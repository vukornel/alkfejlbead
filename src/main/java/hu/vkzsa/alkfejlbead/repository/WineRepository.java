package hu.vkzsa.alkfejlbead.repository;

import hu.vkzsa.alkfejlbead.entity.Wine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WineRepository extends JpaRepository<Wine, Long> {

    @Override
    List<Wine> findAll();

    @Override
    void delete(Wine wine);

    Wine findWineById(Long id);
}
