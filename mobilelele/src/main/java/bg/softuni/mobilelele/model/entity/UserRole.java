package bg.softuni.mobilelele.model.entity;

import bg.softuni.mobilelele.model.entity.enums.Role;

import javax.persistence.*;

@Entity
@Table(name = "roles")
public class UserRole {
    private Long id;
    private Role role;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Column(name = "name")
    @Enumerated(EnumType.STRING)
    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }


}
