public class Main {
    public static void main(String[] args) {
        try {
            ListaDobleEnlazada lista = new ListaDobleEnlazada();
            
            lista.insertar(new Producto(101, "Laptop Dell XPS 13", 999.99));
            lista.insertar(new Producto(102, "Smartphone Samsung Galaxy S21", 799.99));
            lista.insertar(new Producto(103, "Auriculares Bose QuietComfort 35", 299.99));
            lista.insertar(new Producto(104, "Tablet Apple iPad Pro", 1099.99));
            lista.insertar(new Producto(105, "Monitor LG UltraWide", 499.99));
            lista.insertar(new Producto(106, "Teclado Mecánico Logitech", 149.99));
            
            lista.listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
