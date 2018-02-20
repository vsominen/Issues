package issues;

public class User {
    
    private Login login;
    private int id;
    public User() {
       
    }
       
    public Login getLogin() {
        return login;
    }

    public void setLogin(Login l) {
        this.login = l;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }
    
}
