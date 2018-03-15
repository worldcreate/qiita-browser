package work.snowglobe.data.source

import io.reactivex.Completable
import io.reactivex.Single
import work.snowglobe.data.model.PostEntity
import work.snowglobe.data.repository.PostDataStore
import work.snowglobe.data.repository.PostRemote
import javax.inject.Inject

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class PostRemoteDataStore @Inject constructor(private val postRemote: PostRemote) :
        PostDataStore {

    override fun clearPosts(): Completable {
        throw UnsupportedOperationException()
    }

    override fun savePosts(bufferoos: List<PostEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [BufferooEntity] instances from the API
     */
    override fun getPosts(): Single<List<PostEntity>> {
        return postRemote.getPosts()
    }

}