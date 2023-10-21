package com.patikadev.Model;

public class User {

    private int id;
    private  String name;
    private String username;
    private String pass;
    private  String  type;

    public User(){

    }


    // CONSTRUCTOR...
    public User(int id, String name, String username, String pass, String type){
        this.id = id;
        this.name = name;
        this.username = username;
        this.pass = pass;
        this.type = type;
    }


    // GETTER AND SETTER METHODS...
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getUsername(){
        return  username;
    }
    public void setUsername(String username){
        this.username= username;
    }
     public String getPass(){
        return pass;
     }
     public void setPass(String pass){
        this.pass = pass;
     }

     public String getType(){
        return type;
     }
     public void setType(String type){
        this.type = type;
     }












}

