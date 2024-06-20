package courses.lesson_6;

import java.io.*;

public class CsvHandler {
    public static void saveData(AppData appData, String fileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            writer.write(String.join(";", appData.getHeader()));
            writer.newLine();

            for (int[] row : appData.getData()) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int value : row) {
                    if (stringBuilder.length() > 0) {
                        stringBuilder.append(";");
                    }
                    stringBuilder.append(value);
                }
                writer.write(stringBuilder.toString());
                writer.newLine();
            }
            System.out.println("Data saved to file successfully");
        } catch (IOException e) {
            System.out.println("Error saving file");
            e.printStackTrace();
        }

    }

    public static AppData loadFile(String filePatch) {
        String[] header = null;
        int[][] data = null;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePatch))) {
            String headerLine = reader.readLine();
            header = headerLine.split(";");

            int rows = (int) (reader.lines().count()+1);
            data = new int[rows][header.length];

            String line;
            int rowIndex = 0;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(";");
                for (int i = 0; i < values.length; i++) {
                    data[rowIndex][i] = Integer.parseInt(values[i]);
                }

                rowIndex++;
            }

            System.out.println("File loaded successfully");
        } catch (IOException e) {
            System.out.println("Error");
            e.printStackTrace();
        }
        return new AppData(header, data);
    }

}
