package com.lablll.labwork4;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

    private String filename;
    private CharFactory charFactory = new CharFactory();
    private List<EnglishCharacter> words;

    ReadFromFile(String filename, ArrayList<EnglishCharacter> words) {
        this.words = words;
        this.filename = filename;
    }
    public ArrayList<Coordinate> read() {
        ArrayList<Coordinate> coordinates = new ArrayList<>();
        try(FileReader reader = new FileReader(filename))
        {
            // читаем посимвольно
            int c;
            int line = 1, column = 0;
            while((c = reader.read()) != -1){


                if((char)c == '\r') {
                    continue;

                }
                if((char)c == '\n') {
                    line++;
                    column = 0;
                    continue;
                }
                words.add(charFactory.getChar((char)c));
                coordinates.add(new Coordinate(line, column));
                column++;
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        return coordinates;
    }
}
