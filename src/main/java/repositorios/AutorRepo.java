package repositorios;

import modelos.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepo extends JpaRepository<Autor, Long> {
}
