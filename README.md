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

## 🆕 Fitur Baru yang Ditambahkan

### ✅ 1. Tambah Data Siswa
- Menambahkan minimal 10 data siswa secara statis dari file `DummyData.kt`.
```
return listOf(
            Student("Andi", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Okta", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Soli", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Andika", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Andromeda", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Bramasta", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Marga", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Pangukuh", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Galang", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Surya", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan Pati"),
            Student("Admaja", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan"),
            Student("Joko", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan"),
            Student("Widodo", "123456", "XII TJKT 1", "TJKT", "SMK Tunas Harapan")
        )
```

### ✅ 2. Field Baru pada Setiap Siswa
- Menambahkan field:
  - **Jurusan**
  - **Sekolah**
- Field ini ditambahkan pada class `Student.kt`, ditampilkan di item list dan halaman detail.
```
data class Student(
    val nama: String,
    val nis: String,
    val kelas: String,
    val jurusan: String,
    val sekolah: String
)
```

### ✅ 3. Tombol Aksi per Siswa
- Menambahkan dua tombol baru di `item_student.xml`:
  - **Edit**
  - **Hapus**
```
<Button
    android:id="@+id/btnEdit"
    android:text="Edit"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>

<Button
    android:id="@+id/btnHapus"
    android:text="Hapus"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"/>
```

### ✅ 4. Fitur Edit
- Saat tombol "Edit" ditekan:
  - Muncul dialog `AlertDialog` menggunakan layout `dialog_edit_student.xml`.
  - Pengguna bisa mengubah `nama` dan `kelas`.
  - Validasi: input tidak boleh kosong.
- 🧩 Cuplikan Kode Edit (StudentAdapter.kt)
```
val editView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_student, null)
val inputNama = editView.findViewById<EditText>(R.id.editNama)
val inputKelas = editView.findViewById<EditText>(R.id.editKelas)

AlertDialog.Builder(context)
    .setTitle("Edit Siswa")
    .setView(editView)
    .setPositiveButton("Simpan") { _, _ ->
        val namaBaru = inputNama.text.toString().trim()
        val kelasBaru = inputKelas.text.toString().trim()

        if (namaBaru.isEmpty() || kelasBaru.isEmpty()) {
            Toast.makeText(context, "Input tidak boleh kosong!", Toast.LENGTH_SHORT).show()
            return@setPositiveButton
        }

        studentList[position] = student.copy(nama = namaBaru, kelas = kelasBaru)
        notifyItemChanged(position)
    }
    .setNegativeButton("Batal", null)
    .show()
```
- 🧩 Kode Layout: dialog_edit_student.xml
```
<LinearLayout ... >
    <EditText
        android:id="@+id/editNama"
        android:hint="Nama"
        ... />
    <EditText
        android:id="@+id/editKelas"
        android:hint="Kelas"
        ... />
</LinearLayout>
```

### ✅ 5. Fitur Hapus
- Saat tombol "Hapus" ditekan:
  - Muncul konfirmasi.
  - Jika disetujui, siswa dihapus dari daftar (RecyclerView diperbarui secara langsung).
- 🧩 Cuplikan Kode Hapus (StudentAdapter.kt)
```
AlertDialog.Builder(context)
    .setTitle("Hapus Siswa")
    .setMessage("Yakin ingin menghapus ${student.nama}?")
    .setPositiveButton("Ya") { _, _ ->
        studentList.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, studentList.size)
    }
    .setNegativeButton("Batal", null)
    .show()
```

### ✅ 6. Halaman Detail Diperluas
- Menampilkan semua informasi siswa, termasuk jurusan & sekolah.
- 🧩 Intent ke DetailActivity
```
intent.putExtra("student_jurusan", student.jurusan)
intent.putExtra("student_sekolah", student.sekolah)
```
- 🧩 Di DetailActivity.kt
```
val jurusan = intent.getStringExtra("student_jurusan")
val sekolah = intent.getStringExtra("student_sekolah")
tvJurusan.text = jurusan
tvSekolah.text = sekolah
```

## 📂 File-File Baru / Dimodifikasi

| File | Penjelasan |
|------|------------|
| `Student.kt` | Menambahkan field `jurusan` dan `sekolah`. |
| `DummyData.kt` | Menambahkan minimal 10 data siswa. |
| `StudentAdapter.kt` | Menambahkan tombol edit & hapus, logika edit dan hapus item. |
| `item_student.xml` | Menambahkan tampilan tombol edit & hapus serta text jurusan & sekolah. |
| `dialog_edit_student.xml` | Layout dialog untuk mengedit data siswa. |
| `DetailActivity.kt` | Menampilkan semua informasi siswa termasuk field tambahan. |
| `README.md` | Menjelaskan fitur-fitur tambahan (file ini). |

## 📸 Screenshot


  
