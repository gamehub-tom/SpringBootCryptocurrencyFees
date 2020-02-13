package com.playcoin.playwalletservicefees.api.service

import com.playcoin.playwalletservicefees.api.domain.Fee

interface FeeService {
    fun fees(): Result<Fee>
}
