public class Main {
    public static void main(String[] args) {
        try {
            ListaDobleEnlazada lista = new ListaDobleEnlazada();
            
            lista.insertar(new Producto(10, "Producto A", 15.99));
            lista.insertar(new Producto(5, "Producto B", 10.99));
            lista.insertar(new Producto(20, "Producto C", 25.99));
            lista.insertar(new Producto(15, "Producto D", 20.99));
            lista.insertar(new Producto(8, "Producto E", 12.99));
            lista.insertar(new Producto(12, "Producto F", 18.99));
            
            lista.listar();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
