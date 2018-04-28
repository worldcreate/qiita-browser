package work.snowglobe.domain.interactor.home

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import io.reactivex.subscribers.DisposableSubscriber
import work.snowglobe.domain.executor.PostExecutionThread
import work.snowglobe.domain.executor.ThreadExecutor
import work.snowglobe.domain.model.Post
import work.snowglobe.domain.model.Tag
import work.snowglobe.domain.repository.PostRepository
import work.snowglobe.domain.repository.TagRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Bufferoo] instances from the [BufferooRepository]
 */
open class HomeUseCaseImpl @Inject constructor(
        private val postRepository: PostRepository,
        private val tagRepository: TagRepository,
        private val threadExecutor: ThreadExecutor,
        private val postExecutionThread: PostExecutionThread):
        HomeUseCase {

    private val disposables = CompositeDisposable()

    override fun retrieveTags(singleObserver: DisposableSingleObserver<List<Tag>>) {
        val single = tagRepository.getTags()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler) as Single<List<Tag>>
        addDisposable(single.subscribeWith(singleObserver))
    }

    override fun retrievePosts(subscriber: DisposableSubscriber<List<Post>>) {
        val single = tagRepository.getTags()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler) as Single<List<Tag>>
        addDisposable(single.subscribeWith(PostSubscriber(subscriber)))
    }

    inner class PostSubscriber constructor(private val singleObserver: DisposableSubscriber<List<Post>>): DisposableSingleObserver<List<Tag>>() {
        override fun onSuccess(t: List<Tag>) {
            val list = ArrayList<Single<List<Post>>>()

            for (tag in t) {
                list.add(postRepository.getPosts(tag.id)
                        .subscribeOn(Schedulers.from(threadExecutor))
                        .observeOn(postExecutionThread.scheduler))
            }

            addDisposable(Single.merge(list).subscribeWith(singleObserver))
        }

        override fun onError(exception: Throwable) {

        }

    }


    /**
     * Dispose from current [CompositeDisposable].
     */
    override fun dispose() {
        if (!disposables.isDisposed) disposables.dispose()
    }

    /**
     * Dispose from current [CompositeDisposable].
     */
    private fun addDisposable(disposable: Disposable) {
        disposables.add(disposable)
    }


}