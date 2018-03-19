package work.snowglobe.presentation.main

import work.snowglobe.presentation.BasePresenter
import work.snowglobe.presentation.BaseView
import work.snowglobe.presentation.model.PostView
import work.snowglobe.presentation.model.TagView

/**
 * Defines a contract of operations between the Browse Presenter and Browse View
 */
interface MainContract {

    interface View : BaseView<Presenter> {

        fun showProgress()

        fun hideProgress()

        fun showPosts(posts: List<PostView>)

        fun showTags(tags: List<TagView>)

        fun hidePosts()

        fun showErrorState(exception: Throwable)

        fun hideErrorState()

        fun showEmptyState()

        fun hideEmptyState()

    }

    interface Presenter : BasePresenter {

        fun retrievePosts()

        fun retrieveTags()
    }

}