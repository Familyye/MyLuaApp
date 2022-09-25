package com.dingyi.myluaapp.editor.highlight

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import androidx.annotation.UiThread
import androidx.annotation.WorkerThread
import io.github.rosemoe.sora.lang.analysis.AnalyzeManager
import io.github.rosemoe.sora.lang.analysis.StyleReceiver
import io.github.rosemoe.sora.lang.styling.MappedSpans
import io.github.rosemoe.sora.lang.styling.Styles
import io.github.rosemoe.sora.text.CharPosition
import io.github.rosemoe.sora.text.ContentReference
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancel
import kotlinx.coroutines.launch

abstract class HighlightProvider : AnalyzeManager {

    private var ref: ContentReference? = null

    private var receiver: StyleReceiver? = null

    private var data: IncrementalEditContent? = IncrementalEditContent()


    private var handler: Handler? = Handler(Looper.getMainLooper())

    private var superJob: Job? = Job()

    protected var coroutine: CoroutineScope? = CoroutineScope(Dispatchers.IO + (superJob ?: Job()))


    protected val runTaskList = mutableListOf<Job>()

    override fun setReceiver(receiver: StyleReceiver?) {
        this.receiver = receiver
    }


    fun getData(): IncrementalEditContent? {
        return data
    }


    private fun cancelAllTask() {
        cancelRunTask()
        superJob?.cancel()
        coroutine?.cancel()
        superJob = null
        coroutine = null
        handler = null
    }

    private fun cancelRunTask() {
        runTaskList.forEach {
            it.cancel()
        }
        runTaskList.clear()
    }

    @UiThread
    fun updateStyle(styles: Styles) {
        runOnUiThread {
            receiver?.setStyles(this@HighlightProvider, styles)
        }
    }


    override fun insert(start: CharPosition, end: CharPosition, insertedContent: CharSequence) {
        if (start.toIntPair() == end.toIntPair()) {
            return
        }

        data?.apply {
            actionType = IncrementalEditContent.TYPE.INSERT
            startPosition = start
            endPosition = end
            actionContent = insertedContent
        }

        rerun()
    }

    override fun reset(content: ContentReference, extraArguments: Bundle) {
        ref = content
        data = IncrementalEditContent()
        System.gc()
        superJob = Job()
        coroutine = CoroutineScope(Dispatchers.IO + (superJob ?: Job()))
        rerun()
    }


    protected fun runOnUiThread(runnable: Runnable) {
        handler?.post(runnable)
    }


    private fun requireData(): IncrementalEditContent {
        return checkNotNull(data)
    }

    override fun delete(start: CharPosition, end: CharPosition, deletedContent: CharSequence) {

        if (start.toIntPair() == end.toIntPair()) {
            return
        }

        data?.apply {
            actionType = IncrementalEditContent.TYPE.DELETE
            startPosition = start
            endPosition = end
            actionContent = deletedContent
        }

        rerun()

    }

    override fun rerun() {
        cancelRunTask()
        runHighlighting()
    }

     private fun runHighlighting() {
        val delegate = JobDelegate()

        coroutine?.launch(context = Dispatchers.IO) {
            Log.v("HighlightProvider", "Start Highlight in thread:${Thread.currentThread().name}")
            try {
                runHighlighting(ref,requireData().copy(),delegate)
            } catch (e: Exception) {
                e.printStackTrace(System.err)
                Log.e("HighlightProvider", "Unexpected exception is thrown in the thread.",e.fillInStackTrace())
            } finally {
                Log.v("HighlightProvider", "Complete Highlight")
            }
        }?.let { job ->
            runTaskList.add(job)
            delegate.setJob(job)
            job.start()
        }

    }

    protected fun fillContent(textContentTmp: StringBuilder, ref: ContentReference?) {

        ref?.let { ref ->
            // Collect line contents
            textContentTmp.setLength(0)
            textContentTmp.ensureCapacity(ref.length)

            var i = 0
            while (i < ref.lineCount) {
                if (i != 0) {
                    textContentTmp.append('\n')
                }
                ref.appendLineTo(textContentTmp, i)
                i++
            }
        }
    }


    abstract suspend fun runHighlighting(
        ref: ContentReference?,
        data:IncrementalEditContent,
        delegate: Delegate
    )

    override fun destroy() {
        data = null
        receiver = null
        cancelAllTask()
    }

    /**
     * Default highlight method,must run in background thread
     */
    @WorkerThread
    abstract fun highlighting(
        text: CharSequence,
        builder: MappedSpans.Builder,
        styles: Styles,
        delegate: Delegate
    )

    interface Delegate {
        fun isCancelled(): Boolean
    }



}