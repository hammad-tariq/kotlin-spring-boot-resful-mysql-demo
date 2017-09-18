package restapi.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


//data class UserFeedback(val email: String?, val start: Int, val feedback: String, val fcm_token: String, val deviceId: String)

@Entity
class UserFeedback() {


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Int? = 0
    lateinit var email: String
    lateinit var stars: String
    lateinit var feedback: String
    lateinit var fcm_token: String
    lateinit var deviceId: String

    constructor(email: String, stars: String, feedback: String, fcm_token: String, deviceId: String) : this() {
        this.email = email
        this.deviceId = deviceId
        this.fcm_token = fcm_token
        this.feedback = feedback
        this.stars = stars
    }
}