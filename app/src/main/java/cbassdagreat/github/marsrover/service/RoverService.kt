package cbassdagreat.github.marsrover.service

import cbassdagreat.github.marsrover.model.Photos
import retrofit2.Call
import retrofit2.http.GET

interface RoverService {

    @GET("photos?earth_date=2015-6-3&api_key=DEMO_KEY")
    fun getPics(): Call<Photos>
}