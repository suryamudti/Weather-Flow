package com.surya.android.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.surya.android.data.db.dao.ForecastDao
import com.surya.android.data.db.entities.DbForecast
import com.surya.android.data.db.entities.DbLocationDetails

private const val DB_NAME = "forecast_database"

@Database(entities = [(DbLocationDetails::class), (DbForecast::class)], version = 1)
abstract class ForecastDatabase : RoomDatabase() {

  abstract fun forecastDao(): ForecastDao

  companion object {
    fun create(context: Context): ForecastDatabase {

      return Room.databaseBuilder(
          context,
          ForecastDatabase::class.java,
          DB_NAME
      ).build()
    }
  }
}
