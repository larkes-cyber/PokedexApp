package ktor

import io.ktor.client.HttpClient
import io.ktor.client.HttpClientConfig

internal expect class HttpClientFactory constructor(){
    fun createHttpClient(config: HttpClientConfig<*>.()-> Unit): HttpClient
}