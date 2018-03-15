package work.snowglobe.presentation.main

import work.snowglobe.presentation.BasePresenter
import work.snowglobe.presentation.BaseView
import work.snowglobe.presentation.model.PostView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface MainContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showPosts(posts: List<PostView>)

        fun hidePosts()

        fun showErrorState()

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrievePosts()

    }

}