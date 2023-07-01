/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;
import Vista.Empleado;
import Vista.Administrador;
import java.sql.*;
import javax.swing.JOptionPane;
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
public class UsuarioRepository implements IUsuario{
    private String URL = "jdbc:mysql://localhost:3306/db_tienda";
    private String usuario = "root";
    private String password = "";
    public UsuarioRepository(){
        try{
        }catch(Exception e){
            e.printStackTrace();
        }
    }
   
    @Override
    public Boolean validarUsuario(Usuario objUsu) 
    {
    String sql = "SELECT * FROM tb_usuario WHERE Usuario = ?";
    try {
        Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, objUsu.getUsuario());
        ResultSet resultSet = statement.executeQuery();

        if (resultSet.next()) {
            String p = resultSet.getString("Clave");
            String rol = resultSet.getString("IdRol");

            if (objUsu.getClave().equals(p)) {
                if("1".equals(rol))
                {
                    Administrador admin = new Administrador();
                        admin.setVisible(true);
                        return true;
                }
                else
                {
                    Empleado empl = new Empleado();
                    empl.setVisible(true);
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null, "La contraseña es incorrecta.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "El usuario no existe.");
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
    return false;
}

    

    @Override
    public boolean eliminarUsuario(int id) {
        String sql = "DELETE FROM tb_usuario WHERE IdUsuario = ?";
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
    public boolean editarUsuario(Usuario usus) {
        String sql = "UPDATE tb_usuario SET Usuario=?, Clave=?, IdRol=? WHERE IdUsuario=?";
       try {
           Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, usus.getClave());
        statement.setString(2, usus.getClave());
        statement.setInt(3, usus.getIdRol());
        statement.setInt(4,usus.getIdUsuario());
        statement.execute();
        return true;
    } catch (SQLException e) {

         e.printStackTrace();
           return false;
          
}
    }

    @Override
    public List<Usuario> listarUsuarios() {
        List<Usuario> listaUS = new ArrayList<>();
    String sql = "SELECT * FROM tb_usuario";
    try {
        Connection connection = DriverManager.getConnection(URL, usuario, password);
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet resultSet = statement.executeQuery();
        while (resultSet.next()) {
            int IdUs = resultSet.getInt("IdUsuario");
            int IdRolUs = resultSet.getInt("IdRol");
            String NomUs = resultSet.getString("Usuario");
            String ClaveUs = resultSet.getString("Clave");
            Usuario uSuS = new Usuario(IdUs, IdRolUs,NomUs,ClaveUs);
            listaUS.add(uSuS);
        }
    } catch (SQLException e) {  
        e.printStackTrace();
    }
    return listaUS;
    }

    

    @Override
    public void agregarUsuario(Usuario usu) {
        String sql = "insert into tb_usuario(IdRol,Usuario,Clave) values(?,?,?)";
        try{
            Connection connection = DriverManager.getConnection(URL, usuario, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1,usu.getIdRol());
            statement.setString(2,usu.getUsuario());
            statement.setString(3, usu.getClave());
            statement.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
        
        
    @Override
    public Usuario buscarUsuario(int id){
        Usuario us = new Usuario();
        String sql = "SELECT * FROM tb_usuario WHERE IdUsuario = ?";
        try {
            Connection connection = DriverManager.getConnection(URL, usuario, password);
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                int idu = resultSet.getInt("IdUsuario");
                String usv = resultSet.getString("Usuario");
                String clv = resultSet.getString("Clave");
                int rol = resultSet.getInt("IdRol");
                us.setIdUsuario(idu);
                us.setUsuario(usv);
                us.setClave(clv);
                us.setIdRol(rol);
                
                
                
            }
                

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return us;
    }

    
}
