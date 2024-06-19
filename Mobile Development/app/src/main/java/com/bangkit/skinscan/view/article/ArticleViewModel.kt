package com.bangkit.skinscan.view.article

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.bangkit.skinscan.data.remote.response.Article
import com.bangkit.skinscan.data.repository.Repository

class ArticleViewModel(repository: Repository): ViewModel() {
    val article: LiveData<PagingData<Article>> =
        repository.getArticle().cachedIn(viewModelScope)
}