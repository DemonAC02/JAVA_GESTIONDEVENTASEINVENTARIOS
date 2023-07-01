/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author demon
 */
public class Usuario {
    int IdUsuario;
    String usuario;
    String clave;
    int IdRol;

    public Usuario() {
    }

    public Usuario(String usuario, String clave, int IdRol) {
        this.usuario = usuario;
        this.clave = clave;
        this.IdRol = IdRol;
    }

    public Usuario(int IdUsuario,int IdRol, String usuario, String clave) {
        this.IdUsuario = IdUsuario;
        this.usuario = usuario;
        this.clave = clave;
        this.IdRol = IdRol;
    }



    public Usuario(String usuario, String clave) {
        this.usuario = usuario;
        this.clave = clave;
    }



    public int getIdUsuario() {
        return IdUsuario;
    }

    public void setIdUsuario(int IdUsuario) {
        this.IdUsuario = IdUsuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int IdRol) {
        this.IdRol = IdRol;
    }
    

        
}
