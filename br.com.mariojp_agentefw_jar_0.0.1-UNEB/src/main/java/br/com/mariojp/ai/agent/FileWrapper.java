package br.com.mariojp.ai.agent;

import java.io.FileWriter;
import java.io.IOException;

public class FileWrapper {
  public void fileWriter(String pathname, String name, String content) {
    try {
      FileWriter myWriter = new FileWriter(pathname + "/" + name, true);
      myWriter.append(content);
      myWriter.close();
      System.out.println("Successfully saved " + name);
    } catch (IOException e) {
      System.out.println("An error occurred " + name);
      e.printStackTrace();
    }
  }
}
