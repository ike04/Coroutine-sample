package com.example.coroutine_sample

import android.view.View
import com.example.coroutine_sample.databinding.ViewListCellBinding
import com.google.gson.annotations.SerializedName
import com.xwray.groupie.viewbinding.BindableItem

class ArticleFactory(private val article: Article) :
    BindableItem<ViewListCellBinding>() {
    override fun getLayout() = R.layout.view_list_cell

    override fun bind(viewBinding: ViewListCellBinding, position: Int) {
        viewBinding.item = article
    }

    override fun initializeViewBinding(view: View): ViewListCellBinding {
        return ViewListCellBinding.bind(view)
    }

//    override fun isSameAs(other: Item<*>): Boolean = (other as? ArticleFactory)?.article?.id == article.id
}

data class Article(
    @SerializedName("likes_count")
    val likeCount: Int,
    val title: String,
    @SerializedName("updated_at")
    val updateDate: String,
    val url: String
)
