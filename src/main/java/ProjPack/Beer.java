package ProjPack;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="beers")
public class Beer {

    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name = "alc")
    private Double alc;
    @Column(name = "price")
    private String price;

    List<Cooker>cookers=new ArrayList<Cooker>();

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAlc(Double alc) {
        this.alc = alc;
    }
    public void setPrice(String price) {
        this.price = price;
    }
    public void setCookers(List<Cooker> cookers) {
        this.cookers = cookers;
    }
    @Id
    @Column(name="id")
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Double getAlc() {
        return alc;
    }
    public String getPrice() {
        return price;
    }
    @ManyToMany(targetEntity = Cooker.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="cookers_beers",
            joinColumns=@JoinColumn(name="beer_id"),
            inverseJoinColumns=@JoinColumn(name="cooker_id"))
    public List<Cooker> getCookers() {
        return cookers;
    }
}
