package Data;


import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.io.IOException;


public class GitHubData{

    public static void main(String[] args) {
        try {
            // Step 2: Pull data from the GitHub API
            String url = "https://api.github.com/users";
            HttpURLConnection conn = (HttpURLConnection) new URL(url).openConnection();
            conn.setRequestMethod("GET");

            // Use Scanner to read the response
            String content = readStream(conn);
            conn.disconnect();

            // Parse the JSON response using Jackson library
            ObjectMapper objectMapper = new ObjectMapper();
            List<Map<String, Object>> usersList = objectMapper.readValue(
                    content, new TypeReference<List<Map<String, Object>>>() {});

            List<GitHubUser> gitHubUsers = new ArrayList<>();

            // Create an ExecutorService to manage concurrencies or threads
            ExecutorService executorService = Executors.newFixedThreadPool(8);
            List<Future<GitHubUser>> futures = new ArrayList<>();

            for (int i = 0; i < 20; i++) {
                Map<String, Object> userObject = usersList.get(i);
                Callable<GitHubUser> task = createGitHubUserTask(userObject, objectMapper);
                futures.add(executorService.submit(task));
            }

            // Collect the results
            for (Future<GitHubUser> future : futures) {
                gitHubUsers.add(future.get());
            }

            // Shut down the executor service
            executorService.shutdown();
           
 
            // Step 3: Print out all the available IDs
            System.out.println("Available User IDs:");
            for (GitHubUser user : gitHubUsers) {
                System.out.println(user.getLogin());
            }

            // Step 4: Prompt user to type in an ID
            Scanner inputScanner = new Scanner(System.in);
            System.out.println("Please type in an ID:");
            String inputId = inputScanner.nextLine().trim();
            inputScanner.close();

            // Find and print the user's details
            boolean found = false;
            for (GitHubUser user : gitHubUsers) {
                if (user.getLogin().equalsIgnoreCase(inputId)) {
                    System.out.println(user);
                    found = true;
                    break;
                }
            }

            if (!found) {
                System.out.println("User with ID 'inputId'is not found. Please check your SPELLING and Try Again.");
            }
        }catch (IOException e) {
            // Handle network-related exceptions gracefully
            System.err.println("Error: Network issue encountered. Please check your internet connection and try again.");
        } catch (Exception e) {
            // Handle other unexpected exceptions
            System.err.println("Error: An unexpected error occurred. Please try again later.");
            e.printStackTrace(); // For debugging purposes
        }
    }

    private static Callable<GitHubUser> createGitHubUserTask(Map<String, Object> userObject, ObjectMapper objectMapper) {
        return () -> {
            URL userUrl = new URL((String) userObject.get("url"));
            HttpURLConnection userConn = (HttpURLConnection) userUrl.openConnection();
            userConn.setRequestMethod("GET");

            String userContent = readStream(userConn);
            userConn.disconnect();

            Map<String, Object> userDetails = objectMapper.readValue(
                    userContent, new TypeReference<Map<String, Object>>() {});

            String login = (String) userObject.get("login");
            String profileUrl = (String) userObject.get("html_url");
            int numberOfRepos = (int) userDetails.get("public_repos");
            int numberOfFollowers = (int) userDetails.get("followers");
            int numberOfFollowing = (int) userDetails.get("following");

            return new GitHubUser(login, profileUrl, numberOfRepos, numberOfFollowers, numberOfFollowing);
        };
    }

    private static String readStream(HttpURLConnection conn) throws Exception {
        StringBuilder content = new StringBuilder();
        try (Scanner scanner = new Scanner(conn.getInputStream())) {
            while (scanner.hasNextLine()) {
                content.append(scanner.nextLine());
            }
        }
        return content.toString();
    }
}

class GitHubUser {
    private final String login;
    private final String profileUrl;
    private final int numberOfRepos;
    private final int numberOfFollowers;
    private final int numberOfFollowing;

    public GitHubUser(String login, String profileUrl, int numberOfRepos,
                      int numberOfFollowers, int numberOfFollowing) {
        this.login = login;
        this.profileUrl = profileUrl;
        this.numberOfRepos = numberOfRepos;
        this.numberOfFollowers = numberOfFollowers;
        this.numberOfFollowing = numberOfFollowing;
    }

    public String getLogin() {
        return login;
    }

    @Override
    public String toString() {
        return "Login: " + login + "\nProfile URL: " + profileUrl +
               "\nNumber of Repos: " + numberOfRepos +
               "\nNumber of Followers: " + numberOfFollowers +
               "\nNumber of Following: " + numberOfFollowing;
    }
}
