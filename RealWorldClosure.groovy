// Read a file line-by-line
new File('example.txt').eachLine { line, index ->
    println "${index + 1}: $line"
}

// Filter and process lines
def errors = []

new File('app.log').eachLine { line ->
    if (line.contains('ERROR')) {
        errors << line
    }
}

println "Found ${errors.size()} errors"

// Define a sequence of tasks as closures and run them dynamically
def tasks = [
    { println 'Step 1: Clean' },
    { println 'Step 2: Compile' },
    { println 'Step 3: Test' },
    { println 'Step 4: Package' }
]

tasks.each { it() }

// List all .groovy files in a directory recursively
def listGroovyFiles = { dir ->
    dir.eachFileRecurse { file ->
        if (file.name.endsWith('.groovy')) {
            println file.path
        }
    }
}

listGroovyFiles new File('.')

// DSL-style configuration with closures
class AppConfig {
    String env
    String db

    def configure(Closure cl) {
        cl.delegate = this
        cl.resolveStrategy = Closure.DELEGATE_FIRST
        cl()
    }
}

def config = new AppConfig()
config.configure {
    env = 'production'
    db = 'postgres'
}

println "Environment: ${config.env}, DB: ${config.db}"

// Build a simple build script using closures and a mini DSL
class BuildScript {
    def steps = []

    def step(String name, Closure action) {
        steps << [name: name, action: action]
    }

    def run() {
        steps.each {
            println "Running: ${it.name}"
            it.action()
        }
    }
}

def build = new BuildScript()

build.step('Compile') { println 'Compiling source...' }
build.step('Test') { println 'Running tests...' }
build.step('Deploy') { println 'Deploying app...' }

build.run()