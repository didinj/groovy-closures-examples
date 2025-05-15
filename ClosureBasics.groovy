// Closure syntax
def myClosure = { println "Hello from a closure!" }
myClosure() // Output: Hello from a closure!

// Optionally include parameters before the -> symbol
def greet = { name -> println "Hello, $name!" }
greet("Groovy") // Output: Hello, Groovy!

// Define closures with one or more parameters
def add = { a, b -> return a + b }
println add(3, 5) // Output: 8

// Omitting the parameter declaration when only one parameter is expected
def square = { it * it }
println square(4) // Output: 16

// Example of passing a closure
def repeat(times, closure) {
    for (int i = 0; i < times; i++) {
        closure(i)
    }
}
repeat(3, { println "Running iteration ${it + 1}" })

// Closures return the result of the last expression
def multiply = { a, b -> a * b }
def result = multiply(6, 7)
println result // Output: 42
