package finalprojact;
public class Users {
    private String id;
    private String name;
    private String password;
    private String email;
    private String phoneNumber;
    private int status;
    private  String checkIn ;
     private String checkOut;
  
    public Users() {
    }

    @Override
    public String toString() {
        return  "MAGAER HAS  id: " + id + "|| name:  " + name + " ||password: " + password + " ||email:  " + email + " ||phoneNumber:  " + phoneNumber + " || status:  " + status + "|| check In:  " + checkIn + " ||check Out: " + checkOut ;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }


    public Users(String id, String name, String password, String email, String phoneNumber, int status, String checkIn, String checkOut) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.status = status;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
    
}

