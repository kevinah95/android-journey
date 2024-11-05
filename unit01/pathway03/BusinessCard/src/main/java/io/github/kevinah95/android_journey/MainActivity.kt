package io.github.kevinah95.android_journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Call
import androidx.compose.material.icons.outlined.Email
import androidx.compose.material.icons.outlined.Share
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
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
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    BusinessCard()
}

@Composable
fun BusinessCard() {
    Column(modifier = Modifier
        .fillMaxSize()
        .background(Color(0xFFD2E7D4))) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            ProfileDescription(modifier = Modifier.weight(8f))
            ContactInfo(
                "+00 (00) 000 000",
                "@socialmediahandle",
                "email@domain.com",
                modifier = Modifier.weight(1f)
            )
        }
    }
}

@Composable
fun ProfileDescription(modifier: Modifier = Modifier) {
    val image = painterResource(R.drawable.android_logo)
    Column(
        modifier = modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Row {
            Image(
                painter = image,
                contentDescription = null,
                modifier = Modifier
                    .background(Color(0xFF083041))
                    .width(100.dp)
            )
        }
        Row {
            Text(
                text = "Jennifer Doe",
                fontSize = 56.sp,
                fontWeight = FontWeight.Thin
            )
        }

        Row {
            Text(
                text = "Android Developer Extraordinaire",
                fontWeight = FontWeight.Bold,
                color = Color(0xFF016A38)
            )
        }


    }
}

@Composable
fun ContactInfo(
    telephone: String,
    socialMediaHandle: String,
    email: String,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Bottom,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Column {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Outlined.Call,
                    contentDescription = null,
                    tint = Color(0xFF016A38)
                )
                Text(
                    text = telephone,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Outlined.Share,
                    contentDescription = null,
                    tint = Color(0xFF016A38)
                )
                Text(
                    text = socialMediaHandle,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
            Row(verticalAlignment = Alignment.CenterVertically) {
                Icon(
                    Icons.Outlined.Email,
                    contentDescription = null,
                    tint = Color(0xFF016A38)
                )
                Text(
                    text = email,
                    modifier = Modifier.padding(start = 8.dp)
                )
            }
        }
    }
}


@Preview(showBackground = true, showSystemUi = true)
@Composable
fun GreetingPreview() {
    AndroidJourneyTheme {
        BusinessCardApp()
    }
}