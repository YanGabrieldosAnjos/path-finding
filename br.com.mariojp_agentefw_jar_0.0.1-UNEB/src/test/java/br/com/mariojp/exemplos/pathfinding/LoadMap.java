package br.com.mariojp.exemplos.pathfinding;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class LoadMap {
    String path;
    String name;
    String[][] map;

    public static final String ORIGIN = "@";
    public static final String DESTINY = "&";
    public static final String EMPTY_SPACE = "$";
    public static final String OBSTACLE = "*";

    public LoadMap(String name, String path){
        this.name = name;
        this.path = path;
        this.map = this.loadMap(path);
    }

    public String getName() {
        return name;
    }

    public String getPath() {
        return path;
    }

    public void setMap(String[][] map) {
        this.map = map;
    }

    public String[][] getMap() {
        return this.map;
    }
    public String[][] loadMap(String path) {
        try{
            File mapFile = new File(path);
            ArrayList<String[]>  mapLine = new ArrayList<>();


            Scanner myReader = new Scanner(mapFile);
            while (myReader.hasNextLine()) {
                mapLine.add(myReader.nextLine().split(""));
            }
            myReader.close();
            String [][] map = new String[mapLine.size()][];

            for(int i =0; i < mapLine.size(); i++){
                String[] row = mapLine.get(i);
                map[i] = row;
            }
            return map;
        }catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

        return null;
    }
}