package com.karaoke.jpakaraoke.CONTROLADOR;
import com.karaoke.jpakaraoke.ENTIDAD.Usuario;
import com.karaoke.jpakaraoke.INTERFACE.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UsuarioControlador {

    @Autowired
    private UsuarioRep rep;


    @PostMapping("/crearUsr")//crea usuarios
    public Usuario addUsuario(@RequestBody Usuario usuario){
        return rep.save(usuario);
    }

    @GetMapping(value = "/listaUsr")
    public ResponseEntity<List<Usuario>> getCuentas() {
        List<Usuario> usuarios = rep.findAll();
        return new ResponseEntity<>(usuarios, HttpStatus.OK);
    }

}
