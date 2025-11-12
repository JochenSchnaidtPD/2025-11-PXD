## Pattern Matching in Java
#### Boring title: How to use `switch` and `instanceof` in 2025
What is pattern matching?


Shortest possible explanation<br>
Pattern matching saves you typing, makes code clearer, and prevents many typical errors when casting objects.<br>
<br>
In well-formed description<br>
Pattern matching allows common logic in a program, namely the conditional extraction of components from objects, to be expressed more concisely and safely.<br>
<br>
<br>
Pattern Matching is one of the topics in Project Amber.<br>
Project Amber aims to explore and incubate smaller, productivity-oriented Java language features.<br>
Amber was introduced around 2017 is still ongoing.<br>
<br>
<br>
But instead of defining the single words and meanings, let's see how pattern matching evolved in Java up to today's state.<br>
<br>
<hr>

## FAQ
Q: Why do I need to know this? I was told AI will do my job.<br>
A: LLMs return code but it is up to the operator to review and evaluate the delivered solution. And therefore it is necessary to understand the provided code. Check the file AiPatternMatching.<br>
## Summary
_Pattern matching saves you typing, makes code clearer, and prevents many typical errors when casting objects._

Yes it is true. There are some handy changes when it comes to programming with Java.

But we saw that there are also some points to consider while most of the changes come naturally.

Pattern Matching for primitives is still in preview and will be shipped after Java 26.

>Future Work<br>
Having regularized the language's rules around type comparisons and pattern matching, we may then consider introducing constant patterns. (1)

<br>
<hr>

## Sources, lots of them

OpenJDK
- [Project Coin](https://openjdk.org/projects/coin/)
- [Project Amber](https://openjdk.org/projects/amber/)
- [OpenJDK Wiki Amber](https://wiki.openjdk.org/display/amber)
- [Pattern Matching for Java](https://openjdk.org/projects/amber/design-notes/patterns/pattern-matching-for-java)
- [JDK 21](https://openjdk.org/projects/jdk/21/)
- [JDK 25](https://openjdk.org/projects/jdk/25/)

Java Version Almanac
- [Java 21](https://javaalmanac.io/jdk/21/)
- [Java 25](https://javaalmanac.io/jdk/25/)

jdk.java.net
- [Java Platform, Standard Edition 21 Reference Implementations](https://jdk.java.net/java-se-ri/21)
- [Java Platform, Standard Edition 25 Reference Implementations](https://jdk.java.net/java-se-ri/25)

Java Docs
- [Java 16 Record Classes](https://docs.oracle.com/en/java/javase/16/language/records.html)
- [Java 16 Sealed Classes](https://docs.oracle.com/en/java/javase/16/language/sealed-classes-and-interfaces.html)
- [Java 21 Record Classes](https://docs.oracle.com/en/java/javase/21/language/records.html)
- [Java 21 Sealed Classes](https://docs.oracle.com/en/java/javase/21/language/sealed-classes-and-interfaces.html)
- [Java 21 Pattern Matching](https://docs.oracle.com/en/java/javase/21/language/pattern-matching.html)
- [Java 25 Switch Expressions and Statements](https://docs.oracle.com/en/java/javase/25/language/switch-expressions-and-statements.html)
- [Java 25 Safe Casting with instanceof and switch](https://docs.oracle.com/en/java/javase/25/language/safe-casting-instanceof-and-switch.html)

Java Language Specification
- [Java Language Specification 24](https://docs.oracle.com/javase/specs/jls/se24/html/jls-15.html#jls-15.20.2)

All the JEPs in the source file.


(1) https://bugs.openjdk.org/browse/JDK-8359136

 