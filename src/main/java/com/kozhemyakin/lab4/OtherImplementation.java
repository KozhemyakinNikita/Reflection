package com.kozhemyakin.lab4;

/**
 * @author n.s.kozhemyakin
 */
public class OtherImplementation implements SomeInterface {
    /**
     * Constructs a new `OtherImplementation` object.
     */
    public OtherImplementation() {}
    /**
     * Performs an alternative action for the `doSomething` method.
     * Prints "B" to the standard output.
     */
    @Override
    public void doSomething() {
        System.out.println("B");
    }
}