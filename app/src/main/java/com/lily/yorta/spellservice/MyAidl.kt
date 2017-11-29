package com.lily.yorta.spellservice

/**
 * Created by nagaiyouta on 2017/11/29.
 */
class MyAidl : IMyAidlInterface.Stub() {
    override fun spellMagic(magic: String?) {
        print("start basicTypes")
        print(magic)
    }
}