package vavra.me.spacetycooncommand

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun Screen(
    state: State,
    onMotherSelected: (Target) -> Unit,
    onFighterSelected: (Target) -> Unit,
    onBomberSelected: (Target) -> Unit,
    onRefresh: () -> Unit
) {
    Column(Modifier.padding(24.dp)) {
        Picker(
            label = "Attack with mothership to:",
            state.targets,
            state.mothershipSelection,
            onMotherSelected
        )
        Picker(
            label = "Attack with fighters to:",
            state.targets,
            state.fightersSelection,
            onFighterSelected
        )
        Picker(
            label = "Attack with bombers to:",
            state.targets,
            state.bombersSelection,
            onBomberSelected
        )
        Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
            OutlinedButton(onClick = onRefresh) {
                Text("Refresh")
            }
        }
    }

}

@Composable
fun ColumnScope.Picker(label: String, targets: List<Target>, selection: Target?, onSelected: (Target) -> Unit) {
    Text(label, color = Color.Gray)

    var expanded by remember { mutableStateOf(false) }
    OutlinedButton(
        onClick = { expanded = !expanded }
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                selection?.name ?: "",
                style = MaterialTheme.typography.body1,
                color = Color.Black,
                modifier = Modifier.weight(1f)
            )
            Icon(Icons.Default.ArrowDropDown, null)
            DropdownMenu(
                expanded = expanded,
                onDismissRequest = { expanded = false },
                modifier = Modifier.fillMaxWidth()
            ) {
                targets.forEach { target ->
                    DropdownMenuItem(
                        onClick = {
                            expanded = false
                            onSelected(target)
                        }) {
                        Text(
                            text = target.name,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }

        }
    }

    Row(modifier = Modifier.align(Alignment.CenterHorizontally)) {
        Button(onClick = { }) {
            Text("Attack!")
        }
    }
    Spacer(modifier = Modifier.height(24.dp))
}

@Preview(showBackground = true)
@Composable
fun ScreenPreview() {
    Screen(
        State(
            listOf(),
            Target("id", "ducks - mothership"),
            Target("id", "ducks - mothership"),
            Target("id", "ducks - mothership")
        ),
        {}, {}, {}, {}
    )
}