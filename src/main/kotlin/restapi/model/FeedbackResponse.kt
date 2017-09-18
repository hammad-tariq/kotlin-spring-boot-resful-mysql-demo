package restapi.model

class FeedbackResponse() {

    lateinit var mStatus: Any
    lateinit var mMessage: String


    constructor(mStatus: Any, mMessage: String) : this() {
        this.mMessage = mMessage
        this.mStatus = mStatus
    }

}