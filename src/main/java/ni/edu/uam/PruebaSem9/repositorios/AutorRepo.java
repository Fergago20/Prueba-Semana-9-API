package ni.edu.uam.PruebaSem9.repositorios;

import ni.edu.uam.PruebaSem9.modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepo extends JpaRepository<Autor, Long> {
}
