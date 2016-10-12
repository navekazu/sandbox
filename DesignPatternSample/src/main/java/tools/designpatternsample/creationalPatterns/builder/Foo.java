package tools.designpatternsample.creationalPatterns.builder;

public class Foo {
    private int value;
    public int getValue() {
        return this.value;
    }
    public static FooBuilder builder() {
        return new FooBuilder();
    }
    public  static class FooBuilder {
        private Foo foo;
        public FooBuilder value(int value) {
            this.foo.value = value;
            return this;
        }
        public Foo build() {
            Foo foo = new Foo();
            foo.value = this.foo.value;
            return foo;
        }
    }
}
