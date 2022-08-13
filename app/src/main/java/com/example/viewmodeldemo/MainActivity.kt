package com.example.viewmodeldemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class MainActivity : AppCompatActivity() {
//    var totalCount = 0
    private lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)

        //var totalCount = 0
        val countButton = findViewById<Button>(R.id.btnCount)
        val countTextView  = findViewById<TextView>(R.id.tvCount)
//        countTextView.text = viewModel.count.toString()
        viewModel.count.observe(this, Observer {
            countTextView.text = it.toString()
        })
        countButton.setOnClickListener {
            //totalCount += 1
            //++totalCount
            //countTextView.text = totalCount.toString()
            viewModel.updateCount()
        }

    }


}