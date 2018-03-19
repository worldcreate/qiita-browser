package work.snowglobe.domain.repository

import io.reactivex.Single
import work.snowglobe.domain.model.Tag

/**
 * Interface defining methods for how the data layer can pass data to and from the Domain layer.
 * This is to be implemented by the data layer, setting the requirements for the
 * operations that need to be implemented
 */
interface TagRepository {

    fun getTags(): Single<List<Tag>>

}