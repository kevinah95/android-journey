package io.github.kevinah95.android_journey

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import io.github.kevinah95.android_journey.ui.theme.HappyBirthdayTheme

class ExamplePreviewScreenshots {

    @Preview(showBackground = true)
    @Composable
    fun GreetingPreview() {
        HappyBirthdayTheme {
            GreetingImage(message = "Happy Birthday Kevin!", from = "— From Jenni")
        }
    }
}