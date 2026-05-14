package ni.edu.uam.PruebaSem9.servicios;

import ni.edu.uam.PruebaSem9.modelos.Libro;
import org.springframework.stereotype.Service;
import ni.edu.uam.PruebaSem9.repositorios.LibroRepo;

import java.util.List;

@Service
public class LibroServicio {
    private final LibroRepo libroRepo;

    public LibroServicio(LibroRepo libroRepo) {
        this.libroRepo = libroRepo;
    }

    public List<Libro> findAll() {
        return libroRepo.findAll();
    }

    public Libro findById(Long id) {
        return libroRepo.findById(id).orElse(null);
    }

    public Libro save(Libro libro) {
        return libroRepo.save(libro);
    }

    public void deleteById(Long id) {
        libroRepo.deleteById(id);
    }
}
