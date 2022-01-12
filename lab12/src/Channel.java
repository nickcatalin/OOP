import java.util.ArrayList;
import java.util.List;

public class Channel {

    String name;
    List<User> users ;

    public Channel(String name)
    {
        this.users=new ArrayList<>();
        this.name=name;
    }
    public void subscribe(User user)
    {
        users.add(user);


    }
    public void unsubscribe(User user)
    {
        users.remove(user);

    }
    public void notify(String notification)
    {
        for(int i=0;i<users.size();i++)
            users.get(i).notifications.add(notification);

        for(int i=0;i<users.size();i++){
            System.out.println(users.get(i).name);
          users.get(i).printNotification();
        }

    }
}
class teest{

    public static void main(String[] args)
    {
        Channel channel = new Channel("Nick codes sometimes");
        User alin=new User("Alin");
        channel.subscribe(alin);
        channel.subscribe(new User("Alex"));
        channel.subscribe(new User("Ion"));
        channel.subscribe(new User("Joita"));
        channel.subscribe(new User("Vlad"));
        channel.notify("Am postat un nou vidoe\n Se numeste Basic Linux Commands");

        channel.unsubscribe(alin);
        channel.notify("Am postat video nou\n Basic c projects");

    }


}
