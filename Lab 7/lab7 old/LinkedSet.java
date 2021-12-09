import java.util.LinkedList;
import java.util.Set;
import java.util.Collections;

public class LinkedSet extends LinkedList implements Set {
    @Override
   public boolean add(Object obj){
        if(super.contains(obj)==false)
        {
            super.add(obj);
        }
        return true ;
    }
    @Override
    public void add(int i,Object obj){
        if(super.contains(obj)==false)
        {
            super.add(i,obj);
        }

    }
    @Override
    public Object set( int i,Object obj)
    {
        if(super.contains(obj)==false)
        {
            super.set(i,obj);
        }
        return this;
    }

}
