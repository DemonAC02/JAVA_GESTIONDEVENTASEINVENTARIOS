/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author demon
 */
public class Detalle {
    private int IdDetalle;
    private int IdProducto;
    private int IdVenta;
    private int Cantidad;
    private double Precio;

    public Detalle() {
    }

    public Detalle(int IdDetalle, int IdProducto, int IdVenta, int Cantidad, double Precio) {
        this.IdDetalle = IdDetalle;
        this.IdProducto = IdProducto;
        this.IdVenta = IdVenta;
        this.Cantidad = Cantidad;
        this.Precio = Precio;
    }

    public int getIdDetalle() {
        return IdDetalle;
    }

    public void setIdDetalle(int IdDetalle) {
        this.IdDetalle = IdDetalle;
    }

    public int getIdProducto() {
        return IdProducto;
    }

    public void setIdProducto(int IdProducto) {
        this.IdProducto = IdProducto;
    }

    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public double getPrecio() {
        return Precio;
    }

    public void setPrecio(double Precio) {
        this.Precio = Precio;
    }
    
}

