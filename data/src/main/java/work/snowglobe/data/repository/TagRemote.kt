package work.snowglobe.data.repository

import io.reactivex.Single
import work.snowglobe.data.model.TagEntity

/**
 * Interface defining methods for the caching of Bufferroos. This is to be implemented by the
 * cache layer, using this interface as a way of communicating.
 */
interface TagRemote {

    /**
     * Retrieve a list of Bufferoos, from the cache
     */
    fun getTags(): Single<List<TagEntity>>

}