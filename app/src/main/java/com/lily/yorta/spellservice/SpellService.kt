package com.lily.yorta.spellservice

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log

class SpellService : Service() {
    val TAG = "yorta.lily.SPELL"
    override fun onCreate() {
        super.onCreate()
    }

    override fun onBind(intent: Intent): IBinder? { return mBinder }

    private val mBinder = object: IMyAidlInterface.Stub() {
        override fun spellMagic(magic: String?) : String {
            Log.d(TAG, "start service")
            Log.d(TAG, magic)
            if (magic == "ケアル"){
                return "ケアルガ"
            } else if (magic == "ファイア"){
                return "ファイガ"
            } else if (magic == "サンダー"){
                return "サンダガ"
            } else if (magic == "ブリザド"){
                return "ブリザガ"
            } else if (magic == "ウォータ"){
                return "ウォタガ"
            } else if (magic == "ヘイスト"){
                return "ヘイスガ"
            } else if (magic == "スロウ"){
                return "スロウガ"
            } else if (magic == "プロテス"){
                return "プロテガ"
            } else if (magic == "シェル"){
                return "シェルガ"
            } else if (magic == "エアロ"){
                return "エアロガ"
            } else if (magic == "バイオ"){
                return "バイオガ"
            } else if (magic == "クエイク"){
                return "クエイガ"
            } else if (magic == "グラビデ") {
                return "グラビガ"
            }
            return "その魔法は未対応です"
        }
    }
}
