package U1_Recursividad.ejercicios;

public class OchoReinas {
    private static final int N = 15;
    private static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < N; i++) {
        	System.out.printf("%20s"," ");
            for (int j = 0; j < N; j++) {
                if (tablero[i][j] == 1) {
                    System.out.printf("%4s","R"); // Q representa una reina
                } else {
                    System.out.printf("%4s","-"); // - representa una casilla vacía
                }
            }
            System.out.println();
        }
    }

    // Método para verificar si es seguro colocar una reina en tablero[row][col]
    private static boolean esSeguro(int[][] tablero, int fila, int col) {
        // Verificar la fila hacia la izquierda
        for (int i = 0; i < col; i++) {
            if (tablero[fila][i] == 1) {
                return false;
            }
        }

        // Verificar la diagonal superior izquierda
        for (int i = fila, j = col; i >= 0 && j >= 0; i--, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        // Verificar la diagonal inferior izquierda
        for (int i = fila, j = col; i < N && j >= 0; i++, j--) {
            if (tablero[i][j] == 1) {
                return false;
            }
        }

        return true;
    }

    // Método para resolver el problema de las 8 reinas utilizando Backtracking
    private static boolean resolverReinas(int[][] tablero, int col) {
        // Caso base: si se han colocado todas las reinas
        if (col >= N) {
            return true;
        }

        // Probar colocando la reina en cada fila de la columna actual
        for (int i = 0; i < N; i++) {
            if (esSeguro(tablero, i, col)) {
                // Colocar la reina en la casilla tablero[i][col]
                tablero[i][col] = 1;

                // Recursivamente intentar colocar el resto de las reinas
                if (resolverReinas(tablero, col + 1)) {
                    return true;
                }

                // Si no es posible, retirar la reina (Backtracking)
                tablero[i][col] = 0;
            }
        }

        // Si no se puede colocar una reina en ninguna fila de esta columna, retornar falso
        return false;
    }

   
    public static void main(String[] args) {
        int[][] tablero = new int[N][N]; 

       
        if (!resolverReinas(tablero, 0)) {
        	System.out.println("No hay solución");
        	return;
           
        } 
        imprimirTablero(tablero); 
    }
}
