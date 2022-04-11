package com.example.exemplo1.Modelos;

public class Usuario implements Cloneable{
    private int id;
    private String login;
    private String senha;
    private String email;


    public Usuario (){}

    public Usuario(String login, String senha){
        this.login=login;
        this.senha=senha;

    }

    public Usuario( int id, String login, String senha){
        this.id=id;
        this.login=login;
        this.senha=senha;

    }
    public Usuario(Usuario u){
        this.id=u.id;
        this.login=u.login;
        this.senha=u.senha;
        this.email= u.email;


    }

    public int getId () {
        return this.id;
    }

    public void setId(int id){
        this.id=id;
    }

    public String getLogin () {
        return this.login;
    }

    public void setLogin(String login){ this.login=login; }

    public String getSenha(){
        return this.senha;
    }

    public void setSenha (String senha) {
        this.senha =senha;
    }

    public String getEmail(){return  this.senha;}

    public void setEmail(String email){this.email= email;}


@Override
    public Object clone(){
        Usuario clone= new Usuario(this);
        return clone;
    }

}
