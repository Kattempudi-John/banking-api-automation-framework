package utilities;

import org.json.JSONArray;

public class JsonArrayPractice {

    public static void main(String[] args) {

        JSONArray array = new JSONArray();

        // Add skills
        array.put("Java");
        array.put("Selenium");
        array.put("REST Assured");
        array.put("TestNG");

        // Read first skill
        System.out.println(array.get(0));

        // Read third skill
        System.out.println(array.get(2));

        // Update fourth skill
        array.put(3, "JUnit");

        // Print final array
        System.out.println(array);
    }
}
