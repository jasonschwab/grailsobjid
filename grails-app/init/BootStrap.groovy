import fooidnull.Foo
import fooidnull.ReBar
import fooidnull.Bar

class BootStrap {

    def init = { servletContext ->
        new Bar(name: 'one').save(failOnError: true)
        Bar bar = new Bar(name: 'two').save(failOnError: true)
        new Bar(name: 'three').save(failOnError: true)

        new ReBar(name: 'four', reName: 'rone').save(failOnError: true)
        new ReBar(name: 'five', reName: 'rtwo').save(failOnError: true)
        ReBar reBar = new ReBar(name: 'six', reName: 'rthree').save(failOnError: true)

        new Foo(bar: bar, reBar: reBar, name: 'f1').save(failOnError: true)
        new Foo(bar: bar, reBar: reBar, name: 'f2').save(failOnError: true)
        new Foo(bar: bar, reBar: reBar, name: 'f3').save(failOnError: true)
    }
    def destroy = {
    }
}
