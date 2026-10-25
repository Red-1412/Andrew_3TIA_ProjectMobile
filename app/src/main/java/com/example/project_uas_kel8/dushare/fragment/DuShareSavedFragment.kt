package com.example.project_uas_kel8.dushare.fragment

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.FragmentDushareSavedBinding
import com.example.project_uas_kel8.dushare.activity.DuShareSearchActivity
import com.example.project_uas_kel8.dushare.adapter.SavedNoteAdapter
import com.example.project_uas_kel8.dushare.data.DuShareMockData
import com.example.project_uas_kel8.dushare.model.NoteModel

class DuShareSavedFragment : Fragment() {

    private var _binding: FragmentDushareSavedBinding? = null
    private val binding get() = _binding!!
    private lateinit var adapter: SavedNoteAdapter
    private var selectedCategory = "ALL" // ALL, Rangkuman, Latihan Soal, Modul Kuliah
    private var savedList = DuShareMockData.savedNotes

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDushareSavedBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = SavedNoteAdapter(
            savedList,
            onBookmarkToggle = { note ->
                val status = if (note.isBookmarked) "disimpan" else "dihapus dari tersimpan"
                Toast.makeText(requireContext(), "${note.title} $status", Toast.LENGTH_SHORT).show()
                filterSaved()
            },
            onItemClick = { note ->
                AlertDialog.Builder(requireContext())
                    .setTitle(note.title)
                    .setMessage("Penulis: ${note.author} (${note.authorUniversity})\nFormat: ${note.fileType} (${note.pageCount})\nRating: ★ ${note.rating}\nStatus: ${note.timeAgo}")
                    .setPositiveButton("Buka Dokumen") { _, _ ->
                        Toast.makeText(requireContext(), "Membuka ${note.title}...", Toast.LENGTH_SHORT).show()
                    }
                    .setNegativeButton("Tutup", null)
                    .show()
            }
        )
        binding.rvSavedNotes.adapter = adapter

        // Search in saved
        binding.edtSavedSearch.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                filterSaved()
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // Category Tabs
        setupCategoryTabs()

        // Explore button in tip card
        binding.btnExploreNotes.setOnClickListener {
            val intent = Intent(requireContext(), DuShareSearchActivity::class.java)
            startActivity(intent)
        }

        filterSaved()
    }

    private fun setupCategoryTabs() {
        binding.tabSavedAll.setOnClickListener {
            selectedCategory = "ALL"
            updateTabStyles()
            filterSaved()
        }
        binding.tabSavedRangkuman.setOnClickListener {
            selectedCategory = "Rangkuman"
            updateTabStyles()
            filterSaved()
        }
        binding.tabSavedLatihan.setOnClickListener {
            selectedCategory = "Latihan Soal"
            updateTabStyles()
            filterSaved()
        }
        binding.tabSavedModul.setOnClickListener {
            selectedCategory = "Modul Kuliah"
            updateTabStyles()
            filterSaved()
        }
    }

    private fun updateTabStyles() {
        val activeBg = ContextCompat.getDrawable(requireContext(), R.drawable.bg_dushare_pill_active)
        val inactiveBg = ContextCompat.getDrawable(requireContext(), R.drawable.bg_dushare_pill_inactive)
        val activeColor = ContextCompat.getColor(requireContext(), R.color.dushare_primary_container)
        val inactiveColor = ContextCompat.getColor(requireContext(), R.color.dushare_on_surface_variant)

        fun setTab(tv: TextView, isActive: Boolean) {
            tv.background = if (isActive) activeBg else inactiveBg
            tv.setTextColor(if (isActive) activeColor else inactiveColor)
        }

        setTab(binding.tabSavedAll, selectedCategory == "ALL")
        setTab(binding.tabSavedRangkuman, selectedCategory == "Rangkuman")
        setTab(binding.tabSavedLatihan, selectedCategory == "Latihan Soal")
        setTab(binding.tabSavedModul, selectedCategory == "Modul Kuliah")
    }

    private fun filterSaved() {
        val query = binding.edtSavedSearch.text.toString().trim().lowercase()
        val filtered = savedList.filter { note ->
            val matchesCategory = when (selectedCategory) {
                "Rangkuman" -> note.category.equals("Rangkuman", ignoreCase = true)
                "Latihan Soal" -> note.category.equals("Latihan Soal", ignoreCase = true)
                "Modul Kuliah" -> note.category.equals("Modul Kuliah", ignoreCase = true)
                else -> true
            }
            val matchesQuery = query.isEmpty() ||
                    note.title.lowercase().contains(query) ||
                    note.subject.lowercase().contains(query) ||
                    note.author.lowercase().contains(query)
            matchesCategory && matchesQuery
        }

        adapter.updateList(filtered)
        binding.txtSavedCountBadge.text = "${filtered.size} Berkas"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
