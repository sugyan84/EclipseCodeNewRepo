package excelOperations;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import JSONOperations.SingleJSONObject;
import JSONOperations.SinglePathDB;
import JSONOperations.State;

public class WriteExcel
{
	static  XSSFWorkbook workbook = new XSSFWorkbook();
    static  XSSFSheet sheet = workbook.createSheet("Java Books");
    static Row row = null;
    static Cell cell = null;
    
    static int highestRow= 0;
    static int highestCol = 0;
       
    
    public static void main(String[] args) throws FileNotFoundException, IOException
	{
    	//writeObejctToExcel();
    	
    	/*for(int i=1;i<10;i++)
    	{
    		row= sheet.createRow(i-1);
    		
    		for(int r=1;r<5;r++)
    		{
    			cell= row.createCell(r-1);
            	cell.setCellValue(i+" N "+r);
    		}
        	
    	}
    	
    	 try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx")) 
    	 {
             workbook.write(outputStream);
         }*/
    	
	}
    
    
    public static void putInNewRow(int r, int c, String val)
    {
    	row= sheet.createRow(r-1);
    	cell= row.createCell(c-1);
    	cell.setCellValue((String)val);
    	
    	if(r>highestRow)
    		highestRow=r;
    	if(c>highestCol)
    		highestCol=c;
    }
    
    public static void putInNewCol(int c, String val)
    {
    	//row= sheet.createRow(r-1);
    	cell= row.createCell(c-1);
    	cell.setCellValue((String)val);
    	
    	if(c>highestCol)
    		highestCol=c;
    }
    
    
   
     public static void writeObejctToExcel(SingleJSONObject p) throws FileNotFoundException, IOException
     {
    	int locR=1;
    	int locC = 1;
    	
    	putInNewRow(locR, locC, p.getRuleSetName());
    	putInNewCol(++locC, p.getRuleSetSubmitNum());				//2
    	
    	Iterator ipathDB= p.pathDB.iterator();
    	
    	while(ipathDB.hasNext())
    	{
    		SinglePathDB onePathDBObj = (SinglePathDB) ipathDB.next();
    		
    		putInNewCol(++locC, onePathDBObj.getPathRuleID());//3
    		putInNewCol(++locC, onePathDBObj.getPathRuleType());//4
    		//sampleUtt
    		putInNewCol(++locC, onePathDBObj.getIntent());//5
    		putInNewCol(++locC, onePathDBObj.getDescription());//6
    		putInNewCol(++locC, String.valueOf(onePathDBObj.getSeqNum()));//7
    		putInNewCol(++locC, onePathDBObj.getPathRuleID());//8
    		
    		Iterator iState= onePathDBObj.s.iterator();
    		
    		//System.out.println(onePathDBObj.s.size());
    		
    		int locStateStartCol=0;
    		int locStateStartRow =0;
    		
    		locStateStartCol=locC;
    		locStateStartRow=locR;
    		
    		while(iState.hasNext())
    		{
    			State oneState = (State) iState.next();
    			
    			//System.out.println(oneState+"\n\n");
    			
    			if(oneState!=null)
    			{
    				locC= locStateStartCol;
    				
    				putInNewCol(++locC, oneState.getStateID());
    				//System.out.println(oneState.getStateID()+" in "+locC);
        			putInNewCol(++locC, oneState.getStateDesc());
        			putInNewCol(++locC, oneState.getSubIntent());
        			putInNewCol(++locC, String.valueOf(oneState.isNesting()));
        			putInNewCol(++locC, String.valueOf(oneState.isScreenlessState()));
        			putInNewCol(++locC, String.valueOf(oneState.isLandingState()));
        			
        			locR=locR+1;
        			highestRow=locR;
        			highestCol=locC;
    			}
    			
    			
    			
    		}
    		
    		locR=locR+1;
			highestRow=locR;
			locC=3;
			
    	}
    	
    	
    	 
    	 
    	 try (FileOutputStream outputStream = new FileOutputStream("JavaBooks.xlsx")) 
    	 {
             workbook.write(outputStream);
         }
     }
     
     
}

