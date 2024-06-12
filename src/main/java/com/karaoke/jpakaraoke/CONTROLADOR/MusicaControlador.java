package com.karaoke.jpakaraoke.CONTROLADOR;
import com.karaoke.jpakaraoke.ENTIDAD.Musica;
import com.karaoke.jpakaraoke.INTERFACE.MusicaRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class MusicaControlador {

    @Autowired
    private MusicaRep rep;


    @PostMapping("/guardarMusica")//guardaMusica
    public Musica addUsuario(@RequestBody Musica musica){
        return rep.save(musica);
    }

    @GetMapping(value = "/listaMusica")//lista de Musicas
    public ResponseEntity<List<Musica>> getCuentas() {
        List<Musica> musicas = rep.findAll();
        return new ResponseEntity<>(musicas, HttpStatus.OK);
    }

        @GetMapping(value = "/listaGenerosMusica")
    public ResponseEntity<List<String>> getListaGenerosMusicales() {
        List<String> generosMusicales = rep.findDistinctGeneroMusica();
        return new ResponseEntity<>(generosMusicales, HttpStatus.OK);
    }

    @DeleteMapping("/eliminarMusica/{id}")
    public ResponseEntity<Void> eliminarMusica(@PathVariable Integer id) {
        if (!rep.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        rep.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/editarMusica/{id}")
    public ResponseEntity<Musica> editarMusica(@PathVariable Integer id, @RequestBody Musica musicaDetalles) {
        Optional<Musica> musicaOptional = rep.findById(id);
        if (!musicaOptional.isPresent()) {
            return ResponseEntity.notFound().build();
        }

        Musica musica = musicaOptional.get();
        musica.setNombreMusica(musicaDetalles.getNombreMusica());
        musica.setArtistaNombre(musicaDetalles.getArtistaNombre());
        musica.setGeneroMusica(musicaDetalles.getGeneroMusica());

        Musica musicaActualizada = rep.save(musica);
        return ResponseEntity.ok(musicaActualizada);
    }
}
