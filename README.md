# jlox
A tree-walk interpreter for the programming language `lox` written in Java.
After Robert Nystrom's excellent book "Crafting Interpreters"

## Requirements: 
Just Java. 

## Usage
```
java out.production.jlox.dev.ohner.jlox.Lox [file.lox]

With a [file] argument, expects file to be a lox source file and executes it.
Without a [file] argument, opens a lox prompt
```

## Example
```
fun fib(n) {
   if (n <= 1) return n;
   return fib(n - 2) + fib(n - 1);
}

for (var i = 0; i < 40; i = i + 1) {
  print fib(i);
}
```
