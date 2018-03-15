package work.snowglobe.qiitabrowser.injection.module

import dagger.Module
import dagger.Provides
import work.snowglobe.domain.interactor.post.GetPosts
import work.snowglobe.presentation.main.MainContract
import work.snowglobe.presentation.main.MainPresenter
import work.snowglobe.presentation.mapper.PostMapper
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
                                      getPosts: GetPosts, mapper: PostMapper):
            MainContract.Presenter {
        return MainPresenter(mainView, getPosts, mapper)
    }

}
