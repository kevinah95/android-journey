package io.github.kevinah95.android_journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import io.github.kevinah95.android_journey.ui.theme.AndroidJourneyTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AndroidJourneyTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    ComposableArticleApp()
                }
            }
        }
    }
}

@Composable
fun ComposableArticleApp() {
    ArticleCard(
        stringResource(R.string.article_card_title),
        stringResource(R.string.article_card_short_description),
        stringResource(R.string.article_card_long_description)
    )
}

@Composable
fun ArticleCard(title: String, shortDescription: String, longDescription: String, modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.bg_compose_background)

    Column(modifier = modifier) {
        Image(
            painter = image,
            contentDescription = null,
        )
        Text(
            text = title,
            fontSize = 24.sp,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = shortDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier
                .padding(start = 16.dp, end = 16.dp)
        )
        Text(
            text = longDescription,
            textAlign = TextAlign.Justify,
            modifier = Modifier.padding(16.dp)
        )
    }
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidJourneyTheme {
        ArticleCard(
            stringResource(R.string.article_card_title),
            stringResource(R.string.article_card_short_description),
            stringResource(R.string.article_card_long_description)
        )
    }
}