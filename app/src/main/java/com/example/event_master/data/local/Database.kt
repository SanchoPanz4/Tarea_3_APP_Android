package com.example.event_master.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.event_master.data.local.dao.ActividadDao
import com.example.event_master.data.local.dao.EventoDao
import com.example.event_master.data.local.entity.ActividadEntity
import com.example.event_master.data.local.entity.EventoEntity


/*
mas tarde quiero probar este codigo, en teoria deberia permitir evitar tener que cambiar la version en la DB porque estaria borrandola y recreandola pero como ahora no quiero probar eso quedara comentado como muesrta
context.getApplicationContext().deleteDatabase(SystemStrings.ROOM_DATABASE_NAME); //<<<< ADDED before building Database.
//Your existing code follows
Room.databaseBuilder(context.getApplicationContext(), AppDatabase.class, SystemStrings.ROOM_DATABASE_NAME)
                // allow queries on the main thread.
                // Don't do this on a real app!
                .allowMainThreadQueries()
                .fallbackToDestructiveMigration()
                .build();
*/


@Database(entities = [EventoEntity::class, ActividadEntity::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun eventoDao(): EventoDao
    abstract fun actividadDao(): ActividadDao
    companion object {
        @Volatile
        private var Instance: AppDatabase? = null
        fun getDatabase(context: Context): AppDatabase {
// if the Instance is not null, return it, otherwise create a new database instance.
            return Instance ?: synchronized(this) {
                Room.databaseBuilder(context, AppDatabase::class.java, "App_database")
                    .build().also { Instance = it }
            }
        }
    }
}