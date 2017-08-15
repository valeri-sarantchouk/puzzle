package valeri.conditions;

public class RoutingLogic {

    private static int OptionOne = 1;
    private static int OptionTwo = 2;

    private RoutingLogic() { }

    /**
     * The original method containing inefficient conditional logic.
     */
    public static int original(boolean first, boolean second, boolean third)
    {
        if (!first)
        {
            if (second)
            {
                if (third)
                {
                    return OptionOne;
                }
                else if (!second)
                {
                    return OptionTwo;
                }
                else
                {
                    return OptionOne;
                }
            }
            else
            {
                return OptionOne;
            }
        }
        else if (!third)
        {
            if (!second)
            {
                return OptionTwo;
            }
        }
        else if (!second)
        {
            return OptionTwo;
        }
        if (!(third || !second))
        {
            return OptionTwo;
        }
        return OptionOne;
    }



    /**
     * Improving upon the 'original' method, the 'simplified' method provides the same results as the
     * 'original' method (given the same input params), but having a simpler implementation.
     */
    public static int simplified(boolean first, boolean second, boolean third) {
        if (!first) {
            return OptionOne;
        }
        else if (!(third || second)
                || !(third || !second)) {
            return OptionTwo;
        }
        return OptionOne;
    }

    /**
     * Even shorter version. See unit tests for verification code.
     */
    public static int simplifiedTernary(boolean first, boolean second, boolean third) {
        return !first || ((second || third) && (!second || third))
                ? OptionOne : OptionTwo;
    }

    // --- Helper methods --------------------------------

    /**
     * Functional wrapper for the 'original' method.
     */
    public static Integer original(InputState is) {
        return original(is.isFirst(), is.isSecond(), is.isThird());
    }

    /**
     * Functional wrapper for the 'simplified' method.
     */
    public static Integer simplified(InputState is) {
        return simplified(is.isFirst(), is.isSecond(), is.isThird());
    }

    /**
     * Functional wrapper for the 'simplifiedTernary' method.
     */
    public static Integer simplifiedTernary(InputState is) {
        return simplifiedTernary(is.isFirst(), is.isSecond(), is.isThird());
    }

}
