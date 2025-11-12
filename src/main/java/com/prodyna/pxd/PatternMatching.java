package com.prodyna.pxd;

import com.prodyna.pxd.model.*;
import com.prodyna.pxd.model.Terminator;

public class PatternMatching {

  /**
   * Statement -> no return value
   * Works with primitives (except long), wrapper, enums, and String.
   * switch labels of the same type as selector
   * Fall through, default not required
   */
  void legacy_switch_implementation(int i) {

    switch (i) {
      case 2:
      case 4:
        System.out.println("two or four");
        break;
      case 5:
        System.out.println("five");
        break;
      case 8:
        System.out.println("eight");
        break;
      default:
        System.out.println("Something else");
        break;
    }
  }


  /**
   * matching on class, explicit cast necessary
   * further processing afterwards -> adds more complexity
   * null-safe
   */
  void legacy_instanceof_implementation(Object o) {

    if (o instanceof String) {
      String s = (String) o;
      if (s.length() > 10) {
        System.out.println("long string: " + s);
      } else {
        System.out.println("short string: " + s);
      }
    } else if (o instanceof Integer) {
      Integer i = (Integer) o;
      if (i > 100) {
        System.out.println("integer above 100: " + i);
      } else {
        System.out.println("integer below 100: " + i);
      }
    } else {
      System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /*
   * Java 7
   * The goal of Project Coin is to determine what set of small language changes should be added to JDK 7.
   * - Strings in switch
   * Java Almanac: https://javaalmanac.io/jdk/7/
   */

  /*
   * Java 8
   * Lambda Expressions, Default Methods in Interfaces, Effectively Final Variables, Streams, JavaFX
   * Java Almanac: https://javaalmanac.io/jdk/8/
   */

  /*
   * Java 9
   * Module System, Var Handles, Reactive Streams
   * Java Almanac: https://javaalmanac.io/jdk/9/
   */

  /*
   * Java 10
   * Graal VM, Keyword var
   * Java Almanac: https://javaalmanac.io/jdk/10/
   */

  /*
   * Java 11
   * Java 11 was the first Long Term Support (LTS).
   * btw. EOL Date 2027-10
   * Local Variable Syntax for Lambda Parameters, Java EE and CORBA removed, Nashorn JavaScript Engine deprecated
   * Java Almanac: https://javaalmanac.io/jdk/11/
   */

  /*
   * Java 12
   * Shenandoah GC, Switch Expressions 1. Preview
   * Java Almanac: https://javaalmanac.io/jdk/12/
   */

  /*
   * Java 13
   * Reimplement the Legacy Socket API, Switch Expressions 2. Preview
   * Java Almanac: https://javaalmanac.io/jdk/12/
   */

  /// Java 14 Switch Expressions<br>
  /// [JEP 361: Switch Expressions](https://openjdk.org/jeps/361)<br>
  /// [Java Almanac](https://javaalmanac.io/features/switch/)<br>
  /// <br>
  /// Handling
  /// - Expression -> return value
  /// - works with primitives (except double, float, long, boolean), wrapper, enums, and String.
  /// - support either traditional case ... : labels (with fall through) or new case ... -> labels (with no fall through)
  /// - switch labels of the same type as selector
  /// - no more fall through, comma-separated list, default required
  String java_14_implementation(int i) {

    return switch (i) {
      case 2, 4 -> "two or four";
      case 5 -> "five";
      case 8 -> {
        System.out.println("blocks are allowed here");
        yield "eight";
      }
      default -> "Something else";
    };
  }

  /*
   * Java 15
   * ZGC & Shenandoah GC,  Sealed Classes 1. Preview,  Pattern Matching for instanceof 2. Preview,  Records 2. Preview
   * Java Almanac: https://javaalmanac.io/jdk/15/
   */

  /// Java 16 Pattern Matching for instanceof<br>
  /// [JEP 394: Pattern Matching for instanceof](https://openjdk.org/jeps/394)<br>
  /// [Java Almanac](https://javaalmanac.io/features/instanceof-patterns/)<br>
  /// [Java Language Updates](https://docs.oracle.com/en/java/javase/16/language/pattern-matching-instanceof-operator.html)<br>
  /// also<br>
  /// [JEP 395: Records](https://openjdk.org/jeps/395)<br>
  /// [Java Almanac](https://javaalmanac.io/features/records/)<br>
  /// <br>
  /// Handling
  /// - match on class includes pattern variable which can directly be used
  /// - less complexity
  /// - order matters
  /// - variable scopes exits
  void java_16_pattern_matching_for_instanceof(Object o) {

    if (o instanceof String s && s.length() > 10) {
      System.out.println("long string: " + s);
    } else if (o instanceof String s) {
      System.out.println("short string: " + s);

    } else if (o instanceof Integer i && i > 100) {
      System.out.println("integer above 100: " + i);
    } else if (o instanceof Integer i) {
      System.out.println("integer below 100: " + i);

    } else if (o instanceof Person p) {
      System.out.println("Are you " + p.name() + "? - It works with records too.");

    } else {
      System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /*
   * Java 17
   * Sealed Classes, Sealed Interfaces for fine granular access of class hierarchies.
   * Pattern Matching for switch - 1. Preview
   * Java Almanac: https://javaalmanac.io/jdk/17/
   */

  /*
   * Java 18
   * UTF-8 by Default, Reimplement Core Reflection with Method Handles
   * Pattern Matching for switch - 2. Preview
   * Java Almanac: https://javaalmanac.io/jdk/18/
   */

  /*
   * Java 19
   * Linux/RISC-V Port
   * Pattern Matching for switch - 3. Preview, Record Patterns - 1. Preview
   * Java Almanac: https://javaalmanac.io/jdk/19/
   */

  /*
   * Java 20
   * Pattern Matching for switch - 4. Preview, Record Patterns - 2. Preview
   * Virtual Threads 2. Preview, Structured Concurrency 2. Incubator
   * Java Almanac: https://javaalmanac.io/jdk/20/
   */

  /// Java 21 Pattern Matching for switch<br>
  /// [JEP 441: Pattern Matching for switch](https://openjdk.org/jeps/441)<br>
  /// [Java Almanac](https://javaalmanac.io/features/typepatterns/)<br>
  /// <br>
  /// Handling
  /// - pattern variable must be present - differs from instanceof
  /// - default case must be present
  /// - default case dominates null case
  /// - default does not include null
  /// - null case to handle o == null, no NPE on switch (o)
  /// - null case missing -> NPE backward compatibility
  void java_21_pattern_matching_for_switch(Object o) {

    switch (o) {
      case String s -> {
        if (s.length() > 10) {
          System.out.println("long string: " + s);
        } else {
          System.out.println("short string: " + s);
        }
      }
      case Integer i -> {
        if (i > 100) {
          System.out.println("integer above 100: " + i);
        } else {
          System.out.println("integer below 100: " + i);
        }
      }
      case null -> System.out.println("we prevented a NPE");
      default -> System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /**
   * Case refinement<br>
   * In contrast to case labels with constants, a pattern case label can apply to many values.<br>
   * This can often lead to conditional code on the right-hand side of a switch rule.<br>
   * <br>
   * when reserved word in this context only
   * all validations on left side of arrow
   * all statements on the right side of arrow
   * guard: "s.length() > 10"
   * guarded pattern: String s when s.length() > 10
   * guarded pattern case label: case String s when s.length() > 10
   * order matters
   */
  void java_21_guarded_pattern_matching_for_switch(Object o) {

    switch (o) {
      case String s when s.length() > 10 -> System.out.println("long string: " + s);
      case String s -> System.out.println("short string: " + s);
      case Integer i when i > 100 -> System.out.println("integer above 100: " + i);
      case Integer i -> System.out.println("integer below 100: " + i);
      case null, default -> System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /**
   * Expression -> return value
   * when reserved word in this context only
   * all validations on left side of arrow
   * all statements on the right side of arrow
   * guard: "s.length() > 10"
   * guarded pattern: String s when s.length() > 10
   * guarded pattern case label: case String s when s.length() > 10
   * order matters
   */
  String java_21_guarded_pattern_matching_for_switch_expression(Object o) {

    return switch (o) {
      case String s when s.length() > 10 -> "long string: " + s;
      case String s -> "short string: " + s;
      case Integer i when i > 100 -> "integer above 100: " + i;
      case Integer i -> "integer below 100: " + i;
      case null, default -> "¯\\_(ツ)_/¯";
    };
  }

  /**
   * pattern variable must not have the same name as an already defined variable in the scope.
   * leads to "Variable 's' is already defined in the scope"
   * equally named class variable is fine although
   */
  String t = "class level defined variable for long strings";

  String java_21_pattern_variable_shadowing(Object o) {

    // not allowed:
    // String t = "Gone with the wind";

    return switch (o) {
      case String t when t.length() > 10 -> this.t;
      case String t -> "short string: " + t;
      case null, default -> "¯\\_(ツ)_/¯";
    };
  }

  /**
   * pattern variables are mutable and their value can be changed
   */
  String java_21_pattern_variable_mutability(Object o) {

    return switch (o) {
      case String s -> {
        s = "something different";
        yield s;
      }
      case null, default -> "¯\\_(ツ)_/¯";
    };
  }

  /**
   * Switches and enum constants
   * The use of enum constants in case labels is, at present, highly constrained:
   * The selector expression of the switch must be of the enum type,
   * and the labels must be simple names of the enum's constants.
   */
  void java_21_enums_prior(Suit s) {

    switch (s) {
      case HEARTS -> System.out.println("It's a heart!");
      default -> System.out.println("Some other suit");
    }
  }

  /**
   * Even after adding pattern labels, this constraint leads to unnecessarily verbose code.
   */
  void java_21_enums_exhaustive_switch_without_enum_support(CardClassification c) {

    switch (c) {
      case Suit s when s == Suit.CLUBS -> System.out.println("It's clubs");
      case Suit s when s == Suit.DIAMONDS -> System.out.println("It's diamonds");
      case Suit s when s == Suit.HEARTS -> System.out.println("It's hearts");
      case Suit s -> System.out.println("It's spades");
      case Tarot t -> System.out.println("It's a tarot");
    }
  }

  /**
   * We therefore relax the requirement that the selector expression be of the enum type
   * and we allow case constants to use qualified names of enum constants.
   */
  void java_21_enums_exhaustive_switch_with_enum_support(CardClassification c) {

    switch (c) {
      case Suit.CLUBS -> System.out.println("It's clubs");
      case Suit.DIAMONDS -> System.out.println("It's diamonds");
      case Suit.HEARTS -> System.out.println("It's hearts");
      case Suit.SPADES -> System.out.println("It's spades");
      case Tarot t -> System.out.println("It's a tarot");
    }
  }

  void java_21_enums_improved_enum_constant_labels_by_interface(Currency c) {

    switch (c) {
      case Coin.HEADS -> System.out.println("Heads");// Qualified name of enum constant as a label
      case Coin.TAILS -> System.out.println("Tails");
    }
  }

  void java_21_enums_improved_enum_constant_labels_by_enum(Coin c) {

    switch (c) {
      case HEADS -> System.out.println("Heads");
      case Coin.TAILS -> System.out.println("Tails"); // Unnecessary qualification but allowed
    }
    // but don't mix it up on the interface
  }


  /// Java 21 Record Patterns<br>
  /// [JEP 440: Record Patterns](https://openjdk.org/jeps/440)<br>
  /// [Java Almanac](https://javaalmanac.io/features/recordpatterns/)<br>
  /// <br>
  /// Record patterns to deconstruct record values.
  /// Record patterns and type patterns can be nested to enable a powerful, declarative,
  /// and composable form of data navigation and processing.
  void java_21_record_pattern_for_instanceof(Object o) {

    if (o instanceof Pair(Double d1, Double d2)) {
      System.out.println("pair of doubles: " + d1 + ", " + d2);
    } else if (o instanceof Pair(String s, Double d2)) {
      System.out.println("pair for key/value: " + s + ", " + d2);
    } else if (o instanceof Pair(var v1, var v2)) {
      System.out.println("pair for anything else: " + v1 + ", " + v2);

    } else {
      System.out.println("¯\\_(ツ)_/¯");
    }
  }

  void java_21_record_pattern_for_switch(Object o) {

    switch (o) {
      case Pair(Double d1, Double d2) -> System.out.println("pair of doubles: " + d1 + ", " + d2);
      case Pair(String s, Double d2) -> System.out.println("pair for key/value: " + s + ", " + d2);
      case Pair(String s, Pair(String nested, Integer bar)) -> System.out.println("nested value is: " + bar);
      case Pair(var v1, var v2) -> System.out.println("pair for anything else: " + v1 + ", " + v2);
      case null, default -> System.out.println("¯\\_(ツ)_/¯");
    }
  }

  /// Java 21 Pattern Matching on sealed classes<br>
  /// [JEP 409: Sealed Classes](https://openjdk.org/jeps/409)<br>
  /// [Java Almanac](https://javaalmanac.io/features/sealedtypes/)<br>
  /// <br>
  /// Only to show exhaustiveness and compatibility, so comment one case out
  void java_21_pattern_matching_for_sealed_classes(TimeTraveler timeTraveler) {
    switch (timeTraveler) {
      case DocBrown x -> System.out.println(x.catchphrase());
      case DrWho y -> System.out.println(y.catchphrase());
      case MartyMcFly z -> System.out.println(z.catchphrase());
      case Terminator arnie -> System.out.println(arnie.catchphrase());
    }
  }

  /// Java 22 Unnamed Variables & Patterns<br>
  /// [JEP 456: Unnamed Variables & Patterns](https://openjdk.org/jeps/456)<br>
  /// <br>
  /// Enhance the Java programming language with unnamed variables and unnamed patterns,
  /// which can be used when variable declarations or nested patterns are required but never used.
  /// Improve the readability of record patterns by eliding unnecessary nested type patterns.
  /// it works with multiple patterns in case labels
  void java_22_unnamed_pattern_matching_for_switch(TimeTraveler timeTraveler) {
    switch (timeTraveler) {
      case DrWho _ -> System.out.println("TARDIS stuff");
      case DocBrown _, MartyMcFly _ -> System.out.println("Back to the Future");
      case Terminator arnie -> System.out.println(arnie.catchphrase());
    }
  }

  /*
   * Java 23
   * ZGC: Generational Mode by Default
   * Primitive Types in Patterns, instanceof, and switch 1. Preview
   * Java Almanac: https://javaalmanac.io/jdk/18/
   */


  /*
   * Java 24
   * Remove the Windows 32-bit x86 Port, Ahead-of-Time Class Loading & Linking, Synchronize Virtual Threads without Pinning
   * Primitive Types in Patterns, instanceof, and switch 2. Preview
   * Java Almanac: https://javaalmanac.io/jdk/24/
   */


  /*
   * Java 25
   * Remove the 32-bit x86 Port, Ahead-of-Time Command-Line Ergonomics & Method Profiling, Compact Object Headers
   * Generational Shenandoah, Module Import Declarations, Compact Source Files and Instance Main Methods, Flexible Constructor Bodies
   * Primitive Types in Patterns, instanceof, and switch 3. Preview
   * Java Almanac: https://javaalmanac.io/jdk/25/
   */


  /// Java 25 Primitive Types in Patterns, instanceof, and switch<br>
  /// [JEP 507: Primitive Types in Patterns, instanceof, and switch (Third Preview)](https://openjdk.org/jeps/507)<br>
  /// <br>
  /// Goals
  /// - Enable uniform data exploration by allowing type patterns for all types, whether primitive or reference.
  /// - Align type patterns with instanceof, and align instanceof with safe casting.
  /// - Allow pattern matching to use primitive types in both nested and top-level pattern contexts.
  /// - Provide easy-to-use constructs that eliminate the risk of losing information due to unsafe casts.
  /// - Following the enhancements to switch in Java 5 (enum switch) and Java 7 (string switch), allow switch to process values of any primitive type.
  void java_25_preview_integral_types_in_pattern_for_switch(IntegralTypes integralTypes) {

    switch (integralTypes.b()) {
      case byte b when b == 110 -> System.out.println("byte: " + b);
      case byte b -> System.out.println("any other byte: " + b);
    }

    switch (integralTypes.s()) {
      case 3 -> System.out.println("short three");
      case short s when s >= 10 && s <= 20 -> System.out.println("short between 10 and 20: " + s);
      case short s -> System.out.println("any other short: " + s);
    }

    switch (integralTypes.i()) {
      case 0 -> System.out.println("integer zero");
      case int i when i >= 100 -> System.out.println("integer more than 100: " + i);
      case int i -> System.out.println("any other integer: " + i);
    }

    switch (integralTypes.l()) {
      case 14L -> System.out.println("long fourteen");
      case 6547L -> System.out.println("long match: " + integralTypes.l());
      case long l -> System.out.println("any other long: " + l);
    }

    switch (integralTypes.c()) {
      case 'P' -> System.out.println("char: " + integralTypes.c());
      case char c -> System.out.println("any other char: " + c);
    }
  }

  void java_25_preview_primitive_types_in_pattern_for_switch(PrimitiveTypes primitiveTypes) {

    switch (primitiveTypes.b()) {
      case boolean b when b -> System.out.println("boolean: " + b);
      case boolean b -> System.out.println("any other boolean: " + b);
    }

    switch (primitiveTypes.f()) {
      case 0.5F -> System.out.println("half a float zero");
      case float f when f >= 100.0 -> System.out.println("float more than 100: " + f);
      case float f -> System.out.println("any other float: " + f);
    }

    /*
    Beware !!!
    The semantics of floating-point literals in case labels is defined in terms of representation equivalence
    at compile time and run time. It is a compile-time error to use two floating-point literals that are
    representation equivalent. For example, the following switch is illegal because the literal 0.999999999f
    is rounded up to 1.0f, creating a duplicate case label.
      float v = ...
      switch (v) {
        case 1.0f -> ...
        case 0.999999999f -> ...    // error: duplicate label
        default -> ...
      }
    */

    switch (primitiveTypes.d()) {
      case 3.0002 -> System.out.println("double three something");
      case double d when d >= 10.0 && d <= 20 -> System.out.println("double between 10 and 20: " + d);
      case double d -> System.out.println("any other double: " + d);
    }
  }

  void java_25_preview_integral_types_in_pattern_for_instanceof(IntegralTypes integralTypes) {

    if (integralTypes.b() instanceof byte b) {
      System.out.println("it is a byte: " + b);
    }

    if (integralTypes.s() instanceof short s && s == 3) {
      System.out.println("short three");
    }

    if (integralTypes.s() instanceof char ) {
      System.out.println("matched a char value but is a short --> means a widening and narrowing primitive conversion was performed");
    }

    if (integralTypes.i() instanceof int ) {
      System.out.println("matched an int value");
    }

    if (integralTypes.l() instanceof int) {
      System.out.println("matched a long value but is an int --> a narrowing primitive conversion was performed");
    } else {
      System.out.println("integralTypes.l() is NOT a long");
    }

    if (integralTypes.l() instanceof int l && l == 6547.0F) {
      System.out.println("matched a float --> a widening primitive conversion was performed");
    }

    if (integralTypes.l() instanceof long ) {
      System.out.println("matched a long value");
    }

    if (integralTypes.c() instanceof char) {
      System.out.println("also works for char");
    }

    // no integral to boolean conversion allowed
  }

  void java_25_preview_primitive_types_in_pattern_for_instanceof(PrimitiveTypes primitiveTypes) {

    if (primitiveTypes.f() instanceof float) {
      System.out.println("half a float zero");
    }

    if (primitiveTypes.d() instanceof double d && d >= 10.0 && d <= 20  ) {
      System.out.println("double between 10 and 20: " + d);
    }

    if (primitiveTypes.d() instanceof int i  ) {
      System.out.println("matched an int value but is double --> a narrowing primitive conversion was performed for: " + i);
    }

    if (primitiveTypes.f() instanceof double d  ) {
      System.out.println("matched a double value but is float --> an unconditionally exact conversion was performed for: " + d);
    }

    if (primitiveTypes.b() instanceof boolean ) {
      System.out.println("also works for boolean");
    }

    // no primitive to boolean conversion allowed
  }

}
