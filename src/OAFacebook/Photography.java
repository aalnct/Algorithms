package OAFacebook;

public class Photography {

    public static void main(String[] args) {
        int N = 5;
        String C = "APABA";
        int X = 1;
        int Y = 2;
        System.out.println(getArtisticPhotography(N,C,X,Y));
    }

    public static int getArtisticPhotography(int N, String C, int X, int Y) {
        int count = 0;

        for (int p=0; p < N; p++) {
            if (C.charAt(p) != 'P') {
                continue;
            }

            for (int a =0; a < N; a++) {
                if (C.charAt(a) != 'A') {
                    continue;
                }

                for (int b=0; b  < N; b++) {
                    if (C.charAt(b) != 'B') {
                        continue;
                    }

                    if (p < a && a < b) {
                        int distancePA = Math.abs(a-p);
                        int distanceAB = Math.abs(b-a);

                        if (distancePA >= X && distancePA <=Y
                        && distanceAB >=X && distanceAB <= Y) {
                            count++;
                        }
                    }
                }
            }

        }
        return count;
    }
}
