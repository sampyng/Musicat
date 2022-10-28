package io.samng.musicat

import com.squareup.workflow1.Snapshot
import com.squareup.workflow1.StatefulWorkflow
import com.squareup.workflow1.action
import io.samng.musicat.MusicsWorkflow.Output
import io.samng.musicat.MusicsWorkflow.State

object MusicsWorkflow : StatefulWorkflow<Unit, State, Output, MusicsScreen>() {

    data class State(
        val username: String
    )
    object Output

    override fun initialState(
        props: Unit,
        snapshot: Snapshot?,
    ): State = State(username = "")

    override fun render(
        renderProps: Unit,
        renderState: State,
        context: RenderContext,
    ): MusicsScreen = MusicsScreen(
        username = renderState.username,
        onUsernameChanged = { context.actionSink.send(onUsernameChanged(it)) },
        onLoginTapped = {}
    )

    private fun onUsernameChanged(username: String) = action {
        state = state.copy(username = username)
    }

    override fun snapshotState(state: State): Snapshot? = null
}
