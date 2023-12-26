package com.kozhemyakin.lab4;

/**
 * @author n.s.kozhemyakin
 */
public class SomeImplementation implements SomeInterface {
    /**
     * Constructs a new `SomeImplementation` object.
     */
    public SomeImplementation() {}
    /**
     * Performs a specific action for the `doSomething` method.
     * Prints "A" to the standard output.
     */
    @Override
    public void doSomething() {
        System.out.println("A");
    }
}
