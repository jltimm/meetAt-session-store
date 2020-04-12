package com.meetAt.api.controllers

import io.ktor.application.ApplicationCall
import io.ktor.response.respondText

class SessionController {
    suspend fun get(ctx: ApplicationCall) {
        ctx.respondText("test")
    }
}