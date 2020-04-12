package com.meetAt.api.controllers

import com.meetAt.AppRule
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test

class SessionControllerTest {
    @Rule
    @JvmField
    val appRule = AppRule()

    @Test
    fun `get session`() {
        val response = appRule.http.get<String>("/get")
        assertEquals(response.status, 200)
        assertEquals(response.body, "Get")
    }

    @Test
    fun `create session`() {
        val response = appRule.http.post<String>("/create")
        assertEquals(response.status, 200)
        assertEquals(response.body, "Create")
    }

    @Test
    fun `destroy session`() {
        val response = appRule.http.delete("/destroy")
        assertEquals(response.status, 200)
        assertEquals(response.body, "Destroy")
    }
}