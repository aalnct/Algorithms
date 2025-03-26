package restart.string.intermidiate;

public class MovePiecesToObtainString {

    public static void main(String[] args) {
        String start = "_L"; //so this cannot move to left , so answer for this combination will be false
        String target = "L_";

        System.out.println(canChange(start,target));
    }

    static boolean canChange (String start, String target) {
        String startFiltered = start.replaceAll("_", "");
        String targetFiltered = target.replaceAll("_", "");

        if (!startFiltered.equals(targetFiltered)) {
            return false;
        }

        int startIndex = 0;
        int targetIndex = 0;
        int n = start.length();

        while (startIndex < n && targetIndex < n) {

            while (startIndex < n && start.charAt(startIndex) == '_') {
                startIndex++;
            }
            while (targetIndex < n && target.charAt(targetIndex) == '_') {
                targetIndex++;
            }

            if (startIndex == n || targetIndex == n) {
                break;
            }

            if (start.charAt(startIndex) == 'L' && startIndex < targetIndex) {
                return false;
            }

            if (start.charAt(startIndex) == 'R' && startIndex > targetIndex) {
                return false;
            }

            startIndex++;
            targetIndex++;
        }
        return true;
    }
}
