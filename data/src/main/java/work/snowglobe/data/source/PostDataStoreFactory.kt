package work.snowglobe.data.source

import work.snowglobe.data.repository.PostDataStore
import javax.inject.Inject

/**
 * Create an instance of a BufferooDataStore
 */
open class PostDataStoreFactory @Inject constructor(
        private val postRemoteDataStore: PostRemoteDataStore) {

    /**
     * Returns a DataStore based on whether or not there is content in the cache and the cache
     * has not expired
     */
    open fun retrieveDataStore(): PostDataStore {
        return retrieveRemoteDataStore()
    }

    /**
     * Return an instance of the Cache Data Store
     */
    open fun retrieveRemoteDataStore(): PostDataStore {
        return postRemoteDataStore
    }

}