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
                val manageDetailIntent = Intent(this@MainActivity, DetailProductActivity::class.java)
                    .apply {
                        putExtra(DetailProductActivity.EXTRA_NAME, data.name)
                        putExtra(DetailProductActivity.EXTRA_PRICE, data.price.toString())
                        putExtra(DetailProductActivity.EXTRA_IMAGE_URL, data.image)
                    }
                startActivity(manageDetailIntent)
            }
        })
    }
}
