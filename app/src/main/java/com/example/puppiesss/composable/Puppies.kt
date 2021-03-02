package com.example.puppiesss.composable

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.GridCells
import androidx.compose.foundation.lazy.LazyVerticalGrid
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.puppiesss.model.Puppy
import com.example.puppiesss.viewmodel.PuppyViewModel


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BuildPuppies(viewModel: PuppyViewModel, onClick: (Int) -> Unit) {
    val puppies: ArrayList<Puppy> = viewModel.puppies.value ?: arrayListOf()

    LazyVerticalGrid(
        cells = GridCells.Fixed(2),
        contentPadding = PaddingValues(top = 4.dp, start = 4.dp, end = 12.dp)
    ) {
        items(puppies) { puppy ->
            BuildPuppyItem(puppy) {
                onClick(puppy.id)
            }
        }
    }
}

@Composable
fun BuildPuppyItem(puppy: Puppy, onClick: () -> Unit) {
    val imageModifier = Modifier
        .clickable(onClick = onClick)
        .padding(top = 8.dp, start = 8.dp)
        .clip(RectangleShape)
        .fillMaxHeight()
        .size(150.dp)

    Image(
        modifier = imageModifier,
        painter = painterResource(puppy.picture),
        contentDescription = puppy.name,
        contentScale = ContentScale.Crop
    )
}
