package com.jorge.usuario;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

 public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {
    Page<Usuario> findAll(Pageable pageable);
    Page<Usuario> findOne(Long id);
}