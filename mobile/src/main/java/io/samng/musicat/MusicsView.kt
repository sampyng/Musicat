package io.samng.musicat

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme.typography
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.foundation.Image
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.samng.musicat.model.Music

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MusicsView() {
    val musicList = remember { DataProvider.musicList }
    Scaffold(
        content = { padding ->
            MusicListContent(
                modifier = Modifier.fillMaxSize().padding(padding),
                musics = musicList,
            )
        }
    )
}

@Composable
fun MusicListContent(
    modifier: Modifier = Modifier,
    musics: List<Music>,
) {
    // Use LazyRow when making horizontal lists
    LazyColumn(modifier = modifier) {
        items(items = musics) { data ->
            MusicListItem(data)
        }
    }
}

@Composable
fun MusicListItem(musicItem: Music) {
    Card(
        modifier = Modifier.padding(8.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp),
        shape = RoundedCornerShape(16.dp)
    ) {

        Row {
            Image(
                painter = painterResource(id = musicItem.imageId),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(8.dp)
                    .size(84.dp)
                    .clip(RoundedCornerShape(corner = CornerSize(16.dp)))
            )
            Column(
                modifier = Modifier.fillMaxWidth()
                    .align(Alignment.CenterVertically)
                    .padding(16.dp)
            ) {
                Text(text = musicItem.title, style = typography.titleMedium)
                Text(text = musicItem.artist, style = typography.labelMedium)
            }
        }
    }
}

@Preview
@Composable
fun MusicsViewPreview() {
    MusicsView()
}