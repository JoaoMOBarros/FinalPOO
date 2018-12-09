import java.util.ArrayList;
import java.io.*;

public class UserManagment {

    public ArrayList<User> users = new ArrayList<User>();
    public User loggedUser;

    public String createUser(String newName, int isManager){//Cria usuários apenas se um usário de mesmo nome ainda não existe
        for(User user : users){
            if(newName.equals(user.getName())){//comparação para ver se é igual algum existente
                return "User already exists";
            }
        }//se não é igual, cria uma instancia de User e adiciona na lista de users
        User newUser = new User(newName, isManager);
        users.add(newUser);
        return "User created";
    }

    public String removeUser(String nameToRemove){//Remoção de usuários
        for(User user: users){
            if(nameToRemove.equals(user.getName())) {
                users.remove(user);//procura o usuário na lista e remove
                return "User removed";
            }
        }//se não achou o usuário, não faz nada
        return"User not found";
    }


    public String login(String name){//seta a variável login para o user que foi passado o nome
        for(User user : users){
            if(name.equals(user.getName())){
               loggedUser = user;
               return "Logged User:" + user.getName();
            }
        }
        return "User not found";
    }
    public User whosLogged(){//Função que retorna o usuário que está logado
        if(loggedUser != null)
            return loggedUser;
        return null;
    }

    public String logout(){//seta loggedUser como null -  se não há usuários logados, deslogou quem tava logado.
        if(loggedUser != null) {
            loggedUser = null;
            return "Logout sucessefull";
        }
        return "No user logged in";
    }

    public void writeUsers() throws IOException//Faz a escrita da lista de usuários no arquivo usersList.txt, no padrão
    {//(int)-(string), para verificar, posteriormente, se o usuário é um gerente da loja
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
