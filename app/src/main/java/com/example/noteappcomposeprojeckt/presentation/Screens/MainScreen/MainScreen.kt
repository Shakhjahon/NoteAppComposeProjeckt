package com.example.notesappcomposeprojeckt2.presentation.Screens.MainScreen

import android.annotation.SuppressLint
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import com.example.noteappcomposeprojeckt.R
import com.example.noteappcomposeprojeckt.data.SharePrefences
import com.example.noteappcomposeprojeckt.data.model.NotesModel
import com.example.noteappcomposeprojeckt.presentation.theme.WhiteLight
import com.example.noteappcomposeprojeckt.presentation.theme.dp10
import com.example.noteappcomposeprojeckt.presentation.theme.dp15
import com.example.noteappcomposeprojeckt.presentation.theme.sp16
import com.example.noteappcomposeprojeckt.presentation.theme.sp18
import com.google.accompanist.systemuicontroller.rememberSystemUiController

@RequiresApi(Build.VERSION_CODES.Q)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(
    modifier: Modifier = Modifier,
    callBackScreen: () -> Unit,
) {
    val systemUiController = rememberSystemUiController()
    SideEffect {
        systemUiController.setStatusBarColor(WhiteLight)
        systemUiController.setNavigationBarColor(WhiteLight)
    }
    val sharedPref = SharePrefences(LocalContext.current)
    var titleText by remember {
        mutableStateOf("")
    }
    var descriptionText by remember {
        mutableStateOf("")
    }
    Scaffold(
        containerColor = WhiteLight,
        topBar = {
            CenterAlignedTopAppBar(
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = WhiteLight
                ),
                modifier = modifier.padding(dp10),
                title = {
                    Text(
                        text = "Edit Note",
                        fontSize = sp16,
                        fontWeight = FontWeight(600),
                        color = MaterialTheme.colorScheme.onBackground,
                        textAlign = TextAlign.Center,
                    )
                },
                navigationIcon = {
                    IconButton(
                        onClick = {
                            callBackScreen()
                        },
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBack,
                            contentDescription = null,
                        )
                    }
                },
                actions = {
                    IconButton(

                        onClick = {
                            if (titleText.isNotEmpty() && descriptionText.isNotEmpty()) {
                                callBackScreen()
                                sharedPref.saveNote(
                                    NotesModel(
                                        title = titleText, description = descriptionText
                                    ),
                                )
                            }
                        },
                    ) {
                        Icon(
                            painter = painterResource(R.drawable.save),
                            contentDescription = null,
                        )
                    }
                },
            )
        },
        content = { innerPadding ->
            Column {
                OutlinedTextField(
                    modifier = modifier
                        .padding(innerPadding)
                        .padding(horizontal = dp15)
                        .padding(dp15)
                        .fillMaxWidth(),
                    value = titleText,
                    onValueChange = { titleText = it },
                    label = {
                        Text(
                            text = "Title",
                            color = Color.LightGray,
                            fontWeight = FontWeight(600),
                            fontSize = sp18,
                        )
                    },
                )
                OutlinedTextField(
                    modifier = modifier
                        .padding(dp15)
                        .padding(horizontal = dp15)
                        .fillMaxWidth(),
                    value = descriptionText,
                    onValueChange = { descriptionText = it },
                    label = {
                        Text(
                            text = "Description",
                            color = Color.LightGray,
                            fontWeight = FontWeight(500),
                            fontSize = sp18,
                        )
                    },
                )
            }
        },
    )
}

@RequiresApi(Build.VERSION_CODES.Q)
@Preview
@Composable
fun Preview() {
    MainScreen(callBackScreen = {})
}