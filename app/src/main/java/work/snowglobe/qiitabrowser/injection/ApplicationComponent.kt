package work.snowglobe.qiitabrowser.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import work.snowglobe.qiitabrowser.QiitaBrowserApplication
import work.snowglobe.qiitabrowser.injection.module.ActivityBindingModule
import work.snowglobe.qiitabrowser.injection.module.ApplicationModule
import work.snowglobe.qiitabrowser.injection.scope.PerApplication

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: QiitaBrowserApplication)

}
