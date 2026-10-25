package com.example.project_uas_kel8.dushare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_uas_kel8.databinding.ItemDushareCategoryBinding
import com.example.project_uas_kel8.dushare.model.CategoryModel

class CategoryChipAdapter(
    private val categories: List<CategoryModel>,
    private val onItemClick: (CategoryModel) -> Unit
) : RecyclerView.Adapter<CategoryChipAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDushareCategoryBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDushareCategoryBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = categories[position]
        holder.binding.txtCategoryName.text = item.name
        holder.binding.root.setOnClickListener {
            onItemClick(item)
        }
    }

    override fun getItemCount(): Int = categories.size
}
