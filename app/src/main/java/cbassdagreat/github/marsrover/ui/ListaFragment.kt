package cbassdagreat.github.marsrover.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import cbassdagreat.github.marsrover.adapter.PhotoAdapter
import cbassdagreat.github.marsrover.databinding.FragmentListaBinding
import cbassdagreat.github.marsrover.model.Photo
import cbassdagreat.github.marsrover.viewmodel.RoverVM

class ListaFragment : Fragment() {

    lateinit var binding: FragmentListaBinding
    private val viewModel by activityViewModels<RoverVM>()
    private val adapter = PhotoAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentListaBinding.inflate(layoutInflater)

        val layoutManager = LinearLayoutManager(requireContext())

        with(binding)
        {
            rvLista.adapter = adapter
            rvLista.layoutManager = layoutManager
        }

        adapter.setMiListener(object : PhotoAdapter.MiListener{
            override fun miOnClick(photo: Photo)
            {
                viewModel.updateData(photo)
            }
        })

        viewModel.pics.observe(viewLifecycleOwner, Observer {
            adapter.updateData(it)
        })



        return binding.root
    }


}