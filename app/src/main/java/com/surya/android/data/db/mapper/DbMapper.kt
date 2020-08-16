package com.surya.android.data.db.mapper

import com.surya.android.data.db.entities.DbForecast
import com.surya.android.data.db.entities.DbLocationDetails
import com.surya.android.domain.model.Forecast
import com.surya.android.domain.model.LocationDetails

interface DbMapper {

  fun mapDomainLocationDetailsToDb(locationDetails: LocationDetails): DbLocationDetails

  fun mapDbLocationDetailsToDomain(locationDetails: DbLocationDetails): LocationDetails

  fun mapDomainForecastsToDb(forecasts: List<Forecast>): List<DbForecast>

  fun mapDbForecastsToDomain(forecasts: List<DbForecast>): List<Forecast>
}
