import java.util.ArrayList;
import java.util.List;

public class User {

    String name;
    List<String> notifications;

    public User(String name) {
        this.name=name;
        notifications=new ArrayList<>();
    }

    public void printNotification()
    {

        for(int i=0;i<notifications.size();i++)
            System.out.println(notifications.get(i));

    }
}
