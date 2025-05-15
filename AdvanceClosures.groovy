// Example: Left Currying
def multiply = { a, b -> a * b }
def double = multiply.curry(2)

println double(5) // Output: 10

// Right Currying
def triple = multiply.rcurry(3)

println triple(4) // Output: 12

// Index Currying (Mid-position)
def divide = { a, b, c -> (a + b) / c }
def curried = divide.ncurry(1, 4) // Fix second argument (index 1) to 4

println curried(6, 2) // Output: 4.0

// Basic Memoization
def fib
fib = { n ->
    if (n < 2) return n
    fib(n - 1) + fib(n - 2)
}.memoize()

println fib(30) // Much faster due to caching

// Example: Function Composition
def upper = { it.toUpperCase() }
def exclaim = { it + '!' }

def excited = upper >> exclaim

println excited('groovy') // Output: GROOVY!

// Trampolining allows recursion without blowing the stack by deferring evaluation
def factorial
factorial = { n, acc = 1 ->
    if (n == 1) return acc
    return factorial.trampoline(n - 1, n * acc)
}.trampoline()

println factorial(1000) // Safe from StackOverflow

// Closures are perfect for strategy patterns or dynamic behavior
def taxStrategy = { amount -> amount * 0.2 }
def calculateTax = { amount, strategy -> strategy(amount) }

println calculateTax(100, taxStrategy) // Output: 20.0
