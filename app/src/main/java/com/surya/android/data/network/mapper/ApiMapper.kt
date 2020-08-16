package com.surya.android.data.network.mapper

import com.surya.android.data.network.model.ApiLocation
import com.surya.android.data.network.model.ApiLocationDetails
import com.surya.android.domain.model.Location
import com.surya.android.domain.model.LocationDetails

interface ApiMapper {

  fun mapApiLocationToDomain(apiLocation: ApiLocation): Location

  fun mapApiLocationDetailsToDomain(apiLocationDetails: ApiLocationDetails): LocationDetails
}
