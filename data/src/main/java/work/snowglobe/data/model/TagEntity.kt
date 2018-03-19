package work.snowglobe.data.model

/**
 * Representation for a [TagEntity] fetched from an external layer data source
 */
data class TagEntity(val followers_count: Int, val icon_url: String?, val id: String, val items_count: String)