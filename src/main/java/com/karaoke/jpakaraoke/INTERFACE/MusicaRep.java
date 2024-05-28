package com.karaoke.jpakaraoke.INTERFACE;

import com.karaoke.jpakaraoke.ENTIDAD.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

@Repository
public interface MusicaRep extends JpaRepository<Musica,Integer> {

    @Query("SELECT DISTINCT m.generoMusica FROM Musica m")
    List<String> findDistinctGeneroMusica();
}
