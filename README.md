# JUsecase Builders
[![Build Status](https://travis-ci.org/casid/jusecase-builders.svg?branch=master)](https://travis-ci.org/casid/jusecase-builders)
[![Coverage Status](https://coveralls.io/repos/github/casid/jusecase-builders/badge.svg?branch=master)](https://coveralls.io/github/casid/jusecase-builders?branch=master)

Builders for descriptive unit test setups that provide a fluent and convenient way to build things.

##  Setup
JUsecase Builders is available on Maven central repository:
```xml
<dependency>
    <groupId>org.jusecase</groupId>
    <artifactId>builders</artifactId>
    <version>0.2.0</version>
</dependency>
```

## "Okay, tell me something about it"
No Problem, let us start with the builder contract. Every builder follows this simple contract
```java
public interface Builder<T> {
    T build();
}
```
Given this contract, we added several ways to wrap the call of `build()` to add fluent syntax sugar like `a()`, `an()` and `of()` that you may find in `Builder` class:
```java
public static <T> T a(final Builder<T> builder) {
    return builder.build();
}

public static <T> T an(final Builder<T> builder) {
    return builder.build();
}

public static <T> T of(final T entity) {
    return entity;
}

public static <T> T[] of(final T... entities) {
    return entities;
}
```

## "Thats neat, but how do I use your builders?"
Okay okay, one thing after another :) As everything else, the different builders are also published in `Builder` class, so this may be the only class to include to access any kind of builder.

Lets pretend you want to build a list out of some values. Instead of writing ..
```java
final List<String> myList = new ArrayList();
myList.add("a");
myList.add("b");
myList.add("c");
```
.. you would simply use the `list()` method from our `Builders` class ..
```java
final List<String> myList = list("a", "b", "c").build();
```

**"So thats the fluent syntax you talked about earlier?"**

Hell, no! To provide a truly fluent way we will make use of the helper methods `a()` and `of()` like this ..
```java
final List<String> myList = a(list(of("a", "b", "c")));
```
How about that? Isn't this way better now?

**"Yeah your right, thats way better!"**

Thanks! We also think that this way of chaining will provide a much better experience, especially for the foreign readers of your code.

