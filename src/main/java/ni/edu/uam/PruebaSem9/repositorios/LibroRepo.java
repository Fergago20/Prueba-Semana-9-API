package ni.edu.uam.PruebaSem9.repositorios;

import ni.edu.uam.PruebaSem9.modelos.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepo extends JpaRepository<Libro, Long> {
}
