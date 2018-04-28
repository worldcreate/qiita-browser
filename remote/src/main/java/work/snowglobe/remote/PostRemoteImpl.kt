package work.snowglobe.remote

import io.reactivex.Single
import work.snowglobe.data.model.PostEntity
import work.snowglobe.data.repository.PostRemote
import work.snowglobe.remote.mapper.PostEntityMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class PostRemoteImpl @Inject constructor(private val postService: PostService,
                                         private val entityMapper: PostEntityMapper) :
        PostRemote {

    /**
     * Retrieve a list of [BufferooEntity] instances from the [BufferooService].
     */
    override fun getPosts(tagId: String): Single<List<PostEntity>> {
        return postService.getPosts(tagId)
                .map {
                    it.map { listItem ->
                        entityMapper.mapFromRemote(listItem)
                    }
                }
    }

}