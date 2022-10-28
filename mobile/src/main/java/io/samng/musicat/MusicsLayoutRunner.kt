package io.samng.musicat

import com.squareup.workflow1.ui.LayoutRunner
import com.squareup.workflow1.ui.LayoutRunner.Companion.bind
import com.squareup.workflow1.ui.ViewEnvironment
import com.squareup.workflow1.ui.ViewFactory
import com.squareup.workflow1.ui.WorkflowUiExperimentalApi
import com.squareup.workflow1.ui.setTextChangedListener
import com.squareup.workflow1.ui.updateText
import io.samng.musicat.databinding.MusicsViewBinding

@OptIn(WorkflowUiExperimentalApi::class)
class MusicsLayoutRunner(
    private val binding: MusicsViewBinding
) : LayoutRunner<MusicsScreen> {

    override fun showRendering(
        rendering: MusicsScreen,
        viewEnvironment: ViewEnvironment
    ) {
        // updateText and setTextChangedListener are helpers provided by the workflow library that take
        // care of the complexity of correctly interacting with EditTexts in a declarative manner.
//        binding.username.updateText(rendering.username)
//        binding.username.setTextChangedListener {
//            rendering.onUsernameChanged(it.toString())
//        }
//        binding.login.setOnClickListener { rendering.onLoginTapped() }
    }

    companion object : ViewFactory<MusicsScreen> by bind(
        MusicsViewBinding::inflate, ::MusicsLayoutRunner
    )
}