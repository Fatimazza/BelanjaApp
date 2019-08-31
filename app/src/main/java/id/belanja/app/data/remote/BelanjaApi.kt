package id.belanja.app.data.remote

import com.google.gson.JsonObject
import id.belanja.app.BuildConfig
import id.belanja.app.data.model.Product
import id.belanja.app.data.remote.response.ProductResponse
import id.belanja.app.data.remote.response.ProductsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.*

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Aug, Sat 31 2019 11:53
 **/
object BelanjaApi {

    fun create(): Api {
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(BuildConfig.BASE_URL)
            .build()
        return retrofit.create(Api::class.java)
    }

    interface Api {
        @GET("/products")
        fun getProducts(): Call<ProductsResponse>

        @POST("/products")
        fun saveProduct(@Body product: Product): Call<ProductResponse>

        @DELETE("/products/{id}")
        fun deleteProduct(@Path("id") id: Int): Call<JsonObject>

        @PUT("/products/{id}")
        fun updateProuct(@Path("id") id: Int, @Body product: Product): Call<ProductResponse>
    }
}