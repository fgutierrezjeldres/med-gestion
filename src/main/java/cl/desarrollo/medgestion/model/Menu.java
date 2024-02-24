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
@Table(name = "tbl_menu")
public class Menu {

    @Id
    @EqualsAndHashCode.Include
    private Integer idMenu;

    @Column(nullable = false, length = 60)
    private String icon;

    @Column(nullable = false, length = 60)
    private String name;

    @Column(nullable = false, length = 60)
    private String url;



    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "menu_rol",
            joinColumns = @JoinColumn(name = "id_menu", referencedColumnName = "idMenu"),
            inverseJoinColumns = @JoinColumn(name = "id_rol", referencedColumnName = "idRol")
    )
    private List<Rol> roles;
}
