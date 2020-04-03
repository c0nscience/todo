package berlin.herzig.dilabpairingday.todo

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.context.TestConfiguration
import org.springframework.context.annotation.Bean
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@WebMvcTest(TodoResource::class)
internal class TodoResourceIntegrationTest {

  @Autowired
  private lateinit var mockMvc: MockMvc

  @Autowired
  private lateinit var todoService: TodoService

  @Test
  fun store() {
    mockMvc.perform(post("/todos")
      .contentType(MediaType.APPLICATION_JSON)
      .content("{\"name\": \"new todo\"}"))
      .andExpect(status().isCreated)

    val savedTodos = todoService.findAll()
    assertEquals(1, savedTodos.size)

    val (name) = savedTodos[0]
    assertEquals("new todo", name)
  }

  @TestConfiguration
  class TodoResourceIntegrationTest {

    @Bean
    fun todoService(): TodoService = TodoService()

  }


}
