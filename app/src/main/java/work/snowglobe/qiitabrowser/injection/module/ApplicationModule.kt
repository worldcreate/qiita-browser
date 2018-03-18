package work.snowglobe.qiitabrowser.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import work.snowglobe.data.PostDataRepository
import work.snowglobe.data.executor.JobExecutor
import work.snowglobe.data.mapper.PostMapper
import work.snowglobe.data.repository.PostRemote
import work.snowglobe.data.source.PostDataStoreFactory
import work.snowglobe.domain.executor.PostExecutionThread
import work.snowglobe.domain.executor.ThreadExecutor
import work.snowglobe.domain.repository.PostRepository
import work.snowglobe.qiitabrowser.BuildConfig
import work.snowglobe.qiitabrowser.UiThread
import work.snowglobe.qiitabrowser.injection.scope.PerApplication
import work.snowglobe.remote.*

/**
 * Module used to provide dependencies at an application-level.
 */
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePostDataRepository(factory: PostDataStoreFactory,
                                           mapper: PostMapper): PostRepository {
        return PostDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: PostService,
                                       factory: work.snowglobe.remote.mapper.PostEntityMapper): PostRemote {
        return PostRemoteImpl(service, factory)
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun providePostService(): PostService {
        return PostServiceFactory.makePostService(BuildConfig.DEBUG)
    }

    @Provides
    @PerApplication
    internal fun provideTagService(): TagService {
        return TagServiceFactory.makeTagService(BuildConfig.DEBUG)
    }
}
