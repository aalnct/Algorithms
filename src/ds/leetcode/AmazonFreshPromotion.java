package ds.leetcode;

public class AmazonFreshPromotion {

    public static void main(String[] args) {
        String [] shoppingCart = new String[] {"apple", "banana", "apple", "banana", "orange", "banana"};
        String [][] codes = new String [][] {
                {"apple", "apple"},  {"banana", "anything", "banana"}
        };
        int winner  = winner(codes, shoppingCart);
        System.out.println(winner);
    }

    public static int winner (String [][] codes, String [] shoppingCart) {
        StringBuilder stringBuilder = new StringBuilder(".*");
        for (String[] code : codes) {
            for (String str : code) {
                stringBuilder.append(str.equalsIgnoreCase("anything") ? ".*" : str);
            }
            stringBuilder.append(".*");
        }
        StringBuilder cart = new StringBuilder();

        for (String s : shoppingCart) {
            cart.append(s);
        }
        return cart.toString().matches(stringBuilder.toString()) ? 1 : 0;
    }
}
