package ni.edu.uam.PruebaSem9.servicios;

import ni.edu.uam.PruebaSem9.modelos.Autor;
import org.springframework.stereotype.Service;
import ni.edu.uam.PruebaSem9.repositorios.AutorRepo;

import java.util.List;

@Service
public class AutorServicio {
    private final AutorRepo autorRepo;

    public AutorServicio(AutorRepo autorRepo) {
        this.autorRepo = autorRepo;
    }

    public List<Autor> findAll() {
        return autorRepo.findAll();
    }
    public  Autor findById(Long id) {
        return autorRepo.findById(id).orElse(null);
    }

    public Autor save(Autor autor, Long id) {
        return autorRepo.save(autor);
    }
    public  void delete(Long id) {
        autorRepo.deleteById(id);
    }
}
