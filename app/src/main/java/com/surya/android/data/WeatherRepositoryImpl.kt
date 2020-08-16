package com.surya.android.data

import com.surya.android.data.db.dao.ForecastDao
import com.surya.android.data.db.mapper.DbMapper
import com.surya.android.data.network.client.WeatherApiClient
import com.surya.android.data.network.mapper.ApiMapper
import com.surya.android.domain.model.Location
import com.surya.android.domain.repository.WeatherRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext

class WeatherRepositoryImpl(
    private val weatherApiClient: WeatherApiClient,
    private val apiMapper: ApiMapper,
    private val backgroundDispatcher: CoroutineDispatcher,
    private val forecastDao: ForecastDao,
    private val dbMapper: DbMapper
) : WeatherRepository {

  override suspend fun findLocation(location: String) = withContext(backgroundDispatcher) {
    try {
      weatherApiClient.findLocation(location)
          .map(apiMapper::mapApiLocationToDomain)
    } catch (error: Throwable) {
      emptyList<Location>()
    }
  }

  override suspend fun fetchLocationDetails(id: Int) = withContext(backgroundDispatcher) {
    val locationDetails = try {
      apiMapper.mapApiLocationDetailsToDomain(
          weatherApiClient.getLocationDetails(id)
      )
    } catch (error: Throwable) {
      null
    }

    if (locationDetails != null) {
      forecastDao.updateLocationDetails(dbMapper.mapDomainLocationDetailsToDb(locationDetails))
      forecastDao.updateForecasts(dbMapper.mapDomainForecastsToDb(locationDetails.forecasts))
    }
  }

  override fun getForecasts() =
      forecastDao
          .getForecasts()
          .map { dbMapper.mapDbForecastsToDomain(it) }
}
