package com.surya.android.data.db.mapper

import com.surya.android.data.db.entities.DbForecast
import com.surya.android.data.db.entities.DbLocationDetails
import com.surya.android.domain.model.Forecast
import com.surya.android.domain.model.LocationDetails

class DbMapperImpl : DbMapper {
  override fun mapDomainLocationDetailsToDb(locationDetails: LocationDetails): DbLocationDetails {
    return with(locationDetails) {
      DbLocationDetails(
        time, sunrise, sunset, title, id
      )
    }
  }

  override fun mapDbLocationDetailsToDomain(locationDetails: DbLocationDetails): LocationDetails {
    return with(locationDetails) {
      LocationDetails(emptyList(), time, sunrise, sunset, title, id)
    }
  }

  override fun mapDomainForecastsToDb(forecasts: List<Forecast>): List<DbForecast> {
    return forecasts.map {
      with(it) {
        DbForecast(
          id,
          state,
          windDirection,
          date,
          minTemp,
          maxTemp,
          temp,
          windSpeed,
          pressure,
          humidity,
          visibility,
          predictability,
          weatherStateAbbreviation
        )
      }
    }
  }

  override fun mapDbForecastsToDomain(forecasts: List<DbForecast>): List<Forecast> {
    return forecasts.map {
      with(it) {
        Forecast(
          id,
          state,
          windDirection,
          date,
          minTemp,
          maxTemp,
          temp,
          windSpeed,
          pressure,
          humidity,
          visibility,
          predictability,
          weatherStateAbbreviation
        )
      }
    }
  }
}
