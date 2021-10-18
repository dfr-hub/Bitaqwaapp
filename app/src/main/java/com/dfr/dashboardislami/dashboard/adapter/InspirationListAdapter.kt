package com.dfr.dashboardislami.dashboard.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.dashboard.model.InspirationModel
import java.util.ArrayList

class InspirationListAdapter(private val listInspiration: ArrayList<InspirationModel>)
    : RecyclerView.Adapter<InspirationListAdapter.ListViewHolder>() {

    // class untuk mendaftarkan komponen pada layout dan memasukanya ke dalam variable
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        // variable imgPhoto berisi komponen ImageView pada layout item_row_inspiration.xml
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)

    }

    // mendaftarkan tampilan / layout menampilalkan data
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        // variable berisi layout yang akan menampilkan data (item_row_inspiration)
        val view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_row_inspiration, parent, false)
        return ListViewHolder(view)
    }

    // memasang data ke komponen layout
    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {

        // memasukan data berdasrkan posisinya ke dalam variable inspiration
        val inspiration = listInspiration[position]

        Glide.with(holder.itemView.context)
                .load(inspiration.InspirationImage)
                .into(holder.imgPhoto)
    }

    // memasukan jumlah data yang ingin ditampilkan
    override fun getItemCount(): Int {
        return listInspiration.size
    }
}