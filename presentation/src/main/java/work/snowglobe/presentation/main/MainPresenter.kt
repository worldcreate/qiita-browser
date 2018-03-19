package work.snowglobe.presentation.main

import io.reactivex.observers.DisposableSingleObserver
import work.snowglobe.domain.interactor.SingleUseCase
import work.snowglobe.domain.model.Post
import work.snowglobe.domain.model.Tag
import work.snowglobe.presentation.mapper.PostMapper
import work.snowglobe.presentation.mapper.TagMapper
import javax.inject.Inject

class MainPresenter @Inject constructor(val browseView: MainContract.View,
                                        val getQiitaUseCase: SingleUseCase<List<Post>, Void>,
                                        val getTagsUseCase: SingleUseCase<List<Tag>, Void>,
                                        val postMapper: PostMapper,
                                        val tagMapper: TagMapper):
        MainContract.Presenter {

    init {
        browseView.setPresenter(this)
    }

    override fun start() {
        retrievePosts()
        retrieveTags()
    }

    override fun stop() {
        getQiitaUseCase.dispose()
    }

    override fun retrieveTags() {
        getTagsUseCase.execute(TagSubscriber())
    }

    override fun retrievePosts() {
        getQiitaUseCase.execute(PostSubscriber())
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

    inner class PostSubscriber: DisposableSingleObserver<List<Post>>() {

        override fun onSuccess(t: List<Post>) {
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