package utilities;


import com.jayway.jsonpath.JsonPath;

public class JsonPathPractice {

    public static void main(String[] args) {

        String json = "{\n" +
                "  \"status\": \"SUCCESS\",\n" +
                "  \"customer\": {\n" +
                "    \"id\": 101,\n" +
                "    \"profile\": {\n" +
                "      \"name\": \"John\",\n" +
                "      \"role\": \"QA Engineer\",\n" +
                "      \"contact\": {\n" +
                "        \"email\": \"john@example.com\",\n" +
                "        \"phone\": \"9876543210\"\n" +
                "      }\n" +
                "    },\n" +
                "    \"address\": {\n" +
                "      \"city\": \"Bangalore\",\n" +
                "      \"country\": \"India\"\n" +
                "    }\n" +
                "  }\n" +
                "}";

        System.out.println((int)JsonPath.read(json, "customer.id"));
        System.out.println((String)JsonPath.read(json, "customer.profile.name"));
        System.out.println((String)JsonPath.read(json, "customer.profile.role"));
        System.out.println((String)JsonPath.read(json, "customer.profile.contact.email"));
        System.out.println((String)JsonPath.read(json, "customer.address.city"));
        System.out.println((String)JsonPath.read(json, "customer.address.country"));

    }
}
