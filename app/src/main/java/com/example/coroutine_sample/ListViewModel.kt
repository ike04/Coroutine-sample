package com.example.coroutine_sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {
    private val repository = SearchRepositoryImpl()
    private val _articleList = MutableLiveData<List<Article>?>()
    val articleList = _articleList as LiveData<List<Article>?>

    fun fetchArticle(tag: String, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val articleList = repository.fetchArticles(tag, page)
                _articleList.postValue(articleList)
            } catch (e: Exception) {
            }
        }
    }
}
