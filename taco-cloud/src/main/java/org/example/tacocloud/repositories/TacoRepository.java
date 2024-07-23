package org.example.tacocloud.repositories;

import org.example.tacocloud.domains.Taco;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TacoRepository
        extends CrudRepository<Taco, Long>, PagingAndSortingRepository<Taco, Long> {

}