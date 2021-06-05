package fr.xaviercorbier.iwj.api
import fr.xaviercorbier.iwj.models.Joke
import retrofit2.Call
import retrofit2.http.*

interface SimpleApi {
    @Headers("Accept: application/json")
    @GET("/")
    open fun getJoke(): Call<Joke>
}