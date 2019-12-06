package hu.vkzsa.alkfejlbead.entity;

import javax.persistence.*;
import java.util.List;

@Entity
public class Storage {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String location;
    private int size;

    @OneToMany(mappedBy = "storedAt")
    private List<Beer> beerList;

    @OneToMany(mappedBy = "storedAt")
    private List<Wine> wineList;


    public Storage(String location, int size, List<Beer> beerList, List<Wine> wineList) {
        this.location = location;
        this.size = size;
        this.beerList = beerList;
        this.wineList = wineList;
    }

    public Storage() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public List<Beer> getBeerList() {
        return beerList;
    }

    public void setBeerList(List<Beer> beerList) {
        this.beerList = beerList;
    }

    public List<Wine> getWineList() {
        return wineList;
    }

    public void setWineList(List<Wine> wineList) {
        this.wineList = wineList;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", location='" + location + '\'' +
                ", size=" + size +
                ", beerList=" + beerList +
                ", wineList=" + wineList +
                '}';
    }
}
