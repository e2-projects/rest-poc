package lt.edas.demo.poc.exceptions;

public class MapperException extends RuntimeException {

    public MapperException() {
        super("Cannot map null or empty object");
    }

}
