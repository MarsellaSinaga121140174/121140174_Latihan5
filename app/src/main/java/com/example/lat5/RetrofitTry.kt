package com.example.lat5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitTry : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://api.example.com/") // Ganti dengan base URL yang sesuai
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        // Membuat instance layanan Retrofit
        val service = retrofit.create(ApiService::class.java)

        // Memanggil endpoint yang diinginkan
        val call = service.getSomeData()

        // Membuat panggilan asynchronous
        call.enqueue(object : Callback<SomeData> {
            override fun onResponse(call: Call<SomeData>, response: Response<SomeData>) {
                if (response.isSuccessful) {
                    // Data berhasil diterima
                    val someData = response.body()
                    // Lakukan sesuatu dengan data yang diterima
                } else {
                    // Gagal mendapatkan data, tindakan perbaikan
                }
            }

            override fun onFailure(call: Call<SomeData>, t: Throwable) {
                // Gagal melakukan panggilan jaringan, tindakan perbaikan
            }
        })
    }
}
