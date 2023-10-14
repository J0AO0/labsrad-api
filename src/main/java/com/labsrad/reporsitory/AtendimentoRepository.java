package com.labsrad.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.labsrad.domain.Atendimento;

public interface AtendimentoRepository extends PagingAndSortingRepository<Atendimento, Integer> {
	@Query(value = "SELECT * FROM atendimento", nativeQuery = true)
	List<Atendimento> findAllCat();

	@Query(value = "SELECT * FROM atendimento where id = ?", nativeQuery = true)
	Atendimento findPorId(Integer id);	

}