package com.lily.yorta.spellservice

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    val TAG = "yorta.lily.MAIN"
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

        val button = findViewById(R.id.button) as Button
        val plainText = findViewById(R.id.editText) as EditText

        val intent = Intent(this@MainActivity, SpellService::class.java)
        bindService(intent, mConnection, Context.BIND_AUTO_CREATE)



        button.setOnClickListener{
            val str = plainText.text.toString()
            val spell = mIMyAidlInterface?.spellMagic(str)
            val disp = str + " convert to " + spell
            Log.d(TAG, spell)
            Toast.makeText(this, disp, Toast.LENGTH_SHORT).show()
        }

    }

    override fun onPause() {
        super.onPause()
        unbindService(mConnection)
    }
}
