import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Punto4 {

    public BufferedReader cp = new BufferedReader(new InputStreamReader(System.in));

    public Validacion validacion = new Validacion();

    public Punto4() throws IOException {



        String lineas = "-----------------------------------------------------------";

        Stack<String> pilaCaracter = new Stack<>();

        boolean flagMenu = true;
        while (flagMenu){
            System.out.println("\n---------- PUNTO 4 ----------\n");
            System.out.println("Digite 1 para llenar la pila");
            System.out.println("Digite 2 para buscar un elemento dentro de la pila");
            System.out.println("Digite 3 para mostrar la pila");
            System.out.println("Digite 4 para salir");
            int opcion = Integer.parseInt(validacion.eleccionAValidarSinSobrepasar(1, cp.readLine(),4));
            System.out.println(lineas);
            switch (opcion){
                case 1:
                    pilaCaracter = llenarPila();
                    System.out.println(lineas);
                    break;
                case 2:
                    if (pilaCaracter.isEmpty()){
                        System.out.println("La pila esta vacia, llenela para poder realizar una operacion");
                        System.out.println(lineas);
                        break;
                    }
                    System.out.println("Ingrese el caracter a buscar: ");
                    String aBuscar = validacion.eleccionAValidar(3, cp.readLine());
                    int posicion = buscar(pilaCaracter,aBuscar);

                    while (true){
                        if (posicion == -1){
                            pilaCaracter = llenarPila();
                            System.out.println("Ingrese el caracter a buscar: ");
                            aBuscar = validacion.eleccionAValidar(3, cp.readLine());
                            posicion = buscar(pilaCaracter,aBuscar);
                        }else if (posicion == -2){
                            System.out.println("Ingrese el caracter a buscar: ");
                            aBuscar = validacion.eleccionAValidar(3, cp.readLine());
                            posicion = buscar(pilaCaracter,aBuscar);
                        }else {
                            break;
                        }
                    }

                    System.out.println("La Posicion del caracter "+aBuscar+" es: "+posicion);
                    System.out.println(lineas);
                    break;
                case 3:
                    if (pilaCaracter.isEmpty()){
                        System.out.println("La pila esta vacia, llenela para poder realizar una operacion");
                        System.out.println(lineas);
                        break;
                    }
                    mostrarPila(pilaCaracter);
                    System.out.println(lineas);
                    break;
                case 4:
                    flagMenu = false;
                    break;
                default:
                    System.out.println("El numero "+opcion+" no es una opcion del menú.");
                    System.out.println(lineas);
            }

        }

    }
    public Stack<String> llenarPila() throws IOException{

        Stack<String> pilaCaracter = new Stack<>();
        String cadena = "";

        while (!cadena.equals("-1")){

            System.out.println("ingrese los caracteres o numeros que tiene la pila, o -1 para dejar de ingresar");
            cadena = validacion.eleccionAValidar(3, cp.readLine());

            if (pilaCaracter.contains(cadena)){
                System.out.println("El elemento ya esta en la pila");
                System.out.println("-----------------");
                continue;
            }

            if (cadena.equals("-1") && pilaCaracter.isEmpty()){
                System.out.println("-----------------");
                System.out.println("Aun no has digitado ningun dato.");
                System.out.println("-----------------");
                cadena ="";

            }else if (!cadena.equals("-1")){
                pilaCaracter.push(cadena);
            }

        }
        System.out.println("-----------------");
        System.out.println("| PILA CREADA |");
        System.out.println("-----------------");
        System.out.println(pilaCaracter);

        return pilaCaracter;
    }

    public int buscar(Stack<String> pila,String abuscar) throws IOException{

        pila = (Stack<String>) pila.clone();
        Stack<String> operaciones = (Stack<String>) pila.clone();
        int dimension = pila.size();

        int paraRetornar = 0;

        boolean isHere = false;
        for (int i = 0; i < dimension; i++) {
            String caracter = operaciones.pop();
            if (caracter.equals(abuscar)){
                paraRetornar = dimension-i;
                isHere = true;
                break;
            }

        }

        if (!isHere){

            while (true){
                System.out.println("No se encontro el dato, ingrese 1 para buscar otro caracter o 0 para llenar nuevamente la pila: ");
                int opcion = Integer.parseInt(validacion.eleccionAValidarSinSobrepasar(1, cp.readLine(),4));
                if (opcion == 1){
                    paraRetornar = -2;
                    break;
                }else if(opcion == 0){
                    paraRetornar = -1;
                    break;
                }else {
                    System.out.println("Opncion invalida");
                }

            }

        }

        return paraRetornar;

    }

    public void mostrarPila(Stack<String> pila){
        System.out.println(pila);
    }

}
