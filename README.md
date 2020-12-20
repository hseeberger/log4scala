# log4scala #

log4scala is a library providing convenient and performant logging for Scala 3. It is piggybacking 
on [Apache Logj4 2](https://logging.apache.org/log4j/2.x) (but you can use other backends like 
[Logback](http://logback.qos.ch/)) and it automagically applies the check-enabled-idiom thanks to 
Scala 3 metaprogramming.

In a nutshell, you can invoke logging methods like `info` without checking if the respective log 
level is enabled, because that is handled for you by the compiler:

``` scala
def expensive() = ??? // Very expensive construction of "expensive"
val logger = Logger(getClass)
logger.info(s"I am an $expensive log message ;-)")
```

The compiler will – more or less – create the following code for you:

``` scala
...
// maybeCreateMessage() would return something like "I am an $expensive log message ;-)"
if (logger.isInfoEnabled) logger.info(maybeCreateMessage()) 
```

So if the respective log level is not enabled, the potentially expensive construction of the log 
message will not happen without you having to explicitly check the log level.

log4scala is inspired by:
- [Scala Logging](https://github.com/lightbend/scala-logging)
- [Log4j](https://github.com/Log4s/log4s)
- [Scala 3 / Dotty docs](http://dotty.epfl.ch/docs/reference/metaprogramming/inline.html)

So far log4scala is work in progress and there are not yet any releases.

## Contribution policy ##

Contributions via GitHub pull requests are gladly accepted from their original author. Along with
any pull requests, please state that the contribution is your original work and that you license
the work to the project under the project's open source license. Whether or not you state this
explicitly, by submitting any copyrighted material via pull request, email, or other means you
agree to license the material under the project's open source license and warrant that you have the
legal authority to do so.

## License ##

This code is open source software licensed under the
[Apache-2.0](http://www.apache.org/licenses/LICENSE-2.0) license.
