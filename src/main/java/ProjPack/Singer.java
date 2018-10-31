package ProjPack;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@Entity
@Table(name="singers")
public class Singer {

    private Integer id;
    @Column(name="singer_name")
    private String name;
    @Column(name="singer_salary")
    private Long salary;

    private List<Event> events=new ArrayList<Event>();
    private List<Song> songs=new ArrayList<Song>();

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setSalary(Long salary) {
        this.salary = salary;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    @Id
    @Column(name="singer_id")
    public Integer getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public Long getSalary() {
        return salary;
    }
    @ManyToMany(targetEntity = Event.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="events_singers",
            joinColumns=@JoinColumn(name="singer_id"),
            inverseJoinColumns=@JoinColumn(name="event_id"))
    public List<Event> getEvents() {
        return events;
    }
    @ManyToMany(targetEntity = Song.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="singers_songs",
            joinColumns=@JoinColumn(name="singer_id"),
            inverseJoinColumns=@JoinColumn(name="song_id"))
    public List<Song> getSongs() {
        return songs;
    }
}
