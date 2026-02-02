import com.google.gson.Gson;

public class TestGson {
    public void runTestGson() {
        int[] intArray = {1, 2, 3, 4, 5};
        Gson gson = new Gson();
        String s =  gson.toJson(intArray);
        System.out.println(s);

        MyClass mc = new MyClass();
        mc.setMyArray(intArray);
        String s2 =  gson.toJson(mc);
        System.out.println(s2);

    }
}
