package hu.vkzsa.alkfejlbead.repository;

import hu.vkzsa.alkfejlbead.entity.Beer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BeerRepository extends JpaRepository<Beer, Long> {

    @Override
    List<Beer> findAll();

    @Override
    void delete(Beer beer);

    Beer findBeerById(Long id);
}
