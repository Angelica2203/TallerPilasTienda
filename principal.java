import java.util.Stack;
import javax.swing.JOptionPane;
public class principal 
{
    public int Menu()
    {
        String input;
        int vrUsu = 0; 
        boolean validInput = false;
        do 
        {
            input = JOptionPane.showInputDialog("---------- MENU ----------\n" +
                                                "1.Registrar Prenda\n" +
                                                "2.Buscar Prenda\n" +
                                                "3.Modificar Prenda\n" +
                                                "4.Vender Prenda\n" + 
                                                "5.Consultar Stock\n" + 
                                                "6.Salir\n");
            if (input != null && input.matches("\\d+")) 
            {
                vrUsu = Integer.parseInt(input);
                if (vrUsu >= 1 && vrUsu <= 6) 
                {
                    validInput = true;
                } 
                else 
                {
                    JOptionPane.showMessageDialog(null, "Opción no válida, reintente por favor");
                }
            } 
            else 
            {
                JOptionPane.showMessageDialog(null, "Error: Debe ingresar un número válido.");
            }

        } while (!validInput);

        return vrUsu;
    }
    public static void main(String[] args) 
    {
        Stack<Tienda> pila = new Stack<>();
        int opc;
        do 
        {
            metodos met = new metodos();
            principal m = new principal();
            opc = m.Menu();
            switch (opc) 
            {
                case 1:
                    pila = met.RegistrarPrenda(pila);
                    break;
                case 2:
                    met.BuscarPrenda(pila);
                    break;
                case 3:
                    met.ModificarPrenda(pila);
                    break;
                case 4:
                    met.VenderPrenda(pila);
                    break;
                case 5:
                    met.ConsultarStock(pila);
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "El programa ha terminado");
                    break;
            }
            
        } while (opc != 6);
    }
}
