package com.vosker.technicaltest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.vosker.technicaltest.common.Status
import org.koin.androidx.viewmodel.ext.android.viewModel
import com.vosker.technicaltest.databinding.FragmentJokesBinding
import com.vosker.technicaltest.ui.model.JokeUiModel
import androidx.recyclerview.widget.DividerItemDecoration

class JokeFragment : Fragment() {

    private val viewModel by viewModel<JokeViewModel>()

    private var binding: FragmentJokesBinding? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentJokesBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        getJokes()
    }

    private fun getJokes() {
        viewModel.getJokes().observe(requireActivity(), { resource ->
            when (resource.status) {
                Status.Loading -> {
                    setProgress(true)
                }
                Status.Success -> {
                    setProgress(false)
                    resource.data?.let { jokeUiModelList ->
                        setupRecyclerView(jokeUiModelList)
                    }
                }
                Status.Error -> {
                    setProgress(false)
                }
            }
        })
    }

    private fun setupRecyclerView(jokeUiModelList: List<JokeUiModel>) {
        binding?.recyclerView?.apply {
            while (this.itemDecorationCount > 0) {
                this.removeItemDecorationAt(0)
            }
            this.layoutManager =
                LinearLayoutManager(context, RecyclerView.VERTICAL, false)
            addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))
            val adapter = JokeListAdapter(::onJokeSelected)
            this.adapter = adapter
            adapter.submitList(jokeUiModelList)
        }
    }

    private fun onJokeSelected(jokeSelected: JokeUiModel) {
        val action =
            JokeFragmentDirections.actionJokesFragmentToJokeDetailFragment(jokeSelected)
        findNavController().navigate(action)
    }

    private fun setProgress(isVisible: Boolean) {
        binding?.progress?.isVisible = isVisible
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}