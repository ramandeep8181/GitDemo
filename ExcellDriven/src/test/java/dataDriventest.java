import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriventest {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub

// This code is to get data from the excell sheet and it is step one to reach excell and then sheet number

//1 XSSFWorkbook is a class of POI API and we will create object of this class i.e workboook here to take
// control over the excell.
//2. To give the workbook object knowledge that where is the excell located we will pass argument of the
// type FileInputStream. This FileInputStream has a path to the excell and note that the path must contains .xlsx
// Also, note that FileInputStream is a class of java and its object here 'fis' has access to location of excell file

//3. now as we have reached the excell , so now we will reach sheet number
// so we will count the number of sheets and iterate thru them until we found the required sheet,
// after we get the required sheet we will get its index number and the return type is XSSFSheet.
		
// in while loop we have intialised two int's , k will increase every time while loop will be exe and
// the current value of the k is stored into coloumn variable.
		
		FileInputStream fis = new FileInputStream("C://Users//rammi//OneDrive//Documents//DemoData.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis); 
		
		int sheets = workbook.getNumberOfSheets();
		for(int i=0; i<sheets; i++)
		{
			// if the sheet name matches then go inside the if loop.
			if (workbook.getSheetName(i).equalsIgnoreCase("table1"))
			{
			// below step is to access sheet in excell
		//(imp) at this level we have access to sheet, now after this step we will proceed to get row access
				XSSFSheet sheet = workbook.getSheetAt(i);
		//below step is to take access to the rows of specific sheet(also helpful to find no. of rows)
				Iterator<Row> rows = sheet.iterator(); 		// sheet is collection of rows
		// to access the first row (notice we entered the first row)
				Row firstrow = rows.next();
		// to iterate through entire row to find coloumn "TestCases"
				Iterator<Cell> ce = firstrow.cellIterator(); // row is collection of cells  
				int k=0;
				int coloumn =0;
				while (ce.hasNext())
				{
					Cell value = ce.next();
					if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
					{
						// we have reached desired coloumn
						coloumn=k;
					}
					k++;
				}
				System.out.println(coloumn);
				
		//(imp) once coloumn is identified then scan the entire coloumn to identify purchase row
	    // first step is to scan rows, but we already did, so no need to do again.
				while(rows.hasNext())
				{
					Row r= rows.next();
		//below step, get the cell for only index number 'coloumn', then grab its value and compare it with "purchase"
					if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase("Purchase"))
					{
		//(imp) after we grab the testcase "purchase", we want to pull the data of all the cells
						Iterator<Cell> cv= r.cellIterator();
						while(cv.hasNext())
						{
							System.out.println(cv.next().getStringCellValue());
						}
					}
				}
				
				
				
				
				
			}
			
		}
		
		
		
		
		
	}

}

