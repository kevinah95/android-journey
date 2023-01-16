package com.example.quadrant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.quadrant.ui.theme.QuadrantTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuadrantTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    color = MaterialTheme.colors.background
                ) {
                    QuadrantApp()
                }
            }
        }
    }
}

@Composable
fun QuadrantApp() {
    Column(Modifier.fillMaxSize()) {
        Row(Modifier.weight(1f)) {
            QuadrantCell(
                title = stringResource(R.string.first_quadrant_title_text),
                description = stringResource(R.string.first_quadrant_description_text),
                backgroundColor = Color.Green,
                modifier = Modifier.weight(1f)
            )
            QuadrantCell(
                title = stringResource(R.string.second_quadrant_title_text),
                description = stringResource(R.string.second_quadrant_description_text),
                backgroundColor = Color.Yellow,
                modifier = Modifier.weight(1f)
            )
        }
        Row(Modifier.weight(1f)) {
            QuadrantCell(
                title = stringResource(R.string.third_quadrant_title_text),
                description = stringResource(R.string.third_quadrant_description_text),
                backgroundColor = Color.Cyan,
                modifier = Modifier.weight(1f)
            )
            QuadrantCell(
                title = stringResource(R.string.fourth_quadrant_title_text),
                description = stringResource(R.string.fourth_quadrant_description_text),
                backgroundColor = Color.LightGray,
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun QuadrantCell(title: String, description: String, backgroundColor: Color, modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(backgroundColor)
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = title,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 16.dp)
        )
        Text(
            text = description,
            textAlign = TextAlign.Justify
        )
    }
}


@Preview(showBackground = true)
@Composable
fun QuadrantAppPreview() {
    QuadrantApp()
}