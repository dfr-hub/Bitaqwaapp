package com.dfr.dashboardislami.menus.dzikir.data

import com.dfr.dashboardislami.menus.dzikir.model.DzikirModel

object DzikirData {
    private val dzikirDzikir = arrayOf(
        "سُبْحَانَ ٱللَّٰهِ",
        "ٱلْحَمْدُ لِلَّٰهِ",
        "ٱللَّٰهُ أَكْبَر",
        "أَسْتَغْفِرُ اللهَ"
    )

    private val dzikirLatin = arrayOf(
        "Subhanallah",
        "Alhamdulillah",
        "Allahu Akbar",
        "Astaghfirullah"
    )

    private val dzikirTranslate = arrayOf(
        "Mahasuci Allah",
        "Segala Puji Bagi Allah",
        "Allah Maha Besar",
        "Aku Memohon Ampun Kepada Allah"
    )

    val listDzikirData: ArrayList<DzikirModel>
        get() {
            val list = arrayListOf<DzikirModel>()
            for (position in dzikirDzikir.indices) {
                val dzikir = DzikirModel()
                dzikir.dzikir = dzikirDzikir[position]
                dzikir.latin = dzikirLatin[position]
                dzikir.translate = dzikirTranslate[position]
                list.add(dzikir)
            }
            return list
        }

}