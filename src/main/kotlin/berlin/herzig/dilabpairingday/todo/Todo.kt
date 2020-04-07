package berlin.herzig.dilabpairingday.todo

import java.util.*

data class Todo(val id: String = UUID.randomUUID().toString(),
                val name: String,
                val star: Boolean = false)
