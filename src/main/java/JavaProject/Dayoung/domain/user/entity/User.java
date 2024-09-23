package JavaProject.Dayoung.domain.user.entity;

import JavaProject.Dayoung.domain.area.entity.Area;
import JavaProject.Dayoung.domain.user.entity.type.Role;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "varchar(30)", nullable = false, unique = true)
    private String accountId;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String email;

    @Column(columnDefinition = "varchar(100)", nullable = false)
    private String password;

    @Column(columnDefinition = "varchar(30)", nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(500)")
    private String introduction;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "area_id")
    private Area area;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    private Integer score;

    public void modifyInfo(String accountId, String name, Area area, String introduction) {
        this.accountId = accountId;
        this.name = name;
        this.area = area;
        this.introduction = introduction;
    }

    public void changePassword(String password) {
        this.password = password;
    }
}
