package finalprojact;

import static finalprojact.Admin.managers;
import static finalprojact.Manager.employees;
import java.util.ArrayList;
import java.util.Scanner;

public class HolidayRequest {
      private String id;
     private String name;
     private String reason;
     private String details;
     private String date;
      private String status;
      public static ArrayList<HolidayRequest> holidayRequests = new ArrayList<>();
      Scanner s = new Scanner(System.in);
      
     public HolidayRequest(){}

    @Override
    public String toString() {
        return  "HolidayRequest (  id: " + id + "|| name: " + name + " || reason:" + reason + "|| details:  " + details + "|| date: " + date + "|| status:  " + status+" )" ;
    }

 public void ViewHolidayRequests() {
        System.out.println(">>>>> View Holiday Requests <<<<<");
        for (HolidayRequest request : holidayRequests) {
             if(request.getStatus().equals("pending")){
            System.out.println(request.toString());}
        }


    }

    public void AcceptHolidayRequest() {
        System.out.println(">>>>> Accept Holiday Request <<<<<");
        System.out.println("Enter employee ID: ");
        String employeeId = s.next();

        boolean requestFound = false;
        for (HolidayRequest request : holidayRequests) {
            if (request.getId().equals(employeeId)&&request.getStatus().equals("pending")) {
               
                request.setStatus("Accept");
                requestFound = true; 
                System.out.println("Holiday request accepted for employee ID: " + employeeId);
                break;
            }
        }

        if (!requestFound) {
            System.out.println("No holiday request found for employee ID: " + employeeId);
        }
    }

    public void RejectHolidayRequest() {
        System.out.println(">>>>> Reject Holiday Request <<<<<");
        System.out.println("Enter employee ID: ");
        String employeeId = s.next();

        boolean requestFound = false;
        for (HolidayRequest request : holidayRequests) {
            if (request.getId().equals(employeeId)&&request.getStatus().equals("pending")) {
               request.setStatus(" Reject");
                
                requestFound = true; 
                System.out.println("Holiday request rejected for employee ID: " + employeeId);
                break;
            }
        }

        if (!requestFound) {
            System.out.println("No holiday request found for employee ID: " + employeeId);
        }
    }
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    public HolidayRequest(String id, String name, String reason, String details, String date, String status) {
        this.id = id;
        this.name = name;
        this.reason = reason;
        this.details = details;
        this.date = date;
        this.status = status;
    }




    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
     




   
}
