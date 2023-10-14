package com.labsrad.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.labsrad.domain.ExameConvenio;

public interface ExameConvenioRepository extends PagingAndSortingRepository<ExameConvenio, Integer> {
	@Query(value = "SELECT * FROM exame_convenio", nativeQuery = true)
	List<ExameConvenio> findAllCat();

	@Query(value = "SELECT * FROM exame_convenio where id = ?", nativeQuery = true)
	ExameConvenio findPorId(Integer id);	

}

