package com.example.project_uas_kel8.dushare.activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import com.example.project_uas_kel8.R
import com.example.project_uas_kel8.databinding.ActivityDushareMainBinding
import com.example.project_uas_kel8.dushare.fragment.DuShareHomeFragment
import com.example.project_uas_kel8.dushare.fragment.DuShareProfileFragment
import com.example.project_uas_kel8.dushare.fragment.DuShareSavedFragment

class DuShareMainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDushareMainBinding
    private var currentTabIndex = 0 // 0: Home, 1: Saved, 2: Profile

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDushareMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.dushareMainRoot) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, 0)
            insets
        }

        // Top Nav Right Actions
        binding.btnTopNavNotifications.setOnClickListener {
            Toast.makeText(this, "Tidak ada notifikasi baru", Toast.LENGTH_SHORT).show()
        }

        binding.imgTopNavAvatar.setOnClickListener {
            selectTab(2) // Profile
        }

        // Bottom Nav Tabs
        binding.tabHome.setOnClickListener {
            selectTab(0)
        }

        binding.tabExplore.setOnClickListener {
            val intent = Intent(this, DuShareSearchActivity::class.java)
            startActivity(intent)
        }

        // Center Elevated '+' FAB (Matching Stitch Design)
        binding.fabAddMaterial.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Unggah Materi Baru")
                .setMessage("Bagikan catatan kuliah, rangkuman, atau latihan soal Anda ke komunitas mahasiswa EduShare.")
                .setPositiveButton("Pilih Berkas") { _, _ ->
                    Toast.makeText(this, "Membuka pengelola berkas...", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        binding.tabSaved.setOnClickListener {
            selectTab(1)
        }

        binding.tabProfile.setOnClickListener {
            selectTab(2)
        }

        // Initial tab: Home
        selectTab(0)
    }

    fun navigateToTab(tabIndex: Int) {
        selectTab(tabIndex)
    }

    private fun selectTab(index: Int) {
        currentTabIndex = index
        updateTabVisuals()

        when (index) {
            0 -> {
                binding.txtTopNavTitle.text = "Home"
                replaceFragment(DuShareHomeFragment())
            }
            1 -> {
                binding.txtTopNavTitle.text = "Materi Tersimpan"
                replaceFragment(DuShareSavedFragment())
            }
            2 -> {
                binding.txtTopNavTitle.text = "Profil Mahasiswa"
                replaceFragment(DuShareProfileFragment())
            }
        }
    }

    private fun updateTabVisuals() {
        val activeColor = ContextCompat.getColor(this, R.color.dushare_primary_container)
        val inactiveColor = ContextCompat.getColor(this, R.color.dushare_text_muted)

        fun setItem(icon: ImageView, label: TextView, isActive: Boolean) {
            icon.setColorFilter(if (isActive) activeColor else inactiveColor)
            label.setTextColor(if (isActive) activeColor else inactiveColor)
        }

        setItem(binding.iconTabHome, binding.labelTabHome, currentTabIndex == 0)
        setItem(binding.iconTabExplore, binding.labelTabExplore, false)
        setItem(binding.iconTabSaved, binding.labelTabSaved, currentTabIndex == 1)
        setItem(binding.iconTabProfile, binding.labelTabProfile, currentTabIndex == 2)
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.fragmentContainer.id, fragment)
            .commit()
    }
}
