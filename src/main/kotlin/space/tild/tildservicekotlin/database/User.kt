package space.tild.tildservicekotlin.database

import jakarta.persistence.*
import lombok.AllArgsConstructor
import lombok.Data
import lombok.NoArgsConstructor
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant


@Table(name = "users")
@Entity
data class User(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long? = null,
    var firstName : String = "Blank",
    var lastName : String? = null,
    var username : String = "Blank",
    var email : String = "Blank",
    var password : String = "Blank",
    var userPosition : String? = null,
    var description : String? = null,
    var status : String? = null,
    @ManyToMany(cascade = [CascadeType.MERGE])
    @JoinTable(name = "user_task",
    joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "task_id")]
    )
    var tasks : Set<Task?> = setOf(null),
    @ManyToMany(cascade = [CascadeType.MERGE])
    @JoinTable(name = "user_project",
        joinColumns = [JoinColumn(name = "user_id")],
        inverseJoinColumns = [JoinColumn(name = "project_id")]
    )
    var projects : Set<Project?> = setOf(null),
    @CreationTimestamp var createdAt : Instant? = null,
    @UpdateTimestamp var updatedAt : Instant? = null
)
