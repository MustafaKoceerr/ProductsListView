package com.example.productslistview.services

import com.example.productslistview.models.ProductsData
import retrofit2.Call
import retrofit2.http.GET

interface IDummyService {

    @GET("products")
    fun getProducts() : Call<ProductsData>
}