package kr.android.nearcart.network_call

import kr.android.nearcart.model.NearbyPlacesResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NearbyPlacesAPIService {
    @GET("maps/api/place/nearbysearch/json")
    suspend fun getNearbyPlaces(
        @Query("location") location: String? = null,
        @Query("radius") radius: Int? = null,
        @Query("keyword") keyword: String? = null,
        @Query("pagetoken") pagetoken: String? = null,
        @Query("key") key: String
    ): NearbyPlacesResponse
}