package youtube.gson;

import com.google.gson.Gson;

public class Main {
    public static void main(String[] args) {

        // serializeUserSimple();
        deserializeUserSimple();

    }

    private static void serializeUserSimple() {
        UserSimple user = new UserSimple("Julio", "A22Julio@iessanclemente.net", 22, true);

        Gson gson = new Gson();
        String json = gson.toJson(user);
        System.out.println(json);
    }

    private static void deserializeUserSimple() {
        String userJson = "{'name':'Julio','email':'A22Julio@iessanclemente.net','age':22,'isDeveloper':true}";

        Gson gson= new Gson();
        UserSimple userSimple= gson.fromJson(userJson, UserSimple.class);
        System.out.println(userSimple);

    }
}
