package cbassdagreat.github.marsrover.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import cbassdagreat.github.marsrover.R
import cbassdagreat.github.marsrover.databinding.ItemLayoutBinding
import cbassdagreat.github.marsrover.model.Fotos
import cbassdagreat.github.marsrover.model.Photo
import com.squareup.picasso.Picasso

class FotoAdapter : RecyclerView.Adapter<FotoAdapter.CustomViewHolder>() {
    class CustomViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){

        private val binding = ItemLayoutBinding.bind(itemView)

        fun bindData(photo: Photo)
        {
            with(binding)
            {
                Picasso.get().load(photo.imgSrc).resize(300,300).into(ivPic)
            }
        }
    }

    var lista: List<Photo> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
    val view =  LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
    return CustomViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder.bindData(lista[position])

    }

    override fun getItemCount(): Int = lista.size

}
