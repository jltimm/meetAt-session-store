package com.meetAt.config

import com.meetAt.api.controllers.SessionController
import org.kodein.di.Kodein
import org.kodein.di.generic.bind
import org.kodein.di.generic.singleton

object ModulesConfig {
    private val sessionModule = Kodein.Module("SESSION") {
        bind() from singleton { SessionController() }
    }
    internal val kodein = Kodein {
        import(sessionModule)
    }
}