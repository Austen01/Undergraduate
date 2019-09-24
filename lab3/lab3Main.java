package lab3;
import java.io.*;

public class lab3Main {
	 // main method
    public static void main(String[] args){
        
    	
    	Employee emp1 = new Employee();
    	EmployeeSet empSet1 = new EmployeeSet();
    	emp1.employeeName = "Austen";
    	emp1.employeeNumber = 3;
    	empSet1.add(emp1);
    	System.out.println(empSet1.toString());
    	empSet1.addOrdered(emp1);
    	empSet1.remove(3);
        System.out.println(read(empSet1).size());
        
    	
   }//end main
    

   // read function to add employee objects from core_dataset.csv
    public static EmployeeSet read(EmployeeSet set) {
    	String line = "";
        String splitWith = ",";
        boolean firstLine = true;
        
        
        try {
            // FileReader reads the file.
            FileReader fileReader = new FileReader("/Users/austenhill/Desktop/core_dataset.csv");
            
            // Wrap the filereader in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // null line will signify the end of file
            while((line = bufferedReader.readLine()) != null) {
                
                //add the current line to data Array
                String[] data = line.split(splitWith);
                
                // extract specified values (get meta data from first line and values from subsequent)
                if(!firstLine) {
                	Employee emp = new Employee();
                    emp.employeeName  = data[0] + "," + data[1];
                    emp.employeeNumber = Integer.parseInt(data[2]);
                    emp.employeeAge = Integer.parseInt(data[6]);
                    emp.employeeState = data[3];
                    emp.employeeZip = Integer.parseInt(data[4]);
                    set.add(emp);
                }else {
                }//end if:else
                
                firstLine = false;
                
            }//end while
            
            // close the file
            bufferedReader.close();
            
            //file error exception handling
        }catch(FileNotFoundException ex) {
        	System.out.println("not found");
        }catch(IOException ex) {
            System.out.println("Error reading file '" + "core_dataset.csv" + "'");
        }//end catch
        
        
        return set;
    }//end read
}
