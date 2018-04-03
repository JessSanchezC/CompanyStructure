import java.util.ArrayList;

public class TechnicalLead extends TechnicalEmployee {
    public ArrayList<SoftwareEngineer> team;


    public TechnicalLead(String name){
        //Should create a new TechnicalLead that is a Manager.
        // The TechnicalLead's base salary should be 1.3 times that of a TechnicalEmployee.
        // TechnicalLeads should have a default head count of 4.
        super(name);
        this.baseSalary*=1.3;
        headcount=4;
        this.team=new ArrayList<SoftwareEngineer>();
    }

    public boolean hasHeadCount(){
        //Should return true if the number of direct reports this manager has is less than their headcount.
        if(team.size()<headcount){
            return true;
        } else {
            return false;
        }
    }

    public boolean addReport(SoftwareEngineer e){
        //Should accept the reference to a SoftwareEngineer object,

        if(hasHeadCount()){
            team.add(e); // and if the TechnicalLead has head count left should add this employee to their list of direct reports.
            e.setManager(this);//set the Technical Lead as manager of the Software Engineer.
            return true;// If the employee is successfully added to the TechnicalLead's direct reports true should be returned,
        } else {
            return false; // false should be returned otherwise
        }
    }

    public boolean approveCheckIn(SoftwareEngineer e){

        if(e.getManager().equals(this) && e.getCodeAccess()){//Should see if the employee passed in does report to this manager and if their code access is currently set to "true".
            return true;// If both those things are true, true is returned, otherwise false is returned
        } else {
            return false;
        }
    }


    public boolean requestBonus(Employee e, double bonus){

        //Should check if the bonus amount requested would be approved by the BusinessLead supporting this TechnicalLead.
        // If it is, that employee should get that bonus and true should be returned. False should be returned otherwise

        //Crear un field para saber que accountant da soporte a este manager, y poder dirigir el request
        BusinessLead businessLead= (BusinessLead)getAccountantSupport().getManager();
        if (businessLead.approveBonus(e, bonus)){
            return true;
        } else {
            return false;
        }
    }


    public String getTeamStatus(){
        //Should return a String that gives insight into this Manager and all their direct reports.
        // It should return a string that is a combination of the TechnicalLead's employee status followed by each of their direct employee's status on subsequent lines.
        // If the TechnicalLead has no reports it should print their employee status followed by the text " and no direct reports yet ".
        // Example: "10 Kasey has 5 successful check ins and no direct reports yet".
        // If the TechnicalLead does have reports it might look something like "10 Kasey has 5 successful check ins and is managing: /n 5 Niky has 2 successful check ins"

        if (team.size()==0){
            return this.employeeStatus()+ " and no direct reports yet";
        } else {
            String teamStatus="";
            for (int i=0;i<team.size();i++){
                teamStatus+=("    "+team.get(i).employeeStatus()+"\n");
            }
            return this.employeeStatus()+" and is managing: \n"+teamStatus;
        }

    }


}
