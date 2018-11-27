/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeria.DAL;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import pizzeria.BL.Conexion;

/**
 *
 * @author Zero
 */
public class loginDAL {
    
   Conexion objConexion = new Conexion(); 
   
   
    public int LogIn(String usuario, String pass){ 
    int aprobado = 0;
    ResultSet ComandoEjecutado=objConexion.EjecutarSentenciaSQL("SELECT COUNT(*) FROM Empleados WHERE Usuario ="+usuario+"AND Contraseña ="+pass); 
    objConexion.Desconectar(); 
    try{ 
        while (ComandoEjecutado.next()) {
    int existe = Integer.parseInt(ComandoEjecutado.getString("count(*)"));
    
    if (existe > 0)
    {
    aprobado = 1;
    }
   // System.out.println(firstName);
    }
    }
    catch(SQLException e){
 //return null; 
} 
    return aprobado;
}
}




