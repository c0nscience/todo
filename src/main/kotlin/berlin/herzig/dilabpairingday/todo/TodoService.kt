package berlin.herzig.dilabpairingday.todo

import org.springframework.stereotype.Service

@Service
class TodoService {

  private var todos: List<Todo> = emptyList()

  fun save(todo: Todo): String {
    todos = todos + todo
    return todo.id
  }

  fun findAll(): List<Todo> {
    return todos
  }

  fun reset() {
    todos = emptyList()
  }

  fun star(id: String) {
    todos = todos.map { todo ->
      return@map if (todo.id == id) {
        todo.copy(star = true)
      } else {
        todo
      }
    }
  }

}
