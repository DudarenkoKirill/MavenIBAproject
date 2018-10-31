package ProjPack;

import Exceptions.MyException;

public class Admin extends User {

public void addUsers(){
    try{
    Event event=new Festival();
    event.addUser();
}catch (MyException my){
        my.getMessage();
    }
}
}
