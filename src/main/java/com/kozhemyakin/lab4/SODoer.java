package com.kozhemyakin.lab4;
/**
 * @author n.s.kozhemyakin
 */
public class SODoer implements SomeOtherInterface {
    /**
     * Constructs a new `SODoer` object.
     */
    public SODoer() {}
    /**
     * Performs a specific action for the `doSomething` method.
     * Prints "C" to the standard output.
     */
    @Override
    public void doSomething() {
        System.out.println("C");
    }
}
