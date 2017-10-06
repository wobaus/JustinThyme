package com.JustinThyme.justinthymer.models.data;


import org.springframework.stereotype.Repository;

@Repository
@Transactional
public interface UserDao exends CrudRepository<User, Integer> {
}
