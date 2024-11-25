package OAGoogle;

public class StudentAttendanceRecords {


    public static void main(String[] args) {
        String records = "PPALLL";
        System.out.println(checkRecord(records));
    }

    private static boolean checkRecord(String records) {
        int absentCount = 0;
        int lateCount = 0;

        char [] c = records.toCharArray();

        for (int i = 0; i < c.length; i++) { // "LALL"
            if (c[i] == 'A') {
                absentCount++;
                if (absentCount > 1) {
                    return false;
                }
                lateCount = 0;
            } else if (c[i] == 'L') {
                lateCount++;
                if (lateCount > 2) {
                    return false;
                }
            } else {
                lateCount = 0;
            }
        }
        return true;
    }
}
