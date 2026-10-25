package com.example.project_uas_kel8.dushare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.ItemDushareRecentBinding
import com.example.project_uas_kel8.dushare.model.NoteModel

class RecentNoteAdapter(
    private val notes: List<NoteModel>,
    private val onBookmarkToggle: (NoteModel) -> Unit,
    private val onItemClick: (NoteModel) -> Unit
) : RecyclerView.Adapter<RecentNoteAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDushareRecentBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDushareRecentBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.txtFileTypeBadge.text = note.fileType
        holder.binding.txtRecentTitle.text = note.title
        holder.binding.txtRecentSubtitle.text = "${note.subject} • ${note.author}"
        holder.binding.txtRecentRating.text = note.rating.toString()
        holder.binding.txtRecentDownloads.text = "• ${note.downloadCount} unduhan"
        holder.binding.txtRecentTime.text = "• ${note.timeAgo}"

        val bookmarkIcon = if (note.isBookmarked) {
            R.drawable.ic_dushare_bookmark_filled
        } else {
            R.drawable.ic_dushare_bookmark
        }
        holder.binding.btnRecentBookmark.setImageResource(bookmarkIcon)
        holder.binding.btnRecentBookmark.setColorFilter(
            ContextCompat.getColor(
                holder.itemView.context,
                if (note.isBookmarked) R.color.dushare_primary_container else R.color.dushare_outline
            )
        )

        holder.binding.btnRecentBookmark.setOnClickListener {
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
