package com.example.productslistview.models

import com.google.gson.annotations.SerializedName

data class ProductsData(
    val products: List<Product>,
    val total: Int,
    val skip: Int,
    val limit: Int

)
