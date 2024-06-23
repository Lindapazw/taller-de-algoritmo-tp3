class ListaDobleEnlazada {
    Nodo inicio;
    Nodo fin;

    public ListaDobleEnlazada() {
        inicio = null;
        fin = null;
    }

    public void insertar(Producto producto) throws Exception {
        Nodo nuevo = new Nodo(producto);
        if (inicio == null) { // Lista vacía
            inicio = nuevo;
            fin = nuevo;
        } else if (inicio.producto.codigo > producto.codigo) { // Insertar al inicio
            if (inicio.producto.codigo == producto.codigo) throw new Exception("Código duplicado");
            nuevo.siguiente = inicio;
            inicio.anterior = nuevo;
            inicio = nuevo;
        } else {
            Nodo actual = inicio;
            while (actual.siguiente != null && actual.siguiente.producto.codigo < producto.codigo) {
                actual = actual.siguiente;
            }
            if (actual.siguiente != null && actual.siguiente.producto.codigo == producto.codigo) {
                throw new Exception("Código duplicado");
            }
            nuevo.siguiente = actual.siguiente;
            if (actual.siguiente != null) {
                actual.siguiente.anterior = nuevo;
            } else {
                fin = nuevo;
            }
            actual.siguiente = nuevo;
            nuevo.anterior = actual;
        }
    }

    public void listar() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.producto);
            actual = actual.siguiente;
        }
    }
}
