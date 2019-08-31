package id.belanja.app.data.model

import java.io.Serializable

data class Product(
    var name: String = "",
    var price: Int = 0,
    var image: String = "",
    var id: Int? = null
) : Serializable
