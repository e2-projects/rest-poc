package lt.edas.demo.poc.services.mapper

import org.slf4j.Logger
import spock.lang.Specification
import spock.lang.Subject

class MapperServiceImplTest extends Specification {

    @Subject
    private MapperService service;
    private Logger logger = Mock()

    def setup() {
        service = new MapperServiceImpl(logger)
    }
}
