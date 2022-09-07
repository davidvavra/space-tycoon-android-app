package vavra.me.spacetycooncommand

import android.app.Application
import android.util.Log
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
import vavra.me.generated.apis.GameApi
import vavra.me.generated.infrastructure.ApiClient
import vavra.me.generated.models.Command
import vavra.me.generated.models.Credentials
import vavra.me.generated.models.Ship

class MainViewModel(val app: Application) : AndroidViewModel(app) {
    var state by mutableStateOf(
        State(
            listOf(),
            null,
            null,
            null
        )
    )
        private set
    private val apiClient = ApiClient(authNames = arrayOf("cookieAuth"))
    private val api = apiClient.createService(GameApi::class.java)
    private var playerId: String? = null
    private var ships: Map<String, Ship> = mapOf()


    init {
        refresh()
    }

    fun refresh() {
        viewModelScope.launch {
           // if (playerId == null) {
                login()
          //  }
            val data = api.dataGet().body()
            if (data?.ships != null) {
                val players = data.players
                ships = data.ships
                val filteredShips =
                    ships.entries.filter {
                        (it.value.shipClass == SHIP_CLASS_BOMBER ||
                                it.value.shipClass == SHIP_CLASS_FIGHTER ||
                                it.value.shipClass == SHIP_CLASS_MOTHERSHIP)
                                && it.value.player != playerId
                    }
                val targets = filteredShips.map {
                    val playerName = players[it.value.player]?.name
                    val shipClassName = shipClassName(it.value.shipClass)
                    val name = "$playerName - $shipClassName (${it.value.name})"
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
        if (response.isSuccessful) {
            playerId = response.body()?.id
            val cookie = response.headers()["set-cookie"]!!.split("=")[1]
            apiClient.cookie = cookie
            alert("Welcome player id '${playerId}'")
        } else {
            alert("Login failed")
        }
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

    fun motherAttack() {
        attack(SHIP_CLASS_MOTHERSHIP, state.mothershipSelection)
    }

    fun fighterAttack() {
        attack(SHIP_CLASS_FIGHTER, state.fightersSelection)
    }

    fun bomberAttack() {
        attack(SHIP_CLASS_BOMBER, state.bombersSelection)
    }

    private fun attack(shipClass: String, target: Target?) {
        val attackers =
            ships.entries.filter { it.value.player == playerId && it.value.shipClass == shipClass }
        val shipClassName = shipClassName(shipClass)
        if (attackers.isEmpty()) {
            alert("No $shipClassName alive :-(")
        } else {
            if (target != null) {
                viewModelScope.launch {
                    val response = api.commandsPost(
                        attackers.associate { it.key to Command("attack", target.id) }
                    )
                    if (response.isSuccessful) {
                        alert("All ${shipClassName}s on the way")
                    } else {
                        val error = response.errorBody()
                        alert(error.toString())
                    }
                }
            }
        }
    }

    private fun alert(text: String) {
        Toast.makeText(app, text, Toast.LENGTH_LONG).show()
    }

    private fun shipClassName(shipClass: String): String {
        return when (shipClass) {
            SHIP_CLASS_FIGHTER -> "fighter"
            SHIP_CLASS_MOTHERSHIP -> "mother"
            SHIP_CLASS_BOMBER -> "bomber"
            else -> "?"
        }
    }

    companion object {
        const val SHIP_CLASS_FIGHTER = "4"
        const val SHIP_CLASS_BOMBER = "5"
        const val SHIP_CLASS_MOTHERSHIP = "1"
    }
}