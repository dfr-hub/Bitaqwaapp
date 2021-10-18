package com.dfr.dashboardislami.menus.videokajian

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.databinding.ActivityMenuVideoKajianBinding
import com.dfr.dashboardislami.menus.videokajian.adapter.VideoKajianListAdapter
import com.dfr.dashboardislami.menus.videokajian.model.VideoKajianModel

class MenuVideoKajianActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuVideoKajianBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMenuVideoKajianBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarMenuVideoKajian)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        // men set agar recycle view berjalan dengan baik dan juga ukuran nya tidak terpotong
        val list: ArrayList<VideoKajianModel> = arrayListOf()
        binding.rvVideoKajian.setHasFixedSize(true)
        list.addAll(VideoKajianData.listData)
        binding.rvVideoKajian.layoutManager = LinearLayoutManager(this)
        val listVideoAdapter = VideoKajianListAdapter(list)
        binding.rvVideoKajian.adapter = listVideoAdapter
    }

    //tombol back toolbar
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)

    }
}