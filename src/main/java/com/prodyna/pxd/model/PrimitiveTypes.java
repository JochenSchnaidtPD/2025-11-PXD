package com.prodyna.pxd.model;

/// <h1>Primitive Types and Values</h1>
/// Primitive values do not share state with other primitive values.<br>
///<br>
/// The numeric types are the integral types and the floating-point types.<br>
/// The integral types are byte, short, int, and long, whose values are 8-bit, 16-bit, 32-bit and 64-bit signed two's-complement integers, respectively, and char, whose values are 16-bit unsigned integers representing UTF-16 code units (§3.1).<br>
/// The floating-point types are float, whose values exactly correspond to the 32-bit IEEE 754 binary32 floating-point numbers, and double, whose values exactly correspond to the 64-bit IEEE 754 binary64 floating-point numbers.<br>
/// The boolean type has exactly two values: true and false.<br>
/// [4.2. Primitive Types and Values](https://docs.oracle.com/javase/specs/jls/se24/html/jls-4.html#jls-4.2)<br>

public record PrimitiveTypes(float f, double d, boolean b) {
}
