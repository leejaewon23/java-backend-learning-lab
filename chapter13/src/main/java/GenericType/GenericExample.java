package GenericType;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
public class GenericExample {

    Product<Tv, String> product1 = new Product<>();


}
