package com.example.noteappcomposeprojeckt.presentation.Screens.onBoordingScreen

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import com.example.noteappcomposeprojeckt.R
import com.example.noteappcomposeprojeckt.data.SharePrefences
import com.example.noteappcomposeprojeckt.presentation.MainItems.NotesItem
import com.example.noteappcomposeprojeckt.presentation.theme.LightPurple
import com.example.noteappcomposeprojeckt.presentation.theme.dp15
import com.example.noteappcomposeprojeckt.presentation.theme.dp25
import com.example.noteappcomposeprojeckt.presentation.theme.dp40
import com.example.noteappcomposeprojeckt.presentation.theme.dp60
import com.example.noteappcomposeprojeckt.presentation.theme.sp16
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@Preview
@Composable
fun OnBoordingScreenPreview() {
    OnBoordingScreen(onBoordingScreenNavController = {})
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OnBoordingScreen(
    onBoordingScreenNavController: () -> Unit
) {
    val systemUiController = rememberSystemUiController()
//    SideEffect {
//        systemUiController.setStatusBarColor(MaterialTheme.colorScheme.background)
//        systemUiController.setNavigationBarColor(MaterialTheme.colorScheme.background)
//    }
    val notesSharedPref = SharePrefences(LocalContext.current)
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                modifier = Modifier.padding(dp15),
                title = {
                    Text(
                        text = stringResource(
                            R.string.recent_notes
                        ),
                        fontSize = sp16,
                        fontWeight = FontWeight(600),
                    )
                },
                navigationIcon = {
                    Icon(
                        painter = painterResource(id = R.drawable.nav_left),
                        contentDescription = null,
                    )
                },
                actions = {
                    Icon(
                        painter = painterResource(id = R.drawable.search),
                        contentDescription = null,
                    )
                },
            )
        },
        content = { innerPadding ->
            LazyVerticalStaggeredGrid(
                modifier = Modifier.padding(innerPadding),
                columns = StaggeredGridCells.Fixed(2),
                content = {
                    items(notesSharedPref.getAllNotes()) { item ->
                        NotesItem(notesModel = item)
                    }
                },
            )
        },

        bottomBar = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(dp25)
                    .clip(RoundedCornerShape(topStart = dp25, topEnd = dp25)),
                horizontalArrangement = Arrangement.Center
            ) {
                IconButton(modifier = Modifier
                    .clip(CircleShape)
                    .width(dp60)
                    .height(dp60)
                    .background(color = LightPurple), onClick = {
                    onBoordingScreenNavController()
                }) {
                    Icon(
                        modifier = Modifier
                            .width(dp40)
                            .height(dp40),
                        imageVector = Icons.Default.Add,
                        tint = MaterialTheme.colorScheme.background,
                        contentDescription = null,
                    )
                }
            }
        },
    )
}