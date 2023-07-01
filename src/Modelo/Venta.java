/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author demon
 */
public class Venta {
    private int IdVenta;
    private double Monto;
    private String NombreCompr;
    private int DniCompr;
    private int IdMetodoPago;
    private String FechaVenta;

    public Venta() {
    }

    public String getFechaVenta() {
        return FechaVenta;
    }

    public void setFechaVenta(String FechaVenta) {
        this.FechaVenta = FechaVenta;
    }

    public Venta(double Monto, String NombreCompr, int DniCompr, int IdMetodoPago, String FechaVenta) {
        this.Monto = Monto;
        this.NombreCompr = NombreCompr;
        this.DniCompr = DniCompr;
        this.IdMetodoPago = IdMetodoPago;
        this.FechaVenta = FechaVenta;
    }

    public Venta(int IdVenta, double Monto, String NombreCompr, int DniCompr, int IdMetodoPago, String FechaVenta) {
        this.IdVenta = IdVenta;
        this.Monto = Monto;
        this.NombreCompr = NombreCompr;
        this.DniCompr = DniCompr;
        this.IdMetodoPago = IdMetodoPago;
        this.FechaVenta = FechaVenta;
    }
    

   
    


    public int getIdVenta() {
        return IdVenta;
    }

    public void setIdVenta(int IdVenta) {
        this.IdVenta = IdVenta;
    }

    public double getMonto() {
        return Monto;
    }

    public void setMonto(double Monto) {
        this.Monto = Monto;
    }

    public String getNombreCompr() {
        return NombreCompr;
    }

    public void setNombreCompr(String NombreCompr) {
        this.NombreCompr = NombreCompr;
    }

    public int getDniCompr() {
        return DniCompr;
    }

    public void setDniCompr(int DniCompr) {
        this.DniCompr = DniCompr;
    }

    public int getIdMetodoPago() {
        return IdMetodoPago;
    }

    public void setIdMetodoPago(int IdMetodoPago) {
        this.IdMetodoPago = IdMetodoPago;
    }
    
    
    
}
