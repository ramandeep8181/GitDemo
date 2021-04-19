import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class dataDriventest1 {
	// diff from dataDriventest class code is that we have made this class as a method.
	
	// after we made this class, at last we will make it a method and call it from other class by
	// calling method name we will give here.

	public ArrayList<String> getData(String TestCasename) throws IOException
	{
		
		ArrayList<String> a = new ArrayList<String>();
		// to make the object fis know the path to the excell
				FileInputStream fis = new FileInputStream("C:\\Users\\rammi\\OneDrive\\Documents\\DemoData.xlsx");
			// pass the fis argument, workbook will take control of excell
				XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			// total number of sheets
				Integer sheets = workbook.getNumberOfSheets();
				
				for(int i=0; i<sheets; i++)
				{
					if(workbook.getSheetName(i).equalsIgnoreCase("table1"))
					{
				// to know the index of sheet i.e table1
					XSSFSheet sheet = workbook.getSheetAt(i);
				// once reach the sheet, start its iteration
					Iterator<Row> rows = sheet.iterator();
				// our aim is to get into first row
					Row firstrow = rows.next();
				///now start its iteration to reach Testcases coloumn
					Iterator<Cell> ce = firstrow.cellIterator();
					
					int k=0;
					int coloumn =0;
					while (ce.hasNext())
					{
						Cell value = ce.next();
						if(value.getStringCellValue().equalsIgnoreCase("TestCases"))
						{
							coloumn=k;
						}
						k++;
					}
					System.out.println(coloumn);
				// again iterate the sheet to reach row Purchase , as we already declared "rows", so no need to mention again	
					while(rows.hasNext())
					{
						Row r = rows.next();
						if(r.getCell(coloumn).getStringCellValue().equalsIgnoreCase(TestCasename))
						{
				// after reaching the Purchase testcase, start its iteration to get each cell value
							Iterator<Cell> cv =r.cellIterator();
							while(cv.hasNext())
							{
								Cell c= cv.next();
								if(c.getCellType()==CellType.STRING)
								{
									a.add(c.getStringCellValue());
								}
								else
								{
									a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
								}
							}
						}
					}
					
					
					
					}
				}
	
				
				
				
				
				return a;
			}
		

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
	}

}
