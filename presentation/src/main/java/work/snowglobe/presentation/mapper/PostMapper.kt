package work.snowglobe.presentation.mapper

import work.snowglobe.domain.model.Post
import work.snowglobe.presentation.model.PostView
import javax.inject.Inject

/**
 * Map a [PostView] to and from a [Post] instance when data is moving between
 * this layer and the Domain layer
 */
open class PostMapper @Inject constructor(): Mapper<PostView, Post> {

    /**
     * Map a [Post] instance to a [PostView] instance
     */
    override fun mapToView(type: Post): PostView {
        return PostView(type.name, type.title, type.avatar)
    }


}