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
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String accountId;

    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
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
