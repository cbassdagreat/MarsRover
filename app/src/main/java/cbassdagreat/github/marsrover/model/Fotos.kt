package cbassdagreat.github.marsrover.model


import com.google.gson.annotations.SerializedName

data class Fotos(
    @SerializedName("photos")
    val photos: List<Photo>
)