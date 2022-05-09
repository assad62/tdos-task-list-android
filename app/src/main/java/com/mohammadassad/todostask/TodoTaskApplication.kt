package com.mohammadassad.todostask
import android.app.Activity
import android.app.Application
import android.content.Context

class TodoTaskApplication: Application() {
    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)

    }

    init {
        instance = this
    }

    val appActivityLifecycleCallbacks = AppLifecycleCallBack()

    override fun onCreate() {
        super.onCreate()

        registerActivityLifecycleCallbacks(appActivityLifecycleCallbacks)
    }

    companion object {
        private var instance: TodoTaskApplication? = null

        fun currentActivity(): Activity? {

            return instance!!.appActivityLifecycleCallbacks.currentActivity
        }
    }

}

