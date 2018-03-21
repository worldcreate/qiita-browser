package work.snowglobe.domain.interactor.home

import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableSingleObserver
import work.snowglobe.domain.model.Post
import work.snowglobe.domain.model.Tag


/**
 * Abstract class for a UseCase that returns an instance of a [Single].
 */
interface HomeUseCase {

    fun retrieveTags(singleObserver: DisposableSingleObserver<List<Tag>>)

    fun retrievePosts(singleObserver: DisposableSingleObserver<List<Post>>)

    /**
     * Dispose from current [CompositeDisposable].
     */
    fun dispose()

}