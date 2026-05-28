package com.example.demo.repository;

import com.example.demo.models.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    // Buscar usuario por username
    Optional<Usuario> findByUsername(String username);

    // Buscar usuarios activos/inactivos
    List<Usuario> findByEstado(boolean estado);

    // Verificar username repetido
    boolean existsByUsername(String username);

    // Buscar usuarios por rol
    @Query("""
        SELECT u
        FROM Usuario u
        JOIN u.roles r
        WHERE r.nombre = :rol
    """)
    List<Usuario> buscarPorRol(String rol);

    // Buscar usuario por empleado
    Optional<Usuario> findByEmpleadoId(Long empleadoId);
}