package com.example.project_uas_kel8.dushare.activity

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.ActivityDushareSearchBinding
import com.example.project_uas_kel8.dushare.adapter.SearchResultAdapter
import com.example.project_uas_kel8.dushare.data.DuShareMockData
import com.example.project_uas_kel8.dushare.model.NoteModel

class DuShareSearchActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDushareSearchBinding
    private lateinit var adapter: SearchResultAdapter
    private var selectedFileType = "ALL" // ALL, PDF, PPT, DOC
    private var allResults = DuShareMockData.searchResults

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDushareSearchBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, systemBars.bottom)
            insets
        }

        val initialQuery = intent.getStringExtra("QUERY") ?: "Machine Learning"
        binding.edtSearchQuery.setText(initialQuery)

        binding.btnSearchBack.setOnClickListener {
            finish()
        }

        // Setup Adapter
        adapter = SearchResultAdapter(
            allResults,
            onBookmarkToggle = { note ->
                val status = if (note.isBookmarked) "disimpan" else "dihapus dari materi tersimpan"
                Toast.makeText(this, "${note.title} $status", Toast.LENGTH_SHORT).show()
            },
            onItemClick = { note ->
                AlertDialog.Builder(this)
                    .setTitle(note.title)
                    .setMessage("Penulis: ${note.author} (${note.authorUniversity})\nFormat: ${note.fileType} (${note.pageCount})\nRating: ★ ${note.rating} (${note.reviewCount} ulasan)\nUnduhan: ${note.downloadCount}\n\n${note.description}")
                    .setPositiveButton("Unduh Materi") { _, _ ->
                        Toast.makeText(this, "Mengunduh ${note.title}...", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Tutup", null)
                    .show()
            }
        )
        binding.rvSearchResults.adapter = adapter

        // Search text watcher
        binding.edtSearchQuery.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterResults()
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // Filter chips click listeners
        setupFilterChips()

        // Sort button
        binding.btnSort.setOnClickListener {
            Toast.makeText(this, "Urutan: Rating Tertinggi", Toast.LENGTH_SHORT).show()
        }

        // Filter options button
        binding.btnFilterOptions.setOnClickListener {
            Toast.makeText(this, "Filter Lanjutan", Toast.LENGTH_SHORT).show()
        }

        // Upload Prompt Button
        binding.btnUploadPrompt.setOnClickListener {
            Toast.makeText(this, "Membuka formulir unggah materi baru...", Toast.LENGTH_SHORT).show()
        }

        filterResults()
    }

    private fun setupFilterChips() {
        binding.chipAllFiles.setOnClickListener {
            selectedFileType = "ALL"
            updateChipStyles()
            filterResults()
        }
        binding.chipPdf.setOnClickListener {
            selectedFileType = "PDF"
            updateChipStyles()
            filterResults()
        }
        binding.chipPpt.setOnClickListener {
            selectedFileType = "PPT"
            updateChipStyles()
            filterResults()
        }
        binding.chipDoc.setOnClickListener {
            selectedFileType = "DOC"
            updateChipStyles()
            filterResults()
        }
    }

    private fun updateChipStyles() {
        val activeBg = ContextCompat.getDrawable(this, R.drawable.bg_dushare_pill_active)
        val inactiveBg = ContextCompat.getDrawable(this, R.drawable.bg_dushare_pill_inactive)
        val activeColor = ContextCompat.getColor(this, R.color.dushare_primary_container)
        val inactiveColor = ContextCompat.getColor(this, R.color.dushare_on_surface_variant)

        fun setChip(tv: TextView, isActive: Boolean, activeText: String, normalText: String) {
            tv.background = if (isActive) activeBg else inactiveBg
            tv.setTextColor(if (isActive) activeColor else inactiveColor)
            tv.text = if (isActive) activeText else normalText
        }

        setChip(binding.chipAllFiles, selectedFileType == "ALL", "✓ Semua File", "Semua File")
        setChip(binding.chipPdf, selectedFileType == "PDF", "✓ PDF (84)", "PDF (84)")
        setChip(binding.chipPpt, selectedFileType == "PPT", "✓ PPT (26)", "PPT (26)")
        setChip(binding.chipDoc, selectedFileType == "DOC", "✓ DOC (18)", "DOC (18)")
    }

    private fun filterResults() {
        val query = binding.edtSearchQuery.text.toString().trim().lowercase()
        val filtered = allResults.filter { note ->
            val matchesType = when (selectedFileType) {
                "PDF" -> note.fileType.equals("PDF", ignoreCase = true)
                "PPT" -> note.fileType.equals("PPT", ignoreCase = true)
                "DOC" -> note.fileType.equals("DOC", ignoreCase = true)
                else -> true
            }
            val matchesQuery = query.isEmpty() ||
                    note.title.lowercase().contains(query) ||
                    note.subject.lowercase().contains(query) ||
                    note.author.lowercase().contains(query)
            matchesType && matchesQuery
        }

        adapter.updateList(filtered)
        binding.txtResultCount.text = "${filtered.size} materi ditemukan"
    }
}
