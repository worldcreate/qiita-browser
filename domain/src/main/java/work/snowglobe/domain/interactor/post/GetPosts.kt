package work.snowglobe.domain.interactor.post

import io.reactivex.Single
import work.snowglobe.domain.executor.PostExecutionThread
import work.snowglobe.domain.executor.ThreadExecutor
import work.snowglobe.domain.interactor.SingleUseCase
import work.snowglobe.domain.model.Post
import work.snowglobe.domain.repository.PostRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Bufferoo] instances from the [BufferooRepository]
 */
open class GetPosts @Inject constructor(val postRepository: PostRepository,
                                        threadExecutor: ThreadExecutor,
                                        postExecutionThread: PostExecutionThread):
        SingleUseCase<List<Post>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Post>> {
        return postRepository.getPosts()
    }

}