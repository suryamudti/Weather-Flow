package com.surya.android.domain.model

data class LocationDetails(
  val forecasts: List<Forecast>,
  val time: String,
  val sunrise: String,
  val sunset: String,
  val title: String,
  val id: Int
)
