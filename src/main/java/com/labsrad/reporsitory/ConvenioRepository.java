package com.labsrad.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.labsrad.domain.Convenio;



public interface ConvenioRepository extends PagingAndSortingRepository<Convenio, Integer> {
	@Query(value = "SELECT * FROM convenio", nativeQuery = true)
	List<Convenio> findAllCat();

	@Query(value = "SELECT * FROM convenio where id = ?", nativeQuery = true)
	Convenio findPorId(Integer id);	

}
