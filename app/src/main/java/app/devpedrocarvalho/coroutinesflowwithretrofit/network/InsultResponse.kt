package app.devpedrocarvalho.coroutinesflowwithretrofit.network

import com.google.gson.annotations.SerializedName

data class InsultResponse(
    @SerializedName("created")
    val created: String,

    @SerializedName("insult")
    val insult: String,

    @SerializedName("number")
    val number: String
)