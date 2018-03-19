package work.snowglobe.remote

import io.reactivex.Single
import retrofit2.http.GET
import work.snowglobe.remote.model.TagModel

/**
 * Defines the abstract methods used for interacting with the Bufferoo API
 */
interface TagService {

    @GET("users/sogrnwil/following_tags")
    fun getFollowingTags(): Single<List<TagModel>>

}
