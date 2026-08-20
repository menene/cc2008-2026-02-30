import java.util.Scanner;
public class View{
    private Controller controller ;
    private Scanner scanner;
    public View(Controller controller){
        this.controller =controller;
        scanner = new Scanner(System.in);
    }
    public void showMenu(){
        int option;
        do{
            System.out.println("========== MENU ==========");
            System.out.println("1.) Agregar Atleta");
            System.out.println("2.) Gestionar Atleta");
            System.out.println("3.) Mostrar todos los Atletas");
            System.out.println("4.) Mostrar Ganador");
            System.out.println("5.) Mostrar Resultados generales");
            System.out.println("0.) Salir");
            System.out.print("Seleccione una opción: ");
            option = scanner.nextInt();
            switch(option){
                case 1:
                    registerAthlete();
                    break;
                case 2:
                    athleteMenu();
                    break;
                case 3:
                    showAllAthletes();
                    break;
                case 4:
                    showWinner();
                    break;
                case 5:
                    showResults();
                    break;
                case 0:
                    System.out.println("Saliendo... ");
                    break;
                default:
                    System.out.println("Opción invalida");
            }
        }while(option != 0);
    }
    public void registerAthlete(){
        if(controller.hasSpace()){
            scanner.nextLine();
            System.out.print("Nombre: ");
            String name = scanner.nextLine();
            System.out.print("Edad: ");
            int age = scanner.nextInt();
            Athlete athlete = new Athlete(name,controller.getAthleteNumber(),age);
            controller.addAthlete(athlete);
            System.out.println("Atleta registrado correctamente");
        }
        else{
            System.out.println("No hay espacio para más atletas");
        }    
    }
    public void showAllAthletes(){
        if(controller.getAthleteNumber()-1>0){
            System.out.println("========== ATLETAS REGISTRADOS ==========");
            Athlete[] athletes = controller.getAthletes();
            for(Athlete i : athletes){
                if(i!= null){
                    System.out.println("Número: "+i.getNumber()+" | Nombre: "+ i.getName()+" | Edad: "+ i.getAge());
                }
            }
        }
        else{
            System.out.println("Aún no ha registrado algún atleta");
        }
    }
    public void showWinner(){
        if(controller.getAthleteNumber()-1>1){
            System.out.println("========== ATLETA GANADOR ==========");
            Athlete winner = controller.getWinner();
            System.out.println("Número: "+winner.getNumber()+" | Nombre: "+ winner.getName()+" | Edad: "+ winner.getAge());
            System.out.println("------------ Intentos ----------");
            if(winner.getAvailableAttempts() == 10){
                System.out.println("Aún no tiene intentos registrados");
            }
            else{
                int c = 1;

                for(int i : winner.getAttempts()){
                    if(i > 0){
                        System.out.println(c + ".) Tiempo: " + i);
                        c++;
                    }
                }
            }
        }
        else{
            System.out.println("Tiene que tener almenos dos atletas");
        }
    }
    public void showResults(){
        if(controller.getAthleteNumber()-1>0){
            System.out.println("========== RESULTADOS GENERALES ==========");
            System.out.println(controller.getResults());
        }
        else{
            System.out.println("Aún no ha registrado algún atleta");
        }
    }
    public void athleteMenu(){
        if(controller.getAthleteNumber()-1>0){
            int indexa;
            do{
                this.showAllAthletes();
                System.out.print("Seleccione un atleta: ");
                indexa = scanner.nextInt();
                if(indexa<=0||indexa>=controller.getAthleteNumber()){
                    System.out.println("El atleta seleccionado no existe");
                }
            }while(indexa<=0||indexa>=controller.getAthleteNumber());
            Athlete athlete = controller.getAthlete(indexa);
            if(athlete!=null){
                int option;
                do{
                    System.out.println("========== MENU ATLETA ==========");
                    System.out.println("1.) Registrar intento");
                    System.out.println("2.) Modificar intento");
                    System.out.println("3.) Mostrar información del atleta");
                    System.out.println("0.) volver");
                    System.out.print("Seleccione una opción: ");
                    option = scanner.nextInt();
                    switch(option){
                        case 1:{
                            if(athlete.getAvailableAttempts()>0){
                                System.out.print("Ingrese el tiempo obtenido: ");
                                int t = scanner.nextInt();
                                if(t>0){
                                    athlete.addAttempt(t);
                                    System.out.println("Intento añadido correctamente");
                                }
                                else{
                                    System.out.println("Error el tiempo tiene que ser mayor que 0");
                                }
                            }
                            else{
                                System.out.println("El atleta ya realizó sus 10 intentos");
                            }
                            break;
                        }
                        case 2:{
                            if (athlete.getAvailableAttempts() == 10) {
                                System.out.println("El atleta aún no tiene intentos registrados");
                                break;
                            }

                            System.out.println("========== INTENTOS ==========");
                            int c=1;
                            for(int i : athlete.getAttempts()){
                                if(i>0){
                                    System.out.println(c+".) Tiempo: "+i);
                                    c++;
                                }
                            }
                            int attempt;
                            do{
                                System.out.print("Ingrese el número del intento a modificar: ");
                                attempt=scanner.nextInt();
                                if(attempt<1 || attempt>=c){
                                    System.out.println("Intento invalido");
                                }
                            }while(attempt<1 || attempt>=c);
                            System.out.print("Ingrese el nuevo tiempo: ");
                            int t = scanner.nextInt();
                            if(t>0){
                                athlete.changeAttemptTime(attempt-1,t);
                                System.out.println("Intento modificado correctamente");
                            }
                            else{
                                System.out.println("Error el tiempo tiene que ser mayor que 0");
                            }
                            break;
                        }
                        case 3:{
                            System.out.println("========== INFORMACIÓN ==========");
                            System.out.println("Número: "+athlete.getNumber()+" | Nombre: "+ athlete.getName()+" | Edad: "+ athlete.getAge());
                            System.out.println("------------ Intentos ----------");
                            int c=1;
                            for(int i : athlete.getAttempts()){
                                if(i>0){
                                    System.out.println(c+".) Tiempo: "+i);
                                    c++;
                                }
                            }
                            break;
                        }
                        case 0:{
                            System.out.println("Regresando...");
                            break;
                        }
                        default:{
                            System.out.println("Opción incorrecta");
                        }
                    }
                }while(option!=0);
            }
            
        }
        else{
            System.out.println("Aún no tiene atletas registrados");
        }
    }
}