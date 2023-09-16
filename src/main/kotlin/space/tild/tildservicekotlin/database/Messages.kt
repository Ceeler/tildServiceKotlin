package space.tild.tildservicekotlin.database

import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.JoinColumn
import jakarta.persistence.ManyToOne
import jakarta.persistence.SequenceGenerator
import jakarta.persistence.Table
import org.hibernate.annotations.CreationTimestamp
import org.hibernate.annotations.UpdateTimestamp
import java.time.Instant

@Entity
@Table(name = "direct_messages")
data class DirectMessage(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long? = null,
    var messageText : String = "Empty",
    @ManyToOne
    @JoinColumn(name = "author_id")
    var author : User = User(),
    @ManyToOne
    @JoinColumn(name = "receiver_id")
    var receiver : User = User(),
    @CreationTimestamp var createdAt : Instant? = null
)

@Entity
@Table(name = "project_messages")
data class ProjectMessage(
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    var id : Long? = null,
    var projectText : String = "Empty",
    @ManyToOne
    @JoinColumn(name = "author_id")
    var author : User = User(),
    @ManyToOne
    @JoinColumn(name = "project_id")
    var project: Project = Project(),
    @CreationTimestamp var createdAt : Instant? = null,
    @UpdateTimestamp var updatedAt : Instant? = null
)
