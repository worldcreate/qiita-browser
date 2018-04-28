package work.snowglobe.domain.repository

import io.reactivex.Completable
import io.reactivex.Single
import work.snowglobe.domain.model.Post

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface PostRepository {

    fun clearPosts(): Completable

    fun getPosts(tagId: String): Single<List<Post>>

}