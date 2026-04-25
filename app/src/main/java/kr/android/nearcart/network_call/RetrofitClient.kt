package kr.android.nearcart.network_call

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    private const val BASE_URL = "https://maps.googleapis.com/"

    //building the url for geocoding API
    fun addressCreate() : GeocodeAPIService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(GeocodeAPIService :: class.java)
    }

    //building the url for Places API
    fun nearbyPlacesCreate() : NearbyPlacesAPIService {
        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        return retrofit.create(NearbyPlacesAPIService :: class.java)
    }

}