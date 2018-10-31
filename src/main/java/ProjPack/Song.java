package ProjPack;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="songs")
public class Song {

    private Integer id;
    @Column(name = "name")
    private String name;
    @Column(name="author")
    private String author;
    @Column(name="duration")
    private Time duration;
    private List<Singer>singers=new ArrayList<Singer>();

    public void setId(Integer id) {
        this.id = id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setDuration(Time duration) {
        this.duration = duration;
    }
    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }
    @Id
    @Column(name = "id")
    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Time getDuration() {
        return duration;
    }

    public String getAuthor() {
        return author;
    }
    @ManyToMany(targetEntity = Singer.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="singers_songs",
            joinColumns=@JoinColumn(name="song_id"),
            inverseJoinColumns=@JoinColumn(name="singer_id"))
    public List<Singer> getSingers() {
        return singers;
    }
}
