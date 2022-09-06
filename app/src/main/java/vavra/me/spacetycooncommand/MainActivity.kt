package vavra.me.spacetycooncommand

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.LifecycleCoroutineScope
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch
import vavra.me.generated.apis.GameApi
import vavra.me.generated.infrastructure.ApiClient
import vavra.me.spacetycooncommand.ui.theme.SpaceTycoonCommandTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceTycoonCommandTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Greeting("Android")
                }
                test(lifecycleScope)
            }
        }
    }
}

private fun test(scope: CoroutineScope) {
    scope.launch {
        val apiClient = ApiClient()
        val api = apiClient.createService(GameApi::class.java)
        val response = api.currentTickGet()
        Log.d("SPACE", "tick=${response.body()?.tick}")
    }
}

@Composable
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    SpaceTycoonCommandTheme {
        Greeting("Android")
    }
}