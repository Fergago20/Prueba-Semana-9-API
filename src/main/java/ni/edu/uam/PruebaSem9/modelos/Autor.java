package ni.edu.uam.PruebaSem9.modelos;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "autores")
@AllArgsConstructor
@NoArgsConstructor
@Getter @Setter
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_autor", nullable = false)
    private Long id;

    @Column(name = "nombre_autor", nullable = false, length = 100, unique = true)
    private String nombre;

    @Column(name = "fecha_nacimiento_autor", nullable = false)
    private LocalDate fechaNacimiento;

}
