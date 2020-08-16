package com.surya.android.domain.repository

import com.surya.android.domain.model.Forecast
import com.surya.android.domain.model.Location
import kotlinx.coroutines.flow.Flow

interface WeatherRepository {

  suspend fun findLocation(location: String): List<Location>

  suspend fun fetchLocationDetails(id: Int)

  fun getForecasts(): Flow<List<Forecast>>
}
