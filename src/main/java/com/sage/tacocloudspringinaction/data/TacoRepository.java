package com.sage.tacocloudspringinaction.data;

import com.sage.tacocloudspringinaction.Taco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import java.net.ContentHandler;

public interface TacoRepository extends CrudRepository<Taco, Long> {
    Page<Taco> findAll(Pageable pageable);
}
