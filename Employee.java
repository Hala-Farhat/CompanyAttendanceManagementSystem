package finalprojact;
import static finalprojact.Admin.managers;
import static finalprojact.HolidayRequest.holidayRequests;
import static finalprojact.Manager.employees;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Employee extends Users{
    private String typeOfEmployee;
    Scanner s = new Scanner(System.in);
    public Employee( String id, String name, String password, String email, String phoneNumber,String typeOfEmployee, int status, String checkIn, String checkOut) {
        super(id, name, password, email, phoneNumber, status, checkIn, checkOut);
        this.typeOfEmployee = typeOfEmployee;
    }

   
    Employee() {
    }
       public void LoginAsEmployee1() {
       LoginScreen u = new  LoginScreen();
       Manager m= new Manager();
        int choice = 0;
        do {
                    System.out.println(">>>>> Employee <<<<<\n"
                            + "1- change password.\n"
                            + "2- Attendance.\n"
                            + "3- Holiday\n"
                            + "4- Exit."
                    );
                    choice = s.nextInt();
                    switch (choice) {
                        case 1:
                           ChangePassword();
                            break;
                        case 2:
                            Attendance();
                            break;
                        case 3:
                            Holiday();
                            break;
                        case 4:      
                     u.loginscreen();
                            break;
                        default:
                            System.out.println("Enter valid number please!");
                    }

                } while (choice != 4);}
       
      String idem;
    public void LoginAsEmployee() {
        String passWord;
            System.out.println("<<<<< Login As Employee  >>>>>>");
            System.out.println("Enter your id: ");
            idem = s.next();
            System.out.println("Enter your password");
             passWord = s.next();
            for(Employee em:employees ){
            if (em.getId().equals(idem)&&em.getStatus()==1&&em.getPassword().equals(passWord)) {
                LoginAsEmployee1();
                return;
            }}       

            System.out.println("check your id and password or  your accont not Activate");
              LoginAsEmployee() ;
    }
     
        public void ChangePassword() {
        String NewPassword ;
         System.out.println(">>>>> Change Password <<<<<");
         System.out.println(" New password: ");
        NewPassword =s.next();
        for(Employee em:employees){
            if(em.getId().equals(idem)){
         em.setPassword(NewPassword);
                System.out.println("Change Password done:)");
            }
        }
    }

    public void Attendance() {
        int choice;
        do {
            System.out.println(">>>>> Attendance <<<<<");
            System.out.println("1- Time of attendance.\n"
                    + "2- Time to leave\n"
                    + "3- Exit\n"
            );
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    timeOfAttendance();
                    break;
                case 2:
                    timeToLeave();
                    break;
                case 3:
                   LoginAsEmployee1();
                    break;
                default:
                    System.out.println("Enter a valid number please!");
            }
        } while (choice != 3);
    }

    public void timeOfAttendance() {
        System.out.println(">>>>> Time of Attendance <<<<<");
        System.out.println("Enter the company's time of attendance: ");
        String timeOfAttendance = s.next();
      for(Employee em:employees){
            if(em.getId().equals(this.idem)){
        em.setCheckIn(timeOfAttendance);       
    }}}

    public void timeToLeave() {
        System.out.println(">>>>> Time of Leave <<<<<");
        System.out.println("Enter the company's time of leave: ");
        String timeOfLeave = s.next();
           for(Employee em:employees){
            if(em.getId().equals(this.idem)){
           em.setCheckOut(timeOfLeave);       
    }}}

    public void Holiday() {
        int choice;
        HolidayRequest h =new HolidayRequest();
        do {
            System.out.println(">>>>> Holiday <<<<<");
            System.out.println("1- My Holiday.\n"
                    + "2- Create Holiday\n"
                    + "3- Exit\n"
            );
            choice = s.nextInt();
            switch (choice) {
                case 1:
                 MyHolidayRequests1();
                    break;
                case 2:
                   createHolidayRequest1() ;
                    break;
                case 3:
                   LoginAsEmployee1();
                    break;
                default:
                    System.out.println("Enter a valid number please!");
            }
        } while (choice != 3);
    }
 public void MyHolidayRequests() {
    System.out.println(">>>>> My Holiday <<<<<");
    if (holidayRequests.isEmpty()) {
        System.out.println("You have no holiday requests.");
    } else {
        for (HolidayRequest request : holidayRequests) {
             for(Manager m: managers ){
            if (m.getId().equals(idem)) {
             System.out.println(request.toString());}}}}}

public void createHolidayRequest1() {
    System.out.println(">>>>> Create Holiday <<<<<");
    System.out.println("Enter Name:");
    String name = s.next();
    System.out.println("Enter reason:");
    String reason = s.next();
    System.out.println("Enter Details:");
    String details = s.next();
    System.out.println("Enter the date of your holiday: ");
    String date = s.next();
   HolidayRequest request1 = new HolidayRequest(idem,name, reason,details,date,"pending");
   holidayRequests.add(request1);
    System.out.println("Holiday request has been created successfully:)");
}
  public void MyHolidayRequests1() {
    System.out.println(">>>>> My Holiday <<<<<");
    if (holidayRequests.isEmpty()) {
        System.out.println("You have no holiday requests.");
    } else {
        for (HolidayRequest request : holidayRequests) {
            if (request .getId().equals(idem)) {
             System.out.println(request.toString());
             }
        }
    }
}
    public String toString() {
        return   " Employee has id:" + getId() + " ||name:  " + getName() + " || password:  " + getPassword() + "|| email: " + getEmail() + "||phoneNumber:  " + getPhoneNumber() + "|| status:  " + getStatus() + "|| typeOfEmployee: " + 
                
      getTypeOfEmployee()+ " ||check In:  " + this.getCheckIn() + " ||check Out:  " + this.getCheckOut() ;
    }

    public String getTypeOfEmployee() {
        return typeOfEmployee;
    }

    public void setTypeOfEmployee(String  typeOfEmployee) {
        this.typeOfEmployee = typeOfEmployee;
    }

}

