package work.snowglobe.qiitabrowser

import android.app.Activity
import android.app.Application
import android.support.v4.BuildConfig
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import work.snowglobe.qiitabrowser.injection.DaggerApplicationComponent
import javax.inject.Inject

class QiitaBrowserApplication : Application(), HasActivityInjector {

    @Inject lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
                .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> {
        return activityDispatchingAndroidInjector
    }

}
