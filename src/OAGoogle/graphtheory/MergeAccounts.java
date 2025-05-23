package OAGoogle.graphtheory;

import java.util.*;

public class MergeAccounts {

    public static void main(String[] args) {
        List<List<String>> accounts = List.of(List.of("John", "johnsmith@mail.com", "john_newyork@mail.com"),
                List.of("John", "johnsmith@mail.com", "john00@mail.com"),
                List.of("Mary", "mary@mail.com"),
                List.of("John", "johnnybravo@mail.com"));

        List<List<String>> result = mergeAccounts(accounts);

        for (List<String> merged : result) {
            System.out.println(merged);
        }
    }

    static List<List<String>> mergeAccounts (List<List<String>> accounts) {
        // email list of connected emails
        Map<String,List<String>> graph = new HashMap<>();
        Map<String,String > emailToName = new HashMap<>(); // email and account name connection

        for (List<String> account : accounts) {
            String name = account.get(0);
            System.out.println("name :" + name);

            // start making connections now

            for (int i=1; i < account.size(); i++) {
                String email = account.get(i);
                System.out.println("email :" + email);
                emailToName.put(email,name);

                graph.putIfAbsent(email,new ArrayList<>());

                if (i > 1) {
                    String firstEmail = account.get(1);
                    graph.putIfAbsent(firstEmail, new ArrayList<>());

                    graph.get(email).add(firstEmail);
                    graph.get(firstEmail).add(email);
                }
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        for (String email : emailToName.keySet()) {
            if (!visited.contains(email)) {
                List<String> connectedEmails = new ArrayList<>();
                bfs(graph,email,visited,connectedEmails);
                Collections.sort(connectedEmails);

                List<String> mergedAccounts = new ArrayList<>();
                mergedAccounts.add(emailToName.get(email));
                mergedAccounts.addAll(connectedEmails);

                result.add(mergedAccounts);
            }
        }
        return result;
    }

    static void bfs (Map<String, List<String>> graph, String startEmail, Set<String> visited, List<String> connectedEmails) {
        Queue<String> queue = new LinkedList<>();
        queue.offer(startEmail);
        visited.add(startEmail);

        while (!queue.isEmpty()) {
            String email = queue.poll();
            connectedEmails.add(email);

            for (String nei : graph.get(email)) {
                if (!visited.contains(nei)) {
                    visited.add(nei);
                    queue.offer(nei);
                }
            }
        }
    }
}
