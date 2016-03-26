# JUsecase Builders

[![Build Status](https://travis-ci.org/casid/jusecase-builders.svg?branch=master)](https://travis-ci.org/casid/jusecase-builders)
[![Coverage Status](https://coveralls.io/repos/github/casid/jusecase-builders/badge.svg?branch=master)](https://coveralls.io/github/casid/jusecase-builders?branch=master)
[![Join the chat at https://gitter.im/casid/jusecase-builders](https://badges.gitter.im/casid/jusecase-builders.svg)](https://gitter.im/casid/jusecase-builders?utm_source=badge&utm_medium=badge&utm_campaign=pr-badge&utm_content=badge)

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
Given this contract, we added several ways to wrap the call of `build()` to add fluent syntax sugar like `a()`, `an()` and `of()` that you may find in `Builders` class:
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
Okay okay, one thing after another :) As everything else, the different builders are also published in `Builders` class, so this may be the only class to include to access any kind of builder.

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

**"So this is just about lists?"**

Absolutely not! You can use this for all your entities. We'll get to that soon! The `Builders` class provides convenient access to the following java built-ins:
```java
Date myDate = a(date("2020-01-01 00:00:00"));
Set<String> mySet = a(set("a", "b", "c"));
List<String> myList = a(list("a", "b", "c"));
String[] myArray = an(array("a", "b", "c"));
```

##"You mentioned custom builders before. Why is this a good idea?"

Well, imagine this unit test setup:
```java
User admin = new User();
admin.setName("admin");

List<UserRoles> adminRoles = new ArrayList<>();
adminRoles.add("read");
adminRoles.add("write");
admin.setRoles(adminRoles);
```

Bloated, isn't it? A lot of code for setting two properties on an entity.

What about if we need the admin user for other tests? What if we need an admin, but with a different name? Without builders, this can lead to a lot of mess in your codebase.

Remember the builder contract? Let's implement it for a `User` entity
```java
public class UserBuilder implements Builder<User> {
    private final User user = new User();
    
    public UserBuilder withName(String name) {
        user.setName(name);
        return this;
    }
    
    public UserBuilder withRoles(List<String> roles) {
        user.setRoles(roles);
        return this;
    }
    
    @Override
    public User build() {
        return user;
    }
}
```

And in your project-specific `Builders` class add
```java
public static UserBuilder user() {
    return new UserBuilder();
}
```

Now we can refactor the test setup to this
```java
User admin = a(user()
    .withName("admin")
    .withRoles(a(list("read", "write")))
);
```

Much better, isn't it? But there's even more!

**"More? Tell me about it!"**

Yes, exactly! Have you ever heard about object mothers? Object mothers create entities, that are used in a lot of unit tests. Pretty much like personas from UX design.

Let's refactor our test further and put the admin creation to the `UserBuilder`:
```java
public UserBuilder admin() {
    return this
        .withName("admin")
        .withRoles(a(list("read", "write")));
}
```

Our test setup is now reduced to this
```java
User admin = a(user().admin());
```

Reads a whole lot better, doesn't it?

**"Wait! What if I need to change something about the admin, as you mentioned before?"**

Good that you ask. Well, the admin() object mother still returns a builder, right? So you can do this
```java
User admin = a(user().admin().withName("Chuck Norris"));
```

Now for this specific unit test we have an admin with the name Chuck Norris.

That's it! We believe using builders highly improves the readability and size of unit tests. You should give it a try :-)
