package pl.edu.ug.wknopp.kolokwium.domain;

import javax.persistence.*;

@Entity
public class PackOfCards {
    private long id;
    private String title;
    private Manufacturer manufacturer;
    private boolean fullPack;
    private Theme theme;


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

    @ManyToOne(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isFullPack() {
        return fullPack;
    }

    public void setFullPack(boolean complete) {
        this.fullPack = complete;
    }

    @OneToOne(cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
    public Theme getTheme() {
        return theme;
    }

    public void setTheme(Theme theme) {
        this.theme = theme;
    }

    @Override
    public String toString() {
        return "PackOfCards{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", manufacturer=" + manufacturer +
                ", fullPack=" + fullPack +
                ", theme=" + theme +
                '}';
    }
}
