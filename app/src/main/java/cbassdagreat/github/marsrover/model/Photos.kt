package cbassdagreat.github.marsrover.model


import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("photos")
    val photos: List<Photo>
)