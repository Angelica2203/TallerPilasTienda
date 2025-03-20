public class Tienda 
{
    private String marca;
    private int referencia;
    private int cantidad;
    private double precio;
    public Tienda() 
    {

    }
    public Tienda(String marca, int referencia, int cantidad, double precio) 
    {
        this.marca = marca;
        this.referencia = referencia;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    public String getMarca() {
        return marca;
    }
    public int getReferencia() {
        return referencia;
    }
    public int getCantidad() {
        return cantidad;
    }
    public double getPrecio() {
        return precio;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public void setReferencia(int referencia) {
        this.referencia = referencia;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
