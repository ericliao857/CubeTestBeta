package com.example.cubetestbeta2.ui.attraction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.RoundedCorners
import com.bumptech.glide.request.RequestOptions
import com.example.cubetestbeta2.R
import com.example.cubetestbeta2.databinding.FragmentAttractionBinding
import com.example.cubetestbeta2.tools.Tools.fromHtml
import com.example.cubetestbeta2.tools.Tools.toHtmlText
import com.example.cubetestbeta2.ui.list.ListFragmentDirections
import com.example.cubetestbeta2.vo.attraction.Attraction
import com.example.cubetestbeta2.vo.attraction.Image
import com.example.cubetestbeta2.vo.news.News
import com.youth.banner.adapter.BannerImageAdapter
import com.youth.banner.holder.BannerImageHolder
import com.youth.banner.indicator.CircleIndicator


/**
 * 旅遊景點頁面
 */
class AttractionFragment : Fragment() {
    private var _binding: FragmentAttractionBinding? = null
    private val binding: FragmentAttractionBinding get() = _binding!!
    private val args: AttractionFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAttractionBinding.inflate(inflater, container, false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initView() {
        initBanner(args.attraction.images)
        setAttraction(args.attraction)
    }

    /**
     * 設定景點相關UI
     */
    private fun setAttraction(attraction: Attraction) {
        binding.tvOpenTime.text = getString(R.string.open_time, attraction.openTime)
        binding.tvAddress.text = getString(R.string.address, attraction.address)
        binding.tvNumber.text = getString(R.string.number, attraction.tel)
        binding.tvWebsite.fromHtml(getString(R.string.website, attraction.officialSite))
        binding.tvWebsite.setOnClickListener {
            goToAttractionWebSite(attraction)
        }
        binding.tvInduction.text = attraction.introduction
    }

    /**
     * 滑動的照片
     * */
    private fun initBanner(images: List<Image>?) {
        binding.banner.setAdapter(object : BannerImageAdapter<Image?>(images) {
            override fun onBindView(
                holder: BannerImageHolder,
                data: Image?,
                position: Int,
                size: Int
            ) {
                data?.let {
                    Glide.with(holder.itemView)
                        .load(it.src)
                        .apply(RequestOptions.bitmapTransform(RoundedCorners(30)))
                        .into(holder.imageView)
                }
            }
        }).addBannerLifecycleObserver(this) //添加生命周期观察者
            .setIndicator(CircleIndicator(requireContext()))
    }

    /**
     * 前往旅遊景點網頁頁面
     */
    private fun goToAttractionWebSite(attraction: Attraction) {
        val directions = AttractionFragmentDirections.toWebViewFragment(attraction.officialSite, title = attraction.name)
        findNavController().navigate(directions)
    }
}