package com.sage.tacocloudspringinaction.data;

import com.sage.tacocloudspringinaction.Taco;
import org.springframework.data.repository.CrudRepository;

public interface TacoRepository extends CrudRepository<Taco, Long> {
}
