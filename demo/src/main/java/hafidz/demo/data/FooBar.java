package hafidz.demo.data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class FooBar {

    @Getter
    private Foo foo;

    @Getter
    private Bar bar;
}
