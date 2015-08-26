# Grails Object ID Null

This is a simple demonstration of what looks like a bug.

There are domain classes Foo, Bar, and ReBar which extends Bar.  Foo has a Bar and a ReBar.

Bootstrap creates some objects and saves them.

The controller TryIt actions retrieve the objects and outputs the Foo ID, the Bar and the ReBar ID via both foo.barId and foo.bar.id methods.

The index action retrieves the objects via criteria.  The list action retrieves the objects via Foo.list()

The behaviour should be the same however for foo.reBarId it gets null instead of the ID.  It gets the id properly if the objects are retrieved via list.
