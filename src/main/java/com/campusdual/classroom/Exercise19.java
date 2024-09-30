package com.campusdual.classroom;

public class Exercise19 {

    public static int[] createAndPopulateUnidimensionalArray(int columns) {
        int[] uniArray = new int[columns];
        for (int i = 0; i < columns; i++) {
            uniArray[i] = i + 1;  // Llenar el array con números naturales
        }
        return uniArray;
    }

    public static int[][] createAndPopulateBidimensionalArray(int rows, int columns) {
        int[][] biArray = new int[rows][columns];
        int value = 1;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                biArray[i][j] = value++;  // Llenar el array con números naturales
            }
        }
        return biArray;
    }

    public static int[][][] createAndPopulateTridimensionalArray(int depth, int rows, int columns) {
        int[][][] triArray = new int[depth][rows][columns];
        int value = 1;
        for (int i = 0; i < depth; i++) {
            for (int j = 0; j < rows; j++) {
                for (int k = 0; k < columns; k++) {
                    triArray[i][j][k] = value++;  // Llenar el array con números naturales
                }
            }
        }
        return triArray;
    }

    public static String getUnidimensionalString(int[] uniArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < uniArray.length; i++) {
            sb.append(uniArray[i]);
            if (i < uniArray.length - 1) {
                sb.append(" ");  // Espacio entre números
            }
        }
        return sb.toString();
    }

    public static String getBidimensionalString(int[][] biArray) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < biArray.length; i++) {
            sb.append(getUnidimensionalString(biArray[i]));  // Convertir cada fila en String
            if (i < biArray.length - 1) {
                sb.append("\n");  // Salto de línea entre filas
            }
        }
        return sb.toString();
    }

    public static int[][] flatTridimensionalArray(int[][][] intArrayTri) {
        int rows = intArrayTri[0].length;
        int cols = intArrayTri[0][0].length;
        int[][] flatArray = new int[rows][cols];

        // Aplanar el array tridimensional
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                for (int k = 0; k < intArrayTri.length; k++) {
                    flatArray[i][j] += intArrayTri[k][i][j];  // Sumar los valores en la misma posición
                }
            }
        }
        return flatArray;
    }

    public static String getTridimensionalString(int[][][] intArrayTri) {
        int[][] flatMatrix = flatTridimensionalArray(intArrayTri);
        return getTridimensionalString(intArrayTri, flatMatrix);
    }

    private static String getTridimensionalString(int[][][] intArrayTri, int[][] flatMatrix) {
        StringBuilder sb = new StringBuilder();
        int rows = intArrayTri[0].length;

        for (int i = 0; i < rows; i++) {
            sb.append(stringFlatMatrixRow(flatMatrix, i));
            sb.append("   →   ");
            sb.append(stringTriMatrixRow(intArrayTri, i));
            sb.append("\n");
        }
        sb.deleteCharAt(sb.length() - 1);  // Eliminar el último salto de línea
        return sb.toString();
    }

    private static String stringTriMatrixRow(int[][][] intArrayTri, int row) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intArrayTri.length; i++) {
            sb.append(getUnidimensionalString(intArrayTri[i][row]));
            if (i < intArrayTri.length - 1) {
                sb.append("   ");  // Espacio entre matrices
            }
        }
        return sb.toString();
    }

    private static String stringFlatMatrixRow(int[][] flatMatrix, int row) {
        return getUnidimensionalString(flatMatrix[row]);
    }

    public static void main(String[] args) {
        int[] uniArray = createAndPopulateUnidimensionalArray(5);
        System.out.println(getUnidimensionalString(uniArray));
        System.out.println("===================");
        int[][] intArrayBi = createAndPopulateBidimensionalArray(3, 3);
        System.out.println(getBidimensionalString(intArrayBi));
        System.out.println("===================");
        int[][][] intArrayTri = createAndPopulateTridimensionalArray(2, 2, 2);
        System.out.println(getTridimensionalString(intArrayTri));
    }
}
