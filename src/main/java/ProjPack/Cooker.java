package ProjPack;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="cookers")
public class Cooker  {
    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="salary")
    private Long salary;


    private List<Event> events=new ArrayList<Event>();
    private List<Beer> beers=new ArrayList<Beer>();
    @Id
    @Column(name="cooker_id")
    public Integer getId() {
        return id;
    }
    @ManyToMany(targetEntity = Event.class,fetch= FetchType.LAZY,cascade= CascadeType.ALL)
    @JoinTable(name="events_cookers",
            joinColumns=@JoinColumn(name="cooker_id"),
            inverseJoinColumns=@JoinColumn(name="event_id"))
    public List<Event> getEvents() {
        return events;
    }
    public String getName() {
        return name;
    }
    public Long getSalary() {
        return salary;
    }

    @ManyToMany(targetEntity = Cooker.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="cookers_beers",
            joinColumns=@JoinColumn(name="cooker_id"),
            inverseJoinColumns=@JoinColumn(name="beer_id"))
    public List<Beer> getBeers() {
        return beers;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(Long salary) {
        this.salary = salary;
    }
    public void setBeers(List<Beer> beers) {
        this.beers = beers;
    }
}
