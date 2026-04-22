public class main {

    // complejidad de tiempo O(n) para encontrar el máximo en un array, 
    // ya que se debe recorrer todo el array una vez para comparar cada elemento con el máximo actual.
    // a medida que el tamaño del array aumenta, el tiempo de ejecución también aumenta linealmente.
    // Fragmento 1
    public static int encontrarMaximo(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
        if (array[i] > max) {
        max = array[i];
        }
        }
        return max;
    }
    //complejidad de tiempo O(n) para verificar si un número es primo,
    // ya que en el peor de los casos (cuando n es primo) se deben verificar todos los número.
    // a medida que n aumenta, el número de verificaciones también aumenta, aunque no de manera lineal, sino de manera sublineal.
    // Fragmento 2
    public static boolean esPrimo(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) return false;
        }
        return true;
    }
    // La complejidad de tiempo para imprimir una matriz de tamaño m x n es O(n^2),
    // ya que se deben recorrer todos los elementos de la matriz para imprimirlos.
    // a medida que el número de filas (m) y columnas (n) aumenta, el tiempo de ejecución también aumenta proporcionalmente al producto de O(n^2)
    // Fragmento 3
    public static void imprimirMatriz(int[][] matriz) {
        for (int i = 0; i < matriz.length; i++) {
        for (int j = 0; j < matriz[i].length; j++) {
        System.out.print(matriz[i][j] + " ");
        }
        System.out.println();
        }
    }
    // La complejidad de tiempo para la búsqueda binaria es O(log n),
    // ya que en cada paso se divide el espacio de búsqueda a la mitad.
    // a medida que el tamaño del array aumenta, el número de comparaciones necesarias para encontrar el objetivo aumenta logarítmicamente, 
    // lo que hace que la búsqueda binaria sea mas eficaz que la búsqueda lineal (O(n)) para arrays grandes, siempre y cuando el array esté ordenado previamente.
    // Fragmento 4
    public static int busquedaBinaria(int[] array, int objetivo) {
        int izq = 0, der = array.length - 1;
        while (izq <= der) {
        int medio = izq + (der - izq) / 2;
        if (array[medio] == objetivo) return medio;
        if (array[medio] < objetivo) izq = medio + 1;
        else der = medio - 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] array = {3, 5, 7, 2, 8};
        System.out.println("Máximo: " + encontrarMaximo(array));

        int numero = 29;
        System.out.println(numero + " es primo? " + esPrimo(numero));

        int[][] matriz = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println("Matriz:");
        imprimirMatriz(matriz);

        int[] arrayOrdenado = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        int objetivo = 5;
        int resultado = busquedaBinaria(arrayOrdenado, objetivo);
        if (resultado != -1) {
            System.out.println("Elemento " + objetivo + " encontrado en índice: " + resultado);
        } else {
            System.out.println("Elemento " + objetivo + " no encontrado en el array.");
        }
    }
}