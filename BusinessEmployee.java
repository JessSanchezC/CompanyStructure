public class BusinessEmployee extends Employee {


    public BusinessEmployee(String name){
        //Has a default salary of 50000
        super(name,50000.00);
    }

    public double getBonusBudget(){
        //Should establish a running tally of the remaining bonusBudget for the team this employee supports.
        // How that budget is determined will depend on which type of Business Employee it is
        return bonusBudget;
        }

    public void setBonusBudget(double bonusBudget) {
        this.bonusBudget = bonusBudget;
    }

    public String employeeStatus(){
        //Should return a String representation of this BusinessEmployee that includes
        // their ID, name and the size of their currently managed budget.
        // Example: "1 Kasey with a budget of 22500.0"
        String s= String.format("%.2f",bonusBudget);//reduce the double to 2 decimals
        return this.toString()+" with a budget of "+ s;
    }
}
