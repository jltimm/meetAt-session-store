package com.meetAt.api.controllers

import com.meetAt.AppRule
import junit.framework.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

class SessionControllerTest {
    @Rule
    @JvmField
    val appRule = AppRule()

    @Test
    fun `get session test`() {
        val response = appRule.http.get<String>("/get")
        assertEquals(response.status, 200)
    }
}