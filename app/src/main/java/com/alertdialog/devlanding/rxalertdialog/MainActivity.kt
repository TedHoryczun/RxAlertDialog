package com.alertdialog.devlanding.rxalertdialog

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.util.Log
import com.alertdialog.devlanding.rxalertdialoglib.AlertButton
import com.alertdialog.devlanding.rxalertdialoglib.RxAlertDialog

class MainActivity : AppCompatActivity(), MainContract.view {

    val presenter: MainContract.presenter = MainPresenter(this)
    val TAG = "MainActivity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val builder = AlertDialog.Builder(this)
            .setMessage("message")
            .setTitle("title")
        val rxAlert = RxAlertDialog(builder)
        presenter.showAlertStuff(rxAlert)
    }

    override fun negativeButtonClick(message: String) {
        Log.i(TAG, message)
    }

    override fun positiveButtonClick(message: String) {
        Log.i(TAG, message)
    }
}
