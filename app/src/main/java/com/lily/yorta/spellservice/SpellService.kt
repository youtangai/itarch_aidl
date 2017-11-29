package com.lily.yorta.spellservice

import android.app.Service
import android.content.Intent
import android.os.IBinder

class SpellService : Service() {

    private val mBinder = object: IMyAidlInterface.Stub() {
        override fun spellMagic(magic: String?) {
            print(magic)
        }
    }

    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder? { return mBinder }
}
