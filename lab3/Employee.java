package lab3;
import java.util.Arrays;
public class Employee {

    // class variables
    String employeeName, employeeState;
    int employeeNumber, employeeAge, employeeZip, advisorCount;
    int advisors[];

    // default constructor with no arguments
    public Employee(){
        employeeName  = null;
        employeeNumber = 0;
        employeeAge = 0;
        employeeState = null;
        employeeZip = 0;
        advisorCount = 0;
        advisors = new int[1];
    }//end constructor


    // copy constructor
    public Employee(Object obj){
        // check that the object is not null and is an instance of Employee
        if((obj != null) && (obj instanceof Employee)){
            Employee emp = (Employee) obj; // type cast
            this.employeeNumber = emp.employeeNumber;
            this.employeeAge = emp.employeeAge;
            this.employeeZip = emp.employeeZip;
            this.advisorCount = emp.advisorCount;
            this.employeeName = new String(emp.employeeName);
            this.employeeState = new String(emp.employeeState);
            this.advisorCount = emp.advisorCount;
            //clone the advisors array
            this.advisors = new int[emp.advisors.length];
            this.advisors = emp.advisors.clone();
        }//end if
    }//end constructor


    // set methods with the value to assign as parameters

    /**
     * @param employeeName the employeeName to set
     */
    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    /**
     * @param employeeNumber the employeeNumber to set
     */
    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * @param employeeAge the employeeAge to set
     */
    public void setEmployeeAge(int employeeAge) {
        this.employeeAge = employeeAge;
    }

    /**
     * @param employeeState the employeeState to set
     */
    public void setEmployeeState(String employeeState) {
        this.employeeState = employeeState;
    }

    /**
     * @param employeeZip the employeeZip to set
     */
    public void setEmployeeZip(int employeeZip) {
        this.employeeZip = employeeZip;
    }

    /**
     * @param advisors add to array of advisors. empNumber is the value for the advisor to add to the array
     */
    public void setAdvisors(int empNumber) {
        // make sure that there are no more than three advisors
        if(this.advisorCount >= 3){
            System.out.println("This employee already has three advisors");
        }//end if

        // if less than three advisors increase the array size if needed (collection bag) and add the new advisor to the array
        else{
            if(this.advisorCount >= this.advisors.length){
                int tmp[] = new int[this.advisorCount+1];
                for(int i=0; i < this.advisorCount; i++){
                    tmp[i] = this.advisors[i];
                }//end for

                this.advisors = tmp;
            }//end if

            this.advisors[this.advisorCount] = empNumber;
            advisorCount++;
            //print success if the advisor was added
            System.out.println("Added " + empNumber + " to " + this.employeeName + "'s advisors.");
        }//end else
    }//end set advisors



    //get methods return the value of each variable

    /**
     * @return the employeeName
     */
    public String getEmployeeName() {
        return employeeName;
    }

    /**
     * @return the employeeNumber
     */
    public int getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * @return the employeeAge
     */
    public int getEmployeeAge() {
        return employeeAge;
    }

    /**
     * @return the employeeState
     */
    public String getEmployeeState() {
        return employeeState;
    }

    /**
     * @return the employeeZip
     */
    public int getEmployeeZip() {
        return employeeZip;
    }

    /**
     * @return the advisors
     */
    public int[] getAdvisors() {
        return advisors;
    }

    //override toString method to make object into a string with specified order
    public String toString() {
        return "\nEmployee Name: " + getEmployeeName() + "\nEmployee Number: " + getEmployeeNumber() + 
               "\nEmployee Age: " + getEmployeeAge() + "\nEmployee State: " + getEmployeeState() +
               "\nEmployee Zip: " + getEmployeeZip() + "\nAdvisors: " + Arrays.toString(getAdvisors()) + "\n\n";
    }//end toString


    //compare employee numbers of two objects
    // obj parameter is a reference to the object that will be on the right side of the relational operator
    public boolean equals(Object obj) {
        // check that the object parameter is not null and is an instance of Employee
        if((obj != null) && (obj instanceof Employee)){
            Employee emp = (Employee) obj; // type cast
            //compare the number of calling object and parameter object and return true if matched and false if different
            if(this.employeeNumber == emp.employeeNumber){
                return true;
            }//end if ==
        }//end if instanceof
        return false;
    }//end equals


    // make a new array with all advisors defined during runtime for two Employee objects
    // both parameters are references to the objects to use
    public static int[] getAllAdvisors(Employee e1, Employee e2){
        int distinctAdvisors[] = null;
        // if both not null then store each advisor number into new array named distinctAdvisors
        if((e1 != null) && (e2 != null)){
            int newCount = e1.advisorCount + e2.advisorCount; // sum of e1 and e2 advisor array elements
            distinctAdvisors = new int[newCount]; // new array of distinct advisors the size of the sum of e1 and e2 advisor arrays 
            int index = 0; // index is the index of distinctAdvisors array

            // add each element in e1 array and then e2 array to distinctAdvisors
            for(int i = 0; i < e1.advisorCount; i++){
                distinctAdvisors[i] = e1.advisors[i];
                index++;
            }//end for
            for(int i = 0; i < e2.advisorCount; i++){
                distinctAdvisors[index] = e2.advisors[i];
                index++;
            }//end for

        }//end if !null
        return distinctAdvisors; // return the new array
    }//end getAllAdvisors
}
