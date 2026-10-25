package com.example.project_uas_kel8.dushare.data

import com.example.project_uas_kel8.dushare.model.CategoryModel
import com.example.project_uas_kel8.dushare.model.NoteModel
import com.example.project_uas_kel8.dushare.model.UserProfileModel

object DuShareMockData {
    val currentUser = UserProfileModel()

    val categories = listOf(
        CategoryModel("1", "Pemrograman", noteCount = 124),
        CategoryModel("2", "Basis Data", noteCount = 85),
        CategoryModel("3", "Jaringan Komputer", noteCount = 67),
        CategoryModel("4", "Statistika", noteCount = 42),
        CategoryModel("5", "Machine Learning", noteCount = 98),
        CategoryModel("6", "Multimedia", noteCount = 31)
    )

    val popularNotes = listOf(
        NoteModel(
            id = "pop_1",
            title = "Ringkasan Object Oriented Programming",
            subject = "Pemrograman",
            semester = "Semester 3",
            author = "Andi Pratama",
            authorUniversity = "ITB",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=11",
            rating = 4.8,
            reviewCount = 128,
            downloadCount = "1.4K",
            fileType = "PDF",
            pageCount = "34 Halaman",
            description = "Ringkasan lengkap mengenai 4 pilar OOP: Encapsulation, Abstraction, Inheritance, dan Polymorphism beserta implementasi Java/Kotlin.",
            timeAgo = "Trending Kampus",
            isBookmarked = true,
            category = "Rangkuman"
        ),
        NoteModel(
            id = "pop_2",
            title = "Catatan Kuliah: Supervised vs Unsupervised",
            subject = "Machine Learning",
            semester = "Semester 5",
            author = "Clara Wijaya",
            authorUniversity = "Universitas Indonesia",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=5",
            rating = 4.9,
            reviewCount = 94,
            downloadCount = "920",
            fileType = "PPT",
            pageCount = "42 Slide",
            description = "Slide visual mengenai perbandingan algoritma pembelajaran mesin terawasi vs tak terawasi lengkap dengan contoh dataset riil.",
            timeAgo = "Trending Kampus",
            isBookmarked = false,
            category = "Modul Kuliah"
        ),
        NoteModel(
            id = "pop_3",
            title = "Protokol TCP/IP & Pengalamatan Subnetting",
            subject = "Jaringan",
            semester = "Semester 3",
            author = "Budi Santoso",
            authorUniversity = "UGM",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=12",
            rating = 4.6,
            reviewCount = 64,
            downloadCount = "780",
            fileType = "PDF",
            pageCount = "50 Halaman",
            description = "Tutorial langkah demi langkah perhitungan CIDR, subnet mask, broadcast address, serta simulasi Cisco Packet Tracer.",
            timeAgo = "Trending Kampus",
            isBookmarked = false,
            category = "Rangkuman"
        )
    )

    val recentNotes = listOf(
        NoteModel(
            id = "rec_1",
            title = "Rangkuman Basis Data – Normalisasi",
            subject = "Basis Data",
            semester = "Semester 3",
            author = "Siti Rahma",
            authorUniversity = "UGM",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=9",
            rating = 4.7,
            reviewCount = 45,
            downloadCount = "1.2K",
            fileType = "PDF",
            pageCount = "22 Halaman",
            timeAgo = "2 jam lalu",
            isBookmarked = false,
            category = "Rangkuman"
        ),
        NoteModel(
            id = "rec_2",
            title = "Slide Presentasi Pengantar Jaringan & OSI Layer",
            subject = "Jaringan Komputer",
            semester = "Semester 3",
            author = "Budi Santoso",
            authorUniversity = "Universitas Indonesia",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=12",
            rating = 4.6,
            reviewCount = 38,
            downloadCount = "850",
            fileType = "PPT",
            pageCount = "30 Slide",
            timeAgo = "5 jam lalu",
            isBookmarked = false,
            category = "Modul Kuliah"
        ),
        NoteModel(
            id = "rec_3",
            title = "Latihan Soal Ujian Tengah Semester Statistika",
            subject = "Statistika",
            semester = "Semester 3",
            author = "Dewi Lestari",
            authorUniversity = "ITS",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=25",
            rating = 4.9,
            reviewCount = 88,
            downloadCount = "2.1K",
            fileType = "DOC",
            pageCount = "18 Halaman",
            timeAgo = "Kemarin",
            isBookmarked = true,
            category = "Latihan Soal"
        )
    )

    val searchResults = listOf(
        NoteModel(
            id = "search_1",
            title = "Machine Learning Dasar – Supervised Learning",
            subject = "Machine Learning",
            semester = "Semester 5",
            author = "Budi Santoso",
            authorUniversity = "Universitas Indonesia",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=12",
            rating = 4.9,
            reviewCount = 86,
            downloadCount = "324",
            fileType = "PDF",
            pageCount = "48 Halaman",
            description = "Ringkasan materi komprehensif mengenai konsep klasifikasi dan regresi dilengkapi studi kasus Python scikit-learn, evaluasi matriks, dan visualisasi boundary.",
            timeAgo = "3 hari lalu",
            isBookmarked = true,
            category = "Rangkuman"
        ),
        NoteModel(
            id = "search_2",
            title = "Deep Learning & Neural Networks: Konsep Backpropagation",
            subject = "Kecerdasan Buatan",
            semester = "Semester 6",
            author = "Maya Safitri",
            authorUniversity = "Institut Teknologi Bandung",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=26",
            rating = 4.8,
            reviewCount = 142,
            downloadCount = "512",
            fileType = "PDF",
            pageCount = "62 Halaman",
            description = "Penjelasan matematis langkah demi langkah turunan fungsi loss, gradient descent, aktivasi ReLU & Sigmoid, serta implementasi perceptron multi-layer.",
            timeAgo = "5 hari lalu",
            isBookmarked = false,
            category = "Rangkuman"
        ),
        NoteModel(
            id = "search_3",
            title = "Slide Presentasi Unsupervised Learning: Clustering K-Means",
            subject = "Machine Learning",
            semester = "Semester 5",
            author = "Kevin Wijaya",
            authorUniversity = "Universitas Gadjah Mada",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=33",
            rating = 4.7,
            reviewCount = 48,
            downloadCount = "198",
            fileType = "PPT",
            pageCount = "35 Slide",
            description = "Slide presentasi seminar kelas mengenai algoritma clustering tak terawasi, penentuan nilai K optimal menggunakan Elbow Method, dan Silhouette Score.",
            timeAgo = "1 minggu lalu",
            isBookmarked = false,
            category = "Modul Kuliah"
        ),
        NoteModel(
            id = "search_4",
            title = "Kumpulan Latihan Soal & Pembahasan UTS Machine Learning",
            subject = "Latihan Soal",
            semester = "Semester 5",
            author = "Asisten Lab AI",
            authorUniversity = "Fakultas Ilmu Komputer",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=49",
            rating = 4.9,
            reviewCount = 310,
            downloadCount = "840",
            fileType = "DOC",
            pageCount = "24 Halaman",
            description = "Koleksi 50+ latihan soal teori probabilitas, Bayes Theorem, Decision Trees, overfitting vs underfitting lengkap dengan kunci jawaban dan pembahasan.",
            timeAgo = "2 minggu lalu",
            isBookmarked = false,
            category = "Latihan Soal"
        )
    )

    val savedNotes = listOf(
        NoteModel(
            id = "saved_1",
            title = "Machine Learning Dasar – Supervised Learning",
            subject = "Machine Learning",
            semester = "Semester 5",
            author = "Budi Santoso",
            authorUniversity = "UI",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=12",
            rating = 4.9,
            reviewCount = 86,
            downloadCount = "324",
            fileType = "PDF",
            pageCount = "48 Hal",
            timeAgo = "Disimpan 2 hari lalu",
            isBookmarked = true,
            category = "Rangkuman"
        ),
        NoteModel(
            id = "saved_2",
            title = "Ringkasan Object Oriented Programming & Design Patterns",
            subject = "Pemrograman",
            semester = "Semester 3",
            author = "Andi Pratama",
            authorUniversity = "ITB",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=11",
            rating = 4.8,
            reviewCount = 128,
            downloadCount = "1.4K",
            fileType = "PDF",
            pageCount = "34 Hal",
            timeAgo = "Disimpan 5 hari lalu",
            isBookmarked = true,
            category = "Rangkuman"
        ),
        NoteModel(
            id = "saved_3",
            title = "Kumpulan Latihan Soal & Pembahasan UTS Basis Data",
            subject = "Basis Data",
            semester = "Semester 3",
            author = "Siti Rahma",
            authorUniversity = "UGM",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=9",
            rating = 4.9,
            reviewCount = 92,
            downloadCount = "450",
            fileType = "DOC",
            pageCount = "26 Hal",
            timeAgo = "Disimpan 1 minggu lalu",
            isBookmarked = true,
            category = "Latihan Soal"
        ),
        NoteModel(
            id = "saved_4",
            title = "Slide Presentasi Algoritma Greedy & Dynamic Programming",
            subject = "Statistika & Algoritma",
            semester = "Semester 4",
            author = "Kevin Wijaya",
            authorUniversity = "UGM",
            authorAvatarUrl = "https://i.pravatar.cc/150?img=33",
            rating = 4.7,
            reviewCount = 54,
            downloadCount = "210",
            fileType = "PPT",
            pageCount = "36 Slide",
            timeAgo = "Disimpan 2 minggu lalu",
            isBookmarked = true,
            category = "Modul Kuliah"
        )
    )

    val userUploadedNotes = listOf(
        NoteModel(
            id = "user_1",
            title = "Ringkasan Object Oriented Programming",
            subject = "Pemrograman • Dipublikasikan",
            semester = "Semester 3",
            author = "Andrew",
            authorUniversity = "Universitas XYZ",
            rating = 4.8,
            reviewCount = 128,
            downloadCount = "140",
            fileType = "PDF",
            pageCount = "34 Halaman",
            timeAgo = "2 hari yang lalu",
            isBookmarked = false,
            category = "Rangkuman"
        ),
        NoteModel(
            id = "user_2",
            title = "Catatan Kuliah Struktur Data & Algoritma: Graph & Tree",
            subject = "Pemrograman • Dipublikasikan",
            semester = "Semester 3",
            author = "Andrew",
            authorUniversity = "Universitas XYZ",
            rating = 4.9,
            reviewCount = 42,
            downloadCount = "110",
            fileType = "PDF",
            pageCount = "28 Halaman",
            timeAgo = "1 minggu yang lalu",
            isBookmarked = false,
            category = "Rangkuman"
        ),
        NoteModel(
            id = "user_3",
            title = "Latihan Soal Algoritma Pemrograman Semester 3",
            subject = "Pemrograman • Dipublikasikan",
            semester = "Semester 3",
            author = "Andrew",
            authorUniversity = "Universitas XYZ",
            rating = 4.7,
            reviewCount = 25,
            downloadCount = "70",
            fileType = "DOCX",
            pageCount = "18 Halaman",
            timeAgo = "2 minggu yang lalu",
            isBookmarked = false,
            category = "Latihan Soal"
        )
    )
}
