import java.io.*;


public class EmployeeFileOp {
    
    //main function
    public static void main(String[] args) {
        //filePath is old csv to read from and fileName is new csv to write to
        String filePath = "core_dataset.csv";
        String fileName = "young_employee.csv";
        
        //call read function and pass old file name
        read(filePath);
        
        //call write function and pass old file and new file name
        write(filePath, fileName); //write to a new file and pass the original file path
    }
    
    
    
    // method to read the csv file
    public static void read(String filePath){
        String line = "";
        String splitWith = ",";
        boolean firstLine = true;
        
        try {
            // FileReader reads the file.
            FileReader fileReader = new FileReader(filePath);
            
            // Wrap the filereader in a bufferedreader
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // null line will signify the end of file
            while((line = bufferedReader.readLine()) != null) {
                
                //add the current line to data Array
                String[] data = line.split(splitWith);
                
                // extract specified values (get meta data from first line and values from subsequent)
                if(!firstLine) {
                    String empName = data[0] + "," + data[1];
                    String empNum = data[2];
                    String state = data[3];
                    String zip = data[4];
                    String age = data[6];
                    String sex = data[7];
                    System.out.println(empName + ", " + empNum + ", " + state + ", " + zip + ", " + age + ", " + sex);
                }else {
                    String empName = data[0];
                    String empNum = data[1];
                    String state = data[2];
                    String zip = data[3];
                    String age = data[5];
                    String sex = data[6];
                    System.out.println(empName + ", " + empNum + ", " + state + ", " + zip + ", " + age + ", " + sex);
                }//end if:else
                
                firstLine = false;
                
            }//end while
            
            // close the file
            bufferedReader.close();
            
            //file error exception handling
        }catch(FileNotFoundException ex) {
            System.out.println("Could not find file '" +  filePath + "'");
        }catch(IOException ex) {
            System.out.println("Error reading file '" + filePath + "'");
        }//end catch
        
        //print successful if no errors
        System.out.println("Success reading file "+ filePath + "\n\n");
        
    }//end of read function
    
    
    
    
    // function to write employees under 30 to young_employees.csv
    public static void write(String filePath, String fileName){
        String line = "";
        String splitWith = ",";
        boolean firstLine = true;
        
        try {
            // make a new file with name specified in main
            File file = new File(fileName);
            
            // initialize file writer and wrap it in a buffer
            FileWriter fileWriter = new FileWriter(file.getAbsoluteFile());
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            
            // initialize file reader and wrap it in a buffer
            FileReader fileReader = new FileReader(filePath);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            
            // null line will signify the end of file
            while((line = bufferedReader.readLine()) != null) {
                
                //add the current line to data Array
                String[] data = line.split(splitWith);
                
                // get specified values and write them to new file if employee age is 30 or under
                if(!firstLine) {
                    if(Integer.parseInt(data[6]) <= 30) {
                        String empName = data[0] + "," + data[1];
                        String empNum = data[2];
                        String state = data[3];
                        String zip = data[4];
                        String age = data[6];
                        String sex = data[7];
                        
                        bufferedWriter.append(empName + ", " + empNum + ", " + state + ", " + zip + ", " + age + ", " + sex + "\n");
                    }
                }else {
                    String empName = data[0];
                    String empNum = data[1];
                    String state = data[2];
                    String zip = data[3];
                    String age = data[5];
                    String sex = data[6];
                    bufferedWriter.append(empName + ", " + empNum + ", " + state + ", " + zip + ", " + age + ", " + sex + "\n");
                }//end if:else
                
                firstLine = false;
                
            }//end while
            
            // close all io instances
            bufferedWriter.close();
            fileWriter.close();
            bufferedReader.close();
            
            //file error exception handling
        }catch(FileNotFoundException ex) {
            System.out.println("Could not find file '" +  filePath + "'");
        }catch(IOException ex) {
            System.out.println("Error reading file '" + filePath + "'");
        }
        
        //print successful if no errors
        System.out.println("Success reading file "+ filePath);
        
        
        System.out.println("Finish writing pairs to file "+ fileName);
    }//end of write function
    
    
    
}//end of class

