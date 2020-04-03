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
    todoService.save(Todo(name = "First"))

    val savedTodos = todoService.findAll()
    assertEquals(1, savedTodos.size)
  }

  @Test
  internal fun testSaveTodos() {
    todoService.save(Todo(name = "First"))
    todoService.save(Todo(name = "Second"))

    val savedTodos = todoService.findAll()
    assertEquals(2, savedTodos.size)
  }
}
