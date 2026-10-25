package com.example.project_uas_kel8.dushare.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.project_uas_kel8.databinding.ItemDushareMyNoteBinding
import com.example.project_uas_kel8.dushare.model.NoteModel

class MyNoteAdapter(
    private val notes: List<NoteModel>,
    private val onMenuClick: (NoteModel) -> Unit,
    private val onItemClick: (NoteModel) -> Unit
) : RecyclerView.Adapter<MyNoteAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: ItemDushareMyNoteBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDushareMyNoteBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val note = notes[position]
        holder.binding.txtMyNoteSubject.text = note.subject
        holder.binding.txtMyNoteTitle.text = note.title
        holder.binding.txtMyNoteFileMeta.text = "${note.fileType} • ${note.pageCount}"
        holder.binding.txtMyNoteRating.text = note.rating.toString()
        holder.binding.txtMyNoteDownloads.text = "${note.downloadCount} unduhan"

        holder.binding.btnMyNoteMenu.setOnClickListener {
            onMenuClick(note)
        }

        holder.binding.root.setOnClickListener {
            onItemClick(note)
        }
    }

    override fun getItemCount(): Int = notes.size
}
