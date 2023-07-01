/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.*;
import javax.swing.JOptionPane;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 *
 * @author demon
 */
public class ProductoRepository implements IProducto{

    private String URL = "jdbc:mysql://localhost:3306/db_tienda";
    private String usuario = "root";
    private String password = "";
    public ProductoRepository(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void agregarProducto(Producto producto) {
        String sql = "insert into tb_productos(Producto,Precio,Stock) values(?,?,?)";
        try{
            Connection connection = DriverManager.getConnection(URL, usuario, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,producto.getNombreProducto());
            statement.setDouble(2,producto.getPrecio());
            statement.setInt(3, producto.getStock());
            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean eliminarProducto(int id) {
        String sql = "DELETE FROM tb_productos WHERE IdProducto = ?";
        try (Connection connection = DriverManager.getConnection(URL, usuario, password);
     PreparedStatement statement = connection.prepareStatement(sql)) {
    statement.setInt(1, id);
    statement.execute();
    return true;
} catch (Exception e) {
    e.printStackTrace();
    return false;
}

        
        
    }

    @Override
    public List<Producto> listarProductos() {
    List<Producto> listaPR = new ArrayList<>();
    String sql = "SELECT * FROM tb_productos";
    try {
        Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int IdPRO = resultSet.getInt("IdProducto");
            String nombrepro = resultSet.getString("Producto");
            double precio = resultSet.getDouble("Precio");
            int stock = resultSet.getInt("Stock");
            Producto producto = new Producto(IdPRO,nombrepro, precio, stock);
            listaPR.add(producto);
        }
    } catch (SQLException e) {  
        e.printStackTrace();
    }
    return listaPR;
}

    @Override
    public Boolean editarProducto(Producto pro) {
        String sql = "UPDATE tb_productos SET Producto=?, Precio=?, Stock=? WHERE IdProducto=?";
       try {
           Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, pro.getNombreProducto());
        statement.setDouble(2, pro.getPrecio());
        statement.setInt(3, pro.getStock());
        statement.setInt(4,pro.getIdProducto());
        statement.execute();
        return true;
    } catch (SQLException e) {

         e.printStackTrace();
           return false;
          
}
    }

    @Override
    public Producto buscarProducto(int pro) {
        Producto pr = new Producto();
        String sql = "SELECT * FROM tb_productos WHERE IdProducto = ?";
        try {
            Connection connection = DriverManager.getConnection(URL, usuario, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, pro);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int id = resultSet.getInt("IdProducto");
                String nombrepro = resultSet.getString("Producto");
                double precio = resultSet.getDouble("Precio");
                int stock = resultSet.getInt("Stock");
                pr.setIdProducto(id);
                pr.setNombreProducto(nombrepro);
                pr.setPrecio(precio);
                pr.setStock(stock);
                
                
                
            }
                

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pr;
        
    }

    @Override
    public List<Rol> ListarRoles() {
         List<Rol> listaRols = new ArrayList<>();
        String sql = "select * from tb_rol";
        try{
            Connection connection = DriverManager.getConnection(URL, usuario, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery();
            //a partir de resultSet creamos una lista de objetos de la clase Genero
            while(resultSet.next()){
                int idrol = resultSet.getInt("IdRol");
                String nomrl = resultSet.getString("Rol");
                Rol rol = new Rol(nomrl);
                listaRols.add(rol);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return listaRols;
    }


}
