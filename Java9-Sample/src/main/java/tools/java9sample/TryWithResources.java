package tools.java9sample;

public class TryWithResources {
    public class Resource implements AutoCloseable {
        public void throwExceptionMethod() throws Exception {
        }
        public void close() {
        }
    }

    public void tryWithResourcesSample() {
        Resource r1 = new Resource();
        try (Resource r2 = r1) {
        }

        Resource r3 = new Resource();
        try (r3) {
        }

//        try (Resource r1 = new Resource()) {
//        }
    }

    public void main(String[] args) {
        TryWithResources twr = new TryWithResources();
        twr.tryWithResourcesSample();
    }
}