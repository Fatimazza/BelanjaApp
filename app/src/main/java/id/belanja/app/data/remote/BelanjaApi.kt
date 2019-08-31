package id.belanja.app.data.remote

import id.belanja.app.BuildConfig
import id.belanja.app.data.remote.response.GetProductsResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

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
        fun getProducts(): Call<GetProductsResponse>
    }
}