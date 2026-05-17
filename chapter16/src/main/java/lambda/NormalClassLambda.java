package lambda;

public class NormalClassLambda {
    public void doSome() {
        Lambda ms1 = new ClassString();
        ms1.procString("abc", 3);

        Lambda ms2 = new LambdaImplement();
        ms2.procString("abc", 3);
    }
}
