package berlin.herzig.dilabpairingday.todo

class TodoService {

  private var todos: List<Todo> = emptyList()

  fun save(todo: Todo) {
    todos = todos + todo
  }

  fun findAll(): List<Todo> {
    return todos
  }

}
