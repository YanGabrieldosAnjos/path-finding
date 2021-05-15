package br.com.mariojp.exemplos.bestpath;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.Random;

public class GenerateMaps {
  private String[][] buildMap;
  private int column = 0;
  private int row = 0;
  private String[] charSpecial = {"*", "*", "$", "$","$","$","$"};

  private int _generate(int min, int max) {
    Random random = new Random();
    int randomNumber =  random.nextInt(max + 1 - min) + min;
    try {
        if (randomNumber >= min && randomNumber <= max ) {
          return randomNumber;
        }
        
			throw new Exception("Retry");
    } catch (Exception e) {
      return this._generate(min, max);
    }
  }

  private void _generateEmptyMatrices() {
    this.column = this._generate(0, 100);
    this.row = this._generate(0, 100);

    this.buildMap = new String[row][column];
  } 

  public void fileCreate(String pathname, String name, String content) {
    try {
      File myObj = new File(pathname + "/" + name);
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }
  }

  public void fileWriter(String pathname, String name, String content) {
    try {
      FileWriter myWriter = new FileWriter(pathname + "/" + name);
      myWriter.write(content);
      myWriter.close();
      System.out.println("Successfully saved " + name);
    } catch (IOException e) {
      System.out.println("An error occurred " + name);
      e.printStackTrace();
    }
  }

  public void exec(int idx) {
    this._generateEmptyMatrices();

    try {
      for (int i = 0; i < this.row; i++) {
        for (int j = 0; j < this.column; j++) {
          this.buildMap[i][j] =  charSpecial[this._generate(0, 6)];
        }
      }       

      int[] start = {this._generate(0, this.row), this._generate(0, this.column)};
      int[] end = {this._generate(0, this.row), this._generate(0, this.column)};

      String content = "";
      String content2 = "";
      this.buildMap[start[0]][start[1]] = "@";
      this.buildMap[end[0]][end[1]] = "&";

      String[][] buildMapCopy = Arrays.stream(this.buildMap).map(String[]::clone).toArray(String[][]::new);

      buildMapCopy[start[0]][start[1]] = "$";
      buildMapCopy[end[0]][end[1]] = "@";

      for (int i = 0; i < this.row; i++) {
          for (int j = 0; j < this.column; j++) {
            content += this.buildMap[i][j];
            content2 += buildMapCopy[i][j];
          }
          content += "\n";
          content2 += "\n";
      }

      this.fileWriter("br.com.mariojp_agentefw_jar_0.0.1-UNEB/src/test/resources/maps", idx + "-init-map", content);
      this.fileWriter("br.com.mariojp_agentefw_jar_0.0.1-UNEB/src/test/resources/maps", idx + "-target-map", content2);
    } catch (Exception e) {
      this.exec(idx);
    }
  } 
}
