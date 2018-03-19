package work.snowglobe.data.source

import io.reactivex.Completable
import io.reactivex.Single
import work.snowglobe.data.model.PostEntity
import work.snowglobe.data.model.TagEntity
import work.snowglobe.data.repository.TagDataStore
import work.snowglobe.data.repository.TagRemote
import javax.inject.Inject

/**
 * Implementation of the [BufferooDataStore] interface to provide a means of communicating
 * with the remote data source
 */
open class TagRemoteDataStore @Inject constructor(private val tagRemote: TagRemote) :
        TagDataStore {

    override fun clearPosts(): Completable {
        throw UnsupportedOperationException()
    }

    override fun savePosts(bufferoos: List<PostEntity>): Completable {
        throw UnsupportedOperationException()
    }

    /**
     * Retrieve a list of [BufferooEntity] instances from the API
     */
    override fun getTags(): Single<List<TagEntity>> {
        return tagRemote.getTags()
    }

}