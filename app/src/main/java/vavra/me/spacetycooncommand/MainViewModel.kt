package vavra.me.spacetycooncommand

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vavra.me.generated.apis.GameApi
import vavra.me.generated.infrastructure.ApiClient
import vavra.me.generated.models.Credentials

class MainViewModel : ViewModel() {
    var state by mutableStateOf(
        State(
            listOf(),
            null,
            null,
            null
        )
    )
        private set
    private val api = ApiClient().createService(GameApi::class.java)
    private var playerId: String? = null


    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
            if (playerId == null) {
                login()
            }
            val data = api.dataGet().body()
            if (data?.ships != null) {
                val players = data.players
                val filteredShips =
                    data.ships.entries.filter {
                        (it.value.shipClass == SHIP_TYPE_BOMBER ||
                                it.value.shipClass == SHIP_TYPE_FIGHTER ||
                                it.value.shipClass == SHIP_TYPE_MOTHERSHIP)
                                && it.value.player != playerId
                    }
                val targets = filteredShips.map {
                    val playerName = players[it.value.player]?.name
                    val type = when (it.value.shipClass) {
                        SHIP_TYPE_FIGHTER -> "fighter"
                        SHIP_TYPE_MOTHERSHIP -> "mother"
                        SHIP_TYPE_BOMBER -> "bomber"
                        else -> "?"
                    }
                    val name = "$playerName - $type (${it.value.name})"
                    Target(it.key, name)
                }
                state = State(
                    targets,
                    targets.first(),
                    targets.first(),
                    targets.first()
                )
            } else {
                Log.w("TYCOON", "no data")
            }

        }
    }

    private suspend fun login() {
        val response = api.loginPost(Credentials("spaceinvaders", "artemis"))
        playerId = response.body()?.id
        Log.i("TYCOON", "Player ID=$playerId")
    }

    fun motherSelected(target: Target) {
        state = state.copy(mothershipSelection = target)
    }

    fun fighterSelected(target: Target) {
        state = state.copy(fightersSelection = target)
    }

    fun bomberSelected(target: Target) {
        state = state.copy(bombersSelection = target)
    }

    companion object {
        const val SHIP_TYPE_FIGHTER = "4"
        const val SHIP_TYPE_BOMBER = "5"
        const val SHIP_TYPE_MOTHERSHIP = "1"
    }
}