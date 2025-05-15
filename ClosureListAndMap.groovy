// Iterating with each
def fruits = ['Apple', 'Banana', 'Orange']

fruits.each { println it }

// Iterating with each and index
fruits.eachWithIndex { item, index ->
    println "${index}: ${item}"
}

// Use collect to transform a list
def upperFruits = fruits.collect { it.toUpperCase() }
println upperFruits // Output: [APPLE, BANANA, ORANGE]

// Filtering with find, findAll, any, and every
def numbers = [1, 2, 3, 4, 5, 6]

def even = numbers.find { it % 2 == 0 }
println even // Output: 2

def evens = numbers.findAll { it % 2 == 0 }
println evens // Output: [2, 4, 6]

println numbers.any { it > 5 }   // true
println numbers.every { it > 0 } // true

// Iterating with each
def person = [name: 'John', age: 30, city: 'New York']

person.each { key, value ->
    println "$key => $value"
}

// Filtering Maps
def adults = [Anna: 22, Bob: 17, Chris: 19]
def result = adults.findAll { name, age -> age >= 18 }

println result // Output: [Anna:22, Chris:19]

// Transforming Maps
def upperNames = adults.collectEntries { name, age ->
    [(name.toUpperCase()): age]
}

println upperNames // Output: [ANNA:22, BOB:17, CHRIS:19]

// Groovy makes it easy to chain operations
def names = ['jane', 'jack', 'john']

def filtered = names
    .findAll { it.startsWith('j') }
    .collect { it.capitalize() }

println filtered // Output: [Jane, Jack, John]