package work.snowglobe.remote

import io.reactivex.Single
import retrofit2.http.GET
import work.snowglobe.remote.model.PostModel

/**
 * Defines the abstract methods used for interacting with the Bufferoo API
 */
interface PostService {

    @GET("team.json")
    fun getPosts(): Single<PostResponse>

    class PostResponse {
        lateinit var team: List<PostModel>
    }

}
