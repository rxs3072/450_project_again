package edu.louisiana.cacs.csce450GProject;
import edu.louisiana.cacs.csce450GProject.*;
import java.io.*;
import java.util.*;

public class Parser{
	/*
	* YOUR CODE GOES HERE
	* 
	* You must implement two methods
	* 1. parse
	* 2. printParseTree
     
    * Print the intermediate states of the parsing process,
    * including the intermediate states of the parse tree,make
    * as specified in the class handout.
    * If the input is legal according to the grammar,
    * print ACCEPT, else UNGRAMMATICAL.
    * If the parse is successful, print the final parse tree.

	* You can modify the input and output of these function but not the name
	*
	*/
	public static Stack<String> parseStack=new Stack<String>();
	public static Stack<Stack> tempstack=new Stack<Stack>();
	public static String actionvalue=new String();
	public static String inputfile;
	public Parser(String fileName) {
		
	System.out.println("file to parse"+fileName);		
	inputfile=fileName;	
	}
	
	/*
	* Dummy code
	*/
	
	public static void printParseTree() throws IOException{
		
				
}
	

	/*
	* Dummy code
	*/
	public static void parse() throws IOException{
		//tempstack.push("0");
		//parseStack.push("0");
		SebastaScanner scan=new SebastaScanner();
		action actionObj=new action();
		ShiftReduce shiftreduceObj=new ShiftReduce();
		scan.scanner(inputfile);
		List<String> tokensInFile=SebastaScanner.tokens;
		
		Iterator<Map<String,Object>> ListIterator = actionObj.stateActions.iterator();
		actionObj.actiontable();
		parseStack.push("0");
		String format = "%-40s%-30s%-20s%-15s%-15s%-15s%-15s%-10s%-10s%n";
		System.out.printf(format,"Stack","input tokens","action lookup","actionvalue","valueofLHS","lengthOfRHS","gotoLookup","gotoValue","stackAction");
		
		do
		{	
			String element= tokensInFile.get(0);
			//System.out.println(element);
			String obj= parseStack.peek();
			//System.out.println(parseStack);
			Map<String,Object> getstate = actionObj.stateActions.get(Integer.parseInt(obj));
			actionvalue = (String) getstate.get(element);
			
			if(actionvalue.length()==2)
				{
				String state1=actionvalue.substring(1);
				String action1=actionvalue.substring(0, 1);
				List<String> actionLookup=new ArrayList<String>();
				actionLookup.add(state1);
				actionLookup.add(action1);
				System.out.printf(format,parseStack,tokensInFile,"["+obj+","+element+"]",actionvalue," "," "," "," ","push"+" "+element+state1);
				
				if(action1.equals("S"))
				{
				//System.out.println("Shift");
				shiftreduceObj.Shift(element,Integer.parseInt(state1));
				
				}
				else if(action1.equals("R"))
				{
					
					shiftreduceObj.Reduce(Integer.parseInt(state1));
					System.out.printf(format,parseStack,tokensInFile,"["+obj+","+element+"]",actionvalue,shiftreduceObj.LHS,shiftreduceObj.RHSLength,"["+shiftreduceObj.gotostate+","+shiftreduceObj.LHS+"]",shiftreduceObj.gotovalue,"push"+" "+shiftreduceObj.LHS+shiftreduceObj.gotovalue);
					
				}
				
				}
				
			if(actionvalue=="accept")
				{
					System.out.println("ACCEPT");
				}
			else
			{
				actionvalue="UNGRAMMATICAL";
				System.out.println("UNGRAMMATICAL");
			}
				
	}	while(actionvalue!="accept" ||actionvalue!="UNGRAMMATICAL" );
				
				
        printParseTree();
	}

}