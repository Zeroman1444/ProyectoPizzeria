/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pizzeria.BL;

//importamos los paquetes necesarios
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author Guzman
 */
public class Conexion {
    String CadenaConexion = "jdbc:sqlite:C:\\Users\\joser\\OneDrive\\UTM\\Ingenieria\\7mo Cuatrimestre\\Programación de Aplicaciones\\3er Parcial\\EjerciciosyPracticas\\Pizzeria\\src\\pizzeria\\BL\\Pizzeria.db";
    Connection conn= null;
    public Conexion(){ }
    public Connection Conectar(){ try {Class.forName("org.sqlite.JDBC"); 
this.conn= DriverManager.getConnection(CadenaConexion); 
} 
catch (Exception e) { System.out.println("Problemas al conectarse"+e); } return this.conn; 
}
    
    public void Desconectar()
{ 
this.conn=null; 
}
    
    public int EjecutarComandoSQL(String Sentencia)
{ 
try 
{ 
PreparedStatement pstm=Conectar().prepareStatement(Sentencia); pstm.execute(); return 1; 
}
catch (SQLException e) { System.out.println(e); return 0; 
}
}
    
    public ResultSet EjecutarSentenciaSQL(String Sentencia)
{
try 
{ 
PreparedStatement pstm=Conectar().prepareStatement(Sentencia); pstm.execute(); ResultSet Resultado=pstm.executeQuery(); return Resultado; 
}
catch (SQLException e) 
{
 System.out.println(e);
return null; 
} 
}
}
