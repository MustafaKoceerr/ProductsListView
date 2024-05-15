package com.example.productslistview.adapters

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.productslistview.R
import com.example.productslistview.models.Product

class ProductListAdapter(val context: Activity, val productList : List<Product>) : BaseAdapter() {
    override fun getCount(): Int {
        return productList.size
    }

    override fun getItem(position: Int): Any {
            return productList.get(position)
    }

    override fun getItemId(position: Int): Long {
        return productList.get(position).id!!.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val rootView = context.layoutInflater.inflate(R.layout.list_row,null,false)
        val dt = productList.get(position)
        val productId = rootView.findViewById<TextView>(R.id.productId)
        val productTitle = rootView.findViewById<TextView>(R.id.productTitle)
        val productPrice = rootView.findViewById<TextView>(R.id.productPrice)
        val productStock = rootView.findViewById<TextView>(R.id.productStock)
        val productBrand = rootView.findViewById<TextView>(R.id.productBrand)
        val productImage = rootView.findViewById<TextView>(R.id.productImage)

        productId.setText("ID: "+dt.id.toString())
        productTitle.setText("TITLE: "+dt.title.toString())
        productPrice.setText("PRICE: "+dt.price.toString())
        productStock.setText("STOCK: "+dt.stock.toString())
        productBrand.setText("BRAND: "+dt.stock.toString())
        productImage.setText("IMAGE: "+dt.images.get(0).toString())

        return rootView
    }
}