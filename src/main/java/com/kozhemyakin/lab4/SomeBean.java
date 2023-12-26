package com.kozhemyakin.lab4;

/**
 * @author n.s.kozhemyakin
 */
public class SomeBean {
    /**
     * Constructs a new `SomeBean` object.
     */
    public SomeBean() {}
    /**
     * The first field annotated with `AutoInjectable`, representing a dependency
     * on an implementation of the `SomeInterface` interface.
     */
    @AutoInjectable
    private SomeInterface field1;
    /**
     * The second field annotated with `AutoInjectable`, representing a dependency
     * on an implementation of the `SomeOtherInterface` interface.
     */
    @AutoInjectable
    private SomeOtherInterface field2;
    /**
     * Executes the `doSomething` method for both injected dependencies.
     */
    public void foo() {
        // Call the doSomething method on the first injected dependency.
        field1.doSomething();

        // Call the doSomething method on the second injected dependency.
        field2.doSomething();
    }
}
