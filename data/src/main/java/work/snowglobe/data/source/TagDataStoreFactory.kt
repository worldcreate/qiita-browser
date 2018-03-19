package work.snowglobe.data.source

import work.snowglobe.data.repository.PostDataStore
import work.snowglobe.data.repository.TagDataStore
import javax.inject.Inject

/**
 * Create an instance of a BufferooDataStore
 */
open class TagDataStoreFactory @Inject constructor(
        private val tagRemoteDataStore: TagRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(): TagDataStore {
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveRemoteDataStore(): TagDataStore {
        return tagRemoteDataStore
    }

}