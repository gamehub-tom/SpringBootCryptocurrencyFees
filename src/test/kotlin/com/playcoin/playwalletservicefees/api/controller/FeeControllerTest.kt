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
    fun bitcoinFees() {
        val mvcResult = mockMvc
            .perform(get("/BTC/fees").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andReturn()

        val type = object : TypeToken<ApiResponse<Fee>>() {}.type
        val content = mvcResult.response.contentAsString
        val apiResult = gson.fromJson<ApiResponse<Fee>>(content, type)

        assertThat(apiResult.data).isNotNull
        assertThat(apiResult.status).isEqualTo(ResponseStatus.OK.code)
    }

    @Test
    fun ethereumFees() {
        val mvcResult = mockMvc
            .perform(get("/ETH/fees").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andReturn()

        val type = object : TypeToken<ApiResponse<Fee>>() {}.type
        val content = mvcResult.response.contentAsString
        val apiResult = gson.fromJson<ApiResponse<Fee>>(content, type)

        assertThat(apiResult.data).isNull()
        assertThat(apiResult.status).isEqualTo(ResponseStatus.ERROR.code)
    }

    @Test
    fun playcoinFees() {
        val mvcResult = mockMvc
            .perform(get("/PLY/fees").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andReturn()

        val type = object : TypeToken<ApiResponse<Fee>>() {}.type
        val content = mvcResult.response.contentAsString
        val apiResult = gson.fromJson<ApiResponse<Fee>>(content, type)

        assertThat(apiResult.data).isNull()
        assertThat(apiResult.status).isEqualTo(ResponseStatus.ERROR.code)
    }

    @Test
    fun playcoinxFees() {
        val mvcResult = mockMvc
            .perform(get("/PLX/fees").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andReturn()

        val type = object : TypeToken<ApiResponse<Fee>>() {}.type
        val content = mvcResult.response.contentAsString
        val apiResult = gson.fromJson<ApiResponse<Fee>>(content, type)

        assertThat(apiResult.data).isNull()
        assertThat(apiResult.status).isEqualTo(ResponseStatus.ERROR.code)
    }

    @Test
    fun dummyFees() {
        val mvcResult = mockMvc
            .perform(get("/DMY/fees").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk)
            .andReturn()

        val type = object : TypeToken<ApiResponse<Fee>>() {}.type
        val content = mvcResult.response.contentAsString
        val apiResult = gson.fromJson<ApiResponse<Fee>>(content, type)

        assertThat(apiResult.data).isNull()
        assertThat(apiResult.status).isEqualTo(ResponseStatus.ERROR.code)
    }

    @Test
    fun anythingFees() {
        mockMvc
            .perform(get("/XRP/fees").accept(MediaType.APPLICATION_JSON))
            .andExpect(status().is4xxClientError)
    }
}