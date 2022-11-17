package com.example.got.view.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.got.databinding.FragmentHomeBinding
import com.example.got.model.Character
import com.example.got.model.response.CharacterResponse
import com.example.got.view.adapter.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel by viewModel<HomeViewModel>()
    private lateinit var infoAdapter: HomeAdapter

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.populaCharacters()
        observer()

        infoAdapter = HomeAdapter()
    }

    private fun observer() {
        viewModel.characterResponse.observe(viewLifecycleOwner) {
            it?.let {
                setAdapter(it)
            }
        }
    }

    private fun setAdapter(response: CharacterResponse) {
        binding.activityListaPersonagensRecyclerview.apply {
            adapter = infoAdapter
            infoAdapter.sendsToAdapter(response)
            infoAdapter.setClickListener(object : HomeAdapter.ClickListener{
                override fun onItemClick(character: Character, position: Int) {
                    val bundle = bundleOf("characters" to response)
//                    findNavController().navigate()
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}