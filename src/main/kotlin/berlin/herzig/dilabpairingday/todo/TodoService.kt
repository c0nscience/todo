package berlin.herzig.dilabpairingday.todo

import org.springframework.stereotype.Service

@Service
class TodoService {

  private var todos: List<Todo> = emptyList()

  fun save(todo: Todo) {
    todos = todos + todo
  }

  fun findAll(): List<Todo> {
    return todos
  }

  fun reset() {
    todos = emptyList()
  }

}
