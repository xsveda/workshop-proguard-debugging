package workshop.proguard.debugging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import workshop.proguard.debugging.theme.ProGuardDebuggingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ProGuardDebuggingTheme {
            }
        }
    }
}