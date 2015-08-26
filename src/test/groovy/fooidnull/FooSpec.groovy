package fooidnull

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Foo)
@Mock([Bar, ReBar])
class FooSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test reBarId"() {
        given:
            new Bar(name: 'one').save(failOnError: true)
            Bar bar = new Bar(name: 'two').save(failOnError: true)
            new Bar(name: 'three').save(failOnError: true)

            new ReBar(name: 'four', reName: 'rone').save(failOnError: true)
            new ReBar(name: 'five', reName: 'rtwo').save(failOnError: true)
            ReBar reBar = new ReBar(name: 'six', reName: 'rthree').save(failOnError: true)

            new Foo(bar: bar, reBar: reBar, name: 'f1').save(failOnError: true)
            new Foo(bar: bar, reBar: reBar, name: 'f2').save(failOnError: true)
            new Foo(bar: bar, reBar: reBar, name: 'f3').save(failOnError: true)

            def criteria = Foo.createCriteria()
            def results = criteria.list {
                reBar {
                    idEq(6L)
                }
            }
        expect:
            Foo.count == 3
    }
}
