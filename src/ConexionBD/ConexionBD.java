package ConexionBD;
import java.sql.*;
public class ConexionBD {
    private Connection conexion;
    private Statement stm;
    private ResultSet rs;

    public ConexionBD() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            String URL="jdbc:mysql://localhost:3306/BD_Escuela_Topicos";

            conexion=DriverManager.getConnection(URL,"root","jael0531");

            System.out.println("Casi soy ingeniero en sistemas");
            System.out.println("Conexion establecida");

        } catch (ClassNotFoundException e) {
            System.out.println("Error en el controlador de conexion de Mysql");
        }catch (SQLException e) {
            System.out.println("Error en la ruta (URL) de conexion");
        }
    }

    public boolean ejecutarInstruccionDML(String instruccionDML){
        boolean res = false;

        try {
            stm = conexion.createStatement();
            if(stm.executeUpdate(instruccionDML)==1)
                res= true;
        } catch (SQLException e) {
            System.out.println("Error en la instruccion sql");
        }

        return res;
    }

    public ResultSet ejecutarConsultaSQL(String consultaSQL){
        rs = null;

        try {
            stm = conexion.createStatement();
            rs = stm.executeQuery(consultaSQL);

        } catch (SQLException e) {
            System.out.println("Error en la instruccion sql");
        }

        return rs;

    }

    public void cerrarConexion() {
        try {
            stm.close();
            conexion.close();
        } catch (SQLException e) {
            System.out.println("Error de cierre en la conexion");
            e.printStackTrace();
        }
    }
}
