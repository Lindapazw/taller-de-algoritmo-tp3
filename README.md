# Gestión de Productos con Lista Doblemente Enlazada en Java

Este proyecto implementa una lista doblemente enlazada en Java para gestionar una serie de productos. Cada producto tiene un código, una descripción y un precio. La lista mantiene los productos ordenados por código de menor a mayor.

## Estructura del Proyecto

El proyecto consta de los siguientes archivos:

- `Producto.java`: Clase que representa un producto con un código, una descripción y un precio.
- `Nodo.java`: Clase que representa un nodo en la lista doblemente enlazada.
- `ListaDobleEnlazada.java`: Clase que implementa la lista doblemente enlazada y los métodos para insertar y listar productos.
- `Main.java`: Clase principal que inserta productos de prueba en la lista y los lista por pantalla.

## Clases y Métodos

### Producto.java

```java
class Producto {
    int codigo;
    String descripcion;
    double precio;
    
    public Producto(int codigo, String descripcion, double precio) {
        this.codigo = codigo;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Producto{" +
                "codigo=" + codigo +
                ", descripcion='" + descripcion + '\'' +
                ", precio=" + precio +
                '}';
    }
}
```

### Nodo.java
```java
class Nodo {
    Producto producto;
    Nodo anterior;
    Nodo siguiente;

    public Nodo(Producto producto) {
        this.producto = producto;
    }
}
```

### ListaDobleEnlazada.java
```java
class ListaDobleEnlazada {
    Nodo inicio;
    Nodo fin;

    public ListaDobleEnlazada() {
        inicio = null;
        fin = null;
    }

    public void insertar(Producto producto) throws Exception {
        Nodo nuevo = new Nodo(producto);
        if (inicio == null) {
            inicio = nuevo;
            fin = nuevo;
        } else if (inicio.producto.codigo > producto.codigo) {
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

```

### Main.java
```java
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

```

## Cómo Compilar y Ejecutar

1. **Abrir la Terminal en Visual Studio Code:**
   - Ve a "View" > "Terminal" para abrir una nueva terminal integrada en VS Code.


2. **Compilar los Archivos Java:**
   - Ejecuta el siguiente comando para compilar todos los archivos Java:
     ```sh
     javac Producto.java Nodo.java ListaDobleEnlazada.java Main.java
     ```

3. **Ejecutar el Programa:**
   - Una vez que los archivos estén compilados, ejecuta el programa principal con el siguiente comando:
     ```sh
     java Main
     ```

## Requisitos

- Java Development Kit (JDK) instalado en tu sistema.
- Visual Studio Code u otro editor de texto.
