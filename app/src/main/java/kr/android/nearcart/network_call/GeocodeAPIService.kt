package kr.android.nearcart.network_call

import kr.android.nearcart.model.GeocodingResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface GeocodeAPIService {
    @GET("maps/api/geocode/json")
    suspend fun getAddressFromCoordinates(
        @Query("latlng") latlng : String,
        @Query("key") key : String
    ) : GeocodingResponse
}