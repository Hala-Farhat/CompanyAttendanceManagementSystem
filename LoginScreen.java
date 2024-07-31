package finalprojact;
import java.util.Scanner;
public class LoginScreen {  
    Admin a= new Admin();
     Manager m = new Manager();
     Employee e = new Employee();
  public void loginscreen(){
     Scanner s= new Scanner(System.in); 
    int num=0;
    do{
    System.out.println("<<<<<login screen>>>>>>\n 1.Login as Admin\n 2.Login as Manager\n 3.Login as Employee\n 4.Exit");
     num=s.nextInt();
    switch(num){
        case 1:
       a.LoginAsAdmin();
         break;
        case 2:
         m.LoginAsManager();
            break;
        case 3:
            e.LoginAsEmployee();
            break;
        case 4:
            System.exit(0);
        break;
        default :
            System.out.println(" Enter a valid number please!");
            
    }}
       while(num!=4);}

   

   
    
}
