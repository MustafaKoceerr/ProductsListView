package com.example.productslistview

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.productslistview.configs.ApiClient
import com.example.productslistview.models.ProductsData
import com.example.productslistview.services.IDummyService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

private lateinit var myButton : Button
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        myButton = findViewById(R.id.button)
        val iDummyService = ApiClient.getClient().create(IDummyService::class.java)


        myButton.setOnClickListener {
            val intent = Intent(applicationContext,ProductsActivity::class.java)
            startActivity(intent)


        }



    }
}