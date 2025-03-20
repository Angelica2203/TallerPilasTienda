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
        pila.push(o);
        JOptionPane.showMessageDialog(null, "Repuesto ingresado correctamente");
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
                    System.out.println("PRENDA ENCONTRADA\n" +
                                    "Marca: " + prenda.getMarca() + "\n" +
                                    "Referencia: " + prenda.getReferencia() + "\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n" +
                                    "Precio: " + prenda.getPrecio() + "\n");
                } 
                else
                {
                    System.out.println("Prenda no encontrada");
                }
            }
            else
            {
                if (prenda.getReferencia() == ref) 
                {
                    System.out.println("PRENDA ENCONTRADA\n" +
                                    "Marca: " + prenda.getMarca() + "\n" +
                                    "Referencia: " + prenda.getReferencia() + "\n" +
                                    "Cantidad: " + prenda.getCantidad() + "\n" +
                                    "Precio: " + prenda.getPrecio() + "\n");
                } 
                else
                {
                    System.out.println("Prenda no encontrada");
                }
            }
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
}
