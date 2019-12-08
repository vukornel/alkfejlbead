package hu.vkzsa.alkfejlbead.repository;

import hu.vkzsa.alkfejlbead.entity.User;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {

    User findByEmail(String email);
}
