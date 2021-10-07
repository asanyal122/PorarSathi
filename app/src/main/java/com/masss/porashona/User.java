package com.masss.porashona;

public class User {
    public String email;
    public String id;
    User()
    {

    }
    User(String _id , String _email)
    {
        id=_id;
        email=_email;
    }

    public String getEmail() {
        return email;
    }

    public String getId() {
        return id;
    }
}
