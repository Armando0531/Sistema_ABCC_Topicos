package vista;

import java.util.ArrayList;
import javax.swing.SwingUtilities;
import Controlador.AlumnoDAO;
import modelo.Alumno;

public class VentanaInicio {
    public static void main(String[] args) {

        AlumnoDAO ado=new AlumnoDAO();

        ArrayList<Alumno> listaAlumnos=ado.buscarAlumnos("01");
        if(listaAlumnos!=null) {
            for (Alumno alumno : listaAlumnos) {
                System.out.println("-->"+alumno);
            }
        }else {
            System.out.println("Null");
        }

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new EjegirVentana();
            }
        });

    }
}
