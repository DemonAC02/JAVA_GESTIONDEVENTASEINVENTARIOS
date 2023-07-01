/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Modelo;

import java.util.List;

/**
 *
 * @author demon
 */
public interface IVenta {
    void agregarVenta(Venta vnt);
    public boolean ActualizarStock(int cant , int id);
    List<Venta> Listarventas();
    Venta BuscarVenta(int id);
    void RegistarDetalle(Detalle det);
    public int IdVenta();
    List<Metodo> listarMetodos();
    List<Cliente> listarClientes();
    void RegistarCliente(Cliente cli);    
}
