package utilities;


import org.json.JSONObject;

public class JsonObjectPractice {

    public static void main(String[] args) {

        JSONObject object = new JSONObject();

        object.put("id", 101);
        object.put("name", "John");
        object.put("role", "QA Engineer");

        object.get("name");
        object.get("role");

        System.out.println(object);
    }




}
