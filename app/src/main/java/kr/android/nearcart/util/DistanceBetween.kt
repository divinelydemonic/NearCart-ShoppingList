package kr.android.nearcart.util

import android.location.Location
import com.google.android.gms.maps.model.LatLng

//to find the nearest place from current location
fun distanceBetweenPlaces(a : LatLng, b : LatLng) : Float {
    val result = FloatArray(1)
    Location.distanceBetween(
        a.latitude, a.longitude,
        b.latitude, b.longitude,
        result
    )
    return result[0]    //in meters
}