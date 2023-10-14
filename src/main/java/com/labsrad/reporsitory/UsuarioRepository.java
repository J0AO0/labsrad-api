package com.labsrad.reporsitory;

import com.labsrad.domain.Convenio;
import com.labsrad.domain.Usuario;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface UsuarioRepository extends PagingAndSortingRepository<Usuario, Integer> {
    @Query(value = "SELECT * FROM usuario", nativeQuery = true)
    List<Usuario> findAllCat();

    @Query(value = "SELECT * FROM usuario where id = ?", nativeQuery = true)
    Usuario findPorId(Integer id);

}
