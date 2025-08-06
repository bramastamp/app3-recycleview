# Project RecyclerView

Ini adalah proyek sederhana untuk belajar RecyclerView menggunakan Git & Android Studio

## 👥 Tim
- Bramasta Marga Pangukuh
- Galang Surya Admaja
- Andika Andromeda
  
## 📱 Fitur-fitur yang sudah ada
### Halaman Utama
- Menampilkan daftar siswa:
  - Nama
  - NIS
  - Kelas

### Popup Konfirmasi
- Setelah item diklik, muncul `AlertDialog`:
  - **Lihat** → Menuju halaman detail
  - **Batal** → Menutup dialog

### Halaman Detail
- Menampilkan:
  - Foto siswa
  - Nama lengkap
  - NIS
  - Kelas

## 🔧 Teknologi
- Kotlin
- Android Studio
- Git + GitHub

## 📁 Struktur file dan alur data
<img width="251" height="451" alt="image" src="https://github.com/user-attachments/assets/1341b87a-0a74-4b67-a399-6f0ff0be994a" />


### 1. **MainActivity**
- Memanggil data dari `DummyData.getStudentList()`.
- Menginisialisasi `RecyclerView`.
- Mengatur `StudentAdapter` sebagai adapter.

```kotlin
recyclerView.adapter = StudentAdapter(this, DummyData.getStudentList())
```

### 2. **DummyData.kt**
- Menyediakan data siswa berupa list objek Student.
```
listOf(
    Student("Andi", "123456", "XII TJKT 1"),
    Student("Okta", "123456", "XII TJKT 1"),
    Student("Soli", "123456", "XII TJKT 1")
)
```

### 3. **StudentAdapter.kt**
- Menyediakan data siswa berupa list objek Student.
- Mengatur tampilan tiap siswa dalam item_student.xml.
- Menampilkan nama, NIS, dan kelas.
- Saat item diklik:
  - Menampilkan Toast
  - Menampilkan AlertDialog → jika "Lihat" ditekan, buka DetailActivity dan kirim data lewat Intent.
```
intent.putExtra("student_nama", student.nama)
intent.putExtra("student_nis", student.nis)
intent.putExtra("student_kelas", student.kelas)
```

### 4. **DetailActivity.kt**
- Menyediakan data siswa berupa list objek Student.
- Menerima data Intent dari adapter.
- Menampilkan nama, NIS, dan kelas pada layout activity_detail.xml.
```
val nama = intent.getStringExtra("student_nama")
tvNama.text = nama
```

 


## 📸 Screenshot


  
