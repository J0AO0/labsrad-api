package com.labsrad.reporsitory;

import com.labsrad.domain.Convenio;
import com.labsrad.domain.Paciente;
import com.labsrad.domain.Patrimonio;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

public interface PatrimonioReporsitoty extends PagingAndSortingRepository<Patrimonio, Integer> {
    @Query(value = "SELECT * FROM patrimonio", nativeQuery = true)
    List<Patrimonio> findAllCat();

    @Query(value = "SELECT * FROM patrimonio where id = ?", nativeQuery = true)
    Patrimonio findPorId(Integer id);
}
