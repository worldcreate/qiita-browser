package work.snowglobe.remote.model.post

import work.snowglobe.remote.model.UserModel

/**
 * Representation for a [PostModel] fetched from the API
 */
class PostModel(val renderedBody: String, val body: String, val coediting: String, val commentsCount: String, val createdAt: String, val group: String?, val id: String, val likesCount: String, val private: String, val reactionsCount: String, val tags: List<TagModel>, val title: String, val updatedAt: String, val url: String, val user: UserModel, val pageViewsCount: String)