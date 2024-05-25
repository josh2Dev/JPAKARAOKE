package com.karaoke.jpakaraoke.CONTROLADOR;
import com.karaoke.jpakaraoke.ENTIDAD.Musica;
import com.karaoke.jpakaraoke.ENTIDAD.Usuario;
import com.karaoke.jpakaraoke.INTERFACE.UsuarioRep;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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


    @PostMapping("/login")
    public ResponseEntity<Integer> loginUser(@RequestParam String nombre, @RequestParam String contrasena) {
        int resultado = rep.sp_karaoke_login(nombre, contrasena);
        if (resultado == 1001) {
            // Login exitoso
            return ResponseEntity.ok(resultado); // Devuelve 1001 para indicar éxito
        } else {
            // Error en el login
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(resultado); // Devuelve 1002 para indicar error
        }
    }
}


