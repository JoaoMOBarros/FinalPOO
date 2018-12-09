public class User {

    String name;
    int isManager;

    public User(String name, int isManager){
        this.name = name;
        this.isManager = isManager;
    }

    public String getName() {
        return name;
    }
    public int getIsManager(){
        return isManager;
    }
}
