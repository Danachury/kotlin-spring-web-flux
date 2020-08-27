package com.danachury.samples.kotlinspringwebflux.controllers

import com.danachury.samples.kotlinspringwebflux.entities.StockPrice
import org.springframework.http.MediaType.TEXT_EVENT_STREAM_VALUE
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import reactor.core.publisher.Flux
import java.time.Duration
import java.time.Instant
import java.util.*
import java.util.concurrent.ThreadLocalRandom

@RestController
class RestController {

    /**
     * Generate a Flux of StockPrice with an interval of 1 second.
     */
    @GetMapping(value = ["/stocks/{symbol}"], produces = [TEXT_EVENT_STREAM_VALUE])
    fun prices(@PathVariable symbol: String): Flux<StockPrice> {
        return Flux
            .interval(Duration.ofSeconds(1))
            .map { StockPrice(symbol, randomStockPrice(), Date.from(Instant.now())) }
    }

    /**
     * Generate a random price {@sample ThreadLocalRandom}.
     */
    private fun randomStockPrice(): Double {
        return ThreadLocalRandom.current().nextDouble(100.0)
    }
}
