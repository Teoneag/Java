import expression.*;

public final class Calculator {

    /**
     * Calculates the value of a given expression.
     *
     * @param e The expression to calculate
     * @return The result
     */
    public static int calculate(Expression e) {
        if (e == null) {
            throw new NullPointerException();
        }
        if (e instanceof Constant c) {
            return c.value();
        }
        if (e instanceof Add a) {
            return calculate(a.left()) + calculate(a.right());
        }
        if (e instanceof Subtract s) {
            return calculate(s.left()) - calculate(s.right());
        }
        if (e instanceof Multiply m) {
            return calculate(m.left()) * calculate(m.right());
        }
        throw new IllegalArgumentException("Unknown expression: " + e.getClass());
    }

}
