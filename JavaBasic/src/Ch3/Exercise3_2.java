package Ch3;

public class Exercise3_2 {
    public static void main(String[] args) {
        int numOfApples = 123;
        int sizeOfBucket = 10;
        int numOfBucket = ((numOfApples % sizeOfBucket) == 0) ? (numOfApples / sizeOfBucket) : (numOfApples / sizeOfBucket) + 1;
        System.out.println(numOfBucket);
    }
}
