package com.example.lat5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room

class RoomTry : AppCompatActivity() {

    private lateinit var db: AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi database Room
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "example-database"
        ).build()

        // Contoh penggunaan database Room
        val userDao = db.userDao()

        // Menambahkan pengguna baru
        val user = User(1, "John Doe")
        userDao.insert(user)

        // Mendapatkan daftar pengguna
        val users = userDao.getAll()

        // Lakukan sesuatu dengan daftar pengguna
    }
}

}