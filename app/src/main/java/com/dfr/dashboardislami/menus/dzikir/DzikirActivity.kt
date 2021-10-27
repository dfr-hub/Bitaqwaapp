package com.dfr.dashboardislami.menus.dzikir

import VideoKajianData
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.databinding.ActivityDzikirBinding
import com.dfr.dashboardislami.menus.dzikir.adapter.DzikirListAdapter
import com.dfr.dashboardislami.menus.dzikir.data.DzikirData
import com.dfr.dashboardislami.menus.dzikir.model.DzikirModel

class DzikirActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDzikirBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDzikirBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        initRecyclerView()
    }

    private fun initRecyclerView() {
        val list: ArrayList<DzikirModel> = arrayListOf()
        binding.rvDzikir.setHasFixedSize(true)
        list.addAll(DzikirData.listDzikirData)
        binding.rvDzikir.layoutManager = LinearLayoutManager(this)
        val listDzikirAdapter = DzikirListAdapter(list)
        binding.rvDzikir.adapter = listDzikirAdapter

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}