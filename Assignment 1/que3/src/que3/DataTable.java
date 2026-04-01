/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package que3;

/**
 *
 * @author root
 */

import java.util.Hashtable;
public class DataTable implements Featurable {

    private int rows;
    private int cols;
    private String[][] table;

    private String foreground = "Black";
    private String background = "White";
    private String font = "Default";

    public DataTable(int rows, int cols) throws TableException {
        if (rows > 200 || cols > 200) {
            throw new TableException("Rows or Columns cannot exceed 200");
        }
        this.rows = rows;
        this.cols = cols;
        table = new String[rows][cols];
    }

    // Insert value
    public void setValue(int r, int c, String value) {
        table[r][c] = value;
    }

    // Display table
    public void display() {
        System.out.println("\nTable Content:");
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.print((table[i][j] == null ? "-" : table[i][j]) + "\t");
            }
            System.out.println();
        }
    }

    // Insert Row
    public void insertRow() throws TableException {
        if (rows + 1 > 200) {
            throw new TableException("Maximum row limit reached");
        }

        String[][] newTable = new String[rows + 1][cols];
        for (int i = 0; i < rows; i++)
            newTable[i] = table[i];

        table = newTable;
        rows++;
    }

    // Delete Row
    public void deleteRow(int r) {
        String[][] newTable = new String[rows - 1][cols];
        int k = 0;
        for (int i = 0; i < rows; i++) {
            if (i != r) {
                newTable[k++] = table[i];
            }
        }
        table = newTable;
        rows--;
    }

    // Insert Column
    public void insertColumn() throws TableException {
        if (cols + 1 > 200) {
            throw new TableException("Maximum column limit reached");
        }

        String[][] newTable = new String[rows][cols + 1];
        for (int i = 0; i < rows; i++)
            System.arraycopy(table[i], 0, newTable[i], 0, cols);

        table = newTable;
        cols++;
    }

    // Delete Column
    public void deleteColumn(int c) {
        String[][] newTable = new String[rows][cols - 1];
        for (int i = 0; i < rows; i++) {
            int k = 0;
            for (int j = 0; j < cols; j++) {
                if (j != c) {
                    newTable[i][k++] = table[i][j];
                }
            }
        }
        table = newTable;
        cols--;
    }

    // Populate using Hashtable
    public void populateFromHashtable(Hashtable<Integer, String> ht) {
        int index = 0;
        for (String value : ht.values()) {
            table[index / cols][index % cols] = value;
            index++;
            if (index >= rows * cols) break;
        }
    }

    // Featurable methods
    public void setForeground(String color) {
        foreground = color;
    }

    public void setBackground(String color) {
        background = color;
    }

    public void setFont(String font) {
        this.font = font;
    }

    public String getForeground() {
        return foreground;
    }

    public String getBackground() {
        return background;
    }

    public String getFont() {
        return font;
    }
}
