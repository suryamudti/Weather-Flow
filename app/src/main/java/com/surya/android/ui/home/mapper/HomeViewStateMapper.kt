package com.surya.android.ui.home.mapper

import com.surya.android.domain.model.Forecast
import com.surya.android.domain.model.Location
import com.surya.android.ui.home.ForecastViewState
import com.surya.android.ui.home.LocationViewState

interface HomeViewStateMapper {

  fun mapForecastsToViewState(forecasts: List<Forecast>): List<ForecastViewState>

  fun mapLocationsToViewState(locations: List<Location>): List<LocationViewState>
}
