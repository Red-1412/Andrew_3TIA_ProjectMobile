package com.example.project_uas_kel8.dushare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.ItemDushareSavedBinding
import com.example.project_uas_kel8.dushare.model.NoteModel

class SavedNoteAdapter(
    private var notes: List<NoteModel>,
    private val onBookmarkToggle: (NoteModel) -> Unit,
    private val onItemClick: (NoteModel) -> Unit
) : RecyclerView.Adapter<SavedNoteAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDushareSavedBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDushareSavedBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.txtSavedFileType.text = note.fileType
        holder.binding.txtSavedSubject.text = note.subject
        holder.binding.txtSavedTitle.text = note.title
        holder.binding.txtSavedAuthor.text = "${note.author} • ${note.authorUniversity}"
        holder.binding.txtSavedRating.text = note.rating.toString()
        holder.binding.txtSavedDownloads.text = "${note.downloadCount} unduhan"
        holder.binding.txtSavedPages.text = "• ${note.pageCount}"

        val bookmarkIcon = if (note.isBookmarked) {
            R.drawable.ic_dushare_bookmark_filled
        } else {
            R.drawable.ic_dushare_bookmark
        }
        holder.binding.btnSavedBookmark.setImageResource(bookmarkIcon)
        holder.binding.btnSavedBookmark.setColorFilter(
            ContextCompat.getColor(
                holder.itemView.context,
                if (note.isBookmarked) R.color.dushare_primary_container else R.color.dushare_outline
            )
        )

        holder.binding.btnSavedBookmark.setOnClickListener {
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
