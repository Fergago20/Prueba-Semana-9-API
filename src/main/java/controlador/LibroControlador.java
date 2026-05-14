package controlador;

import modelos.Libro;
import org.springframework.web.bind.annotation.*;
import repositorios.LibroRepo;
import servicios.LibroServicio;

@RestController
@RequestMapping("/api/libros")
public class LibroControlador {
private LibroServicio libroServicio;

    public LibroControlador(LibroServicio libroServicio) {
        this.libroServicio = libroServicio;
    }

@GetMapping
    public Object getAllLibros() {
        return libroServicio.findAll();
    }
@GetMapping("/{id}")
    public Object getLibroById(@PathVariable Long id) {
        return libroServicio.findById(id);
    }

    @PostMapping()
    public Object createLibro(@RequestBody Libro libro) {
        return libroServicio.save(libro);
    }

    @PutMapping("/{id}")
public Libro updateLibro(@PathVariable Long id, @RequestBody Libro libro) {
    libro.setId(id);
    return libroServicio.save(libro);
    }

    @DeleteMapping("/{id}")
    public void deleteLibro(@PathVariable Long id) {
        libroServicio.deleteById(id);
    }
}
