package com.cinema.View;
import java.util.Scanner;
import com.cinema.Controller.editUserData;
import com.cinema.Model.Usuario;
import com.cinema.Model.login;
import com.cinema.Model.userSession;
public class editUserInfo {
     final static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) throws Exception  {

        System.out.println("Selecione o que deseja editar");
        System.out.println("1: Editar email");
        System.out.println("2: Editar senha");
        int op = scanner.nextInt();
        
        scanner.nextLine();


        switch (op) {
            case 1:
                System.out.println("Informe o novo email");
                String email = scanner.nextLine();

                 userSession emailUser = new userSession(email);
                 emailUser.setEmail(email);
                 editUserData.editUserEmail(emailUser);
                break;

            case 2:
                    System.out.println("Informe a senha");
                    String senha = scanner.nextLine();
                    Usuario userPassword = new login(senha);
                    userPassword.setSenha(senha);
                    editUserData.editUserPassword(userPassword);

                break;

            default:

            
                break;
        }


    }

}
