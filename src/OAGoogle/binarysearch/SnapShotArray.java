package OAGoogle.binarysearch;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class SnapShotArray {

    private List<TreeMap<Integer,Integer>> snapShots;
    private int snapID;

    public static void main(String[] args) {

    }

    public SnapShotArray (int length) {
        snapShots = new ArrayList<>();
        snapShots.add(new TreeMap<>()); // initialize first snapshot ...
        snapID = 0;
    }

    public void set(int index, int value) {
        snapShots.get(snapID).put(index,value);
    }

    public int snap(){
        snapShots.add(new TreeMap<>(snapShots.get(snapID)));
        return snapID++;
    }

    public int get(int index, int snapID) {
        TreeMap<Integer,Integer> snapShot = snapShots.get(snapID);
        Integer value = snapShot.floorKey(index); // find the closest key
        return (value != null) ? snapShot.get(value) : 0 ;
    }

}
