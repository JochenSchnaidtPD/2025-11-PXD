package com.prodyna.pxd;

import org.junit.jupiter.api.Test;


// https://openjdk.org/jeps/409
public class SealedClassesTest {

  interface I {
  }

  class C {
  } // does not implement I

  @Test
  void c_instance_of_sealed_classes_test() {

    C instance = new C();

    if (instance instanceof I)
      System.out.println("It's an I");
  }


  /*
  The type conversion rules capture a notion of open extensibility. The Java type system does not assume a closed world.
  Classes and interfaces can be extended at some future time, and casting conversions compile to runtime tests, so we can safely be flexible.
   */
  class B extends C implements I {
  }

  @Test
  void b_instance_of_sealed_classes_test() {

    B instance = new B();

    if (instance instanceof I)
      System.out.println("It's an I");
  }


  /*
  The test fails to compile, since the compiler knows that there can be no subclass of Final_C,
  so since Final_C does not implement I then it is never possible for a Final_C value to implement I.
   */
  final class Final_C {
  } // does not implement I

  @Test
  void final_c_instance_of_sealed_classes_test() {

    Final_C instance = new Final_C();

    // Compile-time error!
    // if (instance instanceof I)
    //   System.out.println("It's an I");
  }


  /*
  What if C is not final, but sealed? Its direct subclasses are explicitly enumerated, and — by the definition of being sealed — in the same module,
  so we expect the compiler to look to see if it can spot a similar compile-time error

  Class Sealed_C does not implement I, and is not final, so by the existing rules we might conclude that a conversion is possible.
  Sealed_C is sealed, however, and there is one permitted direct subclass of Sealed_C, namely D.
  By the definition of sealed types, D must be either final, sealed, or non-sealed.
  In this example, all the direct subclasses of Sealed_C are final and do not implement I.
  This program should therefore be rejected, since there cannot be a subtype of Sealed_C that implements I.
   */
  sealed class Sealed_C permits D {
  }

  final class D extends Sealed_C {
  }

  @Test
  void sealed_c_instance_of_sealed_classes_test() {

    Sealed_C instance = new Sealed_C();

    // Compile-time error!
    // if (instance instanceof I)
    //  System.out.println("It's an I");
  }


  /*
  In contrast, consider a similar program where one of the direct subclasses of the sealed class is non-sealed.
  This is type-correct, since it is possible for a subtype of the non-sealed type D to implement I.
   */
  sealed class Sealed_X permits Y, Z {
  }

  non-sealed class Y extends Sealed_X {
  }

  final class Z extends Sealed_X {
  }

  @Test
  void sealed_x_instance_of_sealed_classes_test() {

    Sealed_X instance = new Sealed_X();

    if (instance instanceof I)
      System.out.println("It's an I");
  }
}
