package com.mohammadassad.todostask.storage

import android.content.Context
import android.util.Log
import com.mohammadassad.todostask.AppLifecycleCallBack
import com.mohammadassad.todostask.TodoTaskApplication
import com.mohammadassad.todostask.TodoTaskApplication.Companion.currentActivity

object  LocalStorage {
    fun getStringValue(key:String): String? {

        val activity = currentActivity()

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return ""
        return sharedPref.getString(key,"")
    }

    fun setStringValue(key:String,value:String) {

        val activity = currentActivity()

        val sharedPref = activity?.getPreferences(Context.MODE_PRIVATE) ?: return
        with (sharedPref.edit()) {
            putString(key, value)
            apply()
        }


    }
}