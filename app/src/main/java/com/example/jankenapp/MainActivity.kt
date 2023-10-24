package com.example.jankenapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.TextKeyListener.clear
import android.view.View
import androidx.core.content.edit
import androidx.preference.Preference
import androidx.preference.PreferenceManager
import com.example.jankenapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.gu.setOnClickListener { onJankenButtonTapped(it) }
        binding.choki.setOnClickListener { onJankenButtonTapped(it) }
        binding.pa.setOnClickListener { onJankenButtonTapped(it) }

        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit{
            clear()
        }
    }

    fun onJankenButtonTapped(view: View?){
        // 新しい画面を開くためのインテント（データ構造）を定義
        val intent = Intent(this, ResultActivity::class.java)
        // viewのidをインテントに格納する
        intent.putExtra("MY_HAND", view?.id)
        // 定義したインテントを起動する
        startActivity(intent)
    }
}