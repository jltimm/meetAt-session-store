package com.meetAt.api

import com.meetAt.api.controllers.SessionController
import io.ktor.routing.Routing
import io.ktor.routing.get
import io.ktor.routing.route

fun Routing.session(sessionController: SessionController) {
    route("get") {
        get { sessionController.get(this.context) }
    }
}