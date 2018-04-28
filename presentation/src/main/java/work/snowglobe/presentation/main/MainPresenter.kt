package work.snowglobe.presentation.main

import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.subscribers.DisposableSubscriber
import work.snowglobe.domain.interactor.home.HomeUseCase
import work.snowglobe.domain.model.Post
import work.snowglobe.domain.model.Tag
import work.snowglobe.presentation.mapper.PostMapper
import work.snowglobe.presentation.mapper.TagMapper
import javax.inject.Inject

class MainPresenter @Inject constructor(val browseView: MainContract.View,
                                        private val homeUseCase: HomeUseCase,
                                        private val postMapper: PostMapper,
                                        private val tagMapper: TagMapper):
        MainContract.Presenter {

    init {
        browseView.setPresenter(this)
    }

    override fun start() {
        retrievePosts()
        retrieveTags()
    }

    override fun stop() {
        homeUseCase.dispose()
    }

    override fun retrieveTags() {
        homeUseCase.retrieveTags(TagSubscriber())
    }

    override fun retrievePosts() {
        homeUseCase.retrievePosts(PostSubscriber())
    }

    internal fun handleGetPostsSuccess(posts: List<Post>) {
        browseView.hideErrorState()
        if (posts.isNotEmpty()) {
            browseView.hideEmptyState()
            browseView.showPosts(posts.map { postMapper.mapToView(it) })
        } else {
            browseView.hidePosts()
            browseView.showEmptyState()
        }
    }

    internal fun handleGetTagsSuccess(tags: List<Tag>) {
        browseView.hideErrorState()
        if (tags.isNotEmpty()) {
            browseView.hideEmptyState()
            browseView.showTags(tags.map { tagMapper.mapToView(it) })
        } else {
            browseView.hidePosts()
            browseView.showEmptyState()
        }
    }

    inner class PostSubscriber: DisposableSubscriber<List<Post>>() {
        override fun onComplete() {
//            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }

        override fun onNext(t: List<Post>) {
            handleGetPostsSuccess(t)
        }

        override fun onError(exception: Throwable) {
            browseView.hidePosts()
            browseView.hideEmptyState()
            browseView.showErrorState(exception)
        }

    }

    inner class TagSubscriber: DisposableSingleObserver<List<Tag>>() {

        override fun onSuccess(t: List<Tag>) {
            handleGetTagsSuccess(t)
        }

        override fun onError(exception: Throwable) {
            browseView.hidePosts()
            browseView.hideEmptyState()
            browseView.showErrorState(exception)
        }

    }

}