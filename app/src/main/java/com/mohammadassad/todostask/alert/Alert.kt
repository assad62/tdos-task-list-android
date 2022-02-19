package com.mohammadassad.todostask.alert

import android.content.Context
import com.marsad.stylishdialogs.StylishAlertDialog

object Alert {

    fun showAlert(title:String, message:String, alertType:Int,context: Context?){
        StylishAlertDialog(context, alertType)
            .setTitleText(title)
            .setContentText(message)
            .show()
    }
}