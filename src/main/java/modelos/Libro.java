package modelos;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import jakarta.validation.constraints.AssertTrue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "libros")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_libro", nullable = false)
    private Long id;

    @Column(name = "titulo_libro", nullable = false, length = 200)
    private String titulo;

    @Column(name = "fecha_publicacion_libro", nullable = false)
    private LocalDate fecha;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_autor", nullable = false)
    private Autor autor;

    @Transient
    @AssertTrue(message = "La fecha de publicación no puede ser futura")
    public boolean fechaValida() {
        return fecha != null && !fecha.isAfter(LocalDate.now());
    }
}
