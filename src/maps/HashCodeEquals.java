package maps;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by AmitAgarwal on 3/16/19.
 */
public class HashCodeEquals{

    private int userId;
    private String name;

    public HashCodeEquals(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public static void main(String [] args){
        HashCodeEquals user1 = new HashCodeEquals(1,"test");
        HashCodeEquals user2 = new HashCodeEquals(1,"test");

        List<HashCodeEquals> list = new ArrayList<>();

        HashSet<HashCodeEquals> hashSet = new HashSet<>();

        hashSet.add(user1);
        hashSet.add(user2);

        System.out.println("user1 hashcode :" + user1.hashCode());
        System.out.println("user2 hashcode :" + user2.hashCode());

        System.out.println("Checking equality : " + user1.equals(user2));

        list.add(user1);

        System.out.println("ArrayList checking :" + list.contains(new HashCodeEquals(1,"test")));


        System.out.println("HashSet :: " + hashSet.contains(new HashCodeEquals(1,"test")));
    }

    //overriding default implementation
    @Override
    public boolean equals(Object ob){
        if(ob==null) return false;
        if(!(ob instanceof HashCodeEquals)) return false;
        if(ob == this) return true;
        return this.userId == ((HashCodeEquals)ob).userId;
    }

    //same id will be stored in the same bucket
    public int hashCode(){
        return this.userId;
    }
}
