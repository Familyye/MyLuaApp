package com.dingyi.myluaapp.ui

import android.annotation.SuppressLint
import android.app.StatusBarManager
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import com.dingyi.myluaapp.R
import com.dingyi.myluaapp.common.ktx.checkNotNull

import com.dingyi.myluaapp.databinding.ActivityGeneralBinding

/**
 * @author: dingyi
 * @date: 2021/8/4 21:31
 * @description:
 **/
class GeneralActivity : AppCompatActivity() {


    private val binding by lazy {
        ActivityGeneralBinding.inflate(layoutInflater)
    }

    @SuppressLint("WrongConstant")
    override fun onCreate(savedInstanceState: Bundle?) {
        delegate.localNightMode= AppCompatDelegate.MODE_NIGHT_YES
        super.onCreate(savedInstanceState)

        setContentView(binding.root)

        setSupportActionBar(binding.toolbarInclude.toolbar)

        intent?.let {
            val bundle = it.getBundleExtra("arg")
            val type = it.getStringExtra("type").checkNotNull()

            val classStatic = Class.forName(type)

            (classStatic.newInstance() as Fragment).apply {
                arguments=bundle
            }

        }?.let {
            supportFragmentManager.beginTransaction().add(R.id.container, it)
                .commit()
        }
    }




    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        finish()
        return super.onOptionsItemSelected(item)
    }

}