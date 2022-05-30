import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ///VARIABLES
        int option, testValue;
        Product product;
        boolean out = false;
        Sale sale = new Sale(new ArrayList<Product>());
        int[] testList = {1, 2, 3};


        System.out.println("BIENVENIDO A LA APLICACIÓN");

        while (!out) {
            System.out.println("""
                    Tiene disponible las siguientes opciones:\s
                     1. Agregar productos.
                     2. Calcular compra.
                     3. Generar error de prueba.
                     4. Salir de la aplicación.""");

            option = askInfoInt("Seleccione la opción que desea realizar:");

            switch (option) {
                case 1:
                    product = createProduct();
                    addProductToSale(product, sale);
                    break;
                case 2:
                    try {
                        System.out.println("El total de la compra son: " + sale.calculateTotalSale() + " euros.");
                    } catch (EmptySaleException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 3:
                    /// código que genera error ArrayIndexOutOfBoundsException
                    try {
                        testValue = testList[3];
                    } catch (ArrayIndexOutOfBoundsException e) {
                        System.out.println("Error: ArrayIndexOutOfBoundException. No se puede acceder a una posición del array que no existe");
                    }
                    break;
                case 4:
                    System.out.println("Hasta la próxima!!");
                    out = true;
                    break;
            }
        }
    }


//////////   FUNCIONALIDADES DEL PROGRAMA
    private static Product addProductToSale(Product product, Sale sale) {
        sale.addProduct(product);
        return product;
    }

    private static Product createProduct() {
        String name = askInfoString("indique el nombre del producto que desea agregar");
        int price = askInfoInt("Indique el precio del producto");
        Product product = new Product(name, price);
        return product;
    }


    //////////   ENTRADA DE DATOS
    private static int askInfoInt(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextInt();
    }

    private static String askInfoString(String message) {
        Scanner sc = new Scanner(System.in);
        System.out.println(message);
        return sc.nextLine();
    }

}