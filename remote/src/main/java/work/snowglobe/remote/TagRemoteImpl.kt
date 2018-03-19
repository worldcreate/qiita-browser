package work.snowglobe.remote

import io.reactivex.Single
import work.snowglobe.data.model.TagEntity
import work.snowglobe.data.repository.TagRemote
import work.snowglobe.remote.mapper.PostEntityMapper
import work.snowglobe.remote.mapper.TagEntityMapper
import javax.inject.Inject

/**
 * Remote implementation for retrieving Bufferoo instances. This class implements the
 * [BufferooRemote] from the Data layer as it is that layers responsibility for defining the
 * operations in which data store implementation layers can carry out.
 */
class TagRemoteImpl @Inject constructor(private val tagService: TagService,
                                        private val entityMapper: TagEntityMapper) :
        TagRemote {

    /**
     * Retrieve a list of [BufferooEntity] instances from the [BufferooService].
     */
    override fun getTags(): Single<List<TagEntity>> {
        return tagService.getFollowingTags()
                .map {
                    it.map { listItem ->
                        entityMapper.mapFromRemote(listItem)
                    }
                }
    }

}