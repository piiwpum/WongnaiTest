package com.piiwpum.wongnaitest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.piiwpum.wongnaitest.databinding.ActivityMainBinding
import com.piiwpum.wongnaitest.model.ResponseModel
import com.piiwpum.wongnaitest.ui.adapter.CoinAdapter
import com.piiwpum.wongnaitest.ui.view_model.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class MainActivity : AppCompatActivity() {
    private val mainViewModel: MainViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initViewModel()

    }


    fun initViewModel() {
        mainViewModel.responseModel.observe(this, response)
    }

    private var response = Observer<ResponseModel> {
        binding.rvCoin.layoutManager = LinearLayoutManager(this)
        binding.rvCoin.adapter = CoinAdapter(this, it.data.coins)
    }


}