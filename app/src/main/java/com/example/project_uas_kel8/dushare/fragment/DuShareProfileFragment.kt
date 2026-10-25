package com.example.project_uas_kel8.dushare.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.FragmentDushareProfileBinding
import com.example.project_uas_kel8.dushare.activity.DuShareSettingsActivity
import com.example.project_uas_kel8.dushare.adapter.MyNoteAdapter
import com.example.project_uas_kel8.dushare.data.DuShareMockData

class DuShareProfileFragment : Fragment() {

    private var _binding: FragmentDushareProfileBinding? = null
    private val binding get() = _binding!!
    private var isMyNotesTab = true

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDushareProfileBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val sharedPref = requireActivity().getSharedPreferences("user_pref", Context.MODE_PRIVATE)
        val username = sharedPref.getString("username", "Andrew") ?: "Andrew"
        binding.txtProfileName.text = username

        // Settings Button -> Opens Screen 7: Pengaturan
        binding.btnOpenSettings.setOnClickListener {
            val intent = Intent(requireContext(), DuShareSettingsActivity::class.java)
            startActivity(intent)
        }

        // Share Profile Button
        binding.btnShareProfile.setOnClickListener {
            val sendIntent = Intent().apply {
                action = Intent.ACTION_SEND
                putExtra(
                    Intent.EXTRA_TEXT,
                    "Lihat profil dan materi kuliah dari $username di EduShare: https://edushare.app/u/$username"
                )
                type = "text/plain"
            }
            startActivity(Intent.createChooser(sendIntent, "Bagikan Profil"))
        }

        // Edit Profile
        binding.btnEditProfile.setOnClickListener {
            Toast.makeText(requireContext(), "Edit Profil Mahasiswa", Toast.LENGTH_SHORT).show()
        }

        // Redeem Points
        binding.btnRedeemPoints.setOnClickListener {
            AlertDialog.Builder(requireContext())
                .setTitle("Tukar Poin EduShare")
                .setMessage("Anda memiliki 480 Poin EduShare. Tukar dengan voucher buku, sertifikat kontributor, atau langganan premium.")
                .setPositiveButton("Tukar Sekarang") { _, _ ->
                    Toast.makeText(requireContext(), "Permintaan penukaran poin diajukan!", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        // Setup My Notes RecyclerView
        val myNoteAdapter = MyNoteAdapter(
            DuShareMockData.userUploadedNotes,
            onMenuClick = { note ->
                val options = arrayOf("Edit Informasi", "Lihat Statistik", "Hapus Catatan")
                AlertDialog.Builder(requireContext())
                    .setTitle(note.title)
                    .setItems(options) { _, which ->
                        when (which) {
                            0 -> Toast.makeText(requireContext(), "Edit ${note.title}", Toast.LENGTH_SHORT).show()
                            1 -> Toast.makeText(requireContext(), "Statistik: ${note.downloadCount} unduhan, ★ ${note.rating}", Toast.LENGTH_SHORT).show()
                            2 -> Toast.makeText(requireContext(), "${note.title} dihapus", Toast.LENGTH_SHORT).show()
                        }
                    }
                    .show()
            },
            onItemClick = { note ->
                Toast.makeText(requireContext(), "Membuka ${note.title}", Toast.LENGTH_SHORT).show()
            }
        )
        binding.rvMyNotes.adapter = myNoteAdapter

        // Upload new note button
        binding.btnUploadNewNote.setOnClickListener {
            Toast.makeText(requireContext(), "Membuka form unggah catatan baru...", Toast.LENGTH_SHORT).show()
        }

        // Tab Switching: Materi Saya vs Tentang
        binding.tabMyNotes.setOnClickListener {
            if (!isMyNotesTab) {
                isMyNotesTab = true
                updateTabs()
            }
        }

        binding.tabAboutActivity.setOnClickListener {
            if (isMyNotesTab) {
                isMyNotesTab = false
                updateTabs()
            }
        }
    }

    private fun updateTabs() {
        val activeBg = ContextCompat.getDrawable(requireContext(), R.drawable.bg_dushare_pill_active)
        val inactiveBg = ContextCompat.getDrawable(requireContext(), R.drawable.bg_dushare_pill_inactive)
        val activeColor = ContextCompat.getColor(requireContext(), R.color.dushare_primary_container)
        val inactiveColor = ContextCompat.getColor(requireContext(), R.color.dushare_on_surface_variant)

        if (isMyNotesTab) {
            binding.tabMyNotes.background = activeBg
            binding.tabMyNotes.setTextColor(activeColor)
            binding.tabAboutActivity.background = inactiveBg
            binding.tabAboutActivity.setTextColor(inactiveColor)

            binding.layoutMyNotesContainer.visibility = View.VISIBLE
            binding.layoutAboutContainer.visibility = View.GONE
        } else {
            binding.tabMyNotes.background = inactiveBg
            binding.tabMyNotes.setTextColor(inactiveColor)
            binding.tabAboutActivity.background = activeBg
            binding.tabAboutActivity.setTextColor(activeColor)

            binding.layoutMyNotesContainer.visibility = View.GONE
            binding.layoutAboutContainer.visibility = View.VISIBLE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
