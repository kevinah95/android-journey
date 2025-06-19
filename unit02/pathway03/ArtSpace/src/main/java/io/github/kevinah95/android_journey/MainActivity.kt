package io.github.kevinah95.android_journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.navigationBars
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBars
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(WindowInsets.navigationBars.asPaddingValues())
                        .padding(WindowInsets.statusBars.asPaddingValues())
                ) {
                    Greeting()
                }
            }
        }
    }
}


@Composable
fun Greeting(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .border(width = 1.dp, color = Color.Magenta, shape = RoundedCornerShape(1.dp))
            .padding(horizontal = 16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        ArtworkWall(Modifier.weight(6f))
        ArtworkDescriptor(Modifier.weight(2f))
        DisplayController(
            Modifier.weight(1f)
        )

    }

}

@Composable
fun ArtworkWall(modifier: Modifier = Modifier) {

    Surface(
        border = BorderStroke(30.dp, color = Color.White),
        modifier = modifier

            .padding(6.dp),
        shadowElevation = 16.dp,
    ) {
        Image(
            painter = painterResource(R.drawable.img_01),
            contentDescription = null,
            contentScale = ContentScale.Crop,
        )
    }
}

@Composable
fun ArtworkDescriptor(modifier: Modifier = Modifier) {
    Row(
        horizontalArrangement = Arrangement.Center,
        modifier = modifier
            .border(width = 1.dp, color = Color.Red, shape = RoundedCornerShape(1.dp))
            .fillMaxWidth()
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = "Artwork Title",
                fontWeight = FontWeight.Bold,
                fontSize = 40.sp,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(1.dp))
            )
            Text(
                text = "Artwork artist (Year)",
                fontSize = 20.sp,
                modifier = Modifier
                    .border(width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(1.dp))
            )
        }
    }
}

@Composable
fun DisplayController(modifier: Modifier = Modifier) {
    Row(
        verticalAlignment = Alignment.Bottom,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = modifier
            .border(width = 1.dp, color = Color.Red, shape = RoundedCornerShape(1.dp))
            .fillMaxWidth(),
    ) {
        Row(
            Modifier
                .border(width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(1.dp))
                .weight(1f)
        ) {
            Button(onClick = { }, modifier = Modifier) {
                Text("Previous")
            }
        }
        Row(
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .border(width = 1.dp, color = Color.Blue, shape = RoundedCornerShape(1.dp))
                .weight(1f)
        ) {
            Button(onClick = { }, modifier = Modifier) {
                Text("Next")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    AndroidJourneyTheme {
        Greeting()
    }
}