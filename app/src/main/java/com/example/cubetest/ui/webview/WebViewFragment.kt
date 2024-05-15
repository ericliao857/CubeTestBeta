package com.example.cubetest.ui.webview

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import com.example.cubetest.databinding.FragmentWebviewBinding


/**
 * WebView頁面
 */
class WebViewFragment : Fragment() {
    private var _binding: FragmentWebviewBinding? = null
    private val binding: FragmentWebviewBinding get() = _binding!!
    private val args: WebViewFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWebviewBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initWebView(args.newsUrl)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initWebView(link: String) {
        val webSettings = binding.webview.settings
        webSettings.javaScriptEnabled = true
        binding.webview.webViewClient = WebViewClient()
        binding.webview.loadUrl(link)
    }

}