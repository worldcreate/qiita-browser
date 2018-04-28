package work.snowglobe.data

import io.reactivex.Completable
import io.reactivex.Single
import work.snowglobe.data.mapper.PostMapper
import work.snowglobe.data.source.PostDataStoreFactory
import work.snowglobe.domain.model.Post
import work.snowglobe.domain.repository.PostRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [BufferooRepository] interface for communicating to and from
 * data sources
 */
class PostDataRepository @Inject constructor(private val factory: PostDataStoreFactory,
                                             private val postMapper: PostMapper) :
        PostRepository {

    override fun clearPosts(): Completable {
        TODO()
    }

    override fun getPosts(tagId: String): Single<List<Post>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getPosts(tagId)
                .map { list ->
                    list.map { listItem ->
                        postMapper.mapFromEntity(listItem)
                    }
                }
    }

}