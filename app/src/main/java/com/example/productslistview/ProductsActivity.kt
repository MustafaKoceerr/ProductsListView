package com.example.productslistview

import android.os.Bundle
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.productslistview.adapters.ProductListAdapter
import com.example.productslistview.configs.ApiClient
import com.example.productslistview.models.ProductsData
import com.example.productslistview.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ProductsActivity : AppCompatActivity() {

    private lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_products)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        listView = findViewById(R.id.listViewProduct)
        val iDummyService = ApiClient.getClient().create(IDummyService::class.java)

        try {
            iDummyService.getProducts().enqueue(object : Callback<ProductsData> {
                override fun onResponse(p0: Call<ProductsData>, p1: Response<ProductsData>) {
                    // list adapter oluşturup, product'a bağlamalıyım
                    p1.body()?.let {
                        val productAdaptors = ProductListAdapter(this@ProductsActivity, p1.body()!!.products)
                        listView.adapter = productAdaptors
                    }
                }
                override fun onFailure(p0: Call<ProductsData>, p1: Throwable) {
                    println("============OnFAILURE")

                }
            })
        }catch (ex : Exception){
            println("*********CATH'E YAKALANDIN! ${ex.stackTrace}")
        }


    }
}