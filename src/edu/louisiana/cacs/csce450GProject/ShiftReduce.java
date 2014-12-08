package edu.louisiana.cacs.csce450GProject;
import java.util.*;
import java.io.*;

import edu.louisiana.cacs.csce450GProject.*;
class ShiftReduce{
	public static String LHS,RHS,gotostate,gotovalue;
	public static int RHSLength;
	
	public void Shift(String s1, int s2)
	{
		//Parser ParseObj=new Parser();
		Parser.parseStack.push(s1);
		Parser.parseStack.push(Integer.toString(s2));
		String x= SebastaScanner.tokens.remove(0);
		//System.out.println(x+" " +SebastaScanner.tokens.size());
	}
	public void Reduce(int s3)
	{
		Language.Grammer();
		String TargetRule=Language.rules[s3-1];
		//System.out.println(TargetRule);
		String delims="->";
		String[] ruleSplitted=new String[10];
		ruleSplitted=TargetRule.split(delims);
		 LHS=ruleSplitted[0];
		 RHS=ruleSplitted[1];
		RHSLength=Language.length.get(s3-1);
		for(int j=2*RHSLength; j>0;j--)
		{
			Parser.parseStack.pop();
			
		}
		
		gotoTable.gotoTableMethod();
		gotostate = Parser.parseStack.peek();
		//System.out.println(gotostate);
		Map<String,Object> getgoto = gotoTable.gotoActions.get(Integer.parseInt(gotostate));
	 gotovalue = (String) getgoto.get(LHS);
		Parser.parseStack.push(LHS);
		Parser.parseStack.push(gotovalue);
	
	}
	
}