package com.tugcearas.learncountriesapp.data.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.tugcearas.learncountriesapp.data.model.CountryModel

@Database(entities = [CountryModel::class], version = 1)
abstract class CountryDb:RoomDatabase() {

    abstract fun countryDao(): CountryDao

    companion object{
        @Volatile
        private var dbInstance : CountryDb? = null

        private val lock = Any()
        operator fun invoke(context: Context) = dbInstance ?: synchronized(lock){
            dbInstance ?: createDatabase(context).also {
                dbInstance = it
            }
        }

        private fun createDatabase(context: Context) = Room.databaseBuilder(
            context.applicationContext,CountryDb::class.java, "countryDatabase"
        ).build()
    }
}