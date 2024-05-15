package com.example.cubetest.ui

import android.app.AlertDialog
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.findNavController
import com.example.cubetest.R
import com.example.cubetest.databinding.ActivityMainBinding
import com.example.cubetest.vm.MainViewModel
import com.example.cubetest.vo.Language
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
        // 選擇語言
        binding.ibMenu.setOnClickListener {
            showLanguageDialog()
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


    /**
     * 顯示更改語言Dialog
     */
    private fun showLanguageDialog() {
        val builder: AlertDialog.Builder = AlertDialog.Builder(this)
        val languages = Language.entries
        val languageTexts = languages.map { it.languageName }.toTypedArray()
        builder.setTitle(getString(R.string.set_language))
            .setItems(languageTexts) { dialog, which ->
                viewModel.setLanguageCode(languages[which])
                dialog.dismiss()
            }
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}