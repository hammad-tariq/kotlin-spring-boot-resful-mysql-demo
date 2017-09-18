package restapi.controller

import org.apache.juli.logging.Log
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import restapi.model.FeedbackResponse
import restapi.model.UserFeedback
import restapi.repository.UserRepository
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.GetMapping
import restapi.model.User


@RestController
@RequestMapping("/api/v1")
class RestApiController {

    @Autowired
    lateinit var userRepo: UserRepository

    /*  */
    @RequestMapping(value = "/feedback", method = arrayOf(RequestMethod.POST))
    fun submitFeedback(@RequestBody body: UserFeedback): Any {

        if (body.feedback == "") {
            throw IllegalArgumentException("empty feedback not allowed.")
        } else
            return body
    }

    @GetMapping("/users/getuser")
    fun getAllUsersFromDb(): Any {
        return userRepo.findAll()
    }

    @GetMapping(path = arrayOf("/add")) // Map ONLY GET Requests
    @ResponseBody
    fun addNewUser(@RequestParam name: String, @RequestParam email: String): String {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request
        if (name == "" || email == "") {
                  throw IllegalArgumentException("invalid input.")
        } else {
            val n = User(name, email)
            n.name = name
            n.email = email
            userRepo.save(n)
            return "Saved"
        }
    }


    @ExceptionHandler(IllegalArgumentException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleIllegalArgumentError(e: IllegalArgumentException) = e.message


    @ExceptionHandler(RuntimeException::class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    fun handleRuntimeError(e: IllegalArgumentException) = e.message


}