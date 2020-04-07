package berlin.herzig.dilabpairingday.todo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
class TodoResource(private val todoService: TodoService) {

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/todos")
  fun store(@RequestBody todo: Todo) {
    todoService.save(todo)
  }

  @GetMapping("/todos")
  fun findAll(): List<Todo> {
    return todoService.findAll()
  }

}
