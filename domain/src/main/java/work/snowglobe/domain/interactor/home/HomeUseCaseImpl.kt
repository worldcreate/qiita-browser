package work.snowglobe.domain.interactor.home

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import work.snowglobe.domain.executor.PostExecutionThread
import work.snowglobe.domain.executor.ThreadExecutor
import work.snowglobe.domain.interactor.home.HomeUseCase
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

    override fun retrievePosts(singleObserver: DisposableSingleObserver<List<Post>>) {
        val single = postRepository.getPosts()
                .subscribeOn(Schedulers.from(threadExecutor))
                .observeOn(postExecutionThread.scheduler) as Single<List<Post>>
        addDisposable(single.subscribeWith(singleObserver))
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