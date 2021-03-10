package hashtable;

public class Application {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(19);

        hashTable.insert("Apple");
        hashTable.insert("Hello");
        hashTable.insert("Feeling");
        hashTable.insert("Water");
        hashTable.insert("Africa");
        hashTable.insert("Speed");
        hashTable.insert("Phone");
        hashTable.insert("September");
        hashTable.insert("Michale");
        hashTable.insert("Milk");
        hashTable.insert("Huge");
        hashTable.insert("Dogs");
        hashTable.insert("Cats");
        hashTable.insert("Parrot");
        hashTable.insert("Spider");
        hashTable.insert("Sure");
        hashTable.insert("Penalty");
        hashTable.insert("Remember");
        hashTable.insert("Remarkable");

        hashTable.displayTable();

//        System.out.println(".....Finding Elements.....");
//        System.out.println(hashTable.find("Apple"));
//        //System.out.println(hashTable.find("Zebra"));
//        System.out.println(hashTable.find("Remember"));
//        System.out.println(hashTable.find("Sure"));
//        System.out.println(hashTable.find("Spider"));
//        System.out.println(hashTable.find("Penalty"));


    }
}
