package work.snowglobe.presentation.mapper

import work.snowglobe.domain.model.Post
import work.snowglobe.domain.model.Tag
import work.snowglobe.presentation.model.PostView
import work.snowglobe.presentation.model.TagView
import javax.inject.Inject

/**
 * Map a [PostView] to and from a [Post] instance when data is moving between
 * this layer and the Domain layer
 */
open class TagMapper @Inject constructor(): Mapper<TagView, Tag> {

    /**
     * Map a [Post] instance to a [PostView] instance
     */
    override fun mapToView(type: Tag): TagView {
        return TagView(type.followers_count.toString(), type.icon_url, type.id, type.items_count)
    }


}