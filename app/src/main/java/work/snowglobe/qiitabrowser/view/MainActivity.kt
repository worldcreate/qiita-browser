package work.snowglobe.qiitabrowser.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import dagger.android.AndroidInjection
import work.snowglobe.presentation.main.MainContract
import work.snowglobe.presentation.model.PostView
import work.snowglobe.qiitabrowser.R
import javax.inject.Inject

class MainActivity : AppCompatActivity(), MainContract.View {
    @Inject lateinit var onboardingPresenter: MainContract.Presenter

    override fun setPresenter(presenter: MainContract.Presenter) {
        onboardingPresenter = presenter
    }

    override fun showProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideProgress() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showPosts(posts: List<PostView>) {
        Log.d("debug", posts.toString())
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hidePosts() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showErrorState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideErrorState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun showEmptyState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun hideEmptyState() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        AndroidInjection.inject(this)
    }

    override fun onStart() {
        super.onStart()
        onboardingPresenter.start()
    }
}
