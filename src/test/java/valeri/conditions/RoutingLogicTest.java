package valeri.conditions;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.function.Function;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class RoutingLogicTest {

    /**
     * Test matrix contains all possible permutations of the input parameters
     * for the routing logic component.
     */
    boolean[][] testMatrix = {
            { true, true, true },
            { true, true, false },
            { true, false, false },
            { false, false, false },
            { false, false, true },
            { false, true, true }
    };

    @Before
    public void setUp() { }

    @Test
    public void test3() {
        Arrays.stream(testMatrix)
                .map(testSet -> new InputState(testSet[0], testSet[1], testSet[2]))
                .forEach(inputState -> verify(inputState, RoutingLogic::original, RoutingLogic::simplified));
    }

    @Test
    public void test4() {
        Arrays.stream(testMatrix)
                .map(testSet -> new InputState(testSet[0], testSet[1], testSet[2]))
                .forEach(inputState -> verify(inputState, RoutingLogic::original, RoutingLogic::simplifiedTernary));
    }

    public static void verify(InputState state, Function<InputState, Integer> original, Function<InputState, Integer> simplified) {
        final Integer originalResult = original.apply(state);
        final Integer refactoredResult = simplified.apply(state);
        assertThat(originalResult, is(equalTo(refactoredResult)));
    }
}
