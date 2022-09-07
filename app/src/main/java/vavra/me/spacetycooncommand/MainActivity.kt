package vavra.me.spacetycooncommand

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import vavra.me.spacetycooncommand.ui.theme.SpaceTycoonCommandTheme

class MainActivity : ComponentActivity() {

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SpaceTycoonCommandTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    Screen(
                        viewModel.state,
                        onMotherSelected = { viewModel.motherSelected(it) },
                        onFighterSelected = { viewModel.fighterSelected(it) },
                        onBomberSelected = { viewModel.bomberSelected(it) },
                        onRefresh = { viewModel.refresh() })
                }
            }
        }
    }
}