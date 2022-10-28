package io.samng.musicat

data class MusicsScreen(
    /** The current name that has been entered. */
    val username: String,
    /** Callback when the name changes in the UI. */
    val onUsernameChanged: (String) -> Unit,
    /** Callback when the login button is tapped. */
    val onLoginTapped: () -> Unit
)