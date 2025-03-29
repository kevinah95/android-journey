package io.github.kevinah95.android_journey

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class HappyBirthdayInstrumentedTest {

    @get:Rule val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("io.github.kevinah95.android_journey", appContext.packageName)
    }

    @Test
    fun testGreetingAndSenderTextsAreDisplayed() {
        composeTestRule.onNode(hasTestTag("greeting_text")).assertIsDisplayed()
        composeTestRule.onNode(hasTestTag("sender_text")).assertIsDisplayed()
    }
}