package com.nareshgediya.kotlinmvvmnasic

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nareshgediya.kotlinmvvmnasic.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    lateinit var mainVIewModel: MainVIewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        val dao = QuoteDatabse.getDatabase(applicationContext).quoteDao()
        val repository = QuoteRepository(dao)
        mainVIewModel = ViewModelProvider(this,MainViewModelFactory(repository)).get(MainVIewModel::class.java)

        mainVIewModel.getQuotes().observe(this,{
            binding.qoutes = it.toString()
            Toast.makeText(this, binding.qoutes, Toast.LENGTH_SHORT).show()
        })
        binding.btnAdd.setOnClickListener {
            val quote  = Quote(0,"This Test ","Naresh")
            mainVIewModel.insertQuotes(quote)
        }
    }
}