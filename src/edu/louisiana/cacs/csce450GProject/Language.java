package edu.louisiana.cacs.csce450GProject;
import java.util.ArrayList;
import java.util.List;
import edu.louisiana.cacs.csce450GProject.*;
public class Language {
	public static String[] rules=new String[10];
	public static List<Integer> length=new ArrayList<Integer>();
	public static void Grammer() throws NullPointerException{
		length.add(3);
		length.add(1);
		length.add(3);
		length.add(1);
		length.add(3);
		length.add(1);
		
		rules[0]="E->E+T";
		rules[1]="E->T";
		rules[2]="T->T*F";
		rules[3]="T->F";
		rules[4]="F->(E)";
		rules[5]="F->id";
	
	}
}
