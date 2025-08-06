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

## 🧠 Cara Kerja RecyclerView
RecyclerView adalah komponen Android yang digunakan untuk menampilkan daftar data dalam bentuk list atau grid secara efisien. Ia menggantikan ListView dengan pendekatan yang lebih modular dan hemat memori.
## ⚙️ Komponen Utama dalam RecyclerView:
- Adapter: Menyediakan data dan mengatur bagaimana tiap item ditampilkan.
- ViewHolder: Menyimpan referensi view agar tidak perlu mencari ulang (findViewById).
- LayoutManager: Menentukan tata letak list (linear, grid, staggered, dll).

## 🔁 Alur Kerja RecyclerView di Aplikasi Ini
  1. Data Siswa disiapkan oleh DummyData.getStudentList() → menghasilkan List<Student>.
  2. Adapter (StudentAdapter):
    - Menerima daftar data.
    - Menciptakan tampilan untuk setiap item (onCreateViewHolder).
    - Mengisi data ke tampilan (onBindViewHolder).
  3. ViewHolder:
    - Digunakan untuk menyimpan referensi komponen dalam item_student.xml seperti:
      - TextView untuk nama, NIS, kelas
      - ImageView untuk ikon siswa
  4. Klik Item:
     - Saat item diklik:
      - Tampilkan Toast dan AlertDialog
      - Jika disetujui, navigasi ke DetailActivity lewat Intent sambil membawa data siswa
  5. LayoutManager:
     - Digunakan LinearLayoutManager → menampilkan list secara vertikal.

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

## ✨ Fitur Baru yang Ditambahkan

### ✅ 1. Menambahkan 10 Data Siswa
- Data dummy ditambahkan di file: `DummyData.kt`
- Setiap siswa memiliki informasi:
  - Nama
  - NIS
  - Kelas
  - **Jurusan**
  - **Sekolah**

### 🔍 2. Fitur Search / Filter
- Menambahkan `SearchView` di `MainActivity`
- Pengguna dapat mencari siswa berdasarkan **nama**
- Data akan difilter secara **langsung (real-time)** di `RecyclerView`

### 🌙 3. Dukungan Dark Mode
- Menambahkan file `colors.xml` untuk mode terang dan `values-night/colors.xml` untuk mode gelap
- UI akan otomatis menyesuaikan sesuai dengan **preferensi sistem pengguna**

### 🧾 4. Menampilkan Detail Siswa Lengkap
- Saat item siswa diklik, akan muncul dialog konfirmasi
- Jika pengguna memilih "Lihat", maka akan diarahkan ke `DetailActivity`
- Menampilkan:
  - Nama
  - NIS
  - Kelas
  - Jurusan
  - Sekolah

## 🛠️ File yang Dimodifikasi / Ditambahkan

| File | Deskripsi |
|------|-----------|
| `Student.kt` | Menambahkan field `jurusan` dan `sekolah` |
| `DummyData.kt` | Menambahkan 10 data siswa lengkap |
| `StudentAdapter.kt` | Menambahkan filter, binding jurusan & sekolah |
| `item_student.xml` | Menambahkan `TextView` jurusan dan sekolah |
| `activity_main.xml` | Menambahkan `SearchView` |
| `MainActivity.kt` | Menambahkan logika pencarian |
| `activity_detail.xml` | Menampilkan info lengkap siswa |
| `DetailActivity.kt` | Mendukung tampilan tambahan |
| `colors.xml` & `colors-night.xml` | Dukungan dark mode |

## 📸 Screenshot


  
