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
public interface IUsuario {
    Boolean validarUsuario(Usuario objUsu);
    void agregarUsuario(Usuario usu);
    boolean eliminarUsuario(int id);  
    boolean editarUsuario(Usuario usus);
    List<Usuario> listarUsuarios();
    Usuario buscarUsuario(int id);
}
