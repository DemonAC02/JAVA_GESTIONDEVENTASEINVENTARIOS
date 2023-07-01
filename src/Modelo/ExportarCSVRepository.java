/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.io.FileWriter;
import java.util.List;

/**
 *
 * @author demon
 */
public class ExportarCSVRepository implements IExportarCsv {

    private String URL = "jdbc:mysql://localhost:3306/db_tienda";
    private String usuario = "root";
    private String password = "";
    public ExportarCSVRepository(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    @Override
    public void exportarDatosCli(List<Cliente> datos, String formato) {
        try (FileWriter writer = new FileWriter(formato)) {
            //ENCABEZADO
            writer.append("ID;Nombre y Apellidos;DNI\n");

            //BUCLE PARA EXTRAER TODOS LOS DATOS DEL OBJETO
            for (Cliente clie : datos) {
                writer.append(String.valueOf(clie.getIdCliente())).append(";");
                writer.append(String.valueOf(clie.getNombreCli())).append(";");
                writer.append(String.valueOf(clie.getDniCli())).append("\n");
            }

            writer.flush();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }

    @Override
    public void exportarDatosPro(List<Producto> datos, String formato) {
try (FileWriter writer = new FileWriter(formato)) {
            writer.append("ID;Nombre;Precio;Stock;\n");

            for (Producto pro : datos) {
                writer.append(String.valueOf(pro.getIdProducto())).append(";");
                writer.append(String.valueOf(pro.getNombreProducto())).append(";");
                writer.append(String.valueOf(pro.getPrecio())).append(";");
                writer.append(String.valueOf(pro.getStock())).append("\n");
            }

            writer.flush();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }    }

    @Override
    public void exportarDatosUsu(List<Usuario> datos, String formato) {
try (FileWriter writer = new FileWriter(formato)) {
            writer.append("ID;Usuario;Clave;ID Rol;\n");

            for (Usuario usu : datos) {
                writer.append(String.valueOf(usu.getIdUsuario())).append(";");
                writer.append(String.valueOf(usu.getUsuario())).append(";");
                writer.append(String.valueOf(usu.getClave())).append(";");
                writer.append(String.valueOf(usu.getIdRol())).append("\n");
            }

            writer.flush();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }    } 

    @Override
    public void exportarDatosVen(List<Venta> datos, String formato) {
        try (FileWriter writer = new FileWriter(formato)) {
            writer.append("ID;Nombre y Apellidos;DNI;Total;Fecha;ID MetodoPago\n");

            for (Venta ven : datos) {
                writer.append(String.valueOf(ven.getIdVenta())).append(";");
                writer.append(String.valueOf(ven.getNombreCompr())).append(";");
                writer.append(String.valueOf(ven.getDniCompr())).append(";");
                writer.append(String.valueOf(ven.getMonto())).append(";");
                 writer.append(String.valueOf(ven.getFechaVenta())).append(";");
                writer.append(String.valueOf(ven.getIdMetodoPago())).append("\n");
            }

            writer.flush();
        } catch (Exception e) 
        {
            e.printStackTrace();
        }
    }
    
    
}
