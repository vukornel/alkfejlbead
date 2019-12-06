package hu.vkzsa.alkfejlbead.service;

import hu.vkzsa.alkfejlbead.entity.Storage;
import hu.vkzsa.alkfejlbead.repository.StorageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StorageService {

    private StorageRepository storageRepository;

    @Autowired
    public void setStorageRepository(StorageRepository storageRepository) {
        this.storageRepository = storageRepository;
    }

    public List<Storage> findAllStorages(){
        return storageRepository.findAll();
    }

    public Storage findStorageById(Long id){
        return storageRepository.findStorageById(id);
    }

}
