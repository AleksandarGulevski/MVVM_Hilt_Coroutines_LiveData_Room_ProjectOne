package com.denofdevelopers.mvvm_hilt_coroutines_livedata_room_projectone.utils

import androidx.room.TypeConverter
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*

class ListConverter {

    val gson = Gson()

    @TypeConverter
    fun stringToList(value: String): List<String> {
      if(value == null){
          return Collections.emptyList()
      }

        val listType =
            object : TypeToken<List<String>>() {}.type

        return gson.fromJson(value, listType)
    }

    @TypeConverter
    fun listToString(list: List<String>): String? {
        return gson.toJson(list);
    }
}