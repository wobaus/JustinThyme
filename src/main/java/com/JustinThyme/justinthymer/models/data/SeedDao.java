package com.JustinThyme.justinthymer.models.data;

import com.JustinThyme.justinthymer.models.forms.Seed;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

import javax.transaction.Transactional;
//note need to get this library in package ?

@Repository
@Transactional
public interface SeedDao extends CrudRepository<Seed, Integer> {
}
