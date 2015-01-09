# generator-android-square-stack [![Build Status](https://secure.travis-ci.org/kuhnza/generator-android-square-stack.png?branch=master)](https://travis-ci.org/kuhnza/generator-android-square-stack)

> [Yeoman](http://yeoman.io) generator

This generator will create a skeleton Android app built atop a collection of awesome Android libraries 
by [Square](http://square.github.io/) using a single Activity/multiple view style.

##### Included libraries

* [Dagger - dependency injection](http://square.github.io/dagger/)
* [Mortar - composable, scoped modules](https://github.com/square/mortar)
* [Flow - sane navigation](https://github.com/square/flow)
* [Retrofit - type-safe REST client](https://github.com/square/retrofit)
* [Otto - event bus](https://github.com/square/otto)
* [RXAndroid - reactive extensions for Android](https://github.com/ReactiveX/RxAndroid)

The project also generates with a set of extremely useful test helper classes and static methods along with
example tests showing how to use them.

##### Features

1. Splash screen
2. Production and test build flavors
3. Environment selector menu
4. Registration and Login screens _(coming soon)_

## Getting Started

### Install Yeoman

Not every new computer comes with a Yeoman pre-installed. He lives in the [npm](https://npmjs.org) package repository. You only have to ask for him once, then he packs up and moves into your hard drive. *Make sure you clean up, he likes new and shiny things.*

```bash
npm install -g yo
```

### Install the Generator

Yeoman travels light. He didn't pack any generators when he moved in. You can think of a generator like a plug-in. You get to choose what type of application you wish to create, such as a Backbone application or even a Chrome extension.

To install generator-android-square-stack from npm, run:

```bash
npm install -g generator-android-square-stack
```

Finally, initiate the generator:

```bash
yo android-square-stack
```

This will create a fully functioning Android app skeleton.

### Run it

Once you've generated the skeleton app simply import into Android Studio/IntelliJ (haven't tried with Eclipse & ADT sorry) as a Gradle project, perform a Gradle sync and then run! 

## License

MIT
