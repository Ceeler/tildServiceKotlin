package space.tild.tildservicekotlin.database

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant
import java.util.Date

@Table(name = "projects")
@Entity
data class Project(
    @Id @GeneratedValue(strategy = GenerationType.AUTO, generator = "projects_id_seq")
    @SequenceGenerator(name = "projects_id_seq", sequenceName = "projects_id_seq", allocationSize = 1)
    var id : Long? = null,
    var projectName : String = "Blank",
    var projectDescription : String? = null,
    var endedAt : Date? = Date.from(Instant.now().plusSeconds(60*60*24*30)),
    @ManyToMany(mappedBy = "projects")
    var users : Set<User?> = setOf(null),
    @CreationTimestamp var createdAt : Instant? = null,
    @UpdateTimestamp var updatedAt : Instant? = null
)
