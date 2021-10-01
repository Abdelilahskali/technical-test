package com.vosker.technicaltest.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.vosker.technicaltest.common.Constants.ID_LABEL
import com.vosker.technicaltest.common.Constants.PUNCHLINE_LABEL
import com.vosker.technicaltest.common.Constants.SETUP_LABEL
import com.vosker.technicaltest.common.Constants.TYPE_LABEL
import com.vosker.technicaltest.common.Utils
import com.vosker.technicaltest.databinding.ItemJokeBinding
import com.vosker.technicaltest.ui.model.JokeUiModel

class JokeListAdapter(private val onJokeSelected: (JokeUiModel) -> Unit) :
    ListAdapter<JokeUiModel, JokeListAdapter.ViewHolder>(JokeDC()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            ItemJokeBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) =
        holder.bind(getItem(position))

    inner class ViewHolder(
        private val binding: ItemJokeBinding,
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        override fun onClick(v: View?) {
            if (adapterPosition == RecyclerView.NO_POSITION) return
            onJokeSelected(getItem(adapterPosition))
        }

        fun bind(item: JokeUiModel) {
            binding.apply {
                jokeId.text = Utils.buildItemLabel(item.id.toString(), ID_LABEL)
                jokeType.text = Utils.buildItemLabel(item.type, TYPE_LABEL)
                jokeSetup.text = Utils.buildItemLabel(item.setup, SETUP_LABEL)
                jokePunchline.text = Utils.buildItemLabel(item.punchline, PUNCHLINE_LABEL)
            }
        }
    }

    private class JokeDC : DiffUtil.ItemCallback<JokeUiModel>() {
        override fun areItemsTheSame(
            oldItem: JokeUiModel,
            newItem: JokeUiModel,
        ): Boolean = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: JokeUiModel,
            newItem: JokeUiModel,
        ): Boolean = oldItem == newItem
    }
}