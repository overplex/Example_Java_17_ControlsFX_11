package org.openjfx;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.controlsfx.control.spreadsheet.GridBase;
import org.controlsfx.control.spreadsheet.SpreadsheetCell;
import org.controlsfx.control.spreadsheet.SpreadsheetCellType;
import org.controlsfx.control.spreadsheet.SpreadsheetView;

public class MainApp extends Application {

    private static final int SIZE = 10;

    @Override
    public void start(Stage stage) {

        GridBase grid = new GridBase(SIZE, SIZE);
        fillGrid(grid);
        SpreadsheetView spreadsheetView = new SpreadsheetView(grid);

        Scene scene = new Scene(spreadsheetView);
        stage.setTitle("Java 17, JavaFX 17, ControlsFX 11.1.1, Gradle 7.4, Modular");
        stage.setScene(scene);
        stage.show();
    }

    public SpreadsheetCell createCell(int row, int column, String content) {
        return SpreadsheetCellType.STRING.createCell(row, column, 1, 1, content);
    }

    public void fillGrid(GridBase grid) {

        ObservableList<ObservableList<SpreadsheetCell>> rows = FXCollections.observableArrayList();

        for (int row = 0; row < SIZE; row++) {
            final ObservableList<SpreadsheetCell> gridRow = FXCollections.observableArrayList();
            for (int column = 0; column < SIZE; column++) {
                gridRow.add(createCell(row, column, ""));
            }
            rows.add(gridRow);
        }

        grid.setRows(rows);

        int a = SIZE / 2;
        int b = a - 1;
        grid.setCellValue(b, b, "Java");
        grid.setCellValue(b, a, System.getProperty("java.version"));
        grid.setCellValue(a, b, "JavaFX");
        grid.setCellValue(a, a, System.getProperty("javafx.version"));
    }

    public static void main(String[] args) {
        launch(args);
    }
}
