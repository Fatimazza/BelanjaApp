package id.belanja.app

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.widget.Toast
import id.belanja.app.adapter.ListProductAdapter
import id.belanja.app.model.Products
import id.belanja.app.model.ProductsData
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var list: ArrayList<Products> = arrayListOf()

    private lateinit var listProductAdapter: ListProductAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        showListProducts()
        setupAddProduct()
        setListClickAction()
    }

    private fun showListProducts() {
        list.addAll(ProductsData.listProduct)
        listProductAdapter = ListProductAdapter(list)

        rvProducts.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = listProductAdapter
            setHasFixedSize(true)
        }
    }

    private fun setupAddProduct() {
        btnAddProduct.setOnClickListener {
            val detailIntent = Intent(this, DetailProductActivity::class.java)
            startActivity(detailIntent)
        }
    }

    private fun setListClickAction() {
        listProductAdapter.setOnItemClickCallback(object : ListProductAdapter.OnItemClickCallback {
            override fun onItemClick(data: Products) {
                Toast.makeText(this@MainActivity, "Anda memilih ${data.name}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
