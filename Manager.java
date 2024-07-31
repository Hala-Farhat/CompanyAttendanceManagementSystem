package finalprojact;

import static finalprojact.Admin.managers;
import static finalprojact.HolidayRequest.holidayRequests;
import java.util.ArrayList;
import java.util.Scanner;

public class Manager extends Users {
   Scanner s = new Scanner(System.in);
    public static ArrayList <Employee> employees =new ArrayList <>();
    public Manager() {
    }

    public Manager(String id, String name, String password, String email, String phoneNumber, int status, String checkIn, String checkOut) {
        super(id, name, password, email, phoneNumber, status, checkIn, checkOut);
    }
   

    public void LoginAsManager1(){
          int numManager = 0;
             LoginScreen u = new  LoginScreen();
        do {
                    System.out.println(">>>>> Manager <<<<<\n"
                            + "1- Add Employee.\n"
                            + "2- Update Employee.\n"
                            + "3- Delete Employee\n"
                            + "4- Search about Employee,\n"
                            + "5- Report about Employee.\n"
                            + "6- Report about All Employee.\n"
                            + "7- Deactivate and Activate Employee\n"
                            + "8- Promote an employee to Manager\n"
                            + "9- Attendance\n"
                            + "10- Holiday\n"
                            + "11- Exit");
                    numManager = s.nextInt();
                    switch (numManager) {
                        case 1:
                            AddEmployee();
                            break;
                        case 2:
                            UpdateEmployee();
                            break;
                        case 3:
                            DeleteEmployee();
                            break;
                        case 4:
                            SearchAboutEmployee();
                            break;
                        case 5:
                            ReportAboutEmployee();
                            break;
                        case 6:
                            printAllEmployeeReport();
                            break;
                        case 7:
                            DeactiveActivation();
                            break;
                        case 8:
                            promoteEmployeeToManager();
                            break;
                        case 9:
                            Attendance();
                            break;
                        case 10:
                            Holiday();
                            break;
                        case 11:
                          u.loginscreen();
                            break;
                        default:
                            System.out.println("Enter valid number please!");
                    }

                } while (numManager != 11);}

   String idm;
    public void LoginAsManager() {
        String  password ;
      
            System.out.println("<<<<< Login Manager >>>>>>");
            System.out.println("Enter your id: ");
            idm = s.next();
            System.out.println("Enter your password");
            password = s.next();
            for(Manager m: managers ){
            if (m.getId().equals(idm)&&m.getPassword().equals(password)&&m.getStatus()==1) {
              LoginAsManager1();
              return;
            } }
                System.out.println("check your id and password or  your accont not Activate ");
            LoginAsManager();
      
    }
      public void timeOfAttendance() {
        System.out.println(">>>>> Time of Attendance <<<<<");
        System.out.println("Enter the company's time of attendance: ");
         String timeOfAttendance = s.next();
        for (Manager m: managers){
             if (m.getId().equals(idm)){
                 m.setCheckIn(timeOfAttendance);
             }
    }}

    public void timeToLeave() {
        System.out.println(">>>>> Time of Leave <<<<<");
        System.out.println("Enter the company's time of leave: ");
        String timeOfLeave = s.next(); 
        System.out.println(timeOfLeave);
                for (Manager m: managers){
             if (m.getId().equals(idm)){
                 m.setCheckOut(timeOfLeave);
             }}
    }


     
    public void AddEmployee() {
        String idEm, nameEm, passwordEm, emailEm, phoneNumberEm;
        int statuss;
          String typeOfEmployee;
        System.out.println(">>>>> Add Employee <<<<<");
        System.out.println("Enter id :");
        idEm = s.next();
        System.out.println("Enter name:");
        nameEm = s.next();
        System.out.println("Enter password:");
        passwordEm = s.next();
        do {
            System.out.println("Enter your email:");
            emailEm = s.next();
            if (!emailEm.contains("@gmail.com")) {
                System.out.println("your email should contain @gmail.com");
            }
        } while (!emailEm.contains("@gmail.com"));

        do {
            System.out.println("Enter phone number:");
            phoneNumberEm = s.next();
            if (phoneNumberEm.length() != 10 && (!phoneNumberEm.startsWith("059") || !phoneNumberEm.startsWith("056"))) {
                System.out.println("your phone number should contain 10 digits and start with 059 or 056");
            }
        } while (phoneNumberEm.length() != 10 && (!phoneNumberEm.startsWith("059") || !phoneNumberEm.startsWith("056")));

        do {
            System.out.println("Types of employees (1) <Full-time> or (2) <Part-time>");
            typeOfEmployee = s.next(); 
            if (!typeOfEmployee .equals("1") && !typeOfEmployee.equals("2")) {
                System.out.println("enter a valid number either 1 orf 2!");}
            if( typeOfEmployee.equals("1")){ typeOfEmployee=" Full-time";}
            else if( typeOfEmployee.equals("2")){ typeOfEmployee=" Part-time";}
            
            
        } while (!typeOfEmployee .equals(" Full-time") && !typeOfEmployee.equals(" Part-time"));

        do {
            System.out.println("Enter status:");
            statuss = s.nextInt();
            if (statuss != 0 && statuss != 1) {
                System.out.println("your status should be only 1 or 0 ");
            }
        } while (statuss != 0 && statuss != 1);
        System.out.println("The employee has been successfully added.:)");

        Employee emp = new Employee(idEm, nameEm, passwordEm,emailEm,  phoneNumberEm, typeOfEmployee,statuss,getCheckIn(),getCheckOut());
     
       employees.add(emp);
  
    
    }
      
    private void UpdateEmployee() {
        String id, NewPassword;
        System.out.println(">>>>> Update Employee <<<<<<");
        System.out.println(" Enter id :");
        id = s.next();
        System.out.println(" New password: ");
        NewPassword = s.next();
        for (Employee employee : employees) {
            if (employee.getId().equals(id)) {
                employee.setPassword(NewPassword);
                System.out.println("The a employee's data was successfully updated.");
                return;
            }
        }
        System.out.println("No employee found with ID: " + id);
    }

    private void DeleteEmployee() {
        String id;
        System.out.println(">>>>> Delete Employee <<<<<<");
        System.out.println(" Enter id :");
        id = s.next();
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                employees.remove(e);
                System.out.println("The employee has been successfully deleted.");
                return;
            }
        }
        System.out.println("No employee found with ID: " + id);
    }

    private void SearchAboutEmployee() {
        String id;
        System.out.println(">>>>> Search About Employee <<<<<<");
        System.out.println(" Enter id :");
        id = s.next();
        for (Employee e : employees) {
            if (e.getId().equals(id)) {
                System.out.println("name: " + e.getName() + "||status: " + e.getStatus());
                return;
            }
        }
        System.out.println("No employee found with ID: " + id);
    }
   
   public void ReportAboutEmployee(){
    String idname ;
       System.out.println(">>>>> Report About Manager  <<<<<<");
       System.out.println(" Enter id or name:");
        idname =s.next(); 
         for (Employee e : employees){
   if(e.getId().equals(idname)||e.getName().equals(idname)){
       System.out.println(e.toString());
      return;
   }}}

    private void printAllEmployeeReport() {
        for (Employee e : employees) {
            System.out.println(e.toString());
        }
    }

    public void DeactiveActivation() {
        int choice;
        do {
            System.out.println(">>>>> Deactivate & Activate Employee <<<<<");
            System.out.println("1- Activate.\n"
                    + "2- Deactivate\n"
                    + "3- Exit\n"
            );
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    ActivateEmployee();
                    break;
                case 2:
                    DeactivateEmployee();
                    break;
                case 3:
                    LoginAsManager1();
                    break;
                default:
                    System.out.println("Enter a valid number please!");
            }
        } while (choice != 3);
    }

    public void ActivateEmployee() {
        System.out.println(">>>>> Activate Employee <<<<<");
        System.out.println("Enter employee ID: ");
        String employeeId = s.next();

        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                if (employee.getStatus() == 1) {
                    System.out.println("Employee with ID: " + employeeId + " is already active.");
                } else {
                    employee.setStatus(1);
                    System.out.println("Employee with ID: " + employeeId + " has been activated.");
                }
                return;
            }
        }

        System.out.println("No employee found with ID: " + employeeId);
    }

    public void DeactivateEmployee() {
        System.out.println(">>>>> Deactivate Employee <<<<<");
        System.out.println("Enter employee ID: ");
        String employeeId = s.next();

        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                if (employee.getStatus() == 0) {
                    System.out.println("Employee with ID: " + employeeId + " is already deactivated.");
                } else {
                    employee.setStatus(0);
                    System.out.println("Employee with ID: " + employeeId + " has been deactivated.");
                }
                return;
            }
        }

        System.out.println("No employee found with ID: " + employeeId);
    }
    public void promoteEmployeeToManager() {
        System.out.println(">>›>> Promote Employee to Manager <<<<<");
        System.out.println("Enter employee ID to promote: ");
        String employeeId = s.next();

        for (Employee employee : employees) {
            if (employee.getId().equals(employeeId)) {
                Manager promotedManager = new Manager(
                        employee.getId(),
                        employee.getName(),
                        employee.getPassword(),
                        employee.getEmail(),
                        employee.getPhoneNumber(),
                        employee.getStatus(),
                       employee.getCheckIn(),
                       employee.getCheckOut());

                employees.remove(employee);
                managers.add(promotedManager);

                System.out.println("Employee with ID: " + employeeId + " has the authority of a manager.");
                return;

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
                 LoginAsManager1();
                    break;
                default:
                    System.out.println("Enter a valid number please!");
            }
        } while (choice != 3);
    }



    public void Holiday() {
        int choice;
        HolidayRequest h = new HolidayRequest();
        do {
            System.out.println(">>>>> Holiday <<<<<");
            System.out.println("1- My Holiday.\n"
                    + "2- Create Holiday\n"
                    + "3- Exit\n"
            );
            choice = s.nextInt();
            switch (choice) {
                case 1:
                 MyHolidayRequests();
                    break;
                case 2:
                    createHolidayRequest();
                    break;
                case 3:
                    LoginAsManager1();
                    break;
                default:
                    System.out.println("Enter a valid number please!");
            }
        } while (choice != 3);
    }
    public void createHolidayRequest() {
    System.out.println(">>>>> Create Holiday <<<<<");
    System.out.println("Enter Name:");
    String name = s.next();
    System.out.println("Enter reason:");
    String reason = s.next();
    System.out.println("Enter Details:");
    String details = s.next();
    System.out.println("Enter the date of your holiday: ");
    String date = s.next();
   HolidayRequest request = new HolidayRequest(idm,name, reason,details,date,"pending");
   holidayRequests.add(request);

    System.out.println("Holiday request has been created successfully:)");
}
 public void MyHolidayRequests() {
    System.out.println(">>>>> My Holiday <<<<<");
    if (holidayRequests.isEmpty()) {
        System.out.println("You have no holiday requests.");
    } else {
        for (HolidayRequest request : holidayRequests) {
       
            if ( request.getId().equals(idm)) {
             System.out.println(request.toString());}}}}


}
    
