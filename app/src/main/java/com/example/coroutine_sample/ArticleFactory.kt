package com.example.coroutine_sample

import android.view.View
import com.example.coroutine_sample.databinding.ViewListCellBinding
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
}
