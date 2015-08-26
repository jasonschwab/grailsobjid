package fooidnull

class Foo {
    String name
    Bar bar
    ReBar reBar

    static constraints = {
        bar blank: false, nullable: true
        reBar blank: false, nullable: true
    }
}
