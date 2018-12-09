import java.util.ArrayList;
import java.io.*;

public class UserManagment {

    public ArrayList<User> users = new ArrayList<User>();
    public User loggedUser;

    public String createUser(String newName, int isManager){
        for(User user : users){
            if(newName.equals(user.getName())){
                return "User already exists";
            }
        }
        User newUser = new User(newName, isManager);
        users.add(newUser);
        return "User created";
    }

    public String removeUser(String nameToRemove){
        for(User user: users){
            if(nameToRemove.equals(user.getName())) {
                users.remove(user);
                return "User removed";
            }
        }
        return"User not found";
    }


    public String login(String name){
        for(User user : users){
            if(name.equals(user.getName())){
               loggedUser = user;
               return "Logged User:" + user.getName();
            }
        }
        return "User not found";
    }

    public String logout(){
        if(loggedUser != null) {
            loggedUser = null;
            return "Logout sucessefull";
        }
        return "No user logged in";
    }

    public void writeUsers() throws IOException
    {
        StringBuilder allUsers = new StringBuilder();
        for(User user : users){
            allUsers.append(user.isManager + "-" + user.getName()  + "\n");
        }
        BufferedWriter writer = new BufferedWriter(new FileWriter("usersList.txt"));
        writer.write(allUsers.toString());
        writer.close();
    }



    public void readUsers() throws IOException{
        File file = new File("usersList.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String userName;
        String[] names;

        while ((userName = br.readLine()) != null) {
            names = userName.split("-");

            createUser(names[1], Integer.parseInt(names[0]));
        }

        br.close();
    }

}
