package hashtable;

public class HashTable {

    String [] hashArray;
    int arraySize; // should be prime number of double hashing
    int size; // counter the number of elements in table (no of slots used)

    public HashTable(int noOfSlots) {

        if (isPrime(noOfSlots)) {
            hashArray = new String[noOfSlots];
            arraySize = noOfSlots;
        }else {
            int primeCount = getNextPrime(noOfSlots);
            hashArray = new String[primeCount];
            arraySize = primeCount;

            System.out.println("Hashtable size given ..." + noOfSlots + " is not a prime number");
            System.out.println("Hashtable size changed to ..." + primeCount);
        }
    }

    private boolean isPrime (int number) {
        for (int i=2; i*i <= number; i++) {
            if (number%i == 0) {
                return false;
            }
        }
        return true;
    }

    private int getNextPrime(int minNumber) {
        for (int i = minNumber ; true; i++) {
            if (isPrime(i)) {
                return i;
            }
        }
    }

    private int _hashFunction1 (String word) {
        int hasValue = word.hashCode();
        hasValue = hasValue % arraySize;
        if (hasValue < 0) {
            hasValue += arraySize;
        }
        return hasValue; // ideal index position
    }

    // returns step size > 0
    private int _hashFunction2 (String word) {
        int hashValue = word.hashCode();
        hashValue %= arraySize;

        if (hashValue < 0) {
            hashValue += arraySize;
        }

        return 3-hashValue % 3; // use prime number lesser than size
    }

    public void insert (String word) {
        int hashValue = _hashFunction1(word);
        int stepSize = _hashFunction2(word);

        while (hashArray[hashValue] != null) {
            hashValue = hashValue + stepSize;
            hashValue %= arraySize;
        }

        hashArray[hashValue] = word;
        System.out.println("Inserted word .... " + word);
        size++;
    }

    public String find (String word) {
        int hashValue = _hashFunction1(word);
        int stepSize = _hashFunction2(word);

        while (hashArray[hashValue] != null) {
            if (hashArray[hashValue].equals(word)) {
                return hashArray[hashValue];
            }
            hashValue += stepSize;
            hashValue %= arraySize;
        }
        return hashArray[hashValue]; // most probably it will be null
    }

    public void displayTable () {
        System.out.println("Table");
        for (int i=0;i<arraySize;i++) {
            if (hashArray[i]!=null) {
                System.out.println(hashArray[i] + " ");
            }else {
                System.out.println(".....");
            }
        }
        System.out.println("");
    }
}
