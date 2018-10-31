package ProjPack;

import DAO.EventDao;
import org.hibernate.Session;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Entity
@Table(name="users")
public class User {

    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="login",unique = true)
    private String login;
    @Column(name = "password")
    private String password;
    @Column(name = "role")
    private Integer role;
    @Column(name = "phonenumber")
    private String phonenumber;
    @Column(name = "email")
    private String email;

    @ElementCollection(targetClass=Event.class)
    private List<Event> events=new ArrayList<Event>();

    public static void main(String[] args) {
//      UserService userService=new UserService();
//       User user=userService.findUser(1);
//       for(Event event:user.getEvents())
//           System.out.println(event.getName());
        EventDao eventDao=new EventDao();
        Event event=eventDao.findById(1);
        for(Cooker user:event.getCookers())
           System.out.println(user.getName());
    }
    public void setLogin(String login) {
        this.login = login;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public void setEvents(List<Event> events) {
        this.events = events;
    }
    public void setRole(Integer role) {
        this.role = role;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        Pattern p=Pattern.compile("^(\\+375|80)[\\s-]?(29|44|33|25)[\\s-]?(\\d{7}|\\d{3}[\\s-]?\\d{2}[\\s-]?\\d{2})");
        Matcher matcher=p.matcher(phoneNumber);
        try{
            if(!matcher.matches())
                throw new IllegalArgumentException("!Недопустимое входное значение для номера телефона!");
            else {
                this.phonenumber=phoneNumber;
                System.out.println("Номер успешно добавлен");
            }
        }catch (IllegalArgumentException e){
            e.getMessage();
        }
    }
    public void setEmail(String email)
    {
        Pattern p=Pattern.compile("(\\d|\\w)*@{1}(mail|gmail)\\.{1}(ru|com)$");
        Matcher matcher=p.matcher(email);
        try{
            if(!matcher.matches()) {
                throw new IllegalArgumentException("!Недопустимое входное значение для email!");
            }
            else
                System.out.println("email успешно добавлен");
        }catch (IllegalArgumentException e){
            e.printStackTrace();
        }
    }
    @Id
    @Column(name = "user_id")
    public Integer getId() {
        return id;
    }
    public String getLogin() { return login; }
    public String getPassword() { return password; }
    public Integer getRole() {
        return role;
    }
    public String getPhoneNumber() {
        return phonenumber;
    }
    public String getEmail() {
        return email;
    }




    @ManyToMany(targetEntity = Event.class,fetch=FetchType.LAZY,cascade=CascadeType.ALL)
    @JoinTable(name="users_events",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="event_id"))
    public List<Event> getEvents() {
        return events;
    }
}
