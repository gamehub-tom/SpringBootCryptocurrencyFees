package com.playcoin.playwalletservicefees.api.service.impl

import com.playcoin.playwalletservicefees.api.domain.Fee
import com.playcoin.playwalletservicefees.api.service.FeeService
import org.springframework.stereotype.Service

@Service
class FeeServiceImpl: FeeService {

    override fun fees(): Result<Fee> = Result.failure(RuntimeException())

}