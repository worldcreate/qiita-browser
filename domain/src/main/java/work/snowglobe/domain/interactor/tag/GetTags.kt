package work.snowglobe.domain.interactor.tag

import io.reactivex.Single
import work.snowglobe.domain.executor.PostExecutionThread
import work.snowglobe.domain.executor.ThreadExecutor
import work.snowglobe.domain.interactor.SingleUseCase
import work.snowglobe.domain.model.Post
import work.snowglobe.domain.model.Tag
import work.snowglobe.domain.repository.PostRepository
import work.snowglobe.domain.repository.TagRepository
import javax.inject.Inject

/**
 * Use case used for retreiving a [List] of [Bufferoo] instances from the [BufferooRepository]
 */
open class GetTags @Inject constructor(val tagRepository: TagRepository,
                                       threadExecutor: ThreadExecutor,
                                       postExecutionThread: PostExecutionThread):
        SingleUseCase<List<Tag>, Void?>(threadExecutor, postExecutionThread) {

    public override fun buildUseCaseObservable(params: Void?): Single<List<Tag>> {
        return tagRepository.getTags()
    }

}