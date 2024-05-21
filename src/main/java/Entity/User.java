package Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.security.Timestamp;

@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false)
    private String userEmail;

    @Column(nullable = false)
    private String userPassword;

    @Column(nullable = false)
    private Integer userPhone;

    @Column(nullable = false)
    private String userAddr;

    @Column(nullable = false)
    private String userImg;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'USER'")
    private String userRole;

    @Column(nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp createdAt;

    @Column(nullable = false, columnDefinition = "timestamp default CURRENT_TIMESTAMP")
    private Timestamp updatedAt;

    @Column(nullable = false, columnDefinition = "varchar(255) default 'no'")
    private String userIsDeleted;
}

