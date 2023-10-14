package com.labsrad.reporsitory;

import com.labsrad.domain.Paciente;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PacienteRepository extends PagingAndSortingRepository<Paciente, Integer> {
    @Query(value = "SELECT * FROM paciente", nativeQuery = true)
    List<Paciente> findAllCat();

    @Query(value = "SELECT * FROM paciente where id = ?", nativeQuery = true)
    Paciente findPorId(Integer id);
}
