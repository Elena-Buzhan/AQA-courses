package courses.lesson_7;

public class MainL7 {
    public static void main(String[] args) {
        String[][] matrix = new String[][]{
                {"1", "2", "3", "4"},
                {"3", "6", "2", "2"},
                {"3", "3", "3", "3"},
                {"4", "4", "4", "д"}
        };
        double sum;

        try {
            sum = calcSum(matrix);
            System.out.println("Сумма = " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива не 4x4");
        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

    }


    public static double calcSum(String[][] matrix) throws MyArraySizeException, MyArrayDataException {
        if (!is4x4Matrix(matrix)) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                try {
                    sum += Integer.parseInt(matrix[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверный символ в ячейке: [" + i + "][" + j + "]. " + e.getMessage());
                }
            }
        }
        return sum;
    }

    public static boolean is4x4Matrix(String[][] matrix) {
        if (matrix.length != 4) {
            return false;
        }
        for (int i = 0; i < matrix.length; i++) {
            if (matrix[i].length != 4) {
                return false;
            }
        }
        return true;
    }

}

