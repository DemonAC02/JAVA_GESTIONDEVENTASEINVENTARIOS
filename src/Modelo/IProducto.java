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
public interface IProducto {
    void agregarProducto(Producto producto);
    boolean eliminarProducto(int id);  
    Boolean editarProducto(Producto pro);
    List<Producto> listarProductos();
    Producto buscarProducto(int pro);
     List<Rol> ListarRoles();
    
}
