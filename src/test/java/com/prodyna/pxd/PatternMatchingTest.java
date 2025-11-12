package com.prodyna.pxd;

import com.prodyna.pxd.model.*;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

class PatternMatchingTest {

  private final PatternMatching impl = new PatternMatching();

  @Test
  void legacy_switch_implementation_test() {

    IntStream.range(0, 10).forEach(impl::legacy_switch_implementation);
  }


  @Test
  void legacy_instanceof_implementation_test() {

    impl.legacy_instanceof_implementation("This is a long string");
    impl.legacy_instanceof_implementation("foo");

    impl.legacy_instanceof_implementation(42);
    impl.legacy_instanceof_implementation(512);

    short s = 5;
    impl.legacy_instanceof_implementation(s);
    impl.legacy_instanceof_implementation(null);
  }


  @Test
  void java_14_implementation_test() {

    IntStream.range(0, 10).forEach(i -> {
      String s = impl.java_14_implementation(i);
      System.out.println(s);
    });
  }


  @Test
  void java_16_pattern_matching_for_instanceof_test() {

    impl.java_16_pattern_matching_for_instanceof("This is a long string");
    impl.java_16_pattern_matching_for_instanceof("foo");

    impl.java_16_pattern_matching_for_instanceof(42);
    impl.java_16_pattern_matching_for_instanceof(512);

    impl.java_16_pattern_matching_for_instanceof(new Person("John Connor", 40));

    short s = 5;
    impl.java_16_pattern_matching_for_instanceof(s);
    impl.java_16_pattern_matching_for_instanceof(null);
  }


  @Test
  void java_21_pattern_matching_for_switch_test() {

    impl.java_21_pattern_matching_for_switch("This is a long string");
    impl.java_21_pattern_matching_for_switch("foo");

    impl.java_21_pattern_matching_for_switch(42);
    impl.java_21_pattern_matching_for_switch(512);

    short s = 5;
    impl.java_21_pattern_matching_for_switch(s);
    impl.java_21_pattern_matching_for_switch(null);
  }


  @Test
  void java_21_guarded_pattern_matching_for_switch_test() {

    impl.java_21_guarded_pattern_matching_for_switch("This is a long string");
    impl.java_21_guarded_pattern_matching_for_switch("foo");

    impl.java_21_guarded_pattern_matching_for_switch(42);
    impl.java_21_guarded_pattern_matching_for_switch(512);

    short s = 5;
    impl.java_21_guarded_pattern_matching_for_switch(s);
    impl.java_21_guarded_pattern_matching_for_switch(null);
  }

  @Test
  void java_21_guarded_pattern_matching_for_switch_expression_test() {

    String s;

    s = impl.java_21_guarded_pattern_matching_for_switch_expression("This is a long string");
    System.out.println(s);
    s = impl.java_21_guarded_pattern_matching_for_switch_expression("foo");
    System.out.println(s);

    s = impl.java_21_guarded_pattern_matching_for_switch_expression(42);
    System.out.println(s);
    s = impl.java_21_guarded_pattern_matching_for_switch_expression(512);
    System.out.println(s);

    short sh = 5;
    s = impl.java_21_guarded_pattern_matching_for_switch_expression(sh);
    System.out.println(s);
    s = impl.java_21_guarded_pattern_matching_for_switch_expression(null);
    System.out.println(s);
  }


  @Test
  void java_21_pattern_variable_shadowing_test() {

    String s = impl.java_21_pattern_variable_shadowing("This is a long string");
    System.out.println(s);

    s = impl.java_21_pattern_variable_shadowing("foo");
    System.out.println(s);
  }


  @Test
  void java_21_pattern_variable_mutability_test() {
    String s = impl.java_21_pattern_variable_mutability("This is a long string");
    System.out.println(s);

    s = impl.java_21_pattern_variable_mutability(null);
    System.out.println(s);
  }


  @Test
  void java_21_enums_prior_test() {
    impl.java_21_enums_prior(Suit.HEARTS);
    impl.java_21_enums_prior(Suit.SPADES);
  }


  @Test
  void java_21_enums_exhaustive_switch_without_enum_support_test() {
    impl.java_21_enums_exhaustive_switch_without_enum_support(Suit.DIAMONDS);
    impl.java_21_enums_exhaustive_switch_without_enum_support(Suit.SPADES);
    impl.java_21_enums_exhaustive_switch_without_enum_support(new Tarot());
  }


  @Test
  void java_21_enums_exhaustive_switch_with_enum_support_test() {
    impl.java_21_enums_exhaustive_switch_with_enum_support(Suit.DIAMONDS);
    impl.java_21_enums_exhaustive_switch_with_enum_support(Suit.SPADES);
    impl.java_21_enums_exhaustive_switch_with_enum_support(new Tarot());
  }


  @Test
  void java_21_enums_improved_enum_constant_labels_by_interface_test() {
    impl.java_21_enums_improved_enum_constant_labels_by_interface(Coin.HEADS);
    impl.java_21_enums_improved_enum_constant_labels_by_interface(Coin.TAILS);
  }


  @Test
  void java_21_enums_improved_enum_constant_labels_by_enum_test() {
    impl.java_21_enums_improved_enum_constant_labels_by_enum(Coin.HEADS);
    impl.java_21_enums_improved_enum_constant_labels_by_enum(Coin.TAILS);
  }


  @Test
  void java_21_pattern_matching_for_instanceof_test() {

    impl.java_21_record_pattern_for_instanceof(new Pair<>(0.4, 0.5));
    impl.java_21_record_pattern_for_instanceof(new Pair<>("ghj", 0.5));
    impl.java_21_record_pattern_for_instanceof(new Pair<>(Boolean.TRUE, 0.5F));

    impl.java_21_record_pattern_for_instanceof(new Person("John Connor", 40));

    short s = 5;
    impl.java_21_record_pattern_for_instanceof(s);
    impl.java_21_record_pattern_for_instanceof(null);
  }


  @Test
  void java_21_record_pattern_for_switch_test() {

    impl.java_21_record_pattern_for_switch(new Pair<>(0.4, 0.5));
    impl.java_21_record_pattern_for_switch(new Pair<>("ghj", 0.5));
    impl.java_21_record_pattern_for_switch(new Pair<>(Boolean.TRUE, 0.5F));
    impl.java_21_record_pattern_for_switch(new Pair<>("foo", new Pair<>("bar", 8)));

    impl.java_21_record_pattern_for_switch(new Person("John Connor", 40));

    short s = 5;
    impl.java_21_record_pattern_for_switch(s);
    impl.java_21_record_pattern_for_switch(null);
  }


  @Test
  void java_21_pattern_matching_for_sealed_classes_test() {

    impl.java_21_pattern_matching_for_sealed_classes(new DocBrown());
    impl.java_21_pattern_matching_for_sealed_classes(new DrWho());
    impl.java_21_pattern_matching_for_sealed_classes(new MartyMcFly());
    impl.java_21_pattern_matching_for_sealed_classes(new Terminator());
  }


  @Test
  void java_22_unnamed_pattern_matching_for_switch_test() {

    impl.java_22_unnamed_pattern_matching_for_switch(new DocBrown());
    impl.java_22_unnamed_pattern_matching_for_switch(new DrWho());
    impl.java_22_unnamed_pattern_matching_for_switch(new MartyMcFly());
    impl.java_22_unnamed_pattern_matching_for_switch(new Terminator());
  }


  @Test
  void java_25_preview_integral_types_in_pattern_for_switch_test() {

    IntegralTypes it = new IntegralTypes((byte)110, (short)3, 1024, 6547L, 'P');
    impl.java_25_preview_integral_types_in_pattern_for_switch(it);

    System.out.println("- - - ");

    IntegralTypes it2 = new IntegralTypes((byte)10, (short)13, 55, 14L, 'a');
    impl.java_25_preview_integral_types_in_pattern_for_switch(it2);
  }


  @Test
  void java_25_preview_primitive_types_in_pattern_for_switch_test() {

    PrimitiveTypes pt = new PrimitiveTypes(0.5F, 3.0002, true);
    impl.java_25_preview_primitive_types_in_pattern_for_switch(pt);

    System.out.println("- - - ");

    PrimitiveTypes pt2 = new  PrimitiveTypes(5.0F, 17, false);
    impl.java_25_preview_primitive_types_in_pattern_for_switch(pt2);
  }


  @Test
  void java_25_preview_integral_types_in_pattern_for_instanceof_test() {

    IntegralTypes it = new IntegralTypes((byte)110, (short)3, 1024, 6547L, 'P');
    impl.java_25_preview_integral_types_in_pattern_for_instanceof(it);
  }


  @Test
  void java_25_preview_primitive_types_in_pattern_for_instanceof_test() {

    PrimitiveTypes pt = new PrimitiveTypes(0.5F, 17.000, true);
    impl.java_25_preview_primitive_types_in_pattern_for_instanceof(pt);
  }

}