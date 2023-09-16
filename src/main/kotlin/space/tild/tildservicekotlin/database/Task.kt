package space.tild.tildservicekotlin.database

import jakarta.persistence.*
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "tasks")
data class Task(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long? = null,
    var taskName : String = "Blank",
    var taskDescription : String? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author : User = User(),
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    var project : Project = Project(),
    @ManyToMany(mappedBy = "tasks")
    var executors : Set<User?> = setOf(null),
    @CreationTimestamp var createdAt : Instant? = null,
    @UpdateTimestamp var updatedAt : Instant? = null
)
