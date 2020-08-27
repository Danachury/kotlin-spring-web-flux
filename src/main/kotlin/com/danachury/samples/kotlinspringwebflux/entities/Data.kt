package com.danachury.samples.kotlinspringwebflux.entities

import java.util.*

data class StockPrice(val symbol: String, val price: Double, val time: Date)
