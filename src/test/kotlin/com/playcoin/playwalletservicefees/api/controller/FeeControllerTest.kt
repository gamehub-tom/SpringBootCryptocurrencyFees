package com.playcoin.playwalletservicefees.api.controller

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.playcoin.playwalletservicefees.api.domain.ApiResponse
import com.playcoin.playwalletservicefees.api.domain.Fee
import com.playcoin.playwalletservicefees.enums.ResponseStatus
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
class FeeControllerTest {

    @Autowired lateinit var mockMvc: MockMvc

    val gson: Gson = GsonBuilder().create()

    @Test
    fun fees() {

        val mvcResult = mockMvc
            .perform(get("/fees").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andReturn()

        val type = object : TypeToken<ApiResponse<Fee>>() {}.type
        val content = mvcResult.response.contentAsString
        val apiResult = gson.fromJson<ApiResponse<Fee>>(content, type)

        assertThat(apiResult.data).isNotNull
        assertThat(apiResult.status).isEqualTo(ResponseStatus.OK.code)
    }
}