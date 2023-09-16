package space.tild.tildservicekotlin.database

import java.time.Instant

data class DirectMessage(
    var id : Long,
    var messageText : String,
    var author : User,
    var receiver : User,
    var createdAt : Instant
)

data class ProjectMessage(
    var id : Long,
    var projectText : String,
    var author : User,
    var project : Project,
    var createdAt : Instant,
    var updatedAt : Instant
)
