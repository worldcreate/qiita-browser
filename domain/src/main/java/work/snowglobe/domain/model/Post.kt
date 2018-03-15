package work.snowglobe.domain.model

/**
 * Representation for a [Post] fetched from an external layer data source
 */
data class Post(val name: String, val title: String, val avatar: String)