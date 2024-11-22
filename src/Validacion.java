import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Validacion {

    public Validacion() {
    }

    // Devuelve true si es un entero positivo
    public boolean isInt(String dato){

        try {

            // verificamos si no contiene letras
            double newDato=Double.parseDouble(dato);

            if (dato.contains(".")){
                return false;
            }
            // verificamos que no sea negativo
            if (newDato < -1){
                return false;
            }

            // verificamos que sea entero
            if ((newDato>(int)newDato) && (newDato<(int)newDato+1)){
                return false;
            }

            return true;

        }catch (Exception e){
            return false;
        }

    }

    // Devuelve true si es un numero real positivo
    public boolean isDouble(String dato){

        try {

            // verificamos si no contiene letras
            double newDato=Double.parseDouble(dato);

            // verdadero o falso
            return newDato>-1;

        }catch (Exception e){
            return false;
        }
    }

    // Devuelve un false si contiene caracteres especiales
    public boolean withOutSpecialCharacter(String cadena){
        if (cadena.equals("-1")){
            return true;
        }
        int ascii;

        for (char carater: cadena.toCharArray()){
            ascii = carater;
            if ((( ascii > 0 ) && ( ascii < 48 )) || (( ascii > 57 ) && ( ascii < 65 ))|| (( ascii > 90) && ( ascii < 97 )) || ( ascii > 122 )){
                return false;
            }
        }
        return true;
    }

    // Devuelve un false si contiene caracteres especiales y numeros
    public boolean withOutSpecialCharacterAndNumbers(String cadena){

        int ascii;

        for (char carater: cadena.toCharArray()){
            ascii= carater;
            if ((( ascii > 0 ) && ( ascii < 65 )) || (( ascii > 90 ) && ( ascii < 97 )) || ( ascii > 122 )){
                return false;
            }
        }

        return true;
    }

    // Devuelve un false si contiene caracteres especiales y numeros, pero permite los espacios
    public boolean forFullName(String cadena){

        int ascii;

        for (char carater: cadena.toCharArray()){
            ascii= carater;

            if ( ((ascii>0) && (ascii<32)) || ((ascii>32) && (ascii<65)) || ((ascii>90) && (ascii<97)) || ((ascii>122))){
                return false;
            }
        }

        return true;
    }

    // Menu para seleccionar la validacion adecuada y retorna el valor esperado
    public String eleccionAValidar(int opcion, String cadena) throws IOException {

        BufferedReader cp=new BufferedReader(new InputStreamReader(System.in));
        boolean IsTrue;

        switch (opcion){
            case 1:
                // Verificamos que si o si sea un numero entero
                IsTrue = isInt(cadena);
                while (!IsTrue){
                        System.out.println(cadena+" No es un entero positivo, Digite nuevamente: ");
                        cadena = cp.readLine();
                        IsTrue=isInt(cadena);

                }
                return cadena;
            case 2:

                IsTrue = isDouble(cadena);
                while (!IsTrue){
                    System.out.println(cadena+" No es un numero real positivo, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=isDouble(cadena);
                }
                return cadena;
            case 3:
                IsTrue = withOutSpecialCharacter(cadena);
                while (!IsTrue){
                    System.out.println(cadena+" Contiene caracteres especiales, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=withOutSpecialCharacter(cadena);
                }
                return cadena;
            case 4:
                IsTrue = withOutSpecialCharacterAndNumbers(cadena);
                while (!IsTrue){
                    System.out.println(cadena+" Contiene caracteres especiales ó numeros, Digite nuevamente: ");
                    cadena= cp.readLine();
                    IsTrue=withOutSpecialCharacterAndNumbers(cadena);
                }

                return cadena;
            case 5:
                IsTrue = forFullName(cadena);

                while (!IsTrue){
                    System.out.println(cadena + " Contiene caracteres especiales ó numeros, Digite nuevamente: ");
                    cadena = cp.readLine();
                    IsTrue = forFullName(cadena);
                }

                return cadena;

            default:
                System.out.println("Mijo caso incorrecto utilice bien las cosas, digite el caso manual nuevamente: ");
                System.out.println("Ya sabe que tiene que corregir la opcion del metodo no hay una opcion "+opcion+" mire bien como utilizar el metodo :)");
                int opcionNueva= Integer.parseInt(eleccionAValidar(1,cp.readLine()));
                cadena = eleccionAValidar(opcionNueva,cadena);

        }
        return cadena;
    }

    // Metodo para verificar un dato y aparte que no se pase de un limite
    public String eleccionAValidarSinSobrepasar(int opcion, String cadena,double noSobrepasar) throws IOException {

        BufferedReader cp=new BufferedReader(new InputStreamReader(System.in));

        double IsTrue;
        IsTrue = Double.parseDouble(eleccionAValidar(opcion,cadena));

        while (IsTrue>noSobrepasar){
            if (opcion==2){
                System.out.println("El dato no debe sobre pasar el numero "+noSobrepasar);
            }else {
                int noSobrepasarEntero = (int) noSobrepasar;
                System.out.println("El dato no debe sobre pasar el numero "+noSobrepasarEntero);
            }

            System.out.println("ingrese el dato nuevamente: ");
            cadena=cp.readLine();
            IsTrue = Double.parseDouble(eleccionAValidar(opcion,cadena ));
        }

        if (opcion==1){
            return String.valueOf((int)IsTrue);
        }else {
            return String.valueOf(IsTrue);
        }

    }

}
