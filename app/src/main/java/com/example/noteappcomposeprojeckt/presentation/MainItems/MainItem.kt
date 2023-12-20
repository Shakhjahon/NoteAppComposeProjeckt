package com.example.noteappcomposeprojeckt.presentation.MainItems

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.noteappcomposeprojeckt.data.model.NotesModel
import com.example.noteappcomposeprojeckt.presentation.theme.dp12
import com.example.noteappcomposeprojeckt.presentation.theme.dp5
import com.example.noteappcomposeprojeckt.presentation.theme.dp8
import com.example.noteappcomposeprojeckt.presentation.theme.sp12
import com.example.noteappcomposeprojeckt.presentation.theme.sp16

@Preview
@Composable
fun Preview() {
    NotesItem(
        notesModel = NotesModel(
            title = "lllllllllllllllllllllllll",
            description = "lllllllllllllllllllllllll"
        )
    )
}

@Composable
fun NotesItem(
    modifier: Modifier = Modifier.padding(dp12), notesModel: NotesModel
) {
    val onBeckroundColor = MaterialTheme.colorScheme.onBackground

    Card(
        shape = RoundedCornerShape(dp12),
        modifier = modifier.width(160.dp)

    ) {
        Column(
            modifier = modifier.padding(dp8)
        ) {
            Text(
                text = notesModel.title,
                fontSize = sp16,
                fontWeight = FontWeight(600),
                color = onBeckroundColor,
                textAlign = TextAlign.Center,
            )
            Text(
                text = notesModel.description,
                fontSize = sp12,
                fontWeight = FontWeight(500),
                color = onBeckroundColor,
                textAlign = TextAlign.Center,
            )

        }
    }
}