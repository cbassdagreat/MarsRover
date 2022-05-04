package cbassdagreat.github.marsrover.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import cbassdagreat.github.marsrover.R
import cbassdagreat.github.marsrover.databinding.ItemLayoutBinding
import cbassdagreat.github.marsrover.model.Photo
import cbassdagreat.github.marsrover.model.Photos
import com.squareup.picasso.Picasso

class PhotoAdapter : RecyclerView.Adapter<PhotoAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemView: View, val listener: MiListener) :
        RecyclerView.ViewHolder(itemView) {
        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(photo: Photo) {
            with(binding)
            {
                Picasso.get().load(photo.imgSrc).resize(300, 300).into(ivPic)

                itemView.setOnClickListener {
                    listener.miOnClick(photo)
                }
            }
        }
    }

    var lista: List<Photo> = ArrayList()
    lateinit var listener: MiListener

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return CustomViewHolder(view, listener)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])

    }

    override fun getItemCount(): Int = lista.size

    fun updateData(pic: Photos) {
        lista = pic.photos
        notifyDataSetChanged()

    }

    interface MiListener {
        fun miOnClick(photo: Photo)
    }

    fun setMiListener(listener: MiListener) {
        this.listener = listener

    }

}
