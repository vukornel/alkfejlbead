package hu.vkzsa.alkfejlbead.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;


@Entity
public class Beer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String origin;
    private int amount;

    @JsonBackReference
    @ManyToOne
    private Storage storedAt;


    public Beer() {
    }

    public Beer(String type, String origin, int amount, Storage storedAt) {
        this.type = type;
        this.origin = origin;
        this.amount = amount;
        this.storedAt = storedAt;
    }

    public int getAmount() {

        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public Storage getStoredAt() {
        return storedAt;
    }

    public void setStoredAt(Storage storedAt) {
        this.storedAt = storedAt;
    }

    @Override
    public String toString() {
        return "Beer{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", origin='" + origin + '\'' +
                ", amount=" + amount +
                ", storedAt=" + storedAt +
                '}';
    }


}
