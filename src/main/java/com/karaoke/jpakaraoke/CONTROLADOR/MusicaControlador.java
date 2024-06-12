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

}
