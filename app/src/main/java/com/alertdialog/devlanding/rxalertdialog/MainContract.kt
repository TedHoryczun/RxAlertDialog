package com.alertdialog.devlanding.rxalertdialog

import com.alertdialog.devlanding.rxalertdialoglib.RxAlertDialog


interface MainContract{
    interface view{
        fun negativeButtonClick(message: String)
        fun positiveButtonClick(message: String)
    }
    interface presenter{

        fun showAlertStuff(rxAlert: RxAlertDialog)
    }
}