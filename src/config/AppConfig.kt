package com.meetAt.config

import com.meetAt.api.controllers.SessionController
import com.meetAt.api.session
import io.ktor.application.Application
import io.ktor.application.install
import io.ktor.routing.Routing
import io.ktor.server.engine.*
import io.ktor.server.netty.Netty
import io.ktor.util.KtorExperimentalAPI
import org.kodein.di.generic.instance

const val SERVER_PORT = 8083

@KtorExperimentalAPI
@EngineAPI
fun setup(): BaseApplicationEngine {
    // TODO: Cache/DB config here
    return server(Netty);
}

@KtorExperimentalAPI
@EngineAPI
fun server(
    engine: ApplicationEngineFactory<BaseApplicationEngine,
            out ApplicationEngine.Configuration>
): BaseApplicationEngine {
    return embeddedServer(
        engine,
        port = SERVER_PORT,
        watchPaths = listOf("mainModule"),
        module = Application::mainModule
    )
}

@KtorExperimentalAPI
fun Application.mainModule() {
    val sessionController by ModulesConfig.kodein.instance<SessionController>()
    install(Routing) {
        session(sessionController)
    }
}