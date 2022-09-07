package vavra.me.spacetycooncommand

data class State(
    val targets: List<Target>,
    val mothershipSelection: Target?,
    val fightersSelection: Target?,
    val bombersSelection: Target?
)

data class Target(val id: String, val name: String)
