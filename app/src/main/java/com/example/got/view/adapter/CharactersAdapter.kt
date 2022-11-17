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
    private var clickListener: ClickListener? = null

    inner class ViewHolder(
        private val binding: ItemCharacterBinding,
    ) : RecyclerView.ViewHolder(binding.root) {

        val imageCharacter = itemView.findViewById<ImageView>(R.id.item_character_image)

        fun bind(character: Character) {
            Glide.with(imageCharacter)
                .load(character.imageUrl)
                .placeholder(loadCircularProgress(imageCharacter.context))
                .into(imageCharacter)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemCharacterBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
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

    fun sendsToAdapter(listaMandaAdapter: List<Character>) {
        val oldRangeItem = listCharacter.size
        val newRangeItem = listaMandaAdapter.size

        listCharacter.clear()
        listCharacter.addAll(listaMandaAdapter)

        notifyItemRangeInserted(oldRangeItem, newRangeItem)
    }

    fun setClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    interface ClickListener {
        fun onItemClick(character: Character, position: Int)
    }

}