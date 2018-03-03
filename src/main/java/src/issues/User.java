package issues;

public class User {
    
    private String login;
    private int id;
    public User() { 
       
    }
       
    public String getLogin() {
        return login;
    }

    public void setLogin(String l) {
        this.login = l;
    }



    public int getId() {
        return id;
    }



    public void setId(int id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        return false;
    }

    @Override
    public String toString() {
        return "User [login=" + login + ", id=" + id + "]";
    }
    
    
    
}
