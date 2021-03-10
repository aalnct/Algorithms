package javacertification.classdesign;

public class Test11 {
    enum TrafficLight {
        GREEN("GO"), AMBER ("slow"), RED ("Stop");
        private String message;
        //GREEN("GO"), AMBER ("slow"), RED ("Stop"); --> need to first line of enum
        TrafficLight (String message) {
             this.message = message;
         }

        public static void main(String[] args) {
            JobStatus status = JobStatus.FAIL;
            TestResult result = TestResult.FAIL;

            System.out.println(status.equals(result));
            //System.out.println(status == result);

            JobStatus js1 = JobStatus.SUCCESS;
            /**
             * Cannot clone enum, to make sure
             * their singleton status can be preserved
             */
            //JobStatus js2 = js1.clone();
        }
}


    enum JobStatus {
        SUCCESS, FAIL;
    }
    enum TestResult {
        PASS, FAIL;
    }
}
