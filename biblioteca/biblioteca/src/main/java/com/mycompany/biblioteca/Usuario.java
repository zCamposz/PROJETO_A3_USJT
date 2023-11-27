package com.mycompany.biblioteca;

public class Usuario {
        private int id_login;
        private String login;
        private String senha;
        private String tipo_login;

    public String getTipo_login() {
        return tipo_login;
    }

    public void setTipo_login(String tipo_login) {
        this.tipo_login = tipo_login;
    }

    public int getId_login() {
        return id_login;
    }

    public void setId_login(int id_login) {
        this.id_login = id_login;
    }
        

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
         
         
         
    }
