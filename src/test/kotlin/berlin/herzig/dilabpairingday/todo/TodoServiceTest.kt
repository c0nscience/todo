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

    assertNameEquals(savedTodos[0], "First")
  }

  @Test
  internal fun testSaveTodos() {
    whenTodoSavedWith("First")
    whenTodoSavedWith("Second")

    val savedTodos = todoService.findAll()
    assertEquals(2, savedTodos.size)

    assertNameEquals(savedTodos[0], "First")
    assertNameEquals(savedTodos[1], "Second")
  }

  private fun whenTodoSavedWith(name: String) {
    todoService.save(Todo(name))
  }

  private fun assertNameEquals(todo: Todo, expected: String) {
    val (name) = todo
    assertEquals(expected, name)
  }
}
