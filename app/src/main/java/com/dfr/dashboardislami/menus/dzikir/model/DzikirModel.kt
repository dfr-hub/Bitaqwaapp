package com.dfr.dashboardislami.menus.dzikir.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DzikirModel(
    var dzikir: String = "",
    var translate: String = "",
    var latin: String = ""
) : Parcelable