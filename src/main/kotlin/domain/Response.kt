package domain

data class Response(val statusCode: String, val header: Header, val body: String)
