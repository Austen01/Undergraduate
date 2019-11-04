package lab3;
import lab3.*;

public class EmployeeSet {
    //EmployeeSet variables
    int empCount; // number of employees in the empArr array
    int capacity = 10; // initial capacity
    Employee empArr[]; // array to hold employee objects
;
    // no-argument constructor
    public EmployeeSet(){
        empCount = 0;
        capacity = 10;
        empArr = new Employee[capacity];
    }//end constructor

    // copy constructor
    public EmployeeSet(Object obj){
        // check that the object is not null and is an instance of Employee
        if((obj != null) && (obj instanceof EmployeeSet)){
            EmployeeSet empSet = (EmployeeSet) obj; // type cast
            Employee tmp[] = new Employee[empSet.capacity];
            this.empCount = empSet.empCount;
            this.capacity = empSet.capacity;
            for(int i=0; i < empSet.empCount; i++){
                tmp[i] = empSet.empArr[i];
            }//end for
            this.empArr = tmp;
        }//end if
    }//end constructor

    // function to return the number of used elements in the collection
    public int size(){
        return this.empCount;
    }//end size

    public int capacity(){
        return this.capacity;
    }//end capacity

    // check to make sure the array can hold another item and add the employee object
    public void add(Employee a){
        if(a != null){
            ensureCapacity(this.empCount);
            //make sure the employee does not already exist
            if(!this.contains(a)){
                this.empArr[this.empCount] = a;
                this.empCount++;
            }else{
                System.out.println("This employee already exists");
            }
        }//end if! null
    }// end add

    //check to see if the empArr contains a certain employee
    public boolean contains(Employee a){
        if(a == null){
            return false;
        }else if(a instanceof Employee){
            for(int i = 0; i < this.empCount; i++){
                if(a.employeeNumber == this.empArr[i].employeeNumber){
                    return true;
                }//end if
            }//end for
            
        }//end if/else
        return false;
    }//end contains

    //remove an employee from the collection
    public boolean remove(int empNo){
        for(int i = 0; i < this.empCount; i++){
            if(this.empArr[i].getEmployeeNumber() == empNo){
                this.empCount--;
                return true;
            }//end if
        }//end for
        return false;
    }//end remove


    // make sure that the array capacity is larger than the current employee count
    public void ensureCapacity(int minimumCapacity){
        if((minimumCapacity > 0) && (this.empCount >= this.capacity-1)){
            this.capacity *= 2;
            Employee tmp[] = new Employee[this.capacity];
            for(int i = 0; i < this.empCount; i++){
                tmp[i] = this.empArr[i];
            }//end for
            this.empArr = tmp;
        }//end if
    }//end ensureCapacity

    //sort employee objects in ascending order by employee number
    public boolean sortSet(){
        int n = this.empArr.length; 
        for (int i = 0; i < n-1; i++){
            for (int j = 0; j < n-i-1; j++){
            	if((this.empArr[j] == null) || (this.empArr[j+1] == null)) {
            		return true;
            	}
	                if (this.empArr[j].employeeNumber > this.empArr[j+1].employeeNumber){ 
	                    // swap empArr[j+1] and empArr[i] 
	                    Employee temp = this.empArr[j]; 
	                    this.empArr[j] = this.empArr[j+1]; 
	                    this.empArr[j+1] = temp; 
                }//end if
            }//end for
        }//end for
        return true;
    }//end sortSet

    //add a new employee into correct slot so that the array is in ascending order of employee numbers
    public void addOrdered(Employee a){
        if(a != null){
            this.sortSet();
            this.add(a);
            this.sortSet();
        }//end if
    }//end addOrdered
}
