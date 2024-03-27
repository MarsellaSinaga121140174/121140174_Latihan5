package com.example.lat5

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class FirebaseTry : AppCompatActivity() {

    private lateinit var firebaseAnalytics: FirebaseAnalytics
    private lateinit var auth: FirebaseAuth
    private lateinit var firestore: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Inisialisasi Firebase Analytics
        firebaseAnalytics = FirebaseAnalytics.getInstance(this)

        // Inisialisasi Firebase Authentication
        auth = FirebaseAuth.getInstance()

        // Inisialisasi Firebase Firestore
        firestore = FirebaseFirestore.getInstance()

        // Contoh penggunaan Firebase Analytics
        val bundle = Bundle()
        bundle.putString(FirebaseAnalytics.Param.ITEM_ID, "1")
        bundle.putString(FirebaseAnalytics.Param.ITEM_NAME, "Example Item")
        bundle.putString(FirebaseAnalytics.Param.CONTENT_TYPE, "text")
        firebaseAnalytics.logEvent(FirebaseAnalytics.Event.SELECT_CONTENT, bundle)

        // Contoh penggunaan Firebase Authentication
        val currentUser = auth.currentUser
        if (currentUser != null) {
            // User telah masuk
            val email = currentUser.email
            // Lakukan sesuatu dengan email user
        } else {
            // User belum masuk, lakukan autentikasi
            // Misalnya, tampilkan layar login
        }

        // Contoh penggunaan Firebase Firestore
        val docRef = firestore.collection("users").document("exampleUser")
        docRef.get()
            .addOnSuccessListener { document ->
                if (document != null) {
                    // Dokumen ditemukan, lakukan sesuatu
                    val data = document.data
                    // Lakukan sesuatu dengan data yang ditemukan
                } else {
                    // Dokumen tidak ditemukan
                }
            }
            .addOnFailureListener { exception ->
                // Gagal mendapatkan dokumen, lakukan sesuatu
            }
    }
}
