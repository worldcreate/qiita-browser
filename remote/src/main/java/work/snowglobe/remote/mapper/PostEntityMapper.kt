package work.snowglobe.remote.mapper

import work.snowglobe.data.model.PostEntity
import work.snowglobe.remote.model.PostModel
import javax.inject.Inject

/**
 * Map a [BufferooModel] to and from a [BufferooEntity] instance when data is moving between
 * this later and the Data layer
 */
open class PostEntityMapper @Inject constructor(): EntityMapper<PostModel, PostEntity> {

    /**
     * Map an instance of a [BufferooModel] to a [BufferooEntity] model
     */
    override fun mapFromRemote(type: PostModel): PostEntity {
        return PostEntity(type.name, type.title, type.avatar)
    }

}