package com.cleanarchitectureexample.domain.model

data class Count(val count:Int)

fun Int.toCount(): Count {
    return Count(this)
}
