package workshop.proguard.debugging

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.currentComposer
import androidx.compose.runtime.reflect.getDeclaredComposableMethod
import workshop.proguard.debugging.theme.ProGuardDebuggingTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        setContent {
            ProGuardDebuggingTheme {
                // Reflection based alternative to standard composable method call:
                // MainScreen(viewModel = MainViewModel())
                composableMethod.invoke(currentComposer, null, MainViewModel())
            }
        }
    }
}


private val viewModelClass = Class.forName("workshop.proguard.debugging.MainViewModel")
private val composableClass = Class.forName("workshop.proguard.debugging.MainScreenKt")
private val composableMethod = composableClass.getDeclaredComposableMethod("MainScreen", viewModelClass)