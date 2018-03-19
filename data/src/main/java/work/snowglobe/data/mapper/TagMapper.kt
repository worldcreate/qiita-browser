package work.snowglobe.data.mapper

import work.snowglobe.data.data.mapper.Mapper
import work.snowglobe.data.model.PostEntity
import work.snowglobe.data.model.TagEntity
import work.snowglobe.domain.model.Post
import work.snowglobe.domain.model.Tag
import javax.inject.Inject


/**
 * Map a [BufferooEntity] to and from a [Bufferoo] instance when data is moving between
 * this later and the Domain layer
 */
open class TagMapper @Inject constructor(): Mapper<TagEntity, Tag> {

    /**
     * Map a [BufferooEntity] instance to a [Bufferoo] instance
     */
    override fun mapFromEntity(type: TagEntity): Tag {
        return Tag(type.followers_count, type.icon_url.let{""}, type.id, type.items_count)
    }

    /**
     * Map a [Bufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapToEntity(type: Tag): TagEntity {
        return TagEntity(type.followers_count, type.icon_url, type.id, type.items_count)
    }


}