package berlin.herzig.dilabpairingday.todo

class TodoService {
  private var count: Long = 0
  private var savedTodo: Todo = Todo(task = "empty")

  fun save(todo: Todo): Todo {
    val id = count
    count++
    savedTodo = todo.copy(id = id)
    return savedTodo
  }

  fun countAll(): Long {
    return count
  }

  fun findById(id: Long): Todo {
    return savedTodo
  }

}
