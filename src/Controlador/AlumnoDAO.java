package Controlador;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import ConexionBD.ConexionBD;
import modelo.Alumno;
public class AlumnoDAO {
    ConexionBD conexion;

    public AlumnoDAO() {
        conexion= new ConexionBD();
    }

    //===================Altas=============================

    public boolean agregarAlumno(Alumno a) {
        boolean res=false;
        //INSERT INTO ALUMNOS VALUES('1','1','1','',1,1,'1');
        String sql="INSERT INTO alumnos VALUES('"+a.getNumControl()+"','"+a.getNombre()+"','"+a.getPrimerAp()+"','"+a.getSegundoAp()+"',"
                +a.getEdad()+","+a.getSemestre()+",'"+a.getCarrera()+"');";

        res=conexion.ejecutarInstruccionDML(sql);

        return res;
    }

    //==================Bajas============================

    public boolean eliminarAlumno(String nc) {

        // DELETE FROM alumnos WHERE NumControl = '01';

        boolean res= false;

        String sql = "DELETE FROM alumnos WHERE NumControl = \""+ nc +"\"";
        res = conexion.ejecutarInstruccionDML(sql);

        return res;
    }

    //=====================Cambios======================
    public boolean actualizarAlumnos(Alumno a) {
        // UPDATE alumnos SET nombre.. primer ap.. semestre = '10';

        boolean res = false;

        String sql = "UPDATE alumnos SET nombre='"+a.getNombre()+"', PrimerAp='"+a.getPrimerAp()+"', SegundoAp='"+a.getSegundoAp()+"',"
                + "              Edad = "+a.getEdad()+", semestre = "+a.getSemestre()+", Carrera = '"+a.getCarrera()+"'"
                + "                  WHERE NumControl = '"+a.getNumControl()+"';";
        res = conexion.ejecutarInstruccionDML(sql);

        return res;
    }

    //====================Consultas==================
    public ArrayList<Alumno> buscarAlumnos(String filtro){

        ArrayList<Alumno> listaAlumnos=new ArrayList<>();
        String sql="SELECT * FROM alumnos WHERE NumControl='"+filtro+"';";

        ResultSet rs=conexion.ejecutarConsultaSQL(sql);

        try {
            if(rs.next()) {
                do {
                    listaAlumnos.add( new Alumno(rs.getString(1)
                            ,rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getByte(5),
                            rs.getByte(6),
                            rs.getString(7)));
                }while(rs.next());

            }else {
                return null;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listaAlumnos;
    }
}
