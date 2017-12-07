package file.fileMovement;

import java.io.*;

//This program moves a diff type of file by checking filename, to another folder.
public class FileMovementTask
{

	public static String sDir="D:\\Google Drive\\HCL Technologies\\Payslips\\2016";		//Src directory. (infact, the only directory you are dealing with, as it creates another directory in same path) 
	public static String dDir=sDir+"\\2016_";											//The name of sub-dir you want to create.
	
	//This method copies contains of one file into another 
	public static void copyFile(File srcDir, File dDir)
	{
		try
		{
			FileInputStream fr = new FileInputStream(srcDir);
			FileOutputStream fw = new FileOutputStream(dDir);
			
			BufferedInputStream br = new BufferedInputStream(fr);
			BufferedOutputStream bw = new BufferedOutputStream(fw);
			
			int data=0;
			
			while((data=br.read())!=-1)
			{
				bw.write(data);
			}
			
			br.close();
			bw.close();
			fr.close();
			fw.close();
		}
		catch(Exception e)
		{
			
			e.printStackTrace();
		}
	}
	
	
	public static void main(String[] args)
	{
		
		File dir = new File(sDir);
		File newDir=new File(dDir);
		File[] fileList=dir.listFiles();
		
		newDir.mkdir();				//Makes a new directory there itself.
		
		for(File f: fileList)
		{
			String s=f.toString();
			
			
			//LOGIC: How to detect the filenames to move.
			if(s.endsWith("_.pdf"))
			{
				copyFile(f, new File(newDir+"\\"+f.getName()));
				System.out.println(f);
				f.delete();
			}
			//
			
			
		}
	}

}
