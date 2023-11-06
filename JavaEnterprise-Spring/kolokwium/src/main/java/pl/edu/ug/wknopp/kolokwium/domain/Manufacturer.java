package pl.edu.ug.wknopp.kolokwium.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Manufacturer {
    private long id;
    private String name;
    private String nip;
    private List<PackOfCards> createdPacks  = new ArrayList<>();

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNip() {
        return nip;
    }

    public void setNip(String nip) {
        this.nip = nip;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "manufacturer", cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    public List<PackOfCards> getCreatedPacks() {
        return createdPacks;
    }

    public void setCreatedPacks(List<PackOfCards> createdPacks) {
        this.createdPacks = createdPacks;
    }

    @Override
    public String toString() {
        return "Manufacturer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", nip='" + nip + '\'' +
                '}';
    }
}
