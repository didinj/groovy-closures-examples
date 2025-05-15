// Default Resolution
class ScopeDemo {
    def name = 'ScopeDemo'

    def runDemo() {
        def closure = {
            println "this.name: ${this.name}"
            println "owner.name: ${owner.name}"
            println "delegate.name: ${delegate.name}"
        }
        closure()
    }
}

new ScopeDemo().runDemo()

// Nested Closures and owner
def outer = {
    def inner = {
        println "owner is outer? " + (owner == outer)
        println "this is script? "  + (this instanceof GroovyScript)
    }
    inner()
}

outer()

// Changing the delegate and Resolve Strategy
class Person {
    String name
}

def closure = {
    println "Hello, $name!"
}

def p = new Person(name: 'Alice')
closure.delegate = p
closure.resolveStrategy = Closure.DELEGATE_FIRST

closure()  // Output: Hello, Alice!

// Building a tiny HTML builder
class HtmlBuilder {
    def content = ''

    def html(Closure cl) {
        cl.delegate = this
        cl.resolveStrategy = DELEGATE_FIRST
        content += '<html>'
        cl()
        content += '</html>'
    }

    def body(Closure cl) {
        content += '<body>'
        cl.delegate = this
        cl.resolveStrategy = DELEGATE_FIRST
        cl()
        content += '</body>'
    }

    def p(String text) {
        content += "<p>${text}</p>"
    }
}

def builder = new HtmlBuilder()
builder.html {
    body {
        p 'Hello, World!'
    }
}
println builder.content
