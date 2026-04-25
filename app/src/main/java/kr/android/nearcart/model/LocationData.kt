package kr.android.nearcart.model

//latitude-longitude
data class LocationData(
    val latitude : Double,
    val longitude : Double
)

//formatted address from latitude-longitude
data class GeocodingResult(
    val formatted_address : String
)

//list of formatted addresses
data class GeocodingResponse(
    val results : List<GeocodingResult>
)
