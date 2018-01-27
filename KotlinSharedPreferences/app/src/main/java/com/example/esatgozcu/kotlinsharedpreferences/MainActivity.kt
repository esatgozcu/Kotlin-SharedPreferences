package com.example.esatgozcu.kotlinsharedpreferences

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }
    // Ekle butonuna basılınca..
    fun add(view: View)
    {
        // sharedPreferences nesnemizi oluşturuyoruz.
        val sharedPreferences = this.getSharedPreferences(packageName,android.content.Context.MODE_PRIVATE)

        val name = nameText.text.toString()

        val age  = ageText.text.toString().toInt()

        // Verimizi name anahtar kelimesi ile ekliyoruz
        sharedPreferences.edit().putString("name", name).apply()

        // Verimizi age anahtar kelimesi ile ekliyoruz
        sharedPreferences.edit().putInt("age",age).apply()

        // EditTextleri temizliyoruz
        nameText.setText("")
        ageText.setText("")

    }
    // Göster butonuna basılınca..
    fun show(view: View)
    {
        val sharedPreferences = this.getSharedPreferences(packageName,android.content.Context.MODE_PRIVATE)

        // name anahtar kelimesinin verisini çekiyoruz, ikinci parametre default değer
        val showName = sharedPreferences.getString("name","isimsiz")

        // age anahtar kelimesinin verisini çekiyoruz, ikinci parametre default değer
        val showAge = sharedPreferences.getInt("age",0)

        // Toast mesajını gösteriyoruz
        Toast.makeText(applicationContext,"İsim : $showName - Yaş : $showAge",Toast.LENGTH_LONG).show()

    }
    // Sil butonuna basılınca..
    fun remove(view: View)
    {
        val sharedPreferences = this.getSharedPreferences(packageName,android.content.Context.MODE_PRIVATE)

        // Anahtar kelimemize göre verileri kaldırıyoruz
        sharedPreferences.edit().remove("name").apply()
        sharedPreferences.edit().remove("age").apply()

    }
}
