package game.of.life2;

import java.util.Scanner;

public class View {
    Scanner scanner;
    Controller controller;

    //VAMOS A HACER CON BASICAS POR AHORA
    public View(){
        boolean[][] patronInicialAux = {
            {true, true, false, false, false},
            {false, false, true,  true,  false},
            {false, true,  true,  false, false},
            {false, false, false, false, false},
            {false, false, false, false, false}
        };
        controller = new Controller(patronInicialAux);
    }

    public boolean showView(){
        scanner = new Scanner(System.in);
        System.out.println("MENU DE OPCIONES");
        showMenu1(scanner);
        showMenu2(scanner);
        showMenu3(scanner);
        controller.darStep();

        System.out.print("¿Desea continuar? (s/n): ");
        String respuesta = scanner.nextLine();
        return respuesta.equalsIgnoreCase("s");
    }

    private void showMenu1(Scanner scanner){
        System.out.println("----------------------");
        System.out.println("..PASO1 - SELECCIONAR STEP..");
        System.out.println("Ingrese el step: ");
        
        String step = scanner.nextLine();
        System.out.println("Step seleccionado: " + step);
        controller.seleccionarStep(step);
    }

    private void showMenu2(Scanner scanner){
        System.out.println("..PASO2 - SELECCIONAR EL TIPO DE CELDAS..");
        System.out.println("Ingrese el tipo de celdas: ");

        String celda = scanner.nextLine();
        System.out.println("Celda seleccionada: " + celda);
        controller.seleccionarCelda(celda);
    }
    
    private void showMenu3(Scanner scanner){
        System.out.println("----------------------");
        System.out.println("..PASO3 - SELECCIONAR OBSERVER..");
        System.out.println("Ingrese el observer: ");

        String observer = scanner.nextLine();
        System.out.println("Observer seleccionado: " + observer);
        controller.seleccionarObserver(observer);
    }
}




