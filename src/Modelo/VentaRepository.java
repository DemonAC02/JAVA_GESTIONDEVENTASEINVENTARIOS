/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author demon
 */
public class VentaRepository implements IVenta{

    private String URL = "jdbc:mysql://localhost:3306/db_tienda";
    private String usuario = "root";
    private String password = "";
    public VentaRepository(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void agregarVenta(Venta vnt) {
        String sql = "insert into tb_venta(MontoTotal,NombreCompleto,IdMetodoPago,DNI,Fecha) values(?,?,?,?,?)";
        try{
            Connection connection = DriverManager.getConnection(URL, usuario, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setDouble(1,vnt.getMonto());
             statement.setString(2,vnt.getNombreCompr());
             statement.setInt(3,vnt.getIdMetodoPago());
              statement.setInt(4,vnt.getDniCompr());
                statement.setString(5, vnt.getFechaVenta());
            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public boolean ActualizarStock(int cant, int id) {
        String sql = "UPDATE tb_productos SET Stock = ? WHERE IdProducto = ?";
        try {
            Connection connection = DriverManager.getConnection(URL, usuario, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,cant);
            statement.setInt(2, id);
            statement.execute();
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Venta> Listarventas() {
        List<Venta> listaVe = new ArrayList<>();
    String sql = "SELECT * FROM tb_venta";
    try {
        Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int IdVe = resultSet.getInt("IdVenta");
            double Mont = resultSet.getDouble("MontoTotal");
            String NomVe = resultSet.getString("NombreCompleto");
            int Dnive = resultSet.getInt("Dni");
             int IdMe = resultSet.getInt("IdMetodoPago");
            String FechV = resultSet.getString("Fecha");
            Venta Nvtn = new Venta(IdVe,Mont,NomVe,Dnive,IdMe,FechV);
            listaVe.add(Nvtn);
            
            
        }
    } catch (SQLException e) {  
        e.printStackTrace();
    }
    return listaVe;
    }

    @Override
    public Venta BuscarVenta(int id) {
         Venta cl = new Venta();
        String sql = "SELECT * FROM tb_venta WHERE IdVenta = ?";
        try {
            Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setInt(1, id);
        ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                cl.setIdVenta(resultSet.getInt("IdVenta"));
                cl.setMonto(resultSet.getDouble("Total"));
                cl.setDniCompr(resultSet.getInt("DNI"));
                cl.setNombreCompr(resultSet.getString("NombreCompleto"));
                cl.setIdMetodoPago(resultSet.getInt("IdMetodoPago"));
                cl.setFechaVenta(resultSet.getString("Fecha"));
            }
        } catch (SQLException e) {  
        e.printStackTrace();
    }
        return cl;
    }

    @Override
    public void RegistarDetalle(Detalle det) {
        String sql = "INSERT INTO tb_detalleventa (IdVenta, IdProducto, Cantidad,Total) VALUES (?,?,?,?)";
        try {
            Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, det.getIdVenta());
            statement.setInt(2, det.getIdProducto());
            statement.setInt(3, det.getCantidad());
             statement.setDouble(4, det.getPrecio());
            statement.execute();
        } catch (SQLException e) {  
        e.printStackTrace();
    }
        
    }

    @Override
    public int IdVenta() {
        int id = 0;
        String sql = "SELECT MAX(IdVenta) FROM tb_venta";
        try {
            Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                id = resultSet.getInt(1);
            }
        } catch (SQLException e) {  
        e.printStackTrace();
        }
        return id;
    }

    @Override
    public List<Metodo> listarMetodos() {
        List<Metodo> listaMe = new ArrayList<>();
    String sql = "SELECT * FROM tb_metodopago";
    try {
        Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int IdMe = resultSet.getInt("IdMetodoPago");
            String nombremet = resultSet.getString("MetodoPago");
            Metodo meto = new Metodo(IdMe,nombremet);
            listaMe.add(meto);
        }
    } catch (SQLException e) {  
        e.printStackTrace();
    }
    return listaMe;
    }

    @Override
    public List<Cliente> listarClientes() {
        List<Cliente> listaCli = new ArrayList<>();
    String sql = "SELECT * FROM tb_cliente";
    try {
        Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int IdCli = resultSet.getInt("IdCliente");
            String nombrecli = resultSet.getString("NombreCompleto");
            int Dnicli = resultSet.getInt("DNI");
           Cliente clie = new Cliente(IdCli,Dnicli, nombrecli);
            listaCli.add(clie);
        }
    } catch (SQLException e) {  
        e.printStackTrace();
    }
    return listaCli;
    }

    @Override
    public void RegistarCliente(Cliente cli) {
        String sql = "insert into tb_cliente(NombreCompleto,Dni) values(?,?)";
        try{
            Connection connection = DriverManager.getConnection(URL, usuario, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1,cli.getNombreCli());
             statement.setInt(2,cli.getDniCli());
            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    

    
    
}
