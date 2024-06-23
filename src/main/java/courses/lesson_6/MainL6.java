package courses.lesson_6;

public class MainL6 {
    public static void main(String[] args) {
        String[] header = {"C1", "C2", "C3"};
        int[][] data = {
                {1, 1, 1},
                {2, 2, 2},
                {3, 3, 3}
        };
        AppData appData = new AppData(header, data);
        CsvHandler.saveData(appData, "fileCSV.csv");

        AppData loadedData = CsvHandler.loadFile("fileCSV.csv");
        System.out.println(loadedData);
    }
}
