package com.dfr.dashboardislami.menus.videokajian.adapter

import android.content.Intent
import android.graphics.BlurMaskFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions.bitmapTransform
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.menus.doa.adapter.DoaListAdapter
import com.dfr.dashboardislami.menus.videokajian.DetailVideoKajianActivity
import com.dfr.dashboardislami.menus.videokajian.model.VideoKajianModel
import com.dfr.dashboardislami.menus.videokajian.adapter.VideoKajianListAdapter.ListViewHolder as ListViewHolder1

class VideoKajianListAdapter(private val listVideoKajian: ArrayList<VideoKajianModel>) :
RecyclerView.Adapter<VideoKajianListAdapter.ListViewHolder>() {

    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var imgPhoto: ImageView = itemView.findViewById(R.id.iv_item_photo)
        var tvChannel: TextView = itemView.findViewById(R.id.tv_channel)
        var tvSpeaker: TextView = itemView.findViewById(R.id.tv_speaker)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ListViewHolder1 {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_row_video_kajian, parent, false)
        return ListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listVideoKajian.size
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val video = listVideoKajian[position]

        holder.tvChannel.text = video.channel
        holder.tvSpeaker.text = video.speaker
        holder.tvTitle.text = video.title

        Glide.with(holder.itemView.context)
            .load(video.thumbnail)
            .into(holder.imgPhoto)

        holder.itemView.setOnClickListener{
            val intent = Intent(it.context, DetailVideoKajianActivity::class.java)
            intent.putExtra(DetailVideoKajianActivity.EXTRA_VIDEO_KAJIAN, video)
                        it.context.startActivity(intent)
        }
    }
}
