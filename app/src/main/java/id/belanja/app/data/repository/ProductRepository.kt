package id.belanja.app.data.repository

import id.belanja.app.data.model.Product
import id.belanja.app.data.remote.BelanjaApi
import id.belanja.app.data.remote.response.GetProductsResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Aug, Sat 31 2019 11:12
 **/
class ProductRepository(val api: BelanjaApi.Api) {

    fun getProducts(onSuccess: (List<Product>) -> Unit, onError: (Throwable) -> Unit) {
        api.getProducts().enqueue(object : Callback<GetProductsResponse> {
            override fun onFailure(call: Call<GetProductsResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<GetProductsResponse>,
                response: Response<GetProductsResponse>
            ) {
                if (response.isSuccessful) {
                    val result = response.body()?.data?.map {
                        with(it) {
                            Product(name, price, image, id)
                        }
                    }
                    result?.let {
                        onSuccess(it)
                    }

                } else {
                    onError(Throwable("Something went wrong!"))
                }
            }
        })
    }

    fun save(isNew: Boolean, onSuccess: (Product) -> Unit, onError: (Throwable) -> Unit) {

    }

    fun delete(onSuccess: Unit, onError: (Throwable) -> Unit) {

    }


}