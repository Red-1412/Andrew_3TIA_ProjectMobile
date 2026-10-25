package com.example.project_uas_kel8.dushare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.ItemDushareSearchResultBinding
import com.example.project_uas_kel8.dushare.model.NoteModel

class SearchResultAdapter(
    private var notes: List<NoteModel>,
    private val onBookmarkToggle: (NoteModel) -> Unit,
    private val onItemClick: (NoteModel) -> Unit
) : RecyclerView.Adapter<SearchResultAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDushareSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDushareSearchResultBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.txtSearchSubject.text = note.subject
        holder.binding.txtSearchFileMeta.text = "${note.fileType} • ${note.pageCount}"
        holder.binding.txtSearchTitle.text = note.title
        holder.binding.txtSearchDescription.text = note.description
        holder.binding.txtSearchAuthor.text = note.author
        holder.binding.txtSearchUniversity.text = note.authorUniversity
        holder.binding.txtSearchRating.text = note.rating.toString()
        holder.binding.txtSearchReviewCount.text = "(${note.reviewCount})"
        holder.binding.txtSearchDownloads.text = note.downloadCount

        // Initials
        val words = note.author.trim().split(" ")
        val initials = if (words.size >= 2) {
            "${words[0].firstOrNull() ?: ""}${words[1].firstOrNull() ?: ""}"
        } else {
            note.author.take(2).uppercase()
        }
        holder.binding.txtAuthorInitials.text = initials

        val bookmarkIcon = if (note.isBookmarked) {
            R.drawable.ic_dushare_bookmark_filled
        } else {
            R.drawable.ic_dushare_bookmark
        }
        holder.binding.btnSearchBookmark.setImageResource(bookmarkIcon)
        holder.binding.btnSearchBookmark.setColorFilter(
            ContextCompat.getColor(
                holder.itemView.context,
                if (note.isBookmarked) R.color.dushare_primary_container else R.color.dushare_outline
            )
        )

        holder.binding.btnSearchBookmark.setOnClickListener {
            note.isBookmarked = !note.isBookmarked
            notifyItemChanged(position)
            onBookmarkToggle(note)
        }

        holder.binding.root.setOnClickListener {
            onItemClick(note)
        }
    }

    override fun getItemCount(): Int = notes.size

    fun updateList(newNotes: List<NoteModel>) {
        notes = newNotes
        notifyDataSetChanged()
    }
}
