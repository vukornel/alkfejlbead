package hu.vkzsa.alkfejlbead.web.controller;


import hu.vkzsa.alkfejlbead.entity.Beer;
import hu.vkzsa.alkfejlbead.entity.Storage;
import hu.vkzsa.alkfejlbead.entity.Wine;
import hu.vkzsa.alkfejlbead.service.BeerService;
import hu.vkzsa.alkfejlbead.service.StorageService;
import hu.vkzsa.alkfejlbead.service.WineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drink")
public class DrinkController {
    private BeerService beerService;
    private WineService wineService;
    private StorageService storageService;

    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    @Autowired
    public void setBeerService(BeerService beerService) {
        this.beerService = beerService;
    }

    @Autowired
    public void setWineService(WineService wineService) {
        this.wineService = wineService;
    }

    @GetMapping("/beers")
    public List<Beer> beers(){
        return beerService.findAllBeers();
    }

    @GetMapping("/wines")
    public List<Wine> wines(){
        return wineService.findAllWines();
    }

    @GetMapping("/delete/{type}")
    public String delete(@PathVariable String type, @RequestParam Long id){

        switch (type) {
            case "beer":
                beerService.deleteBeer(beerService.findBeerById(id));
                return "Deletion successful";

            case "wine":
                wineService.deleteWine(wineService.findWineById(id));
                return "Deletion successful";
            default:
                return "Deletion unsuccessful";
        }

    }

    @GetMapping("/find/{drink}")
    public String findDrink(@PathVariable String drink, @RequestParam Long id){
        switch (drink) {
            case "beer":
                return beerService.findBeerById(id).toString();
            case "wine":
                return wineService.findWineById(id).toString();
            default:
                return "Oops, something went wrong.";
        }
    }

    @PostMapping("/{drink}/edit")
    public String editDrink(@PathVariable String drink, @RequestParam String data, @RequestParam Long id, @RequestParam String newData){
        switch (drink) {
            case "beer":
                Beer b = beerService.findBeerById(id);
                switch (data) {
                    case "type":
                        b.setType(newData);
                        beerService.saveBeer(b);
                        return "Data changed successfully.";
                    case "origin":
                        b.setOrigin(newData);
                        beerService.saveBeer(b);
                        return "Data changed successfully.";
                    case "amount":
                        b.setAmount(Integer.parseInt(newData));
                        beerService.saveBeer(b);
                        return "Data changed successfully.";
                    default:
                        return "There is no data of a beer like " + data;
                }
            case "wine":
                Wine w = wineService.findWineById(id);
                switch (data) {
                    case "type":
                        w.setType(newData);
                        wineService.saveWine(w);
                        return "Data changed successfully.";
                    case "color":
                        w.setColors(newData);
                        wineService.saveWine(w);
                        return "Data changed successfully.";
                    case "amount":
                        w.setAmount(Integer.parseInt(newData));
                        wineService.saveWine(w);
                        return "Data changed successfully.";
                    default:
                        return "There is no data of a wine like " + data;
                }
            default:
                return "Oops, something went wrong.";
        }
    }

    @PostMapping("/create/{drink}")
    public String createDrink(@PathVariable String drink, @RequestParam String d1, @RequestParam String d2, @RequestParam int amount, @RequestParam Long storedAtId){
        Storage storage = storageService.findStorageById(storedAtId);
        switch (drink) {
            case "beer":
                Beer b = new Beer(d1, d2, amount, storage);
                beerService.saveBeer(b);
                return "The following beer was saved successfully: " + b;
            case "wine":
                Wine w = new Wine(d1, d2, amount, storage);
                wineService.saveWine(w);
                return "The following wine was saved successfully: " + w;
            default:
                return "Oops, something went wrong.";
        }
    }




}
