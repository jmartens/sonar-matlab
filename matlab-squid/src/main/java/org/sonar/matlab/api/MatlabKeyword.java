/*
 * SonarQube Matlab Plugin
 * Copyright (C) 2011 SonarSource and Waleri Enns
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.matlab.api;

import com.sonar.sslr.api.AstNode;
import com.sonar.sslr.api.TokenType;

/**
 * http://docs.matlab.org/reference/lexical_analysis.html#keywords
 */
public enum MatlabKeyword implements TokenType {
	
  /*
   * Entering Commands
   */
  /*
   * Most recent answer
   * @see http://www.mathworks.com/matlab/matlab/ref/ans.html
   */
  ANS("ans"),
  /*
   * Clear Command Window
   * @see http://www.mathworks.com/matlab/matlab/ref/clc.html
   */
  CLC("clc"),
  /*
   * Save Command Window text to file
   * @see http://www.mathworks.com/matlab/matlab/ref/diary.html
   */
  DIARY("diary"),
  /*
   * Set display format for output
   * @see http://www.mathworks.com/matlab/matlab/ref/format.html
   */
  FORMAT("format"),
  /*
   * Send cursor home
   * @see http://www.mathworks.com/matlab/matlab/ref/home.html
   */
  HOME("home"),
  /*
   * Determine whether input is MATLAB keyword
   * @see http://www.mathworks.com/matlab/matlab/ref/iskeyword.html
   */
  ISKEYWORD("iskeyword"),
  /*
   * Control paged output for Command Window
   * @see http://www.mathworks.com/matlab/matlab/ref/more.html
   */
  MORE("more"),

  /*
   * Matrices and Arrays
   */
  /*
   * Array Creation and Concatenation
   */
  /*
   * Construct array with accumulation
   * @see http://www.mathworks.com/matlab/matlab/ref/accumarray.html
   */
  ACCUMARRAY("accumarray"),
  /*
   * Construct block diagonal matrix from input arguments
   * @see http://www.mathworks.com/matlab/matlab/ref/blkdiag.html
   */
  BLKDIAG("blkdiag"),
  /*
   * Get diagonal elements or create diagonal matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/diag.html
   */
  DIAG("diag"),
  /*
   * Identity matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/eye.html
   */
  EYE("eye"),
  /*
   * Logical 0 (false)
   * @see http://www.mathworks.com/matlab/matlab/ref/false.html
   */
  FALSE("false"),
  /*
   * Frequency spacing for frequency response
   * @see http://www.mathworks.com/matlab/matlab/ref/freqspace.html
   */
  FREQSPACE("freqspace"),
  /*
   * Generate linearly spaced vectors
   * @see http://www.mathworks.com/matlab/matlab/ref/linspace.html
   */
  LINSPACE("linspace"),
  /*
   * Generate logarithmically spaced vectors
   * @see http://www.mathworks.com/matlab/matlab/ref/logspace.html
   */
  LOGSPACE("logspace"),
  /*
   * Rectangular grid in 2-D and 3-D space
   * @see http://www.mathworks.com/matlab/matlab/ref/meshgrid.html
   */
  MESHGRID("meshgrid"),
  /*
   * Rectangular grid in N-D space
   * @see http://www.mathworks.com/matlab/matlab/ref/ndgrid.html
   */
  NDGRID("ndgrid"),
  /*
   * Create array of all ones
   * @see http://www.mathworks.com/matlab/matlab/ref/ones.html
   */
  ONES("ones"),
  /*
   * Uniformly distributed pseudorandom numbers
   * @see http://www.mathworks.com/matlab/matlab/ref/rand.html
   */
  RAND("rand"),
  /*
   * Logical 1 (true)
   * @see http://www.mathworks.com/matlab/matlab/ref/true.html
   */
  TRUE("true"),
  /*
   * Create array of all zeros
   * @see http://www.mathworks.com/matlab/matlab/ref/zeros.html
   */
  ZEROS("zeros"),
  /*
   * Concatenate arrays along specified dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/cat.html
   */
  CAT("cat"),
  /*
   * Concatenate arrays horizontally
   * @see http://www.mathworks.com/matlab/matlab/ref/horzcat.html
   */
  HORZCAT("horzcat"),
  /*
   * Concatenate arrays vertically
   * @see http://www.mathworks.com/matlab/matlab/ref/vertcat.html
   */
  VERTCAT("vertcat"),

  /*
   * Indexing
   */
  /*
   * Create vectors, array subscripting, and for-loop iterators
   * @see matlab/ref/colon.html"
  COLON("colon"),
  /*
   * Terminate block of code, or indicate last array index
   * @see http://www.mathworks.com/matlab/matlab/ref/end.html
   */
  END("end"),
  /*
   * Subscripts from linear index
   * @see http://www.mathworks.com/matlab/matlab/ref/ind2sub.html
   */
  IND2SUB("ind2sub"),
  /*
   * Convert subscripts to linear indices
   * @see http://www.mathworks.com/matlab/matlab/ref/sub2ind.html
   */
  SUB2IND("sub2ind"),

  /*
   * Array Dimensions   */
  /*
   * Length of vector or largest array dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/length.html
   */
  LENGTH("length"),
  /*
   * Number of array dimensions
   * @see http://www.mathworks.com/matlab/matlab/ref/ndims.html
   */
  NDIMS("ndims"),
  /*
   * Number of array elements
   * @see http://www.mathworks.com/matlab/matlab/ref/numel.html
   */
  NUMEL("numel"),
  /*
   * Array dimensions
   * @see http://www.mathworks.com/matlab/matlab/ref/size.html
   */
  SIZE("size"),
  /*
   * Number of table rows
   * @see http://www.mathworks.com/matlab/matlab/ref/height.html
   */
  HEIGHT("height"),
  /*
   * Number of table variables
   * @see http://www.mathworks.com/matlab/matlab/ref/width.html
   */
  WIDTH("width"),
  /* 
   * Determine whether input is column vector
   * @see http://www.mathworks.com/matlab/matlab/ref/iscolumn.html
  ISCOLUMN("iscolumn"),
  /*
   * Determine whether array is empty
   * @see http://www.mathworks.com/matlab/matlab/ref/isempty.html
   */
  ISEMPTY("isempty"),
  /*
   * Determine whether input is matrix
   * @see ../matlab/ref/ismatrix.html
   */
  ISMATRIX("ismatrix"),
  /*
   * Determine whether input is row vector
   * @see../matlab/ref/isrow.html
  ISROW("isrow"),
  /*
   * Determine whether input is scalar
   * @see http://www.mathworks.com/matlab/matlab/ref/isscalar.html
   */
  //ISSCALAR("isscalar"),
  /*
   * Determine whether input is vector
   * @see http://www.mathworks.com/matlab/matlab/ref/isvector.html
   */
  //ISVECTOR("isvector"),

  /*
   * Sorting and Reshaping Arrays
   */
  /*
   * Construct block diagonal matrix from input arguments
   * @see http://www.mathworks.com/matlab/matlab/ref/blkdiag.html
   */
//  BLKDIAG("blkdiag"),
  /*
   * Shift array circularly
   * @see http://www.mathworks.com/matlab/matlab/ref/circshift.html
   */
  CIRCSHIFT("circshift"),
  /*
   * Complex conjugate transpose
   * @see http://www.mathworks.com/matlab/matlab/ref/ctranspose.html
   */
  //CTRANSPOSE("ctranspose"),
  /*
   * Get diagonal elements or create diagonal matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/diag.html
   */
//  DIAG("diag"),
  /*
   *  Flip order of elements
   * @see http://www.mathworks.com/matlab/matlab/ref/flip.html
   */
  FLIP("flip"),
  /*
   * Flip array left to right
   * @see http://www.mathworks.com/matlab/matlab/ref/fliplr.html
   */
  FLIPLR("fliplr"),
  /*
   * Flip array up to down
   * @see http://www.mathworks.com/matlab/matlab/ref/flipud.html
   */
  FLIPUD("flipud"),
  /*
   * Inverse permute dimensions of N-D array
   * @see http://www.mathworks.com/matlab/matlab/ref/ipermute.html
   */
  IPERMUTE("ipermute"),
  /*
   * Rearrange dimensions of N-D array
   * @see http://www.mathworks.com/matlab/matlab/ref/permute.html
   */
  PERMUTE("permute"),
  /*
   * Replicate and tile array
   * @see http://www.mathworks.com/matlab/matlab/ref/repmat.html
   */
  REPMAT("repmat"),
  /*
   * Reshape array
   * @see http://www.mathworks.com/matlab/matlab/ref/reshape.html
   */
  RESHAPE("reshape"),
  /*
   * Rotate array 90 degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/rot90.html
   */
  ROT90("rot90"),
  /*
   * Shift dimensions
   * @see http://www.mathworks.com/matlab/matlab/ref/shiftdim.html
   */
  SHIFTDIM("shiftdim"),
  /*
   * Determine whether set elements are in sorted order
   * @see http://www.mathworks.com/matlab/matlab/ref/issorted.html
   */
  ISSORTED("issorted"),
  /*
   * Sort array elements
   * @see http://www.mathworks.com/matlab/matlab/ref/sort.html
   */
  SORT("sort"),
  /*
   * Sort array rows
   * @see http://www.mathworks.com/matlab/matlab/ref/sortrows.html
   */
  SORTROWS("sortrows"),
  /*
   * Remove singleton dimensions
   * @see http://www.mathworks.com/matlab/matlab/ref/squeeze.html
   */
  SQUEEZE("squeeze"),
  /*
   * Transpose
   * @see http://www.mathworks.com/matlab/matlab/ref/transpose.html
   */
  //TRANSPOSE("transpose"),
  /*
   * Vectorize expression
   * @see http://www.mathworks.com/matlab/matlab/ref/vectorize.html
   */
  VECTORIZE("vectorize"),

  /*
   * Operators and Elementary Operations
   */
  /*
   * Arithmetic
   */
  /*
   *  Addition
   * @see http://www.mathworks.com/matlab/matlab/ref/plus.html
   */
  //PLUS("plus"),
  /*
   * Unary plus
   * @see http://www.mathworks.com/matlab/matlab/ref/uplus.html
   */
  //UPLUS("uplus"),
  /*
   * Subtraction
   * @see http://www.mathworks.com/matlab/matlab/ref/minus.html
   */
  //MINUS("minus"),
  /*
   * Unary minus
   * @see http://www.mathworks.com/matlab/matlab/ref/uminus.html
   */
  //UMINUS("uminus"),
  /*
   * Element-wise multiplication
   * @see http://www.mathworks.com/matlab/matlab/ref/times.html
   */
  //TIMES("times"),
  /*
   *  Right array division
   * @see http://www.mathworks.com/matlab/matlab/ref/rdivide.html
   */
  //RDIVIDE("rdivide"),
  /*
   * Left array division
   * @see http://www.mathworks.com/matlab/matlab/ref/ldivide.html
   */
  //LDIVIDE("ldivide"),
  /*
   * Element-wise power
   * @see http://www.mathworks.com/matlab/matlab/ref/power.html
   */
  //POWER("power"),
  /*
   * Matrix Multiplication
   * @see http://www.mathworks.com/matlab/matlab/ref/mtimes.html
   */
  //MTIMES("mtimes"),
  /*
   * Solve systems of linear equations xA = B for x
   * @see http://www.mathworks.com/matlab/matlab/ref/mrdivide.html
   */
  //MRDIVIDE("mrdivide"),
  /*
   * Solve systems of linear equations Ax = B for x
   * @see http://www.mathworks.com/matlab/matlab/ref/mldivide.html
   */
  //MLDIVIDE("mldivide"),
  /*
   * Matrix power
   * @see http://www.mathworks.com/matlab/matlab/ref/mpower.html
   */
  //MPOWER("mpower"),
  /*
   * Cumulative product
   * @see http://www.mathworks.com/matlab/matlab/ref/cumprod.html
   */
  //CUMPROD("cumprod"),
  /*
   * Cumulative sum
   * @see http://www.mathworks.com/matlab/matlab/ref/cumsum.html
   */
  //CUMSUM("cumsum"),
  /*
   * Differences and Approximate Derivatives
   * @see http://www.mathworks.com/matlab/matlab/ref/diff.html
   */
  //DIFF("diff"),
  /*
   * Product of array elements
   * @see http://www.mathworks.com/matlab/matlab/ref/prod.html
   */
  //PROD("prod"),
  /*
   * Sum of array elements
   * @see http://www.mathworks.com/matlab/matlab/ref/sum.html
   */
  //SUM("sum"),
  /*
   * Round toward positive infinity
   * @see http://www.mathworks.com/matlab/matlab/ref/ceil.html
   */
  //CEIL("ceil"),
  /*
   * Round toward zero
   * @see http://www.mathworks.com/matlab/matlab/ref/fix.html
   */
  //FIX("fix"),
  /*
   * Round toward negative infinity
   * @see http://www.mathworks.com/matlab/matlab/ref/floor.html
   */
  //FLOOR("floor"),
  /*
   * Integer division with rounding option
   * @see http://www.mathworks.com/matlab/matlab/ref/idivide.html
   */
  //IDIVIDE("idivide"),
  /*
   * Modulus after division
   * @see http://www.mathworks.com/matlab/matlab/ref/mod.html
   */
  //MOD("mod"),
  /*
   * Remainder after division
   * @see http://www.mathworks.com/matlab/matlab/ref/rem.html
   */
  //REM("rem"),
  /*
   * Round to nearest integer
   * @see http://www.mathworks.com/matlab/matlab/ref/round.html
   */
  //ROUND("round"),

  /*
   * Relational Operations
   * @see ../matlab/ref/relationaloperators.html
   */
  /*
   * Determine equality
   * @see http://www.mathworks.com/matlab/matlab/ref/eq.html
   */
  EQ("eq"),
  /*
   * Determine greater than or equal to
   * @see http://www.mathworks.com/matlab/matlab/ref/ge.html
   */
  GE("ge"),
  /*
   * Determine greater than
   * @see http://www.mathworks.com/matlab/matlab/ref/gt.html
   */
  GT("gt"),
  /*
   * Determine less than or equal to
   * @see http://www.mathworks.com/matlab/matlab/ref/le.html
   */
  LE("le"),
  /*
   * Determine less than
   * @see http://www.mathworks.com/matlab/matlab/ref/lt.html
   */
  LT("lt"),
  /*
   * Determine inequality
   * @see http://www.mathworks.com/matlab/matlab/ref/ne.html
   */
  NE("ne"),
  /*
   * Determine array equality
   * @see http://www.mathworks.com/matlab/matlab/ref/isequal.html
   */
  ISEQUAL("isequal"),
  /*
   * Determine array equality, treating NaN values as equal
   * @see http://www.mathworks.com/matlab/matlab/ref/isequaln.html
   */
  ISEQUALN("isequaln"),

  /*
   * Logical Operations
   */
  /*
   * Logical Operators: Short-circuit
   */
  /*
   * Logical operations with short-circuiting
   * @see http://www.mathworks.com/matlab/matlab/ref/logicaloperatorsshortcircuit.html">
   */
  /*
   * Find logical AND
   * @see http://www.mathworks.com/matlab/matlab/ref/and.html
   */
  ANDAND("&&"),
  /*
   * Find logical AND
   * @see http://www.mathworks.com/matlab/matlab/ref/and.html
   */
  OROR("||"),
  /*
   * Find logical AND
   * @see http://www.mathworks.com/matlab/matlab/ref/and.html
   */
  AND("and"),
  /*
   * Find logical NOT
   * @see http://www.mathworks.com/matlab/matlab/ref/not.html
   */
  NOT("not"),
  /*
   * Find logical OR
   * @see http://www.mathworks.com/matlab/matlab/ref/or.html
   */
  OR("or"),
  /*
   * Logical exclusive-OR
   * @see http://www.mathworks.com/matlab/matlab/ref/xor.html
   */
  XOR("xor"),
  /*
   * Determine if all array elements are nonzero or true
   * @see http://www.mathworks.com/matlab/matlab/ref/all.html
   */
  ALL("all"),
  /*
   * Determine if any array elements are nonzero
   * @see http://www.mathworks.com/matlab/matlab/ref/any.html
   */
  ANY("any"),
  /*
   * Logical 0 (false)
   * @see http://www.mathworks.com/matlab/matlab/ref/false.html
   */
//  FALSE("false"),
  /*
   * Find indices and values of nonzero elements
   * @see http://www.mathworks.com/matlab/matlab/ref/find.html
   */
  //FIND("find"),
  /*
   * Determine if input is logical array
   * @see http://www.mathworks.com/matlab/matlab/ref/islogical.html
   */
  //ISLOGICAL("islogical"),
  /*
   * Convert numeric values to logicals
   * @see http://www.mathworks.com/matlab/matlab/ref/logical.html
   */
  LOGICAL("logical"),
  /*
   * Logical 1 (true)
   * @see http://www.mathworks.com/matlab/matlab/ref/true.html
   */
//  TRUE("true"),

  /*
   * Set Operations   */
  /*
   * Set intersection of two arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/intersect.html
   */
  INTERSECT("intersect"),
  /*
   * Array elements that are members of set array
   * @see http://www.mathworks.com/matlab/matlab/ref/ismember.html
   */
  ISMEMBER("ismember"),
  /*
   * Determine whether set elements are in sorted order
   * @see http://www.mathworks.com/matlab/matlab/ref/issorted.html
   */
  //ISSORTED("issorted"),
  /*
   * Set difference of two arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/setdiff.html
   */
  SETDIFF("setdiff"),
  /*
   * Set exclusive OR of two arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/setxor.html
   */
  SETXOR("setxor"),
  /*
   * Set union of two arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/union.html
   */
  UNION("union"),
  /*
   * Unique values in array
   * @see http://www.mathworks.com/matlab/matlab/ref/unique.html
   */
  UNIQUE("unique"),
  /*
   * Merge two tables by matching up rows using key variables
   * @see http://www.mathworks.com/matlab/matlab/ref/join.html
   */
  JOIN("join"),
  /*
   * Inner join between two tables
   * @see http://www.mathworks.com/matlab/matlab/ref/innerjoin.html
   */
  INNERJOIN("innerjoin"),
  /*
   * Outer join between two tables
   * @see http://www.mathworks.com/matlab/matlab/ref/outerjoin.html
   */
  OUTERJOIN("outerjoin"),

  /*
   * Bit-Wise Operations
   */
  /*
   * Bit-wise AND
   * @see http://www.mathworks.com/matlab/matlab/ref/bitand.html
   */
  BITAND("bitand"),
  /*
   * Bit-wise complement
   * @see http://www.mathworks.com/matlab/matlab/ref/bitcmp.html
   */
  BITCMP("bitcmp"),
  /*
   * Get bit at specified position
   * @see http://www.mathworks.com/matlab/matlab/ref/bitget.html
   */
  BITGET("bitget"),
  /*
   * Bit-wise OR
   * @see http://www.mathworks.com/matlab/matlab/ref/bitor.html
   */
  BITOR("bitor"),
  /*
   * Set bit at specific location
   * @see http://www.mathworks.com/matlab/matlab/ref/bitset.html
   */
  BITSET("bitset"),
  /*
   * Shift bits specified number of places
   * @see http://www.mathworks.com/matlab/matlab/ref/bitshift.html
   */
  BITSHIFT("bitshift"),
  /*
   * Bit-wise XOR
   * @see http://www.mathworks.com/matlab/matlab/ref/bitxor.html
   */
  BITXOR("bitxor"),
  /*
   * Swap byte ordering
   * @see http://www.mathworks.com/matlab/matlab/ref/swapbytes.html
   */
  SWAPBYTES("swapbytes"),

  /*
   * Special Characters
   * @see http://www.mathworks.com/matlab/matlab/ref/specialcharacters.html
   */
  /*
   * Create vectors, array subscripting, and for-loop iterators
   * @see http://www.mathworks.com/matlab/matlab/ref/colon.html
   */
  COLON(":"),
  
  /*
   * Data Types
   */
  /*
   * Numeric Types
   */
  /*
   * Convert to double precision
   * @see http://www.mathworks.com/matlab/matlab/ref/double.html
   */
  DOUBLE("double"),
  /*
   * Convert to single precision
   * @see http://www.mathworks.com/matlab/matlab/ref/single.html
   */
  SINGLE("single"),
  /*
   * Convert to 8-bit signed integer
   * @see http://www.mathworks.com/matlab/matlab/ref/int8.html
   */
  INT8("int8"),
  /*
   * Convert to 16-bit signed integer
   * @see http://www.mathworks.com/matlab/matlab/ref/int16.html
   */
  INT16("int16"),
  /*
   * Convert to 32-bit signed integer
   * @see http://www.mathworks.com/matlab/matlab/ref/int32.html
   */
  INT32("int32"),
  /*
   * Convert to 64-bit signed integer
   * @see http://www.mathworks.com/matlab/matlab/ref/int64.html
   */
  INT64("int64"),
  /*
   * Convert to 8-bit unsigned integer
   * @see http://www.mathworks.com/matlab/matlab/ref/uint8.html
   */
  UINT8("uint8"),
  /*
   * Convert to 16-bit unsigned integer
   * @see http://www.mathworks.com/matlab/matlab/ref/uint16.html
   */
  UINT16("uint16"),
  /*
   * Convert to 32-bit unsigned integer
   * @see http://www.mathworks.com/matlab/matlab/ref/uint32.html
   */
  UINT32("uint32"),
  /*
   * Convert to 64-bit unsigned integer
   * @see http://www.mathworks.com/matlab/matlab/ref/uint64.html
   */
  UINT64("uint64"),
  /*
   * Cast variable to different data type
   * @see http://www.mathworks.com/matlab/matlab/ref/cast.html
   */
  CAST("cast"),
  /*
   * Convert data types without changing underlying data
   * @see http://www.mathworks.com/matlab/matlab/ref/typecast.html
   */
  TYPECAST("typecast"),
  /*
   * Determine if input is integer array
   * @see http://www.mathworks.com/matlab/matlab/ref/isinteger.html
   */
  //ISINTEGER("isinteger"),
  /*
   * Determine if input is floating-point array
   * @see http://www.mathworks.com/matlab/matlab/ref/isfloat.html
   */
  //ISFLOAT("isfloat"),
  /*
   * Determine if input is numeric array
   * @see http://www.mathworks.com/matlab/matlab/ref/isnumeric.html
   */
  //ISNUMERIC("isnumeric"),
  /*
   * Determine if array is real
   * @see http://www.mathworks.com/matlab/matlab/ref/isreal.html
   */
  //ISREAL("isreal"),
  /*
   * Array elements that are finite
   * @see http://www.mathworks.com/matlab/matlab/ref/isfinite.html
   */
  //ISFINITE("isfinite"),
  /*
   * Array elements that are infinite
   * @see http://www.mathworks.com/matlab/matlab/ref/isinf.html
   */
  //ISINF("isinf"),
  /*
   * Array elements that are NaN
   * @see http://www.mathworks.com/matlab/matlab/ref/isnan.html
   */
  //ISNAN("isnan"),
  /*
   * Floating-point relative accuracy
   * @see http://www.mathworks.com/matlab/matlab/ref/eps.html
   */
  //EPS("eps"),
  /*
   * Largest consecutive integer in floating-point format
   * @see http://www.mathworks.com/matlab/matlab/ref/flintmax.html
   */
  //FLINTMAX("flintmax"),
  /*
   * Infinity
   * @see http://www.mathworks.com/matlab/matlab/ref/inf.html
   */
  //INF("inf"),
  /*
   * Largest value of specified integer type
   * @see http://www.mathworks.com/matlab/matlab/ref/intmax.html
   */
  INTMAX("intmax"),
  /*
   * Smallest value of specified integer type
   * @see http://www.mathworks.com/matlab/matlab/ref/intmin.html
   */
  INTMIN("intmin"),
  /*
   * Not-a-Number
   * @see http://www.mathworks.com/matlab/matlab/ref/nan.html
   */
  //NAN("nan"),
  /*
   * Largest positive floating-point number
   * @see http://www.mathworks.com/matlab/matlab/ref/realmax.html
   */
  REALMAX("realmax"),
  /*
   * Smallest positive normalized floating-point number
   * @see http://www.mathworks.com/matlab/matlab/ref/realmin.html
   */
  REALMIN("realmin"),

  /*
   * Characters and Strings
   */
  /*
   * Create and Concatenate Strings
   */
  /*
   * Create string of blank characters
   * @see http://www.mathworks.com/matlab/matlab/ref/blanks.html
   */
  BLANKS("blanks"),
  /*
   * Create cell array of strings from character array
   * @see http://www.mathworks.com/matlab/matlab/ref/cellstr.html
   */
  //CELLSTR("cellstr"),
  /*
   * Convert to character array (string)
   * @see http://www.mathworks.com/matlab/matlab/ref/char.html
   */
  //CHAR("char"),
  /*
   * Determine whether input is cell array of strings
   * @see http://www.mathworks.com/matlab/matlab/ref/iscellstr.html
   */
  //ISCELLSTR("iscellstr"),
  /*
   * Determine whether item is character array
   * @see http://www.mathworks.com/matlab/matlab/ref/ischar.html
   */
  //ISCHAR("ischar"),
  /*
   * Format data into string
   * @see http://www.mathworks.com/matlab/matlab/ref/sprintf.html
   */
  SPRINTF("sprintf"),
  /*
   * Concatenate strings horizontally
   * @see http://www.mathworks.com/matlab/matlab/ref/strcat.html
   */
  STRCAT("strcat"),
  /*
   * Join strings in cell array into single string
   * @see http://www.mathworks.com/matlab/matlab/ref/strjoin.html
   */
  STRJOIN("strjoin"),

  /*
   * Parse Strings
   */
  /*
   * Determine whether item is character array
   * @see http://www.mathworks.com/matlab/matlab/ref/ischar.html
   */
  //ISCHAR("ischar"),
  /*
   * Array elements that are alphabetic letters
   * @see http://www.mathworks.com/matlab/matlab/ref/isletter.html
   */
  ISLETTER("isletter"),
  /*
   * Array elements that are space characters
   * @see http://www.mathworks.com/matlab/matlab/ref/isspace.html
   */
  ISSPACE("isspace"),
  /*
   * Determine whether string is of specified category
   * @see http://www.mathworks.com/matlab/matlab/ref/isstrprop.html
   */
  ISSTRPROP("isstrprop"),
  /*
   * Read formatted data from string
   * @see http://www.mathworks.com/matlab/matlab/ref/sscanf.html
   */
  SSCANF("sscanf"),
  /*
   * Find one string within another
   * @see http://www.mathworks.com/matlab/matlab/ref/strfind.html
   */
  STRFIND("strfind"),
  /*
   * Find and replace substring
   * @see http://www.mathworks.com/matlab/matlab/ref/strrep.html
   */
  STRREP("strrep"),
  /*
   * Split string at specified delimiter
   * @see http://www.mathworks.com/matlab/matlab/ref/strsplit.html
   */
  //STRSPLIT("strsplit"),
  /*
   * Selected parts of string
   * @see http://www.mathworks.com/matlab/matlab/ref/strtok.html
   */
  STRTOK("strtok"),
  /*
   * Check validity of text string
   * @see http://www.mathworks.com/matlab/matlab/ref/validatestring.html
   */
  VALIDATESTRING("validatestring"),
  /*
   * Determine symbolic variables in expression
   * @see http://www.mathworks.com/matlab/matlab/ref/symvar.html
   */
  SYMVAR("symvar"),
  /*
   * Match regular expression (case sensitive)
   * @see http://www.mathworks.com/matlab/matlab/ref/regexp.html
   */
  REGEXP("regexp"),
  /*
   * Match regular expression (case insensitive)
   * @see http://www.mathworks.com/matlab/matlab/ref/regexpi.html
   */
  REGEXPI("regexpi"),
  /*
   * Replace string using regular expression
   * @see http://www.mathworks.com/matlab/matlab/ref/regexprep.html
   */
  REGEXPREP("regexprep"),
  /*
   * Translate string into regular expression
   * @see http://www.mathworks.com/matlab/matlab/ref/regexptranslate.html
   */
  REGEXPTRANSLATE("regexptranslate"),

  /*
   * Compare Strings
   */
  /*
   * Compare strings with case sensitivity
   * @see http://www.mathworks.com/matlab/matlab/ref/strcmp.html
   */
  STRCMP("strcmp"),
  /*
   * Compare strings (case insensitive)
   * @see http://www.mathworks.com/matlab/matlab/ref/strcmpi.html
   */
  STRCMPI("strcmpi"),
  /*
   * Compare first n characters of strings (case sensitive)
   * @see http://www.mathworks.com/matlab/matlab/ref/strncmp.html
   */
  STRNCMP("strncmp"),
  /*
   * Compare first n characters of strings (case insensitive)
   * @see http://www.mathworks.com/matlab/matlab/ref/strncmpi.html
   */
  STRNCMPI("strncmpi"),

  /*
   * Change String Case, Blanks, and Justification
   */
  /*
   * Create string of blank characters
   * @see http://www.mathworks.com/matlab/matlab/ref/blanks.html
   */
  //BLANKS("blanks"),
  /*
   * Strip trailing blanks from end of string
   * @see http://www.mathworks.com/matlab/matlab/ref/deblank.html
   */
  DEBLANK("deblank"),
  /*
   * Remove leading and trailing white space from string
   * @see http://www.mathworks.com/matlab/matlab/ref/strtrim.html
   */
  STRTRIM("strtrim"),
  /*
   * Convert string to lowercase
   * @see http://www.mathworks.com/matlab/matlab/ref/lower.html
   */
  LOWER("lower"),
  /*
   * Convert string to uppercase
   * @see http://www.mathworks.com/matlab/matlab/ref/upper.html
   */
  UPPER("upper"),
  /*
   * Justify character array
   * @see http://www.mathworks.com/matlab/matlab/ref/strjust.html
   */
  STRJUST("strjust"),

  /*
   * Categorical Arrays
   */
  /*
   * Create categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/categorical.html
   */
  CATEGORICAL("categorical"),
  /*
   * Determine whether input is categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/iscategorical.html
   */
  //ISCATEGORICAL("iscategorical"),
  /*
   * Categories of categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/categories.html
   */
  CATEGORIES("categories"),
  /*
   * Test for categorical array categories
   * @see http://www.mathworks.com/matlab/matlab/ref/iscategory.html
   */
  ISCATEGORY("iscategory"),
  /*
   * Determine whether input is ordinal categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/isordinal.html
   */
  ISORDINAL("isordinal"),
  /*
   * Determine whether categories of categorical array are protected
   * @see http://www.mathworks.com/matlab/matlab/ref/isprotected.html
   */
  ISPROTECTED("isprotected"),
  /*
   * Add categories to categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/addcats.html
   */
  ADDCATS("addcats"),
  /*
   * Merge categories in categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/mergecats.html
   */
  MERGECATS("mergecats"),
  /*
   * Remove categories from categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/removecats.html
   */
  REMOVECATS("removecats"),
  /*
   * Rename categories in categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/renamecats.html
   */
  RENAMECATS("renamecats"),
  /*
   * Reorder categories in categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/reordercats.html
   */
  REORDERCATS("reordercats"),
  /*
   * Print summary of table or categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/summary.html
   */
  SUMMARY("summary"),
  /*
   * Count occurrences of categorical array elements by category
   * @see http://www.mathworks.com/matlab/matlab/ref/countcats.html
   */
  COUNTCATS("countcats"),
  /*
   * Find undefined elements in categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/isundefined.html
   */
  ISUNDEFINED("isundefined"),

  /*
   * Tables
   */
  /*
   * Create table from workspace variables
   * @see http://www.mathworks.com/matlab/matlab/ref/table.html
   */
  TABLE("table"),
  /*
   * Convert homogeneous array to table
   * @see http://www.mathworks.com/matlab/matlab/ref/array2table.html
   */
  //ARRAY2TABLE("array2table"),
  /*
   * Convert cell array to table
   * @see http://www.mathworks.com/matlab/matlab/ref/cell2table.html
   */
  //CELL2TABLE("cell2table"),
  /*
   * Convert structure array to table
   * @see http://www.mathworks.com/matlab/matlab/ref/struct2table.html
   */
  //STRUCT2TABLE("struct2table"),
  /*
   * Convert table to homogenous array
   * @see http://www.mathworks.com/matlab/matlab/ref/table2array.html
   */
  //TABLE2ARRAY("table2array"),
  /*
   * Convert table to cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/table2cell.html
   */
  //TABLE2CELL("table2cell"),
  /*
   * Convert table to structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/table2struct.html
   */
  //TABLE2STRUCT("table2struct"),
  /*
   * Create table from file
   * @see http://www.mathworks.com/matlab/matlab/ref/readtable.html
   */
  READTABLE("readtable"),
  /*
   * Write table to file
   * @see http://www.mathworks.com/matlab/matlab/ref/writetable.html
   */
  WRITETABLE("writetable"),
  /*
   * Determine whether input is table
   * @see http://www.mathworks.com/matlab/matlab/ref/istable.html
   */
  //ISTABLE("istable"),
  /*
   * Number of table rows
   * @see http://www.mathworks.com/matlab/matlab/ref/height.html
   */
  //HEIGHT("height"),
  /*
   * Number of table variables
   * @see http://www.mathworks.com/matlab/matlab/ref/width.html
   */
  //WIDTH("width"),
  /*
   * Print summary of table or categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/summary.html
   */
  //SUMMARY("summary"),
  /*
   * Set intersection of two arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/intersect.html
   */
  //INTERSECT("intersect"),
  /*
   * Array elements that are members of set array
   * @see http://www.mathworks.com/matlab/matlab/ref/ismember.html
   */
  //ISMEMBER("ismember"),
  /*
   * Set difference of two arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/setdiff.html
   */
  //SETDIFF("setdiff"),
  /*
   * Set exclusive OR of two arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/setxor.html
   */
  //SETXOR("setxor"),
  /*
   * Unique values in array
   * @see http://www.mathworks.com/matlab/matlab/ref/unique.html
   */
  //UNIQUE("unique"),
  /*
   * Set union of two arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/union.html
   */
  //UNION("union"),
  /*
   * Merge two tables by matching up rows using key variables
   * @see http://www.mathworks.com/matlab/matlab/ref/join.html
   */
  //JOIN("join"),
  /*
   * Inner join between two tables
   * @see http://www.mathworks.com/matlab/matlab/ref/innerjoin.html
   */
  //INNERJOIN("innerjoin"),
  /*
   * Outer join between two tables
   * @see http://www.mathworks.com/matlab/matlab/ref/outerjoin.html
   */
  //OUTERJOIN("outerjoin"),
  /*
   * Sort array rows
   * @see http://www.mathworks.com/matlab/matlab/ref/sortrows.html
   */
  //SORTROWS("sortrows"),
  /*
   * Stack data from multiple variables into single variable
   * @see http://www.mathworks.com/matlab/matlab/ref/stack.html
   */
  STACK("stack"),
  /*
   * Unstack data from single variable into multiple variables
   * @see http://www.mathworks.com/matlab/matlab/ref/unstack.html
   */
  UNSTACK("unstack"),
  /*
   * Find table elements with missing values
   * @see http://www.mathworks.com/matlab/matlab/ref/ismissing.html
   */
  ISMISSING("ismissing"),
  /*
   * Insert missing value indicators into table
   * @see http://www.mathworks.com/matlab/matlab/ref/standardizemissing.html
   */
  STANDARDIZEMISSING("standardizemissing"),
  /*
   * Apply function to table variables
   * @see http://www.mathworks.com/matlab/matlab/ref/varfun.html
   */
  VARFUN("varfun"),
  /*
   * Apply function to table rows
   * @see http://www.mathworks.com/matlab/matlab/ref/rowfun.html
   */
  ROWFUN("rowfun"),

  /*
   * Structures
   */
  /*
   * Create structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/struct.html
   */
  STRUCT("struct"),
  /*
   * Field names of structure, or public fields of object
   * @see http://www.mathworks.com/matlab/matlab/ref/fieldnames.html
   */
  FIELDNAMES("fieldnames"),
  /*
   * Field of structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/getfield.html
   */
  GETFIELD("getfield"),
  /*
   * Determine whether input is structure array field
   * @see http://www.mathworks.com/matlab/matlab/ref/isfield.html
   */
  //ISFIELD("isfield"),
  /*
   * Determine whether input is structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/isstruct.html
   */
  //ISSTRUCT("isstruct"),
  /*
   * Order fields of structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/orderfields.html
   */
  ORDERFIELDS("orderfields"),
  /*
   * Remove fields from structure
   * @see http://www.mathworks.com/matlab/matlab/ref/rmfield.html
   */
  RMFIELD("rmfield"),
  /*
   * Assign values to structure array field
   * @see http://www.mathworks.com/matlab/matlab/ref/setfield.html
   */
  SETFIELD("setfield"),
  /*
   * Apply function to each element of array
   * @see http://www.mathworks.com/matlab/matlab/ref/arrayfun.html
   */
  //ARRAYFUN("arrayfun"),
  /*
   * Apply function to each field of scalar structure
   * @see http://www.mathworks.com/matlab/matlab/ref/structfun.html
   */
  STRUCTFUN("structfun"),
  /*
   * Convert table to structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/table2struct.html
   */
  //TABLE2STRUCT("table2struct"),
  /*
   * Convert structure array to table
   * @see http://www.mathworks.com/matlab/matlab/ref/struct2table.html
   */
  //STRUCT2TABLE("struct2table"),
  /*
   * Convert cell array to structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/cell2struct.html
   */
  //CELL2STRUCT("cell2struct"),
  /*
   * Convert structure to cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/struct2cell.html
   */
  //STRUCT2CELL("struct2cell"),

  /*
   * Cell Arrays
   */
  /*
   * Create cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/cell.html
   */
  CELL("cell"),
  /*
   * Convert cell array to numeric array
   * @see http://www.mathworks.com/matlab/matlab/ref/cell2mat.html
   */
  //CELL2MAT("cell2mat"),
  /*
   * Convert cell array to structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/cell2struct.html
   */
  //CELL2STRUCT("cell2struct"),
  /*
   * Convert cell array to table
   * @see http://www.mathworks.com/matlab/matlab/ref/cell2table.html
   */
  //CELL2TABLE("cell2table"),
  /*
   * Display cell array contents
   * @see http://www.mathworks.com/matlab/matlab/ref/celldisp.html
   */
  CELLDISP("celldisp"),
  /*
   * Apply function to each cell in cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/cellfun.html
   */
  CELLFUN("cellfun"),
  /*
   * Graphically display structure of cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/cellplot.html
   */
  CELLPLOT("cellplot"),
  /*
   * Create cell array of strings from character array
   * @see http://www.mathworks.com/matlab/matlab/ref/cellstr.html
   */
  //CELLSTR("cellstr"),
  /*
   * Determine whether input is cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/iscell.html
   */
  //ISCELL("iscell"),
  /*
   * Determine whether input is cell array of strings
   * @see http://www.mathworks.com/matlab/matlab/ref/iscellstr.html
   */
//  ISCELLSTR("iscellstr"),
  /*
   * Convert array to cell array with potentially different sized cells
   * @see http://www.mathworks.com/matlab/matlab/ref/mat2cell.html">
   */
  //MAT2CELL("mat2cell"),
  /*
   * Convert array to cell array with consistently sized cells
   * @see http://www.mathworks.com/matlab/matlab/ref/num2cell.html
   */
  //NUM2CELL("num2cell"),
  /*
   * Join strings in cell array into single string
   * @see http://www.mathworks.com/matlab/matlab/ref/strjoin.html
   */
  //STRJOIN("strjoin"),
  /*
   * Split string at specified delimiter
   * @see http://www.mathworks.com/matlab/matlab/ref/strsplit.html
   */
  STRSPLIT("strsplit"),
  /*
   * Convert structure to cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/struct2cell.html
   */
  STRUCT2CELL("struct2cell"),
  /*
   * Convert table to cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/table2cell.html
   */
  TABLE2CELL("table2cell"),

  /*
   * Function Handles
   */
  /*
   * Handle used in calling functions indirectly
   * @see http://www.mathworks.com/matlab/matlab/ref/function_handle.html
   */
  FUNCTION_HANDLE("(@)"),
  /*
   * Evaluate function
   * @see http://www.mathworks.com/matlab/matlab/ref/feval.html
   */
  FEVAL("feval"),
  /*
   * Construct function name string from function handle
   * @see http://www.mathworks.com/matlab/matlab/ref/func2str.html
   */
  FUNC2STR("func2str"),
  /*
   * Construct function handle from function name string
   * @see http://www.mathworks.com/matlab/matlab/ref/str2func.html
   */
  STR2FUNC("str2func"),
  /*
   * Function handles to all local functions in MATLAB file
   * @see http://www.mathworks.com/matlab/matlab/ref/localfunctions.html
   */
  LOCALFUNCTIONS("localfunctions"),
  /*
   * Information about function handle
   * @see http://www.mathworks.com/matlab/matlab/ref/functions.html
   */
  FUNCTIONS("functions"),

  /*
   * Map Containers
   */
  /*
   * Map values to unique keys
   * @see http://www.mathworks.com/matlab/matlab/ref/containers.map-class.html
   */
  CONATINERS_MAP("containers.Map"),
  /*
   * Determine if containers.Map object contains key
   * @see http://www.mathworks.com/matlab/matlab/ref/containers.map.iskey.html
   */
   ISKEY("isKey"),
  /*
   * Identify keys of containers.Map object
   * @see http://www.mathworks.com/matlab/matlab/ref/containers.map.keys.html
   */
  KEYS("keys"),
  /*
   * Remove key-value pairs from containers.Map object
   * @see http://www.mathworks.com/matlab/matlab/ref/containers.map.remove.html
   */
  REMOVE("remove"),
  /*
   * Identify values in containers.Map object
   * @see http://www.mathworks.com/matlab/matlab/ref/containers.map.values.html
   */
  VALUES("values"),

  /*
   * Time Series
   */
  /*
   * Time Series Basics
   */
  /*
   * Concatenate time series objects in time dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.append.html
   */
  APPEND("append"),
  /*
   * Query timeseries object property values
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.get.html
   */
  GET("get"),
  /*
   * Size of data sample in timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.getdatasamplesize.html
   */
  GETDATASAMPLESIZE("getdatasamplesize"),
  /*
   * Data quality descriptions
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.getqualitydesc.html
   */
  GETQUALITYDESC("getqualitydesc"),
  /*
   * Subset of time series samples using subscripted index array
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.getsamples.html
   */
  GETSAMPLES("getsamples"),
  /*
   * Plot time series
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.plot.html
   */
//  PLOT("plot"),
  /*
   * Set properties of timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.set.html
   */
  SET("set"),
  /*
   * Construct event object for timeseries object
   * @see matlab/ref/tsdata.event.html
   */
  TSDATA_EVENT("tsdata.event"),
  /*
   * Create timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries-class.html
   */
  TIMESERIES("timeseries"),

  /*
   * Data Manipulation
   */
  /*
   * Add data sample to timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.addsample.html
   */
  ADDSAMPLE("addsample"),
  /*
   * Transpose timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.ctranspose.html
   */
  CTRANSPOSE("ctranspose"),
  /*
   * Remove sample from timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.delsample.html
   */
  DELSAMPLE("delsample"),
  /*
   * Subtract mean or best-fit line and all NaNs from timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.detrend.html
   */
  DETREND("detrend"),
  /*
   * Shape frequency content of time-series
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.filter.html
   */
  FILTER("filter"),
  /*
   * Extract date-string time vector into cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.getabstime.html
   */
  GETABSTIME("getabstime"),
  /*
   * Interpolation method for timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.getinterpmethod.html
   */
  GETINTERPMETHOD("getinterpmethod"),
  /*
   * Extract data samples into new timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.getsampleusingtime.html
   */
  GETSAMPLEUSINGTIME("getsampleusingtime"),
  /*
   * Apply ideal (noncausal) filter to timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.idealfilter.html
   */
  IDEALFILTER("idealfilter"),
  /*
   * Select or interpolate timeseries data using new time vector
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.resample.html
   */
  RESAMPLE("resample"),
  /*
   * Set times of timeseries object as date strings
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.setabstime.html
   */
  SETABSTIME("setabstime"),
  /*
   * Set default interpolation method for timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.setinterpmethod.html
   */
  SETINTERPMETHOD("setinterpmethod"),
  /*
   * Synchronize and resample two timeseries objects using common time vector
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.synchronize.html
   */
  SYNCHRONIZE("synchronize"),
  /*
   * Transpose timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.transpose.html
   */
  TRANSPOSE("transpose"),

  /*
   * Event Data
   */
  /*
   * Add event to timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/addevent.html
   */
  ADDEVENT("addevent"),
  /*
   * Remove tsdata.event objects from timeseries object
   * @see http://www.mathworks.com/matlab/matlab/ref/delevent.html
   */
  DELEVENT("delevent"),
  /*
   * New timeseries object with samples occurring at or after event
   * @see http://www.mathworks.com/matlab/matlab/ref/gettsafteratevent.html
   */
  GETTSAFTERATEVENT("gettsafteratevent"),
  /*
   * New timeseries object with samples occurring after event
   * @see http://www.mathworks.com/matlab/matlab/ref/gettsafterevent.html
   */
  GETTSAFTEREVENT("gettsafterevent"),
  /*
   * New timeseries object with samples occurring at event
   * @see http://www.mathworks.com/matlab/matlab/ref/gettsatevent.html
   */
  GETTSATEVENT("gettsatevent"),
  /*
   * New timeseries object with samples occurring before or at event
   * @see http://www.mathworks.com/matlab/matlab/ref/gettsbeforeatevent.html
   */
  GETTSBEFOREATEVENT("gettsbeforeatevent"),
  /*
   * New timeseries object with samples occurring before event
   * @see http://www.mathworks.com/matlab/matlab/ref/gettsbeforeevent.html
   */
  GETTSBEFOREEVENT("gettsbeforeevent"),
  /*
   * New timeseries object with samples occurring between events
   * @see http://www.mathworks.com/matlab/matlab/ref/gettsbetweenevents.html
   */
  GETTSBETWEENEVENTS("gettsbetweenevents"),

  /*
   * Descriptive Statistics
   */
  /*
   * Interquartile range of timeseries data
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.iqr.html
   */
  IQR("iqr"),
  /*
   * Maximum value of timeseries data
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.max.html
   */
  MAX("max"),
  /*
   * Mean value of timeseries data
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.mean.html
   */
  MEAN("mean"),
  /*
   * Median value of timeseries data
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.median.html
   */
  MEDIAN("median"),
  /*
   *  Minimum value of timeseries  data
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.min.html
   */
  MIN("min"),
  /*
   * Standard deviation of timeseries data
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.std.html
   */
  STD("std"),
  /*
   * Sum of timeseries data
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.sum.html
   */
  SUM("sum"),
  /*
   * Variance of timeseries data
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.var.html
   */
  VAR("var"),

  /*
   * Time Series Collections
   */
  /*
   * Query tscollection object property values
   * @see http://www.mathworks.com/matlab/matlab/ref/gettscollection.html
   */
  GET_TSCOLLECTION("get (tscollection)"),
  /*
   * Determine whether tscollection object is empty
   * @see http://www.mathworks.com/matlab/matlab/ref/isemptytscollection.html
   */
  ISEMPTY_TSCOLLECTION("isempty (tscollection)"),
  /*
   * Length of time vector
   * @see http://www.mathworks.com/matlab/matlab/ref/lengthtscollection.html
   */
  LENGTH_TSCOLLECTION("length (tscollection)"),
  /*
   * Plot time series
   * @see http://www.mathworks.com/matlab/matlab/ref/timeseries.plot.html
   */
//  PLOT("plot"),
  /*
   * Set properties of tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/settscollection.html
   */
  SET_TSCOLLECTION("set (tscollection)"),
  /*
   * Size of tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/sizetscollection.html
   */
  SIZE_TSCOLLECTION("size (tscollection)"),
  /*
   * Create tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/tscollection.html
   */
  TSCOLLECTION("tscollection"),
  /*
   * Add sample to tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/addsampletocollection.html
   */
  ADDSAMPLETOCOLLECTION("addsampletocollection"),
  /*
   * Add timeseries object to tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/addts.html
   */
  ADDTS("addts"),
  /*
   * Remove sample from tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/delsamplefromcollection.html
   */
  DELSAMPLEFROMCOLLECTION("delsamplefromcollection"),
  /*
   * Extract date-string time vector into cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/getabstimetscollection.html
   */
  GETABSTIME_TSCOLLECTION("getabstime (tscollection)"),
  /*
   * Extract data samples into new tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/getsampleusingtimetscollection.html
   */
  GETSAMPLEUSINGTIME_TSCOLLECTION("getsampleusingtime (tscollection)"),
  /*
   * Cell array of names of timeseries objects in tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/gettimeseriesnames.html
   */
  GETTIMESERIESNAMES("gettimeseriesnames"),
  /*
   * Horizontal concatenation for tscollection objects
   * @see http://www.mathworks.com/matlab/matlab/ref/horzcattscollection.html
   */
  HORZCAT_TSCOLLECTION("horzcat (tscollection)"),
  /*
   * Remove timeseries objects from tscollection object
   * @see http://www.mathworks.com/matlab/matlab/ref/removets.html
   */
  REMOVETS("removets"),
  /*
   * Select or interpolate data in tscollection using new time vector
   * @see http://www.mathworks.com/matlab/matlab/ref/resampletscollection.html
   */
  RESAMPLE_TSCOLLECTION("resample (tscollection)"),
  /*
   * Set times of tscollection object as date strings
   * @see http://www.mathworks.com/matlab/matlab/ref/setabstimetscollection.html
   */
  SETABSTIME_TSCOLLECTION("setabstime (tscollection)"),
  /*
   * Change name of timeseries object in tscollection
   * @see http://www.mathworks.com/matlab/matlab/ref/settimeseriesnames.html
   */
  SETTIMESERIESNAMES("settimeseriesnames"),
  /*
   * Vertical concatenation for tscollection objects
   * @see http://www.mathworks.com/matlab/matlab/ref/vertcattscollection.html
   */
  VERTCAT_TSCOLLECTION("vertcat (tscollection)"),

  /*
   * Data Type Identification   */
  /*
   * Detect state
   * @see http://www.mathworks.com/matlab/matlab/ref/is.html
   */
//	  IS*("is*"),
  /*
   * Determine if input is object of specified class
   * @see http://www.mathworks.com/matlab/matlab/ref/isa.html
   */
  ISA("isa"),
  /*
   * Determine whether input is categorical array
   * @see http://www.mathworks.com/matlab/matlab/ref/iscategorical.html
   */
  ISCATEGORICAL("iscategorical"),
  /*
   * Determine whether input is cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/iscell.html
   */
  ISCELL("iscell"),
  /*
   * Determine whether input is cell array of strings
   * @see http://www.mathworks.com/matlab/matlab/ref/iscellstr.html
   */
  ISCELLSTR("iscellstr"),
  /*
   * Determine whether item is character array
   * @see http://www.mathworks.com/matlab/matlab/ref/ischar.html
   */
  ISCHAR("ischar"),
  /*
   * Determine whether input is structure array field
   * @see http://www.mathworks.com/matlab/matlab/ref/isfield.html
   */
  ISFIELD("isfield"),
  /*
   * Determine if input is floating-point array
   * @see http://www.mathworks.com/matlab/matlab/ref/isfloat.html
   */
  ISFLOAT("isfloat"),
  /*
   * True for Handle Graphics object handles
   * @see http://www.mathworks.com/matlab/matlab/ref/ishghandle.html
   */
  ISHGHANDLE("ishghandle"),
  /*
   * Determine if input is integer array
   * @see http://www.mathworks.com/matlab/matlab/ref/isinteger.html
   */
  ISINTEGER("isinteger"),
  /*
   * Determine if input is Java object
   * @see http://www.mathworks.com/matlab/matlab/ref/isjava.html
   */
  ISJAVA("isjava"),
  /*
   * Determine if input is logical array
   * @see http://www.mathworks.com/matlab/matlab/ref/islogical.html
   */
  ISLOGICAL("islogical"),
  /*
   * Determine if input is numeric array
   * @see http://www.mathworks.com/matlab/matlab/ref/isnumeric.html
   */
  ISNUMERIC("isnumeric"),
  /*
   * Determine if input is MATLAB object
   * @see http://www.mathworks.com/matlab/matlab/ref/isobject.html
   */
  ISOBJECT("isobject"),
  /*
   * Determine if array is real
   * @see http://www.mathworks.com/matlab/matlab/ref/isreal.html
   */
  ISREAL("isreal"),
  /*
   * Determine whether input is scalar
   * @see http://www.mathworks.com/matlab/matlab/ref/isscalar.html
   */
  ISSCALAR("isscalar"),
  /*
   * Determine whether input is character array
   * @see http://www.mathworks.com/matlab/matlab/ref/isstr.html
   */
  ISSTR("isstr"),
  /*
   * Determine whether input is structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/isstruct.html
   */
  ISSTRUCT("isstruct"),
  /*
   * Determine whether input is table
   * @see http://www.mathworks.com/matlab/matlab/ref/istable.html
   */
  ISTABLE("istable"),
  /*
   * Determine whether input is vector
   * @see http://www.mathworks.com/matlab/matlab/ref/isvector.html
   */
  ISVECTOR("isvector"),
  /*
   * Determine class of object
   * @see http://www.mathworks.com/matlab/matlab/ref/class.html
   */
  CLASS("class"),
  /*
   * Check validity of array
   * @see http://www.mathworks.com/matlab/matlab/ref/validateattributes.html
   */
  VALIDATEATTRIBUTES("validateattributes"),
  /*
   * List variables in workspace, with sizes and types
   * @see http://www.mathworks.com/matlab/matlab/ref/whos.html
   */
  WHOS("whos"),

  /*
   * Data Type Conversion
   */
  /*
   * Convert to character array (string)
   * @see http://www.mathworks.com/matlab/matlab/ref/char.html
   */
  CHAR("char"),
  /*
   * Convert integer to string
   * @see http://www.mathworks.com/matlab/matlab/ref/int2str.html
   */
  INT2STR("int2str"),
  /*
   * Convert matrix to string
   * @see http://www.mathworks.com/matlab/matlab/ref/mat2str.html
   */
  MAT2STR("mat2str"),
  /*
   * Convert number to string
   * @see http://www.mathworks.com/matlab/matlab/ref/num2str.html
   */
  NUM2STR("num2str"),
  /*
   * Convert string to double-precision value
   * @see http://www.mathworks.com/matlab/matlab/ref/str2double.html
   */
  STR2DOUBLE("str2double"),
  /*
   * Convert string to number
   * @see http://www.mathworks.com/matlab/matlab/ref/str2num.html
   */
  STR2NUM("str2num"),
  /*
   * Convert numeric bytes to Unicode character representation
   * @see http://www.mathworks.com/matlab/matlab/ref/native2unicode.html
   */
  NATIVE2UNICODE("native2unicode"),
  /*
   * Convert Unicode character representation to numeric bytes
   * @see http://www.mathworks.com/matlab/matlab/ref/unicode2native.html
   */
  UNICODE2NATIVE("unicode2native"),
  /*
   * Convert base N number string to decimal number
   * @see http://www.mathworks.com/matlab/matlab/ref/base2dec.html
   */
  BASE2DEC("base2dec"),
  /*
   * Convert binary number string to decimal number
   * @see http://www.mathworks.com/matlab/matlab/ref/bin2dec.html
   */
  BIN2DEC("bin2dec"),
  /*
   * Convert decimal to base N number in string
   * @see http://www.mathworks.com/matlab/matlab/ref/dec2base.html
   */
  DEC2BASE("dec2base"),
  /*
   * Convert decimal to binary number in string
   * @see http://www.mathworks.com/matlab/matlab/ref/dec2bin.html
   */
  DEC2BIN("dec2bin"),
  /*
   * Convert decimal to hexadecimal number in string
   * @see http://www.mathworks.com/matlab/matlab/ref/dec2hex.html
   */
  DEC2HEX("dec2hex"),
  /*
   * Convert hexadecimal number string to decimal number
   * @see http://www.mathworks.com/matlab/matlab/ref/hex2dec.html
   */
  HEX2DEC("hex2dec"),
  /*
   * Convert hexadecimal number string to double-precision number
   * @see http://www.mathworks.com/matlab/matlab/ref/hex2num.html
   */
  HEX2NUM("hex2num"),
  /*
   * Convert singles and doubles to IEEE hexadecimal strings
   * @see http://www.mathworks.com/matlab/matlab/ref/num2hex.html
   */
  NUM2HEX("num2hex"),
  /*
   * Convert table to homogenous array
   * @see http://www.mathworks.com/matlab/matlab/ref/table2array.html
   */
  TABLE2ARRAY("table2array"),
  /*
   * Convert table to cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/table2cell.html
   */
//  TABLE2CELL("table2cell"),
  /*
   * Convert table to structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/table2struct.html
   */
  TABLE2STRUCT("table2struct"),
  /*
   * Convert homogeneous array to table
   * @see http://www.mathworks.com/matlab/matlab/ref/array2table.html
   */
  ARRAY2TABLE("array2table"),
  /*
   * Convert cell array to table
   * @see http://www.mathworks.com/matlab/matlab/ref/cell2table.html
   */
  CELL2TABLE("cell2table"),
  /*
   * Convert structure array to table
   * @see http://www.mathworks.com/matlab/matlab/ref/struct2table.html
   */
  STRUCT2TABLE("struct2table"),
  /*
   * Convert cell array to numeric array
   * @see http://www.mathworks.com/matlab/matlab/ref/cell2mat.html
   */
  CELL2MAT("cell2mat"),
  /*
   * Convert cell array to structure array
   * @see http://www.mathworks.com/matlab/matlab/ref/cell2struct.html
   */
  CELL2STRUCT("cell2struct"),
  /*
   * Create cell array of strings from character array
   * @see http://www.mathworks.com/matlab/matlab/ref/cellstr.html
   */
  CELLSTR("cellstr"),
  /*
   * Convert array to cell array with potentially different sized cells
   * @see http://www.mathworks.com/matlab/matlab/ref/mat2cell.html
   */
  MAT2CELL("mat2cell"),
  /*
   * Convert array to cell array with consistently sized cells
   * @see http://www.mathworks.com/matlab/matlab/ref/num2cell.html
   */
  NUM2CELL("num2cell"),
  /*
   * Convert structure to cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/struct2cell.html
   */
//  STRUCT2CELL("struct2cell"),

  /*
   * Dates and Time
   */
  /*
   * Convert date and time to serial date number
   * @see http://www.mathworks.com/matlab/matlab/ref/datenum.html
   */
  DATENUM("datenum"),
  /*
   * Convert date and time to vector of components
   * @see http://www.mathworks.com/matlab/matlab/ref/datevec.html
   */
  DATEVEC("datevec"),
  /*
   * Convert date and time to string format
   * @see http://www.mathworks.com/matlab/matlab/ref/datestr.html
   */
  DATESTR("datestr"),
  /*
   * Current date and time as serial date number
   * @see http://www.mathworks.com/matlab/matlab/ref/now.html
   */
  NOW("now"),
  /*
   * Current date and time as date vector
   * @see http://www.mathworks.com/matlab/matlab/ref/clock.html
   */
  CLOCK("clock"),
  /*
   * Current date string
   * @see http://www.mathworks.com/matlab/matlab/ref/date.html
   */
  DATE("date"),
  /*
   * Calendar for specified month
   * @see http://www.mathworks.com/matlab/matlab/ref/calendar.html
   */
  CALENDAR("calendar"),
  /*
   * Last day of month
   * @see http://www.mathworks.com/matlab/matlab/ref/eomday.html
   */
  EOMDAY("eomday"),
  /*
   * Day of week
   * @see http://www.mathworks.com/matlab/matlab/ref/weekday.html
   */
  WEEKDAY("weekday"),
  /*
   * Modify date number by field
   * @see http://www.mathworks.com/matlab/matlab/ref/addtodate.html
   */
  ADDTODATE("addtodate"),
  /*
   * Time elapsed between date vectors
   * @see http://www.mathworks.com/matlab/matlab/ref/etime.html
   */
  ETIME("etime"),

  /*
   * Mathematics
   */
  /*
   * Elementary Math
   */
  /*
   * Arithmetic
   */
  /*
   *  Addition
   * @see http://www.mathworks.com/matlab/matlab/ref/plus.html
   */
  PLUS("plus"),
  /*
   * Unary plus
   * @see http://www.mathworks.com/matlab/matlab/ref/uplus.html
   */
  UPLUS("uplus"),
  /*
   * Subtraction
   * @see http://www.mathworks.com/matlab/matlab/ref/minus.html
   */
  MINUS("minus"),
  /*
   * Unary minus
   * @see http://www.mathworks.com/matlab/matlab/ref/uminus.html
   */
  UMINUS("uminus"),
  /*
   * Element-wise multiplication
   * @see http://www.mathworks.com/matlab/matlab/ref/times.html
   */
  TIMES("times"),
  /*
   *  Right array division
   * @see http://www.mathworks.com/matlab/matlab/ref/rdivide.html
   */
  RDIVIDE("rdivide"),
  /*
   * Left array division
   * @see http://www.mathworks.com/matlab/matlab/ref/ldivide.html
   */
  LDIVIDE("ldivide"),
  /*
   * Element-wise power
   * @see http://www.mathworks.com/matlab/matlab/ref/power.html
   */
  POWER("power"),
  /*
   * Matrix Multiplication
   * @see http://www.mathworks.com/matlab/matlab/ref/mtimes.html
   */
  MTIMES("mtimes"),
  /*
   * Solve systems of linear equations xA = B for x
   * @see http://www.mathworks.com/matlab/matlab/ref/mrdivide.html
   */
  MRDIVIDE("mrdivide"),
  /*
   * Solve systems of linear equations Ax = B for x
   * @see http://www.mathworks.com/matlab/matlab/ref/mldivide.html
   */
  MLDIVIDE("mldivide"),
  /*
   * Matrix power
   * @see http://www.mathworks.com/matlab/matlab/ref/mpower.html
   */
  MPOWER("mpower"),
  /*
   * Cumulative product
   * @see http://www.mathworks.com/matlab/matlab/ref/cumprod.html
   */
  CUMPROD("cumprod"),
  /*
   * Cumulative sum
   * @see http://www.mathworks.com/matlab/matlab/ref/cumsum.html
   */
  CUMSUM("cumsum"),
  /*
   * Differences and Approximate Derivatives
   * @see http://www.mathworks.com/matlab/matlab/ref/diff.html
   */
  DIFF("diff"),
  /*
   * Product of array elements
   * @see http://www.mathworks.com/matlab/matlab/ref/prod.html
   */
  PROD("prod"),
  /*
   * Sum of array elements
   * @see http://www.mathworks.com/matlab/matlab/ref/sum.html
   */
//  SUM("sum"),
  /*
   * Round toward positive infinity
   * @see http://www.mathworks.com/matlab/matlab/ref/ceil.html
   */
  CEIL("ceil"),
  /*
   * Round toward zero
   * @see http://www.mathworks.com/matlab/matlab/ref/fix.html
   */
  FIX("fix"),
  /*
   * Round toward negative infinity
   * @see http://www.mathworks.com/matlab/matlab/ref/floor.html
   */
  FLOOR("floor"),
  /*
   * Integer division with rounding option
   * @see http://www.mathworks.com/matlab/matlab/ref/idivide.html
   */
  IDIVIDE("idivide"),
  /*
   * Modulus after division
   * @see http://www.mathworks.com/matlab/matlab/ref/mod.html
   */
  MOD("mod"),
  /*
   * Remainder after division
   * @see http://www.mathworks.com/matlab/matlab/ref/rem.html
   */
  REM("rem"),
  /*
   * Round to nearest integer
   * @see http://www.mathworks.com/matlab/matlab/ref/round.html
   */
  ROUND("round"),

  /*
   * Trigonometry
   */
  /*
   * Sine of argument in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/sin.html
   */
  SIN("sin"),
  /*
   * Sine of argument in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/sind.html
   */
  SIND("sind"),
  /*
   * Inverse sine in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/asin.html
   */
  ASIN("asin"),
  /*
   * Inverse sine in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/asind.html
   */
  ASIND("asind"),
  /*
   * Hyperbolic sine of argument in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/sinh.html
   */
  SINH("sinh"),
  /*
   * Inverse hyperbolic sine
   * @see http://www.mathworks.com/matlab/matlab/ref/asinh.html
   */
  ASINH("asinh"),
  /*
   * Cosine of argument in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/cos.html
   */
  COS("cos"),
  /*
   * Cosine of argument in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/cosd.html
   */
  COSD("cosd"),
  /*
   * Inverse cosine in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/acos.html
   */
  ACOS("acos"),
  /*
   * Inverse cosine in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/acosd.html
   */
  ACOSD("acosd"),
  /*
   * Hyperbolic cosine
   * @see http://www.mathworks.com/matlab/matlab/ref/cosh.html
   */
  COSH("cosh"),
  /*
   * Inverse hyperbolic cosine
   * @see http://www.mathworks.com/matlab/matlab/ref/acosh.html
   */
  ACOSH("acosh"),
  /*
   * Tangent of argument in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/tan.html
   */
  TAN("tan"),
  /*
   * Tangent of argument in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/tand.html
   */
  TAND("tand"),
  /*
   * Inverse tangent in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/atan.html
   */
  ATAN("atan"),
  /*
   * Inverse tangent in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/atand.html
   */
  ATAND("atand"),
  /*
   * Four-quadrant inverse tangent
   * @see http://www.mathworks.com/matlab/matlab/ref/atan2.html
   */
  ATAN2("atan2"),
  /*
   * Four-quadrant inverse tangent in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/atan2d.html
   */
  ATAN2D("atan2d"),
  /*
   * Hyperbolic tangent
   * @see http://www.mathworks.com/matlab/matlab/ref/tanh.html
   */
  TANH("tanh"),
  /*
   * Inverse hyperbolic tangent
   * @see http://www.mathworks.com/matlab/matlab/ref/atanh.html
   */
  ATANH("atanh"),
  /*
   * Cosecant of input angle in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/csc.html
   */
  CSC("csc"),
  /*
   * Cosecant of argument in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/cscd.html
   */
  CSCD("cscd"),
  /*
   * Inverse cosecant in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/acsc.html
   */
  ACSC("acsc"),
  /*
   * Inverse cosecant in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/acscd.html
   */
  ACSCD("acscd"),
  /*
   * Hyperbolic cosecant
   * @see http://www.mathworks.com/matlab/matlab/ref/csch.html
   */
  CSCH("csch"),
  /*
   * Inverse hyperbolic cosecant
   * @see http://www.mathworks.com/matlab/matlab/ref/acsch.html
   */
  ACSCH("acsch"),
  /*
   * Secant of angle in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/sec.html
   */
  SEC("sec"),
  /*
   * Secant of argument in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/secd.html
   */
  SECD("secd"),
  /*
   * Inverse secant in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/asec.html
   */
  ASEC("asec"),
  /*
   * Inverse secant in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/asecd.html
   */
  ASECD("asecd"),
  /*
   * Hyperbolic secant
   * @see http://www.mathworks.com/matlab/matlab/ref/sech.html
   */
  SECH("sech"),
  /*
   * Inverse hyperbolic secant
   * @see http://www.mathworks.com/matlab/matlab/ref/asech.html
   */
  ASECH("asech"),
  /*
   * Cotangent of angle in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/cot.html
   */
  COT("cot"),
  /*
   * Cotangent of argument in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/cotd.html
   */
  COTD("cotd"),
  /*
   * Inverse cotangent in radians
   * @see http://www.mathworks.com/matlab/matlab/ref/acot.html
   */
  ACOT("acot"),
  /*
   * Inverse cotangent in degrees
   * @see http://www.mathworks.com/matlab/matlab/ref/acotd.html
   */
  ACOTD("acotd"),
  /*
   * Hyperbolic cotangent
   * @see http://www.mathworks.com/matlab/matlab/ref/coth.html
   */
  COTH("coth"),
  /*
   * Inverse hyperbolic cotangent
   * @see http://www.mathworks.com/matlab/matlab/ref/acoth.html
   */
  ACOTH("acoth"),
  /*
   * Square root of sum of squares
   * @see http://www.mathworks.com/matlab/matlab/ref/hypot.html
   */
  HYPOT("hypot"),

  /*
   * Exponents and Logarithms
   */
  /*
   * Exponential
   * @see http://www.mathworks.com/matlab/matlab/ref/exp.html
   */
  EXP("exp"),
  /*
   * Compute exp(x)-1 accurately for small values of x
   * @see http://www.mathworks.com/matlab/matlab/ref/expm1.html
   */
  EXPM1("expm1"),
  /*
   * Natural logarithm
   * @see http://www.mathworks.com/matlab/matlab/ref/log.html
   */
  LOG("log"),
  /*
   * Common (base 10) logarithm
   * @see http://www.mathworks.com/matlab/matlab/ref/log10.html
   */
  LOG10("log10"),
  /*
   * Compute log(1+x) accurately for small values of x
   * @see http://www.mathworks.com/matlab/matlab/ref/log1p.html
   */
  LOG1P("log1p"),
  /*
   * Base 2 logarithm and dissect floating-point numbers into exponent and mantissa
   * @see http://www.mathworks.com/matlab/matlab/ref/log2.html
   */
  LOG2("log2"),
  /*
   * Exponent of next higher power of 2
   * @see http://www.mathworks.com/matlab/matlab/ref/nextpow2.html
   */
  NEXTPOW2("nextpow2"),
  /*
   * Real nth root of real numbers
   * @see http://www.mathworks.com/matlab/matlab/ref/nthroot.html
   */
  NTHROOT("nthroot"),
  /*
   * Base 2 power and scale floating-point numbers
   * @see http://www.mathworks.com/matlab/matlab/ref/pow2.html
   */
  POW2("pow2"),
  /*
   * Natural logarithm for nonnegative real arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/reallog.html
   */
  REALLOG("reallog"),
  /*
   * Array power for real-only output
   * @see http://www.mathworks.com/matlab/matlab/ref/realpow.html
   */
  REALPOW("realpow"),
  /*
   * Square root for nonnegative real arrays
   * @see http://www.mathworks.com/matlab/matlab/ref/realsqrt.html
   */
  REALSQRT("realsqrt"),
  /*
   * Square root
   * @see http://www.mathworks.com/matlab/matlab/ref/sqrt.html
   */
  SQRT("sqrt"),

  /*
   * Complex Numbers
   */
  /*
   * Absolute value and complex magnitude
   * @see http://www.mathworks.com/matlab/matlab/ref/abs.html
   */
  ABS("abs"),
  /*
   * Phase angle
   * @see http://www.mathworks.com/matlab/matlab/ref/angle.html
   */
  ANGLE("angle"),
  /*
   * Create complex array
   * @see http://www.mathworks.com/matlab/matlab/ref/complex.html
   */
  COMPLEX("complex"),
  /*
   * Complex conjugate
   * @see http://www.mathworks.com/matlab/matlab/ref/conj.html
   */
  CONJ("conj"),
  /*
   * Sort complex numbers into complex conjugate pairs
   * @see http://www.mathworks.com/matlab/matlab/ref/cplxpair.html
   */
  CPLXPAIR("cplxpair"),
  /*
   * Imaginary unit
   * @see http://www.mathworks.com/matlab/matlab/ref/i.html
   */
  I("i"),
  /*
   * Imaginary part of complex number
   * @see http://www.mathworks.com/matlab/matlab/ref/imag.html
   */
  IMAG("imag"),
  /*
   * Determine if array is real
   * @see http://www.mathworks.com/matlab/matlab/ref/isreal.html
   */
//  ISREAL("isreal"),
  /*
   * Imaginary unit
   * @see http://www.mathworks.com/matlab/matlab/ref/j.html
   */
  J("j"),
  /*
   * Real part of complex number
   * @see http://www.mathworks.com/matlab/matlab/ref/real.html
   */
  REAL("real"),
  /*
   * Signum function
   * @see http://www.mathworks.com/matlab/matlab/ref/sign.html
   */
  SIGN("sign"),
  /*
   * Correct phase angles to produce smoother phase plots
   * @see http://www.mathworks.com/matlab/matlab/ref/unwrap.html
   */
  UNWRAP("unwrap"),

  /*
   * Discrete Math
   */
  /*
   * Prime factors
   * @see http://www.mathworks.com/matlab/matlab/ref/factor.html
   */
  FACTOR("factor"),
  /*
   *  Factorial of input
   * @see http://www.mathworks.com/matlab/matlab/ref/factorial.html
   */
  FACTORIAL("factorial"),
  /*
   * Greatest common divisor
   * @see http://www.mathworks.com/matlab/matlab/ref/gcd.html
   */
  GCD("gcd"),
  /*
   * Determine which array elements are prime
   * @see http://www.mathworks.com/matlab/matlab/ref/isprime.html
   */
  ISPRIME("isprime"),
  /*
   * Least common multiple
   * @see http://www.mathworks.com/matlab/matlab/ref/lcm.html
   */
  LCM("lcm"),
  /*
   * Binomial coefficient or all combinations
   * @see http://www.mathworks.com/matlab/matlab/ref/nchoosek.html
   */
  NCHOOSEK("nchoosek"),
  /*
   * All possible permutations
   * @see http://www.mathworks.com/matlab/matlab/ref/perms.html
   */
  PERMS("perms"),
  /*
   *  Prime numbers less than or equal to input value
   * @see http://www.mathworks.com/matlab/matlab/ref/primes.html
   */
  PRIMES("primes"),
  /*
   * Rational fraction approximation
   * @see http://www.mathworks.com/matlab/matlab/ref/rat.html
   */
  RAT("rat"),
  /*
   * Rational output
   * @see http://www.mathworks.com/matlab/matlab/ref/rats.html
   */
  RATS("rats"),

  /*
   * Polynomials
   */
  /*
   * Polynomial with specified roots
   * @see http://www.mathworks.com/matlab/matlab/ref/poly.html
   */
  POLY("poly"),
  /*
   * Polynomial derivative
   * @see http://www.mathworks.com/matlab/matlab/ref/polyder.html
   */
  POLYDER("polyder"),
  /*
   * Polynomial eigenvalue problem
   * @see http://www.mathworks.com/matlab/matlab/ref/polyeig.html
   */
  POLYEIG("polyeig"),
  /*
   * Polynomial curve fitting
   * @see http://www.mathworks.com/matlab/matlab/ref/polyfit.html
   */
  POLYFIT("polyfit"),
  /*
   * Integrate polynomial analytically
   * @see http://www.mathworks.com/matlab/matlab/ref/polyint.html
   */
  POLYINT("polyint"),
  /*
   * Polynomial evaluation
   * @see http://www.mathworks.com/matlab/matlab/ref/polyval.html
   */
  POLYVAL("polyval"),
  /*
   * Matrix polynomial evaluation
   * @see http://www.mathworks.com/matlab/matlab/ref/polyvalm.html
   */
  POLYVALM("polyvalm"),
  /*
   * Convert between partial fraction expansion and polynomial coefficients
   * @see http://www.mathworks.com/matlab/matlab/ref/residue.html
   */
  RESIDUE("residue"),
  /*
   * Polynomial roots
   * @see http://www.mathworks.com/matlab/matlab/ref/roots.html
   */
  ROOTS("roots"),

  /*
   * Special Functions
   */
  /*
   * Airy Functions
   * @see http://www.mathworks.com/matlab/matlab/ref/airy.html
   */
  AIRY("airy"),
  /*
   * Bessel function of third kind (Hankel function) 
   * @see http://www.mathworks.com/matlab/matlab/ref/besselh.html
   */
  BESSELH("besselh"),
  /*
   * Modified Bessel function of first kind 
   * @see http://www.mathworks.com/matlab/matlab/ref/besseli.html
   */
  BESSELI("besseli"),
  /*
   * Bessel function of first kind
   * @see http://www.mathworks.com/matlab/matlab/ref/besselj.html
   */
  BESSELJ("besselj"),
  /*
   * Modified Bessel function of second kind 
   * @see http://www.mathworks.com/matlab/matlab/ref/besselk.html
   */
  BESSELK("besselk"),
  /*
   * Bessel function of second kind
   * @see http://www.mathworks.com/matlab/matlab/ref/bessely.html
   */
  BESSELY("bessely"),
  /*
   * Beta function
   * @see http://www.mathworks.com/matlab/matlab/ref/beta.html
   */
  BETA("beta"),
  /*
   * Incomplete beta function
   * @see http://www.mathworks.com/matlab/matlab/ref/betainc.html
   */
  BETAINC("betainc"),
  /*
   * Beta inverse cumulative distribution function
   * @see http://www.mathworks.com/matlab/matlab/ref/betaincinv.html
   */
  BETAINCINV("betaincinv"),
  /*
   * Logarithm of beta function
   * @see http://www.mathworks.com/matlab/matlab/ref/betaln.html
   */
  BETALN("betaln"),
  /*
   * Jacobi elliptic functions
   * @see http://www.mathworks.com/matlab/matlab/ref/ellipj.html
   */
  ELLIPJ("ellipj"),
  /*
   * Complete elliptic integrals of first and second kind
   * @see http://www.mathworks.com/matlab/matlab/ref/ellipke.html
   */
  ELLIPKE("ellipke"),
  /*
   * Error function
   * @see http://www.mathworks.com/matlab/matlab/ref/erf.html
   */
  ERF("erf"),
  /*
   * Complementary error function
   * @see http://www.mathworks.com/matlab/matlab/ref/erfc.html
   */
  ERFC("erfc"),
  /*
   * Inverse complementary error function
   * @see http://www.mathworks.com/matlab/matlab/ref/erfcinv.html
   */
  ERFCINV("erfcinv"),
  /*
   * Scaled complementary error function
   * @see http://www.mathworks.com/matlab/matlab/ref/erfcx.html
   */
  ERFCX("erfcx"),
  /*
   * Inverse error function
   * @see http://www.mathworks.com/matlab/matlab/ref/erfinv.html
   */
  ERFINV("erfinv"),
  /*
   * Exponential integral
   * @see http://www.mathworks.com/matlab/matlab/ref/expint.html
   */
  EXPINT("expint"),
  /*
   * Gamma function
   * @see http://www.mathworks.com/matlab/matlab/ref/gamma.html
   */
  GAMMA("gamma"),
  /*
   * Incomplete gamma function
   * @see http://www.mathworks.com/matlab/matlab/ref/gammainc.html
   */
  GAMMAINC("gammainc"),
  /*
   * Inverse incomplete gamma function
   * @see http://www.mathworks.com/matlab/matlab/ref/gammaincinv.html
   */
  GAMMAINCINV("gammaincinv"),
  /*
   * Logarithm of gamma function
   * @see http://www.mathworks.com/matlab/matlab/ref/gammaln.html
   */
  GAMMALN("gammaln"),
  /*
   * Associated Legendre functions
   * @see http://www.mathworks.com/matlab/matlab/ref/legendre.html
   */
  LEGENDRE("legendre"),
  /*
   * Psi (polygamma) function
   * @see http://www.mathworks.com/matlab/matlab/ref/psi.html
   */
  PSI("psi"),

  /*
   * Cartesian Coordinate System Conversion
   */
  /*
   * Transform Cartesian coordinates to polar or cylindrical
   * @see http://www.mathworks.com/matlab/matlab/ref/cart2pol.html
   */
  CART2POL("cart2pol"),
  /*
   * Transform Cartesian coordinates to spherical
   * @see http://www.mathworks.com/matlab/matlab/ref/cart2sph.html
   */
  CART2SPH("cart2sph"),
  /*
   * Transform polar or cylindrical coordinates to Cartesian
   * @see http://www.mathworks.com/matlab/matlab/ref/pol2cart.html
   */
  POL2CART("pol2cart"),
  /*
   * Transform spherical coordinates to Cartesian
   * @see http://www.mathworks.com/matlab/matlab/ref/sph2cart.html
   */
  SPH2CART("sph2cart"),

  /*
   * Constants and Test Matrices
   */
  /*
   * Floating-point relative accuracy
   * @see http://www.mathworks.com/matlab/matlab/ref/eps.html
   */
  EPS("eps"),
  /*
   * Largest consecutive integer in floating-point format
   * @see http://www.mathworks.com/matlab/matlab/ref/flintmax.html
   */
  FLINTMAX("flintmax"),
  /*
   * Imaginary unit
   * @see http://www.mathworks.com/matlab/matlab/ref/i.html
   */
//  I("i"),
  /*
   * Imaginary unit
   * @see http://www.mathworks.com/matlab/matlab/ref/j.html
   */
//  J("j"),
  /*
   * Infinity
   * @see http://www.mathworks.com/matlab/matlab/ref/inf.html
   */
  INF("inf"),
  /*
   * Ratio of circle's circumference to its diameter
   * @see http://www.mathworks.com/matlab/matlab/ref/pi.html
   */
  PI("pi"),
  /*
   * Not-a-Number
   * @see http://www.mathworks.com/matlab/matlab/ref/nan.html
   */
  NAN("nan"),
  /*
   * Array elements that are finite
   * @see http://www.mathworks.com/matlab/matlab/ref/isfinite.html
   */
  ISFINITE("isfinite"),
  /*
   * Array elements that are infinite
   * @see http://www.mathworks.com/matlab/matlab/ref/isinf.html
   */
  ISINF("isinf"),
  /*
   * Array elements that are NaN
   * @see http://www.mathworks.com/matlab/matlab/ref/isnan.html
   */
  ISNAN("isnan"),
  /*
   * Companion matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/compan.html
   */
  COMPAN("compan"),
  /*
   * Test matrices
   * @see http://www.mathworks.com/matlab/matlab/ref/gallery.html
   */
  GALLERY("gallery"),
  /*
   * Hadamard matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/hadamard.html
   */
  HADAMARD("hadamard"),
  /*
   * Hankel matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/hankel.html
   */
  HANKEL("hankel"),
  /*
   * Hilbert matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/hilb.html
   */
  HILB("hilb"),
  /*
   * Inverse of Hilbert matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/invhilb.html
   */
  INVHILB("invhilb"),
  /*
   * Magic square
   * @see http://www.mathworks.com/matlab/matlab/ref/magic.html
   */
  MAGIC("magic"),
  /*
   * Pascal matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/pascal.html
   */
  PASCAL("pascal"),
  /*
   * Classic symmetric eigenvalue test problem
   * @see http://www.mathworks.com/matlab/matlab/ref/rosser.html
   */
  ROSSER("rosser"),
  /*
   * Toeplitz matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/toeplitz.html
   */
  TOEPLITZ("toeplitz"),
  /*
   * Vandermonde matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/vander.html
   */
  VANDER("vander"),
  /*
   * Wilkinson's eigenvalue test matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/wilkinson.html
   */
  WILKINSON("wilkinson"),

  /*
   * Linear Algebra
   */
  /*
   * Matrix Operations   */
  /*
   * Cross product
   * @see http://www.mathworks.com/matlab/matlab/ref/cross.html
   */
  CROSS("cross"),
  /*
   * Dot product
   * @see http://www.mathworks.com/matlab/matlab/ref/dot.html
   */
  DOT("dot"),
  /*
   * Kronecker tensor product
   * @see http://www.mathworks.com/matlab/matlab/ref/kron.html
   */
  KRON("kron"),
  /*
   * Compute and display 3-D surface normals
   * @see http://www.mathworks.com/matlab/matlab/ref/surfnorm.html
   */
  SURFNORM("surfnorm"),
  /*
   * Lower triangular part of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/tril.html
   */
  TRIL("tril"),
  /*
   * Upper triangular part of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/triu.html
   */
  TRIU("triu"),
  /*
   * Transpose
   * @see http://www.mathworks.com/matlab/matlab/ref/transpose.html
   */
//  TRANSPOSE("transpose"),

  /*
   * Linear Equations
   */
  /*
   * Condition number with respect to inversion
   * @see http://www.mathworks.com/matlab/matlab/ref/cond.html
   */
  COND("cond"),
  /*
   * 1-norm condition number estimate
   * @see http://www.mathworks.com/matlab/matlab/ref/condest.html
   */
  CONDEST("condest"),
  /*
   * Evaluate general matrix function
   * @see http://www.mathworks.com/matlab/matlab/ref/funm.html
   */
  FUNM("funm"),
  /*
   * Matrix inverse
   * @see http://www.mathworks.com/matlab/matlab/ref/inv.html
   */
  INV("inv"),
  /*
   * Solve linear system of equations
   * @see http://www.mathworks.com/matlab/matlab/ref/linsolve.html
   */
  LINSOLVE("linsolve"),
  /*
   * Least-squares solution in presence of known covariance
   * @see http://www.mathworks.com/matlab/matlab/ref/lscov.html
   */
  LSCOV("lscov"),
  /*
   * Solve nonnegative least-squares constraints problem
   * @see http://www.mathworks.com/matlab/matlab/ref/lsqnonneg.html
   */
  LSQNONNEG("lsqnonneg"),
  /*
   * Moore-Penrose pseudoinverse of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/pinv.html
   */
  PINV("pinv"),
  /*
   * Reciprocal condition number
   * @see http://www.mathworks.com/matlab/matlab/ref/rcond.html
   */
  RCOND("rcond"),
  /*
   * Solve Sylvester equation AX + XB = C for X
   * @see http://www.mathworks.com/matlab/matlab/ref/sylvester.html
   */
  SYLVESTER("sylvester"),
  /*
   * Solve systems of linear equations Ax = B for x
   * @see http://www.mathworks.com/matlab/matlab/ref/mldivide.html
   */
//  MLDIVIDE("mldivide"),
  /*
   * Solve systems of linear equations xA = B for x
   * @see http://www.mathworks.com/matlab/matlab/ref/mrdivide.html
   */
//  MRDIVIDE("mrdivide"),

  /*
   * Matrix Decomposition
   */
  /*
   * Cholesky factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/chol.html
   */
  CHOL("chol"),
  /*
   * Incomplete Cholesky factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/ichol.html
   */
  ICHOL("ichol"),
  /*
   * Rank 1 update to Cholesky factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/cholupdate.html
   */
  CHOLUPDATE("cholupdate"),
  /*
   * Sparse incomplete LU factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/ilu.html
   */
  ILU("ilu"),
  /*
   * LU matrix factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/lu.html
   */
  LU("lu"),
  /*
   * Orthogonal-triangular decomposition
   * @see http://www.mathworks.com/matlab/matlab/ref/qr.html
   */
  QR("qr"),
  /*
   * Remove column or row from QR factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/qrdelete.html
   */
  QRDELETE("qrdelete"),
  /*
   * Insert column or row into QR factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/qrinsert.html
   */
  QRINSERT("qrinsert"),
  /*
   * Rank 1 update to QR factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/qrupdate.html
   */
  QRUPDATE("qrupdate"),
  /*
   * Givens plane rotation
   * @see http://www.mathworks.com/matlab/matlab/ref/planerot.html
   */
  PLANEROT("planerot"),
  /*
   *  Block LDL' factorization for Hermitian indefinite matrices
   * @see http://www.mathworks.com/matlab/matlab/ref/ldl.html
   */
  LDL("ldl"),
  /*
   * Convert complex diagonal form to real block diagonal form
   * @see http://www.mathworks.com/matlab/matlab/ref/cdf2rdf.html
   */
  CDF2RDF("cdf2rdf"),
  /*
   * Convert real Schur form to complex Schur form
   * @see http://www.mathworks.com/matlab/matlab/ref/rsf2csf.html
   */
  RSF2CSF("rsf2csf"),
  /*
   * Generalized singular value decomposition
   * @see http://www.mathworks.com/matlab/matlab/ref/gsvd.html
   */
  GSVD("gsvd"),
  /*
   * Singular value decomposition
   * @see http://www.mathworks.com/matlab/matlab/ref/svd.html
   */
  SVD("svd"),

  /*
   * Eigenvalues and Singular Values
   */
  /*
   * Diagonal scaling to improve eigenvalue accuracy
   * @see http://www.mathworks.com/matlab/matlab/ref/balance.html
   */
  BALANCE("balance"),
  /*
   * Convert complex diagonal form to real block diagonal form
   * @see http://www.mathworks.com/matlab/matlab/ref/cdf2rdf.html
   */
//  CDF2RDF("cdf2rdf"),
  /*
   * Condition number with respect to eigenvalues
   * @see http://www.mathworks.com/matlab/matlab/ref/condeig.html
   */
  CONDEIG("condeig"),
  /*
   * Eigenvalues and eigenvectors
   * @see http://www.mathworks.com/matlab/matlab/ref/eig.html
   */
  EIG("eig"),
  /*
   * Largest eigenvalues and eigenvectors of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/eigs.html
   */
  EIGS("eigs"),
  /*
   * Generalized singular value decomposition
   * @see http://www.mathworks.com/matlab/matlab/ref/gsvd.html
   */
//  GSVD("gsvd"),
  /*
   * Hessenberg form of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/hess.html
   */
  HESS("hess"),
  /*
   * Eigenvalues of quasitriangular matrices
   * @see http://www.mathworks.com/matlab/matlab/ref/ordeig.html
   */
  ORDEIG("ordeig"),
  /*
   * Reorder eigenvalues in QZ factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/ordqz.html
   */
  ORDQZ("ordqz"),
  /*
   * Reorder eigenvalues in Schur factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/ordschur.html
   */
  ORDSCHUR("ordschur"),
  /*
   * Polynomial with specified roots
   * @see http://www.mathworks.com/matlab/matlab/ref/poly.html
   */
//  POLY("poly"),
  /*
   * Polynomial eigenvalue problem
   * @see http://www.mathworks.com/matlab/matlab/ref/polyeig.html
   */
//  POLYEIG("polyeig"),
  /*
   * QZ factorization for generalized eigenvalues
   * @see http://www.mathworks.com/matlab/matlab/ref/qz.html
   */
  QZ("qz"),
  /*
   * Convert real Schur form to complex Schur form
   * @see http://www.mathworks.com/matlab/matlab/ref/rsf2csf.html
   */
//  RSF2CSF("rsf2csf"),
  /*
   * Schur decomposition
   * @see http://www.mathworks.com/matlab/matlab/ref/schur.html
   */
  SCHUR("schur"),
  /*
   * Matrix square root
   * @see http://www.mathworks.com/matlab/matlab/ref/sqrtm.html
   */
  SQRTM("sqrtm"),
  /*
   * Convert state-space filter parameters to transfer function form
   * @see http://www.mathworks.com/matlab/matlab/ref/ss2tf.html
   */
  SS2TF("ss2tf"),
  /*
   * Singular value decomposition
   * @see http://www.mathworks.com/matlab/matlab/ref/svd.html
   */
//  SVD("svd"),
  /*
   * Find singular values and vectors
   * @see http://www.mathworks.com/matlab/matlab/ref/svds.html
   */
  SVDS("svds"),

  /*
   * Matrix Analysis
   */
  /*
   * Lower and upper matrix bandwidth
   * @see http://www.mathworks.com/matlab/matlab/ref/bandwidth.html
   */
  BANDWIDTH("bandwidth"),
  /*
   * Condition number with respect to inversion
   * @see http://www.mathworks.com/matlab/matlab/ref/cond.html
   */
//  COND("cond"),
  /*
   * Condition number with respect to eigenvalues
   * @see http://www.mathworks.com/matlab/matlab/ref/condeig.html
   */
//  CONDEIG("condeig"),
  /*
   * Matrix determinant
   * @see http://www.mathworks.com/matlab/matlab/ref/det.html
   */
  DET("det"),
  /*
   * Determine if matrix is within specific bandwidth
   * @see http://www.mathworks.com/matlab/matlab/ref/isbanded.html
   */
  ISBANDED("isbanded"),
  /*
   * Determine if matrix is diagonal
   * @see http://www.mathworks.com/matlab/matlab/ref/isdiag.html
   */
  ISDIAG("isdiag"),
  /*
   * Determine if matrix is Hermitian or skew-Hermitian
   * @see http://www.mathworks.com/matlab/matlab/ref/ishermitian.html
   */
  ISHERMITIAN("ishermitian"),
  /*
   * Determine if matrix is symmetric or skew-symmetric
   * @see http://www.mathworks.com/matlab/matlab/ref/issymmetric.html
   */
  ISSYMMETRIC("issymmetric"),
  /*
   * Determine if matrix is lower triangular
   * @see http://www.mathworks.com/matlab/matlab/ref/istril.html
   */
  ISTRIL("istril"),
  /*
   * Determine if matrix is upper triangular
   * @see http://www.mathworks.com/matlab/matlab/ref/istriu.html
   */
  ISTRIU("istriu"),
  /*
   * Vector and matrix norms
   * @see http://www.mathworks.com/matlab/matlab/ref/norm.html
   */
  NORM("norm"),
  /*
   * 2-norm estimate
   * @see http://www.mathworks.com/matlab/matlab/ref/normest.html
   */
  NORMEST("normest"),
  /*
   * Null space 
   * @see http://www.mathworks.com/matlab/matlab/ref/null.html
   */
  NULL("null"),
  /*
   * Orthonormal basis for range of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/orth.html
   */
  ORTH("orth"),
  /*
   * Rank of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/rank.html
   */
  RANK("rank"),
  /*
   * Reciprocal condition number
   * @see http://www.mathworks.com/matlab/matlab/ref/rcond.html
   */
//  RCOND("rcond"),
  /*
   * Reduced row echelon form
   * @see http://www.mathworks.com/matlab/matlab/ref/rref.html
   */
  RREF("rref"),
  /*
   * Angle between two subspaces
   * @see http://www.mathworks.com/matlab/matlab/ref/subspace.html
   */
  SUBSPACE("subspace"),
  /*
   * Sum of diagonal elements
   * @see http://www.mathworks.com/matlab/matlab/ref/trace.html
   */
  TRACE("trace"),

  /*
   * Matrix Functions
   */
  /*
   * Matrix exponential
   * @see http://www.mathworks.com/matlab/matlab/ref/expm.html
   */
  EXPM("expm"),
  /*
   * Matrix logarithm
   * @see http://www.mathworks.com/matlab/matlab/ref/logm.html
   */
  LOGM("logm"),
  /*
   * Matrix square root
   * @see http://www.mathworks.com/matlab/matlab/ref/sqrtm.html
   */
//  SQRTM("sqrtm"),
  /*
   * Apply element-by-element binary operation to two arrays with singleton expansion enabled
   * @see http://www.mathworks.com/matlab/matlab/ref/bsxfun.html
   */
  BSXFUN("bsxfun"),
  /*
   * Apply function to each element of array
   * @see http://www.mathworks.com/matlab/matlab/ref/arrayfun.html
   */
  ARRAYFUN("arrayfun"),
  /*
   * Construct array with accumulation
   * @see http://www.mathworks.com/matlab/matlab/ref/accumarray.html
   */
//  ACCUMARRAY("accumarray"),
  /*
   * Matrix power
   * @see http://www.mathworks.com/matlab/matlab/ref/mpower.html
   */
//  MPOWER("mpower"),

  /*
   * Statistics and Random Numbers
   */
  /*
   * Descriptive Statistics   */
  /*
   * Correlation coefficients
   * @see http://www.mathworks.com/matlab/matlab/ref/corrcoef.html
   */
  CORRCOEF("corrcoef"),
  /*
   * Covariance matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/cov.html
   */
  COV("cov"),
  /*
   * Largest elements in array
   * @see http://www.mathworks.com/matlab/matlab/ref/max.html
   */
//  MAX("max"),
  /*
   * Average or mean value of array
   * @see http://www.mathworks.com/matlab/matlab/ref/mean.html
   */
//  MEAN("mean"),
  /*
   * Median value of array
   * @see http://www.mathworks.com/matlab/matlab/ref/median.html
   */
//  MEDIAN("median"),
  /*
   * Smallest elements in array
   * @see http://www.mathworks.com/matlab/matlab/ref/min.html
   */
//  MIN("min"),
  /*
   * Most frequent values in array
   * @see http://www.mathworks.com/matlab/matlab/ref/mode.html
   */
  MODE("mode"),
  /*
   * Standard deviation
   * @see http://www.mathworks.com/matlab/matlab/ref/std.html
   */
//  STD("std"),
  /*
   * Variance
   * @see http://www.mathworks.com/matlab/matlab/ref/var.html
   */
//  VAR("var"),

  /*
   * Random Number Generation
   */
  /*
   * Uniformly distributed pseudorandom numbers
   * @see http://www.mathworks.com/matlab/matlab/ref/rand.html
   */
//  RAND("rand"),
  /*
   * Normally distributed pseudorandom numbers
   * @see http://www.mathworks.com/matlab/matlab/ref/randn.html
   */
  RANDN("randn"),
  /*
   * Uniformly distributed pseudorandom integers
   * @see http://www.mathworks.com/matlab/matlab/ref/randi.html
   */
  RANDI("randi"),
  /*
   * Random permutation 
   * @see http://www.mathworks.com/matlab/matlab/ref/randperm.html
   */
  RANDPERM("randperm"),
  /*
   * Control random number generation
   * @see http://www.mathworks.com/matlab/matlab/ref/rng.html
   */
  RNG("rng"),
  /*
   * Random number stream
   * @see http://www.mathworks.com/matlab/matlab/ref/randstream.randstream.html
   */
  RANDSTREAM("randstream"),

  /*
   * Interpolation
   */
  /*
   * 1-D Interpolation
   */
  /*
   * 1-D data interpolation (table lookup)
   * @see http://www.mathworks.com/matlab/matlab/ref/interp1.html
   */
  INTERP1("interp1"),
  /*
   * Gridded data interpolation
   * @see http://www.mathworks.com/matlab/matlab/ref/griddedinterpolant-class.html
   */
  GRIDDEDINTERPOLANT("griddedinterpolant"),
  /*
   * Piecewise Cubic Hermite Interpolating Polynomial (PCHIP)
   * @see http://www.mathworks.com/matlab/matlab/ref/pchip.html
   */
  PCHIP("pchip"),
  /*
   * Cubic spline data interpolation
   * @see http://www.mathworks.com/matlab/matlab/ref/spline.html
   */
  SPLINE("spline"),
  /*
   * Evaluate piecewise polynomial
   * @see http://www.mathworks.com/matlab/matlab/ref/ppval.html
   */
  PPVAL("ppval"),
  /*
   * Make piecewise polynomial
   * @see http://www.mathworks.com/matlab/matlab/ref/mkpp.html
   */
  MKPP("mkpp"),
  /*
   * Piecewise polynomial details
   * @see http://www.mathworks.com/matlab/matlab/ref/unmkpp.html
   */
  UNMKPP("unmkpp"),
  /*
   * Pad&eacute; approximation of time delays
   * @see http://www.mathworks.com/matlab/matlab/ref/padecoef.html
   */
  PADECOEF("padecoef"),
  /*
   * 1-D interpolation using FFT method
   * @see http://www.mathworks.com/matlab/matlab/ref/interpft.html
   */
  INTERPFT("interpft"),

  /*
   * Gridded Data Interpolation
   */
  /*
   * Interpolation for 2-D gridded data in meshgrid format
   * @see http://www.mathworks.com/matlab/matlab/ref/interp2.html
   */
  INTERP2("interp2"),
  /*
   * Interpolation for 3-D gridded data in meshgrid format
   * @see http://www.mathworks.com/matlab/matlab/ref/interp3.html
   */
  INTERP3("interp3"),
  /*
   * Interpolation for 1-D, 2-D, 3-D, and N-D gridded data in ndgrid format
   * @see http://www.mathworks.com/matlab/matlab/ref/interpn.html
   */
  INTERPN("interpn"),
  /*
   * Gridded data interpolation
   * @see http://www.mathworks.com/matlab/matlab/ref/griddedinterpolant-class.html
   */
//  GRIDDEDINTERPOLANT("griddedinterpolant"),
  /*
   * Rectangular grid in N-D space
   * @see http://www.mathworks.com/matlab/matlab/ref/ndgrid.html
   */
//  NDGRID("ndgrid"),
  /*
   * Rectangular grid in 2-D and 3-D space
   * @see http://www.mathworks.com/matlab/matlab/ref/meshgrid.html
   */
//  MESHGRID("meshgrid"),

  /*
   * Scattered Data Interpolation
   */
  /*
   * Interpolate scattered data
   * @see http://www.mathworks.com/matlab/matlab/ref/griddata.html
   */
  GRIDDATA("griddata"),
  /*
   * Data gridding and hypersurface fitting (dimension &#8805;2)
   * @see http://www.mathworks.com/matlab/matlab/ref/griddatan.html
   */
  GRIDDATAN("griddatan"),
  /*
   * Scattered data interpolation
   * @see http://www.mathworks.com/matlab/matlab/ref/scatteredinterpolant-class.html
   */
  SCATTEREDINTERPOLANT("scatteredinterpolant"),

  /*
   * Optimization
   */
  /*
   * Find minimum of single-variable function on fixed interval
   * @see http://www.mathworks.com/matlab/matlab/ref/fminbnd.html
   */
  FMINBND("fminbnd"),
  /*
   * Find minimum of unconstrained multivariable function using derivative-free method
   * @see http://www.mathworks.com/matlab/matlab/ref/fminsearch.html
   */
  FMINSEARCH("fminsearch"),
  /*
   * Root of nonlinear function
   * @see http://www.mathworks.com/matlab/matlab/ref/fzero.html
   */
  FZERO("fzero"),
  /*
   * Solve nonnegative least-squares constraints problem
   * @see http://www.mathworks.com/matlab/matlab/ref/lsqnonneg.html
   */
//  LSQNONNEG("lsqnonneg"),
  /*
   * Optimization options values
   * @see http://www.mathworks.com/matlab/matlab/ref/optimget.html
   */
  OPTIMGET("optimget"),
  /*
   * Create or edit optimization options structure
   * @see http://www.mathworks.com/matlab/matlab/ref/optimset.html
   */
  OPTIMSET("optimset"),

  /*
   * Numerical Integration and Differential Equations
   */
  /*
   * Ordinary Differential Equations
   */
  /*
   * Solve nonstiff differential equations; medium order method
   * @see http://www.mathworks.com/matlab/matlab/ref/ode45.html
   */
  ODE45("ode45"),
  /*
   * Solve stiff differential equations and DAEs; variable order method
   * @see http://www.mathworks.com/matlab/matlab/ref/ode15s.html
   */
  ODE15S("ode15s"),
  /*
   * Solve nonstiff differential equations; low order method
   * @see http://www.mathworks.com/matlab/matlab/ref/ode23.html
   */
  ODE23("ode23"),
  /*
   * Solve nonstiff differential equations; variable order method
   * @see http://www.mathworks.com/matlab/matlab/ref/ode113.html
   */
  ODE113("ode113"),
  /*
   * Solve moderately stiff ODEs and DAEs; trapezoidal rule
   * @see http://www.mathworks.com/matlab/matlab/ref/ode23t.html
   */
  ODE23T("ode23t"),
  /*
   * Solve stiff differential equations; low order method
   * @see http://www.mathworks.com/matlab/matlab/ref/ode23tb.html
   */
  ODE23TB("ode23tb"),
  /*
   * Solve stiff differential equations; low order method
   * @see http://www.mathworks.com/matlab/matlab/ref/ode23s.html
   */
  ODE23S("ode23s"),
  /*
   * Solve fully implicit differential equations, variable order method
   * @see http://www.mathworks.com/matlab/matlab/ref/ode15i.html
   */
  ODE15I("ode15i"),
  /*
   * Compute consistent initial conditions for ode15i
   * @see http://www.mathworks.com/matlab/matlab/ref/decic.html
   */
  DECIC("decic"),
  /*
   * Extend solution of initial value problem for ordinary differential equation
   * @see http://www.mathworks.com/matlab/matlab/ref/odextend.html
   */
  ODEXTEND("odextend"),
  /*
   * Ordinary differential equation options parameters
   * @see http://www.mathworks.com/matlab/matlab/ref/odeget.html
   */
  ODEGET("odeget"),
  /*
   * Create or alter options structure for ordinary differential equation solvers
   * @see http://www.mathworks.com/matlab/matlab/ref/odeset.html
   */
  ODESET("odeset"),
  /*
   * Evaluate solution of differential equation problem
   * @see http://www.mathworks.com/matlab/matlab/ref/deval.html
   */
  DEVAL("deval"),

  /*
   * Boundary Value Problems   */
  /*
   * Solve boundary value problems for ordinary differential equations
   * @see http://www.mathworks.com/matlab/matlab/ref/bvp4c.html
   */
  BVP4C("bvp4c"),
  /*
   * Solve boundary value problems for ordinary differential equations
   * @see http://www.mathworks.com/matlab/matlab/ref/bvp5c.html
   */
  BVP5C("bvp5c"),
  /*
   * Form initial guess for BVP solvers
   * @see http://www.mathworks.com/matlab/matlab/ref/bvpinit.html
   */
  BVPINIT("bvpinit"),
  /*
   * Form guess structure for extending boundary value solutions
   * @see http://www.mathworks.com/matlab/matlab/ref/bvpxtend.html
   */
  BVPXTEND("bvpxtend"),
  /*
   * Extract properties from options structure created with bvpset
   * @see http://www.mathworks.com/matlab/matlab/ref/bvpget.html
   */
  BVPGET("bvpget"),
  /*
   * Create or alter options structure of boundary value problem
   * @see http://www.mathworks.com/matlab/matlab/ref/bvpset.html
   */
  BVPSET("bvpset"),
  /*
   * Evaluate solution of differential equation problem
   * @see http://www.mathworks.com/matlab/matlab/ref/deval.html
   */
//  DEVAL("deval"),

  /*
   * Delay Differential Equations   */
  /*
   * Solve delay differential equations (DDEs) with constant delays
   * @see http://www.mathworks.com/matlab/matlab/ref/dde23.html
   */
  DDE23("dde23"),
  /*
   * Solve delay differential equations (DDEs) with general delays
   * @see http://www.mathworks.com/matlab/matlab/ref/ddesd.html
   */
  DDESD("ddesd"),
  /*
   * Solve delay differential equations (DDEs) of neutral type
   * @see http://www.mathworks.com/matlab/matlab/ref/ddensd.html
   */
  DDENSD("ddensd"),
  /*
   * Extract properties from delay differential equations options structure
   * @see http://www.mathworks.com/matlab/matlab/ref/ddeget.html
   */
  DDEGET("ddeget"),
  /*
   * Create or alter delay differential equations options structure
   * @see http://www.mathworks.com/matlab/matlab/ref/ddeset.html
   */
  DDESET("ddeset"),
  /*
   * Evaluate solution of differential equation problem
   * @see http://www.mathworks.com/matlab/matlab/ref/deval.html
   */
//  DEVAL("deval"),

  /*
   * Partial Differential Equations   */
  /*
   * Solve initial-boundary value problems for parabolic-elliptic PDEs in 1-D
   * @see http://www.mathworks.com/matlab/matlab/ref/pdepe.html
   */
  PDEPE("pdepe"),
  /*
   * Evaluate numerical solution of PDE using output of pdepe
   * @see http://www.mathworks.com/matlab/matlab/ref/pdeval.html
   */
  PDEVAL("pdeval"),

  /*
   * Numerical Integration and Differentiation
   */
  /*
   * Numerically evaluate integral
   * @see http://www.mathworks.com/matlab/matlab/ref/integral.html
   */
  INTEGRAL("integral"),
  /*
   * Numerically evaluate double integral
   * @see http://www.mathworks.com/matlab/matlab/ref/integral2.html
   */
  INTEGRAL2("integral2"),
  /*
   * Numerically evaluate triple integral
   * @see http://www.mathworks.com/matlab/matlab/ref/integral3.html
   */
  INTEGRAL3("integral3"),
  /*
   * Numerically evaluate integral, adaptive Gauss-Kronrod quadrature
   * @see http://www.mathworks.com/matlab/matlab/ref/quadgk.html
   */
  QUADGK("quadgk"),
  /*
   * Numerically evaluate double integral, tiled method
   * @see http://www.mathworks.com/matlab/matlab/ref/quad2d.html
   */
  QUAD2D("quad2d"),
  /*
   * Cumulative trapezoidal numerical integration
   * @see http://www.mathworks.com/matlab/matlab/ref/cumtrapz.html
   */
  CUMTRAPZ("cumtrapz"),
  /*
   * Trapezoidal numerical integration
   * @see http://www.mathworks.com/matlab/matlab/ref/trapz.html
   */
  TRAPZ("trapz"),
  /*
   * Integrate polynomial analytically
   * @see http://www.mathworks.com/matlab/matlab/ref/polyint.html
   */
//  POLYINT("polyint"),
  /*
   * Discrete Laplacian
   * @see http://www.mathworks.com/matlab/matlab/ref/del2.html
   */
  DEL2("del2"),
  /*
   * Differences and Approximate Derivatives
   * @see http://www.mathworks.com/matlab/matlab/ref/diff.html
   */
//  DIFF("diff"),
  /*
   * Numerical gradient
   * @see http://www.mathworks.com/matlab/matlab/ref/gradient.html
   */
  GRADIENT("gradient"),
  /*
   * Polynomial derivative
   * @see http://www.mathworks.com/matlab/matlab/ref/polyder.html
   */
//  POLYDER("polyder"),

  /*
   * Fourier Analysis and Filtering
   */
  /*
   * Absolute value and complex magnitude
   * @see http://www.mathworks.com/matlab/matlab/ref/abs.html
   */
//  ABS("abs"),
  /*
   * Phase angle
   * @see http://www.mathworks.com/matlab/matlab/ref/angle.html
   */
//  ANGLE("angle"),
  /*
   * Sort complex numbers into complex conjugate pairs
   * @see http://www.mathworks.com/matlab/matlab/ref/cplxpair.html
   */
//  CPLXPAIR("cplxpair"),
  /*
   * Fast Fourier transform
   * @see http://www.mathworks.com/matlab/matlab/ref/fft.html
   */
  FFT("fft"),
  /*
   * 2-D fast Fourier transform
   * @see http://www.mathworks.com/matlab/matlab/ref/fft2.html
   */
  FFT2("fft2"),
  /*
   * N-D fast Fourier transform
   * @see http://www.mathworks.com/matlab/matlab/ref/fftn.html
   */
  FFTN("fftn"),
  /*
   * Shift zero-frequency component to center of spectrum
   * @see http://www.mathworks.com/matlab/matlab/ref/fftshift.html
   */
  FFTSHIFT("fftshift"),
  /*
   * Interface to FFTW library run-time algorithm tuning control
   * @see http://www.mathworks.com/matlab/matlab/ref/fftw.html
   */
  FFTW("fftw"),
  /*
   * Inverse fast Fourier transform
   * @see http://www.mathworks.com/matlab/matlab/ref/ifft.html
   */
  IFFT("ifft"),
  /*
   * 2-D inverse fast Fourier transform
   * @see http://www.mathworks.com/matlab/matlab/ref/ifft2.html
   */
  IFFT2("ifft2"),
  /*
   * N-D inverse fast Fourier transform
   * @see http://www.mathworks.com/matlab/matlab/ref/ifftn.html
   */
  IFFTN("ifftn"),
  /*
   * Inverse FFT shift
   * @see http://www.mathworks.com/matlab/matlab/ref/ifftshift.html
   */
  IFFTSHIFT("ifftshift"),
  /*
   * Exponent of next higher power of 2
   * @see http://www.mathworks.com/matlab/matlab/ref/nextpow2.html
   */
//  NEXTPOW2("nextpow2"),
  /*
   * Correct phase angles to produce smoother phase plots
   * @see http://www.mathworks.com/matlab/matlab/ref/unwrap.html
   */
//  UNWRAP("unwrap"),
  /*
   * Convolution and polynomial multiplication
   * @see http://www.mathworks.com/matlab/matlab/ref/conv.html
   */
  CONV("conv"),
  /*
   * 2-D convolution
   * @see http://www.mathworks.com/matlab/matlab/ref/conv2.html
   */
  CONV2("conv2"),
  /*
   * N-D convolution
   * @see http://www.mathworks.com/matlab/matlab/ref/convn.html
   */
  CONVN("convn"),
  /*
   * Deconvolution and polynomial division
   * @see http://www.mathworks.com/matlab/matlab/ref/deconv.html
   */
  DECONV("deconv"),
  /*
   * Remove linear trends
   * @see http://www.mathworks.com/matlab/matlab/ref/detrend.html
   */
//  DETREND("detrend"),
  /*
   * 1-D digital filter
   * @see http://www.mathworks.com/matlab/matlab/ref/filter.html
   */
//  FILTER("filter"),
  /*
   * 2-D digital filter
   * @see http://www.mathworks.com/matlab/matlab/ref/filter2.html
   */
  FILTER2("filter2"),

  /*
   * Sparse Matrices
   */
  /*
   * Sparse Matrix Creation
   */
  /*
   * Extract and create sparse band and diagonal matrices
   * @see http://www.mathworks.com/matlab/matlab/ref/spdiags.html
   */
  SPDIAGS("spdiags"),
  /*
   * Sparse identity matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/speye.html
   */
  SPEYE("speye"),
  /*
   * Sparse uniformly distributed random matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/sprand.html
   */
  SPRAND("sprand"),
  /*
   * Sparse normally distributed random matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/sprandn.html
   */
  SPRANDN("sprandn"),
  /*
   * Sparse symmetric random matrix 
   * @see http://www.mathworks.com/matlab/matlab/ref/sprandsym.html
   */
  SPRANDSYM("sprandsym"),
  /*
   * Create sparse matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/sparse.html
   */
  SPARSE("sparse"),
  /*
   * Import matrix from sparse matrix external format
   * @see http://www.mathworks.com/matlab/matlab/ref/spconvert.html
   */
  SPCONVERT("spconvert"),

  /*
   * Sparse Matrix Manipulation
   */
  /*
   * Determine whether input is sparse
   * @see http://www.mathworks.com/matlab/matlab/ref/issparse.html
   */
  ISSPARSE("issparse"),
  /*
   * Number of nonzero matrix elements
   * @see http://www.mathworks.com/matlab/matlab/ref/nnz.html
   */
  NNZ("nnz"),
  /*
   * Nonzero matrix elements
   * @see http://www.mathworks.com/matlab/matlab/ref/nonzeros.html
   */
  NONZEROS("nonzeros"),
  /*
   * Amount of storage allocated for nonzero matrix elements
   * @see http://www.mathworks.com/matlab/matlab/ref/nzmax.html
   */
  NZMAX("nzmax"),
  /*
   * Allocate space for sparse matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/spalloc.html
   */
  SPALLOC("spalloc"),
  /*
   * Apply function to nonzero sparse matrix elements
   * @see http://www.mathworks.com/matlab/matlab/ref/spfun.html
   */
  SPFUN("spfun"),
  /*
   * Replace nonzero sparse matrix elements with ones
   * @see http://www.mathworks.com/matlab/matlab/ref/spones.html
   */
  SPONES("spones"),
  /*
   * Set parameters for sparse matrix routines
   * @see http://www.mathworks.com/matlab/matlab/ref/spparms.html
   */
  SPPARMS("spparms"),
  /*
   * Visualize sparsity pattern
   * @see http://www.mathworks.com/matlab/matlab/ref/spy.html
   */
  SPY("spy"),
  /*
   * Find indices and values of nonzero elements
   * @see http://www.mathworks.com/matlab/matlab/ref/find.html
   */
  FIND("find"),
  /*
   * Convert sparse matrix to full matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/full.html
   */
  FULL("full"),

  /*
   * Reordering Algorithms
   */
  /*
   * Approximate minimum degree permutation
   * @see http://www.mathworks.com/matlab/matlab/ref/amd.html
   */
  AMD("amd"),
  /*
   * Column approximate minimum degree permutation
   * @see http://www.mathworks.com/matlab/matlab/ref/colamd.html
   */
  COLAMD("colamd"),
  /*
   * Sparse column permutation based on nonzero count 
   * @see http://www.mathworks.com/matlab/matlab/ref/colperm.html
   */
  COLPERM("colperm"),
  /*
   * Dulmage-Mendelsohn decomposition
   * @see http://www.mathworks.com/matlab/matlab/ref/dmperm.html
   */
  DMPERM("dmperm"),
  /*
   * Random permutation 
   * @see http://www.mathworks.com/matlab/matlab/ref/randperm.html
   */
//  RANDPERM("randperm"),
  /*
   * Symmetric approximate minimum degree permutation
   * @see http://www.mathworks.com/matlab/matlab/ref/symamd.html
   */
  SYMAMD("symamd"),
  /*
   * Sparse reverse Cuthill-McKee ordering
   * @see http://www.mathworks.com/matlab/matlab/ref/symrcm.html
   */
  SYMRCM("symrcm"),

  /*
   * Sparse Linear Algebra
   */
  /*
   * 1-norm condition number estimate
   * @see http://www.mathworks.com/matlab/matlab/ref/condest.html
   */
//  CONDEST("condest"),
  /*
   * Largest eigenvalues and eigenvectors of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/eigs.html
   */
//  EIGS("eigs"),
  /*
   * Incomplete Cholesky factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/ichol.html
   */
//  ICHOL ("ichol "),
  /*
   * Sparse incomplete LU factorization
   * @see http://www.mathworks.com/matlab/matlab/ref/ilu.html
   */
//  ILU("ilu"),
  /*
   * 2-norm estimate
   * @see http://www.mathworks.com/matlab/matlab/ref/normest.html
   */
//  NORMEST("normest"),
  /*
   * Form least squares augmented system
   * @see http://www.mathworks.com/matlab/matlab/ref/spaugment.html
   */
  SPAUGMENT("spaugment"),
  /*
   * Structural rank
   * @see http://www.mathworks.com/matlab/matlab/ref/sprank.html
   */
  SPRANK("sprank"),
  /*
   * Find singular values and vectors
   * @see http://www.mathworks.com/matlab/matlab/ref/svds.html
   */
//  SVDS("svds"),

  /*
   * Linear Equations (Iterative Methods)
   */
  /*
   * Biconjugate gradients method
   * @see http://www.mathworks.com/matlab/matlab/ref/bicg.html
   */
  BICG("bicg"),
  /*
   * Biconjugate gradients stabilized method
   * @see http://www.mathworks.com/matlab/matlab/ref/bicgstab.html
   */
  BICGSTAB("bicgstab"),
  /*
   * Biconjugate gradients stabilized (l) method
   * @see http://www.mathworks.com/matlab/matlab/ref/bicgstabl.html
   */
  BICGSTABL("bicgstabl"),
  /*
   * Conjugate gradients squared method
   * @see http://www.mathworks.com/matlab/matlab/ref/cgs.html
   */
  CGS("cgs"),
  /*
   * Generalized minimum residual method (with restarts)
   * @see http://www.mathworks.com/matlab/matlab/ref/gmres.html
   */
  GMRES("gmres"),
  /*
   * LSQR method
   * @see http://www.mathworks.com/matlab/matlab/ref/lsqr.html
   */
  LSQR("lsqr"),
  /*
   * Minimum residual method
   * @see http://www.mathworks.com/matlab/matlab/ref/minres.html
   */
  MINRES("minres"),
  /*
   * Preconditioned conjugate gradients method
   * @see http://www.mathworks.com/matlab/matlab/ref/pcg.html
   */
  PCG("pcg"),
  /*
   * Quasi-minimal residual method
   * @see http://www.mathworks.com/matlab/matlab/ref/qmr.html
   */
  QMR("qmr"),
  /*
   * Symmetric LQ method
   * @see http://www.mathworks.com/matlab/matlab/ref/symmlq.html
   */
  SYMMLQ("symmlq"),
  /*
   * Transpose-free quasi-minimal residual method
   * @see http://www.mathworks.com/matlab/matlab/ref/tfqmr.html
   */
  TFQMR("tfqmr"),

  /*
   * Graph and Tree Algorithms
   */
  /*
   * Elimination tree
   * @see http://www.mathworks.com/matlab/matlab/ref/etree.html
   */
  ETREE("etree"),
  /*
   * Plot elimination tree
   * @see http://www.mathworks.com/matlab/matlab/ref/etreeplot.html
   */
  ETREEPLOT("etreeplot"),
  /*
   * Plot nodes and links representing adjacency matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/gplot.html
   */
  GPLOT("gplot"),
  /*
   * Symbolic factorization analysis
   * @see http://www.mathworks.com/matlab/matlab/ref/symbfact.html
   */
  SYMBFACT("symbfact"),
  /*
   * Lay out tree or forest
   * @see http://www.mathworks.com/matlab/matlab/ref/treelayout.html
   */
  TREELAYOUT("treelayout"),
  /*
   * Plot picture of tree
   * @see http://www.mathworks.com/matlab/matlab/ref/treeplot.html
   */
  TREEPLOT("treeplot"),
  /*
   * Convert edge matrix to coordinate and Laplacian matrices
   * @see http://www.mathworks.com/matlab/matlab/ref/unmesh.html
   */
  UNMESH("unmesh"),

  /*
   * Computational Geometry
   */
  /*
   * Triangulation Representation
   */
  /*
   * Triangulation in 2-D or 3-D 
   * @see http://www.mathworks.com/matlab/matlab/ref/triangulation-class.html
   */
//  TRIANGULATION("triangulation"),
  /*
   * Tetrahedron mesh plot
   * @see http://www.mathworks.com/matlab/matlab/ref/tetramesh.html
   */
//  TETRAMESH("tetramesh"),
  /*
   * Triangular mesh plot
   * @see http://www.mathworks.com/matlab/matlab/ref/trimesh.html
   */
//  TRIMESH("trimesh"),
  /*
   * 2-D triangular plot
   * @see http://www.mathworks.com/matlab/matlab/ref/triplot.html
   */
//  TRIPLOT("triplot"),
  /*
   * Triangular surface plot
   * @see http://www.mathworks.com/matlab/matlab/ref/trisurf.html
   */
//  TRISURF("trisurf"),

  /*
   * Delaunay Triangulation
   */
  /*
   * Delaunay triangulation in 2-D and 3-D
   * @see http://www.mathworks.com/matlab/matlab/ref/delaunaytriangulation-class.html
   */
//  DELAUNAYTRIANGULATION("delaunaytriangulation"),
  /*
   * Delaunay triangulation
   * @see http://www.mathworks.com/matlab/matlab/ref/delaunay.html
   */
//  DELAUNAY("delaunay"),
  /*
   * N-D Delaunay triangulation
   * @see http://www.mathworks.com/matlab/matlab/ref/delaunayn.html
   */
//  DELAUNAYN("delaunayn"),
  /*
   * Tetrahedron mesh plot
   * @see http://www.mathworks.com/matlab/matlab/ref/tetramesh.html
   */
  TETRAMESH("tetramesh"),
  /*
   * Triangular mesh plot
   * @see http://www.mathworks.com/matlab/matlab/ref/trimesh.html
   */
  TRIMESH("trimesh"),
  /*
   * 2-D triangular plot
   * @see http://www.mathworks.com/matlab/matlab/ref/triplot.html
   */
  TRIPLOT("triplot"),
  /*
   * Triangular surface plot
   * @see http://www.mathworks.com/matlab/matlab/ref/trisurf.html
   */
//  TRISURF("trisurf"),

  /*
   * Spatial Search
   */
  /*
   * Triangulation in 2-D or 3-D 
   * @see http://www.mathworks.com/matlab/matlab/ref/triangulation-class.html
   */
  TRIANGULATION("triangulation"),
  /*
   * Delaunay triangulation in 2-D and 3-D
   * @see http://www.mathworks.com/matlab/matlab/ref/delaunaytriangulation-class.html
   */
  DELAUNAYTRIANGULATION("delaunaytriangulation"),
  /*
   * N-D nearest point search
   * @see http://www.mathworks.com/matlab/matlab/ref/dsearchn.html
   */
  DSEARCHN("dsearchn"),
  /*
   * N-D closest simplex search
   * @see http://www.mathworks.com/matlab/matlab/ref/tsearchn.html
   */
  TSEARCHN("tsearchn"),
  /*
   * Delaunay triangulation
   * @see http://www.mathworks.com/matlab/matlab/ref/delaunay.html
   */
  DELAUNAY("delaunay"),
  /*
   * N-D Delaunay triangulation
   * @see http://www.mathworks.com/matlab/matlab/ref/delaunayn.html
   */
  DELAUNAYN("delaunayn"),

  /*
   * Convex Hull
   */
  /*
   * Convex hull
   * @see http://www.mathworks.com/matlab/matlab/ref/convhull.html
   */
  CONVHULL("convhull"),
  /*
   * N-D convex hull
   * @see http://www.mathworks.com/matlab/matlab/ref/convhulln.html
   */
  CONVHULLN("convhulln"),
  /*
   * Create one or more filled polygons
   * @see http://www.mathworks.com/matlab/matlab/ref/patch.html
   */
  PATCH("patch"),
  /*
   * Triangular surface plot
   * @see http://www.mathworks.com/matlab/matlab/ref/trisurf.html
   */
  TRISURF("trisurf"),

  /*
   * Voronoi Diagram
   */
  /*
   * Create one or more filled polygons
   * @see http://www.mathworks.com/matlab/matlab/ref/patch.html
   */
//  PATCH("patch"),
  /*
   * Voronoi diagram
   * @see http://www.mathworks.com/matlab/matlab/ref/voronoi.html
   */
  VORONOI("voronoi"),
  /*
   * N-D Voronoi diagram
   * @see http://www.mathworks.com/matlab/matlab/ref/voronoin.html
   */
  VORONOIN("voronoin"),

  /*
   * Elementary Polygons
   */
  /*
   * Area of polygon
   * @see http://www.mathworks.com/matlab/matlab/ref/polyarea.html
   */
  POLYAREA("polyarea"),
  /*
   * Points inside polygonal region
   * @see http://www.mathworks.com/matlab/matlab/ref/inpolygon.html
   */
  INPOLYGON("inpolygon"),
  /*
   * Rectangle intersection area
   * @see http://www.mathworks.com/matlab/matlab/ref/rectint.html
   */
  RECTINT("rectint"),

  /*
   * Graphics
   */
  /*
   * 2-D and 3-D Plots
   */
  /*
   * Line Plots
   */
  /*
   * 2-D line plot
   * @see http://www.mathworks.com/matlab/matlab/ref/plot.html
   */
  PLOT("plot"),
  /*
   * 2-D line plots with y-axes on both left and right side
   * @see http://www.mathworks.com/matlab/matlab/ref/plotyy.html
   */
  PLOTYY("plotyy"),
  /*
   * 3-D line plot
   * @see http://www.mathworks.com/matlab/matlab/ref/plot3.html
   */
  PLOT3("plot3"),
  /*
   * Log-log scale plot
   * @see http://www.mathworks.com/matlab/matlab/ref/loglog.html
   */
  LOGLOG("loglog"),
  /*
   * Semilogarithmic plot
   * @see http://www.mathworks.com/matlab/matlab/ref/semilogx.html
   */
  SEMILOGX("semilogx"),
  /*
   * Semilogarithmic plot
   * @see http://www.mathworks.com/matlab/matlab/ref/semilogy.html
   */
  SEMILOGY("semilogy"),
  /*
   * Plot error bars along curve 
   * @see http://www.mathworks.com/matlab/matlab/ref/errorbar.html
   */
  ERRORBAR("errorbar"),
  /*
   * Plot function between specified limits
   * @see http://www.mathworks.com/matlab/matlab/ref/fplot.html
   */
  FPLOT("fplot"),
  /*
   * Easy-to-use function plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezplot.html
   */
  EZPLOT("ezplot"),
  /*
   * Easy-to-use 3-D parametric curve plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezplot3.html
   */
  EZPLOT3("ezplot3"),
  /*
   * Line specification string syntax
   * @see http://www.mathworks.com/matlab/matlab/ref/linespec.html
   */
  LINESPEC_LINE_SPECIFICATION("linespec (line specification)"),
  /*
   * Color specification
   * @see http://www.mathworks.com/matlab/matlab/ref/colorspec.html
   */
  COLORSPEC_COLOR_SPECIFICATION("colorspec (color specification)"),

  /*
   * Pie Charts, Bar Plots, and Histograms
   */
  /*
   * Bar graph
   * @see http://www.mathworks.com/matlab/matlab/ref/bar.html
   */
  BAR("bar"),
  /*
   * Plot 3-D bar graph
   * @see http://www.mathworks.com/matlab/matlab/ref/bar3.html
   */
  BAR3("bar3"),
  /*
   * Plot bar graph horizontally
   * @see http://www.mathworks.com/matlab/matlab/ref/barh.html
   */
  BARH("barh"),
  /*
   * Plot horizontal 3-D bar graph
   * @see http://www.mathworks.com/matlab/matlab/ref/bar3h.html
   */
  BAR3H("bar3h"),
  /*
   * Histogram plot
   * @see http://www.mathworks.com/matlab/matlab/ref/hist.html
   */
  HIST("hist"),
  /*
   * Histogram bin count
   * @see http://www.mathworks.com/matlab/matlab/ref/histc.html
   */
  HISTC("histc"),
  /*
   * Angle histogram plot
   * @see http://www.mathworks.com/matlab/matlab/ref/rose.html
   */
  ROSE("rose"),
  /*
   * Pareto chart
   * @see http://www.mathworks.com/matlab/matlab/ref/pareto.html
   */
  PARETO("pareto"),
  /*
   * Filled area 2-D plot
   * @see http://www.mathworks.com/matlab/matlab/ref/area.html
   */
  AREA("area"),
  /*
   * Pie chart
   * @see http://www.mathworks.com/matlab/matlab/ref/pie.html
   */
  PIE("pie"),
  /*
   * 3-D pie chart
   * @see http://www.mathworks.com/matlab/matlab/ref/pie3.html
   */
  PIE3("pie3"),

  /*
   * Discrete Data Plots
   */
  /*
   * Plot discrete sequence data
   * @see http://www.mathworks.com/matlab/matlab/ref/stem.html
   */
  STEM("stem"),
  /*
   * Stairstep graph
   * @see http://www.mathworks.com/matlab/matlab/ref/stairs.html
   */
  STAIRS("stairs"),
  /*
   * Plot 3-D discrete sequence data
   * @see http://www.mathworks.com/matlab/matlab/ref/stem3.html
   */
  STEM3("stem3"),
  /*
   * Scatter plot
   * @see http://www.mathworks.com/matlab/matlab/ref/scatter.html
   */
  SCATTER("scatter"),
  /*
   * 3-D scatter plot
   * @see http://www.mathworks.com/matlab/matlab/ref/scatter3.html
   */
  SCATTER3("scatter3"),
  /*
   * Visualize sparsity pattern
   * @see http://www.mathworks.com/matlab/matlab/ref/spy.html
   */
//  SPY("spy"),
  /*
   * Scatter plot matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/plotmatrix.html
   */
  PLOTMATRIX("plotmatrix"),

  /*
   * Polar Plots
   */
  /*
   * Polar coordinate plot
   * @see http://www.mathworks.com/matlab/matlab/ref/polar.html
   */
  POLAR("polar"),
  /*
   * Angle histogram plot
   * @see http://www.mathworks.com/matlab/matlab/ref/rose.html
   */
//  ROSE("rose"),
  /*
   * Plot arrows emanating from origin
   * @see http://www.mathworks.com/matlab/matlab/ref/compass.html
   */
  COMPASS("compass"),
  /*
   * Easy-to-use polar coordinate plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezpolar.html
   */
  EZPOLAR("ezpolar"),
  /*
   * Line specification string syntax
   * @see http://www.mathworks.com/matlab/matlab/ref/linespec.html
   */
//  LINESPEC_LINE_SPECIFICATION("linespec (line specification)"),
  /*
   * Color specification
   * @see http://www.mathworks.com/matlab/matlab/ref/colorspec.html
   */
//  COLORSPEC_COLOR_SPECIFICATION("colorspec (color specification)"),

  /*
   * Contour Plots
   */
  /*
   * Contour plot of matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/contour.html
   */
  CONTOUR("contour"),
  /*
   * Filled 2-D contour plot
   * @see http://www.mathworks.com/matlab/matlab/ref/contourf.html
   */
  CONTOURF("contourf"),
  /*
   * Low-level contour plot computation
   * @see http://www.mathworks.com/matlab/matlab/ref/contourc.html
   */
  CONTOURC("contourc"),
  /*
   * 3-D contour plot
   * @see http://www.mathworks.com/matlab/matlab/ref/contour3.html
   */
  CONTOUR3("contour3"),
  /*
   * Draw contours in volume slice planes
   * @see http://www.mathworks.com/matlab/matlab/ref/contourslice.html
   */
  CONTOURSLICE("contourslice"),
  /*
   * Easy-to-use contour plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezcontour.html
   */
  EZCONTOUR("ezcontour"),
  /*
   * Easy-to-use filled contour plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezcontourf.html
   */
  EZCONTOURF("ezcontourf"),

  /*
   * Vector Fields
   */
  /*
   * Plot velocity vectors
   * @see http://www.mathworks.com/matlab/matlab/ref/feather.html
   */
  FEATHER("feather"),
  /*
   * Quiver or velocity plot
   * @see http://www.mathworks.com/matlab/matlab/ref/quiver.html
   */
  QUIVER("quiver"),
  /*
   * Plot arrows emanating from origin
   * @see http://www.mathworks.com/matlab/matlab/ref/compass.html
   */
//  COMPASS("compass"),
  /*
   * 3-D quiver or velocity plot
   * @see http://www.mathworks.com/matlab/matlab/ref/quiver3.html
   */
  QUIVER3("quiver3"),
  /*
   * Plot streamlines in slice planes
   * @see http://www.mathworks.com/matlab/matlab/ref/streamslice.html
   */
  STREAMSLICE("streamslice"),
  /*
   * Plot streamlines from 2-D or 3-D vector data
   * @see http://www.mathworks.com/matlab/matlab/ref/streamline.html
   */
  STREAMLINE("streamline"),

  /*
   * Surfaces, Volumes, and Polygons
   */
  /*
   * Surface and Mesh Plots
   */
  /*
   * 3-D shaded surface plot
   * @see http://www.mathworks.com/matlab/matlab/ref/surf.html
   */
  SURF("surf"),
  /*
   * Contour plot under a 3-D shaded surface plot 
   * @see http://www.mathworks.com/matlab/matlab/ref/surfc.html
   */
  SURFC("surfc"),
  /*
   * Create surface object
   * @see http://www.mathworks.com/matlab/matlab/ref/surface.html
   */
  SURFACE("surface"),
  /*
   * Surface plot with colormap-based lighting
   * @see http://www.mathworks.com/matlab/matlab/ref/surfl.html
   */
  SURFL("surfl"),
  /*
   * Compute and display 3-D surface normals
   * @see http://www.mathworks.com/matlab/matlab/ref/surfnorm.html
   */
//  SURFNORM("surfnorm"),
  /*
   * Mesh plot
   * @see http://www.mathworks.com/matlab/matlab/ref/mesh.html
   */
  MESH("mesh"),
  /*
   * Plot a contour graph under mesh graph
   * @see http://www.mathworks.com/matlab/matlab/ref/meshc.html
   */
  MESHC("meshc"),
  /*
   * Plot a curtain around mesh plot
   * @see http://www.mathworks.com/matlab/matlab/ref/meshz.html
   */
  MESHZ("meshz"),
  /*
   * Waterfall plot
   * @see http://www.mathworks.com/matlab/matlab/ref/waterfall.html
   */
  WATERFALL("waterfall"),
  /*
   * Ribbon plot
   * @see http://www.mathworks.com/matlab/matlab/ref/ribbon.html
   */
  RIBBON("ribbon"),
  /*
   * 3-D contour plot
   * @see http://www.mathworks.com/matlab/matlab/ref/contour3.html
   */
//  CONTOUR3("contour3"),
  /*
   * Example function of two variables
   * @see http://www.mathworks.com/matlab/matlab/ref/peaks.html
   */
  PEAKS("peaks"),
  /*
   * Generate cylinder
   * @see http://www.mathworks.com/matlab/matlab/ref/cylinder.html
   */
  CYLINDER("cylinder"),
  /*
   * Generate ellipsoid
   * @see http://www.mathworks.com/matlab/matlab/ref/ellipsoid.html
   */
  ELLIPSOID("ellipsoid"),
  /*
   * Generate sphere
   * @see http://www.mathworks.com/matlab/matlab/ref/sphere.html
   */
  SPHERE("sphere"),
  /*
   * Pseudocolor (checkerboard) plot
   * @see http://www.mathworks.com/matlab/matlab/ref/pcolor.html
   */
  PCOLOR("pcolor"),
  /*
   * Convert surface data to patch data
   * @see http://www.mathworks.com/matlab/matlab/ref/surf2patch.html
   */
  SURF2PATCH("surf2patch"),
  /*
   * Easy-to-use 3-D colored surface plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezsurf.html
   */
  EZSURF("ezsurf"),
  /*
   * Easy-to-use combination surface/contour plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezsurfc.html
   */
  EZSURFC("ezsurfc"),
  /*
   * Easy-to-use 3-D mesh plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezmesh.html
   */
  EZMESH("ezmesh"),
  /*
   * Easy-to-use combination mesh/contour plotter
   * @see http://www.mathworks.com/matlab/matlab/ref/ezmeshc.html
   */
  EZMESHC("ezmeshc"),

  /*
   * Volume Visualization
   */
  /*
   * Draw contours in volume slice planes
   * @see http://www.mathworks.com/matlab/matlab/ref/contourslice.html
   */
//  CONTOURSLICE("contourslice"),
  /*
   * Simple function of three variables 
   * @see http://www.mathworks.com/matlab/matlab/ref/flow.html
   */
  FLOW("flow"),
  /*
   * Compute isosurface end-cap geometry
   * @see http://www.mathworks.com/matlab/matlab/ref/isocaps.html
   */
  ISOCAPS("isocaps"),
  /*
   * Calculate isosurface and patch colors
   * @see http://www.mathworks.com/matlab/matlab/ref/isocolors.html
   */
  ISOCOLORS("isocolors"),
  /*
   * Compute normals of isosurface vertices
   * @see http://www.mathworks.com/matlab/matlab/ref/isonormals.html
   */
  ISONORMALS("isonormals"),
  /*
   * Extract isosurface data from volume data
   * @see http://www.mathworks.com/matlab/matlab/ref/isosurface.html
   */
  ISOSURFACE("isosurface"),
  /*
   * Reduce number of patch faces
   * @see http://www.mathworks.com/matlab/matlab/ref/reducepatch.html
   */
  REDUCEPATCH("reducepatch"),
  /*
   * Reduce number of elements in volume data set
   * @see http://www.mathworks.com/matlab/matlab/ref/reducevolume.html
   */
  REDUCEVOLUME("reducevolume"),
  /*
   * Reduce  size of patch faces
   * @see http://www.mathworks.com/matlab/matlab/ref/shrinkfaces.html
   */
  SHRINKFACES("shrinkfaces"),
  /*
   * Volumetric slice plot
   * @see http://www.mathworks.com/matlab/matlab/ref/slice.html
   */
  SLICE("slice"),
  /*
   * Smooth 3-D data
   * @see http://www.mathworks.com/matlab/matlab/ref/smooth3.html
   */
  SMOOTH3("smooth3"),
  /*
   * Extract subset of volume data set
   * @see http://www.mathworks.com/matlab/matlab/ref/subvolume.html
   */
  SUBVOLUME("subvolume"),
  /*
   * Coordinate and color limits for volume data
   * @see http://www.mathworks.com/matlab/matlab/ref/volumebounds.html
   */
  VOLUMEBOUNDS("volumebounds"),
  /*
   * Plot velocity vectors as cones in 3-D vector field
   * @see http://www.mathworks.com/matlab/matlab/ref/coneplot.html
   */
  CONEPLOT("coneplot"),
  /*
   * Compute curl and angular velocity of vector field
   * @see http://www.mathworks.com/matlab/matlab/ref/curl.html
   */
  CURL("curl"),
  /*
   * Compute divergence of vector field
   * @see http://www.mathworks.com/matlab/matlab/ref/divergence.html
   */
  DIVERGENCE("divergence"),
  /*
   * Interpolate stream-line vertices from flow speed
   * @see http://www.mathworks.com/matlab/matlab/ref/interpstreamspeed.html
   */
  INTERPSTREAMSPEED("interpstreamspeed"),
  /*
   * Compute 2-D streamline data
   * @see http://www.mathworks.com/matlab/matlab/ref/stream2.html
   */
  STREAM2("stream2"),
  /*
   * Compute 3-D streamline data
   * @see http://www.mathworks.com/matlab/matlab/ref/stream3.html
   */
  STREAM3("stream3"),
  /*
   * Plot streamlines from 2-D or 3-D vector data
   * @see http://www.mathworks.com/matlab/matlab/ref/streamline.html
   */
//  STREAMLINE("streamline"),
  /*
   * Plot stream particles
   * @see http://www.mathworks.com/matlab/matlab/ref/streamparticles.html
   */
  STREAMPARTICLES("streamparticles"),
  /*
   * 3-D stream ribbon plot from vector volume data
   * @see http://www.mathworks.com/matlab/matlab/ref/streamribbon.html
   */
  STREAMRIBBON("streamribbon"),
  /*
   * Plot streamlines in slice planes
   * @see http://www.mathworks.com/matlab/matlab/ref/streamslice.html
   */
//  STREAMSLICE("streamslice"),
  /*
   * Create 3-D stream tube plot
   * @see http://www.mathworks.com/matlab/matlab/ref/streamtube.html
   */
  STREAMTUBE("streamtube"),

  /*
   * Polygons
   */
  /*
   * Filled 2-D polygons
   * @see http://www.mathworks.com/matlab/matlab/ref/fill.html
   */
  FILL("fill"),
  /*
   * Filled 3-D polygons
   * @see http://www.mathworks.com/matlab/matlab/ref/fill3.html
   */
  FILL3("fill3"),
  /*
   * Create one or more filled polygons
   * @see http://www.mathworks.com/matlab/matlab/ref/patch.html
   */
//  PATCH("patch"),
  /*
   * Convert surface data to patch data
   * @see http://www.mathworks.com/matlab/matlab/ref/surf2patch.html
   */
//  SURF2PATCH("surf2patch"),

  /*
   * Animation
   */
  /*
   * Play recorded movie frames
   * @see http://www.mathworks.com/matlab/matlab/ref/movie.html
   */
  MOVIE("movie"),
  /*
   * Change EraseMode of all objects to normal
   * @see http://www.mathworks.com/matlab/matlab/ref/noanimate.html
   */
  NOANIMATE("noanimate"),
  /*
   * Update figure window and execute pending callbacks
   * @see http://www.mathworks.com/matlab/matlab/ref/drawnow.html
   */
//  DRAWNOW("drawnow"),
  /*
   * Refresh data in graph when data source is specified
   * @see http://www.mathworks.com/matlab/matlab/ref/refreshdata.html
   */
//  REFRESHDATA("refreshdata"),
  /*
   * Return image data associated with movie frame
   * @see http://www.mathworks.com/matlab/matlab/ref/frame2im.html
   */
  FRAME2IM("frame2im"),
  /*
   * Capture movie frame
   * @see http://www.mathworks.com/matlab/matlab/ref/getframe.html
   */
  GETFRAME("getframe"),
  /*
   * Convert image to movie frame
   * @see http://www.mathworks.com/matlab/matlab/ref/im2frame.html
   */
  IM2FRAME("im2frame"),
  /*
   * 2-D comet plot
   * @see http://www.mathworks.com/matlab/matlab/ref/comet.html
   */
  COMET("comet"),
  /*
   * 3-D comet plot
   * @see http://www.mathworks.com/matlab/matlab/ref/comet3.html
   */
  COMET3("comet3"),

  /*
   * Formatting and Annotation
   */
  /*
   * Titles and Labels
   */
  /*
   * Add title to current axes
   * @see http://www.mathworks.com/matlab/matlab/ref/title.html
   */
  TITLE("title"),
  /*
   * Label  x-axis
   * @see http://www.mathworks.com/matlab/matlab/ref/xlabel.html
   */
  XLABEL("xlabel"),
  /*
   * Label  y-axis
   * @see http://www.mathworks.com/matlab/matlab/ref/ylabel.html
   */
  YLABEL("ylabel"),
  /*
   * Label  z-axis
   * @see http://www.mathworks.com/matlab/matlab/ref/zlabel.html
   */
  ZLABEL("zlabel"),
  /*
   * Contour plot elevation labels
   * @see http://www.mathworks.com/matlab/matlab/ref/clabel.html
   */
  CLABEL("clabel"),
  /*
   * Date formatted tick labels
   * @see http://www.mathworks.com/matlab/matlab/ref/datetick.html
   */
  DATETICK("datetick"),
  /*
   * Format text into TeX string
   * @see http://www.mathworks.com/matlab/matlab/ref/texlabel.html
   */
  TEXLABEL("texlabel"),
  /*
   * Graph legend for lines and patches
   * @see http://www.mathworks.com/matlab/matlab/ref/legend.html
   */
  LEGEND("legend"),
  /*
   * Colorbar showing color scale
   * @see http://www.mathworks.com/matlab/matlab/ref/colorbar.html
   */
  COLORBAR("colorbar"),

  /*
   * Coordinate System
   */
  /*
   * Set or query x-axis limits
   * @see http://www.mathworks.com/matlab/matlab/ref/xlim.html
   */
  XLIM("xlim"),
  /*
   * Set or query y-axis limits
   * @see http://www.mathworks.com/matlab/matlab/ref/ylim.html
   */
  YLIM("ylim"),
  /*
   * Set or query z-axis limits
   * @see http://www.mathworks.com/matlab/matlab/ref/zlim.html
   */
  ZLIM("zlim"),
  /*
   * Axes border
   * @see http://www.mathworks.com/matlab/matlab/ref/box.html
   */
  BOX("box"),
  /*
   * Grid lines for 2-D and 3-D plots
   * @see http://www.mathworks.com/matlab/matlab/ref/grid.html
   */
  GRID("grid"),
  /*
   * Set or query axes data aspect ratio
   * @see http://www.mathworks.com/matlab/matlab/ref/daspect.html
   */
  DASPECT("daspect"),
  /*
   * Set or query plot box aspect ratio
   * @see http://www.mathworks.com/matlab/matlab/ref/pbaspect.html
   */
  PBASPECT("pbaspect"),
  /*
   * Create axes graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/axes.html
   */
//  AXES("axes"),
  /*
   * Axis scaling and appearance
   * @see http://www.mathworks.com/matlab/matlab/ref/axis.html
   */
  AXIS("axis"),
  /*
   * Create axes in tiled positions
   * @see http://www.mathworks.com/matlab/matlab/ref/subplot.html
   */
  SUBPLOT("subplot"),
  /*
   * Retain current graph when adding new graphs
   * @see http://www.mathworks.com/matlab/matlab/ref/hold.html
   */
//  HOLD("hold"),
  /*
   * Current axes handle
   * @see http://www.mathworks.com/matlab/matlab/ref/gca.html
   */
  GCA("gca"),
  /*
   * Clear current axes
   * @see http://www.mathworks.com/matlab/matlab/ref/cla.html
   */
  CLA("cla"),

  /*
   * Annotation
   */
  /*
   * Create annotation objects
   * @see http://www.mathworks.com/matlab/matlab/ref/annotation.html
   */
//  ANNOTATION("annotation"),
  /*
   * Create text object in current axes
   * @see http://www.mathworks.com/matlab/matlab/ref/text.html
   */
//  TEXT("text"),
  /*
   * Graph legend for lines and patches
   * @see http://www.mathworks.com/matlab/matlab/ref/legend.html
   */
//  LEGEND("legend"),
  /*
   * Add title to current axes
   * @see http://www.mathworks.com/matlab/matlab/ref/title.html
   */
//  TITLE("title"),
  /*
   * Label  x-axis
   * @see http://www.mathworks.com/matlab/matlab/ref/xlabel.html
   */
//  XLABEL("xlabel"),
  /*
   * Label  y-axis
   * @see http://www.mathworks.com/matlab/matlab/ref/ylabel.html
   */
//  YLABEL("ylabel"),
  /*
   * Label  z-axis
   * @see http://www.mathworks.com/matlab/matlab/ref/zlabel.html
   */
//  ZLABEL("zlabel"),
  /*
   * Enable, disable, and manage interactive data cursor mode
   * @see http://www.mathworks.com/matlab/matlab/ref/datacursormode.html
   */
  DATACURSORMODE("datacursormode"),
  /*
   * Graphical input from mouse or cursor
   * @see http://www.mathworks.com/matlab/matlab/ref/ginput.html
   */
  GINPUT("ginput"),
  /*
   * Mouse placement of text in 2-D view
   * @see http://www.mathworks.com/matlab/matlab/ref/gtext.html
   */
  GTEXT("gtext"),

  /*
   * Colormaps
   */
  /*
   * Set and get current colormap
   * @see http://www.mathworks.com/matlab/matlab/ref/colormap.html
   */
  COLORMAP("colormap"),
  /*
   * Open colormap editor
   * @see http://www.mathworks.com/matlab/matlab/ref/colormapeditor.html
   */
  COLORMAPEDITOR("colormapeditor"),
  /*
   * Colorbar showing color scale
   * @see http://www.mathworks.com/matlab/matlab/ref/colorbar.html
   */
//  COLORBAR("colorbar"),
  /*
   * Brighten or darken colormap
   * @see http://www.mathworks.com/matlab/matlab/ref/brighten.html
   */
  BRIGHTEN("brighten"),
  /*
   * Grayscale colormap for contrast enhancement
   * @see http://www.mathworks.com/matlab/matlab/ref/contrast.html
   */
  CONTRAST("contrast"),
  /*
   * Set color shading properties
   * @see http://www.mathworks.com/matlab/matlab/ref/shading.html
   */
  SHADING("shading"),
  /*
   * Set default figure properties for grayscale monitors
   * @see http://www.mathworks.com/matlab/matlab/ref/graymon.html
   */
  GRAYMON("graymon"),
  /*
   * Color axis scaling
   * @see http://www.mathworks.com/matlab/matlab/ref/caxis.html
   */
  CAXIS("caxis"),
  /*
   * Convert HSV colormap to RGB colormap
   * @see http://www.mathworks.com/matlab/matlab/ref/hsv2rgb.html
   */
  HSV2RGB("hsv2rgb"),
  /*
   * Convert RGB colormap to HSV colormap
   * @see http://www.mathworks.com/matlab/matlab/ref/rgb2hsv.html
   */
  RGB2HSV("rgb2hsv"),
  /*
   * Plot colormap
   * @see http://www.mathworks.com/matlab/matlab/ref/rgbplot.html
   */
  RGBPLOT("rgbplot"),
  /*
   * Spin colormap
   * @see http://www.mathworks.com/matlab/matlab/ref/spinmap.html
   */
  SPINMAP("spinmap"),
  /*
   * Set default property values to display different color schemes
   * @see http://www.mathworks.com/matlab/matlab/ref/colordef.html
   */
  COLORDEF("colordef"),
  /*
   * Change axes background color
   * @see http://www.mathworks.com/matlab/matlab/ref/whitebg.html
   */
  WHITEBG("whitebg"),

  /*
   * Data Exploration
   */
  /*
   * Remove hidden lines from mesh plot
   * @see http://www.mathworks.com/matlab/matlab/ref/hidden.html
   */
  HIDDEN("hidden"),
  /*
   * Pan view of graph interactively
   * @see http://www.mathworks.com/matlab/matlab/ref/pan.html
   */
  PAN("pan"),
  /*
   * Reset graphics object properties to their defaults
   * @see http://www.mathworks.com/matlab/matlab/ref/reset.html
   */
  RESET("reset"),
  /*
   * Rotate object about specified origin and direction
   * @see http://www.mathworks.com/matlab/matlab/ref/rotate.html
   */
  ROTATE("rotate"),
  /*
   * Rotate 3-D view using mouse
   * @see http://www.mathworks.com/matlab/matlab/ref/rotate3d.html
   */
  ROTATE3D("rotate3d"),
  /*
   * Select, move, resize, or copy axes and uicontrol graphics objects
   * @see http://www.mathworks.com/matlab/matlab/ref/selectmoveresize.html
   */
  SELECTMOVERESIZE("selectmoveresize"),
  /*
   * Turn zooming on or off or magnify by factorMagnify by a factor
   * @see http://www.mathworks.com/matlab/matlab/ref/zoom.html
   */
  ZOOM("zoom"),
  /*
   * Enable, disable, and manage interactive data cursor mode
   * @see http://www.mathworks.com/matlab/matlab/ref/datacursormode.html
   */
//  DATACURSORMODE("datacursormode"),
  /*
   * Show or hide Figure Palette
   * @see http://www.mathworks.com/matlab/matlab/ref/figurepalette.html
   */
  FIGUREPALETTE("figurepalette"),
  /*
   * Show or hide figure Plot Browser
   * @see http://www.mathworks.com/matlab/matlab/ref/plotbrowser.html
   */
  PLOTBROWSER("plotbrowser"),
  /*
   * Interactively edit and annotate plots
   * @see http://www.mathworks.com/matlab/matlab/ref/plotedit.html
   */
  PLOTEDIT("plotedit"),
  /*
   * Show or hide plot tools
   * @see http://www.mathworks.com/matlab/matlab/ref/plottools.html
   */
  PLOTTOOLS("plottools"),
  /*
   * Show or hide Property Editor
   * @see http://www.mathworks.com/matlab/matlab/ref/propertyeditor.html
   */
  PROPERTYEDITOR("propertyeditor"),
  /*
   * Show or hide figure plot tool
   * @see http://www.mathworks.com/matlab/matlab/ref/showplottool.html
   */
  SHOWPLOTTOOL("showplottool"),

  /*
   * Data Brushing   */
  /*
   * Interactively mark, delete, modify, and save observations in graphs
   * @see http://www.mathworks.com/matlab/matlab/ref/brush.html
   */
  BRUSH("brush"),
  /*
   * Enable, disable, and manage interactive data cursor mode
   * @see http://www.mathworks.com/matlab/matlab/ref/datacursormode.html
   */
//  DATACURSORMODE("datacursormode"),
  /*
   * Automatically update graphs when variables change
   * @see http://www.mathworks.com/matlab/matlab/ref/linkdata.html
   */
  LINKDATA("linkdata"),
  /*
   * Refresh data in graph when data source is specified
   * @see http://www.mathworks.com/matlab/matlab/ref/refreshdata.html
   */
//  REFRESHDATA("refreshdata"),

  /*
   * 3-D Scene Control
   */
  /*
   * Camera Views
   */
  /*
   * Viewpoint specification
   * @see http://www.mathworks.com/matlab/matlab/ref/view.html
   */
  VIEW("view"),
  /*
   * Create 4-by-4 transform matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/makehgtform.html
   */
//  MAKEHGTFORM("makehgtform"),
  /*
   * View transformation matrices
   * @see http://www.mathworks.com/matlab/matlab/ref/viewmtx.html
   */
  VIEWMTX("viewmtx"),
  /*
   * Control camera toolbar programmatically
   * @see http://www.mathworks.com/matlab/matlab/ref/cameratoolbar.html
   */
  CAMERATOOLBAR("cameratoolbar"),
  /*
   * Rotate camera target around camera position
   * @see http://www.mathworks.com/matlab/matlab/ref/campan.html
   */
  CAMPAN("campan"),
  /*
   * Zoom in and out on scene
   * @see http://www.mathworks.com/matlab/matlab/ref/camzoom.html
   */
  CAMZOOM("camzoom"),
  /*
   *  Move camera position and target
   * @see http://www.mathworks.com/matlab/matlab/ref/camdolly.html
   */
  CAMDOLLY("camdolly"),
  /*
   * Position camera to view object or group of objects
   * @see http://www.mathworks.com/matlab/matlab/ref/camlookat.html
   */
  CAMLOOKAT("camlookat"),
  /*
   * Rotate camera position around camera target
   * @see http://www.mathworks.com/matlab/matlab/ref/camorbit.html
   */
  CAMORBIT("camorbit"),
  /*
   * Set or query camera position
   * @see http://www.mathworks.com/matlab/matlab/ref/campos.html
   */
  CAMPOS("campos"),
  /*
   * Set or query projection type
   * @see http://www.mathworks.com/matlab/matlab/ref/camproj.html
   */
  CAMPROJ("camproj"),
  /*
   * Rotate camera about view axis
   * @see http://www.mathworks.com/matlab/matlab/ref/camroll.html
   */
  CAMROLL("camroll"),
  /*
   * Set or query location of camera target
   * @see http://www.mathworks.com/matlab/matlab/ref/camtarget.html
   */
  CAMTARGET("camtarget"),
  /*
   * Set or query camera up vector
   * @see http://www.mathworks.com/matlab/matlab/ref/camup.html
   */
  CAMUP("camup"),
  /*
   * Set or query camera view angle
   * @see http://www.mathworks.com/matlab/matlab/ref/camva.html
   */
  CAMVA("camva"),

  /*
   * Lighting and Transparency
   */
  /*
   * Create or move light object in camera coordinates
   * @see http://www.mathworks.com/matlab/matlab/ref/camlight.html
   */
  CAMLIGHT("camlight"),
  /*
   * Create light object
   * @see http://www.mathworks.com/matlab/matlab/ref/light.html
   */
  LIGHT("light"),
  /*
   * Create or position light object in spherical coordinates
   * @see http://www.mathworks.com/matlab/matlab/ref/lightangle.html
   */
  LIGHTANGLE("lightangle"),
  /*
   * Specify lighting algorithm
   * @see http://www.mathworks.com/matlab/matlab/ref/lighting.html
   */
  LIGHTING("lighting"),
  /*
   * Calculate diffuse reflectance
   * @see http://www.mathworks.com/matlab/matlab/ref/diffuse.html
   */
  DIFFUSE("diffuse"),
  /*
   * Control reflectance properties of surfaces and patches
   * @see http://www.mathworks.com/matlab/matlab/ref/material.html
   */
  MATERIAL("material"),
  /*
   * Calculate specular reflectance
   * @see http://www.mathworks.com/matlab/matlab/ref/specular.html
   */
  SPECULAR("specular"),
  /*
   * Set or query axes alpha limits
   * @see http://www.mathworks.com/matlab/matlab/ref/alim.html
   */
  ALIM("alim"),
  /*
   * Set transparency properties for objects in current axes
   * @see http://www.mathworks.com/matlab/matlab/ref/alpha.html
   */
  ALPHA("alpha"),
  /*
   * Specify figure alphamap (transparency)
   * @see http://www.mathworks.com/matlab/matlab/ref/alphamap.html
   */
  ALPHAMAP("alphamap"),

  /*
   * Images
   */
  /*
   * Image File Operations
   */
  /*
   * Display image object
   * @see http://www.mathworks.com/matlab/matlab/ref/image.html
   */
  IMAGE("image"),
  /*
   * Scale data and display image object
   * @see http://www.mathworks.com/matlab/matlab/ref/imagesc.html
   */
  IMAGESC("imagesc"),
  /*
   * Read image from graphics file
   * @see http://www.mathworks.com/matlab/matlab/ref/imread.html
   */
//  IMREAD("imread"),
  /*
   * Write image to graphics file
   * @see http://www.mathworks.com/matlab/matlab/ref/imwrite.html
   */
//  IMWRITE("imwrite"),
  /*
   * Information about graphics file
   * @see http://www.mathworks.com/matlab/matlab/ref/imfinfo.html
   */
//  IMFINFO("imfinfo"),
  /*
   * Manage image file format registry
   * @see http://www.mathworks.com/matlab/matlab/ref/imformats.html
   */
  IMFORMATS("imformats"),
  /*
   * Return image data associated with movie frame
   * @see http://www.mathworks.com/matlab/matlab/ref/frame2im.html
   */
//  FRAME2IM("frame2im"),
  /*
   * Convert image to movie frame
   * @see http://www.mathworks.com/matlab/matlab/ref/im2frame.html
   */
//  IM2FRAME("im2frame"),
  /*
   * Convert image to Java image
   * @see http://www.mathworks.com/matlab/matlab/ref/im2java.html
   */
//  IM2JAVA("im2java"),

  /*
   * Modifying Images
   */
  /*
   * Convert indexed image to RGB image
   * @see http://www.mathworks.com/matlab/matlab/ref/ind2rgb.html
   */
  IND2RGB("ind2rgb"),
  /*
   * Convert RGB image to indexed image
   * @see http://www.mathworks.com/matlab/matlab/ref/rgb2ind.html
   */
  RGB2IND("rgb2ind"),
  /*
   * Approximate indexed image by reducing number of colors
   * @see http://www.mathworks.com/matlab/matlab/ref/imapprox.html
   */
  IMAPPROX("imapprox"),
  /*
   * Convert image, increasing apparent color resolution by dithering
   * @see http://www.mathworks.com/matlab/matlab/ref/dither.html
   */
  DITHER("dither"),
  /*
   * Rearrange colors in colormap
   * @see http://www.mathworks.com/matlab/matlab/ref/cmpermute.html
   */
  CMPERMUTE("cmpermute"),
  /*
   * Eliminate duplicate colors in colormap; convert grayscale or truecolor image to indexed image
   * @see http://www.mathworks.com/matlab/matlab/ref/cmunique.html
   */
  CMUNIQUE("cmunique"),

  /*
   * Printing and Exporting
   */
  /*
   * Print figure or save to file
   * @see http://www.mathworks.com/matlab/matlab/ref/print.html
   */
  PRINT("print"),
  /*
   * Configure printer defaults
   * @see http://www.mathworks.com/matlab/matlab/ref/printopt.html
   */
  PRINTOPT("printopt"),
  /*
   * Print dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/printdlg.html
   */
//  PRINTDLG("printdlg"),
  /*
   * Preview figure to print
   * @see http://www.mathworks.com/matlab/matlab/ref/printpreview.html
   */
//  PRINTPREVIEW("printpreview"),
  /*
   * Hardcopy paper orientation
   * @see http://www.mathworks.com/matlab/matlab/ref/orient.html
   */
  ORIENT("orient"),
  /*
   * Save figure to FIG-file
   * @see http://www.mathworks.com/matlab/matlab/ref/savefig.html
   */
  SAVEFIG("savefig"),
  /*
   * Open new copy or raise existing copy of saved figure
   * @see http://www.mathworks.com/matlab/matlab/ref/openfig.html
   */
  OPENFIG("openfig"),
  /*
   * Export figure
   * @see http://www.mathworks.com/matlab/matlab/ref/hgexport.html
   */
  HGEXPORT("hgexport"),
  /*
   * Save Handle Graphics object hierarchy to file
   * @see http://www.mathworks.com/matlab/matlab/ref/hgsave.html
   */
  HGSAVE("hgsave"),
  /*
   * Load Handle Graphics object hierarchy from file
   * @see http://www.mathworks.com/matlab/matlab/ref/hgload.html
   */
  HGLOAD("hgload"),
  /*
   * Save figure or Simulink block diagram using specified format
   * @see http://www.mathworks.com/matlab/matlab/ref/saveas.html
   */
  SAVEAS("saveas"),

  /*
   * Graphics Objects
   */
  /*
   * Graphics Object Identification
   */
  /*
   * Current axes handle
   * @see http://www.mathworks.com/matlab/matlab/ref/gca.html
   */
//  GCA("gca"),
  /*
   * Current figure handle
   * @see http://www.mathworks.com/matlab/matlab/ref/gcf.html
   */
//  GCF("gcf"),
  /*
   * Handle of figure containing object whose callback is executing
   * @see http://www.mathworks.com/matlab/matlab/ref/gcbf.html
   */
  GCBF("gcbf"),
  /*
   * Handle of object whose callback is executing
   * @see http://www.mathworks.com/matlab/matlab/ref/gcbo.html
   */
  GCBO("gcbo"),
  /*
   * Handle of current object
   * @see http://www.mathworks.com/matlab/matlab/ref/gco.html
   */
  GCO("gco"),
  /*
   * Ancestor of graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/ancestor.html
   */
  ANCESTOR("ancestor"),
  /*
   * Find all children of specified objects
   * @see http://www.mathworks.com/matlab/matlab/ref/allchild.html
   */
  ALLCHILD("allchild"),
  /*
   * Find all graphics objects
   * @see http://www.mathworks.com/matlab/matlab/ref/findall.html
   */
  FINDALL("findall"),
  /*
   * Find visible offscreen figures
   * @see http://www.mathworks.com/matlab/matlab/ref/findfigs.html
   */
  FINDFIGS("findfigs"),
  /*
   * Locate graphics objects with specific properties
   * @see http://www.mathworks.com/matlab/matlab/ref/findobj.html
   */
//  FINDOBJ("findobj"),
  /*
   * Create array of graphics handles
   * @see http://www.mathworks.com/matlab/matlab/ref/gobjects.html
   */
  GOBJECTS("gobjects"),
  /*
   * True for Handle Graphics object handles
   * @see http://www.mathworks.com/matlab/matlab/ref/ishghandle.html
   */
//  ISHGHANDLE("ishghandle"),
  /*
   * Test for valid graphics or Java object handle
   * @see http://www.mathworks.com/matlab/matlab/ref/ishandle.html
   */
  ISHANDLE("ishandle"),
  /*
   * Copy graphics objects and their descendants
   * @see http://www.mathworks.com/matlab/matlab/ref/copyobj.html
   */
  COPYOBJ("copyobj"),
  /*
   * Remove files or objects
   * @see http://www.mathworks.com/matlab/matlab/ref/delete.html
   */
//  DELETE("delete"),
  /*
   * Query Handle Graphics object properties
   * @see http://www.mathworks.com/matlab/matlab/ref/get.html
   */
//  GET("get"),
  /*
   * Set Handle Graphics object properties
   * @see http://www.mathworks.com/matlab/matlab/ref/set.html
   */
//  SET("set"),
  /*
   * Open Property Editor
   * @see http://www.mathworks.com/matlab/matlab/ref/propedit.html
   */
//  PROPEDIT("propedit"),

  /*
   * Core Objects   */
  /*
   * Root
   * @see http://www.mathworks.com/matlab/matlab/ref/rootobject.html
   */
  ROOT_OBJECT("root object"),
  /*
   * Create figure graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/figure.html
   */
//  FIGURE("figure"),
  /*
   * Create axes graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/axes.html
   */
//  AXES("axes"),
  /*
   * Display image object
   * @see http://www.mathworks.com/matlab/matlab/ref/image.html
   */
//  IMAGE("image"),
  /*
   * Create light object
   * @see http://www.mathworks.com/matlab/matlab/ref/light.html
   */
//  LIGHT("light"),
  /*
   * Create line object
   * @see http://www.mathworks.com/matlab/matlab/ref/line.html
   */
  LINE("line"),
  /*
   * Create one or more filled polygons
   * @see http://www.mathworks.com/matlab/matlab/ref/patch.html
   */
//  PATCH("patch"),
  /*
   * Create 2-D rectangle object
   * @see http://www.mathworks.com/matlab/matlab/ref/rectangle.html
   */
  RECTANGLE("rectangle"),
  /*
   * Create surface object
   * @see http://www.mathworks.com/matlab/matlab/ref/surface.html
   */
//  SURFACE("surface"),
  /*
   * Create text object in current axes
   * @see http://www.mathworks.com/matlab/matlab/ref/text.html
   */
  TEXT("text"),

  /*
   * Annotation Objects
   */
  /*
   * Create annotation objects
   * @see http://www.mathworks.com/matlab/matlab/ref/annotation.html
   */
  ANNOTATION("annotation"),

  /*
   * Plot Objects
   */
  /*
   * Set Handle Graphics object properties
   * @see http://www.mathworks.com/matlab/matlab/ref/set.html
   */
//  SET("set"),
  /*
   * Query Handle Graphics object properties
   * @see http://www.mathworks.com/matlab/matlab/ref/get.html
   */
//  GET("get"),

  /*
   * Group Objects
   */
  /*
   * Create hggroup object
   * @see http://www.mathworks.com/matlab/matlab/ref/hggroup.html
   */
  HGGROUP("hggroup"),
  /*
   * Create hgtransform graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/hgtransform.html
   */
  HGTRANSFORM("hgtransform"),
  /*
   * Create 4-by-4 transform matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/makehgtform.html
   */
  MAKEHGTFORM("makehgtform"),

  /*
   * Figure Windows
   */
  /*
   * Create figure graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/figure.html
   */
  FIGURE("figure"),
  /*
   * Current figure handle
   * @see http://www.mathworks.com/matlab/matlab/ref/gcf.html
   */
  GCF("gcf"),
  /*
   * Remove specified figure
   * @see http://www.mathworks.com/matlab/matlab/ref/close.html
   */
  CLOSE("close"),
  /*
   * Clear current figure window
   * @see http://www.mathworks.com/matlab/matlab/ref/clf.html
   */
  CLF("clf"),
  /*
   * Redraw current figure
   * @see http://www.mathworks.com/matlab/matlab/ref/refresh.html
   */
  REFRESH("refresh"),
  /*
   * Determine where to draw graphics objects
   * @see http://www.mathworks.com/matlab/matlab/ref/newplot.html
   */
  NEWPLOT("newplot"),
  /*
   * Show most recent graph window
   * @see http://www.mathworks.com/matlab/matlab/ref/shg.html
   */
  SHG("shg"),
  /*
   * Default figure close request function
   * @see http://www.mathworks.com/matlab/matlab/ref/closereq.html
   */
  CLOSEREQ("closereq"),
  /*
   * Drag rectangles with mouse
   * @see http://www.mathworks.com/matlab/matlab/ref/dragrect.html
   */
  DRAGRECT("dragrect"),
  /*
   * Update figure window and execute pending callbacks
   * @see http://www.mathworks.com/matlab/matlab/ref/drawnow.html
   */
  DRAWNOW("drawnow"),
  /*
   * Create rubberband box for area selection
   * @see http://www.mathworks.com/matlab/matlab/ref/rbbox.html
   */
  RBBOX("rbbox"),
  /*
   * Control OpenGL rendering
   * @see http://www.mathworks.com/matlab/matlab/ref/opengl.html
   */
  OPENGL("opengl"),

  /*
   * Axes Property Operations
   */
  /*
   * Create axes graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/axes.html
   */
  AXES("axes"),
  /*
   * Retain current graph when adding new graphs
   * @see http://www.mathworks.com/matlab/matlab/ref/hold.html
   */
  HOLD("hold"),
  /*
   * Current hold state
   * @see http://www.mathworks.com/matlab/matlab/ref/ishold.html
   */
  ISHOLD("ishold"),
  /*
   * Determine where to draw graphics objects
   * @see http://www.mathworks.com/matlab/matlab/ref/newplot.html
   */
//  NEWPLOT("newplot"),

  /*
   * Object Property Operations
   */
  /*
   * Synchronize limits of specified 2-D axes
   * @see http://www.mathworks.com/matlab/matlab/ref/linkaxes.html
   */
  LINKAXES("linkaxes"),
  /*
   * Keep same value for corresponding properties of graphics objects
   * @see http://www.mathworks.com/matlab/matlab/ref/linkprop.html
   */
  LINKPROP("linkprop"),
  /*
   * Refresh data in graph when data source is specified
   * @see http://www.mathworks.com/matlab/matlab/ref/refreshdata.html
   */
  REFRESHDATA("refreshdata"),
  /*
   * Block execution and wait for event or condition
   * @see http://www.mathworks.com/matlab/matlab/ref/waitfor.html
   */
  WAITFOR("waitfor"),
  /*
   * Query Handle Graphics object properties
   * @see http://www.mathworks.com/matlab/matlab/ref/get.html
   */
//  GET("get"),
  /*
   * Set Handle Graphics object properties
   * @see http://www.mathworks.com/matlab/matlab/ref/set.html
   */
//  SET("set"),

  /*
   * Programming Scripts and Functions
   */
  /*
   * Control Flow   */
  /*
   * Execute statements if condition is true
   * @see http://www.mathworks.com/matlab/matlab/ref/if.html
   */
  IF("if"), 
  ELSEIF("elseif"), 
  ELSE("else"),
  /*
   * Execute statements specified number of times
   * @see http://www.mathworks.com/matlab/matlab/ref/for.html
   */
  FOR("for"),
  /*
   * Parallel for loop
   * @see http://www.mathworks.com/matlab/matlab/ref/parfor.html
   */
  PARFOR("parfor"),
  /*
   * Switch among several cases based on expression
   * @see http://www.mathworks.com/matlab/ref/switch.html
   */
  SWITCH("switch"),
  CASE("case"),
  OTHERWISE("otherwise"),
  /*
   * Execute statements and catch resulting errors
   * @see http://www.mathworks.com/matlab/matlab/ref/try.html
   */
  TRY("try"),
  CATCH("catch"),
  /*
   * Repeatedly execute statements while condition is true
   * @see http://www.mathworks.com/matlab/matlab/ref/while.html
   */
  WHILE("while"),
  /*
   * Terminate execution of for or while loop
   * @see http://www.mathworks.com/matlab/matlab/ref/break.html
   */
  BREAK("break"),
  /*
   * Pass control to next iteration of for or while loop
   * @see http://www.mathworks.com/matlab/matlab/ref/continue.html
   */
  CONTINUE("continue"),
  /*
   * Terminate block of code, or indicate last array index
   * @see http://www.mathworks.com/matlab/matlab/ref/end.html
   */
//  END("end"),
  /*
   * Halt execution temporarily
   * @see http://www.mathworks.com/matlab/matlab/ref/pause.html
   */
  PAUSE("pause"),
  /*
   * Return to invoking function
   * @see http://www.mathworks.com/matlab/matlab/ref/return.html
   */
  RETURN("return"),

  /*
   * Scripts
   */
  /*
   * Edit or create file
   * @see http://www.mathworks.com/matlab/matlab/ref/edit.html
   */
  EDIT("edit"),
  /*
   * Request user input
   * @see http://www.mathworks.com/matlab/matlab/ref/input.html
   */
  INPUT("input"),
  /*
   * Generate view of MATLAB file in specified format
   * @see http://www.mathworks.com/matlab/matlab/ref/publish.html
   */
  PUBLISH("publish"),
  /*
   * Open MATLAB Notebook in Microsoft Word software (on Microsoft Windows platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/notebook.html
   */
  NOTEBOOK("notebook"),
  /*
   * Extract MATLAB code from file published to HTML
   * @see http://www.mathworks.com/matlab/matlab/ref/grabcode.html
   */
  GRABCODE("grabcode"),
  /*
   * Force snapshot of image for inclusion in published document
   * @see http://www.mathworks.com/matlab/matlab/ref/snapnow.html
   */
  SNAPNOW("snapnow"),

  /*
   * Functions
   */
  /*
   * Function Basics
   */
  /*
   * Declare function name, inputs, and outputs
   * @see http://www.mathworks.com/matlab/matlab/ref/function.html
   */
  FUNCTION("function"),

  /*
   * Input and Output Arguments
   */
  /*
   * Number of function input arguments
   * @see http://www.mathworks.com/matlab/matlab/ref/nargin.html
   */
  NARGIN("nargin"),
  /*
   * Number of function output arguments
   * @see http://www.mathworks.com/matlab/matlab/ref/nargout.html
   */
  NARGOUT("nargout"),
  /*
   * Variable-length input argument list
   * @see http://www.mathworks.com/matlab/matlab/ref/varargin.html
   */
  VARARGIN("varargin"),
  /*
   * Variable-length output argument list
   * @see http://www.mathworks.com/matlab/matlab/ref/varargout.html
   */
  VARARGOUT("varargout"),
  /*
   * Validate number of input arguments
   * @see http://www.mathworks.com/matlab/matlab/ref/narginchk.html
   */
  NARGINCHK("narginchk"),
  /*
   * Validate number of output arguments
   * @see http://www.mathworks.com/matlab/matlab/ref/nargoutchk.html
   */
  NARGOUTCHK("nargoutchk"),
  /*
   * Check validity of array
   * @see http://www.mathworks.com/matlab/matlab/ref/validateattributes.html
   */
//  VALIDATEATTRIBUTES("validateattributes"),
  /*
   * Check validity of text string
   * @see http://www.mathworks.com/matlab/matlab/ref/validatestring.html
   */
//  VALIDATESTRING("validatestring"),
  /*
   * Parse function inputs
   * @see http://www.mathworks.com/matlab/matlab/ref/inputparser-class.html
   */
  INPUTPARSER("inputparser"),
  /*
   * Variable name of function input
   * @see http://www.mathworks.com/matlab/matlab/ref/inputname.html
   */
  INPUTNAME("inputname"),

  /*
   * Variables
   */
  /*
   * Define persistent variable
   * @see http://www.mathworks.com/matlab/matlab/ref/persistent.html
   */
  PERSISTENT("persistent"),
  /*
   * Determine whether input is valid variable name
   * @see http://www.mathworks.com/matlab/matlab/ref/isvarname.html
   */
  ISVARNAME("isvarname"),
  /*
   * Construct unique strings from input strings
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.lang.makeuniquestrings.html
   */
  MATLAB_LANG_MAKEUNIQUESTRINGS("matlab.lang.makeuniquestrings"),
  /*
   * Construct valid MATLAB identifiers from input strings
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.lang.makevalidname.html
   */
  MATLAB_LANG_MAKEVALIDNAME("matlab.lang.makevalidname"),
  /*
   * Maximum identifier length
   * @see http://www.mathworks.com/matlab/matlab/ref/namelengthmax.html
   */
  NAMELENGTHMAX("namelengthmax"),
  /*
   * Assign value to variable in specified workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/assignin.html
   */
  ASSIGNIN("assignin"),
  /*
   * Declare global variables
   * @see http://www.mathworks.com/matlab/matlab/ref/global.html
   */
  GLOBAL("global"),
  /*
   * Determine whether input is global variable
   * @see http://www.mathworks.com/matlab/matlab/ref/isglobal.html
   */
  ISGLOBAL("isglobal"),

  /*
   * Error Handling
   */
  /*
   * Execute statements and catch resulting errors
   * @see http://www.mathworks.com/matlab/matlab/ref/try.html
   */
//  TRY("try"),
//  CATCH("catch"),
  /*
   * Display message and abort function
   * @see http://www.mathworks.com/matlab/matlab/ref/error.html
   */
  ERROR("error"),
  /*
   * Warning message
   * @see http://www.mathworks.com/matlab/matlab/ref/warning.html
   */
  WARNING("warning"),
  /*
   * Last warning message
   * @see http://www.mathworks.com/matlab/matlab/ref/lastwarn.html
   */
  LASTWARN("lastwarn"),
  /*
   * Generate error when condition is violated
   * @see http://www.mathworks.com/matlab/matlab/ref/assert.html
   */
  ASSERT("assert"),
  /*
   * Cleanup tasks upon function completion
   * @see http://www.mathworks.com/matlab/matlab/ref/oncleanup.html
   */
  ONCLEANUP("oncleanup"),

  /*
   * Debugging
   */
  /*
   * Clear breakpoints
   * @see http://www.mathworks.com/matlab/matlab/ref/dbclear.html
   */
  DBCLEAR("dbclear"),
  /*
   * Resume execution
   * @see http://www.mathworks.com/matlab/matlab/ref/dbcont.html
   */
  DBCONT("dbcont"),
  /*
   * Reverse workspace shift performed by dbup, while in debug mode
   * @see http://www.mathworks.com/matlab/matlab/ref/dbdown.html
   */
  DBDOWN("dbdown"),
  /*
   * Quit debug mode
   * @see http://www.mathworks.com/matlab/matlab/ref/dbquit.html
   */
  DBQUIT("dbquit"),
  /*
   * Function call stack
   * @see http://www.mathworks.com/matlab/matlab/ref/dbstack.html
   */
  DBSTACK("dbstack"),
  /*
   * List all breakpoints
   * @see http://www.mathworks.com/matlab/matlab/ref/dbstatus.html
   */
  DBSTATUS("dbstatus"),
  /*
   * Execute one or more lines from current breakpoint
   * @see http://www.mathworks.com/matlab/matlab/ref/dbstep.html
   */
  DBSTEP("dbstep"),
  /*
   * Set breakpoints for debugging
   * @see http://www.mathworks.com/matlab/matlab/ref/dbstop.html
   */
  DBSTOP("dbstop"),
  /*
   * List text file with line numbers
   * @see http://www.mathworks.com/matlab/matlab/ref/dbtype.html
   */
  DBTYPE("dbtype"),
  /*
   * Shift current workspace to workspace of caller, while in debug mode
   * @see http://www.mathworks.com/matlab/matlab/ref/dbup.html
   */
  DBUP("dbup"),
  /*
   * Check MATLAB code files for possible problems
   * @see http://www.mathworks.com/matlab/matlab/ref/checkcode.html
   */
  CHECKCODE("checkcode"),
  /*
   * Input from keyboard
   * @see http://www.mathworks.com/matlab/matlab/ref/keyboard.html
   */
  KEYBOARD("keyboard"),
  /*
   * Run checkcode for file or folder, reporting results in browser
   * @see http://www.mathworks.com/matlab/matlab/ref/mlintrpt.html
   */
  MLINTRPT("mlintrpt"),

  /*
   * Coding and Productivity Tips
   */
  /*
   * Edit or create file
   * @see http://www.mathworks.com/matlab/matlab/ref/edit.html
   */
//  EDIT("edit"),

  /*
   * Programming Utilities
   */
  /*
   * Display statements during function execution
   * @see http://www.mathworks.com/matlab/matlab/ref/echo.html
   */
  ECHO("echo"),
  /*
   * Execute MATLAB expression in text string
   * @see http://www.mathworks.com/matlab/matlab/ref/eval.html
   */
  EVAL("eval"),
  /*
   * Evaluate MATLAB expression with capture
   * @see http://www.mathworks.com/matlab/matlab/ref/evalc.html
   */
  EVALC("evalc"),
  /*
   * Execute MATLAB expression in specified workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/evalin.html
   */
  EVALIN("evalin"),
  /*
   * Evaluate function
   * @see http://www.mathworks.com/matlab/matlab/ref/feval.html
   */
//  FEVAL("feval"),
  /*
   * Run MATLAB script
   * @see http://www.mathworks.com/matlab/matlab/ref/run.html
   */
  RUN("run"),
  /*
   * Execute built-in function from overloaded method
   * @see http://www.mathworks.com/matlab/matlab/ref/builtin.html
   */
  BUILTIN("builtin"),
  /*
   * List dependencies of MATLAB program files
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.codetools.requiredfilesandproducts.html
   */
  MATLAB_CODETOOLS_REQUIREDFILESANDPRODUCTS("matlab.codetools.requiredfilesandproducts"),
  /*
   * File name of currently running function
   * @see http://www.mathworks.com/matlab/matlab/ref/mfilename.html
   */
  MFILENAME("mfilename"),
  /*
   * Create protected function file
   * @see http://www.mathworks.com/matlab/matlab/ref/pcode.html
   */
  PCODE("pcode"),
  /*
   * Create object to schedule execution of MATLAB commands
   * @see http://www.mathworks.com/matlab/matlab/ref/timer-class.html
   */
  TIMER("timer"),

  /*
   * Data and File Management
   */
  /*
   * Workspace Variables
   */
  /*
   * Remove items from workspace, freeing up system memory
   * @see http://www.mathworks.com/matlab/matlab/ref/clear.html
   */
  CLEAR("clear"),
  /*
   * Clear variables from memory
   * @see http://www.mathworks.com/matlab/matlab/ref/clearvars.html
   */
  CLEARVARS("clearvars"),
  /*
   * Display text or array
   * @see http://www.mathworks.com/matlab/matlab/ref/disp.html
   */
  DISP("disp"),
  /*
   * Open workspace variable in Variables editor or other graphical editing tool
   * @see http://www.mathworks.com/matlab/matlab/ref/openvar.html
   */
  OPENVAR("openvar"),
  /*
   * List variables in workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/who.html
   */
  WHO("who"),
  /*
   * List variables in workspace, with sizes and types
   * @see http://www.mathworks.com/matlab/matlab/ref/whos.html
   */
//  WHOS("whos"),
  /*
   * Load variables from file into workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/load.html
   */
  LOAD("load"),
  /*
   * Save workspace variables to file
   * @see http://www.mathworks.com/matlab/matlab/ref/save.html
   */
  SAVE("save"),
  /*
   * Access and change variables directly in MAT-files, without loading into memory
   * @see http://www.mathworks.com/matlab/matlab/ref/matfile.html
   */
  MATFILE("matfile"),

  /*
   * Data Import and Export
   */
  /*
   * Import and Export Basics
   */
  /*
   * Load data from file
   * @see http://www.mathworks.com/matlab/matlab/ref/importdata.html
   */
  IMPORTDATA("importdata"),
  /*
   * Import data interactively
   * @see http://www.mathworks.com/matlab/matlab/ref/uiimport.html
   */
  UIIMPORT("uiimport"),

  /*
   * Text Files
   */
  /*
   * Read comma-separated value file
   * @see http://www.mathworks.com/matlab/matlab/ref/csvread.html
   */
  CSVREAD("csvread"),
  /*
   * Write comma-separated value file
   * @see http://www.mathworks.com/matlab/matlab/ref/csvwrite.html
   */
  CSVWRITE("csvwrite"),
  /*
   * Read ASCII-delimited file of numeric data into matrix
   * @see http://www.mathworks.com/matlab/matlab/ref/dlmread.html
   */
  DLMREAD("dlmread"),
  /*
   * Write matrix to ASCII-delimited file
   * @see http://www.mathworks.com/matlab/matlab/ref/dlmwrite.html
   */
  DLMWRITE("dlmwrite"),
  /*
   * Read formatted data from text file or string
   * @see http://www.mathworks.com/matlab/matlab/ref/textscan.html
   */
  TEXTSCAN("textscan"),
  /*
   * Create table from file
   * @see http://www.mathworks.com/matlab/matlab/ref/readtable.html
   */
//  READTABLE("readtable"),
  /*
   * Write table to file
   * @see http://www.mathworks.com/matlab/matlab/ref/writetable.html
   */
//  WRITETABLE("writetable"),
  /*
   * Display contents of file
   * @see http://www.mathworks.com/matlab/matlab/ref/type.html
   */
  TYPE("type"),

  /*
   * Spreadsheets
   */
  /*
   * Determine if file contains Microsoft Excel spreadsheet
   * @see http://www.mathworks.com/matlab/matlab/ref/xlsfinfo.html
   */
  XLSFINFO("xlsfinfo"),
  /*
   * Read Microsoft Excel spreadsheet file
   * @see http://www.mathworks.com/matlab/matlab/ref/xlsread.html
   */
  XLSREAD("xlsread"),
  /*
   * Write Microsoft Excel spreadsheet file
   * @see http://www.mathworks.com/matlab/matlab/ref/xlswrite.html
   */
  XLSWRITE("xlswrite"),
  /*
   * Create table from file
   * @see http://www.mathworks.com/matlab/matlab/ref/readtable.html
   */
//  READTABLE("readtable"),
  /*
   * Write table to file
   * @see http://www.mathworks.com/matlab/matlab/ref/writetable.html
   */
//  WRITETABLE("writetable"),

  /*
   * Low-Level File I/O
   */
  /*
   * Close one or all open files
   * @see http://www.mathworks.com/matlab/matlab/ref/fclose.html
   */
  FCLOSE("fclose"),
  /*
   * Test for end-of-file
   * @see http://www.mathworks.com/matlab/matlab/ref/feof.html
   */
  FEOF("feof"),
  /*
   * Information about file I/O errors
   * @see http://www.mathworks.com/matlab/matlab/ref/ferror.html
   */
  FERROR("ferror"),
  /*
   * Read line from file, removing newline characters
   * @see http://www.mathworks.com/matlab/matlab/ref/fgetl.html
   */
  FGETL("fgetl"),
  /*
   * Read line from file, keeping newline characters
   * @see http://www.mathworks.com/matlab/matlab/ref/fgets.html
   */
  FGETS("fgets"),
  /*
   * Read contents of file into string
   * @see http://www.mathworks.com/matlab/matlab/ref/fileread.html
   */
  FILEREAD("fileread"),
  /*
   * Open file, or obtain information about open files
   * @see http://www.mathworks.com/matlab/matlab/ref/fopen.html
   */
  FOPEN("fopen"),
  /*
   * Write data to text file
   * @see http://www.mathworks.com/matlab/matlab/ref/fprintf.html
   */
  FPRINTF("fprintf"),
  /*
   * Read data from binary file
   * @see http://www.mathworks.com/matlab/matlab/ref/fread.html
   */
  FREAD("fread"),
  /*
   * Move file position indicator to beginning of open file
   * @see http://www.mathworks.com/matlab/matlab/ref/frewind.html
   */
  FREWIND("frewind"),
  /*
   * Read data from text file
   * @see http://www.mathworks.com/matlab/matlab/ref/fscanf.html
   */
  FSCANF("fscanf"),
  /*
   * Move to specified position in file
   * @see http://www.mathworks.com/matlab/matlab/ref/fseek.html
   */
  FSEEK("fseek"),
  /*
   * Position in open file
   * @see http://www.mathworks.com/matlab/matlab/ref/ftell.html
   */
  FTELL("ftell"),
  /*
   * Write data to binary file
   * @see http://www.mathworks.com/matlab/matlab/ref/fwrite.html
   */
  FWRITE("fwrite"),

  /*
   * Images
   */
  /*
   * Convert image to Java image
   * @see http://www.mathworks.com/matlab/matlab/ref/im2java.html
   */
  IM2JAVA("im2java"),
  /*
   * Information about graphics file
   * @see http://www.mathworks.com/matlab/matlab/ref/imfinfo.html
   */
  IMFINFO("imfinfo"),
  /*
   * Read image from graphics file
   * @see http://www.mathworks.com/matlab/matlab/ref/imread.html
   */
  IMREAD("imread"),
  /*
   * Write image to graphics file
   * @see http://www.mathworks.com/matlab/matlab/ref/imwrite.html
   */
  IMWRITE("imwrite"),
  /*
   * MATLAB Gateway to LibTIFF library routines
   * @see http://www.mathworks.com/matlab/matlab/ref/tiff-class.html
   */
  TIFF("tiff"),

  /*
   * Scientific Data
   */
  /*
   * netCDF Files   */
  /*
   * Create variable in NetCDF file
   * @see http://www.mathworks.com/matlab/matlab/ref/nccreate.html
   */
  NCCREATE("nccreate"),
  /*
   * Display contents of NetCDF data source in Command Window
   * @see http://www.mathworks.com/matlab/matlab/ref/ncdisp.html
   */
  NCDISP("ncdisp"),
  /*
   *  Return information about NetCDF data source
   * @see http://www.mathworks.com/matlab/matlab/ref/ncinfo.html
   */
  NCINFO("ncinfo"),
  /*
   * Read data from variable in NetCDF data source
   * @see http://www.mathworks.com/matlab/matlab/ref/ncread.html
   */
  NCREAD("ncread"),
  /*
   *  Read attribute value from NetCDF data source
   * @see http://www.mathworks.com/matlab/matlab/ref/ncreadatt.html
   */
  NCREADATT("ncreadatt"),
  /*
   *  Write data to NetCDF file
   * @see http://www.mathworks.com/matlab/matlab/ref/ncwrite.html
   */
  NCWRITE("ncwrite"),
  /*
   * Write attribute to NetCDF file
   * @see http://www.mathworks.com/matlab/matlab/ref/ncwriteatt.html
   */
  NCWRITEATT("ncwriteatt"),
  /*
   * Add NetCDF schema definitions to NetCDF file
   * @see http://www.mathworks.com/matlab/matlab/ref/ncwriteschema.html
   */
  NCWRITESCHEMA("ncwriteschema"),
  /*
   * Summary of MATLAB Network Common Data Form (NetCDF) capabilities
   * @see http://www.mathworks.com/matlab/matlab/ref/netcdf.html
   */
  NETCDF("netcdf"),

  /*
   * HDF5 Files
   */
  /*
   * High-Level Functions
   */
  /*
   * Create HDF5 data set
   * @see http://www.mathworks.com/matlab/matlab/ref/h5create.html
   */
  H5CREATE("h5create"),
  /*
   * Display contents of HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5disp.html
   */
  H5DISP("h5disp"),
  /*
   * Return information about HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5info.html
   */
  H5INFO("h5info"),
  /*
   * Read data from HDF5 data set
   * @see http://www.mathworks.com/matlab/matlab/ref/h5read.html
   */
  H5READ("h5read"),
  /*
   * Read attribute from HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5readatt.html
   */
  H5READATT("h5readatt"),
  /*
   * Write to HDF5 data set
   * @see http://www.mathworks.com/matlab/matlab/ref/h5write.html
   */
  H5WRITE("h5write"),
  /*
   * Write HDF5 attribute
   * @see http://www.mathworks.com/matlab/matlab/ref/h5writeatt.html
   */
  H5WRITEATT("h5writeatt"),

  /*
   * Low-Level Functions
   */
  /*
   * Library (H5)   */
  /*
   * Close HDF5 library
   * @see http://www.mathworks.com/matlab/matlab/ref/h5.close.html
   */
  H5_CLOSE("h5.close"),
  /*
   * Free unused memory in HDF5 library
   * @see http://www.mathworks.com/matlab/matlab/ref/h5.garbage_collect.html
   */
  H5_GARBAGE_COLLECT("h5.garbage_collect"),
  /*
   * Version of HDF5 library
   * @see http://www.mathworks.com/matlab/matlab/ref/h5.get_libversion.html
   */
  H5_GET_LIBVERSION("h5.get_libversion"),
  /*
   * Open HDF5 library
   * @see http://www.mathworks.com/matlab/matlab/ref/h5.open.html
   */
  H5_OPEN("h5.open"),
  /*
   * Set size limits on free lists
   * @see http://www.mathworks.com/matlab/matlab/ref/h5.set_free_list_limits.html
   */
  H5_SET_FREE_LIST_LIMITS("h5.set_free_list_limits"),

  /*
   * Attribute (H5A)   */
  /*
   * Close specified attribute
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.close.html
   */
  H5A_CLOSE("h5a.close"),
  /*
   * Create attribute
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.create.html
   */
  H5A_CREATE("h5a.create"),
  /*
   * Delete attribute
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.delete.html
   */
  H5A_DELETE("h5a.delete"),
  /*
   * Information about attribute
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.get_info.html
   */
  H5A_GET_INFO("h5a.get_info"),
  /*
   * Attribute name
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.get_name.html
   */
  H5A_GET_NAME("h5a.get_name"),
  /*
   * Copy of attribute data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.get_space.html
   */
  H5A_GET_SPACE("h5a.get_space"),
  /*
   * Copy of attribute data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.get_type.html
   */
  H5A_GET_TYPE("h5a.get_type"),
  /*
   * Execute function for attributes attached to object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.iterate.html
   */
  H5A_ITERATE("h5a.iterate"),
  /*
   * Open attribute
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.open.html
   */
  H5A_OPEN("h5a.open"),
  /*
   * Open attribute specified by index
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.open_by_idx.html
   */
  H5A_OPEN_BY_IDX("h5a.open_by_idx"),
  /*
   * Open attribute specified by name
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.open_by_name.html
   */
  H5A_OPEN_BY_NAME("h5a.open_by_name"),
  /*
   * Read attribute
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.read.html
   */
  H5A_READ("h5a.read"),
  /*
   * Write attribute
   * @see http://www.mathworks.com/matlab/matlab/ref/h5a.write.html
   */
  H5A_WRITE("h5a.write"),

  /*
   * Dataset (H5D)   */
  /*
   * Close dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.close.html
   */
  H5D_CLOSE("h5d.close"),
  /*
   * Create new dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.create.html
   */
  H5D_CREATE("h5d.create"),
  /*
   * Copy of dataset access property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.get_access_plist.html
   */
  H5D_GET_ACCESS_PLIST("h5d.get_access_plist"),
  /*
   * Copy of dataset creation property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.get_create_plist.html
   */
  H5D_GET_CREATE_PLIST("h5d.get_create_plist"),
  /*
   * Location of dataset in file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.get_offset.html
   */
  H5D_GET_OFFSET("h5d.get_offset"),
  /*
   * Copy of dataset data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.get_space.html
   */
  H5D_GET_SPACE("h5d.get_space"),
  /*
   * Determine if space is allocated
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.get_space_status.html
   */
  H5D_GET_SPACE_STATUS("h5d.get_space_status"),
  /*
   * Determine required storage size
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.get_storage_size.html
   */
  H5D_GET_STORAGE_SIZE("h5d.get_storage_size"),
  /*
   * Copy of datatype
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.get_type.html
   */
  H5D_GET_TYPE("h5d.get_type"),
  /*
   * Open specified dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.open.html
   */
  H5D_OPEN("h5d.open"),
  /*
   * Read data from HDF5 dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.read.html
   */
  H5D_READ("h5d.read"),
  /*
   * Change size of dataset dimensions
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.set_extent.html
   */
  H5D_SET_EXTENT("h5d.set_extent"),
  /*
   * Determine variable length storage requirements
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.vlen_get_buf_size.html
   */
  H5D_VLEN_GET_BUF_SIZE("h5d.vlen_get_buf_size"),
  /*
   * Write data to HDF5 dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5d.write.html
   */
  H5D_WRITE("h5d.write"),

  /*
   * Dimension Scale (H5DS)   */
  /*
   * Attach dimension scale to specific dataset dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.attach_scale.html
   */
  H5DS_ATTACH_SCALE("h5ds.attach_scale"),
  /*
   * Detach dimension scale from specific dataset dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.detach_scale.html
   */
  H5DS_DETACH_SCALE("h5ds.detach_scale"),
  /*
   * Retrieve label from specific dataset dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.get_label.html
   */
  H5DS_GET_LABEL("h5ds.get_label"),
  /*
   * Number of scales attached to dataset dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.get_num_scales.html
   */
  H5DS_GET_NUM_SCALES("h5ds.get_num_scales"),
  /*
   * Name of dimension scale
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.get_scale_name.html
   */
  H5DS_GET_SCALE_NAME("h5ds.get_scale_name"),
  /*
   * Determine if dataset is a dimension scale
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.is_scale.html
   */
  H5DS_IS_SCALE("h5ds.is_scale"),
  /*
   * Iterate on scales attached to dataset dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.iterate_scales.html
   */
  H5DS_ITERATE_SCALES("h5ds.iterate_scales"),
  /*
   * Set label for dataset dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.set_label.html
   */
  H5DS_SET_LABEL("h5ds.set_label"),
  /*
   * Convert dataset to dimension scale
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ds.set_scale.html
   */
  H5DS_SET_SCALE("h5ds.set_scale"),

  /*
   * Error (H5E)   */
  /*
   * Clear error stack
   * @see http://www.mathworks.com/matlab/matlab/ref/h5e.clear.html
   */
  H5E_CLEAR("h5e.clear"),
  /*
   * Description of major error number
   * @see http://www.mathworks.com/matlab/matlab/ref/h5e.get_major.html
   */
  H5E_GET_MAJOR("h5e.get_major"),
  /*
   * Description of minor error number
   * @see http://www.mathworks.com/matlab/matlab/ref/h5e.get_minor.html
   */
  H5E_GET_MINOR("h5e.get_minor"),
  /*
   * Walk error stack
   * @see http://www.mathworks.com/matlab/matlab/ref/h5e.walk.html
   */
  H5E_WALK("h5e.walk"),

  /*
   * File (H5F)   */
  /*
   * Close HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.close.html
   */
  H5F_CLOSE("h5f.close"),
  /*
   * Create HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.create.html
   */
  H5F_CREATE("h5f.create"),
  /*
   * Flush buffers to disk
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.flush.html
   */
  H5F_FLUSH("h5f.flush"),
  /*
   * File access property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_access_plist.html
   */
  H5F_GET_ACCESS_PLIST("h5f.get_access_plist"),
  /*
   * File creation property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_create_plist.html
   */
  H5F_GET_CREATE_PLIST("h5f.get_create_plist"),
  /*
   * Size of HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_filesize.html
   */
  H5F_GET_FILESIZE("h5f.get_filesize"),
  /*
   * Amount of free space in file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_freespace.html
   */
  H5F_GET_FREESPACE("h5f.get_freespace"),
  /*
   * Global information about file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_info.html
   */
  H5F_GET_INFO("h5f.get_info"),
  /*
   * Metadata cache configuration
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_mdc_config.html
   */
  H5F_GET_MDC_CONFIG("h5f.get_mdc_config"),
  /*
   * Metadata cache hit-rate
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_mdc_hit_rate.html
   */
  H5F_GET_MDC_HIT_RATE("h5f.get_mdc_hit_rate"),
  /*
   * Metadata cache size data
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_mdc_size.html
   */
  H5F_GET_MDC_SIZE("h5f.get_mdc_size"),
  /*
   * Name of HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_name.html
   */
  H5F_GET_NAME("h5f.get_name"),
  /*
   * Number of open objects in HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_obj_count.html
   */
  H5F_GET_OBJ_COUNT("h5f.get_obj_count"),
  /*
   * List of open HDF5 file objects
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.get_obj_ids.html
   */
  H5F_GET_OBJ_IDS("h5f.get_obj_ids"),
  /*
   * Determine if file is HDF5
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.is_hdf5.html
   */
  H5F_IS_HDF5("h5f.is_hdf5"),
  /*
   * Mount HDF5 file onto specified location
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.mount.html
   */
  H5F_MOUNT("h5f.mount"),
  /*
   * Open HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.open.html
   */
  H5F_OPEN("h5f.open"),
  /*
   * Reopen HDF5 file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.reopen.html
   */
  H5F_REOPEN("h5f.reopen"),
  /*
   * Configure HDF5 file metadata cache
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.set_mdc_config.html
   */
  H5F_SET_MDC_CONFIG("h5f.set_mdc_config"),
  /*
   * Unmount file or group from mount point
   * @see http://www.mathworks.com/matlab/matlab/ref/h5f.unmount.html
   */
  H5F_UNMOUNT("h5f.unmount"),

  /*
   * Group (H5G)   */
  /*
   * Close group
   * @see http://www.mathworks.com/matlab/matlab/ref/h5g.close.html
   */
  H5G_CLOSE("h5g.close"),
  /*
   * Create group
   * @see http://www.mathworks.com/matlab/matlab/ref/h5g.create.html
   */
  H5G_CREATE("h5g.create"),
  /*
   * Information about group
   * @see http://www.mathworks.com/matlab/matlab/ref/h5g.get_info.html
   */
  H5G_GET_INFO("h5g.get_info"),
  /*
   * Open specified group
   * @see http://www.mathworks.com/matlab/matlab/ref/h5g.open.html
   */
  H5G_OPEN("h5g.open"),

  /*
   * Identifier (H5I)   */
  /*
   * Decrement reference count
   * @see http://www.mathworks.com/matlab/matlab/ref/h5i.dec_ref.html
   */
  H5I_DEC_REF("h5i.dec_ref"),
  /*
   * File identifier for specified object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5i.get_file_id.html
   */
  H5I_GET_FILE_ID("h5i.get_file_id"),
  /*
   * Name of object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5i.get_name.html
   */
  H5I_GET_NAME("h5i.get_name"),
  /*
   * Reference count of object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5i.get_ref.html
   */
  H5I_GET_REF("h5i.get_ref"),
  /*
   * Type of object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5i.get_type.html
   */
  H5I_GET_TYPE("h5i.get_type"),
  /*
   * Increment reference count of specified object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5i.inc_ref.html
   */
  H5I_INC_REF("h5i.inc_ref"),
  /*
   * Determine if specified identifier is valid
   * @see http://www.mathworks.com/matlab/matlab/ref/h5i.is_valid.html
   */
  H5I_IS_VALID("h5i.is_valid"),

  /*
   * Link (H5L)   */
  /*
   * Copy link from source location to destination location
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.copy.html
   */
  H5L_COPY("h5l.copy"),
  /*
   * Create soft link to external object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.create_external.html
   */
  H5L_CREATE_EXTERNAL("h5l.create_external"),
  /*
   * Create hard link
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.create_hard.html
   */
  H5L_CREATE_HARD("h5l.create_hard"),
  /*
   * Create soft link
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.create_soft.html
   */
  H5L_CREATE_SOFT("h5l.create_soft"),
  /*
   * Remove link
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.delete.html
   */
  H5L_DELETE("h5l.delete"),
  /*
   * Determine if link exists
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.exists.html
   */
  H5L_EXISTS("h5l.exists"),
  /*
   * Information about link
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.get_info.html
   */
  H5L_GET_INFO("h5l.get_info"),
  /*
   * Information about link specified by index
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.get_name_by_idx.html
   */
  H5L_GET_NAME_BY_IDX("h5l.get_name_by_idx"),
  /*
   * Value of symbolic link
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.get_val.html
   */
  H5L_GET_VAL("h5l.get_val"),
  /*
   * Iterate over links
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.iterate.html
   */
  H5L_ITERATE("h5l.iterate"),
  /*
   * Iterate through links in group specified by name
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.iterate_by_name.html
   */
  H5L_ITERATE_BY_NAME("h5l.iterate_by_name"),
  /*
   * Rename link
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.move.html
   */
  H5L_MOVE("h5l.move"),
  /*
   * Recursively iterate through links in group specified by group identifier
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.visit.html
   */
  H5L_VISIT("h5l.visit"),
  /*
   * Recursively iterate through links in group specified by location and group name
   * @see http://www.mathworks.com/matlab/matlab/ref/h5l.visit_by_name.html
   */
  H5L_VISIT_BY_NAME("h5l.visit_by_name"),

  /*
   * MATLAB (H5ML)   
   */
  /*
   * Numerically compare two HDF5 values
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ml.compare_values.html
   */
  H5ML_COMPARE_VALUES("h5ml.compare_values"),
  /*
   * Constants known by HDF5 library
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ml.get_constant_names.html
   */
  H5ML_GET_CONSTANT_NAMES("h5ml.get_constant_names"),
  /*
   * Value corresponding to a string
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ml.get_constant_value.html
   */
  H5ML_GET_CONSTANT_VALUE("h5ml.get_constant_value"),
  /*
   * Functions provided by HDF5 library
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ml.get_function_names.html
   */
  H5ML_GET_FUNCTION_NAMES("h5ml.get_function_names"),
  /*
   * Data type for dataset ID
   * @see http://www.mathworks.com/matlab/matlab/ref/h5ml.get_mem_datatype.html
   */
  H5ML_GET_MEM_DATATYPE("h5ml.get_mem_datatype"),

  /*
   * Object (H5O)
   */
  /*
   * Close object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.close.html
   */
  H5O_CLOSE("h5o.close"),
  /*
   * Copy object from source location to destination location
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.copy.html
   */
  H5O_COPY("h5o.copy"),
  /*
   * Get comment for object specified by object identifier
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.get_comment.html
   */
  H5O_GET_COMMENT("h5o.get_comment"),
  /*
   * Get comment for object specified by location and object name
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.get_comment_by_name.html
   */
  H5O_GET_COMMENT_BY_NAME("h5o.get_comment_by_name"),
  /*
   * Object metadata
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.get_info.html
   */
  H5O_GET_INFO("h5o.get_info"),
  /*
   * Create hard link to specified object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.link.html
   */
  H5O_LINK("h5o.link"),
  /*
   * Open specified object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.open.html
   */
  H5O_OPEN("h5o.open"),
  /*
   * Open object specified by index
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.open_by_idx.html
   */
  H5O_OPEN_BY_IDX("h5o.open_by_idx"),
  /*
   * Set comment for object specified by object identifier
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.set_comment.html
   */
  H5O_SET_COMMENT("h5o.set_comment"),
  /*
   * Set comment for object specified by location and object name
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.set_comment_by_name.html
   */
  H5O_SET_COMMENT_BY_NAME("h5o.set_comment_by_name"),
  /*
   * Visit objects specified by object identifier
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.visit.html
   */
  H5O_VISIT("h5o.visit"),
  /*
   * Visit objects specified by location and object name
   * @see http://www.mathworks.com/matlab/matlab/ref/h5o.visit_by_name.html
   */
  H5O_VISIT_BY_NAME("h5o.visit_by_name"),

  /*
   * Property (H5P)
   */
  /*
   * General Property List Operations
   */
  /*
   * Close property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.close.html
   */
  H5P_CLOSE("h5p.close"),
  /*
   * Copy of property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.copy.html
   */
  H5P_COPY("h5p.copy"),
  /*
   * Create new property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.create.html
   */
  H5P_CREATE("h5p.create"),
  /*
   * Property list class
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_class.html
   */
  H5P_GET_CLASS("h5p.get_class"),

  /*
   * Generic Property List Operations
   */
  /*
   * Close property list class
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.close_class.html
   */
  H5P_CLOSE_CLASS("h5p.close_class"),
  /*
   * Determine equality of property lists
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.equal.html
   */
  H5P_EQUAL("h5p.equal"),
  /*
   * Determine if specified property exists in property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.exist.html
   */
  H5P_EXIST("h5p.exist"),
  /*
   * Value of specified property in property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get.html
   */
  H5P_GET("h5p.get"),
  /*
   * Name of property list class
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_class_name.html
   */
  H5P_GET_CLASS_NAME("h5p.get_class_name"),
  /*
   * Identifier for parent class
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_class_parent.html
   */
  H5P_GET_CLASS_PARENT("h5p.get_class_parent"),
  /*
   * Query number of properties in property list or class
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_nprops.html
   */
  H5P_GET_NPROPS("h5p.get_nprops"),
  /*
   * Query size of property value in bytes
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_size.html
   */
  H5P_GET_SIZE("h5p.get_size"),
  /*
   * Determine if property list is member of class
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.isa_class.html
   */
  H5P_ISA_CLASS("h5p.isa_class"),
  /*
   * Iterate over properties in property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.iterate.html
   */
  H5P_ITERATE("h5p.iterate"),
  /*
   * Set property list value
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set.html
   */
  H5P_SET("h5p.set"),

  /*
   * Dataset Access, Memory, and Transfer Properties
   */
  /*
   * B-tree split ratios
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_btree_ratios.html
   */
  H5P_GET_BTREE_RATIOS("h5p.get_btree_ratios"),
  /*
   * Raw data chunk cache parameters
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_chunk_cache.html
   */
  H5P_GET_CHUNK_CACHE("h5p.get_chunk_cache"),
  /*
   * Data access property lists for multiple files
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_dxpl_multi.html
   */
  H5P_GET_DXPL_MULTI("h5p.get_dxpl_multi"),
  /*
   * Determine if error detection is enabled
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_edc_check.html
   */
  H5P_GET_EDC_CHECK("h5p.get_edc_check"),
  /*
   * Number of I/O vectors
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_hyper_vector_size.html
   */
  H5P_GET_HYPER_VECTOR_SIZE("h5p.get_hyper_vector_size"),
  /*
   * Set B-tree split ratios for dataset transfer
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_btree_ratios.html
   */
  H5P_SET_BTREE_RATIOS("h5p.set_btree_ratios"),
  /*
   * Set raw data chunk cache parameters
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_chunk_cache.html
   */
  H5P_SET_CHUNK_CACHE("h5p.set_chunk_cache"),
  /*
   * Set data transfer property list for multifile driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_dxpl_multi.html
   */
  H5P_SET_DXPL_MULTI("h5p.set_dxpl_multi"),
  /*
   * Enable error detection for dataset transfer
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_edc_check.html
   */
  H5P_SET_EDC_CHECK("h5p.set_edc_check"),
  /*
   * Set number of I/O vectors for hyperslab I/O
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_hyper_vector_size.html
   */
  H5P_SET_HYPER_VECTOR_SIZE("h5p.set_hyper_vector_size"),

  /*
   * Dataset Creation Properties
   */
  /*
   * Determine availability of all filters
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.all_filters_avail.html
   */
  H5P_ALL_FILTERS_AVAIL("h5p.all_filters_avail"),
  /*
   * Determine if fill value is defined
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.fill_value_defined.html
   */
  H5P_FILL_VALUE_DEFINED("h5p.fill_value_defined"),
  /*
   * Return timing of storage space allocation
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_alloc_time.html
   */
  H5P_GET_ALLOC_TIME("h5p.get_alloc_time"),
  /*
   * Return size of chunks
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_chunk.html
   */
  H5P_GET_CHUNK("h5p.get_chunk"),
  /*
   * Return information about external file
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_external.html
   */
  H5P_GET_EXTERNAL("h5p.get_external"),
  /*
   * Return count of external files
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_external_count.html
   */
  H5P_GET_EXTERNAL_COUNT("h5p.get_external_count"),
  /*
   * Return time when fill values are written to dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_fill_time.html
   */
  H5P_GET_FILL_TIME("h5p.get_fill_time"),
  /*
   * Return dataset fill value
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_fill_value.html
   */
  H5P_GET_FILL_VALUE("h5p.get_fill_value"),
  /*
   * Return information about filter in pipeline
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_filter.html
   */
  H5P_GET_FILTER("h5p.get_filter"),
  /*
   * Return information about specified filter
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_filter_by_id.html
   */
  H5P_GET_FILTER_BY_ID("h5p.get_filter_by_id"),
  /*
   * Determine layout of raw data for dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_layout.html
   */
  H5P_GET_LAYOUT("h5p.get_layout"),
  /*
   * Return number of filters in pipeline
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_nfilters.html
   */
  H5P_GET_NFILTERS("h5p.get_nfilters"),
  /*
   * Modify filter in pipeline
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.modify_filter.html
   */
  H5P_MODIFY_FILTER("h5p.modify_filter"),
  /*
   * Remove filter from property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.remove_filter.html
   */
  H5P_REMOVE_FILTER("h5p.remove_filter"),
  /*
   * Set timing for storage space allocation
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_alloc_time.html
   */
  H5P_SET_ALLOC_TIME("h5p.set_alloc_time"),
  /*
   * Set chunk size
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_chunk.html
   */
  H5P_SET_CHUNK("h5p.set_chunk"),
  /*
   * Set compression method and compression level
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_deflate.html
   */
  H5P_SET_DEFLATE("h5p.set_deflate"),
  /*
   * Add additional file to external file list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_external.html
   */
  H5P_SET_EXTERNAL("h5p.set_external"),
  /*
   * Set time when fill values are written to dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fill_time.html
   */
  H5P_SET_FILL_TIME("h5p.set_fill_time"),
  /*
   * Set fill value for dataset creation property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fill_value.html
   */
  H5P_SET_FILL_VALUE("h5p.set_fill_value"),
  /*
   * Add filter to filter pipeline
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_filter.html
   */
  H5P_SET_FILTER("h5p.set_filter"),
  /*
   * Set Fletcher32 checksum filter in dataset creation
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fletcher32.html
   */
  H5P_SET_FLETCHER32("h5p.set_fletcher32"),
  /*
   * Set type of storage for dataset
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_layout.html
   */
  H5P_SET_LAYOUT("h5p.set_layout"),
  /*
   * Set N-Bit filter
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_nbit.html
   */
  H5P_SET_NBIT("h5p.set_nbit"),
  /*
   * Set Scale-Offset filter
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_scaleoffset.html
   */
  H5P_SET_SCALEOFFSET("h5p.set_scaleoffset"),
  /*
   * Set shuffle filter
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_shuffle.html
   */
  H5P_SET_SHUFFLE("h5p.set_shuffle"),

  /*
   * File Access Properties
   */
  /*
   * Retrieve alignment properties
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_alignment.html
   */
  H5P_GET_ALIGNMENT("h5p.get_alignment"),
  /*
   * Low-level file driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_driver.html
   */
  H5P_GET_DRIVER("h5p.get_driver"),
  /*
   * Offset for family file driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_family_offset.html
   */
  H5P_GET_FAMILY_OFFSET("h5p.get_family_offset"),
  /*
   * Information about core file driver properties
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_fapl_core.html
   */
  H5P_GET_FAPL_CORE("h5p.get_fapl_core"),
  /*
   * File access property list information
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_fapl_family.html
   */
  H5P_GET_FAPL_FAMILY("h5p.get_fapl_family"),
  /*
   * Information about multifile access property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_fapl_multi.html
   */
  H5P_GET_FAPL_MULTI("h5p.get_fapl_multi"),
  /*
   * File close degree
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_fclose_degree.html
   */
  H5P_GET_FCLOSE_DEGREE("h5p.get_fclose_degree"),
  /*
   * Library version bounds settings
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_libver_bounds.html
   */
  H5P_GET_LIBVER_BOUNDS("h5p.get_libver_bounds"),
  /*
   * Garbage collection references setting
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_gc_references.html
   */
  H5P_GET_GC_REFERENCES("h5p.get_gc_references"),
  /*
   * Metadata cache configuration
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_mdc_config.html
   */
  H5P_GET_MDC_CONFIG("h5p.get_mdc_config"),
  /*
   * Metadata block size setting
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_meta_block_size.html
   */
  H5P_GET_META_BLOCK_SIZE("h5p.get_meta_block_size"),
  /*
   * Type of data property for MULTI driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_multi_type.html
   */
  H5P_GET_MULTI_TYPE("h5p.get_multi_type"),
  /*
   * Maximum data sieve buffer size
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_sieve_buf_size.html
   */
  H5P_GET_SIEVE_BUF_SIZE("h5p.get_sieve_buf_size"),
  /*
   * Small data block size setting
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_small_data_block_size.html
   */
  H5P_GET_SMALL_DATA_BLOCK_SIZE("h5p.get_small_data_block_size"),
  /*
   * Set alignment properties for file access property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_alignment.html
   */
  H5P_SET_ALIGNMENT("h5p.set_alignment"),
  /*
   * Set offset property for family of files
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_family_offset.html
   */
  H5P_SET_FAMILY_OFFSET("h5p.set_family_offset"),
  /*
   * Modify file access to use H5FD_CORE driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fapl_core.html
   */
  H5P_SET_FAPL_CORE("h5p.set_fapl_core"),
  /*
   * Set file access to use family driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fapl_family.html
   */
  H5P_SET_FAPL_FAMILY("h5p.set_fapl_family"),
  /*
   * Set use of logging driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fapl_log.html
   */
  H5P_SET_FAPL_LOG("h5p.set_fapl_log"),
  /*
   * Set use of multifile driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fapl_multi.html
   */
  H5P_SET_FAPL_MULTI("h5p.set_fapl_multi"),
  /*
   * Set file access for sec2 driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fapl_sec2.html
   */
  H5P_SET_FAPL_SEC2("h5p.set_fapl_sec2"),
  /*
   * Set file access for emulation of split file driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fapl_split.html
   */
  H5P_SET_FAPL_SPLIT("h5p.set_fapl_split"),
  /*
   * Set file access for standard I/O driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fapl_stdio.html
   */
  H5P_SET_FAPL_STDIO("h5p.set_fapl_stdio"),
  /*
   * Set file access for file close degree
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_fclose_degree.html
   */
  H5P_SET_FCLOSE_DEGREE("h5p.set_fclose_degree"),
  /*
   * Set garbage collection references flag
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_gc_references.html
   */
  H5P_SET_GC_REFERENCES("h5p.set_gc_references"),
  /*
   * Set library version bounds for objects
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_libver_bounds.html
   */
  H5P_SET_LIBVER_BOUNDS("h5p.set_libver_bounds"),
  /*
   * Set initial metadata cache configuration
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_mdc_config.html
   */
  H5P_SET_MDC_CONFIG("h5p.set_mdc_config"),
  /*
   * Set minimum metadata block size
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_meta_block_size.html
   */
  H5P_SET_META_BLOCK_SIZE("h5p.set_meta_block_size"),
  /*
   * Specify type of data accessed with MULTI driver
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_multi_type.html
   */
  H5P_SET_MULTI_TYPE("h5p.set_multi_type"),
  /*
   * Set maximum size of data sieve buffer
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_sieve_buf_size.html
   */
  H5P_SET_SIEVE_BUF_SIZE("h5p.set_sieve_buf_size"),
  /*
   * Set size of block reserved for small data
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_small_data_block_size.html
   */
  H5P_SET_SMALL_DATA_BLOCK_SIZE("h5p.set_small_data_block_size"),

  /*
   * File Creation Properties
   */
  /*
   * Return 1/2 rank of indexed storage B-tree
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_istore_k.html
   */
  H5P_GET_ISTORE_K("h5p.get_istore_k"),
  /*
   * Return size of offsets and lengths
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_sizes.html
   */
  H5P_GET_SIZES("h5p.get_sizes"),
  /*
   * Return size of B-tree 1/2 rank and leaf node 1/2 size
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_sym_k.html
   */
  H5P_GET_SYM_K("h5p.get_sym_k"),
  /*
   * Return size of user block
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_userblock.html
   */
  H5P_GET_USERBLOCK("h5p.get_userblock"),
  /*
   * Return version information for file creation property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_version.html
   */
  H5P_GET_VERSION("h5p.get_version"),
  /*
   * Set size of parameter for indexing chunked datasets
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_istore_k.html
   */
  H5P_SET_ISTORE_K("h5p.set_istore_k"),
  /*
   * Set byte size of offsets and lengths
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_sizes.html
   */
  H5P_SET_SIZES("h5p.set_sizes"),
  /*
   * Set size of parameters used to control symbol table nodes
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_sym_k.html
   */
  H5P_SET_SYM_K("h5p.set_sym_k"),
  /*
   * Set user block size
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_userblock.html
   */
  H5P_SET_USERBLOCK("h5p.set_userblock"),

  /*
   * Object Copy and Object Creation Properties
   */
  /*
   * Return tracking order and indexing settings
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_attr_creation_order.html
   */
  H5P_GET_ATTR_CREATION_ORDER("h5p.get_attr_creation_order"),
  /*
   * Retrieve attribute phase change thresholds
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_attr_phase_change.html
   */
  H5P_GET_ATTR_PHASE_CHANGE("h5p.get_attr_phase_change"),
  /*
   * Return properties to be used when object is copied
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_copy_object.html
   */
  H5P_GET_COPY_OBJECT("h5p.get_copy_object"),
  /*
   * Set tracking of attribute creation order
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_attr_creation_order.html
   */
  H5P_SET_ATTR_CREATION_ORDER("h5p.set_attr_creation_order"),
  /*
   * Set attribute storage phase change thresholds
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_attr_phase_change.html
   */
  H5P_SET_ATTR_PHASE_CHANGE("h5p.set_attr_phase_change"),
  /*
   * Set properties to be used when objects are copied
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_copy_object.html
   */
  H5P_SET_COPY_OBJECT("h5p.set_copy_object"),

  /*
   * Group Creation Properties
   */
  /*
   * Determine creation of intermediate groups
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_create_intermediate_group.html
   */
  H5P_GET_CREATE_INTERMEDIATE_GROUP("h5p.get_create_intermediate_group"),
  /*
   * Query if link creation order is tracked
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_link_creation_order.html
   */
  H5P_GET_LINK_CREATION_ORDER("h5p.get_link_creation_order"),
  /*
   * Query settings for conversion between groups
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_link_phase_change.html
   */
  H5P_GET_LINK_PHASE_CHANGE("h5p.get_link_phase_change"),
  /*
   * Set creation of intermediate groups
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_create_intermediate_group.html
   */
  H5P_SET_CREATE_INTERMEDIATE_GROUP("h5p.set_create_intermediate_group"),
  /*
   * Set creation order tracking and indexing
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_link_creation_order.html
   */
  H5P_SET_LINK_CREATION_ORDER("h5p.set_link_creation_order"),
  /*
   * Set parameters for group conversion
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_link_phase_change.html
   */
  H5P_SET_LINK_PHASE_CHANGE("h5p.set_link_phase_change"),

  /*
   * HDF5 String Properties
   */
  /*
   * Return character encoding
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.get_char_encoding.html
   */
  H5P_GET_CHAR_ENCODING("h5p.get_char_encoding"),
  /*
   * Set character encoding used to encode strings
   * @see http://www.mathworks.com/matlab/matlab/ref/h5p.set_char_encoding.html
   */
  H5P_SET_CHAR_ENCODING("h5p.set_char_encoding"),

  /*
   * Reference (H5R)
   */
  /*
   * Create reference
   * @see http://www.mathworks.com/matlab/matlab/ref/h5r.create.html
   */
  H5R_CREATE("h5r.create"),
  /*
   * Open object specified by reference
   * @see http://www.mathworks.com/matlab/matlab/ref/h5r.dereference.html
   */
  H5R_DEREFERENCE("h5r.dereference"),
  /*
   * Name of referenced object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5r.get_name.html
   */
  H5R_GET_NAME("h5r.get_name"),
  /*
   * Type of referenced object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5r.get_obj_type.html
   */
  H5R_GET_OBJ_TYPE("h5r.get_obj_type"),
  /*
   * Copy of data space of specified region
   * @see http://www.mathworks.com/matlab/matlab/ref/h5r.get_region.html
   */
  H5R_GET_REGION("h5r.get_region"),

  /*
   * Dataspace (H5S)
   */
  /*
   * Create copy of data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.copy.html
   */
  H5S_COPY("h5s.copy"),
  /*
   * Create new data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.create.html
   */
  H5S_CREATE("h5s.create"),
  /*
   * Close data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.close.html
   */
  H5S_CLOSE("h5s.close"),
  /*
   * Create new simple data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.create_simple.html
   */
  H5S_CREATE_SIMPLE("h5s.create_simple"),
  /*
   * Copy extent from source to destination data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.extent_copy.html
   */
  H5S_EXTENT_COPY("h5s.extent_copy"),
  /*
   * Determine if data space is simple
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.is_simple.html
   */
  H5S_IS_SIMPLE("h5s.is_simple"),
  /*
   * Set offset of simple data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.offset_simple.html
   */
  H5S_OFFSET_SIMPLE("h5s.offset_simple"),
  /*
   * Select entire extent of data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.select_all.html
   */
  H5S_SELECT_ALL("h5s.select_all"),
  /*
   * Specify coordinates to include in selection
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.select_elements.html
   */
  H5S_SELECT_ELEMENTS("h5s.select_elements"),
  /*
   * Select hyperslab region
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.select_hyperslab.html
   */
  H5S_SELECT_HYPERSLAB("h5s.select_hyperslab"),
  /*
   * Reset selection region to include no elements
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.select_none.html
   */
  H5S_SELECT_NONE("h5s.select_none"),
  /*
   * Determine validity of selection
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.select_valid.html
   */
  H5S_SELECT_VALID("h5s.select_valid"),
  /*
   * Remove extent from data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.set_extent_none.html
   */
  H5S_SET_EXTENT_NONE("h5s.set_extent_none"),
  /*
   * Set size of data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.set_extent_simple.html
   */
  H5S_SET_EXTENT_SIMPLE("h5s.set_extent_simple"),
  /*
   * Bounding box of data space selection
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_select_bounds.html
   */
  H5S_GET_SELECT_BOUNDS("h5s.get_select_bounds"),
  /*
   * Number of element points in selection
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_select_elem_npoints.html
   */
  H5S_GET_SELECT_ELEM_NPOINTS("h5s.get_select_elem_npoints"),
  /*
   * Element points in data space selection
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_select_elem_pointlist.html
   */
  H5S_GET_SELECT_ELEM_POINTLIST("h5s.get_select_elem_pointlist"),
  /*
   * List of hyperslab blocks
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_select_hyper_blocklist.html
   */
  H5S_GET_SELECT_HYPER_BLOCKLIST("h5s.get_select_hyper_blocklist"),
  /*
   * Number of hyperslab blocks
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_select_hyper_nblocks.html
   */
  H5S_GET_SELECT_HYPER_NBLOCKS("h5s.get_select_hyper_nblocks"),
  /*
   * Number of elements in data space selection
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_select_npoints.html
   */
  H5S_GET_SELECT_NPOINTS("h5s.get_select_npoints"),
  /*
   * Type of data space selection
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_select_type.html
   */
  H5S_GET_SELECT_TYPE("h5s.get_select_type"),
  /*
   * Data space size and maximum size
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_simple_extent_dims.html
   */
  H5S_GET_SIMPLE_EXTENT_DIMS("h5s.get_simple_extent_dims"),
  /*
   * Data space rank
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_simple_extent_ndims.html
   */
  H5S_GET_SIMPLE_EXTENT_NDIMS("h5s.get_simple_extent_ndims"),
  /*
   * Number of elements in data space
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_simple_extent_npoints.html
   */
  H5S_GET_SIMPLE_EXTENT_NPOINTS("h5s.get_simple_extent_npoints"),
  /*
   * Data space class
   * @see http://www.mathworks.com/matlab/matlab/ref/h5s.get_simple_extent_type.html
   */
  H5S_GET_SIMPLE_EXTENT_TYPE("h5s.get_simple_extent_type"),

  /*
   * Datatype (H5T)
   */
  /*
   * General Data Type Operation
   */
  /*
   * Close data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.close.html
   */
  H5T_CLOSE("h5t.close"),
  /*
   * Commit transient data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.commit.html
   */
  H5T_COMMIT("h5t.commit"),
  /*
   * Determine if data type is committed
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.committed.html
   */
  H5T_COMMITTED("h5t.committed"),
  /*
   * Copy data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.copy.html
   */
  H5T_COPY("h5t.copy"),
  /*
   * Create new data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.create.html
   */
  H5T_CREATE("h5t.create"),
  /*
   * Determine of data type contains specific class
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.detect_class.html
   */
  H5T_DETECT_CLASS("h5t.detect_class"),
  /*
   * Determine equality of data types
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.equal.html
   */
  H5T_EQUAL("h5t.equal"),
  /*
   * Data type class identifier
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_class.html
   */
  H5T_GET_CLASS("h5t.get_class"),
  /*
   * Copy of data type creation property list
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_create_plist.html
   */
  H5T_GET_CREATE_PLIST("h5t.get_create_plist"),
  /*
   * Native data type of dataset data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_native_type.html
   */
  H5T_GET_NATIVE_TYPE("h5t.get_native_type"),
  /*
   * Size of data type in bytes
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_size.html
   */
  H5T_GET_SIZE("h5t.get_size"),
  /*
   * Base data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_super.html
   */
  H5T_GET_SUPER("h5t.get_super"),
  /*
   * Lock data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.lock.html
   */
  H5T_LOCK("h5t.lock"),
  /*
   * Open named data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.open.html
   */
  H5T_OPEN("h5t.open"),

  /*
   * Array Data Type
   */
  /*
   * Create array data type object
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.array_create.html
   */
  H5T_ARRAY_CREATE("h5t.array_create"),
  /*
   * Array dimension extents
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_array_dims.html
   */
  H5T_GET_ARRAY_DIMS("h5t.get_array_dims"),
  /*
   * Rank of array data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_array_ndims.html
   */
  H5T_GET_ARRAY_NDIMS("h5t.get_array_ndims"),

  /*
   * Atomic Data Type Properties
   */
  /*
   * Character set of string data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_cset.html
   */
  H5T_GET_CSET("h5t.get_cset"),
  /*
   * Exponent bias of floating-point type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_ebias.html
   */
  H5T_GET_EBIAS("h5t.get_ebias"),
  /*
   * Floating-point data type bit field information
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_fields.html
   */
  H5T_GET_FIELDS("h5t.get_fields"),
  /*
   * Internal padding type for floating-point data types
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_inpad.html
   */
  H5T_GET_INPAD("h5t.get_inpad"),
  /*
   * Mantissa normalization type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_norm.html
   */
  H5T_GET_NORM("h5t.get_norm"),
  /*
   * Bit offset of first significant bit
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_offset.html
   */
  H5T_GET_OFFSET("h5t.get_offset"),
  /*
   * Byte order of atomic data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_order.html
   */
  H5T_GET_ORDER("h5t.get_order"),
  /*
   * Padding type of least and most-significant bits
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_pad.html
   */
  H5T_GET_PAD("h5t.get_pad"),
  /*
   * Precision of atomic data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_precision.html
   */
  H5T_GET_PRECISION("h5t.get_precision"),
  /*
   * Sign type for integer data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_sign.html
   */
  H5T_GET_SIGN("h5t.get_sign"),
  /*
   * Storage mechanism for string data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_strpad.html
   */
  H5T_GET_STRPAD("h5t.get_strpad"),
  /*
   * Set character dataset for string data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_cset.html
   */
  H5T_SET_CSET("h5t.set_cset"),
  /*
   * Set exponent bias of floating-point data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_ebias.html
   */
  H5T_SET_EBIAS("h5t.set_ebias"),
  /*
   * Set sizes and locations of floating-point bit fields
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_fields.html
   */
  H5T_SET_FIELDS("h5t.set_fields"),
  /*
   * Specify how unused internal bits are to be filled
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_inpad.html
   */
  H5T_SET_INPAD("h5t.set_inpad"),
  /*
   * Set mantissa normalization of floating-point data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_norm.html
   */
  H5T_SET_NORM("h5t.set_norm"),
  /*
   * Set bit offset of first significant bit
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_offset.html
   */
  H5T_SET_OFFSET("h5t.set_offset"),
  /*
   * Set byte ordering of atomic data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_order.html
   */
  H5T_SET_ORDER("h5t.set_order"),
  /*
   * Set padding type for least and most significant bits
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_pad.html
   */
  H5T_SET_PAD("h5t.set_pad"),
  /*
   * Set precision of atomic data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_precision.html
   */
  H5T_SET_PRECISION("h5t.set_precision"),
  /*
   * Set sign property for integer data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_sign.html
   */
  H5T_SET_SIGN("h5t.set_sign"),
  /*
   * Set size of data type in bytes
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_size.html
   */
  H5T_SET_SIZE("h5t.set_size"),
  /*
   * Set storage mechanism for string data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_strpad.html
   */
  H5T_SET_STRPAD("h5t.set_strpad"),

  /*
   * Compound Data Type
   */
  /*
   * Data type class for compound data type member
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_member_class.html
   */
  H5T_GET_MEMBER_CLASS("h5t.get_member_class"),
  /*
   * Index of compound or enumeration type member
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_member_index.html
   */
  H5T_GET_MEMBER_INDEX("h5t.get_member_index"),
  /*
   * Name of compound or enumeration type member
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_member_name.html
   */
  H5T_GET_MEMBER_NAME("h5t.get_member_name"),
  /*
   * Offset of field of compound data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_member_offset.html
   */
  H5T_GET_MEMBER_OFFSET("h5t.get_member_offset"),
  /*
   * Data type of specified member
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_member_type.html
   */
  H5T_GET_MEMBER_TYPE("h5t.get_member_type"),
  /*
   * Number of elements in enumeration type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_nmembers.html
   */
  H5T_GET_NMEMBERS("h5t.get_nmembers"),
  /*
   * Add member to compound data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.insert.html
   */
  H5T_INSERT("h5t.insert"),
  /*
   * Recursively remove padding from compound data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.pack.html
   */
  H5T_PACK("h5t.pack"),

  /*
   * Enumeration Data Type   */
  /*
   * Create new enumeration data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.enum_create.html
   */
  H5T_ENUM_CREATE("h5t.enum_create"),
  /*
   * Insert enumeration data type member
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.enum_insert.html
   */
  H5T_ENUM_INSERT("h5t.enum_insert"),
  /*
   * Name of enumeration data type member
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.enum_nameof.html
   */
  H5T_ENUM_NAMEOF("h5t.enum_nameof"),
  /*
   * Value of enumeration data type member
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.enum_valueof.html
   */
  H5T_ENUM_VALUEOF("h5t.enum_valueof"),
  /*
   * Value of enumeration data type member
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_member_value.html
   */
  H5T_GET_MEMBER_VALUE("h5t.get_member_value"),

  /*
   * Opaque Data Type Properties
   */
  /*
   * Tag associated with opaque data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.get_tag.html
   */
  H5T_GET_TAG("h5t.get_tag"),
  /*
   * Tag opaque data type with description
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.set_tag.html
   */
  H5T_SET_TAG("h5t.set_tag"),

  /*
   * Variable-length Data Type
   */
  /*
   * Determine if data type is variable-length string
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.is_variable_str.html
   */
  H5T_IS_VARIABLE_STR("h5t.is_variable_str"),
  /*
   * Create new variable-length data type
   * @see http://www.mathworks.com/matlab/matlab/ref/h5t.vlen_create.html
   */
  H5T_VLEN_CREATE("h5t.vlen_create"),

  /*
   * Filters and Compression (H5Z)
   */
  /*
   * Determine if filter is available
   * @see http://www.mathworks.com/matlab/matlab/ref/h5z.filter_avail.html
   */
  H5Z_FILTER_AVAIL("h5z.filter_avail"),
  /*
   * Information about filter
   * @see http://www.mathworks.com/matlab/matlab/ref/h5z.get_filter_info.html
   */
  H5Z_GET_FILTER_INFO("h5z.get_filter_info"),

  /*
   * HDF4 Files
   */
  /*
   * High-Level Functions
   */
  /*
   * Information about HDF4 or HDF-EOS file
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfinfo.html
   */
  HDFINFO("hdfinfo"),
  /*
   * Read data from HDF4 or HDF-EOS file
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfread.html
   */
  HDFREAD("hdfread"),
  /*
   * Read image from graphics file
   * @see http://www.mathworks.com/matlab/matlab/ref/imread.html
   */
//  IMREAD("imread"),
  /*
   * Write image to graphics file
   * @see http://www.mathworks.com/matlab/matlab/ref/imwrite.html
   */
//  IMWRITE("imwrite"),

  /*
   * Low-Level Functions
   */
  /*
   * Gateway to HDF multifile annotation (AN) interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfan.html
   */
  HDFAN("hdfan"),
  /*
   * Gateway to HDF external data (HX) interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfhx.html
   */
  HDFHX("hdfhx"),
  /*
   * Gateway to HDF H interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfh.html
   */
  HDFH("hdfh"),
  /*
   * Gateway to HDF HD interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfhd.html
   */
  HDFHD("hdfhd"),
  /*
   * Gateway to HDF HE interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfhe.html
   */
  HDFHE("hdfhe"),
  /*
   * Utilities for working with MATLAB HDF gateway functions
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfml.html
   */
  HDFML("hdfml"),
  /*
   * Interface to HDF-EOS Point object
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfpt.html
   */
  HDFPT("hdfpt"),
  /*
   * Gateway to HDF Vgroup (V) interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfv.html
   */
  HDFV("hdfv"),
  /*
   * Gateway to VF functions in HDF Vdata interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfvf.html
   */
  HDFVF("hdfvf"),
  /*
   * Gateway to VH functions in HDF Vdata interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfvh.html
   */
  HDFVH("hdfvh"),
  /*
   * Gateway to VS functions in HDF Vdata interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfvs.html
   */
  HDFVS("hdfvs"),
  /*
   * Gateway to HDF 24-bit raster image (DF24) interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfdf24.html
   */
  HDFDF24("hdfdf24"),
  /*
   * Gateway to HDF 8-bit raster image (DFR8) interface
   * @see http://www.mathworks.com/matlab/matlab/ref/hdfdfr8.html
   */
  HDFDFR8("hdfdfr8"),

  /*
   * FITS Files
   */
  /*
   * High-Level Functions
   */
  /*
   * Display FITS metadata
   * @see http://www.mathworks.com/matlab/matlab/ref/fitsdisp.html
   */
  FITSDISP("fitsdisp"),
  /*
   * Information about FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/fitsinfo.html
   */
  FITSINFO("fitsinfo"),
  /*
   * Read data from FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/fitsread.html
   */
  FITSREAD("fitsread"),
  /*
   * Write image to FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/fitswrite.html
   */
  FITSWRITE("fitswrite"),

  /*
   * Low-Level Functions
   */
  /*
   * File Access
   */
  /*
   * Create FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.createfile.html
   */
  CREATEFILE("createfile"),
  /*
   * Open FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.openfile.html
   */
  OPENFILE("openfile"),
  /*
   * Close FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.closefile.html
   */
  CLOSEFILE("closefile"),
  /*
   * Delete FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.deletefile.html
   */
  DELETEFILE("deletefile"),
  /*
   * Name of FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.filename.html
   */
  FILENAME("filename"),
  /*
   * I/O mode of FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.filemode.html
   */
  FILEMODE("filemode"),

  /*
   * Image Manipulation
   */
  /*
   * Create FITS image
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.createimg.html
   */
  CREATEIMG("createimg"),
  /*
   * Size of image
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getimgsize.html
   */
  GETIMGSIZE("getimgsize"),
  /*
   * Data type of image
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getimgtype.html
   */
  GETIMGTYPE("getimgtype"),
  /*
   * Insert FITS image after current image
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.insertimg.html
   */
  INSERTIMG("insertimg"),
  /*
   * Read image data
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readimg.html
   */
  READIMG("readimg"),
  /*
   * Reset image scaling
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.setbscale.html
   */
  SETBSCALE("setbscale"),
  /*
   * Write to FITS image
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.writeimg.html
   */
  WRITEIMG("writeimg"),

  /*
   * Keywords
   */
  /*
   * Header record of keyword
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readcard.html
   */
  READCARD("readcard"),
  /*
   * Keyword
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readkey.html
   */
  READKEY("readkey"),
  /*
   * Keyword as complex scalar value
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readkeycmplx.html
   */
  READKEYCMPLX("readkeycmplx"),
  /*
   * Keyword as double precision value
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readkeydbl.html
   */
  READKEYDBL("readkeydbl"),
  /*
   * Keyword as int64
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readkeylonglong.html
   */
  READKEYLONGLONG("readkeylonglong"),
  /*
   * Long string value
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readkeylongstr.html
   */
  READKEYLONGSTR("readkeylongstr"),
  /*
   * Physical units string from keyword
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readkeyunit.html
   */
  READKEYUNIT("readkeyunit"),
  /*
   * Header record specified by number
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readrecord.html
   */
  READRECORD("readrecord"),
  /*
   * Write or append COMMENT keyword to CHU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.writecomment.html
   */
  WRITECOMMENT("writecomment"),
  /*
   * Write DATE keyword to CHU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.writedate.html
   */
  WRITEDATE("writedate"),
  /*
   * Update or add new keyword into current HDU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.writekey.html
   */
  WRITEKEY("writekey"),
  /*
   * Write physical units string
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.writekeyunit.html
   */
  WRITEKEYUNIT("writekeyunit"),
  /*
   * Write or append HISTORY keyword to CHU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.writehistory.html
   */
  WRITEHISTORY("writehistory"),
  /*
   * Delete key by name
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.deletekey.html
   */
  DELETEKEY("deletekey"),
  /*
   * Delete key by record number
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.deleterecord.html
   */
  DELETERECORD("deleterecord"),
  /*
   * Number of keywords in header
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.gethdrspace.html
   */
  GETHDRSPACE("gethdrspace"),

  /*
   * Header Data Unit (HDU) Access
   */
  /*
   * Copy current HDU from one file to another
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.copyhdu.html
   */
  COPYHDU("copyhdu"),
  /*
   * Number of current HDU in FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.gethdunum.html
   */
  GETHDUNUM("gethdunum"),
  /*
   * Type of current HDU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.gethdutype.html
   */
  GETHDUTYPE("gethdutype"),
  /*
   * Total number of HDUs in FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getnumhdus.html
   */
  GETNUMHDUS("getnumhdus"),
  /*
   * Move to absolute HDU number
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.movabshdu.html
   */
  MOVABSHDU("movabshdu"),
  /*
   * Move to first HDU having specific type and keyword values
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.movnamhdu.html
   */
  MOVNAMHDU("movnamhdu"),
  /*
   * Move relative number of HDUs from current HDU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.movrelhdu.html
   */
  MOVRELHDU("movrelhdu"),
  /*
   * Compute and write checksum for current HDU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.writechecksum.html
   */
  WRITECHECKSUM("writechecksum"),
  /*
   * Delete current HDU in FITS file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.deletehdu.html
   */
  DELETEHDU("deletehdu"),

  /*
   * Image Compression
   */
  /*
   * Compress HDU from one file into another
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.imgcompress.html
   */
  IMGCOMPRESS("imgcompress"),
  /*
   * Determine if current image is compressed
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.iscompressedimg.html
   */
  ISCOMPRESSEDIMG("iscompressedimg"),
  /*
   * Set image compression type
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.setcompressiontype.html
   */
  SETCOMPRESSIONTYPE("setcompressiontype"),
  /*
   * Set scale parameter for HCOMPRESS algorithm
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.sethcompscale.html
   */
  SETHCOMPSCALE("sethcompscale"),
  /*
   * Set smoothing for images compressed with HCOMPRESS
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.sethcompsmooth.html
   */
  SETHCOMPSMOOTH("sethcompsmooth"),
  /*
   * Set tile dimensions
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.settiledim.html
   */
  SETTILEDIM("settiledim"),

  /*
   * ASCII and Binary Tables
   */
  /*
   * Create new ASCII or binary table extension
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.createtbl.html
   */
  CREATETBL("createtbl"),
  /*
   * Insert column into table
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.insertcol.html
   */
  INSERTCOL("insertcol"),
  /*
   * Insert rows into table
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.insertrows.html
   */
  INSERTROWS("insertrows"),
  /*
   * Insert ASCII table after current HDU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.insertatbl.html
   */
  INSERTATBL("insertatbl"),
  /*
   * Insert binary table after current HDU
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.insertbtbl.html
   */
  INSERTBTBL("insertbtbl"),
  /*
   * Delete column from table
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.deletecol.html
   */
  DELETECOL("deletecol"),
  /*
   * Delete rows from table
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.deleterows.html
   */
  DELETEROWS("deleterows"),
  /*
   * ASCII table information
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getacolparms.html
   */
  GETACOLPARMS("getacolparms"),
  /*
   * Binary table information
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getbcolparms.html
   */
  GETBCOLPARMS("getbcolparms"),
  /*
   * Table column name
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getcolname.html
   */
  GETCOLNAME("getcolname"),
  /*
   * Scaled column data type, repeat value, width
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getcoltype.html
   */
  GETCOLTYPE("getcoltype"),
  /*
   * Column data type, repeat value, width
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.geteqcoltype.html
   */
  GETEQCOLTYPE("geteqcoltype"),
  /*
   * Number of columns in table
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getnumcols.html
   */
  GETNUMCOLS("getnumcols"),
  /*
   * Number of rows in table
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getnumrows.html
   */
  GETNUMROWS("getnumrows"),
  /*
   * Read header information from current ASCII table
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readatblhdr.html
   */
  READATBLHDR("readatblhdr"),
  /*
   * Read header information from current binary table
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readbtblhdr.html
   */
  READBTBLHDR("readbtblhdr"),
  /*
   * Read rows of ASCII or binary table column
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.readcol.html
   */
  READCOL("readcol"),
  /*
   * Reset image scaling
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.settscale.html
   */
  SETTSCALE("settscale"),
  /*
   * Write elements into ASCII or binary table column
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.writecol.html
   */
  WRITECOL("writecol"),

  /*
   * Utilities
   */
  /*
   * Numeric value of named constant
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getconstantvalue.html
   */
  GETCONSTANTVALUE("getconstantvalue"),
  /*
   * Revision number of the CFITSIO library
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getversion.html
   */
  GETVERSION("getversion"),
  /*
   * List of open FITS files
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.fits.getopenfiles.html
   */
  GETOPENFILES("getopenfiles"),

  /*
   * Band-Interleaved Files
   */
  /*
   * Read band-interleaved data from binary file
   * @see http://www.mathworks.com/matlab/matlab/ref/multibandread.html
   */
  MULTIBANDREAD("multibandread"),
  /*
   * Write band-interleaved data to file
   * @see http://www.mathworks.com/matlab/matlab/ref/multibandwrite.html
   */
  MULTIBANDWRITE("multibandwrite"),

  /*
   * Common Data Format
   */
  /*
   * Convert MATLAB formatted dates to CDF formatted dates
   * @see http://www.mathworks.com/matlab/matlab/ref/cdfepoch.html
   */
  CDFEPOCH("cdfepoch"),
  /*
   * Information about Common Data Format (CDF) file
   * @see http://www.mathworks.com/matlab/matlab/ref/cdfinfo.html
   */
  CDFINFO("cdfinfo"),
  /*
   * Read data from Common Data Format (CDF) file
   * @see http://www.mathworks.com/matlab/matlab/ref/cdfread.html
   */
  CDFREAD("cdfread"),
  /*
   * Write data to Common Data Format (CDF) file
   * @see http://www.mathworks.com/matlab/matlab/ref/cdfwrite.html
   */
  CDFWRITE("cdfwrite"),
  /*
   * Convert CDF epoch object to MATLAB datenum
   * @see http://www.mathworks.com/matlab/matlab/ref/todatenum.html
   */
  TODATENUM("todatenum"),
  /*
   * Summary of Common Data Format (CDF) capabilities
   * @see http://www.mathworks.com/matlab/matlab/ref/cdflib.html
   */
  CDFLIB("cdflib"),

  /*
   * Audio and Video
   */
  /*
   * Reading and Writing Files
   */
  /*
   * Information about audio file
   * @see http://www.mathworks.com/matlab/matlab/ref/audioinfo.html
   */
  AUDIOINFO("audioinfo"),
  /*
   * Read audio file
   * @see http://www.mathworks.com/matlab/matlab/ref/audioread.html
   */
  AUDIOREAD("audioread"),
  /*
   * Write audio file
   * @see http://www.mathworks.com/matlab/matlab/ref/audiowrite.html
   */
  AUDIOWRITE("audiowrite"),
  /*
   * Information about multimedia file
   * @see http://www.mathworks.com/matlab/matlab/ref/mmfileinfo.html
   */
  MMFILEINFO("mmfileinfo"),
  /*
   * Create Audio/Video Interleaved (AVI) file from MATLAB movie
   * @see http://www.mathworks.com/matlab/matlab/ref/movie2avi.html
   */
  MOVIE2AVI("movie2avi"),
  /*
   * Read video files
   * @see http://www.mathworks.com/matlab/matlab/ref/videoreader-class.html
   */
  VIDEOREADER("videoreader"),
  /*
   * Write video files
   * @see http://www.mathworks.com/matlab/matlab/ref/videowriter-class.html
   */
  VIDEOWRITER("videowriter"),

  /*
   * Recording and Playback
   */
  /*
   * Information about audio device
   * @see http://www.mathworks.com/matlab/matlab/ref/audiodevinfo.html
   */
  AUDIODEVINFO("audiodevinfo"),
  /*
   * Create object for playing audio 
   * @see http://www.mathworks.com/matlab/matlab/ref/audioplayer.html
   */
  AUDIOPLAYER("audioplayer"),
  /*
   * Create object for recording audio
   * @see http://www.mathworks.com/matlab/matlab/ref/audiorecorder.html
   */
  AUDIORECORDER("audiorecorder"),
  /*
   * Convert matrix of signal data to sound
   * @see http://www.mathworks.com/matlab/matlab/ref/sound.html
   */
  SOUND("sound"),
  /*
   * Scale data and play as sound
   * @see http://www.mathworks.com/matlab/matlab/ref/soundsc.html
   */
  SOUNDSC("soundsc"),

  /*
   * Utilities
   */
  /*
   * Produce operating system beep sound
   * @see http://www.mathworks.com/matlab/matlab/ref/beep.html
   */
  BEEP("beep"),
  /*
   * Convert linear audio signal to mu-law
   * @see http://www.mathworks.com/matlab/matlab/ref/lin2mu.html
   */
  LIN2MU("lin2mu"),
  /*
   * Convert mu-law audio signal to linear
   * @see http://www.mathworks.com/matlab/matlab/ref/mu2lin.html
   */
  MU2LIN("mu2lin"),

  /*
   * XML Documents
   */
  /*
   * Read XML document and return Document Object Model node
   * @see http://www.mathworks.com/matlab/matlab/ref/xmlread.html
   */
  XMLREAD("xmlread"),
  /*
   * Write XML Document Object Model node
   * @see http://www.mathworks.com/matlab/matlab/ref/xmlwrite.html
   */
  XMLWRITE("xmlwrite"),
  /*
   * Transform XML document using XSLT engine
   * @see http://www.mathworks.com/matlab/matlab/ref/xslt.html
   */
  XSLT("xslt"),

  /*
   * Memory Mapping
   */
  /*
   * Create memory map to a file
   * @see http://www.mathworks.com/matlab/matlab/ref/memmapfile.html
   */
  MEMMAPFILE("memmapfile"),

  /*
   * File Operations
   */
  /*
   * Files and Folders
   */
  /*
   * List folder contents
   * @see http://www.mathworks.com/matlab/matlab/ref/dir.html
   */
  DIR("dir"),
  /*
   * List folder contents
   * @see http://www.mathworks.com/matlab/matlab/ref/ls.html
   */
  LS("ls"),
  /*
   * Identify current folder
   * @see http://www.mathworks.com/matlab/matlab/ref/pwd.html
   */
  PWD("pwd"),
  /*
   * Set or get attributes of file or folder
   * @see http://www.mathworks.com/matlab/matlab/ref/fileattrib.html
   */
  FILEATTRIB("fileattrib"),
  /*
   * Check existence of variable, function, folder, or class
   * @see http://www.mathworks.com/matlab/matlab/ref/exist.html
   */
  EXIST("exist"),
  /*
   * Determine whether input is folder
   * @see http://www.mathworks.com/matlab/matlab/ref/isdir.html
   */
  ISDIR("isdir"),
  /*
   * Display contents of file
   * @see http://www.mathworks.com/matlab/matlab/ref/type.html
   */
//  TYPE("type"),
  /*
   * Compare two text files, MAT-Files, binary files, Zip files, or folders
   * @see http://www.mathworks.com/matlab/matlab/ref/visdiff.html
   */
  VISDIFF("visdiff"),
  /*
   * List MATLAB files in folder
   * @see http://www.mathworks.com/matlab/matlab/ref/what.html
   */
  WHAT("what"),
  /*
   * Locate functions and files
   * @see http://www.mathworks.com/matlab/matlab/ref/which.html
   */
  WHICH("which"),
  /*
   * Change current folder
   * @see http://www.mathworks.com/matlab/matlab/ref/cd.html
   */
  CD("cd"),
  /*
   * Copy file or folder
   * @see http://www.mathworks.com/matlab/matlab/ref/copyfile.html
   */
  COPYFILE("copyfile"),
  /*
   * Remove files or objects
   * @see http://www.mathworks.com/matlab/matlab/ref/delete.html
   */
  DELETE("delete"),
  /*
   * Set option to move deleted files to recycle folder
   * @see http://www.mathworks.com/matlab/matlab/ref/recycle.html
   */
  RECYCLE("recycle"),
  /*
   * Make new folder
   * @see http://www.mathworks.com/matlab/matlab/ref/mkdir.html
   */
  MKDIR("mkdir"),
  /*
   * Move file or folder
   * @see http://www.mathworks.com/matlab/matlab/ref/movefile.html
   */
  MOVEFILE("movefile"),
  /*
   * Remove folder
   * @see http://www.mathworks.com/matlab/matlab/ref/rmdir.html
   */
  RMDIR("rmdir"),
  /*
   * Open file in appropriate application
   * @see http://www.mathworks.com/matlab/matlab/ref/open.html
   */
  OPEN("open"),
  /*
   * Open file in appropriate application (Windows)
   * @see http://www.mathworks.com/matlab/matlab/ref/winopen.html
   */
  WINOPEN("winopen"),

  /*
   * File Name Construction
   */
  /*
   * Parts of file name and path
   * @see http://www.mathworks.com/matlab/matlab/ref/fileparts.html
   */
  FILEPARTS("fileparts"),
  /*
   * Build full file name from parts
   * @see http://www.mathworks.com/matlab/matlab/ref/fullfile.html
   */
  FULLFILE("fullfile"),
  /*
   * Character to separate file name and internal function name
   * @see http://www.mathworks.com/matlab/matlab/ref/filemarker.html
   */
  FILEMARKER("filemarker"),
  /*
   * File separator for current platform
   * @see http://www.mathworks.com/matlab/matlab/ref/filesep.html
   */
  FILESEP("filesep"),
  /*
   * Name of system's temporary folder
   * @see http://www.mathworks.com/matlab/matlab/ref/tempdir.html
   */
  TEMPDIR("tempdir"),
  /*
   * Unique name for temporary file
   * @see http://www.mathworks.com/matlab/matlab/ref/tempname.html
   */
  TEMPNAME("tempname"),
  /*
   * Root folder
   * @see http://www.mathworks.com/matlab/matlab/ref/matlabroot.html
   */
  MATLABROOT("matlabroot"),
  /*
   * Root folder for specified toolbox
   * @see http://www.mathworks.com/matlab/matlab/ref/toolboxdir.html
   */
  TOOLBOXDIR("toolboxdir"),

  /*
   * File Compression
   */
  /*
   * Compress files into zip file
   * @see http://www.mathworks.com/matlab/matlab/ref/zip.html
   */
  ZIP("zip"),
  /*
   * Extract contents of zip file
   * @see http://www.mathworks.com/matlab/matlab/ref/unzip.html
   */
  UNZIP("unzip"),
  /*
   * Compress files into GNU zip files
   * @see http://www.mathworks.com/matlab/matlab/ref/gzip.html
   */
  GZIP("gzip"),
  /*
   * Uncompress GNU zip files
   * @see http://www.mathworks.com/matlab/matlab/ref/gunzip.html
   */
  GUNZIP("gunzip"),
  /*
   * Compress files into tar file
   * @see http://www.mathworks.com/matlab/matlab/ref/tar.html
   */
  TAR("tar"),
  /*
   * Extract contents of tar file
   * @see http://www.mathworks.com/matlab/matlab/ref/untar.html
   */
  UNTAR("untar"),

  /*
   * Search Path
   */
  /*
   * Add folders to search path
   * @see http://www.mathworks.com/matlab/matlab/ref/addpath.html
   */
  ADDPATH("addpath"),
  /*
   * Remove folders from search path
   * @see http://www.mathworks.com/matlab/matlab/ref/rmpath.html
   */
  RMPATH("rmpath"),
  /*
   * View or change search path
   * @see http://www.mathworks.com/matlab/matlab/ref/path.html
   */
  PATH("path"),
  /*
   * Save current search path
   * @see http://www.mathworks.com/matlab/matlab/ref/savepath.html
   */
  SAVEPATH("savepath"),
  /*
   * View or change user portion of search path
   * @see http://www.mathworks.com/matlab/matlab/ref/userpath.html
   */
  USERPATH("userpath"),
  /*
   * Generate path string
   * @see http://www.mathworks.com/matlab/matlab/ref/genpath.html
   */
  GENPATH("genpath"),
  /*
   * Search path separator for current platform
   * @see http://www.mathworks.com/matlab/matlab/ref/pathsep.html
   */
  PATHSEP("pathsep"),
  /*
   * Open Set Path dialog box to view and change search path
   * @see http://www.mathworks.com/matlab/matlab/ref/pathtool.html
   */
  PATHTOOL("pathtool"),
  /*
   * Restore default search path
   * @see http://www.mathworks.com/matlab/matlab/ref/restoredefaultpath.html
   */
  RESTOREDEFAULTPATH("restoredefaultpath"),

  /*
   * Operating System Commands
   */
  /*
   * Copy and paste strings to and from system clipboard
   * @see http://www.mathworks.com/matlab/matlab/ref/clipboard.html
   */
  CLIPBOARD("clipboard"),
  /*
   * Information about computer on which MATLAB software is running
   * @see http://www.mathworks.com/matlab/matlab/ref/computer.html
   */
  COMPUTER("computer"),
  /*
   * Execute DOS command and return output
   * @see http://www.mathworks.com/matlab/matlab/ref/dos.html
   */
  DOS("dos"),
  /*
   * Environment variable
   * @see http://www.mathworks.com/matlab/matlab/ref/getenv.html
   */
  GETENV("getenv"),
  /*
   * Call Perl script using appropriate operating system executable
   * @see http://www.mathworks.com/matlab/matlab/ref/perl.html
   */
  PERL("perl"),
  /*
   * Set environment variable
   * @see http://www.mathworks.com/matlab/matlab/ref/setenv.html
   */
  SETENV("setenv"),
  /*
   * Execute operating system command and return output
   * @see http://www.mathworks.com/matlab/matlab/ref/system.html
   */
  SYSTEM("system"),
  /*
   * Execute UNIX command and return output
   * @see http://www.mathworks.com/matlab/matlab/ref/unix.html
   */
  UNIX("unix"),
  /*
   * Item from Windows registry
   * @see http://www.mathworks.com/matlab/matlab/ref/winqueryreg.html
   */
  WINQUERYREG("winqueryreg"),

  /*
   * Internet File Access
   */
  /*
   * Connect to FTP server
   * @see http://www.mathworks.com/matlab/matlab/ref/ftp-class.html
   */
  FTP("ftp"),
  /*
   * Send email message to address list
   * @see http://www.mathworks.com/matlab/matlab/ref/sendmail.html
   */
  SENDMAIL("sendmail"),
  /*
   * Download URL content to MATLAB string
   * @see http://www.mathworks.com/matlab/matlab/ref/urlread.html
   */
  URLREAD("urlread"),
  /*
   * Download URL content and save to file
   * @see http://www.mathworks.com/matlab/matlab/ref/urlwrite.html
   */
  URLWRITE("urlwrite"),
  /*
   * Open Web page or file in browser
   * @see http://www.mathworks.com/matlab/matlab/ref/web.html
   */
  WEB("web"),

  /*
   * Serial Port Devices   */
  /*
   * Remove serial port object from memory
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.delete.html
   */
  DELETE_SERIAL("delete (serial)"),
  /*
   * Disconnect serial port object from device
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.fclose.html
   */
  FCLOSE_SERIAL("fclose (serial)"),
  /*
   * Read line of text from device and discard terminator
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.fgetl.html
   */
  FGETL_SERIAL("fgetl (serial)"),
  /*
   * Read line of text from device and include terminator
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.fgets.html
   */
  FGETS_SERIAL("fgets (serial)"),
  /*
   * Connect serial port object to device
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.fopen.html
   */
  FOPEN_SERIAL("fopen (serial)"),
  /*
   * Write text to device
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.fprintf.html
   */
  FPRINTF_SERIAL("fprintf (serial)"),
  /*
   * Read binary data from device
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.fread.html
   */
  FREAD_SERIAL("fread (serial)"),
  /*
   * Read data from device, and format as text
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.fscanf.html
   */
  FSCANF_SERIAL("fscanf (serial)"),
  /*
   * Write binary data to device
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.fwrite.html
   */
  FWRITE_SERIAL("fwrite (serial)"),
  /*
   * Serial port object properties
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.get.html
   */
  GET_SERIAL("get (serial)"),
  /*
   * Event information when event occurs
   * @see http://www.mathworks.com/matlab/matlab/ref/instrcallback.html
   */
  INSTRCALLBACK("instrcallback"),
  /*
   * Read serial port objects from memory to MATLAB workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/instrfind.html
   */
  INSTRFIND("instrfind"),
  /*
   * Find visible and hidden serial port objects
   * @see http://www.mathworks.com/matlab/matlab/ref/instrfindall.html
   */
  INSTRFINDALL("instrfindall"),
  /*
   * Determine whether serial port objects are valid
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.isvalid.html
   */
  ISVALID_SERIAL("isvalid (serial)"),
  /*
   * Read data asynchronously from device
   * @see http://www.mathworks.com/matlab/matlab/ref/readasync.html
   */
  READASYNC("readasync"),
  /*
   * Record data and event information to file
   * @see http://www.mathworks.com/matlab/matlab/ref/record.html
   */
  RECORD("record"),
  /*
   * Create serial port object
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.html
   */
  SERIAL("serial"),
  /*
   * Send break to device connected to serial port
   * @see http://www.mathworks.com/matlab/matlab/ref/serialbreak.html
   */
  SERIALBREAK("serialbreak"),
  /*
   * Configure or display serial port object properties
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.set.html
   */
  SET_SERIAL("set (serial)"),
  /*
   * Stop asynchronous read and write operations
   * @see http://www.mathworks.com/matlab/matlab/ref/stopasync.html
   */
  STOPASYNC("stopasync"),
  /*
   * Remove serial port object from MATLAB workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.clear.html
   */
  CLEAR_SERIAL("clear (serial)"),
  /*
   * Load serial port objects and variables into MATLAB workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.load.html
   */
  LOAD_SERIAL("load (serial)"),
  /*
   * Save serial port objects and variables to file
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.save.html
   */
  SAVE_SERIAL("save (serial)"),
  /*
   * Serial port object summary information
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.disp.html
   */
  DISP_SERIAL("disp (serial)"),
  /*
   * Length of serial port object array
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.length.html
   */
  LENGTH_SERIAL("length (serial)"),
  /*
   * Size of serial port object array
   * @see http://www.mathworks.com/matlab/matlab/ref/serial.size.html
   */
  SIZE_SERIAL("size (serial)"),

  /*
   * Hardware Support
   */
  /*
   * Raspberry Pi Hardware
   */
  /*
   * Install and Set Up Support for Raspberry Pi Hardware
   */
  /*
   * Find and install support for third-party hardware or software
   * @see http://www.mathworks.com/matlab/matlab/ref/supportpackageinstaller.html
   */
  SUPPORTPACKAGEINSTALLER("supportpackageinstaller"),
  /*
   * Open featured examples for this support package
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi_examples.html
   */
  RASPI_EXAMPLES("raspi_examples"),
  /*
   * Open Support Package Installer and update firmware on third-party hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/targetupdater.html
   */
  TARGETUPDATER("targetupdater"),
  /*
   * Get information about installed support packages
   * @see http://www.mathworks.com/matlab/matlab/ref/matlabshared.supportpkg.checkforupdate.html
   */
  MATLABSHARED_SUPPORTPKG_CHECKFORUPDATE("matlabshared.supportpkg.checkforupdate"),
  /*
   * Get information about installed support packages
   * @see http://www.mathworks.com/matlab/matlab/ref/matlabshared.supportpkg.getinstalled.html
   */
  MATLABSHARED_SUPPORTPKG_GETINSTALLED("matlabshared.supportpkg.getinstalled"),

  /*
   * Create a Connection to Raspberry Pi Hardware
   */
  /*
   * Create connection to Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.html
   */
  RASPI("raspi"),

  /*
   * LEDs
   */
  /*
   * Create connection to Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.html
   */
//  RASPI("raspi"),
  /*
   * Turn LED on or off
   * @see http://www.mathworks.com/matlab/matlab/ref/writeled.html
   */
  WRITELED("writeled"),
  /*
   * Show location, name, and color of user-controllable LEDs
   * @see http://www.mathworks.com/matlab/matlab/ref/showleds.html
   */
  SHOWLEDS("showleds"),

  /*
   * GPIO Pins
   */
  /*
   * Create connection to Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.html
   */
//  RASPI("raspi"),
  /*
   * Configure GPIO pin as input or output
   * @see http://www.mathworks.com/matlab/matlab/ref/configuredigitalpin.html
   */
  CONFIGUREDIGITALPIN("configuredigitalpin"),
  /*
   * Read logical value from GPIO input pin
   * @see http://www.mathworks.com/matlab/matlab/ref/readdigitalpin.html
   */
  READDIGITALPIN("readdigitalpin"),
  /*
   * Write logical value to GPIO output pin
   * @see http://www.mathworks.com/matlab/matlab/ref/writedigitalpin.html
   */
  WRITEDIGITALPIN("writedigitalpin"),
  /*
   * Show diagram of GPIO pins
   * @see http://www.mathworks.com/matlab/matlab/ref/showpins.html
   */
  SHOWPINS("showpins"),

  /*
   * Serial Port
   */
  /*
   * Create connection to Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.html
   */
//  RASPI("raspi"),
  /*
   * Create connection to serial device
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.serialdev.html
   */
  SERIALDEV("serialdev"),
  /*
   * Read data from serial device
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.serialdev.read.html
   */
  READ("read"),
  /*
   * Write data to serial device
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.serialdev.write.html
   */
  WRITE("write"),

  /*
   * I2C Interface
   */
  /*
   * Create connection to Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.html
   */
//  RASPI("raspi"),
  /*
   * Scan I2C bus device addresses
   * @see http://www.mathworks.com/matlab/matlab/ref/scani2cbus.html
   */
  SCANI2CBUS("scani2cbus"),
  /*
   * Create connection to I2C device
   * @see http://www.mathworks.com/matlab/matlab/ref/i2cdev.html
   */
  I2CDEV("i2cdev"),
  /*
   * Read data from I2C device
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.i2cdev.read.html
   */
//  READ("read"),
  /*
   * Write data to I2C device
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.i2cdev.write.html
   */
//  WRITE("write"),
  /*
   * Read from register on I2C device
   * @see http://www.mathworks.com/matlab/matlab/ref/readregister.html
   */
  READREGISTER("readregister"),
  /*
   * Write to register on I2C device
   * @see http://www.mathworks.com/matlab/matlab/ref/writeregister.html
   */
  WRITEREGISTER("writeregister"),
  /*
   * Enable I2C interface
   * @see http://www.mathworks.com/matlab/matlab/ref/enablei2c.html
   */
  ENABLEI2C("enablei2c"),
  /*
   * Disable I2C interface
   * @see http://www.mathworks.com/matlab/matlab/ref/disablei2c.html
   */
  DISABLEI2C("disablei2c"),

  /*
   * SPI Interface
   */
  /*
   * Create connection to Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.html
   */
//  RASPI("raspi"),
  /*
   * Create connection to SPI device
   * @see http://www.mathworks.com/matlab/matlab/ref/spidev.html
   */
  SPIDEV("spidev"),
  /*
   * Write data to and read data from SPI device
   * @see http://www.mathworks.com/matlab/matlab/ref/writeread.html
   */
  WRITEREAD("writeread"),
  /*
   * Enable SPI interface
   * @see http://www.mathworks.com/matlab/matlab/ref/enablespi.html
   */
  ENABLESPI("enablespi"),
  /*
   * Disable SPI interface
   * @see http://www.mathworks.com/matlab/matlab/ref/disablespi.html
   */
  DISABLESPI("disablespi"),

  /*
   * Camera Board
   */
  /*
   * Create connection to Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.html
   */
//  RASPI("raspi"),
  /*
   * Create connection to Raspberry Pi Camera Board Module
   * @see http://www.mathworks.com/matlab/matlab/ref/cameraboard.html
   */
  CAMERABOARD("cameraboard"),
  /*
   * Capture RGB image from Camera Board
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.cameraboard.snapshot.html
   */
  SNAPSHOT("snapshot"),
  /*
   * Record video from Camera Board
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.cameraboard.record.html
   */
//  RECORD("record"),
  /*
   * Stop video recording from Camera Board
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.cameraboard.stop.html
   */
  STOP("stop"),

  /*
   * Linux
   */
  /*
   * Create connection to Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.html
   */
//  RASPI("raspi"),
  /*
   * Run command in Linux shell on Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/raspi.system.html
   */
//  SYSTEM("system"),
  /*
   * Open terminal on host computer to use Linux shell on Raspberry Pi hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/openshell.html
   */
  OPENSHELL("openshell"),
  /*
   * Transfer file from Raspberry Pi hardware to host computer
   * @see http://www.mathworks.com/matlab/matlab/ref/getfile.html
   */
  GETFILE("getfile"),
  /*
   * Transfer file from host computer to target hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/putfile.html
   */
  PUTFILE("putfile"),
  /*
   * Delete file on target hardware
   * @see http://www.mathworks.com/matlab/matlab/ref/deletefile.html
   */
//  DELETEFILE("deletefile"),

  /*
   * Webcams
   */
  /*
   * List of Webcams connected to your system
   * @see http://www.mathworks.com/matlab/matlab/ref/webcamlist.html
   */
  WEBCAMLIST("webcamlist"),
  /*
   * Create webcam object to acquire images from Webcams
   * @see http://www.mathworks.com/matlab/matlab/ref/webcam.html
   */
  WEBCAM("webcam"),
  /*
   * Preview live video data from Webcam
   * @see http://www.mathworks.com/matlab/matlab/ref/preview.html
   */
  PREVIEW("preview"),
  /*
   * Acquire single image frame from a Webcam
   * @see http://www.mathworks.com/matlab/matlab/ref/snapshot.html
   */
//  SNAPSHOT("snapshot"),
  /*
   * Close Webcam preview window
   * @see http://www.mathworks.com/matlab/matlab/ref/closepreview.html
   */
  CLOSEPREVIEW("closepreview"),

  /*
   * GUI Building
   */
  /*
   * GUI Building Basics
   */
  /*
   * Open GUI Layout Editor
   * @see http://www.mathworks.com/matlab/matlab/ref/guide.html
   */
  GUIDE("guide"),
  /*
   * Open Property Inspector
   * @see http://www.mathworks.com/matlab/matlab/ref/inspect.html
   */
//  INSPECT("inspect"),

  /*
   * Component Selection
   */
  /*
   * GUI Controls and Indicators
   */
  /*
   * Create figure graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/figure.html
   */
//  FIGURE("figure"),
  /*
   * Create axes graphics object
   * @see http://www.mathworks.com/matlab/matlab/ref/axes.html
   */
//  AXES("axes"),
  /*
   * Create user interface control object
   * @see http://www.mathworks.com/matlab/matlab/ref/uicontrol.html
   */
  UICONTROL("uicontrol"),
  /*
   * Create 2-D graphic table GUI component
   * @see http://www.mathworks.com/matlab/matlab/ref/uitable.html
   */
  UITABLE("uitable"),
  /*
   * Create panel container object
   * @see http://www.mathworks.com/matlab/matlab/ref/uipanel.html
   */
  UIPANEL("uipanel"),
  /*
   * Create container object to exclusively manage radio buttons and toggle buttons
   * @see http://www.mathworks.com/matlab/matlab/ref/uibuttongroup.html
   */
  UIBUTTONGROUP("uibuttongroup"),
  /*
   * Create Microsoft ActiveX control in figure window
   * @see http://www.mathworks.com/matlab/matlab/ref/actxcontrol.html
   */
//  ACTXCONTROL("actxcontrol"),

  /*
   * Menus and Toolbars
   */
  /*
   * Create menus and menu items on figure windows
   * @see http://www.mathworks.com/matlab/matlab/ref/uimenu.html
   */
  UIMENU("uimenu"),
  /*
   * Create context menu
   * @see http://www.mathworks.com/matlab/matlab/ref/uicontextmenu.html
   */
  UICONTEXTMENU("uicontextmenu"),
  /*
   * Create toolbar on figure
   * @see http://www.mathworks.com/matlab/matlab/ref/uitoolbar.html
   */
  UITOOLBAR("uitoolbar"),
  /*
   * Create push button on toolbar
   * @see http://www.mathworks.com/matlab/matlab/ref/uipushtool.html
   */
  UIPUSHTOOL("uipushtool"),
  /*
   * Create toggle button on toolbar
   * @see http://www.mathworks.com/matlab/matlab/ref/uitoggletool.html
   */
  UITOGGLETOOL("uitoggletool"),

  /*
   * Predefined Dialog Boxes
   */
  /*
   * Create and display empty dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/dialog.html
   */
  DIALOG("dialog"),
  /*
   * Create and open error dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/errordlg.html
   */
  ERRORDLG("errordlg"),
  /*
   * Create and open help dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/helpdlg.html
   */
  HELPDLG("helpdlg"),
  /*
   * Create and open message dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/msgbox.html
   */
  MSGBOX("msgbox"),
  /*
   * Create and open question dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/questdlg.html
   */
  QUESTDLG("questdlg"),
  /*
   * Specify and conditionally open dialog box according to user preference
   * @see http://www.mathworks.com/matlab/matlab/ref/uigetpref.html
   */
  UIGETPREF("uigetpref"),
  /*
   * Manage preferences used in uigetpref
   * @see http://www.mathworks.com/matlab/matlab/ref/uisetpref.html
   */
  UISETPREF("uisetpref"),
  /*
   * Open or update wait bar dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/waitbar.html
   */
  WAITBAR("waitbar"),
  /*
   * Open warning dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/warndlg.html
   */
  WARNDLG("warndlg"),
  /*
   * Export variables to workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/export2wsdlg.html
   */
  EXPORT2WSDLG("export2wsdlg"),
  /*
   * Create and open input dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/inputdlg.html
   */
  INPUTDLG("inputdlg"),
  /*
   * Create and open list-selection dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/listdlg.html
   */
  LISTDLG("listdlg"),
  /*
   * Open standard dialog box for setting object's color specification (ColorSpec)
   * @see http://www.mathworks.com/matlab/matlab/ref/uisetcolor.html
   */
  UISETCOLOR("uisetcolor"),
  /*
   * Open standard dialog box for setting object's font characteristics
   * @see http://www.mathworks.com/matlab/matlab/ref/uisetfont.html
   */
  UISETFONT("uisetfont"),
  /*
   * Print dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/printdlg.html
   */
  PRINTDLG("printdlg"),
  /*
   * Preview figure to print
   * @see http://www.mathworks.com/matlab/matlab/ref/printpreview.html
   */
  PRINTPREVIEW("printpreview"),
  /*
   * Open standard dialog box for selecting directory
   * @see http://www.mathworks.com/matlab/matlab/ref/uigetdir.html
   */
  UIGETDIR("uigetdir"),
  /*
   * Open standard dialog box for retrieving files
   * @see http://www.mathworks.com/matlab/matlab/ref/uigetfile.html
   */
  UIGETFILE("uigetfile"),
  /*
   * Interactively select file to open and load data
   * @see http://www.mathworks.com/matlab/matlab/ref/uiopen.html
   */
  UIOPEN("uiopen"),
  /*
   * Open standard dialog box for saving files
   * @see http://www.mathworks.com/matlab/matlab/ref/uiputfile.html
   */
  UIPUTFILE("uiputfile"),
  /*
   * Interactively save workspace variables to MAT-file
   * @see http://www.mathworks.com/matlab/matlab/ref/uisave.html
   */
  UISAVE("uisave"),
  /*
   * Generate menu of choices for user input
   * @see http://www.mathworks.com/matlab/matlab/ref/menu.html
   */
  MENU("menu"),

  /*
   * Component Layout
   */
  /*
   * Align user interface controls (uicontrols) and axes
   * @see http://www.mathworks.com/matlab/matlab/ref/align.html
   */
  ALIGN("align"),
  /*
   * Move GUI figure to specified location on screen
   * @see http://www.mathworks.com/matlab/matlab/ref/movegui.html
   */
  MOVEGUI("movegui"),
  /*
   * Get component position in pixels
   * @see http://www.mathworks.com/matlab/matlab/ref/getpixelposition.html
   */
  GETPIXELPOSITION("getpixelposition"),
  /*
   * Set component position in pixels
   * @see http://www.mathworks.com/matlab/matlab/ref/setpixelposition.html
   */
  SETPIXELPOSITION("setpixelposition"),
  /*
   * List available system fonts
   * @see http://www.mathworks.com/matlab/matlab/ref/listfonts.html
   */
  LISTFONTS("listfonts"),
  /*
   * Wrapped string matrix for given uicontrol
   * @see http://www.mathworks.com/matlab/matlab/ref/textwrap.html
   */
  TEXTWRAP("textwrap"),
  /*
   * Reorder visual stacking order of objects
   * @see http://www.mathworks.com/matlab/matlab/ref/uistack.html
   */
  UISTACK("uistack"),

  /*
   * Coding GUI Behavior
   */
  /*
   * Block program execution and wait to resume
   * @see http://www.mathworks.com/matlab/matlab/ref/uiwait.html
   */
  UIWAIT("uiwait"),
  /*
   * Resume execution of blocked program
   * @see http://www.mathworks.com/matlab/matlab/ref/uiresume.html
   */
  UIRESUME("uiresume"),
  /*
   * Block execution and wait for event or condition
   * @see http://www.mathworks.com/matlab/matlab/ref/waitfor.html
   */
//  WAITFOR("waitfor"),
  /*
   * Wait for key press or mouse-button click
   * @see http://www.mathworks.com/matlab/matlab/ref/waitforbuttonpress.html
   */
  WAITFORBUTTONPRESS("waitforbuttonpress"),
  /*
   * Value of application-defined data
   * @see http://www.mathworks.com/matlab/matlab/ref/getappdata.html
   */
  GETAPPDATA("getappdata"),
  /*
   * Specify application-defined data
   * @see http://www.mathworks.com/matlab/matlab/ref/setappdata.html
   */
  SETAPPDATA("setappdata"),
  /*
   * True if application-defined data exists
   * @see http://www.mathworks.com/matlab/matlab/ref/isappdata.html
   */
  ISAPPDATA("isappdata"),
  /*
   * Remove application-defined data
   * @see http://www.mathworks.com/matlab/matlab/ref/rmappdata.html
   */
  RMAPPDATA("rmappdata"),
  /*
   * Store or retrieve GUI data
   * @see http://www.mathworks.com/matlab/matlab/ref/guidata.html
   */
  GUIDATA("guidata"),
  /*
   * Create structure of handles
   * @see http://www.mathworks.com/matlab/matlab/ref/guihandles.html
   */
  GUIHANDLES("guihandles"),

  /*
   * Packaging GUIs as Apps
   */
  /*
   * Create or modify app project file for packaging app into .mlappinstall file using interactive dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.apputil.create.html
   */
  MATLAB_APPUTIL_CREATE("matlab.apputil.create"),
  /*
   * Package app files into .mlappinstall file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.apputil.package.html
   */
  MATLAB_APPUTIL_PACKAGE("matlab.apputil.package"),
  /*
   * Install app from a .mlappinstall file
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.apputil.install.html
   */
  MATLAB_APPUTIL_INSTALL("matlab.apputil.install"),
  /*
   * Run app programmatically
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.apputil.run.html
   */
  MATLAB_APPUTIL_RUN("matlab.apputil.run"),
  /*
   * List installed app information
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.apputil.getinstalledappinfo.html
   */
  MATLAB_APPUTIL_GETINSTALLEDAPPINFO("matlab.apputil.getinstalledappinfo"),
  /*
   * Uninstall app
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.apputil.uninstall.html
   */
  MATLAB_APPUTIL_UNINSTALL("matlab.apputil.uninstall"),

  /*
   * Advanced Software Development
   */
  /*
   * Object-Oriented Programming
   */
  /*
   * Class Syntax Fundamentals
   */
  /*
   * Class definition keywords
   * @see http://www.mathworks.com/matlab/matlab/ref/classdef.html
   */
//  CLASSDEF("classdef"),
  /*
   * Determine class of object
   * @see http://www.mathworks.com/matlab/matlab/ref/class.html
   */
//  CLASS("class"),
  /*
   * Determine if input is object of specified class
   * @see http://www.mathworks.com/matlab/matlab/ref/isa.html
   */
//  ISA("isa"),
  /*
   * Determine array equality
   * @see http://www.mathworks.com/matlab/matlab/ref/isequal.html
   */
//  ISEQUAL("isequal"),
  /*
   * Determine if input is MATLAB object
   * @see http://www.mathworks.com/matlab/matlab/ref/isobject.html
   */
//  ISOBJECT("isobject"),
  /*
   * Display class enumeration members and names
   * @see http://www.mathworks.com/matlab/matlab/ref/enumeration.html
   */
//  ENUMERATION("enumeration"),
  /*
   * Event names
   * @see http://www.mathworks.com/matlab/matlab/ref/events.html
   */
//  EVENTS("events"),
  /*
   * Class method names
   * @see http://www.mathworks.com/matlab/matlab/ref/methods.html
   */
//  METHODS("methods"),
  /*
   * Class property names
   * @see http://www.mathworks.com/matlab/matlab/ref/properties.html
   */
//  PROPERTIES("properties"),

  /*
   * Defining MATLAB Classes
   */
  /*
   * Class Definition and Organization
   */
  /*
   * Class definition keywords
   * @see http://www.mathworks.com/matlab/matlab/ref/classdef.html
   */
  CLASSDEF("classdef"),
  /*
   * Add package or class to current import list
   * @see http://www.mathworks.com/matlab/matlab/ref/import.html
   */
  IMPORT("import"),

  /*
   * Properties
   */
  /*
   * Class property names
   * @see http://www.mathworks.com/matlab/matlab/ref/properties.html
   */
  PROPERTIES("properties"),
  /*
   * Determine if property of object
   * @see http://www.mathworks.com/matlab/matlab/ref/isprop.html
   */
  ISPROP("isprop"),
  /*
   * Abstract class used to derive handle class with dynamic properties
   * @see http://www.mathworks.com/matlab/matlab/ref/dynamicprops.html
   */
  DYNAMICPROPS("dynamicprops"),
  /*
   * meta.property class describes MATLAB class properties
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.property.html
   */
  META_PROPERTY("meta.property"),

  /*
   * Methods
   */
  /*
   * Class method names
   * @see http://www.mathworks.com/matlab/matlab/ref/methods.html
   */
  METHODS("methods"),
  /*
   * Determine if method of object
   * @see http://www.mathworks.com/matlab/matlab/ref/ismethod.html
   */
  ISMETHOD("ismethod"),
  /*
   * meta.method class describes MATLAB class methods
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.method.html
   */
  META_METHOD("meta.method"),

  /*
   * Handle Classes
   */
  /*
   * Abstract class for deriving handle classes
   * @see http://www.mathworks.com/matlab/matlab/ref/handle.html
   */
  HANDLE("handle"),
  /*
   * Abstract class used to derive handle class with set and get methods
   * @see http://www.mathworks.com/matlab/matlab/ref/hgsetget.html
   */
  HGSETGET("hgsetget"),
  /*
   * Abstract class used to derive handle class with dynamic properties
   * @see http://www.mathworks.com/matlab/matlab/ref/dynamicprops.html
   */
//  DYNAMICPROPS("dynamicprops"),
  /*
   * Superclass providing copy functionality for handle objects
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.mixin.copyable-class.html
   */
  MATLAB_MIXIN_COPYABLE("matlab.mixin.copyable"),
  /*
   * Handle object destructor
   * @see http://www.mathworks.com/matlab/matlab/ref/handle.delete.html
   */
//  DELETE("delete"),
  /*
   * Find handle objects matching specified conditions
   * @see http://www.mathworks.com/matlab/matlab/ref/handle.findobj.html
   */
  FINDOBJ("findobj"),
  /*
   * Determine if input is object of specified class
   * @see http://www.mathworks.com/matlab/matlab/ref/isa.html
   */
//  ISA("isa"),
  /*
   * Is object valid handle class object
   * @see http://www.mathworks.com/matlab/matlab/ref/handle.isvalid.html
   */
  ISVALID("isvalid"),
  /*
   * Find meta.property object associated with property name
   * @see http://www.mathworks.com/matlab/matlab/ref/handle.findprop.html
   */
  FINDPROP("findprop"),
  /*
   * Equality and sorting of handle objects
   * @see http://www.mathworks.com/matlab/matlab/ref/handle.relationaloperators.html
   */
  RELATIONALOPERATORS("relationaloperators"),

  /*
   * Events
   */
  /*
   * Event names
   * @see http://www.mathworks.com/matlab/matlab/ref/events.html
   */
  EVENTS("events"),
  /*
   * Notify listeners that event is occurring
   * @see http://www.mathworks.com/matlab/matlab/ref/handle.notify.html
   */
  NOTIFY("notify"),
  /*
   * Create event listener
   * @see http://www.mathworks.com/matlab/matlab/ref/handle.addlistener.html
   */
  ADDLISTENER("addlistener"),
  /*
   * Base class for all data objects passed to event listeners
   * @see http://www.mathworks.com/matlab/matlab/ref/event.eventdata.html
   */
  EVENT_EVENTDATA("event.eventdata"),
  /*
   * Class defining listener objects
   * @see http://www.mathworks.com/matlab/matlab/ref/event.listener.html
   */
  EVENT_LISTENER("event.listener"),
  /*
   * Data for property events
   * @see http://www.mathworks.com/matlab/matlab/ref/event.propertyevent.html
   */
  EVENT_PROPERTYEVENT("event.propertyevent"),
  /*
   * Define listener object for property events
   * @see http://www.mathworks.com/matlab/matlab/ref/event.proplistener.html
   */
  EVENT_PROPLISTENER("event.proplistener"),

  /*
   * Object Arrays
   */
  /*
   * Create empty array
   * @see http://www.mathworks.com/matlab/matlab/ref/empty.html
   */
  EMPTY("empty"),
  /*
   * Superclass for heterogeneous array formation
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.mixin.heterogeneous-class.html
   */
  MATLAB_MIXIN_HETEROGENEOUS("matlab.mixin.heterogeneous"),

  /*
   * Class Hierarchies
   */
  /*
   * Superclass names
   * @see http://www.mathworks.com/matlab/matlab/ref/superclasses.html
   */
  SUPERCLASSES("superclasses"),
  /*
   * Superclass for heterogeneous array formation
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.mixin.heterogeneous-class.html
   */
//  MATLAB_MIXIN_HETEROGENEOUS("matlab.mixin.heterogeneous"),

  /*
   * Enumerations
   */
  /*
   * Display class enumeration members and names
   * @see http://www.mathworks.com/matlab/matlab/ref/enumeration.html
   */
  ENUMERATION("enumeration"),
  /*
   * Describes enumeration members of MATLAB class
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.enumeratedvalue.html
   */
//  META_ENUMERATEDVALUE("meta.enumeratedvalue"),

  /*
   * Control Save and Load
   */
  /*
   * Save workspace variables to file
   * @see http://www.mathworks.com/matlab/matlab/ref/save.html
   */
//  SAVE("save"),
  /*
   * Load variables from file into workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/load.html
   */
//  LOAD("load"),
  /*
   * Modify save process for object
   * @see http://www.mathworks.com/matlab/matlab/ref/saveobj.html
   */
  SAVEOBJ("saveobj"),
  /*
   * Modify load process for object
   * @see http://www.mathworks.com/matlab/matlab/ref/loadobj.html
   */
  LOADOBJ("loadobj"),

  /*
   * Customize MATLAB Behavior
   */
  /*
   * Concatenate arrays along specified dimension
   * @see http://www.mathworks.com/matlab/matlab/ref/cat.html
   */
//  CAT("cat"),
  /*
   * Concatenate arrays horizontally
   * @see http://www.mathworks.com/matlab/matlab/ref/horzcat.html
   */
//  HORZCAT("horzcat"),
  /*
   * Concatenate arrays vertically
   * @see http://www.mathworks.com/matlab/matlab/ref/vertcat.html
   */
//  VERTCAT("vertcat"),
  /*
   * Create empty array
   * @see http://www.mathworks.com/matlab/matlab/ref/empty.html
   */
//  EMPTY("empty"),
  /*
   * Display text or array
   * @see http://www.mathworks.com/matlab/matlab/ref/disp.html
   */
//  DISP("disp"),
  /*
   * Display text and numeric expressions
   * @see http://www.mathworks.com/matlab/matlab/ref/display.html
   */
  DISPLAY("display"),
  /*
   * Number of array elements
   * @see http://www.mathworks.com/matlab/matlab/ref/numel.html
   */
//  NUMEL("numel"),
  /*
   * Array dimensions
   * @see http://www.mathworks.com/matlab/matlab/ref/size.html
   */
//  SIZE("size"),
  /*
   * Terminate block of code, or indicate last array index
   * @see http://www.mathworks.com/matlab/matlab/ref/end.html
   */
//  END("end"),
  /*
   * Redefine subscripted reference for objects
   * @see http://www.mathworks.com/matlab/matlab/ref/subsref.html
   */
  SUBSREF("subsref"),
  /*
   * Subscripted assignment
   * @see http://www.mathworks.com/matlab/matlab/ref/subsasgn.html
   */
  SUBSASGN("subsasgn"),
  /*
   *  Subscript indexing with object
   * @see http://www.mathworks.com/matlab/matlab/ref/subsindex.html
   */
  SUBSINDEX("subsindex"),
  /*
   * Create structure argument for subsasgn or subsref
   * @see http://www.mathworks.com/matlab/matlab/ref/substruct.html
   */
  SUBSTRUCT("substruct"),

  /*
   * Custom Object Display
   */
  /*
   * Display text or array
   * @see http://www.mathworks.com/matlab/matlab/ref/disp.html
   */
//  DISP("disp"),
  /*
   * Display text and numeric expressions
   * @see http://www.mathworks.com/matlab/matlab/ref/display.html
   */
//  DISPLAY("display"),
  /*
   * Display array details
   * @see http://www.mathworks.com/matlab/matlab/ref/details.html
   */
  DETAILS("details"),
  /*
   * Display customization interface class
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.mixin.customdisplay-class.html
   */
  MATLAB_MIXIN_CUSTOMDISPLAY("matlab.mixin.customdisplay"),
  /*
   * Custom property list for object display
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.mixin.util.propertygroup-class.html
   */
  MATLAB_MIXIN_UTIL_PROPERTYGROUP("matlab.mixin.util.propertygroup"),

  /*
   * Getting Information About Classes and Objects
   */
  /*
   * Obtain meta.class object
   * @see http://www.mathworks.com/matlab/matlab/ref/metaclass.html
   */
  METACLASS("metaclass"),
  /*
   * Find abstract methods and properties
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.abstractdetails.html
   */
  META_ABSTRACTDETAILS("meta.abstractdetails"),
  /*
   * Return meta.class object associated with named class
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.class.fromname.html
   */
  META_CLASS_FROMNAME("meta.class.fromname"),
  /*
   * Return meta.package object for specified package
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.package.fromname.html
   */
  META_PACKAGE_FROMNAME("meta.package.fromname"),
  /*
   * Get all top-level packages
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.package.getallpackages.html
   */
  META_PACKAGE_GETALLPACKAGES("meta.package.getallpackages"),
  /*
   * meta.class class describes MATLAB classes
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.class.html
   */
  META_CLASS("meta.class"),
  /*
   * meta.property class describes MATLAB class properties
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.property.html
   */
//  META_PROPERTY("meta.property"),
  /*
   * meta.method class describes MATLAB class methods
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.method.html
   */
//  META_METHOD("meta.method"),
  /*
   * meta.event class describes MATLAB class events
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.event.html
   */
  META_EVENT("meta.event"),
  /*
   * meta.package class describes MATLAB packages
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.package.html
   */
  META_PACKAGE("meta.package"),
  /*
   * meta.DynamicProperty class describes dynamic property of MATLAB object
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.dynamicproperty.html
   */
  META_DYNAMICPROPERTY("meta.dynamicproperty"),
  /*
   * Describes enumeration members of MATLAB class
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.enumeratedvalue.html
   */
//  META_ENUMERATEDVALUE("meta.enumeratedvalue"),
  /*
   * Superclass for MATLAB object metadata
   * @see http://www.mathworks.com/matlab/matlab/ref/meta.metadata-class.html
   */
  META_METADATA("meta.metadata"),

  /*
   * Calling External Functions
   */
  /*
   * Call MEX-File Functions
   */
  /*
   * Binary MEX-file-name extension
   * @see http://www.mathworks.com/matlab/matlab/ref/mexext.html
   */
  MEXEXT("mexext"),
  /*
   * Names of functions, MEX-files, classes in memory
   * @see http://www.mathworks.com/matlab/matlab/ref/inmem.html
   */
  INMEM("inmem"),

  /*
   * Call C Shared Libraries
   */
  /*
   * Load shared library into MATLAB
   * @see http://www.mathworks.com/matlab/matlab/ref/loadlibrary.html
   */
  LOADLIBRARY("loadlibrary"),
  /*
   * Unload shared library from memory
   * @see http://www.mathworks.com/matlab/matlab/ref/unloadlibrary.html
   */
  UNLOADLIBRARY("unloadlibrary"),
  /*
   * Determine if shared library is loaded
   * @see http://www.mathworks.com/matlab/matlab/ref/libisloaded.html
   */
  LIBISLOADED("libisloaded"),
  /*
   * Call function in shared library
   * @see http://www.mathworks.com/matlab/matlab/ref/calllib.html
   */
  CALLLIB("calllib"),
  /*
   * Return information on functions in shared library
   * @see http://www.mathworks.com/matlab/matlab/ref/libfunctions.html
   */
  LIBFUNCTIONS("libfunctions"),
  /*
   * Display shared library function signatures in window
   * @see http://www.mathworks.com/matlab/matlab/ref/libfunctionsview.html
   */
  LIBFUNCTIONSVIEW("libfunctionsview"),
  /*
   * Convert MATLAB structure to C-style structure for use with shared library
   * @see http://www.mathworks.com/matlab/matlab/ref/libstruct.html
   */
  LIBSTRUCT("libstruct"),
  /*
   * Pointer object for use with shared library
   * @see http://www.mathworks.com/matlab/matlab/ref/libpointer.html
   */
  LIBPOINTER("libpointer"),
  /*
   * Pointer object compatible with C pointer
   * @see http://www.mathworks.com/matlab/matlab/ref/lib.pointer-class.html
   */
  LIB_POINTER("lib.pointer"),

  /*
   * Call Java Libraries
   */
  /*
   * Construct Java array object
   * @see http://www.mathworks.com/matlab/matlab/ref/javaarray.html
   */
  JAVAARRAY("javaarray"),
  /*
   * Return Java class path or specify dynamic path
   * @see http://www.mathworks.com/matlab/matlab/ref/javaclasspath.html
   */
  JAVACLASSPATH("javaclasspath"),
  /*
   * Add entries to dynamic Java class path
   * @see http://www.mathworks.com/matlab/matlab/ref/javaaddpath.html
   */
  JAVAADDPATH("javaaddpath"),
  /*
   * Remove entries from dynamic Java class path
   * @see http://www.mathworks.com/matlab/matlab/ref/javarmpath.html
   */
  JAVARMPATH("javarmpath"),
  /*
   * Error message based on Java feature support
   * @see http://www.mathworks.com/matlab/matlab/ref/javachk.html
   */
  JAVACHK("javachk"),
  /*
   * Determine if input is Java object
   * @see http://www.mathworks.com/matlab/matlab/ref/isjava.html
   */
//  ISJAVA("isjava"),
  /*
   * Determine if Java feature is available
   * @see http://www.mathworks.com/matlab/matlab/ref/usejava.html
   */
  USEJAVA("usejava"),
  /*
   * Call Java method
   * @see http://www.mathworks.com/matlab/matlab/ref/javamethod.html
   */
  JAVAMETHOD("javamethod"),
  /*
   * Call Java method from Event Dispatch Thread (EDT)
   * @see http://www.mathworks.com/matlab/matlab/ref/javamethodedt.html
   */
  JAVAMETHODEDT("javamethodedt"),
  /*
   * Call Java constructor
   * @see http://www.mathworks.com/matlab/matlab/ref/javaobject.html
   */
  JAVAOBJECT("javaobject"),
  /*
   * Call Java constructor on Event Dispatch Thread (EDT)
   * @see http://www.mathworks.com/matlab/matlab/ref/javaobjectedt.html
   */
  JAVAOBJECTEDT("javaobjectedt"),
  /*
   * Create cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/cell.html
   */
//  CELL("cell"),
  /*
   * Determine class of object
   * @see http://www.mathworks.com/matlab/matlab/ref/class.html
   */
//  CLASS("class"),
  /*
   * Remove items from workspace, freeing up system memory
   * @see http://www.mathworks.com/matlab/matlab/ref/clear.html
   */
//  CLEAR("clear"),
  /*
   * List dependencies of function or P-file
   * @see http://www.mathworks.com/matlab/matlab/ref/depfun.html
   */
  DEPFUN("depfun"),
  /*
   * Check existence of variable, function, folder, or class
   * @see http://www.mathworks.com/matlab/matlab/ref/exist.html
   */
//  EXIST("exist"),
  /*
   * Field names of structure, or public fields of object
   * @see http://www.mathworks.com/matlab/matlab/ref/fieldnames.html
   */
//  FIELDNAMES("fieldnames"),
  /*
   * Convert image to Java image
   * @see http://www.mathworks.com/matlab/matlab/ref/im2java.html
   */
//  IM2JAVA("im2java"),
  /*
   * Add package or class to current import list
   * @see http://www.mathworks.com/matlab/matlab/ref/import.html
   */
//  IMPORT("import"),
  /*
   * Names of functions, MEX-files, classes in memory
   * @see http://www.mathworks.com/matlab/matlab/ref/inmem.html
   */
//  INMEM("inmem"),
  /*
   * Open Property Inspector
   * @see http://www.mathworks.com/matlab/matlab/ref/inspect.html
   */
  INSPECT("inspect"),
  /*
   * Determine if input is object of specified class
   * @see http://www.mathworks.com/matlab/matlab/ref/isa.html
   */
//  ISA("isa"),
  /*
   * Class method names
   * @see http://www.mathworks.com/matlab/matlab/ref/methods.html
   */
//  METHODS("methods"),
  /*
   * View class methods
   * @see http://www.mathworks.com/matlab/matlab/ref/methodsview.html
   */
  METHODSVIEW("methodsview"),
  /*
   * Locate functions and files
   * @see http://www.mathworks.com/matlab/matlab/ref/which.html
   */
//  WHICH("which"),
  /*
   * Capture error information for Java exception
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.exception.javaexception-class.html
   */
  MATLAB_EXCEPTION_JAVAEXCEPTION("matlab.exception.javaexception"),

  /*
   * Call .NET Libraries
   */
  /*
   * Getting Started   */
  /*
   * Make .NET assembly visible to MATLAB
   * @see http://www.mathworks.com/matlab/matlab/ref/net.addassembly.html
   */
  NET_ADDASSEMBLY("net.addassembly"),
  /*
   * Check for supported Microsoft .NET Framework
   * @see http://www.mathworks.com/matlab/matlab/ref/net.isnetsupported.html
   */
  NET_ISNETSUPPORTED("net.isnetsupported"),
  /*
   * Summary of functions in MATLAB .NET interface
   * @see http://www.mathworks.com/matlab/matlab/ref/net.html
   */
  NET("net"),
  /*
   * Enable access to .NET commands from network drive
   * @see http://www.mathworks.com/matlab/matlab/ref/enablenetfromnetworkdrive.html
   */
  ENABLENETFROMNETWORKDRIVE("enablenetfromnetworkdrive"),
  /*
   * Members of .NET assembly
   * @see http://www.mathworks.com/matlab/matlab/ref/net.assembly-class.html
   */
  NET_ASSEMBLY("net.assembly"),
  /*
   * Capture error information for .NET exception
   * @see http://www.mathworks.com/matlab/matlab/ref/net.netexception-class.html
   */
  NET_NETEXCEPTION("net.netexception"),

  /*
   * Data Types   */
  /*
   * Array for nonprimitive .NET types
   * @see http://www.mathworks.com/matlab/matlab/ref/net.createarray.html
   */
  NET_CREATEARRAY("net.createarray"),
  /*
   * Create cell array
   * @see http://www.mathworks.com/matlab/matlab/ref/cell.html
   */
//  CELL("cell"),
  /*
   * Lock .NET object representing a RunTime Callable Wrapper (COM Wrapper) so that MATLAB does not release COM object
   * @see http://www.mathworks.com/matlab/matlab/ref/net.disableautorelease.html
   */
  NET_DISABLEAUTORELEASE("net.disableautorelease"),
  /*
   * Unlock .NET object representing a RunTime Callable Wrapper (COM Wrapper) so that MATLAB releases COM object
   * @see http://www.mathworks.com/matlab/matlab/ref/net.enableautorelease.html
   */
  NET_ENABLEAUTORELEASE("net.enableautorelease"),

  /*
   * Properties   */
  /*
   * Static property or field name
   * @see http://www.mathworks.com/matlab/matlab/ref/net.setstaticproperty.html
   */
  NET_SETSTATICPROPERTY("net.setstaticproperty"),

  /*
   * Events and Delegates
   */
  /*
   * Initiate asynchronous .NET delegate call
   * @see http://www.mathworks.com/matlab/matlab/ref/begininvoke.html
   */
  BEGININVOKE("begininvoke"),
  /*
   * Retrieve result of asynchronous call initiated by .NET System.Delegate BeginInvoke method
   * @see http://www.mathworks.com/matlab/matlab/ref/endinvoke.html
   */
  ENDINVOKE("endinvoke"),
  /*
   * Convenience function for static .NET System.Delegate Combine method
   * @see http://www.mathworks.com/matlab/matlab/ref/combine.html
   */
  COMBINE("combine"),
  /*
   * Convenience function for static .NET System.Delegate Remove method
   * @see http://www.mathworks.com/matlab/matlab/ref/remove.html
   */
//  REMOVE("remove"),
  /*
   * Convenience function for static .NET System.Delegate RemoveAll method
   * @see http://www.mathworks.com/matlab/matlab/ref/removeall.html
   */
  REMOVEALL("removeall"),

  /*
   * Enumerations
   */
  /*
   * Bit-wise AND
   * @see http://www.mathworks.com/matlab/matlab/ref/bitand.html
   */
//  BITAND("bitand"),
  /*
   * Bit-wise OR
   * @see http://www.mathworks.com/matlab/matlab/ref/bitor.html
   */
//  BITOR("bitor"),
  /*
   * Bit-wise XOR
   * @see http://www.mathworks.com/matlab/matlab/ref/bitxor.html
   */
//  BITXOR("bitxor"),
  /*
   * .NET enumeration object bit-wise NOT instance method
   * @see http://www.mathworks.com/matlab/matlab/ref/bitnot.html
   */
  BITNOT("bitnot"),

  /*
   * Generic Classes   */
  /*
   * Convert numeric MATLAB array to .NET array
   * @see http://www.mathworks.com/matlab/matlab/ref/net.convertarray.html
   */
  NET_CONVERTARRAY("net.convertarray"),
  /*
   * Create instance of specialized .NET generic type
   * @see http://www.mathworks.com/matlab/matlab/ref/net.creategeneric.html
   */
  NET_CREATEGENERIC("net.creategeneric"),
  /*
   * Invoke generic method of object
   * @see http://www.mathworks.com/matlab/matlab/ref/net.invokegenericmethod.html
   */
  NET_INVOKEGENERICMETHOD("net.invokegenericmethod"),
  /*
   * Represent parameterized generic type definitions
   * @see http://www.mathworks.com/matlab/matlab/ref/net.genericclass-class.html
   */
  NET_GENERICCLASS("net.genericclass"),

  /*
   * Call COM Objects
   */
  /*
   * Create COM server
   * @see http://www.mathworks.com/matlab/matlab/ref/actxserver.html
   */
  ACTXSERVER("actxserver"),
  /*
   * Create Microsoft ActiveX control in figure window
   * @see http://www.mathworks.com/matlab/matlab/ref/actxcontrol.html
   */
  ACTXCONTROL("actxcontrol"),
  /*
   * List currently installed Microsoft ActiveX controls
   * @see http://www.mathworks.com/matlab/matlab/ref/actxcontrollist.html
   */
  ACTXCONTROLLIST("actxcontrollist"),
  /*
   * Create Microsoft ActiveX control from GUI
   * @see http://www.mathworks.com/matlab/matlab/ref/actxcontrolselect.html
   */
  ACTXCONTROLSELECT("actxcontrolselect"),
  /*
   * Determine whether input is COM or ActiveX object
   * @see http://www.mathworks.com/matlab/matlab/ref/iscom.html
   */
  ISCOM("iscom"),
  /*
   * Determine whether input is COM object property
   * @see http://www.mathworks.com/matlab/matlab/ref/com.isprop.html
   */
//  ISPROP("isprop"),
  /*
   * Get property value from interface, or display properties
   * @see http://www.mathworks.com/matlab/matlab/ref/com.get.html
   */
//  GET("get"),
  /*
   * Set object or interface property to specified value
   * @see http://www.mathworks.com/matlab/matlab/ref/com.set.html
   */
//  SET("set"),
  /*
   * Add custom property to COM object
   * @see http://www.mathworks.com/matlab/matlab/ref/addproperty.html
   */
  ADDPROPERTY("addproperty"),
  /*
   * Remove custom property from COM object
   * @see http://www.mathworks.com/matlab/matlab/ref/deleteproperty.html
   */
  DELETEPROPERTY("deleteproperty"),
  /*
   * Open Property Inspector
   * @see http://www.mathworks.com/matlab/matlab/ref/inspect.html
   */
//  INSPECT("inspect"),
  /*
   * Open built-in property page for control
   * @see http://www.mathworks.com/matlab/matlab/ref/com.propedit.html
   */
  PROPEDIT("propedit"),
  /*
   * Field names of structure, or public fields of object
   * @see http://www.mathworks.com/matlab/matlab/ref/fieldnames.html
   */
//  FIELDNAMES("fieldnames"),
  /*
   * Determine whether input is COM object method
   * @see http://www.mathworks.com/matlab/matlab/ref/com.ismethod.html
   */
//  ISMETHOD("ismethod"),
  /*
   * Class method names
   * @see http://www.mathworks.com/matlab/matlab/ref/methods.html
   */
//  METHODS("methods"),
  /*
   * View class methods
   * @see http://www.mathworks.com/matlab/matlab/ref/methodsview.html
   */
//  METHODSVIEW("methodsview"),
  /*
   * Invoke method on COM object or interface, or display methods
   * @see http://www.mathworks.com/matlab/matlab/ref/invoke.html
   */
  INVOKE("invoke"),
  /*
   * Determine whether input is COM object event
   * @see http://www.mathworks.com/matlab/matlab/ref/isevent.html
   */
  ISEVENT("isevent"),
  /*
   * List of events COM object can trigger
   * @see http://www.mathworks.com/matlab/matlab/ref/com.events.html
   */
//  EVENTS("events"),
  /*
   * List event handler functions associated with COM object events
   * @see http://www.mathworks.com/matlab/matlab/ref/eventlisteners.html
   */
  EVENTLISTENERS("eventlisteners"),
  /*
   * Associate event handler for COM object event at run time
   * @see http://www.mathworks.com/matlab/matlab/ref/registerevent.html
   */
  REGISTEREVENT("registerevent"),
  /*
   * Unregister all event handlers associated with COM object events at run time
   * @see http://www.mathworks.com/matlab/matlab/ref/unregisterallevents.html
   */
  UNREGISTERALLEVENTS("unregisterallevents"),
  /*
   * Unregister event handler associated with COM object event at run time
   * @see http://www.mathworks.com/matlab/matlab/ref/unregisterevent.html
   */
  UNREGISTEREVENT("unregisterevent"),
  /*
   * Determine whether input is COM interface
   * @see http://www.mathworks.com/matlab/matlab/ref/isinterface.html
   */
  ISINTERFACE("isinterface"),
  /*
   * List custom interfaces exposed by COM server object
   * @see http://www.mathworks.com/matlab/matlab/ref/interfaces.html
   */
  INTERFACES("interfaces"),
  /*
   * Release COM interface
   * @see http://www.mathworks.com/matlab/matlab/ref/release.html
   */
  RELEASE("release"),
  /*
   * Remove COM control or server
   * @see http://www.mathworks.com/matlab/matlab/ref/com.delete.html
   */
//  DELETE("delete"),
  /*
   * Move or resize control in parent window
   * @see http://www.mathworks.com/matlab/matlab/ref/move.html
   */
  MOVE("move"),
  /*
   * Initialize control object from file
   * @see http://www.mathworks.com/matlab/matlab/ref/com.load.html
   */
//  LOAD("load"),
  /*
   * Serialize control object to file
   * @see http://www.mathworks.com/matlab/matlab/ref/com.save.html
   */
//  SAVE("save"),

  /*
   * Call Web Services
   */
  /*
   * Send SOAP message to endpoint
   * @see http://www.mathworks.com/matlab/matlab/ref/callsoapservice.html
   */
  CALLSOAPSERVICE("callsoapservice"),
  /*
   * Create MATLAB class based on WSDL document
   * @see http://www.mathworks.com/matlab/matlab/ref/createclassfromwsdl.html
   */
  CREATECLASSFROMWSDL("createclassfromwsdl"),
  /*
   * Create SOAP message to send to server
   * @see http://www.mathworks.com/matlab/matlab/ref/createsoapmessage.html
   */
  CREATESOAPMESSAGE("createsoapmessage"),
  /*
   * Convert response string from SOAP server into MATLAB types
   * @see http://www.mathworks.com/matlab/matlab/ref/parsesoapresponse.html
   */
  PARSESOAPRESPONSE("parsesoapresponse"),

  /*
   * Exception Handling   */
  /*
   * Execute statements and catch resulting errors
   * @see http://www.mathworks.com/matlab/matlab/ref/try.html
   */
//  TRY("try"), 
//  CATCH("catch"),
  /*
   * Record additional causes of exception
   * @see http://www.mathworks.com/matlab/matlab/ref/addcausemexception.html
   */
  ADDCAUSE_MEXCEPTION("addcause (mexception)"),
  /*
   * Get error message for exception
   * @see http://www.mathworks.com/matlab/matlab/ref/getreportmexception.html
   */
  GETREPORT_MEXCEPTION("getreport (mexception)"),
  /*
   * Last uncaught exception
   * @see http://www.mathworks.com/matlab/matlab/ref/lastmexception.html
   */
  LAST_MEXCEPTION("last (mexception)"),
  /*
   * Reissue existing exception
   * @see http://www.mathworks.com/matlab/matlab/ref/rethrowmexception.html
   */
  RETHROW_MEXCEPTION("rethrow (mexception)"),
  /*
   * Issue exception and terminate function
   * @see http://www.mathworks.com/matlab/matlab/ref/throwmexception.html
   */
  THROW_MEXCEPTION("throw (mexception)"),
  /*
   * Throw exception as if from calling function
   * @see http://www.mathworks.com/matlab/matlab/ref/throwascallermexception.html
   */
  THROWASCALLER_MEXCEPTION("throwascaller (mexception)"),
  /*
   * Capture error information
   * @see http://www.mathworks.com/matlab/matlab/ref/mexception.html
   */
  MEXCEPTION("mexception"),

  /*
   * Unit Testing Framework
   */
  /*
   * Write Unit Tests
   */
  /*
   * Create array of tests from handles to local functions
   * @see http://www.mathworks.com/matlab/matlab/ref/functiontests.html
   */
  FUNCTIONTESTS("functiontests"),
  /*
   * Superclass of all matlab.unittest test classes
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.testcase-class.html
   */
  MATLAB_UNITTEST_TESTCASE("matlab.unittest.testcase"),

  /*
   * Run Unit Tests
   */
  /*
   * Run set of tests
   * @see http://www.mathworks.com/matlab/matlab/ref/runtests.html
   */
  RUNTESTS("runtests"),
  /*
   * Run TestCase test
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.testcase.run.html
   */
  MATLAB_UNITTEST_TESTCASE_RUN("matlab.unittest.testcase.run"),
  /*
   * Run TestSuite array using TestRunner object configured for text output
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.testsuite.run.html
   */
  MATLAB_UNITTEST_TESTSUITE_RUN("matlab.unittest.testsuite.run"),
  /*
   * Run all tests in TestSuite array
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.testrunner.run.html
   */
  MATLAB_UNITTEST_TESTRUNNER_RUN("matlab.unittest.testrunner.run"),
  /*
   * Add plugin to TestRunner object
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.testrunner.addplugin.html
   */
  MATLAB_UNITTEST_TESTRUNNER_ADDPLUGIN("matlab.unittest.testrunner.addplugin"),
  /*
   * Class for grouping tests to run
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.testsuite-class.html
   */
  MATLAB_UNITTEST_TESTSUITE("matlab.unittest.testsuite"),
  /*
   * Specification of a single test method
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.test-class.html
   */
  MATLAB_UNITTEST_TEST("matlab.unittest.test"),
  /*
   * Class for running tests in matlab.unittest framework
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.testrunner-class.html
   */
  MATLAB_UNITTEST_TESTRUNNER("matlab.unittest.testrunner"),

  /*
   * Analyze Test Results   */
  /*
   * Result of running test suite
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.unittest.testresult-class.html
   */
  MATLAB_UNITTEST_TESTRESULT("matlab.unittest.testresult"),

  /*
   * Performance and Memory
   */
  /*
   * Code Performance
   */
  /*
   * MATLAB benchmark
   * @see http://www.mathworks.com/matlab/matlab/ref/bench.html
   */
  BENCH("bench"),
  /*
   * Elapsed CPU time
   * @see http://www.mathworks.com/matlab/matlab/ref/cputime.html
   */
  CPUTIME("cputime"),
  /*
   * Display memory information
   * @see http://www.mathworks.com/matlab/matlab/ref/memory.html
   */
  MEMORY("memory"),
  /*
   * Profile execution time for function
   * @see http://www.mathworks.com/matlab/matlab/ref/profile.html
   */
  PROFILE("profile"),
  /*
   * Save profile report in HTML format
   * @see http://www.mathworks.com/matlab/matlab/ref/profsave.html
   */
  PROFSAVE("profsave"),
  /*
   * Start stopwatch timer
   * @see http://www.mathworks.com/matlab/matlab/ref/tic.html
   */
  TIC("tic"),
  /*
   * Measure time required to run function
   * @see http://www.mathworks.com/matlab/matlab/ref/timeit.html
   */
  TIMEIT("timeit"),
  /*
   * Read elapsed time from stopwatch
   * @see http://www.mathworks.com/matlab/matlab/ref/toc.html
   */
  TOC("toc"),

  /*
   * Memory Usage
   */
  /*
   * Remove items from workspace, freeing up system memory
   * @see http://www.mathworks.com/matlab/matlab/ref/clear.html
   */
//  CLEAR("clear"),
  /*
   * Names of functions, MEX-files, classes in memory
   * @see http://www.mathworks.com/matlab/matlab/ref/inmem.html
   */
//  INMEM("inmem"),
  /*
   * Display memory information
   * @see http://www.mathworks.com/matlab/matlab/ref/memory.html
   */
//  MEMORY("memory"),
  /*
   * Consolidate workspace memory
   * @see http://www.mathworks.com/matlab/matlab/ref/pack.html
   */
  PACK("pack"),
  /*
   * List variables in workspace, with sizes and types
   * @see http://www.mathworks.com/matlab/matlab/ref/whos.html
   */
//  WHOS("whos"),

  /*
   * MATLAB Environment Control
   */
  /*
   * Open Command History window, or select it if already open
   * @see http://www.mathworks.com/matlab/matlab/ref/commandhistory.html
   */
  COMMANDHISTORY("commandhistory"),
  /*
   * Open Command Window, or select it if already open
   * @see http://www.mathworks.com/matlab/matlab/ref/commandwindow.html
   */
  COMMANDWINDOW("commandwindow"),
  /*
   * Open Current Folder browser, or select it if already open
   * @see http://www.mathworks.com/matlab/matlab/ref/filebrowser.html
   */
  FILEBROWSER("filebrowser"),
  /*
   * Open Workspace browser to manage workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/workspace.html
   */
  WORKSPACE("workspace"),
  /*
   * Preference
   * @see http://www.mathworks.com/matlab/matlab/ref/getpref.html
   */
  GETPREF("getpref"),
  /*
   * Set preference
   * @see http://www.mathworks.com/matlab/matlab/ref/setpref.html
   */
  SETPREF("setpref"),
  /*
   * Add preference
   * @see http://www.mathworks.com/matlab/matlab/ref/addpref.html
   */
  ADDPREF("addpref"),
  /*
   * Remove preference
   * @see http://www.mathworks.com/matlab/matlab/ref/rmpref.html
   */
  RMPREF("rmpref"),
  /*
   * Test for existence of preference
   * @see http://www.mathworks.com/matlab/matlab/ref/ispref.html
   */
  ISPREF("ispref"),
  /*
   * Save workspace variables to MATLAB script
   * @see http://www.mathworks.com/matlab/matlab/ref/matlab.io.savevariablestoscript.html
   */
  MATLAB_IO_SAVEVARIABLESTOSCRIPT("matlab.io.savevariablestoscript"),

  /*
   * Custom Documentation
   */
  /*
   * Build searchable documentation database
   * @see http://www.mathworks.com/matlab/matlab/ref/builddocsearchdb.html
   */
  BUILDDOCSEARCHDB("builddocsearchdb"),

  /*
   * MATLAB API for Other Languages
   */
  /*
   * MATLAB Engine API
   */
  /*
   * Build MEX-function from C/C++ or Fortran source code
   * @see http://www.mathworks.com/matlab/matlab/ref/mex.html
   */
  MEX("mex"),

  /*
   * MATLAB COM Automation Server
   */
  /*
   * Execute MATLAB command in Automation server
   * @see http://www.mathworks.com/matlab/matlab/ref/execute.html
   */
  EXECUTE("execute"),
  /*
   * Evaluate MATLAB function in Automation server
   * @see http://www.mathworks.com/matlab/matlab/ref/com.feval.html
   */
//  FEVAL("feval"),
  /*
   * Character array from Automation server
   * @see http://www.mathworks.com/matlab/matlab/ref/getchararray.html
   */
  GETCHARARRAY("getchararray"),
  /*
   * Store character array in Automation server
   * @see http://www.mathworks.com/matlab/matlab/ref/putchararray.html
   */
  PUTCHARARRAY("putchararray"),
  /*
   * Matrix from Automation server workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/getfullmatrix.html
   */
  GETFULLMATRIX("getfullmatrix"),
  /*
   * Matrix in Automation server workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/putfullmatrix.html
   */
  PUTFULLMATRIX("putfullmatrix"),
  /*
   * Data from variable in Automation server workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/getvariable.html
   */
  GETVARIABLE("getvariable"),
  /*
   * Data from Automation server workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/getworkspacedata.html
   */
  GETWORKSPACEDATA("getworkspacedata"),
  /*
   * Data in Automation server workspace
   * @see http://www.mathworks.com/matlab/matlab/ref/putworkspacedata.html
   */
  PUTWORKSPACEDATA("putworkspacedata"),
  /*
   * Open Automation server window
   * @see http://www.mathworks.com/matlab/matlab/ref/maximizecommandwindow.html
   */
  MAXIMIZECOMMANDWINDOW("maximizecommandwindow"),
  /*
   * Minimize size of Automation server window
   * @see http://www.mathworks.com/matlab/matlab/ref/minimizecommandwindow.html
   */
  MINIMIZECOMMANDWINDOW("minimizecommandwindow"),
  /*
   * Handle to running instance of Automation server
   * @see http://www.mathworks.com/matlab/matlab/ref/actxgetrunningserver.html
   */
  ACTXGETRUNNINGSERVER("actxgetrunningserver"),
  /*
   * Enable, disable, or report status of MATLAB Automation server
   * @see http://www.mathworks.com/matlab/matlab/ref/enableservice.html
   */
  ENABLESERVICE("enableservice"),
  /*
   * Terminate MATLAB Automation server
   * @see http://www.mathworks.com/matlab/matlab/ref/com.quit.html
   */
  QUIT("quit"),

  /*
   * MEX-File Creation API
   */
  /*
   * Executable C/C++ MEX-Files
   */
  /*
   * Build MEX-function from C/C++ or Fortran source code
   * @see http://www.mathworks.com/matlab/matlab/ref/mex.html
   */
//  MEX("mex"),
  /*
   * Enable MEX-file debugging (on UNIX platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/dbmex.html
   */
//  DBMEX("dbmex"),
  /*
   * Get compiler configuration information for building MEX-files
   * @see http://www.mathworks.com/matlab/matlab/ref/mex.getcompilerconfigurations.html
   */
  MEX_GETCOMPILERCONFIGURATIONS("mex.getcompilerconfigurations"),

  /*
   * Call MEX-File Functions
   */
  /*
   * Binary MEX-file-name extension
   * @see http://www.mathworks.com/matlab/matlab/ref/mexext.html
   */
//  MEXEXT("mexext"),
  /*
   * Names of functions, MEX-files, classes in memory
   * @see http://www.mathworks.com/matlab/matlab/ref/inmem.html
   */
//  INMEM("inmem"),

  /*
   * Share MEX-Files
   */
  /*
   * Version information for MathWorks products
   * @see http://www.mathworks.com/matlab/matlab/ref/ver.html
   */
//  VER("ver"),
  /*
   * Information about computer on which MATLAB software is running
   * @see http://www.mathworks.com/matlab/matlab/ref/computer.html
   */
//  COMPUTER("computer"),
  /*
   * Get compiler configuration information for building MEX-files
   * @see http://www.mathworks.com/matlab/matlab/ref/mex.getcompilerconfigurations.html
   */
//  MEX_GETCOMPILERCONFIGURATIONS("mex.getcompilerconfigurations"),
  /*
   * Binary MEX-file-name extension
   * @see http://www.mathworks.com/matlab/matlab/ref/mexext.html
   */
//  MEXEXT("mexext"),

  /*
   * Troubleshoot MEX-Files
   */
  /*
   * Enable MEX-file debugging (on UNIX platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/dbmex.html
   */
  DBMEX("dbmex"),
  /*
   * Names of functions, MEX-files, classes in memory
   * @see http://www.mathworks.com/matlab/matlab/ref/inmem.html
   */
//  INMEM("inmem"),
  /*
   * Build MEX-function from C/C++ or Fortran source code
   * @see http://www.mathworks.com/matlab/matlab/ref/mex.html
   */
//  MEX("mex"),
  /*
   * Get compiler configuration information for building MEX-files
   * @see http://www.mathworks.com/matlab/matlab/ref/mex.getcompilerconfigurations.html
   */
//  MEX_GETCOMPILERCONFIGURATIONS("mex.getcompilerconfigurations"),
  /*
   * Binary MEX-file-name extension
   * @see http://www.mathworks.com/matlab/matlab/ref/mexext.html
   */
//  MEXEXT("mexext"),

  /*
   * Source Control Integration
   */
  /*
   * Check files into source control system (UNIX platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/checkin.html
   */
  CHECKIN("checkin"),
  /*
   * Check files out of source control system (UNIX platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/checkout.html
   */
  CHECKOUT("checkout"),
  /*
   * Name of source control system
   * @see http://www.mathworks.com/matlab/matlab/ref/cmopts.html
   */
  CMOPTS("cmopts"),
  /*
   * Allow custom source control system (UNIX platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/customverctrl.html
   */
  CUSTOMVERCTRL("customverctrl"),
  /*
   * Undo previous checkout from source control system (UNIX platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/undocheckout.html
   */
  UNDOCHECKOUT("undocheckout"),
  /*
   * Source control actions (Windows platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/verctrl.html
   */
  VERCTRL("verctrl"),

  /*
   * Desktop Environment
   */
  /*
   * Startup and Shutdown   */
  /*
   * Start MATLAB program (Windows platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/matlabwindows.html
   */
  MATLAB_WINDOWS("matlab (windows)"),
  /*
   * Start MATLAB program (UNIX platforms)
   * @see http://www.mathworks.com/matlab/matlab/ref/matlabunix.html
   */
  MATLAB_UNIX("matlab (unix)"),
  /*
   * Terminate MATLAB program (same as quit)
   * @see http://www.mathworks.com/matlab/matlab/ref/exit.html
   */
  EXIT("exit"),
  /*
   * Terminate MATLAB program
   * @see http://www.mathworks.com/matlab/matlab/ref/quit.html
   */
//  QUIT("quit"),
  /*
   * Startup file for MATLAB program
   * @see http://www.mathworks.com/matlab/matlab/ref/matlabrc.html
   */
  MATLABRC("matlabrc"),
  /*
   * Startup file for user-defined options
   * @see http://www.mathworks.com/matlab/matlab/ref/startup.html
   */
  STARTUP("startup"),
  /*
   * Termination file for MATLAB program
   * @see http://www.mathworks.com/matlab/matlab/ref/finish.html
   */
  FINISH("finish"),

  /*
   * Basic Settings
   */
  /*
   * Folder containing preferences, history, and layout files
   * @see http://www.mathworks.com/matlab/matlab/ref/prefdir.html
   */
  PREFDIR("prefdir"),
  /*
   * Open Preferences dialog box
   * @see http://www.mathworks.com/matlab/matlab/ref/preferences.html
   */
  PREFERENCES("preferences"),

  /*
   * Platform and License
   */
  /*
   * Determine if version is for Mac OS X platform
   * @see http://www.mathworks.com/matlab/matlab/ref/ismac.html
   */
  ISMAC("ismac"),
  /*
   * Determine if version is for Windows (PC) platform
   * @see http://www.mathworks.com/matlab/matlab/ref/ispc.html
   */
  ISPC("ispc"),
  /*
   * Determine if version is Student Version
   * @see http://www.mathworks.com/matlab/matlab/ref/isstudent.html
   */
  ISSTUDENT("isstudent"),
  /*
   * Determine if version is for UNIX platform
   * @see http://www.mathworks.com/matlab/matlab/ref/isunix.html
   */
  ISUNIX("isunix"),
  /*
   * Error message based on Java feature support
   * @see http://www.mathworks.com/matlab/matlab/ref/javachk.html
   */
//  JAVACHK("javachk"),
  /*
   * Return license number or perform licensing task
   * @see http://www.mathworks.com/matlab/matlab/ref/license.html
   */
  LICENSE("license"),
  /*
   * Determine if Java feature is available
   * @see http://www.mathworks.com/matlab/matlab/ref/usejava.html
   */
//  USEJAVA("usejava"),
  /*
   * Version information for MathWorks products
   * @see http://www.mathworks.com/matlab/matlab/ref/ver.html
   */
  VER("ver"),
  /*
   * Compare toolbox version to specified version string
   * @see http://www.mathworks.com/matlab/matlab/ref/verlessthan.html
   */
  VERLESSTHAN("verlessthan"),
  /*
   * Version number for MATLAB and libraries
   * @see http://www.mathworks.com/matlab/matlab/ref/version.html
   */
  VERSION("version"),

  /*
   * Help and Support
   */
  /*
   * Reference page in Help browserSearch for term in documentation
   * @see http://www.mathworks.com/matlab/matlab/ref/doc.html
   */
  DOC("doc"),
  /*
   * Help for functions in Command Window
   * @see http://www.mathworks.com/matlab/matlab/ref/help.html
   */
  HELP("help"),
  /*
   * Help browser search
   * @see http://www.mathworks.com/matlab/matlab/ref/docsearch.html
   */
  DOCSEARCH("docsearch"),
  /*
   * Search for keyword in all help entries
   * @see http://www.mathworks.com/matlab/matlab/ref/lookfor.html
   */
  LOOKFOR("lookfor"),
  /*
   * Access product examples in Help browser
   * @see http://www.mathworks.com/matlab/matlab/ref/demo.html
   */
  DEMO("demo"),
  /*
   * Run example script step-by-step in Command Window
   * @see http://www.mathworks.com/matlab/matlab/ref/echodemo.html
   */
  ECHODEMO("echodemo");

  private final String value;

  private MatlabKeyword(String value) {
    this.value = value;
  }

  public String getName() {
    return name();
  }

  public String getValue() {
    return value;
  }

  public boolean hasToBeSkippedFromAst(AstNode node) {
    return false;
  }

  public static String[] keywordValues() {
    MatlabKeyword[] keywordsEnum = MatlabKeyword.values();
    String[] keywords = new String[keywordsEnum.length];
    for (int i = 0; i < keywords.length; i++) {
      keywords[i] = keywordsEnum[i].getValue();
    }
    return keywords;
  }

}
