import java.util.Scanner;
import java.util.Stack;

import javax.swing.JOptionPane;

public class metodos 
{
    Scanner sc = new Scanner(System.in);
    public Stack<Tienda> RegistrarPrenda(Stack<Tienda> pila) 
    {
        Tienda o = new Tienda();
        o.setMarca(JOptionPane.showInputDialog("Ingrese la marca"));
        String entrada;
        // Validar referencia
        entrada = JOptionPane.showInputDialog("Ingrese la referencia");
        while (!entrada.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.");
            entrada = JOptionPane.showInputDialog("Ingrese la referencia (número entero):");
        }
        o.setReferencia(Integer.parseInt(entrada));

        // Validar cantidad
        entrada = JOptionPane.showInputDialog("Ingrese la cantidad");
        while (!entrada.matches("\\d+")) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número entero válido.");
            entrada = JOptionPane.showInputDialog("Ingrese la cantidad (número entero):");
        }
        o.setCantidad(Integer.parseInt(entrada));
        
        // Validar precio
        entrada = JOptionPane.showInputDialog("Ingrese el precio");
        while (!entrada.matches("\\d+(\\.\\d+)?")) {
            JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            entrada = JOptionPane.showInputDialog("Ingrese el precio (número válido):");
        }
        o.setPrecio(Double.parseDouble(entrada));
        return ValidarPrenda(pila, o);
    }
    public Stack<Tienda> ValidarPrenda(Stack<Tienda> pila, Tienda nuevaPrenda) 
    {
        boolean encontrado = false;
        for (Tienda prenda : pila) 
        {
            if (prenda.getMarca().equalsIgnoreCase(nuevaPrenda.getMarca()) && prenda.getReferencia() == nuevaPrenda.getReferencia()) 
            {
                prenda.setCantidad(prenda.getCantidad() + nuevaPrenda.getCantidad());
                encontrado = true;
                JOptionPane.showMessageDialog(null, "La prenda ya existe, se ha actualizado la cantidad");
                break;
            }
        }
        if (!encontrado) 
        {
            pila.push(nuevaPrenda);
            JOptionPane.showMessageDialog(null, "Prenda ingresada correctamente");
        }
        MostrarPila(pila);
        return pila;
    }
    public void MostrarPila(Stack<Tienda> pila) 
    {
        for (Tienda o : pila) 
        {
            System.out.println("Marca: " + o.getMarca());
            System.out.println("Referencia: " + o.getReferencia());
            System.out.println("Cantidad: " + o.getCantidad());
            System.out.println("Precio " + o.getPrecio());
            System.out.println();
        }
    }
    public void BuscarPrenda(Stack<Tienda> pila)
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay prendas ingresadas");
            //pila = IngresarRepuesto(pila); //para llevarlo a ingresar repuesto
            return;
        }
        System.out.println("--CONSULTAR-- \n" + "1.Por Marca\n" + "2.Por Referencia\n");
        int opt = sc.nextInt();
        while (opt != 1 && opt != 2) 
        {
            System.out.println("Opción no válida. Por favor ingrese 1 o 2.");
            opt = sc.nextInt();
        }
        boolean encontrado = false;
        String marca = "";
        int ref = 0;
        if (opt == 1) 
        {
            System.out.println("Ingrese la marca a consultar");
            marca = sc.next();
        } else 
        {
            System.out.println("Ingrese la referencia a consultar");
            ref = sc.nextInt();
        }
        for (Tienda prenda : pila) 
        { 
            if(opt == 1)
            {
                if (prenda.getMarca().equalsIgnoreCase(marca)) 
                {
                    encontrado = true;
                    System.out.println("PRENDA ENCONTRADA\n" +
                                    "Marca: " + prenda.getMarca() + "\n" +
                                    "Referencia: " + prenda.getReferencia() + "\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n" +
                                    "Precio: " + prenda.getPrecio() + "\n");
                } 
                
            }
            else
            {
                if (prenda.getReferencia() == ref) 
                {
                    encontrado = true;
                    System.out.println("PRENDA ENCONTRADA\n" +
                                    "Marca: " + prenda.getMarca() + "\n" +
                                    "Referencia: " + prenda.getReferencia() + "\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n" +
                                    "Precio: " + prenda.getPrecio() + "\n");
                } 
            }
        }
        if (!encontrado) 
        {
            System.out.println("Prenda no encontrado");
            return;
        }
    }
    public void ModificarPrenda(Stack<Tienda> pila) 
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay prendas ingresadas");
            return;
        }
        System.out.println("Ingrese la referencia de la prenda a modificar");
        int ref = sc.nextInt();
        boolean encontrado = false;
        for (Tienda prenda : pila) 
        {
            if (prenda.getReferencia() == ref) 
            {
                encontrado = true;
                System.out.println("---MODIFICAR--- \n" + "1.Marca\n" + "2.Referencia\n" + "3.Cantidad\n" + "4.Precio\n");
                int opt = sc.nextInt();
                switch (opt) 
                {
                    case 1:
                        System.out.println("Ingrese la nueva marca");
                        prenda.setMarca(sc.next());
                        break;
                    case 2:
                        System.out.println("Ingrese la nueva referencia");
                        prenda.setReferencia(sc.nextInt());
                        break;
                    case 3:
                        System.out.println("Ingrese la nueva cantidad");
                        prenda.setCantidad(sc.nextInt());
                        break;
                    case 4:
                        System.out.println("Ingrese el nuevo precio");
                        prenda.setPrecio(sc.nextDouble());
                        break;
                    default:
                        System.out.println("Opcion no valida");
                        break;
                }
                System.out.println("PRENDA MODIFICADO\n" +
                                    "Marca: " + prenda.getMarca() + "\n" +
                                    "Referencia: " + prenda.getReferencia() + "\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n" +
                                    "Precio: " + prenda.getPrecio() + "\n");
                return;
            }
        }
        if (!encontrado) 
        {
            System.out.println("Prenda no encontrado");
            return;
        }
    }
    public void VenderPrenda(Stack<Tienda> pila) 
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay prendas ingresadas");
            return;
        }
        System.out.println("--CONSULTAR-- \n" + "1.Por Marca\n" + "2.Por Referencia\n");
        int opt = sc.nextInt();
        while (opt != 1 && opt != 2) 
        {
            System.out.println("Opción no válida. Por favor ingrese 1 o 2.");
            opt = sc.nextInt();
        }
        String marca = "";
        int ref = 0;
        boolean encontrado = false;
        if (opt == 1) 
        {
            System.out.println("Ingrese la marca a a vender");
            marca = sc.next();
        } else 
        {
            System.out.println("Ingrese la referencia a vender");
            ref = sc.nextInt();
        }
        for (Tienda prenda : pila) 
        { 
            if(opt == 1)
            {
                if (prenda.getMarca().equalsIgnoreCase(marca)) 
                {
                    encontrado = true;
                    System.out.println("Ingrese la cantidad a vender");
                    int cant = sc.nextInt();
                    if (cant < prenda.getCantidad()) 
                    {
                        System.out.println("No hay suficiente cantidad para vender");
                        return;
                    }
                    prenda.setCantidad(prenda.getCantidad() - cant);
                    System.out.println("PRENDA ENCONTRADA\n" +
                                    "Marca: " + prenda.getMarca() + "\n" +
                                    "Referencia: " + prenda.getReferencia() + "\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n" +
                                    "Precio: " + prenda.getPrecio() + "\n");  
                } 
            }
            else
            {
                if (prenda.getReferencia() == ref) 
                {
                    encontrado = true;
                    System.out.println("Ingrese la cantidad a vender");
                    int cant = sc.nextInt();
                    if (cant < prenda.getCantidad()) 
                    {
                        System.out.println("No hay suficiente cantidad para vender");
                        return;
                    }
                    prenda.setCantidad(prenda.getCantidad() - cant);
                    System.out.println("PRENDA ENCONTRADA\n" +
                                    "Marca: " + prenda.getMarca() + "\n" +
                                    "Referencia: " + prenda.getReferencia() + "\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n" +
                                    "Precio: " + prenda.getPrecio() + "\n");  
                } 
            }
        }
        if (!encontrado) 
        {
            System.out.println("Prenda no encontrado");
            return;
        }
    }
    public void ConsultarStock(Stack<Tienda> pila) 
    {
        while (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay prendas ingresadas");
            return;
        }
        System.out.println("--CONSULTAR STOCK-- \n" + "1.Por Marca\n" + "2.Por Referencia\n");
        int opt = sc.nextInt();
        while (opt != 1 && opt != 2) 
        {
            System.out.println("Opción no válida. Por favor ingrese 1 o 2.");
            opt = sc.nextInt();
        }
        String marca = "";
        int ref = 0;
        boolean encontrado = false;
        if (opt == 1) 
        {
            System.out.println("Ingrese la marca a consultar");
            marca = sc.next();
        } else 
        {
            System.out.println("Ingrese la referencia a consultar");
            ref = sc.nextInt();
        }
        for (Tienda prenda : pila) 
        { 
            if(opt == 1)
            {
                if (prenda.getMarca().equalsIgnoreCase(marca)) 
                {
                    encontrado = true;
                    System.out.println("STOCK ENCONTRADO\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n");
                } 
            }
            else
            {
                if (prenda.getReferencia() == ref) 
                {
                    encontrado = true;
                    System.out.println("STOCK ENCONTRADO\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n");
                } 
            }
        }
        if (!encontrado) 
        {
            System.out.println("Prenda no encontrado");
            return;
        }
    }
    public void OrdenarPorCantidad(Stack<Tienda> pila) 
    {
        if (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay prendas ingresadas");
            return;
        }

        Stack<Tienda> pilaAux = new Stack<>();

        while (!pila.isEmpty()) 
        {
            Tienda temp = pila.pop();//Extrae el elemento ultimo elemento de la pila
            while (!pilaAux.isEmpty() && pilaAux.peek().getCantidad() < temp.getCantidad()) //peek muestra el elemento que esta en la cima de la pila
            {
                pila.push(pilaAux.pop()); //Extrae el elemento de la pila auxiliar y lo pasa a la pila original
            }
            pilaAux.push(temp);
        }

        while (!pilaAux.isEmpty()) //pasa los elementos de la pila auxiliar a la pila original
        {
            pila.push(pilaAux.pop());
        }
        JOptionPane.showMessageDialog(null, "Prendas ordenadas por cantidad de mayor a menor");
        MostrarPila(pila);
    }
    public void SumarYMostrarCantidades(Stack<Tienda> pila) 
    {
        if (pila.isEmpty()) 
        {
            JOptionPane.showMessageDialog(null, "No hay prendas ingresadas");
            return;
        }
        int sumaTotal = 0;
        for (Tienda prenda : pila) 
        {
            sumaTotal += prenda.getCantidad();
        }

        System.out.println("La suma total de las cantidades de las prendas es: " + sumaTotal);
    }
}
