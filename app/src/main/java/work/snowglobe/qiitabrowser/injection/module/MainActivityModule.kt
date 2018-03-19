package work.snowglobe.qiitabrowser.injection.module

import dagger.Module
import dagger.Provides
import work.snowglobe.domain.executor.PostExecutionThread
import work.snowglobe.domain.executor.ThreadExecutor
import work.snowglobe.domain.interactor.post.GetPosts
import work.snowglobe.domain.interactor.tag.GetTags
import work.snowglobe.domain.repository.PostRepository
import work.snowglobe.domain.repository.TagRepository
import work.snowglobe.presentation.main.MainContract
import work.snowglobe.presentation.main.MainPresenter
import work.snowglobe.presentation.mapper.PostMapper
import work.snowglobe.presentation.mapper.TagMapper
import work.snowglobe.qiitabrowser.view.MainActivity


/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class MainActivityModule {

    @Provides
    internal fun provideMainView(mainActivity: MainActivity): MainContract.View {
        return mainActivity
    }

    @Provides
    internal fun provideMainPresenter(mainView: MainContract.View,
                                      getPosts: GetPosts,
                                      getTags: GetTags,
                                      postMapper: PostMapper,
                                      tagMapper: TagMapper):
            MainContract.Presenter {
        return MainPresenter(mainView, getPosts, getTags, postMapper, tagMapper)
    }

    @Provides
    internal fun provideGetPosts(postRepository: PostRepository,
                                 threadExecutor: ThreadExecutor,
                                 postExecutionThread: PostExecutionThread): GetPosts {
        return GetPosts(postRepository, threadExecutor, postExecutionThread)
    }

    @Provides
    internal fun provideGetTags(tagRepository: TagRepository,
                                threadExecutor: ThreadExecutor,
                                postExecutionThread: PostExecutionThread): GetTags {
        return GetTags(tagRepository, threadExecutor, postExecutionThread)
    }

}
