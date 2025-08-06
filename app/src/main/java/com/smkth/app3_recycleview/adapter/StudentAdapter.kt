package com.smkth.app3_recycleview.adapter

import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.view.*
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.smkth.app3_recycleview.DetailActivity
import com.smkth.app3_recycleview.R
import com.smkth.app3_recycleview.model.Student
import android.widget.EditText



class StudentAdapter(
    private val context: Context,
    private val studentList: MutableList<Student>

) : RecyclerView.Adapter<StudentAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvName: TextView = itemView.findViewById(R.id.tvNama)
        val tvNis: TextView = itemView.findViewById(R.id.tvNis)
        val tvKelas: TextView = itemView.findViewById(R.id.tvKelas)
        val tvJurusan: TextView = itemView.findViewById(R.id.tvJurusan)
        val tvSekolah: TextView = itemView.findViewById(R.id.tvSekolah)
        val btnEdit: Button = itemView.findViewById(R.id.btnEdit)
        val btnHapus: Button = itemView.findViewById(R.id.btnHapus)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.item_student, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = studentList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val student = studentList[position]
        holder.tvName.text = student.nama
        holder.tvNis.text = "NIS: ${student.nis}"
        holder.tvKelas.text = "Kelas: ${student.kelas}"
        holder.tvJurusan.text = "Jurusan: ${student.jurusan}"
        holder.tvSekolah.text = "Sekolah: ${student.sekolah}"

        holder.itemView.setOnClickListener {
            Toast.makeText(context, "Memilih ${student.nama}", Toast.LENGTH_SHORT).show()

            val builder = AlertDialog.Builder(context)
            builder.setTitle("Lihat Detail?")
                .setMessage("Ingin melihat detail dari ${student.nama}?")
                .setPositiveButton("Lihat") { _, _ ->
                    val intent = Intent(context, DetailActivity::class.java)
                    intent.putExtra("student_nama", student.nama)
                    intent.putExtra("student_nis", student.nis)
                    intent.putExtra("student_kelas", student.kelas)
                    intent.putExtra("student_jurusan", student.jurusan)
                    intent.putExtra("student_sekolah", student.sekolah)
                    context.startActivity(intent)
                }
                .setNegativeButton("Batal", null)
                .show()
        }

        holder.btnHapus.setOnClickListener {
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
        }

        holder.btnEdit.setOnClickListener {
            val editView = LayoutInflater.from(context).inflate(R.layout.dialog_edit_student, null)
            val inputNama = editView.findViewById<EditText>(R.id.editNama)
            val inputKelas = editView.findViewById<EditText>(R.id.editKelas)
            val inputJurusan = editView.findViewById<EditText>(R.id.editJurusan)
            val inputSekolah = editView.findViewById<EditText>(R.id.editSekolah)

            inputNama.setText(student.nama)
            inputKelas.setText(student.kelas)
            inputJurusan.setText(student.jurusan)
            inputSekolah.setText(student.sekolah)

            AlertDialog.Builder(context)
                .setTitle("Edit Siswa")
                .setView(editView)
                .setPositiveButton("Simpan") { dialog, _ ->
                    val namaBaru = inputNama.text.toString().trim()
                    val kelasBaru = inputKelas.text.toString().trim()
                    val jurusanBaru = inputJurusan.text.toString().trim()
                    val sekolahBaru = inputSekolah.text.toString().trim()

                    if (namaBaru.isEmpty() || kelasBaru.isEmpty() || jurusanBaru.isEmpty() || sekolahBaru.isEmpty()) {
                        Toast.makeText(context, "Nama dan Kelas tidak boleh kosong!", Toast.LENGTH_SHORT).show()

                        notifyItemChanged(position)
                        return@setPositiveButton
                    }

                    studentList[position] = student.copy(
                        nama = namaBaru,
                        kelas = kelasBaru,
                        jurusan = jurusanBaru,
                        sekolah = sekolahBaru
                    )
                    notifyItemChanged(position)
                }
                .setNegativeButton("Batal", null)
                .show()
        }

    }
}