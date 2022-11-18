package com.example.got.view.ui.continents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.got.databinding.FragmentDashboardBinding
import com.example.got.model.Character
import com.example.got.model.response.CharacterResponse
import com.example.got.model.response.ContinentResponse
import com.example.got.view.adapter.CharactersAdapter
import com.example.got.view.adapter.ContinentAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class ContinentsFragment : Fragment() {

    private val viewModel by viewModel<ContinentsViewModel>()
    private lateinit var infoAdapterContinent: ContinentAdapter
    private var _binding: FragmentDashboardBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentDashboardBinding.inflate(inflater, container, false)
        val root: View = binding.root

        return root
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        viewModel.fillContinents()
//        observer()
//
//        infoAdapterContinent = ContinentAdapter()
//    }
//
//    private fun initObserver() {
//        viewModel.continentsResponse.observe(viewLifecycleOwner) {
//            it?.let {
//                setAdapter(it)
//            }
//        }
//    }
//
//    private fun setAdapter(response: ContinentResponse) {
//        binding.apply {
//            adapter = infoAdapterContinent
//            infoAdapterCharacter.sendsToAdapter(response)
//            infoAdapterCharacter.setClickListener(object : CharactersAdapter.ClickListener{
//                override fun onItemClick(character: Character, position: Int) {
//                    val bundle = bundleOf("characters" to response)
////                    findNavController().navigate()
//                }
//            })
//        }
//    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}