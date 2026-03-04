package ramda;

public class ClassString implements Ramda {
    @Override
    public void procString(String str, int num) {
        for (int i =0; i<num; i++){
            System.out.print(str);
        }
        System.out.println();
    }
}
