package berlin.herzig.dilabpairingday.todo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test

class TodoServiceTest {

  private var todoService: TodoService = TodoService()

  @BeforeEach
  internal fun setUp() {
    todoService = TodoService()
  }

  @Test
  fun testSaveTodo() {
    whenTodoSavedWith("First")

    val savedTodos = todoService.findAll()
    assertEquals(1, savedTodos.size)

    assertEquals(savedTodos[0].name, "First")
  }

  @Test
  internal fun testSaveTodos() {
    whenTodoSavedWith("First")
    whenTodoSavedWith("Second")

    val savedTodos = todoService.findAll()
    assertEquals(2, savedTodos.size)

    assertEquals(savedTodos[0].name, "First")
    assertEquals(savedTodos[1].name, "Second")
  }

  @Test
  internal fun testStarATodo() {
    todoService.save(Todo(name = "first"))
    val id = todoService.save(Todo(name = "second"))

    todoService.star(id)

    val savedTodos = todoService.findAll()
    val staredTodos = savedTodos.filter { it.star }
    assertEquals(1, staredTodos.size)
    assertEquals(staredTodos[0].id, id)
    assertEquals(staredTodos[0].name, "second")
  }

  private fun whenTodoSavedWith(name: String) {
    todoService.save(Todo(name = name))
  }

}
