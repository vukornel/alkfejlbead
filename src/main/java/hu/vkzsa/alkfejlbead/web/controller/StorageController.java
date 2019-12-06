package hu.vkzsa.alkfejlbead.web.controller;

import hu.vkzsa.alkfejlbead.entity.Storage;
import hu.vkzsa.alkfejlbead.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/storage")
public class StorageController {

    private StorageService storageService;

    @Autowired
    public void setStorageService(StorageService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/storages")
    List<Storage> storages(){
        return storageService.findAllStorages();
    }
}