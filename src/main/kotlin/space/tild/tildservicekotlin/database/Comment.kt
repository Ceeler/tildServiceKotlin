package space.tild.tildservicekotlin.database

import java.time.Instant

data class Comment(
    var id : Long,
    var commentText : String,
    var author : User,
    var project: Project,
    var createdAt : Instant,
    var updatedAt : Instant
)
