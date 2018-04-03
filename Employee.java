public abstract class Employee {
    private static int countID; //static , so ti can accumulate the number of  employees

    public String name;
    public int employeeID;
    public double baseSalary;
    public double bonus;

    public Employee manager;
    public Accountant accountantSupport;
    public int headcount=0;

    public double bonusBudget;


    public Employee(String name, double baseSalary){
        //Should construct a new employee object and take in two parameters,
        // one for the name of the user and one for their base salary.
        this.name=name;
        this.baseSalary=baseSalary;
        countID++;
        this.employeeID=countID;
    }

    public double getBaseSalary(){
        return this.baseSalary;//Should return the employee's current salary
    }

    public String getName(){
        return this.name;  //Should return the employee's current name
    }

    public int getEmployeeID(){
        //Should return the employee's ID.
        // The ID should be issued on behalf of the employee at the time they are constructed.
        // The first ever employee should have an ID of "1", the second "2" and so on
        return this.employeeID;
    }

    public Employee getManager(){
        return manager;//Should return a reference to the Employee object that represents this employee's manager
    }

    public Accountant getAccountantSupport() {
        return accountantSupport;
    }

    public void setManager(Employee manager){
        this.manager=manager;
    }

    public boolean equals(Employee other){
        //Should return true if the two employee IDs are the same, false otherwise
        return this.getEmployeeID()==other.getEmployeeID();
    }

    public String toString(){
        //Should return a String representation of the employee that is a combination of their id followed by their name.
        // Example: "1 Kasey"
        return getEmployeeID()+" "+getName();
    }

    public abstract String employeeStatus();

    public void getBonus(){

    }

}
