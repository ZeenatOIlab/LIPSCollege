package com.lipscollage.Utility

import android.content.Context

class sharedpreferenceClass(var context: Context) {
    val sharedPref = context.getSharedPreferences("user_enrolled", Context.MODE_PRIVATE)

}