package JavaProject.Sqlite.domain.user.entity;

import JavaProject.Sqlite.domain.user.entity.type.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String accountId;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    public void modifyInfo(String accountId, String name) {
        this.accountId = accountId;
        this.name = name;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
