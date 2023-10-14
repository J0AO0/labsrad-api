package com.labsrad.reporsitory;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.labsrad.domain.Empresa;

public interface EmpresaRepository extends PagingAndSortingRepository<Empresa, Integer> {
	@Query(value = "SELECT * FROM empresa", nativeQuery = true)
	List<Empresa> findAllCat();

	@Query(value = "SELECT * FROM empresa where id = ?", nativeQuery = true)
	Empresa findPorId(Integer id);	

}
