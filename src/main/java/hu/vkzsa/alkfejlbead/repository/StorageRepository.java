package hu.vkzsa.alkfejlbead.repository;

import hu.vkzsa.alkfejlbead.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StorageRepository extends JpaRepository<Storage, Long> {

    @Override
    List<Storage> findAll();

    Storage findStorageById(Long id);

}
