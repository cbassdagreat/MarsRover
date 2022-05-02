package cbassdagreat.github.marsrover.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import cbassdagreat.github.marsrover.R
import cbassdagreat.github.marsrover.adapter.FotoAdapter
import cbassdagreat.github.marsrover.databinding.FragmentListaBinding

class ListaFragment : Fragment() {

    lateinit var binding: FragmentListaBinding
    //lateinit var viewModel by activityViewModels<> {  }
    private val adapter = FotoAdapter()

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



        return binding.root
    }


}