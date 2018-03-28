public class LoginService {
    public boolean authenticate (String username, String password){
//        if (password == null || password.trim() == ""){
//            return false;
//        }
        if(password.equals("password") && username.equals("admin")){
            return true;
        }
        return false;
    }
}
