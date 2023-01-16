package pl.edu.ug.wknopp.kolokwium.domain;

import javax.persistence.*;

@Entity
public class PackOfCards {
    private long id;
    private String title;
//    private Manufacturer manufacturer;
    private boolean fullPack;


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

//    @ManyToOne(cascade = CascadeType.PERSIST)
//    public Manufacturer getManufacturer() {
//        return manufacturer;
//    }
//
//    public void setManufacturer(Manufacturer manufacturer) {
//        this.manufacturer = manufacturer;
//    }

    public boolean getFullPack() {
        return fullPack;
    }

    public void setFullPack(boolean complete) {
        this.fullPack = complete;
    }
}
