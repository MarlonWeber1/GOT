package com.example.got.view.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.core.content.ContextCompat
import androidx.core.graphics.BlendModeColorFilterCompat
import androidx.core.graphics.BlendModeCompat
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.CircularProgressDrawable
import com.bumptech.glide.Glide
import com.example.got.R
import com.example.got.databinding.ItemCharacterBinding
import com.example.got.model.Character

class CharactersAdapter() : RecyclerView.Adapter<CharactersAdapter.ViewHolder>() {

    private val listCharacter: ArrayList<Character> = arrayListOf()
    private lateinit var clickListener: ClickListener

    inner class ViewHolder(
        private val binding: ItemCharacterBinding,
        listener: ClickListener
    ) : RecyclerView.ViewHolder(binding.root) {

        val imageCharacter = itemView.findViewById<ImageView>(R.id.item_character_image)
        init{
            itemView.let {
                it.setOnClickListener{
                    listener.onItemClick(listCharacter[bindingAdapterPosition], bindingAdapterPosition)
                }
            }
        }

        fun bind(character: Character) {
            Glide.with(imageCharacter)
                .load(character.imageUrl)
                .placeholder(loadCircularProgress(imageCharacter.context))
                .into(imageCharacter)
            binding.itemCharacterText.text = character.fullName
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            ), clickListener
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listCharacter[position])
    }

    override fun getItemCount(): Int {
        return listCharacter.size
    }

    private fun loadCircularProgress(context: Context): CircularProgressDrawable {
        val circularProgressDrawable = CircularProgressDrawable(context)
        val colorFilter = BlendModeColorFilterCompat.createBlendModeColorFilterCompat(
            ContextCompat.getColor(context, R.color.background_blue),
            BlendModeCompat.SRC_ATOP
        )

        circularProgressDrawable.colorFilter = colorFilter
        circularProgressDrawable.strokeWidth = 10f
        circularProgressDrawable.centerRadius = 60f
        circularProgressDrawable.start()

        return circularProgressDrawable
    }

    fun sendsToAdapter(listSendsToAdapter: List<Character>) {
        val oldRangeItem = listCharacter.size
        val newRangeItem = listSendsToAdapter.size

        listCharacter.clear()
        listCharacter.addAll(listSendsToAdapter)

        notifyItemRangeInserted(oldRangeItem, newRangeItem)
    }

    fun setClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    interface ClickListener {
        fun onItemClick(character: Character, position: Int)
    }

}