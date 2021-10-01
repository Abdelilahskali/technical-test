package com.vosker.technicaltest.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import com.vosker.technicaltest.common.Constants
import com.vosker.technicaltest.common.Constants.RANDOM_JOKE_IMAGE
import com.vosker.technicaltest.common.Utils
import com.vosker.technicaltest.common.loadImage
import com.vosker.technicaltest.databinding.FragmentJokeDetailBinding
import com.vosker.technicaltest.ui.model.JokeUiModel

class JokeDetailFragment : Fragment() {

    private var binding: FragmentJokeDetailBinding? = null

    private val args: JokeDetailFragmentArgs by navArgs()

    private var jokeUiModel: JokeUiModel? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        binding = FragmentJokeDetailBinding.inflate(inflater, container, false)
        return binding?.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    private fun initViews() {

        jokeUiModel = args.joke

        binding?.apply {
            jokeImage.loadImage(RANDOM_JOKE_IMAGE)
            jokeId.text = Utils.buildItemLabel(jokeUiModel?.id.toString(), Constants.ID_LABEL)
            jokeType.text = Utils.buildItemLabel(jokeUiModel?.type.orEmpty(), Constants.TYPE_LABEL)
            jokeSetup.text =
                Utils.buildItemLabel(jokeUiModel?.setup.orEmpty(), Constants.SETUP_LABEL)
            jokePunchline.text =
                Utils.buildItemLabel(jokeUiModel?.punchline.orEmpty(), Constants.PUNCHLINE_LABEL)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding = null
    }
}