package com.example.randomimage


import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.randomimage.databinding.ItemListBinding

class MyListAdapter: RecyclerView.Adapter<MyListAdapter.MyViewHolder>() {

    private var myData: List<String> = listOf()

    fun setList(list: List<String>) {
        myData = list
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context))
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(myData[position])
    }

    override fun getItemCount(): Int {
        return myData.size
    }

    class MyViewHolder(
        private val binding: ItemListBinding
    ): ViewHolder(binding.root) {
        fun bind(data: String) {
            binding.myTextView.text = data
        }
    }
}