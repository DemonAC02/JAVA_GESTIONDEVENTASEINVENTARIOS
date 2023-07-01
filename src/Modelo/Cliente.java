/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

/**
 *
 * @author demon
 */
public class Cliente {
    private int IdCliente;
    private int DniCli;
    private String NombreCli;

    public Cliente() {
    }

    public Cliente(int IdCliente, int DniCli, String NombreCli) {
        this.IdCliente = IdCliente;
        this.DniCli = DniCli;
        this.NombreCli = NombreCli;
    }

    public Cliente(int DniCli, String NombreCli) {
        this.DniCli = DniCli;
        this.NombreCli = NombreCli;
    }

    public int getIdCliente() {
        return IdCliente;
    }

    public void setIdCliente(int IdCliente) {
        this.IdCliente = IdCliente;
    }

    public int getDniCli() {
        return DniCli;
    }

    public void setDniCli(int DniCli) {
        this.DniCli = DniCli;
    }

    public String getNombreCli() {
        return NombreCli;
    }

    public void setNombreCli(String NombreCli) {
        this.NombreCli = NombreCli;
    }
    
    
}
