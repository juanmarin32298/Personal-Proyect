public class TallerRecursividad {

    // Ejercicios: NIVEL 1 =====================

    // 1. Multiplicación por sumas
    // Caso base: b == 0
    // Caso recursivo: a + multiplicar(a, b - 1)
    // Reducción: b se acerca a 0
    public static int multiplicar(int a, int b) {
        if (b == 0)
            return 0;
        return a + multiplicar(a, b - 1);
    }

    // 2. Suma de pares
    // Caso base: n == 0
    // Caso recursivo: 2*n + sumaPares(n-1)
    // Reducción: n se acerca a 0
    public static int sumaPares(int n) {
        if (n == 0)
            return 0;
        return 2 * n + sumaPares(n - 1);
    }

    // 3. Imprimir array
    // Caso base: i == arr.length
    // Caso recursivo: imprimir + avanzar índice
    // Reducción: i se acerca a arr.length
    public static void imprimir(int[] arr, int i) {
        if (i == arr.length)
            return;
        System.out.print(arr[i] + " ");
        imprimir(arr, i + 1);
    }

    // 4. Contar letra
    // Caso base: cadena vacía
    // Caso recursivo: sumar coincidencia + resto
    // Reducción: palabra se acorta cada vez más
    public static int contarLetra(String palabra, char letra) {
        if (palabra.isEmpty())
            return 0;
        int suma = (palabra.charAt(0) == letra) ? 1 : 0;
        return suma + contarLetra(palabra.substring(1), letra);
    }

    // 5. Longitud de string
    // Caso base: ""
    // Caso recursivo: 1 + resto
    // Reducción: palabra se acorta cada vez más
    public static int longitud(String palabra) {
        if (palabra.equals(""))
            return 0;
        return 1 + longitud(palabra.substring(1));
    }

    // 6. Cuenta progresiva
    // Caso base: n == 0
    // Caso recursivo: primero llamada, luego imprime
    // Reducción: n se acerca a 0
    public static void cuenta(int n) {
        if (n == 0)
            return;
        cuenta(n - 1);
        System.out.print(n + " ");
    }

    // 7. Eliminar primera aparición
    // Caso base: string vacío
    // Caso recursivo: si coincide, omitir; si no, conservar + resto
    // Reducción: string se acorta cada vez más
    public static String eliminarPrimero(String s, char c) {
        if (s.isEmpty())
            return "";
        if (s.charAt(0) == c)
            return s.substring(1);
        return s.charAt(0) + eliminarPrimero(s.substring(1), c);
    }

    // Ejercicios: NIVEL 2 =====================

    // 8. Invertir array
    // Caso base: inicio >= fin
    // Caso recursivo: intercambiar + avanzar inicio y retroceder fin
    // Reducción: inicio se acerca a fin y fin se acerca a inicio
    public static void invertir(int[] arr, int inicio, int fin) {
        if (inicio >= fin)
            return;
        int temp = arr[inicio];
        arr[inicio] = arr[fin];
        arr[fin] = temp;
        invertir(arr, inicio + 1, fin - 1);
    }

    // 9. Verificar orden
    // Caso base: último elemento
    // Caso recursivo: comparar actual con siguiente + avanzar índice
    // Reducción: índice se acerca a arr.length - 1
    public static boolean estaOrdenado(int[] arr, int i) {
        if (i >= arr.length - 1)
            return true;
        if (arr[i] >= arr[i + 1])
            return false;
        return estaOrdenado(arr, i + 1);
    }

    // 10. Decimal a binario
    // Caso base: n == 0
    // Caso recursivo: aBinario(n / 2) + (n % 2)
    // Reducción: n se acerca a 0
    public static String aBinario(int n) {
        if (n == 0)
            return "";
        return aBinario(n / 2) + (n % 2);
    }

    // 11. Padovan
    // Caso base: n=0,1,2
    // Caso recursivo: padovan(n-2) + padovan(n-3)
    // Reducción: n se acerca a 0,1,2
    public static int padovan(int n) {
        if (n == 0 || n == 1 || n == 2)
            return 1;
        return padovan(n - 2) + padovan(n - 3);
    }

    // 12. Eliminar vocales
    // Caso base: vacío
    // Caso recursivo: si es vocal, omitir; si no, conservar + resto
    // Reducción: string se acorta cada vez más
    public static String sinVocales(String s) {
        if (s.isEmpty())
            return "";
        char c = s.charAt(0);
        if ("aeiouAEIOU".indexOf(c) != -1) {
            return sinVocales(s.substring(1));
        }
        return c + sinVocales(s.substring(1));
    }

    // 13. MCD
    // Caso base: b == 0
    // Caso recursivo: mcd(b, a % b)
    // Reducción: b se acerca a 0
    public static int mcd(int a, int b) {
        if (b == 0)
            return a;
        return mcd(b, a % b);
    }

    // 14. Número primo
    // Caso base: divisor == 1
    // Caso recursivo: si n divisible por divisor → no primo; si no, seguir con divisor-1
    // Reducción: divisor se acerca a 1
    public static boolean esPrimo(int n, int divisor) {
        if (divisor == 1)
            return true;
        if (n % divisor == 0)
            return false;
        return esPrimo(n, divisor - 1);
    }

    // 15. Suma pares en array
    // Caso base: fin del array
    // Caso recursivo: si es par, sumar valor + resto; si no, solo resto
    // Reducción: índice se acerca a arr.length
    public static int sumaParesArray(int[] arr, int i) {
        if (i == arr.length)
            return 0;
        int valor = (arr[i] % 2 == 0) ? arr[i] : 0;
        return valor + sumaParesArray(arr, i + 1);
    }

    // 16. Triángulo
    // Caso base: n == 0
    // Caso recursivo: imprimir después de la llamada
    public static void triangulo(int n) {
        if (n == 0)
            return;
        triangulo(n - 1);
        for (int i = 0; i < n; i++) {
            System.out.print("*");
        }
        System.out.println();
    }

    // 17. Caminos en grid
    // Caso base: llegada
    // Caso inválido: fuera de límites
    // Caso recursivo: avanzar hacia abajo + avanzar hacia derecha
    public static int caminos(int f, int c, int i, int j) {
        if (i == f - 1 && j == c - 1)
            return 1;
        if (i >= f || j >= c)
            return 0;
        return caminos(f, c, i + 1, j) + caminos(f, c, i, j + 1);
    }

    // Ejercicios: NIVEL 3 =====================

    // 18. Permutaciones
    // Caso base: restante vacía
    // Caso recursivo: para cada letra en restante, crear nuevo prefijo y nuevo restante, luego llamar recursivamente
    // Reducción: restante se acorta cada vez más
    public static void permutaciones(String prefijo, String restante) {
        if (restante.isEmpty()) {
            System.out.println(prefijo);
            return;
        }

        for (int i = 0; i < restante.length(); i++) {
            char letra = restante.charAt(i);
            String nuevoPrefijo = prefijo + letra;
            String nuevoRestante = restante.substring(0, i) + restante.substring(i + 1);
            permutaciones(nuevoPrefijo, nuevoRestante);
        }
    }

    // 19. Coin Change
    // Caso base: cantidad == 0
    // Caso inválido: cantidad < 0 o no hay más monedas
    // Caso recursivo: usar la moneda actual + no usar la moneda actual
    public static int coinChange(int[] monedas, int cantidad, int i) {
        if (cantidad == 0)
            return 1;
        if (cantidad < 0 || i == monedas.length)
            return 0;
        return coinChange(monedas, cantidad - monedas[i], i) + coinChange(monedas, cantidad, i + 1);
    }

    // 20. Laberinto
    // Caso base: llegada
    // Caso inválido: fuera de límites o pared
    // Caso recursivo: avanzar en las 4 direcciones
    public static boolean resolverLaberinto(boolean[][] lab, int i, int j) {
        int n = lab.length;

        if (i < 0 || j < 0 || i >= n || j >= n || !lab[i][j])
            return false;

        if (i == n - 1 && j == n - 1)
            return true;

        lab[i][j] = false;

        return resolverLaberinto(lab, i + 1, j) ||
                resolverLaberinto(lab, i - 1, j) ||
                resolverLaberinto(lab, i, j + 1) ||
                resolverLaberinto(lab, i, j - 1);
    }

    // MAIN
    public static void main(String[] args) {
        // Aquí puedes probar las funciones implementadas
        System.out.println("Multiplicar 3 x 4: " + multiplicar(3, 4));
        System.out.println("Suma de pares hasta 5: " + sumaPares(5));
        int[] arr = { 1, 2, 3, 4, 5 };
        System.out.print("Imprimir array: ");
        imprimir(arr, 0);
        System.out.println("\nContar 'a' en 'banana': " + contarLetra("banana", 'a'));
        System.out.println("Longitud de 'hola': " + longitud("hola"));
        System.out.print("Cuenta progresiva hasta 5: ");
        cuenta(5);
        System.out.println("\nEliminar primera 'a' de 'banana': " + eliminarPrimero("banana", 'a'));
        int[] arr2 = { 1, 2, 3, 4, 5 };
        invertir(arr2, 0, arr2.length - 1);
        System.out.print("Array invertido: ");
        imprimir(arr2, 0);
        System.out.println("\nEstá ordenado? " + estaOrdenado(arr2, 0));
        System.out.println("Decimal 10 a binario: " + aBinario(10));
        System.out.println("Padovan(5): " + padovan(5));
        System.out.println("Sin vocales en 'hola mundo': " + sinVocales("hola mundo"));
        System.out.println("MCD de 48 y 18: " + mcd(48, 18));
        System.out.println("¿Es 17 primo? " + esPrimo(17, 16));
        int[] arr3 = { 1, 2, 3, 4, 5, 6 };
        System.out.println("Suma de pares en array: " + sumaParesArray(arr3, 0));
        System.out.println("Triángulo de 5 filas:");
        triangulo(5);
        System.out.println("Caminos en grid 3x3: " + caminos(3, 3, 0, 0));
        System.out.println("Permutaciones de 'abc':");
        permutaciones("", "abc");
        boolean[][] laberinto = {
                { true, false, true, true },
                { true, true, false, true },
                { false, true, true, false },
                { true, false, true, true }
        };
        System.out.println("Resolviendo laberinto:");
        System.out.println("Se puede llegar al final? " + resolverLaberinto(laberinto, 0, 0));
    }
}
