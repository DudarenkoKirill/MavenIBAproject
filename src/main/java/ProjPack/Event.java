package ProjPack;

import Exceptions.MyException;

import javax.persistence.*;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Entity
@Table(name="events")
public class Event {

    private Integer id;
    @Column(name="name")
    private String name;
    @Column(name="date")
    private Date date;
    @Column(name="time")
    private Time time;
    @Column(name="place")
    private String place;
    @Column(name="capacity")
    private Integer capacity;
    @Column(name="quantityOfUsers")
    private static Long QuantityOfUsers;
    @ElementCollection(targetClass=User.class)
    private List<User> users=new ArrayList<User>();
    @ElementCollection(targetClass=Cooker.class)
    private List<Cooker> cookers =new ArrayList<Cooker>();
    @ElementCollection(targetClass=Singer.class)
    private List<Singer> singers =new ArrayList<Singer>();
    public Event(){}
    public void setId(Integer id){this.id=id;}
    public void setName(String name) {
    this.name = name;
}
    public void setDate(Date date) {
        this.date = date;
    }
    public void setTime(Time time) {
        this.time = time;
    }
    public void setPlace(String place) {
        this.place = place;
    }
    public void setCapacity(Integer capacity) {
        this.capacity = capacity;
    }
    public static void setQuantityOfUsers(long quantityOfUsers) {
        QuantityOfUsers = quantityOfUsers;
    }
    public void setUsers(List<User> users) {
        this.users = users;
    }
    public void setCookers(List<Cooker> cookers) {
        this.cookers = cookers;
    }
    public void setSingers(List<Singer> singers) {
        this.singers = singers;
    }


    @Id
    @Column(name="event_id")
    public Integer getId() {
        return id;
    }
    public String getPlace() {
        return place;
    }
    public Integer getCapacity() {
        return capacity;
    }
    public static long getQuantityOfUsers() {
        return QuantityOfUsers;
    }
    public String getName() {
        return name;
    }
    public Date getDate() {
        return date;
    }
    public Time getTime() {
        return time;
    }

    @ManyToMany(targetEntity = User.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="users_events",
            joinColumns=@JoinColumn(name="event_id"),
            inverseJoinColumns=@JoinColumn(name="user_id"))
    public List<User> getUsers() {
        return users;
    }

    @ManyToMany(targetEntity = Cooker.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="events_cookers",
            joinColumns=@JoinColumn(name="event_id"),
            inverseJoinColumns=@JoinColumn(name="cooker_id"))
    public List<Cooker> getCookers() {
        return cookers;
    }

    @ManyToMany(targetEntity = Singer.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="events_singers",
            joinColumns=@JoinColumn(name="event_id"),
            inverseJoinColumns=@JoinColumn(name="singer_id"))
    public List<Singer> getSingers() {
        return singers;
    }


    public void addUser()throws MyException {
            if(QuantityOfUsers>capacity)
                throw new MyException("!!!Число пользователей переполнено!!!") ;

    }

}
