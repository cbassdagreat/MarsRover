package cbassdagreat.github.marsrover.viewmodel

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import cbassdagreat.github.marsrover.client.ClienteRetrofit
import cbassdagreat.github.marsrover.model.Photos
import cbassdagreat.github.marsrover.model.Photo
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RoverVM (application: Application) : AndroidViewModel(application) {


    val pics = MutableLiveData<Photos>()
    val pic = MutableLiveData<Photo>()


    fun getData()
    {
        val service = ClienteRetrofit.getInstance(ClienteRetrofit.BASE_URL)
        service.getPics().enqueue(object : Callback<Photos> {
            override fun onResponse(call: Call<Photos>, response: Response<Photos>){
                response.body().let {
                    pics.postValue(it)
                    Log.i("RESPONSE",it.toString())
                }
            }
            override fun onFailure(call:Call<Photos>, t: Throwable){
                Log.e("CALL", t.message.toString())
                call.cancel()
            }
        })

        }

    fun updateData(pic:Photo)
    {
        this.pic.value = pic
    }



}