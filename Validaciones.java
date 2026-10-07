import java.util.Scanner;

public class Validaciones {

    public int validarEntero (Scanner sc){
           while (!sc.hasNextInt()) {
            System.out.print("Por favor Ingrese un digito numerico: ");
            sc.next();
        }
        return sc.nextInt();
    }     
    
        public double validarDouble (Scanner sc){
           while (!sc.hasNextDouble()) {
            System.out.print("Por favor Ingrese un digito numerico decimal: ");
            sc.next();
        }
        return sc.nextDouble();
        }     

}