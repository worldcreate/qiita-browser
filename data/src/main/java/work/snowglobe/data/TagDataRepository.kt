package work.snowglobe.data

import io.reactivex.Completable
import io.reactivex.Single
import work.snowglobe.data.mapper.TagMapper
import work.snowglobe.data.source.TagDataStoreFactory
import work.snowglobe.domain.model.Tag
import work.snowglobe.domain.repository.TagRepository
import javax.inject.Inject

/**
 * Provides an implementation of the [BufferooRepository] interface for communicating to and from
 * data sources
 */
class TagDataRepository @Inject constructor(private val factory: TagDataStoreFactory,
                                            private val tagMapper: TagMapper) :
        TagRepository {

    override fun getTags(): Single<List<Tag>> {
        val dataStore = factory.retrieveDataStore()
        return dataStore.getTags()
                .map { list ->
                    list.map { listItem ->
                        tagMapper.mapFromEntity(listItem)
                    }
                }
    }

}