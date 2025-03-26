package restart.string.intermidiate;

import java.util.ArrayDeque;
import java.util.Deque;

public class SimplifyPath {
    public static void main(String[] args) {
        String path1 = "/home/";
        String path2 = "/a/./b/../../c/";
        String path3 = "/../";
        String path4 = "/home//foo/";

        System.out.println(simplifyPath(path1));
        System.out.println(simplifyPath(path2));
        System.out.println(simplifyPath(path3));
        System.out.println(simplifyPath(path4));
    }

    static String simplifyPath (String path) {
        Deque<String> deque = new ArrayDeque<>();
        String [] tokens = path.split("/");

        for (String token : tokens) {
            if (token.equals("") || token.equals(".")) {
                continue;
            }
            if (token.equals("..")) {
                if (!deque.isEmpty()) {
                    deque.pop();
                }
            } else {
                deque.push(token);
            }
        }
        if (deque.isEmpty()) {
            return "/";
        }

        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.insert(0, "/"+deque.pop());
        }
        return sb.toString();
    }
}
