package backEnd;


public class Logout {
    public static void logOut(){
        LoginSession.isLoggedIn = false;
        //context.setVisible(false);
        //loginScreen.setVisible(true);
    }
}
