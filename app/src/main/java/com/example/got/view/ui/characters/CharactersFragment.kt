package com.example.got.view.ui.characters

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import com.example.got.databinding.FragmentHomeBinding
import com.example.got.model.Character
import com.example.got.model.response.CharacterResponse
import com.example.got.view.adapter.CharactersAdapter
import com.example.got.view.detalhes.CharacterInfoActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val viewModel by viewModel<CharactersViewModel>()
    private lateinit var infoAdapterCharacter: CharactersAdapter

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

        viewModel.fillCharacters()
        observer()

        infoAdapterCharacter = CharactersAdapter()
    }

    private fun observer() {
        viewModel.characterResponse.observe(viewLifecycleOwner) {
            it?.let {
                setAdapter(it)
            }
        }
    }

    private fun setAdapter(response: CharacterResponse) {
        binding.activityListCharactersRecyclerview.apply {
            adapter = infoAdapterCharacter
            infoAdapterCharacter.sendsToAdapter(response)
            infoAdapterCharacter.setClickListener(object : CharactersAdapter.ClickListener{
                override fun onItemClick(character: Character, position: Int) {
                    val intent = Intent(requireActivity(), CharacterInfoActivity::class.java)
                    intent.putExtra("sendCharacter", character)
                    startActivity(intent)
                }
            })
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}