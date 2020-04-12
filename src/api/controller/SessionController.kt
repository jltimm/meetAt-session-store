package com.meetAt.api.controller

import io.ktor.application.ApplicationCall
import io.ktor.response.respondText

class SessionController {
    suspend fun get(ctx: ApplicationCall) {
        val id = ctx.parameters["id"]
        // TODO
        ctx.respondText("Get")
    }
    suspend fun create(ctx: ApplicationCall) {
        val id = ctx.parameters["id"]
        // TODO
        ctx.respondText("Create")
    }
    suspend fun destroy(ctx: ApplicationCall) {
        val id = ctx.parameters["id"]
        // TODO
        ctx.respondText("Destroy")
    }
}