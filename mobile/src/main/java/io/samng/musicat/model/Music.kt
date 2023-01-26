package io.samng.musicat.model

import io.samng.musicat.R

data class Music(
    val id: Int,
    val title: String,
//    val length: Int,
    val artist: String,
    val imageId: Int = R.drawable.music_placeholder
)