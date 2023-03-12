package libs;

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class UserHandling {

    // Find the usrdat.json using the path handling fix.
    private static final PathHandling pathFinder = new PathHandling("json/usrdat.json");
    private static final String FILE_PATH = pathFinder.findFilePath();

    private static final String FILE_NAME = "usrdat.json";

    // create a new user and store it in the JSON file.
    public static void SIGN_UP(String SU_username, String SU_password) {
        JSONObject user = new JSONObject();
        user.put("id", ID_GENERATOR());
        user.put("username", SU_username);
        user.put("password", SU_password);
        JSONArray usersArray = READ_JSON();
        usersArray.add(user);
        WRITE_JSON(usersArray);
    }

    // check if the given username and password match an existing user in the JSON.
    // file
    public static boolean SIGN_IN(String SI_username, String SI_password) {
        JSONArray usersArray = READ_JSON();
        for (Object obj : usersArray) {
            JSONObject user = (JSONObject) obj;
            if (user.get("username").equals(SI_username) && user.get("password").equals(SI_password)) {
                return true;
            }
        }
        return false;
    }

    // generate a random id for a new user.
    private static int ID_GENERATOR() {
        Random rand = new Random();
        int id = rand.nextInt(100000);
        JSONArray usersArray = READ_JSON();
        for (Object obj : usersArray) {
            JSONObject user = (JSONObject) obj;
            if ((long) user.get("id") == id) {
                return ID_GENERATOR();
            }
        }
        return id;
    }

    // read the user data from the JSON file and return it as a JSONArray object.
    private static JSONArray READ_JSON() {
        JSONParser parser = new JSONParser();
        JSONArray usersArray = new JSONArray();
        try {
            FileReader fileReader = new FileReader(FILE_NAME);
            usersArray = (JSONArray) parser.parse(fileReader);
            fileReader.close();
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return usersArray;
    }

    // write the given JSONArray object to the JSON file.
    // this will create a new JSON file if it was not found though.
    private static void WRITE_JSON(JSONArray usersArray) {
        try { // if file was found :
            FileWriter fileWriter = new FileWriter(FILE_NAME);
            fileWriter.write(usersArray.toJSONString());
            fileWriter.flush();
            fileWriter.close();
        } catch (IOException e) { // file not found:
            e.printStackTrace();
        }
    }

    public static void USER_HANDLING_DEBUG_MENU() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter username:");
        String username = scanner.nextLine();
        System.out.println("Enter password:");
        String password = scanner.nextLine();
        SIGN_UP(username, password);
        System.out.println("User signed up finished. (Check json data!)");

        System.out.println("Enter username:");
        username = scanner.nextLine();
        System.out.println("Enter password:");
        password = scanner.nextLine();

        if (SIGN_IN(username, password)) {
            System.out.println("Sign in finished successfully. Check data.");
        } else {
            System.out.println("Function failed. / User was not found.");
        }
        scanner.close();
    }
} // class UserHandling
