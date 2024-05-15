package com.example.cubetestbeta2.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.cubetestbeta2.databinding.FragmentListBinding
import com.example.cubetestbeta2.vm.MainViewModel
import com.example.cubetestbeta2.vo.attraction.Attraction
import com.example.cubetestbeta2.vo.news.News
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.activityViewModel

class ListFragment : Fragment() {
    private var _binding: FragmentListBinding? = null
    private val binding: FragmentListBinding get() = _binding!!
    private val viewModel: MainViewModel by activityViewModel()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentListBinding.inflate(inflater, container, false)
        val view = binding.root
        // Inflate the layout for this fragment
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observe() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.uiState.collect {
                    showLoading(it.isLoading)
                    setNewsList(it.news)
                    if (it.attractions.isEmpty()) {

                    }
                    setAttractionList(it.attractions)
                }
            }
        }
    }

    private fun showLoading(isShow: Boolean) {
        binding.progressBar.isVisible = isShow
    }

    private fun setNewsList(news: List<News>) {
        val adapter = NewsAdapter(news = news, showItems = NewsAdapter.HOME_COUNT) {
            goToNewDetail(it)
        }
        binding.rvNews.layoutManager = LinearLayoutManager(requireContext())
        binding.rvNews.adapter = adapter
    }

    private fun setAttractionList(attractions: List<Attraction>) {
        val adapter = AttractionAdapter(attractions = attractions)
        binding.rvAttraction.layoutManager = LinearLayoutManager(requireContext())
        binding.rvAttraction.adapter = adapter
    }

    /**
     * 前往訊息頁面
     */
    private fun goToNewDetail(news: News) {
        val directions = ListFragmentDirections.toNewsFragment(news.url)
        findNavController().navigate(directions)
    }

    companion object {
    }
}