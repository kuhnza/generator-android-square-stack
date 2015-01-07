# generator-android-square-stack [![Build Status](https://secure.travis-ci.org/kuhnza/generator-android-square-stack.png?branch=master)](https://travis-ci.org/kuhnza/generator-android-square-stack)

> [Yeoman](http://yeoman.io) generator

This generator will create a skeleton Android app built atop a collection of awesome Android libraries 
by (Square)[http://square.github.io/] using a single Activity/multiple view style.

Included libraries:

* (Dagger - dependency injection)[http://square.github.io/dagger/]
* (Mortar - composable, scoped modules)[https://github.com/square/mortar]
* (Flow - sane navigation)[https://github.com/square/flow]
* (Retrofit - type-safe REST client)[https://github.com/square/retrofit]
* (Otto - event bus)[https://github.com/square/otto]
* (RXAndroid - reactive extensions for Android)[https://github.com/ReactiveX/RxAndroid]

The project also generates with a set of extremely useful test helper classes and static methods along with
example tests showing how to use them.

## Getting Started

### What is Yeoman?

Trick question. It's not a thing. It's this guy:

![](http://i.imgur.com/JHaAlBJ.png)

Basically, he wears a top hat, lives in your computer, and waits for you to tell him what kind of application you wish to create.

Not every new computer comes with a Yeoman pre-installed. He lives in the [npm](https://npmjs.org) package repository. You only have to ask for him once, then he packs up and moves into your hard drive. *Make sure you clean up, he likes new and shiny things.*

```bash
npm install -g yo
```

### Yeoman Generators

Yeoman travels light. He didn't pack any generators when he moved in. You can think of a generator like a plug-in. You get to choose what type of application you wish to create, such as a Backbone application or even a Chrome extension.

To install generator-android-square-stack from npm, run:

```bash
npm install -g generator-android-square-stack
```

Finally, initiate the generator:

```bash
yo android-square-stack
```

### Getting To Know Yeoman

Yeoman has a heart of gold. He's a person with feelings and opinions, but he's very easy to work with. If you think he's too opinionated, he can be easily convinced.

If you'd like to get to know Yeoman better and meet some of his friends, [Grunt](http://gruntjs.com) and [Bower](http://bower.io), check out the complete [Getting Started Guide](https://github.com/yeoman/yeoman/wiki/Getting-Started).


## License

MIT
