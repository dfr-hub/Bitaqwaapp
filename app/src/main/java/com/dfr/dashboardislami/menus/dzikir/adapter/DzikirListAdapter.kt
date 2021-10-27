package com.dfr.dashboardislami.menus.dzikir.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.appcompat.view.menu.MenuView
import androidx.recyclerview.widget.RecyclerView
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.menus.dzikir.DzikirActivity
import com.dfr.dashboardislami.menus.dzikir.model.DzikirModel
import com.dfr.dashboardislami.menus.videokajian.adapter.VideoKajianListAdapter

class DzikirListAdapter(private val dzikirActivity: ArrayList<DzikirModel>,var count: Int = 0) :
    RecyclerView.Adapter<DzikirListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var btnMinusButton: ImageButton = itemView.findViewById(R.id.btn_button_minus)
        var btnPlusButton: ImageButton = itemView.findViewById(R.id.btn_button_plus)
        var tvDzikir: TextView = itemView.findViewById(R.id.tv_arab_dzikir)
        var tvArti: TextView = itemView.findViewById(R.id.tv_arti_dzikir)
        var tvLatin: TextView = itemView.findViewById(R.id.tv_latin_dzikir)
        var tvAngka: TextView = itemView.findViewById(R.id.angka_dzikir)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DzikirListAdapter.ListViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_dzikir, parent, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: DzikirListAdapter.ListViewHolder, position: Int) {
        val dzikir = dzikirActivity[position]

        holder.tvArti.text = dzikir.translate
        holder.tvDzikir.text = dzikir.dzikir
        holder.tvLatin.text = dzikir.latin

        holder.btnPlusButton.setOnClickListener {
            count += 1
            holder.tvAngka.text = count.toString()
        }

        holder.btnMinusButton.setOnClickListener{
            count -= 1
            holder.tvAngka.text = count.toString()
        }

    }
    override fun getItemCount(): Int {
        return dzikirActivity.size
    }

}