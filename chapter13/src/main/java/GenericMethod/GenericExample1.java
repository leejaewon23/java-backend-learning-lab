package GenericMethod;

public class GenericExample1 {
    public static <T> Box1<T> boxing(T t) {
        Box1<T> box = new Box1<>();
        box.set(t);
        return box;
    }
}
