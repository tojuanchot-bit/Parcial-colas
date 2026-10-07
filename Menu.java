import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Menu {
    /*1)	Recepción empresarial
Los visitantes llegan a una empresa y esperan para ser recibidos por diferentes funcionarios.
Un visitante puede:
•	Llegar. 
•	Esperar. 
•	Ser llamado. 
•	No responder. 
•	Cancelar la visita. 
•	Cambiar el funcionario que desea visitar. 
•	Ser atendido. 
Determine como es el proceso según su criterio.*/

    public static void main(String[] args) {
        boolean continuar = true;
        int opt;
        Validaciones v = new Validaciones();
        Scanner sc = new Scanner(System.in);
        Queue<Objvisitante> visitas = new LinkedList<>();
        Metodos m = new Metodos();
        
        System.out.println("---------- PARCIAL COLAS ----------");
        System.out.println("Ejercicio 1, Recepción empresarial");

        while (continuar) {

            System.out.println("Menu recepción: ");
            System.out.println("1. Registar visitante. ");
            System.out.println("2. Llamar visitante.");
            System.out.println("3. Mostrar estado de las visitas.");
            System.out.println("4. Cambiar visita. ");
            System.out.println("5. Seleccionar funcionario. ");

            System.out.print("Ingrese una opción: ");
            opt = v.validarEntero(sc);
            sc.nextLine();

            switch (opt) {
                case 1:
                    visitas = m.registrarVisitante(visitas, sc, v);
                    break;
                case 2:
                    visitas = m.llamar(visitas, v, sc);
                    break;

                case 3:
                    m.mostrarEstadoVisitas(visitas, sc, v);
                    break;

                case 4:
                    visitas = m.modificarFuncionario(visitas, v, sc);
                    break;

                case 5:
                    visitas = m.CancelarVisita(visitas, v, sc);
                    break;
                default:
                    System.out.println("Ingrese una opción valida: (0 - 1)");
                    break;
            }
        }

    }

}
