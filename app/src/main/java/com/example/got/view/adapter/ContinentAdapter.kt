package com.example.got.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.got.databinding.ItemContinentBinding
import com.example.got.model.Character
import com.example.got.model.Continent

class ContinentAdapter() : RecyclerView.Adapter<ContinentAdapter.ViewHolder>() {

    private val listContinents: ArrayList<Continent> = arrayListOf()
    private var clickListener: ContinentAdapter.ClickListener? = null

    inner class ViewHolder(
        private val binding: ItemContinentBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(continent: Continent) {
            binding.itemContinentText.text = continent.name
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemContinentBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(listContinents[position])
    }

    override fun getItemCount(): Int {
        return listContinents.size
    }

    fun sendsToAdapter(listSendsToAdapter: List<Character>) {
        val oldRangeItem = listContinents.size
        val newRangeItem = listSendsToAdapter.size

        listContinents.clear()
//        listContinents.addAll(listSendsToAdapter)

        notifyItemRangeInserted(oldRangeItem, newRangeItem)
    }

    fun setClickListener(clickListener: ClickListener) {
        this.clickListener = clickListener
    }

    interface ClickListener {
        fun onItemClick(character: Character, position: Int)
    }

}