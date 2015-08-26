package fooidnull

class TryItController {

    def index() {
        StringBuilder response = new StringBuilder()
        def criteria = Foo.createCriteria()
        def results = criteria.list {
            reBar {
                idEq(6L)
            }
        }

        response.append("<h1>Criteria by ReBar</h1>")
        results.each {
            response.append("Foo: ${it.id}<br/>")
            response.append("&nbsp;foo.barId: ${it.barId}<br/>")
            response.append("&nbsp;foo.bar.id: ${it.bar.id}<br/>")
            response.append("&nbsp;foo.reBarId: ${it.reBarId}<br/>")
            response.append("&nbsp;foo.reBar.id: ${it.reBar.id}<br/>")
        }
        render response.toString()
    }

    def list() {
        StringBuilder response = new StringBuilder()

        def results = Foo.list()

        response.append("<h1>Criteria by List</h1>")
        results.each {
            response.append("Foo: ${it.id}<br/>")
            response.append("&nbsp;foo.barId: ${it.barId}<br/>")
            response.append("&nbsp;foo.bar.id: ${it.bar.id}<br/>")
            response.append("&nbsp;foo.reBarId: ${it.reBarId}<br/>")
            response.append("&nbsp;foo.reBar.id: ${it.reBar.id}<br/>")
        }
        render response.toString()
    }
}
