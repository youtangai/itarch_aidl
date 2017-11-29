package com.lily.yorta.spellservice

import android.content.ComponentName
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG = "yorta.lily.aidl"
    var mIMyAidlInterface: IMyAidlInterface? = null

    private val mConnection = object: ServiceConnection {

        override fun onServiceConnected(className: ComponentName?, service: IBinder?){
            mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service)
        }

        override fun onServiceDisconnected(className: ComponentName?) {
            Log.e(TAG, "Service has unexpectedly disconnected")
            mIMyAidlInterface = null
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}
