package com.lily.yorta.spellservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log

class MainActivity : AppCompatActivity() {
    val TAG = "yorta.lily.MAIN"
    var mIMyAidlInterface: IMyAidlInterface? = null

    private val mConnection = object: ServiceConnection {

        override fun onServiceConnected(className: ComponentName?, service: IBinder?){
            mIMyAidlInterface = IMyAidlInterface.Stub.asInterface(service)
            val spell = mIMyAidlInterface?.spellMagic("hogehoge")
            Log.d(TAG, spell)
        }

        override fun onServiceDisconnected(className: ComponentName?) {
            Log.e(TAG, "Service has unexpectedly disconnected")
            mIMyAidlInterface = null
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val intent = Intent(this@MainActivity, SpellService::class.java)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)
    }

    override fun onPause() {
        super.onPause()
        unbindService(mConnection)
    }
}
