package com.example.event_master.data.local

import androidx.room.TypeConverter
import com.example.event_master.ui.model.Evento
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.Date

class Converters {
    @TypeConverter
    fun fromTimestamp(value: Long?): Date? {
        return value?.let { Date(it) }
    }

    @TypeConverter
    fun dateToTimestamp(date: Date?): Long? {
        return date?.time
    }

    @TypeConverter
    fun fromListaEventos(value: MutableList<Evento>): String{
        return Gson().toJson(value)
    }

    @TypeConverter
    fun jsonToListaEventos(value: String): MutableList<Evento>{
        val listType = object : TypeToken<MutableList<Evento>>() {}.type
        return Gson().fromJson(value,listType)
    }
}