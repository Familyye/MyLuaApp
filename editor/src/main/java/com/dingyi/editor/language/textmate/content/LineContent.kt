package com.dingyi.editor.language.textmate.content

import android.util.ArrayMap
import android.util.SparseArray
import io.github.rosemoe.sora.text.TextAnalyzer

/**
 * @author: dingyi
 * @date: 2021/10/10 16:43
 * @description:a diff content util
 **/
class LineContent {

    private val bufferContent = SparseArray<Line>()

    private val diffContent = ArrayMap<Int, Line>()


    fun commitText(text: String, delegate: TextAnalyzer.AnalyzeThread.Delegate): Boolean {
        var allDiffFlag = false
        diffContent.clear()
        if (!delegate.shouldAnalyze()) {
            return false
        }
        text.reader().readLines().forEachIndexed { line, lineText ->

            if (!delegate.shouldAnalyze()) {
                return false
            }
            val bufferLine: Line? = bufferContent.get(line)
            var diffFlag = false

            if (lineText.hashCode() != bufferLine?.content.hashCode()) {
                diffFlag = true
            }

            if (diffFlag) {
                val diffLine = bufferLine ?: Line(line, lineText)
                if (bufferContent.indexOfKey(line) < 0) {
                    bufferContent.put(line, diffLine)
                } else {
                    diffLine.content = lineText
                }
                diffContent[line] = diffLine
                allDiffFlag = true
            }

        }
        return allDiffFlag
    }


    fun getDiffLines(): Map<Int, Line> {
        return diffContent
    }

    fun getLines(): SparseArray<Line> {
        return bufferContent
    }

}