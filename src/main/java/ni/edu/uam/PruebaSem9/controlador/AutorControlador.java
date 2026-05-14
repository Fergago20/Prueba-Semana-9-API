package ni.edu.uam.PruebaSem9.controlador;

import ni.edu.uam.PruebaSem9.modelos.Autor;
import org.springframework.web.bind.annotation.*;
import ni.edu.uam.PruebaSem9.servicios.AutorServicio;

import java.util.List;

@RestController
@RequestMapping("/api/autores")
public class AutorControlador {

    private final AutorServicio autorServicio;

    public AutorControlador(AutorServicio autorServicio) {
        this.autorServicio = autorServicio;
    }

    @GetMapping
    public List<Autor> listaAutores() {
        return autorServicio.findAll();
    }

    @GetMapping("/{id}")
    public Autor obtenerAutorPorId(@PathVariable Long id) {
        return autorServicio.findById(id);
    }

    @PostMapping
    public Autor crearAutor(@RequestBody Autor autor) {
        return autorServicio.save(autor, null);
    }

    @PutMapping("/{id}")
    public Autor actualizarAutor(@PathVariable Long id, @RequestBody Autor autor) {
        autor.setId(id);
        return autorServicio.save(autor, id);
    }

    @DeleteMapping("/{id}")
    public void eliminarAutor(@PathVariable Long id) {
        autorServicio.delete(id);
    }
}