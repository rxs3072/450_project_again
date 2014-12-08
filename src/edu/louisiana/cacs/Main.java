package edu.louisiana.cacs;
//import edu.louisiana.cacs.csce450GProject;
import java.io.*;

import edu.louisiana.cacs.csce450GProject.Parser;
//import edu.louisiana.cacs.csce450GProject.SebastaScanner;
public class Main  {
    public static void main(String[] args) throws IOException{
        System.out.println("Hello World from Main");
        
       Parser myParser = new Parser(args[0]);
        
        myParser.parse();
        
    }
}