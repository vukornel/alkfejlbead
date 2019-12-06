package hu.vkzsa.alkfejlbead.service;

import hu.vkzsa.alkfejlbead.entity.Beer;
import hu.vkzsa.alkfejlbead.repository.BeerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BeerService {

    private BeerRepository beerRepository;

    @Autowired
    public void setBeerRepository(BeerRepository beerRepository) {
        this.beerRepository = beerRepository;
    }


    public List<Beer> findAllBeers(){
        return beerRepository.findAll();
    }

    public Beer findBeerById(Long id){
        return beerRepository.findBeerById(id);
    }

    public void deleteBeer(Beer b){
        beerRepository.delete(b);
    }

    public void saveBeer(Beer b){
        beerRepository.save(b);
    }

}