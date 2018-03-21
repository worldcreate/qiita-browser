package work.snowglobe.qiitabrowser.injection.module

import dagger.Module
import dagger.Provides
import work.snowglobe.domain.executor.PostExecutionThread
import work.snowglobe.domain.executor.ThreadExecutor
import work.snowglobe.domain.interactor.home.HomeUseCaseImpl
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
                                      homeUseCase: HomeUseCaseImpl,
                                      postMapper: PostMapper,
                                      tagMapper: TagMapper):
            MainContract.Presenter {
        return MainPresenter(mainView, homeUseCase, postMapper, tagMapper)
    }

    @Provides
    internal fun provideHomeUseCase(postRepository: PostRepository,
                                 tagRepository: TagRepository,
                                 threadExecutor: ThreadExecutor,
                                 postExecutionThread: PostExecutionThread): HomeUseCaseImpl {
        return HomeUseCaseImpl(postRepository, tagRepository, threadExecutor, postExecutionThread)
    }

}
