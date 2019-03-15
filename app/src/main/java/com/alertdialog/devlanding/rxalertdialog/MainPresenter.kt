package com.alertdialog.devlanding.rxalertdialog

import com.alertdialog.devlanding.rxalertdialoglib.AlertButton
import com.alertdialog.devlanding.rxalertdialoglib.RxAlertDialog


class MainPresenter(val view: MainContract.view) : MainContract.presenter {

    override
    fun showAlertStuff(rxAlert: RxAlertDialog) {
        rxAlert.show("yes", "no")
            .doOnNext { event ->
                when (event) {
                    AlertButton.POSITIVE -> {
                        view.positiveButtonClick("positive button click")
                    }
                    AlertButton.NEGATIVE -> {
                        view.negativeButtonClick("negative button click")
                    }
                }
            }.subscribe()
    }
}