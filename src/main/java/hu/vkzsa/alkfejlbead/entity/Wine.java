package hu.vkzsa.alkfejlbead.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
public class Wine {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;
    private String colors;
    private int amount;

    @JsonBackReference
    @ManyToOne
    private Storage storedAt;

    public Wine(String type, String colors, int amount, Storage storedAt) {
        this.type = type;
        this.colors = colors;
        this.amount = amount;
        this.storedAt = storedAt;
    }

    public Wine() {
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

    public String getColors() {
        return colors;
    }

    public void setColors(String colors) {
        this.colors = colors;
    }

    public Storage getStoredAt() {
        return storedAt;
    }

    public void setStoredAt(Storage storedAt) {
        this.storedAt = storedAt;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Wine{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", colors='" + colors + '\'' +
                ", amount=" + amount +
                ", storedAt=" + storedAt +
                '}';
    }
}
