import java.util.*;
import java.sql.*;
import java.io.*;
import org.apache.poi.ss.usermodel.Cell;  
import org.apache.poi.ss.usermodel.Row;  
import org.apache.poi.xssf.usermodel.XSSFSheet;  
import org.apache.poi.xssf.usermodel.XSSFWorkbook;  
public class MainClass
{
	private static List<DataObject> list;
	public static void main(String gg[])
	{
		list=getList("details.xlsx");
		Connection connection=null;
		try
		{
			//below two lines are used for connectivity.
			Class.forName("com.mysql.cj.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/hrdb","hr","hr");
			PreparedStatement preparedStatement;
			for(int i=0;i<list.size();i++)
			{
				preparedStatement=connection.prepareStatement("insert into studentdetails (rollNumber,candidateName,collegeName,physicsMarks,chemistryMarks,biologyMarks,mathsMarks,englishMarks,computerMarks) values (?,?,?,?,?,?,?,?,?)",Statement.RETURN_GENERATED_KEYS);
				preparedStatement.setDouble(1,list.get(i).getRollNumber());
				preparedStatement.setString(2,list.get(i).getCandidateName());
				preparedStatement.setString(3,list.get(i).getCollegeName());
				preparedStatement.setDouble(4,list.get(i).getPhysicsMarks());
				preparedStatement.setDouble(5,list.get(i).getChemistryMarks());
				preparedStatement.setDouble(6,list.get(i).getBiologyMarks());
				preparedStatement.setDouble(7,list.get(i).getMathsMarks());
				preparedStatement.setDouble(8,list.get(i).getEnglishMarks());
				preparedStatement.setDouble(9,list.get(i).getComputerMarks());
				preparedStatement.executeUpdate();
				preparedStatement.close();
			}
			connection.close();  
			System.out.println("All the data is now added in database");
	
	InputStreamReader isr;
	isr=new InputStreamReader(System.in);
	BufferedReader br;
	br=new BufferedReader(isr);
	
	while(true)
	{
		String s;
		System.out.println("*****Menu******");
		System.out.println("1. Get Toppers list");
		System.out.println("2. Get report of student");
		System.out.println("3. Exit");
		System.out.print("Enter your choice :-> ");
		s=br.readLine();
		if(s.equals("1")) printToppersList();
		else if(s.equals("2")) 
		{
			String in;
			int num;
			System.out.print("Enter roll number :-> ");
			
			try{
			in=br.readLine();
			num=Integer.parseInt(in);
			generateReportCardByRollNumber(num);	
			}catch(Exception e)
			{
				System.out.println("Invalid roll number");
			}
			
		}
		else if(s.equals("3")) break;
		else System.out.println("Invalid Input select again");		
	}
	}catch(Exception exception){
		System.out.println(exception);
	}
	
	}
	
	
	public static List<DataObject> getList(String fileName)   
	{  
	List<DataObject> lis=new ArrayList<DataObject>();
	try  
	{  
		File file = new File(fileName);   //creating a new file instance  
		FileInputStream fis = new FileInputStream(file);   //obtaining bytes from the file  
		DataObject dataObject;
		//creating Workbook instance that refers to .xlsx file  
		XSSFWorkbook wb = new XSSFWorkbook(fis);   
		XSSFSheet sheet = wb.getSheetAt(0);     //creating a Sheet object to retrieve object  
		Iterator<Row> itr = sheet.iterator();    //iterating over excel file  
		itr.next();  
		while (itr.hasNext())                 
		{  
			Row row = itr.next();  
			dataObject=new DataObject();
			Iterator<Cell> cellIterator = row.cellIterator();   //iterating over each column  
			Cell cell = cellIterator.next();  

			dataObject.setRollNumber(cell.getNumericCellValue());
			cell = cellIterator.next();
			dataObject.setCandidateName(cell.getStringCellValue());
			cell = cellIterator.next();
			dataObject.setCollegeName(cell.getStringCellValue());
			cell = cellIterator.next();
			dataObject.setPhysicsMarks(cell.getNumericCellValue());
			cell = cellIterator.next();
			dataObject.setChemistryMarks(cell.getNumericCellValue());
			cell = cellIterator.next();
			dataObject.setBiologyMarks(cell.getNumericCellValue());
			cell = cellIterator.next();
			dataObject.setMathsMarks(cell.getNumericCellValue());
			cell = cellIterator.next();
			dataObject.setEnglishMarks(cell.getNumericCellValue());
			cell = cellIterator.next();
			dataObject.setComputerMarks(cell.getNumericCellValue());

			lis.add(dataObject);
		}  
	}  
	catch(Exception e)  
	{  
		e.printStackTrace();  
	}
	return lis;  
	}  //function ends
	
	
	private static void printToppersList()
	{
		Collections.sort(list, new Comparator<DataObject>() {
        public int compare(DataObject d1,DataObject d2) {
            return (int)d2.getTotal() - (int)d1.getTotal();
        }
	});	
	System.out.println();
	System.out.println();
	System.out.println("********Merit list*********");	
	for(int i=0;i<list.size();i++)
	{
		System.out.print("Name "+list.get(i).getCandidateName());
		System.out.println("   Total Marks "+list.get(i).getTotal());
	}
	System.out.println();
	System.out.println();
	}
	
	private static void generateReportCardByRollNumber(int num)
	{
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).getRollNumber()==num) 
			{
				System.out.println();
				System.out.println();
				System.out.println("#####Report Of "+list.get(i).getCandidateName()+"#####");
				System.out.println("Roll Number   :   "+list.get(i).getRollNumber());
				System.out.println("Physics Marks   :   "+list.get(i).getPhysicsMarks());
				System.out.println("Maths Marks   :   "+list.get(i).getMathsMarks());
				System.out.println("Chemistry Marks   :   "+list.get(i).getChemistryMarks());
				System.out.println("English Marks   :   "+list.get(i).getEnglishMarks());
				System.out.println("Computer Marks   :   "+list.get(i).getComputerMarks());
				System.out.println("Biology Marks  :   "+list.get(i).getBiologyMarks());
				System.out.println("Total Marks  :   "+list.get(i).getTotal());
				System.out.println();System.out.println();
			}
		}
		System.out.println("Invalid RollNumber");
	}
	
}