package com.dfr.dashboardislami.menus.doa.adapter

import android.content.Intent
import android.telecom.Call
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ListView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.menus.doa.DetailDoaActivity
import com.dfr.dashboardislami.menus.doa.model.DoaModel

class  DoaListAdapter(
    private val listDoa: ArrayList<DoaModel>,
    private val title: String,
    private val logo: Int
) : RecyclerView.Adapter<DoaListAdapter.ListViewHolder>() {
    inner class ListViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        var ivLogoDoa : ImageView = ItemView.findViewById(R.id.iv_logo_doa)
        var tvTitleDoa: TextView = ItemView.findViewById(R.id.tv_title_doa)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_doa, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val doa = listDoa[position]

        holder.tvTitleDoa.text = doa.title

        Glide.with(holder.itemView.context)
            .load(logo)
            .load(holder.ivLogoDoa)

        // aksi item di klik
        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailDoaActivity::class.java)
            intent.putExtra(DetailDoaActivity.EXTRA_DOA, doa)
            it.context.startActivity(intent)
        }

    }

    override fun getItemCount(): Int {
        return listDoa.size
    }
}
