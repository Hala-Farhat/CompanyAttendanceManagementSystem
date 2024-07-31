package finalprojact;
import java.util.ArrayList;
import java.util.Scanner;
public class Admin{
     Scanner s= new Scanner(System.in);
    public static final String ID = "123123";
    public static final String PASSWORD = "123456";
      public static  ArrayList<Manager> managers = new ArrayList<>();

    public void AddManager (){
        String id, name, password,email,phoneNumber;
        int status ;
        System.out.println(">>>>> Add Manager <<<<<" );
        System.out.println("Enter id:");
         id =s.next();
          System.out.println("Enter name:");
         name =s.next();
         System.out.println("Enter password:");
         password =s.next();
             do{
                 System.out.println("Enter email:");
                   email =s.next();
             if(!email.contains("@gmail.com")){
                 System.out.println("your email should contains @gmail.com in last email ");}
             }while(!email.contains("@gmail.com"));
             
             do{
                 System.out.println("Enter phone number:");
                   phoneNumber =s.next();
             if(phoneNumber.length()!=10&& (!phoneNumber.startsWith("059") || !phoneNumber.startsWith("056"))){
                 System.out.println("your number should contains 10 numbers and start with 059 or 056");}
             }while(phoneNumber.length()!=10&& (!phoneNumber.startsWith("059") || !phoneNumber.startsWith("056")));
             
                        do{
                 System.out.println("Enter status:");
                   status =s.nextInt();
             if( status!=0&& status!=1){
                 System.out.println("your status should be only 1 or 0 ");}
             }while( status!=0&&status!=1);
        System.out.println("The manager has been successtully added.:)");
        Manager m1=new Manager();
         String CheckIn= m1.getCheckIn();
          String CheckOut= m1.getCheckOut();
         Manager  m=new  Manager (id, name,password, email,phoneNumber,status,CheckIn,CheckOut);
         managers.add(m);      
}
   public void UpdateManager (){
       String id ,NewPassword;
       System.out.println(">>>>> Update Manager <<<<<<");
       System.out.println(" Enter id :");
        id =s.next();
       System.out.println(" New password: ");
        NewPassword =s.next();
        for (Manager manager : managers) {
            if (manager.getId().equals(id)) {
                manager.setPassword(NewPassword);
                 System.out.println("The a manager's data was successfully updated.");
                  return;
   }}System.out.println("No manager found with ID: " + id);}
   
   
   public void DeleteManager(){
     String id ;
       System.out.println(">>>>> Delete Manager <<<<<<");
       System.out.println(" Enter id :");
        id =s.next();
   for (Manager m : managers){
   if(m.getId().equals(id)){
   managers.remove(m);
    System.out.println("The manager has been successfully deleted.");
        return;
   }}System.out.println("No manager found with ID: " + id);}
       private void SearchAboutManager() {
        String id;
        System.out.println(">>>>> Search About Employee <<<<<<");
        System.out.println(" Enter id :");
        id = s.next();
        for (Manager m : managers) {
            if (m.getId().equals(id)) {
                System.out.println("name: " + m.getName() + "||status: " + m.getStatus());
                return;
            }
        }
        System.out.println("No employee found with ID: " + id);
    }

   
   
   public void ReportAboutManager(){
    String idname ;
       System.out.println(">>>>> Report About Manager  <<<<<<");
       System.out.println(" Enter id or name:");
        idname =s.next(); 
         for (Manager m : managers){
   if(m.getId().equals(idname)||m.getName().equals(idname)){
       System.out.println(m.toString());
      return;
   }
   }System.out.println("No manager found with this: " + idname); }
    public void printAllManagersReport() {
        System.out.println("<<<<<<< All Managers Report >>>>>>");
        for (Manager m : managers) {
    
            System.out.println(m.toString());
        }
    }
      public void LoginAsAdmin1() {  
             LoginScreen u = new LoginScreen();
          int numadmin;
          do {
                    System.out.println(">>>>> Admin <<<<<\n"
                            + "1- Add Manager.\n"
                            + "2- Update Manager.\n"
                            + "3- Delete Manager\n"
                            + "4- Search about Manager\n"
                            + "5- Report about Manager.\n"
                            + "6- Report about All Manager.\n"
                            + "7- Holiday requests.\n"
                            + "8- Deactivate and Activate Manager\n"
                            + "9- Exit");
                    numadmin = s.nextInt();
                    switch (numadmin) {
                        case 1:
                            AddManager();
                            break;
                        case 2:
                            UpdateManager();
                            break;
                        case 3:
                            DeleteManager();
                            break;
                        case 4:
                            SearchAboutManager();
                            break;
                        case 5:
                            ReportAboutManager();
                            break;
                        case 6:
                            printAllManagersReport();
                            break;
                        case 7:
                            HolidayRequests();
                            break;
                        case 8:
                            DeactiveActivation();
                            break;
                        case 9:
                        u.loginscreen();
                            break;
                        default:
                            System.out.println("Enter valid number please!");

                    }

                } while (numadmin != 9);
}
    public void LoginAsAdmin() {
       
        String id, password;
        do {
            System.out.println("<<<<<login screen>>>>>>");
            System.out.println("Enter your id: ");
            id = s.next();
            System.out.println("Enter your password");
            password = s.next();
       
            if (ID.equals(id) && PASSWORD.equals(password)) {
               LoginAsAdmin1();
            } else {
                System.out.println("check your id and password ");
            }
        } while (!ID.equals(id) || !PASSWORD.equals(password));
    }

    public void HolidayRequests() {
        int choice;
        HolidayRequest h= new HolidayRequest ();
        do {
            System.out.println(">>>>> Holiday Requests <<<<<");
            System.out.println("1- View Holiday requests.\n"
                    + "2- Accept the holiday\n"
                    + "3- Rejected the holiday\n"
                    + "4- Exit"
            );
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    h.ViewHolidayRequests();
                    break;
                case 2:
                    h.AcceptHolidayRequest();
                    break;
                case 3:
                   h. RejectHolidayRequest();
                    break;
                case 4:
                     LoginAsAdmin1();
                    break;
                default:
                    System.out.println("Enter a valid number please!");
            }
        } while (choice != 4);
    }

   
    public void DeactiveActivation() {
        int choice;
        do {
            System.out.println(">>>>> Deactivate & Activate Manager <<<<<");
            System.out.println("1- Activate.\n"
                    + "2- Deactivate\n"
                    + "3- Exit"
            );
            choice = s.nextInt();
            switch (choice) {
                case 1:
                    ActivateManager();
                    break;
                case 2:
                    DeactivateManager();
                    break;
                case 3:
                     LoginAsAdmin1();
                    break;
                default:
                    System.out.println("Enter a valid number please!");
            }
        } while (choice != 3);
    }

    public void ActivateManager() {
        System.out.println(">>>>> Activate Manager <<<<<");
        System.out.println("Enter manager ID: ");
        String managerId = s.next();

        for (Manager manager : managers) {
            if (manager.getId().equals(managerId)) {
                if (manager.getStatus() == 1) {
                    System.out.println("Manager with ID: " + managerId + " is already active.");
                } else {
                    manager.setStatus(1);
                    System.out.println("Manager with ID: " + managerId + " has been activated.");
                }
                return;
            }
        }

        System.out.println("No manager found with ID: " + managerId);
    }

    public void DeactivateManager() {
        System.out.println(">>>>> Deactivate Manager <<<<<");
        System.out.println("Enter manager ID: ");
        String managerId = s.next();

        for (Manager manager : managers) {
            if (manager.getId().equals(managerId)) {
                if (manager.getStatus() == 0) {
                    System.out.println("Manager with ID: " + managerId + " is already deactivated.");
                } else {
                    manager.setStatus(0);
                    System.out.println("Manager with ID: " + managerId + " has been deactivated.");
                }
                return;
            }
        }

        System.out.println("No manager found with ID: " + managerId);
    }

}


