package restapi.repository

import org.springframework.data.repository.CrudRepository
import restapi.model.User

interface UserRepository : CrudRepository<User, Long> {
}