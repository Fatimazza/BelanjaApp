package id.belanja.app

import android.app.Application
import id.belanja.app.data.remote.BelanjaApi
import id.belanja.app.data.repository.ProductRepository

/**
 * @author Yuana andhikayuana@gmail.com
 * @since Aug, Sat 31 2019 11:13
 **/
class App : Application() {

    val repository: ProductRepository by lazy {
        ProductRepository(BelanjaApi.create())
    }

    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }

    companion object {
        @Volatile
        private var INSTANCE: App? = null

        val instance: App
            get() {
                if (INSTANCE == null) {
                    synchronized(App::class.java) {
                        if (INSTANCE == null) {
                            throw RuntimeException("Something went wrong!")
                        }
                    }
                }
                return INSTANCE!!
            }
    }
}