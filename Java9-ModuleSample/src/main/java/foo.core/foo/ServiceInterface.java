package foo;

import foo.service.Service01;

public interface ServiceInterface {
    public void serve();

    public static ServiceInterface create() {
        return new Service01();
    }
}
