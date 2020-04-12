package com.meetAt.api

import com.meetAt.api.controller.SessionController
import io.ktor.routing.*

fun Routing.session(sessionController: SessionController) {
    route("get") {
        get { sessionController.get(this.context) }
    }
    route("create") {
        post { sessionController.create(this.context) }
    }
    route("destroy") {
        delete { sessionController.destroy(this.context) }
    }
}