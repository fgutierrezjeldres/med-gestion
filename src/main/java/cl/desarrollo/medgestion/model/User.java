package cl.desarrollo.medgestion.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;


@NoArgsConstructor
@AllArgsConstructor
@Data //  getter, setter, equalsandhashcode, tostring
@Entity
@EqualsAndHashCode(onlyExplicitlyIncluded = true) //
@Table(name = "tbl_user")
public class User {

    @Id
    @EqualsAndHashCode.Include
    private Integer idUser;

    @Column(nullable = false, length = 60, unique = true)
    private String username;
    @Column(nullable = false, length = 60)
    private String password;
    @Column(nullable = false)
    private boolean enabled;

    @ManyToMany(fetch = FetchType.EAGER)//se usa de esta manera cuando la data no es mucha
    @JoinTable(name = "user_rol",
            joinColumns = @JoinColumn(name = "id_user", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol")
    )
    private List<Rol> roles;


}
