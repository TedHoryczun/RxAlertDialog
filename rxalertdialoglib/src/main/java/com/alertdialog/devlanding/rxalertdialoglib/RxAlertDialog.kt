package com.alertdialog.devlanding.rxalertdialoglib

import android.content.Context
import android.support.v7.app.AlertDialog
import io.reactivex.Observable


class RxAlertDialog(private val builder: AlertDialog.Builder) {

    fun setStyle(
        message: CharSequence? = null,
        title: CharSequence? = null
    ) {
        message?.let { builder.setMessage(message) }
        title?.let { builder.setTitle(title) }
    }


    fun show(
        positiveButton: CharSequence? = null,
        negativeButton: CharSequence? = null
    ): Observable<AlertButton> {

        return Observable.create<AlertButton> { ob ->

            positiveButton.let {
                builder.setPositiveButton(
                    positiveButton
                ) { _, _ -> ob.onNext(AlertButton.POSITIVE) }
            }
            negativeButton.let {
                builder.setNegativeButton(
                    negativeButton
                ) { _, _ -> ob.onNext(AlertButton.NEGATIVE) }
            }
            val dialog = builder.show()
            ob.setCancellable { dialog.dismiss() }

        }
    }

}
