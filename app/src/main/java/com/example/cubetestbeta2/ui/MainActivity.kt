package com.example.cubetestbeta2.ui

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.core.view.isVisible
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.findNavController
import com.example.cubetestbeta2.R
import com.example.cubetestbeta2.databinding.ActivityMainBinding
import com.example.cubetestbeta2.ui.attraction.AttractionFragmentArgs
import com.example.cubetestbeta2.vm.MainViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModel()
    private val navController by lazy {
        findNavController(R.id.nav_host_fragment)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    override fun onStart() {
        super.onStart()
        setNavigation()
        setEventClick()
    }

    private fun setEventClick() {
        // 返回
        binding.ibBack.setOnClickListener {
            navController.navigateUp()
        }
    }

    private fun setNavigation() {
        navController.addOnDestinationChangedListener { _, destination, bundle ->
            binding.ibMenu.visibility = if (destination.id == R.id.listFragment) View.VISIBLE else View.INVISIBLE
            binding.ibBack.visibility = if (destination.id != R.id.listFragment) View.VISIBLE else View.INVISIBLE
            // 旅遊景點的Title要根據景點名稱顯示
            if (destination.id == R.id.listFragment) {
                binding.tvTitle.text = destination.label
            } else {
                binding.tvTitle.text = bundle?.getString("title")
            }
        }
    }
}