package com.example.coroutine_sample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.HttpException
import java.net.UnknownHostException

class ListViewModel : ViewModel() {
    private val repository = SearchRepositoryImpl()
    private val _articleList = MutableLiveData<List<Article>?>()
    private val _error = MutableLiveData<Failure>()
    val articleList = _articleList as? LiveData<List<Article>?>
    val error = _error as? LiveData<Failure>

    fun fetchArticle(tag: String, page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            try {
                val articleList = repository.fetchArticles(tag, page)
                _articleList.postValue(articleList)
            } catch (e: Exception) {
                _error.postValue(Failure(e, e.toMessage()))
            }
        }
    }
}

data class Failure(
    val error: Throwable,
    val message: String
)

fun Throwable.toMessage(): String {
    return when (this) {
        is HttpException -> "エラーが発生しました。"
        is UnknownHostException -> "ネットワークに接続できません。"
        else -> "エラーが発生しました。"
    }
}
