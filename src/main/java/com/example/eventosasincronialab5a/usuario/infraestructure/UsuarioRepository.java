package com.example.eventosasincronialab5a.usuario.infraestructure;

import com.example.eventosasincronialab5a.usuario.domain.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
