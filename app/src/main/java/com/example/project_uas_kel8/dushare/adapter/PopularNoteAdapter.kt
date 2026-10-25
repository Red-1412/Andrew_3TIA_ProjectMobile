package com.example.project_uas_kel8.dushare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.ItemDusharePopularBinding
import com.example.project_uas_kel8.dushare.model.NoteModel

class PopularNoteAdapter(
    private val notes: List<NoteModel>,
    private val onBookmarkToggle: (NoteModel) -> Unit,
    private val onItemClick: (NoteModel) -> Unit
) : RecyclerView.Adapter<PopularNoteAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDusharePopularBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDusharePopularBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.txtSubject.text = note.subject
        holder.binding.txtFileMeta.text = "${note.fileType} • ${note.pageCount}"
        holder.binding.txtTitle.text = note.title
        holder.binding.txtAuthorName.text = note.author
        holder.binding.txtRating.text = note.rating.toString()
        holder.binding.txtReviewCount.text = "(${note.reviewCount} ulasan)"

        val bookmarkIcon = if (note.isBookmarked) {
            R.drawable.ic_dushare_bookmark_filled
        } else {
            R.drawable.ic_dushare_bookmark
        }
        holder.binding.btnBookmark.setImageResource(bookmarkIcon)
        holder.binding.btnBookmark.setColorFilter(
            ContextCompat.getColor(
                holder.itemView.context,
                if (note.isBookmarked) R.color.dushare_primary_container else R.color.dushare_outline
            )
        )

        if (note.authorAvatarUrl.isNotEmpty()) {
            Glide.with(holder.itemView.context)
                .load(note.authorAvatarUrl)
                .placeholder(R.drawable.user)
                .into(holder.binding.imgAuthorAvatar)
        }

        holder.binding.btnBookmark.setOnClickListener {
            note.isBookmarked = !note.isBookmarked
            notifyItemChanged(position)
            onBookmarkToggle(note)
        }

        holder.binding.root.setOnClickListener {
            onItemClick(note)
        }
    }

    override fun getItemCount(): Int = notes.size
}
