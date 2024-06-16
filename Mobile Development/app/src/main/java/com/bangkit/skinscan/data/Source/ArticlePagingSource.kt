package com.bangkit.skinscan.data.Source

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.bangkit.skinscan.data.remote.ApiService
import com.bangkit.skinscan.data.remote.response.LoginResponse

class ArticlePagingSource(private val apiService: ApiService): PagingSource<Int, LoginResponse>() {

    private companion object {
        const val INITIAL_PAGE_INDEX = 1
    }

    override fun getRefreshKey(state: PagingState<Int, LoginResponse>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, LoginResponse> {
        TODO()
//        return try {
//            val position = params.key ?: INITIAL_PAGE_INDEX
//            val responseData = apiService.getStories(position, params.loadSize)
//
//            LoadResult.Page(
//                data = responseData.listStory,
//                prevKey = if (position == INITIAL_PAGE_INDEX) null else position - 1,
//                nextKey = if (responseData.listStory.isEmpty()) null else position + 1
//            )
//        } catch (exception: Exception){
//            return LoadResult.Error(exception)
//        }
    }
}