package work.snowglobe.data.mapper

import work.snowglobe.data.data.mapper.Mapper
import work.snowglobe.data.model.PostEntity
import work.snowglobe.domain.model.Post
import javax.inject.Inject


/**
 * Map a [BufferooEntity] to and from a [Bufferoo] instance when data is moving between
 * this later and the Domain layer
 */
open class PostMapper @Inject constructor(): Mapper<PostEntity, Post> {

    /**
     * Map a [BufferooEntity] instance to a [Bufferoo] instance
     */
    override fun mapFromEntity(type: PostEntity): Post {
        return Post(type.name, type.title, type.avatar)
    }

    /**
     * Map a [Bufferoo] instance to a [BufferooEntity] instance
     */
    override fun mapToEntity(type: Post): PostEntity {
        return PostEntity(type.name, type.title, type.avatar)
    }


}