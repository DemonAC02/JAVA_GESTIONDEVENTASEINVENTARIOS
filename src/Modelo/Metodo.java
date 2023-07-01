/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author demon
 */
public class Metodo {
    private int IdMetodo;
    private String Metodo;

    public Metodo(String Metodo) {
        this.Metodo = Metodo;
    }

    public int getIdMetodo() {
        return IdMetodo;
    }

    public Metodo(int IdMetodo, String Metodo) {
        this.IdMetodo = IdMetodo;
        this.Metodo = Metodo;
    }

    public void setIdMetodo(int IdMetodo) {
        this.IdMetodo = IdMetodo;
    }

    public String getMetodo() {
        return Metodo;
    }

    public void setMetodo(String Metodo) {
        this.Metodo = Metodo;
    }
    
}
