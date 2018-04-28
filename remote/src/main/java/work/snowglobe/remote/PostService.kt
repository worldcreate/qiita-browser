package work.snowglobe.remote

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path
import work.snowglobe.remote.model.post.PostModel

/**
 * Defines the abstract methods used for interacting with the Bufferoo API
 */
interface PostService {

    @GET("tags/{tagId}/items")
    fun getPosts(@Path("tagId") tagId: String): Single<List<PostModel>>
}
