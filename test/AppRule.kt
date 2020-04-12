package com.meetAt

import com.meetAt.config.SERVER_PORT
import com.meetAt.config.setup
import com.meetAt.util.HttpUtil
import io.ktor.server.engine.ConnectorType
import io.ktor.server.engine.EngineAPI
import io.ktor.util.KtorExperimentalAPI
import org.junit.rules.ExternalResource
import java.util.concurrent.TimeUnit

class AppRule : ExternalResource() {
    @KtorExperimentalAPI
    @EngineAPI
    private val app = setup()
    lateinit var http: HttpUtil

    @KtorExperimentalAPI
    @EngineAPI
    val port = app.environment.connectors.find { it.type == ConnectorType.HTTP }?.port ?: SERVER_PORT

    @KtorExperimentalAPI
    @EngineAPI
    override fun before() {
        app.start()
        TimeUnit.MILLISECONDS.sleep(500)
        http = HttpUtil(port)
    }

    @KtorExperimentalAPI
    @EngineAPI
    override fun after() {
        app.stop(500, 500)
    }

}
