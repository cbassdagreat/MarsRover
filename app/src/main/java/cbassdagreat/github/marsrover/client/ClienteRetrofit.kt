package cbassdagreat.github.marsrover.client

import cbassdagreat.github.marsrover.service.RoverService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class ClienteRetrofit {

    companion object {
        const val BASE_URL = "https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/"
        private var cliente:Retrofit?=null

        fun getInstance(url:String):RoverService
        {
            if(cliente==null)
            {
                cliente = Retrofit.Builder().baseUrl(url).addConverterFactory(GsonConverterFactory.create()).build()
            }

            return cliente!!.create(RoverService::class.java)
        }

    }
}
