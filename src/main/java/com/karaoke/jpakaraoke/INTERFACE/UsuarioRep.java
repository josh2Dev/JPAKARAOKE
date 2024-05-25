package com.karaoke.jpakaraoke.INTERFACE;

import com.karaoke.jpakaraoke.ENTIDAD.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRep extends JpaRepository<Usuario,Integer> {

     // Método para invocar el SP
     @Procedure(name = "sp_karaoke_login")
     int sp_karaoke_login(@Param("nombre") String nombre, @Param("contrasena") String contrasena);
}
