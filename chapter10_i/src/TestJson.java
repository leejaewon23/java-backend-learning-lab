import com.google.gson.Gson;

import java.util.Calendar;


public class TestJson {
    public void test() {
        PatientOfAnimal cat1 = new PatientOfAnimal(
                "야옹이", "eiskd922k399a"
                , Calendar.getInstance().getTime()
                , Calendar.getInstance().getTime()
                , 0
        );

        Gson gson = new Gson();
        String s = gson.toJson(cat1);       // ==> [1]
        System.out.println(s);
    }
}