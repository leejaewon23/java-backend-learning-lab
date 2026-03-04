package ramda;

public class NormalClassRamda {
    public void doSome() {
        Ramda ms1 = new ClassString();
        ms1.procString("abc", 3);

        Ramda ms2 = new RamdaImplement();
        ms2.procString("abc", 3);
    }
}
