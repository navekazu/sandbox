package tools.java9sample;

public class TryWithResources {
    public class Resource implements AutoCloseable {
        public void throwableMethod() throws Exception {
        }
        public void close() {
        }
    }

    public void tryWithResourcesSample() {
//        Resource r1 = new Resource();
//        try (Resource r2 = r1) {
//        }
        try (Resource r1 = new Resource()) {
        }
    }

    public void main(String[] args) {
        TryWithResources twr = new TryWithResources();
        twr.tryWithResourcesSample();
    }
}