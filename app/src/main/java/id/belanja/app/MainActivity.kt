package id.belanja.app

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import id.belanja.app.adapter.ListProductAdapter
import id.belanja.app.model.Products
import id.belanja.app.model.ProductsData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Products> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListProducts()
        setupAddProduct()
    }

    private fun showListProducts() {
        list.addAll(ProductsData.listProduct)
        rvProducts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = ListProductAdapter(list)
            setHasFixedSize(true)
        }
    }

    private fun setupAddProduct() {
        btnAddProduct.setOnClickListener {
            val detailIntent = Intent(this, DetailProductActivity::class.java)
            startActivity(detailIntent)
        }
    }
}
