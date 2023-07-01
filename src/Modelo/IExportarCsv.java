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
public interface IExportarCsv {
    void exportarDatosCli(List<Cliente> datos, String formato);
    void exportarDatosPro(List<Producto> datos, String formato);
    void exportarDatosUsu(List<Usuario> datos, String formato);
    void exportarDatosVen(List<Venta> datos, String formato);
}
