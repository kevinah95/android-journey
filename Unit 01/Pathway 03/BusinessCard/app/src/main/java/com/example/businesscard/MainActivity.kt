package com.example.businesscard

import Border
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.sharp.Call
import androidx.compose.material.icons.sharp.Email
import androidx.compose.material.icons.sharp.Share
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
import border
import com.example.businesscard.ui.theme.BusinessCardTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BusinessCardTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = Color(0xFF083041)
                ) {
                    BusinessCardApp()
                }
            }
        }
    }
}

@Composable
fun BusinessCardApp() {
    Column {
        HeaderInfoCard(
            "Jennifer Doe",
            "Android Developer Extraordinaire",
            modifier = Modifier.weight(3f)
        )
        ContactInfoCard(modifier = Modifier.weight(1f))
    }
}

@Composable
fun HeaderInfoCard(name: String, title: String, modifier: Modifier = Modifier) {
    val image = painterResource(id = R.drawable.android_logo)
    Column(
        modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = image,
            contentDescription = null,
            modifier = Modifier.width(128.dp)
        )
        Text(
            text = name,
            fontSize = 48.sp,
            color = Color.White,
            fontWeight = FontWeight.ExtraLight
        )
        Text(
            text = title,
            fontSize = 14.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF3ddc84)
        )
    }
}

@Composable
fun ContactInfoCard(modifier: Modifier = Modifier) {
    Column(modifier = modifier.fillMaxSize(), verticalArrangement = Arrangement.Top) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(top = Border(1.dp, Color.LightGray))
                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Icon(
                Icons.Sharp.Call,
                contentDescription = null,
                tint = Color(0xFF3ddc84)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = "+00 (00) 000 000", color = Color.White)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(top = Border(1.dp, Color.LightGray))
                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Icon(
                Icons.Sharp.Share,
                contentDescription = null,
                tint = Color(0xFF3ddc84)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = "@socialmediahandle", color = Color.White)
        }
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .border(top = Border(1.dp, Color.LightGray))
                .padding(start = 32.dp, top = 8.dp, bottom = 8.dp)
        ) {
            Icon(
                Icons.Sharp.Email,
                contentDescription = null,
                tint = Color(0xFF3ddc84)
            )
            Spacer(modifier = Modifier.width(24.dp))
            Text(text = "email@domain.com", color = Color.White)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HeaderInfoCardPreview() {
    BusinessCardTheme {
        //HeaderInfoCard("Jennifer Doe", "Android Developer Extraordinaire")
        //ContactInfoCard()
        Surface(
            modifier = Modifier.fillMaxSize(),
            color = Color(0xFF083041)
        ) {
            BusinessCardApp()
        }
    }
}