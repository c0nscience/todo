package berlin.herzig.dilabpairingday.todo

import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RestController
class TodoResource(private val todoService: TodoService) {

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping("/todos")
  fun store(@RequestBody todo: Todo) {
    todoService.save(todo)
  }

}
