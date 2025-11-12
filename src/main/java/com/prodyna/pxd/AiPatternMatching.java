package com.prodyna.pxd;

// Collect what the internet and IntelliJ Junie with different LLMs created

public class AiPatternMatching {

  // what I wanted
  String java_21_guarded_pattern_matching_for_switch_expression(Object o) {

    return switch (o) {
      case String s when s.length() > 10 -> "long string: " + s;
      case String s -> "short string: " + s;
      case Integer i when i > 100 -> "integer above 100: " + i;
      case Integer i -> "integer below 100: " + i;
      case null, default -> "¯\\_(ツ)_/¯";
    };
  }

  // what I described

  /*
    create me a java class file called "AiPatternMatchingJunie". Inside of the file write a method which returns a String and takes a Object o as parameter.
    use switch in the method and do not use the ternary operator.
    in case o is a string which is longer than 10 return "this is a long string" otherwise return "short string".
    in case o is an int bigger than 100 return "integer above 100: " followed by the value otherwise return  "integer below 100: " followed by the value.
    as default and in case of an null return "¯\\_(ツ)_/¯".
   */


  // what I got from IntelliJ Junie with Claude sonnet 4.5

  public String matchObject(Object o) {
    return switch (o) {
      case String s when s.length() > 10 -> "this is a long string";
      case String s -> "short string";
      case Integer i when i > 100 -> "integer above 100: " + i;
      case Integer i -> "integer below 100: " + i;
      case null, default -> "¯\\_(ツ)_/¯";
    };
  }


  // what I sent to AIs to get the wording right for the method above

  /*
    create me a java class file called "AiPatternMatchingMore". Inside of the file write a method which returns a String and takes a Object o as parameter.
    in case o is a string which is longer than 10 return "this is a long string" otherwise return "short string".
    in case o is an int bigger than 100 return "integer above 100: " followed by the value otherwise return  "integer below 100: " followed by the value.
    as default and in case of an null return "¯\\_(ツ)_/¯".
  */

  // what I got from IntelliJ Junie with Chat-GPT 5

  /**
   * Evaluates the given object based on simple rules:
   * - If the object is a String: returns whether it's long (>10) or short.
   * - If the object is an Integer: returns a message based on whether it's above 100 or not.
   * - For null or any other type: returns the default shrug.
   *
   * @param o the object to evaluate
   * @return the evaluation result as a String
   */
  public static String match1(Object o) {
    if (o == null) {
      return "¯\\_(ツ)_/¯";
    }

    if (o instanceof String) {
      String s = (String) o;
      return s.length() > 10 ? "this is a long string" : "short string";
    }

    if (o instanceof Integer) {
      int i = (Integer) o;
      return i > 100 ? "integer above 100: " + i : "integer below 100: " + i;
    }

    return "¯\\_(ツ)_/¯";
  }


  // what I got from IntelliJ Junie with Claude 4.5 Sonnet

  public String matchObject1(Object o) {
    if (o == null) {
      return "¯\\_(ツ)_/¯";
    }

    if (o instanceof String s) {
      if (s.length() > 10) {
        return "this is a long string";
      } else {
        return "short string";
      }
    }

    if (o instanceof Integer i) {
      if (i > 100) {
        return "integer above 100: " + i;
      } else {
        return "integer below 100: " + i;
      }
    }

    return "¯\\_(ツ)_/¯";
  }


  // from  https://www.codeconvert.ai/java-code-generator?id=c5707298-e982-413e-95ed-e123fd32d9a2
  public String analyzeObject(Object o) {
    if (o == null) {
      return "¯\\_(ツ)_/¯";
    }
    if (o instanceof String s) {
      if (s.length() > 10) {
        return "this is a long string";
      } else {
        return "short string";
      }
    }
    if (o instanceof Integer i) {
      if (i > 100) {
        return "integer above 100: " + i;
      } else {
        return "integer below 100: " + i;
      }
    }
    return "¯\\_(ツ)_/¯";
  }


  /*
    added to task: "use switch in the method"
  */

  // what I got from IntelliJ Junie with Chat-GPT 5

  /**
   * Evaluates the given object using a pattern-matching switch and returns a message.
   * <p>
   * Rules:
   * - If o is a String: return "this is a long string" when length > 10, otherwise "short string".
   * - If o is an int/Integer: return "integer above 100: <value>" when value > 100, otherwise
   * "integer below 100: <value>".
   * - For null and any other type: return "¯\\_(ツ)_/¯".
   */
  public static String match2(Object o) {
    // Pattern matching for switch (Java 21+). We also handle null explicitly.
    return switch (o) {
      case null -> "¯\\_(ツ)_/¯";
      case String s -> s.length() > 10 ? "this is a long string" : "short string";
      case Integer i -> i > 100 ? ("integer above 100: " + i) : ("integer below 100: " + i);
      default -> "¯\\_(ツ)_/¯";
    };
  }


  /*
    added to task: "use switch in the method and do not use the ternary operator."
  */


  // what I got from IntelliJ Junie with Chat-GPT 5

  /**
   * Utility class demonstrating pattern matching with switch without using the ternary operator.
   */
  // public class AiPatternMatchingMore {

  /**
   * Evaluates the given object using a pattern-matching switch and returns a message.
   * <p>
   * Rules:
   * - If o is a String: return "this is a long string" when length > 10, otherwise "short string".
   * - If o is an int/Integer: return "integer above 100: <value>" when value > 100, otherwise
   * "integer below 100: <value>".
   * - For null and any other type: return "¯\\_(ツ)_/¯".
   */
  public static String match3(Object o) {
    // Pattern matching for switch (Java 21+). We also handle null explicitly.
    return switch (o) {
      case null -> "¯\\_(ツ)_/¯";
      case String s -> {
        if (s.length() > 10) {
          yield "this is a long string";
        } else {
          yield "short string";
        }
      }
      case Integer i -> {
        if (i > 100) {
          yield "integer above 100: " + i;
        } else {
          yield "integer below 100: " + i;
        }
      }
      default -> "¯\\_(ツ)_/¯";
    };
  }


  // from  https://refact.ai/java-code-generator/
  public String handleObject(Object o) {
    if (o == null) {
      return "¯\\_(ツ)_/¯";
    }

    switch (o.getClass().getSimpleName()) {
      case "String":
        String s = (String) o;
        if (s.length() > 10) {
          return "this is a long string";
        } else {
          return "short string";
        }
      case "Integer":
        Integer i = (Integer) o;
        if (i > 100) {
          return "integer above 100: " + i;
        } else {
          return "integer below 100: " + i;
        }
      default:
        return "¯\\_(ツ)_/¯";
    }
  }


  // from https://www.codeconvert.ai/java-code-generator?id=44b3bd06-2321-4aa4-a49d-dd0daea7f7e3
  // not compile clean  at all
  /*
  public String analyzeObject(Object o) {
    if (o == null) {
      return "¯\\_(ツ)_/¯";
    }
    return switch (o) {
      case String s && s.length() > 10 -> "this is a long string";
        case String s -> "short string";
      case Integer i && i > 100 -> "integer above 100: " + i;
        case Integer i -> "integer below 100: " + i;
        default -> "¯\\_(ツ)_/¯";
    };
  }
  */

}
