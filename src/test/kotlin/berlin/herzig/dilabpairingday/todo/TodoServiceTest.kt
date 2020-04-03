package berlin.herzig.dilabpairingday.todo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNotNull
import org.junit.jupiter.api.Test

class TodoServiceTest {

  private val todoService: TodoService = TodoService()

  @Test
  fun testSaveTodo() {
    val countBeforeSave = todoService.countAll()
    assertEquals(0, countBeforeSave)

    val newTodo = Todo(task = "build todo server")
    val savedTodo = todoService.save(newTodo)
    assertNotNull(savedTodo)

    val countAfterSave = todoService.countAll()
    assertEquals(1, countAfterSave)

    val foundTodo = todoService.findById(savedTodo.id!!)
    assertEquals(newTodo.task, foundTodo.task)
  }
}
