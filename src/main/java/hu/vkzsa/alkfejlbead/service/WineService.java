package hu.vkzsa.alkfejlbead.service;

import hu.vkzsa.alkfejlbead.entity.Wine;
import hu.vkzsa.alkfejlbead.repository.WineRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WineService {

    private WineRepository wineRepository;

    @Autowired
    public void setWineRepository(WineRepository wineRepository) {
        this.wineRepository = wineRepository;
    }

    public List<Wine> findAllWines(){
        return wineRepository.findAll();
    }

    public Wine findWineById(Long id){
        return wineRepository.findWineById(id);
    }

    public void deleteWine(Wine w){
        wineRepository.delete(w);
    }

    public void saveWine(Wine w){
        wineRepository.save(w);
    }

}
