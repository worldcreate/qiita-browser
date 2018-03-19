package work.snowglobe.domain.model

/**
 * Representation for a [Tag] fetched from an external layer data source
 */
data class Tag(val followers_count: Int, val icon_url: String, val id: String, val items_count: String)