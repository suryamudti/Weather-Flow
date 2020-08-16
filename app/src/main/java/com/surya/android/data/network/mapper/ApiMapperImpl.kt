package com.surya.android.data.network.mapper

import com.surya.android.data.network.model.ApiForecast
import com.surya.android.data.network.model.ApiLocation
import com.surya.android.data.network.model.ApiLocationDetails
import com.surya.android.domain.model.Forecast
import com.surya.android.domain.model.Location
import com.surya.android.domain.model.LocationDetails

class ApiMapperImpl : ApiMapper {

  override fun mapApiLocationDetailsToDomain(apiLocationDetails: ApiLocationDetails): LocationDetails {
    return with(apiLocationDetails) {
      LocationDetails(
        forecasts.map { mapApiForecastToDomain(it) },
        time,
        sunrise,
        sunset,
        title,
        id
      )
    }
  }

  override fun mapApiLocationToDomain(apiLocation: ApiLocation) = Location(
    apiLocation.id,
    apiLocation.title
  )

  private fun mapApiForecastToDomain(apiForecast: ApiForecast) = with(apiForecast) {
    Forecast(
      id,
      weatherState,
      windDirection,
      date,
      minTemp,
      maxTemp,
      temp,
      windSpeed,
      airPressure,
      humidity,
      visibility,
      predictability,
      weatherStateAbbreviation
    )
  }
}
