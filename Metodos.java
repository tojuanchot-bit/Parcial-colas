import java.util.Queue;
import java.util.Scanner;

public class Metodos {
    private int contadorId = 1;

    public Queue<Objvisitante> registrarVisitante(Queue<Objvisitante> visitas, Scanner sc, Validaciones v) {
        Objvisitante o = new Objvisitante();

        System.out.println("Registrando visitante #" + contadorId + " del día de hoy");
        o.setIdVisitante(contadorId);
        System.out.println("Ingrese Nombre del Visitante: ");
        o.setVisitante(sc.nextLine());
        System.out.println("Ingrese identificación: ");
        o.setIdentificación(v.validarEntero(sc));
        System.out.println("Ingrese el funcionario al que va a visitar: ");
        o.setFuncionario(seleccionarFuncionario(v, sc));
        o.setEstado(1);
        contadorId++;
        visitas.offer(o);
        return visitas;
    }


    public String seleccionarFuncionario(Validaciones v, Scanner sc) {
        System.out.println("1. Andres.");
        System.out.println("2. Carlos.");
        System.out.println("3. Laura");
        System.out.println("4. Isabel.");

        int n = v.validarEntero(sc);

        String nombre = "";
        boolean valido = false;

        while (!valido) {

            switch (n) {
                case 1:
                    valido = true;
                    nombre = "Andres";
                    break;

                case 2:
                    valido = true;
                    nombre = "Carlos";
                    break;
                case 3:
                    valido = true;
                    nombre = "Laura";
                    break;
                case 4:
                    valido = true;
                    nombre = "Isabel";
                    break;

                default:
                    System.out.println("Ingrese una opción válida (1 - 4)");
            }
        }
        return nombre;

    }

    public void mostrarVisitante (Objvisitante o, Scanner sc, Validaciones v){
        int n = o.getEstado();
        System.out.print("Estado: "   );
        mostrarEstado(v, sc, n);
        System.out.println("Nombre: " + o.getVisitante());
        System.out.println("Identificación: " + o.getIdentificación());
        System.out.println("Funcionario: " + o.getFuncionario());
        System.out.println("--------------------------------------");
    }

    public void mostrarEstado(Validaciones v, Scanner sc, int n) {

        switch (n) {
            case 1:
                System.out.println("En espera.");
                break;

            case 2:
                System.out.println("Llamado.");

                break;

            case 3:
                System.out.println("No responde.");

                break;

            case 4: 
                System.out.println("Atendido.");
                break;
            
            case 5:
                System.out.println("Cancelar.");

        }
    }

    public Queue<Objvisitante> llamar (Queue<Objvisitante> visitas, Validaciones v, Scanner sc){
        
        boolean encontrado = false;

        while (!encontrado) {

        System.out.println("Para regresar al menu principal marque 0");
        System.out.println("Ingrese id del visitante a llamar: ");
        int id = v.validarEntero(sc);

        
        
            for (Objvisitante o : visitas) {

                if (o.getIdVisitante() == id) {
                    o.setEstado(2);
                    mostrarVisitante(o, sc, v);
                    int n = decidirQueHacerCuandoLLamar(v, sc);
                    o.setEstado(n);
                    encontrado = true;
                    break;
                } else if (id != 0) {
                    System.out.println("Id no encontrado");
                }
            }

            if (id == 0) {
                System.out.println("Retornando al menu principal.");
                return visitas;
            }
        }

        return visitas;

    }

    public int decidirQueHacerCuandoLLamar(Validaciones v, Scanner sc){
        System.out.println("1. No responde.");
        System.out.println("2. Pasar al funcionario.");
        System.out.println("3. Cancelar turno.");
        int n = v.validarEntero(sc);
        int nuevoEstado = 2;

        switch (n) {
            case 1:
                nuevoEstado = 3; 
                break;
            
            case 2:
                nuevoEstado = 4;
            
            case 3: 
                nuevoEstado = 5;
        
            default:
                System.out.println("Ingrese una opcion valida (1 - 3");
                break; 
        }
        return nuevoEstado;
    }

    public void mostrarEstadoVisitas (Queue<Objvisitante> visitas, Scanner sc, Validaciones v){

        System.out.println("Estado Vistas");

        for (Objvisitante o : visitas) {

            mostrarVisitante(o,sc, v);
            
        }

    }

    public Queue<Objvisitante> modificarFuncionario(Queue<Objvisitante> visitas, Validaciones v, Scanner sc){
        
        boolean encontrado = false;

        while (!encontrado) {

        System.out.println("Para regresar al menu principal marque 0");
        System.out.println("Ingrese id del visitante a modificar: ");
        int id = v.validarEntero(sc);

    
            for (Objvisitante o : visitas) {

                if (o.getIdVisitante() == id) {
                    System.out.println("Ingrese que funcionario va a visitar: ");
                    o.setFuncionario(seleccionarFuncionario(v, sc));
                    mostrarVisitante(o, sc, v);
                    int n = decidirQueHacerCuandoLLamar(v, sc);
                    o.setEstado(n);
                    encontrado = true;
                    break;
                } else if (id != 0) {
                    System.out.println("Id no encontrado");
                }
            }

            if (id == 0) {
                System.out.println("Retornando al menu principal.");
                return visitas;
            }
        }
        return visitas;
    }

        public Queue<Objvisitante> CancelarVisita(Queue<Objvisitante> visitas, Validaciones v, Scanner sc){
        
        boolean encontrado = false;

        while (!encontrado) {

        System.out.println("Para regresar al menu principal marque 0");
        System.out.println("Ingrese id del visitante a cancelar: ");
        int id = v.validarEntero(sc);

    
        for (Objvisitante o : visitas) {

            if (o.getIdVisitante() == id) {
                o.setEstado(5);
                mostrarVisitante(o, sc, v);
                int n = decidirQueHacerCuandoLLamar(v, sc);
                o.setEstado(n);
                encontrado = true;
                break;
            } else if (id != 0) {
                System.out.println("Id no encontrado");
            }
        }

        if (id == 0) {
            System.out.println("Retornando al menu principal.");
            return visitas;
        }
    }
    return visitas;
}
}    
