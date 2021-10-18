package com.dfr.dashboardislami.menus.zakat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.databinding.ActivityMenuZakatBinding
import java.text.Format
import java.text.NumberFormat
import java.util.*

class MenuDzakatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuZakatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuZakatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbarMenuZakat)

        initView()
    }

    private fun initView() {
        binding.btnZakat.setOnClickListener {
            val formatAmount = NumberFormat.getNumberInstance(Locale("id", "ID"))
                .format(binding.etAmountZakat.getNumericValue())
            binding.tvHartaAmmount.text = "Rp $formatAmount"

            if (binding.etAmountZakat.getNumericValue()?.toInt()!! >= 85000000) {
                val zakat = binding.etAmountZakat.getNumericValue()!!.toInt() * (2.5 / 100)
                val formatZakat = NumberFormat.getNumberInstance(Locale("id", "ID"))
                    .format(zakat)
                binding.tvAmmountZakat.text = "Rp $formatZakat"
            } else {
                Toast.makeText(
                    this,
                    "Total Harta masih belum mencapai nisab (85gr Emas)",
                    Toast.LENGTH_SHORT
                ).show()
                binding.tvAmmountZakat.text = "Rp 0"
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}