package com.example.project_uas_kel8.dushare.model

data class NoteModel(
    val id: String,
    val title: String,
    val subject: String,
    val semester: String,
    val author: String,
    val authorUniversity: String,
    val authorAvatarUrl: String = "",
    val rating: Double,
    val reviewCount: Int,
    val downloadCount: String,
    val fileType: String, // PDF, PPT, DOC
    val pageCount: String,
    val description: String = "",
    val timeAgo: String = "",
    var isBookmarked: Boolean = false,
    val category: String = "Rangkuman" // Rangkuman, Latihan Soal, Modul Kuliah
)
