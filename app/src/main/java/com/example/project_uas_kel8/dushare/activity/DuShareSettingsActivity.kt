package com.example.project_uas_kel8.dushare.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.project_uas_kel8.databinding.ActivityDushareSettingsBinding

class DuShareSettingsActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDushareSettingsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        binding = ActivityDushareSettingsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.root) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(0, systemBars.top, 0, systemBars.bottom)
            insets
        }

        binding.btnSettingsBack.setOnClickListener {
            finish()
        }

        binding.btnSettingsMore.setOnClickListener {
            Toast.makeText(this, "Opsi Pengaturan", Toast.LENGTH_SHORT).show()
        }

        binding.rowEditProfile.setOnClickListener {
            Toast.makeText(this, "Buka Form Edit Profil", Toast.LENGTH_SHORT).show()
        }

        binding.rowChangePassword.setOnClickListener {
            Toast.makeText(this, "Buka Form Ubah Password", Toast.LENGTH_SHORT).show()
        }

        binding.rowLanguage.setOnClickListener {
            val languages = arrayOf("Bahasa Indonesia (Aktif)", "English")
            AlertDialog.Builder(this)
                .setTitle("Pilih Bahasa")
                .setItems(languages) { _, which ->
                    Toast.makeText(this, "Bahasa diubah ke ${languages[which]}", Toast.LENGTH_SHORT).show()
                }
                .show()
        }

        binding.rowAbout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Tentang EduShare")
                .setMessage("EduShare adalah platform akademik peer-to-peer terkemuka bagi mahasiswa untuk saling berbagi catatan kuliah terstruktur, rangkuman ujian, dan materi presentasi.")
                .setPositiveButton("Tutup", null)
                .show()
        }

        binding.rowFaq.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Bantuan & FAQ")
                .setMessage("Pusat bantuan seputar cara mengunggah dokumen, klaim poin kontributor, dan sistem verifikasi mahasiswa.")
                .setPositiveButton("Tutup", null)
                .show()
        }

        binding.switchNotifications.setOnCheckedChangeListener { _, isChecked ->
            val msg = if (isChecked) "Notifikasi diskusi diaktifkan" else "Notifikasi diskusi dinonaktifkan"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        binding.switchWifiOnly.setOnCheckedChangeListener { _, isChecked ->
            val msg = if (isChecked) "Unduhan hanya melalui Wi-Fi" else "Unduhan via data seluler diizinkan"
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
        }

        // Logout
        binding.btnLogout.setOnClickListener {
            AlertDialog.Builder(this)
                .setTitle("Keluar Akun")
                .setMessage("Apakah Anda yakin ingin keluar dari akun EduShare?")
                .setPositiveButton("Keluar") { dialog, _ ->
                    val sharedPref = getSharedPreferences("user_pref", MODE_PRIVATE)
                    sharedPref.edit().clear().apply()
                    dialog.dismiss()

                    val intent = Intent(this, DuShareLoginActivity::class.java)
                    intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                    startActivity(intent)
                    finish()
                }
                .setNegativeButton("Batal", null)
                .show()
        }
    }
}
