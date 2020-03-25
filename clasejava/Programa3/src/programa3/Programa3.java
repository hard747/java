package programa3;

public class Programa3 {
// variacion orientada a objetos

    public static void main(String[] args) {

        // le creo intancia a prod1
        Producto prod1, prod2;
        
        //imprime el constructor
        prod1 = new Producto();
        System.out.println("Datos iniciales del producto");
        System.out.println("Nombr del producto " + prod1.nombreProducto);
        System.out.println("Precio Actual " + prod1.precioActual);
        System.out.println("Precio Nuevo " + prod1.precioNuevo);
        System.out.println("igv "+Producto.igv);

        System.out.println("Datos actualizados del producto");
        prod1.nombreProducto = "Computador";
        prod1.precioActual = 2000;
        prod1.precioNuevo = 2400;
        System.out.println("Nombr del producto " + prod1.nombreProducto);
        System.out.println("Precio Actual " + prod1.precioActual);
        System.out.println("Precio Nuevo " + prod1.precioNuevo);
         System.out.println("igv "+Producto.igv);// se puede correr con el nombre de la clase

        //no se puede declarar dos veces double
        double pv = prod1.porcentajeVariacion();
        System.out.println("% variacion: " + pv);

        prod2 = new Producto();
        prod2.nombreProducto = "Impresora";
        prod2.precioActual = 1000;
        prod2.precioNuevo = 1400;
        System.out.println("Nombre del producto " + prod2.nombreProducto);
        System.out.println("Precio Actual " + prod2.precioActual);
        System.out.println("Precio Nuevo " + prod2.precioNuevo);
         System.out.println("igv "+Producto.igv);

        pv = prod2.porcentajeVariacion();
        System.out.println("% variacion: " + pv);
        
        //prueba de metodo de clase puede llamarce de la clase
        Producto.actualizaIGV(0.2);
        System.out.println(" \nigv de producto1:  "+ prod2.igv);
        
        //prueba this
        System.out.println("precio nuevo de prd2: "+ prod2.precioNuevo);
        prod2.actualizarPrecioNuevo(500,'+' );
        System.out.println("precio nuevo de prd2: "+ prod2.precioNuevo);
        
        //sbrecarga de constructoes
        Producto prod3;
        prod3= new Producto("Precio", 100,120);
         System.out.println("Datos iniciales del producto");
        System.out.println("Nombr del producto " + prod1.nombreProducto);
        System.out.println("Precio Actual " + prod1.precioActual);
        System.out.println("Precio Nuevo " + prod1.precioNuevo);
        System.out.println("igv "+Producto.igv);
        

    }//main()

}//class
