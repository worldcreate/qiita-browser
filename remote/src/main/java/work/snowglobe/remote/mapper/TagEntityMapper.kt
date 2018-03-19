package work.snowglobe.remote.mapper

import work.snowglobe.data.model.PostEntity
import work.snowglobe.data.model.TagEntity
import work.snowglobe.remote.model.TagModel
import javax.inject.Inject

/**
 * Map a [BufferooModel] to and from a [BufferooEntity] instance when data is moving between
 * this later and the Data layer
 */
open class TagEntityMapper @Inject constructor(): EntityMapper<TagModel, TagEntity> {

    /**
     * Map an instance of a [BufferooModel] to a [BufferooEntity] model
     */
    override fun mapFromRemote(type: TagModel): TagEntity {
        return TagEntity(type.followers_count, type.icon_url, type.id, type.items_count)
    }

}