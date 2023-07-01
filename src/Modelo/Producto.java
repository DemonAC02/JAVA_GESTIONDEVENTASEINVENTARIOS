/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author demon
 */
public class Producto {
    private int IdProducto;
    private String NombreProducto;
    private Double Precio;
    private Integer Stock;

    public Producto(int IdProducto, String NombreProducto, Double Precio, Integer Stock) {
        this.IdProducto = IdProducto;
        this.NombreProducto = NombreProducto;
        this.Precio = Precio;
        this.Stock = Stock;
    }

    public Producto(String NombreProducto, Double Precio, Integer Stock) {
        this.NombreProducto = NombreProducto;
        this.Precio = Precio;
        this.Stock = Stock;
    }

    public Producto() {
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public String getNombreProducto() {
        return NombreProducto;
    }

    public void setNombreProducto(String NombreProducto) {
        this.NombreProducto = NombreProducto;
    }

    public Double getPrecio() {
        return Precio;
    }

    public void setPrecio(Double Precio) {
        this.Precio = Precio;
    }

    public Integer getStock() {
        return Stock;
    }

    public void setStock(Integer Stock) {
        this.Stock = Stock;
    }
    
    
    
    
}
