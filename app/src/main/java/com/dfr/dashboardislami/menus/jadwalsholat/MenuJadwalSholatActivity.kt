package com.dfr.dashboardislami.menus.jadwalsholat

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Toast
import com.dfr.dashboardislami.R
import com.dfr.dashboardislami.databinding.ActivityMenuJadwalSholatBinding
import java.text.SimpleDateFormat
import java.util.*
import com.loopj.android.http.*
import cz.msebera.android.httpclient.Header
import org.json.JSONObject

class MenuJadwalSholatActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMenuJadwalSholatBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuJadwalSholatBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        setSupportActionBar(binding.toolbarMenuJadwalSholat)

        initView()
    }

    private fun initView() {
        val c: Date = Calendar.getInstance().time
        val df = SimpleDateFormat("E, dd MMM", Locale.getDefault())
        val formattedDate: String = df.format(c)

        binding.tvDatePray.text = formattedDate

        initGetDataJadwalSholat(c, "bogor")
    }

    private fun initGetDataJadwalSholat(date: Date, city: String) {
        val df = SimpleDateFormat("yyyy-MM-DD", Locale.getDefault())
        val formattedDate: String = df.format(date)

        val client = AsyncHttpClient()
        val url = "https://api.pray.zone/v2/times/day.json?city=$city&date=2021-10-12"
        client.get(url, object : AsyncHttpResponseHandler() {
            override fun onSuccess(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val response = responseBody?.let { String(it) }

                try {
                    val responseObject = JSONObject(response)
                    val dataResult = responseObject.getJSONObject("results")
                    val dataDateTimeArray = dataResult.getJSONArray("datetime")
                    val dataObjectDateTime = dataDateTimeArray.getJSONObject(0)
                    val dataObjectTime = dataObjectDateTime.getJSONObject("times")

                    binding.tvPrayTimeImsak.text = dataObjectTime.getString("Imsak")
                    binding.tvPrayTimeSunrise.text = dataObjectTime.getString("Sunrise")
                    binding.tvPrayTimeSubuh.text = dataObjectTime.getString("Fajr")
                    binding.tvPrayTimeDzuhur.text = dataObjectTime.getString("Dhuhr")
                    binding.tvPrayTimeAshar.text = dataObjectTime.getString("Asr")
                    binding.tvPrayTimeMaghrib.text = dataObjectTime.getString("Maghrib")
                    binding.tvPrayTimeIsya.text = dataObjectTime.getString("Isha")

                    val dataObjectionLocation = dataResult.getJSONObject("location")
                    binding.tvLocation.text = dataObjectionLocation.getString("city")
                } catch (e: Exception) {
                    Toast.makeText(this@MenuJadwalSholatActivity, e.message, Toast.LENGTH_SHORT)
                        .show()
                    e.printStackTrace()
                }
            }

            override fun onFailure(
                statusCode: Int,
                headers: Array<out Header>?,
                responseBody: ByteArray?,
                error: Throwable?
            ) {
                binding.pbJadwalSholat.visibility = View.INVISIBLE
                val errorMessage = when (statusCode) {
                    401 -> "$statusCode : Bad Request"
                    403 -> "$statusCode : Forbidden"
                    404 -> "$statusCode : Not Found"
                    else -> "$statusCode : ${error?.message}"
                }
                Toast.makeText(this@MenuJadwalSholatActivity, errorMessage, Toast.LENGTH_SHORT)
                    .show()
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> finish()
        }

        return super.onOptionsItemSelected(item)
    }
}
