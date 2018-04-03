public class SoftwareEngineer extends TechnicalEmployee{
    public boolean CodeAccess;

    public SoftwareEngineer(String name){
        super(name);
        setCodeAccess(true);
    }

    public boolean getCodeAccess(){
        return CodeAccess;//Should return whether or not this SoftwareEngineer has access to make changes to the code base
    }

    public void setCodeAccess(boolean access){
        //Should allow an external piece of code to update
        // the SoftwareEngineer's code privileges to either true or false
        this.CodeAccess=access;
    }

    public int getSuccessfulCheckIns(){
        //Should return the current count of how many times this SoftwareEngineer
        // has successfully checked in code
        return checkins;
    }

    public boolean checkInCode(){
        //Should check if this SoftwareEngineer's manager approves of their check in.
        // If the check in is approved their successful checkin count should be increased and the method should return "true".
        // If the manager does not approve the check in the SoftwareEngineer's code access should be changed to false and
        // the method should return "false"
        TechnicalLead manager=(TechnicalLead) this.getManager();
        if (manager.approveCheckIn(this)){
            this.checkins++;
            return true;
        } else {
            CodeAccess=false;
            return false;
        }
    }

    /*
    public void setManger(TechnicalEmployee manager){

        super.manager=manager;
    }
     */

}
