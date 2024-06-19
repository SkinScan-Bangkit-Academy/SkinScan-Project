package com.bangkit.skinscan.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.bangkit.skinscan.databinding.FragmentArticleBinding
import com.bangkit.skinscan.view.ViewModelFactory
import com.bangkit.skinscan.view.article.adapter.ArticleListAdapter
import com.bangkit.skinscan.view.article.ArticleViewModel
import com.bangkit.skinscan.view.article.adapter.LoadingStateAdapter

class ArticleFragment : Fragment() {

    private lateinit var binding: FragmentArticleBinding
    private val articleViewModel by viewModels<ArticleViewModel> { ViewModelFactory.getInstance(requireContext()) }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentArticleBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvArticle.layoutManager = LinearLayoutManager(requireContext())
        binding.rvArticle.addItemDecoration(DividerItemDecoration(requireContext(), LinearLayoutManager(requireContext()).orientation))


        getArticle()
    }

    private fun getArticle(){
        val adapter = ArticleListAdapter()
        binding.rvArticle.adapter = adapter.withLoadStateFooter(
            footer = LoadingStateAdapter{
                adapter.retry()
            }
        )
        articleViewModel.article.observe(viewLifecycleOwner){
            adapter.submitData(lifecycle, it)
        }
    }

}