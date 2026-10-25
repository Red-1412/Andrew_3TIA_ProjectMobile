package com.example.project_uas_kel8.dushare.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.project_uas_kel8.databinding.FragmentDushareHomeBinding
import com.example.project_uas_kel8.dushare.activity.DuShareMainActivity
import com.example.project_uas_kel8.dushare.activity.DuShareSearchActivity
import com.example.project_uas_kel8.dushare.adapter.CategoryChipAdapter
import com.example.project_uas_kel8.dushare.adapter.PopularNoteAdapter
import com.example.project_uas_kel8.dushare.adapter.RecentNoteAdapter
import com.example.project_uas_kel8.dushare.data.DuShareMockData

class DuShareHomeFragment : Fragment() {

    private var _binding: FragmentDushareHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDushareHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "Andrew") ?: "Andrew"
        binding.txtGreetingName.text = username

        // Search Bar Click
        binding.btnSearchContainer.setOnClickListener {
            val intent = Intent(requireContext(), DuShareSearchActivity::class.java)
            startActivity(intent)
        }

        // Continue Reading Button
        binding.btnContinueReading.setOnClickListener {
            Toast.makeText(
                requireContext(),
                "Melanjutkan membaca: Binary Search Tree (Halaman 18)",
                Toast.LENGTH_SHORT
            ).show()
        }

        // Category Chips
        val categoryAdapter = CategoryChipAdapter(DuShareMockData.categories) { category ->
            val intent = Intent(requireContext(), DuShareSearchActivity::class.java)
            intent.putExtra("QUERY", category.name)
            startActivity(intent)
        }
        binding.rvCategories.adapter = categoryAdapter

        // See All Courses
        binding.txtSeeAllCourses.setOnClickListener {
            val intent = Intent(requireContext(), DuShareSearchActivity::class.java)
            startActivity(intent)
        }

        // Popular Notes
        val popularAdapter = PopularNoteAdapter(
            DuShareMockData.popularNotes,
            onBookmarkToggle = { note ->
                val status = if (note.isBookmarked) "disimpan" else "dihapus dari simpanan"
                Toast.makeText(requireContext(), "${note.title} $status", Toast.LENGTH_SHORT).show()
            },
            onItemClick = { note ->
                Toast.makeText(requireContext(), "Membuka ${note.title}", Toast.LENGTH_SHORT).show()
            }
        )
        binding.rvPopularNotes.adapter = popularAdapter

        // Recent Notes
        val recentAdapter = RecentNoteAdapter(
            DuShareMockData.recentNotes,
            onBookmarkToggle = { note ->
                val status = if (note.isBookmarked) "disimpan" else "dihapus dari simpanan"
                Toast.makeText(requireContext(), "${note.title} $status", Toast.LENGTH_SHORT).show()
            },
            onItemClick = { note ->
                Toast.makeText(requireContext(), "Membuka ${note.title}", Toast.LENGTH_SHORT).show()
            }
        )
        binding.rvRecentNotes.adapter = recentAdapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
