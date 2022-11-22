package com.example.got.view.ui.continents

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.got.databinding.FragmentDashboardBinding
import com.example.got.model.response.ContinentResponse
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

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.fillContinents()
        observer()

        infoAdapterContinent = ContinentAdapter()
    }

    private fun observer() {
        viewModel.continentsResponse.observe(viewLifecycleOwner) {
            it?.let {
                setAdapter(it)
            }
        }
    }

    private fun setAdapter(response: ContinentResponse) {
        binding.activityListContinentsRecyclerview.apply {
            adapter = infoAdapterContinent
            infoAdapterContinent.sendsToAdapter(response)

        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}