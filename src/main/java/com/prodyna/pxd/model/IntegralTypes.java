package com.prodyna.pxd.model;

/// <h1>Integral Types and Values</h1>
/// For byte, from -128 to 127, inclusive<br>
/// For short, from -32768 to 32767, inclusive<br>
/// For int, from -2147483648 to 2147483647, inclusive<br>
/// For long, from -9223372036854775808 to 9223372036854775807, inclusive<br>
/// For char, from '\u0000' to '\uffff' inclusive, that is, from 0 to 65535<br>
/// [4.2. Primitive Types and Values](https://docs.oracle.com/javase/specs/jls/se24/html/jls-4.html#jls-4.2)<br>
public record IntegralTypes (byte b, short s, int i, long l, char c){
}
