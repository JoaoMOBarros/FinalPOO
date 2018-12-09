import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        UserManagment teste = new UserManagment();

        teste.writeUsers();//criar o arquivo

        teste.readUsers();

        teste.createUser("pedreineiro", 1);
        teste.createUser("paulinho  pereira", 0);
        teste.createUser("joana paula", 1);
        teste.createUser("pedreineiro", 1);
        teste.createUser("pedreineiro", 1);
        teste.removeUser("alex");
        teste.writeUsers();

    }
}
