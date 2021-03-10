package javacertification.functionalinterfaceandstreamapi;

public class Message {
    private String msg = "Good Morning";

    public Message (String msg) {
        this.msg = msg;
    }

    public Message () {
        super();
    }

    public String getMsg () {
        return msg;
    }

    @Override
    public String toString() {
        return "Message{" +
                "msg='" + msg + '\'' +
                '}';
    }
}
