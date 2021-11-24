package com.dfr.dashboardislami.dashboard

import android.content.Intent
import android.icu.text.SimpleDateFormat
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.dashboard.adapter.InspirationListAdapter
import com.dfr.dashboardislami.dashboard.data.InspirationData
import com.dfr.dashboardislami.dashboard.model.InspirationModel
import com.dfr.dashboardislami.databinding.ActivityDashboardBinding
import com.dfr.dashboardislami.menus.doa.MenuDoaActivity
import com.dfr.dashboardislami.menus.dzikir.MenuDzikirActivity
import com.dfr.dashboardislami.menus.jadwalsholat.MenuJadwalSholatActivity
import com.dfr.dashboardislami.menus.videokajian.MenuVideoKajianActivity
import com.dfr.dashboardislami.menus.zakat.MenuDzakatActivity
import java.util.*
import kotlin.collections.ArrayList

class  DashboardActivity : AppCompatActivity() {

    // variable untuk mengikat layout ke class
    private lateinit var binding: ActivityDashboardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // mendaftarkan layout activity_dashboard.xml
        binding = ActivityDashboardBinding.inflate(layoutInflater)
        // variable untuk menampung komponen layout
        val view = binding.root
        // menentukan tampilan dengan data yang ada di variable view (binding)
        setContentView(view)

        initNavMenu()
        initHeader()
        initRecyclerViewInspiration()

    }

    // fungsi untuk berpindah activity
    private fun initNavMenu(){

        // memberi perintah klil pada komponen iv_ivon
        binding.ivIconMenuDoa.setOnClickListener {

            // memulai activity baru dengan intent sebagai pembawa alamat activity yang ingin dituju
            startActivity(Intent(this, MenuDoaActivity::class.java))
        }

        binding.ivIconMenuDzikir.setOnClickListener {
            startActivity(Intent(this, MenuDzikirActivity::class.java))
        }

        binding.ivIconMenuJadwalSholat.setOnClickListener {
            startActivity(Intent(this, MenuJadwalSholatActivity::class.java))
        }

        binding.ivIconMenuVideoKajian.setOnClickListener {
            startActivity(Intent(this, MenuVideoKajianActivity::class.java))
        }

        binding.ivIconMenuZakat.setOnClickListener {
            startActivity(Intent(this, MenuDzakatActivity::class.java))
        }

    }

    //fungsi untuk menampilkan data dari adapter ke komponen recycle vieew
    private fun initRecyclerViewInspiration(){
        
        // variable list untuk menampung data dari objek InspirationData
        val list: ArrayList<InspirationModel> = arrayListOf()
        // memasukan semua data ke dalam variable list
        val listAdapter = InspirationListAdapter(list)
        // membuat obejct InspirationListAdapter
        list.addAll(InspirationData.listData)

        // mengatur ukuran recycle view agar fix
        binding.rvInspiration.setHasFixedSize(true)
        // mengatur tampilan recycleview agar sejajar secara vertical
        binding.rvInspiration.layoutManager = LinearLayoutManager(this)
        // memasang adapter ke recycleview
        binding.rvInspiration.adapter = listAdapter
    }

    private fun initHeader() {
        val timeNow = Calendar.getInstance()
        val timeFormat = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
            SimpleDateFormat("HH")
        } else {
            TODO("VERSION.SDK_INT < N")
        }
        val time = timeFormat.format(timeNow.time)

        when {
            time.toInt() in 0..6 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_night)
            }
            time.toInt() in 7..12 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_morning)
            }   
            time.toInt() in 13..18 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_afternoon)
            }
            time.toInt() in 19..23 -> {
                binding.ivHeader.setBackgroundResource(R.drawable.bg_header_dashboard_night)
            }
        }
    }
}