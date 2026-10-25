package com.example.project_uas_kel8.dushare.model

data class UserProfileModel(
    val name: String = "Andrew",
    val email: String = "andrew@mahasiswa.pcr.ac.id",
    val major: String = "Teknik Informatika",
    val university: String = "Politeknik Caltex Riau",
    val semester: String = "Semester 5",
    val avatarUrl: String = "https://images.unsplash.com/photo-1535713875002-d1d0cf377fde?auto=format&fit=crop&w=200&q=80",
    val isVerified: Boolean = true,
    val sharedNotesCount: Int = 12,
    val averageRating: Double = 4.8,
    val totalDownloads: Int = 320,
    val rewardPoints: Int = 480,
    val bio: String = "Mahasiswa semester 5 Teknik Informatika yang senang membagi ringkasan kuliah terstruktur dan bank soal ujian. Fokus minat pada Rekayasa Perangkat Lunak dan Cloud Computing."
)
