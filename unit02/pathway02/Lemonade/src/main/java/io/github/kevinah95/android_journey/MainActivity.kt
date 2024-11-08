package io.github.kevinah95.android_journey

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
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
                LemonadeApp()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun LemonadeApp() {
    LemonadeWithButtonAndImage(modifier = Modifier
        .fillMaxSize()
        .wrapContentSize(Alignment.Center)
    )
}

@Composable
fun LemonadeWithButtonAndImage(modifier: Modifier = Modifier) {

    var currentStep by remember { mutableIntStateOf(1) }
    val lemonadeMap = mutableMapOf(
        "step" to 1,
        "imageR" to R.drawable.lemon_tree,
        "imageDesc" to R.string.str_lemon_tree,
        "description" to R.string.desc_lemon_tree
    )

    when(currentStep){
        1 -> {
            lemonadeMap["step"] = 1
            lemonadeMap["imageR"] = R.drawable.lemon_tree
            lemonadeMap["imageDesc"] = R.string.str_lemon_tree
            lemonadeMap["description"] = R.string.desc_lemon_tree
        }
        2 -> {
            lemonadeMap["step"] = 2
            lemonadeMap["imageR"] = R.drawable.lemon_squeeze
            lemonadeMap["imageDesc"] = R.string.str_lemon_squeeze
            lemonadeMap["description"] = R.string.desc_lemon_squeeze
        }
        3 -> {
            lemonadeMap["step"] = 3
            lemonadeMap["imageR"] = R.drawable.lemon_drink
            lemonadeMap["imageDesc"] = R.string.str_lemon_drink
            lemonadeMap["description"] = R.string.desc_lemon_drink
        }
        4 -> {
            lemonadeMap["step"] = 4
            lemonadeMap["imageR"] = R.drawable.lemon_restart
            lemonadeMap["imageDesc"] = R.string.str_lemon_restart
            lemonadeMap["description"] = R.string.desc_lemon_restart
        }
    }




    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {

                currentStep++

                if (currentStep > 4){
                    currentStep = 1
                }

            },
            shape = RoundedCornerShape(25.dp),
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFFc3ecd2))
        ) {
            Image(
                painter = lemonadeMap["imageR"]?.let { painterResource(it) }!!,
                contentDescription = lemonadeMap["imageDesc"]?.let { stringResource(it) }
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = lemonadeMap["description"]?.let { stringResource(it) }!!,
            fontSize = 18.sp
        )
    }
}