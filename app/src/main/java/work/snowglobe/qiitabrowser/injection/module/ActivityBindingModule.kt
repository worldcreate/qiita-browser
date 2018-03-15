package work.snowglobe.qiitabrowser.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import work.snowglobe.qiitabrowser.injection.scope.PerActivity
import work.snowglobe.qiitabrowser.view.MainActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(MainActivityModule::class))
    abstract fun bindMainActivity(): MainActivity

}