package com.larkes.pokedexapp.android

import PlatformSDK
import android.app.Application
import platform.PlatformConfiguration

class PokedexApp:Application() {

    override fun onCreate() {
        super.onCreate()
        PlatformSDK.init(PlatformConfiguration(this))
    }

}