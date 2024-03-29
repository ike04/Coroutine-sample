package com.example.coroutine_sample

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.coroutine_sample.databinding.ListFragmentBinding
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder

class ListFragment : Fragment() {

    companion object {
        fun newInstance() = ListFragment()
    }

    private lateinit var binding: ListFragmentBinding
    private val viewModel: ListViewModel by viewModels()
    private val groupAdapter = GroupAdapter<GroupieViewHolder>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ListFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerView.adapter = groupAdapter

        viewModel.articleList?.observe(viewLifecycleOwner) { article ->
            article?.map { ArticleFactory(it) }?.let { groupAdapter.update(it) }
        }

        viewModel.error?.observe(viewLifecycleOwner) { error ->
            Toast.makeText(requireContext(), error.message, Toast.LENGTH_SHORT).show()
        }

        viewModel.fetchArticle("Kotlin", 1)
    }
}
