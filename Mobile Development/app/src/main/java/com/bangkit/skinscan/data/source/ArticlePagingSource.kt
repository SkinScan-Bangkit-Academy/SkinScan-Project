package com.bangkit.skinscan.data.source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bangkit.skinscan.data.remote.ApiService
import com.bangkit.skinscan.data.remote.response.Article

class ArticlePagingSource(private val apiService: ApiService): PagingSource<Int, Article>() {

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, Article>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Article> {
        return try {
            val position = params.key ?: INITIAL_PAGE_INDEX
            val responseData = apiService.getArticle(position, params.loadSize)
            val articles = responseData.data.map { it.article }


            LoadResult.Page(
                data = articles,
                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
                nextKey = if (articles.isEmpty()) null else position + 1
            )
        } catch (exception: Exception){
            return LoadResult.Error(exception)
        }
    }
}