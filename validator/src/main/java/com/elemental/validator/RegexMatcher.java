/*
 * Modifications Copyright (c) 2018 Razeware LLC
 *
 *  Permission is hereby granted, free of charge, to any person obtaining a copy
 *  of this software and associated documentation files (the "Software"), to deal
 *  in the Software without restriction, including without limitation the rights
 *  to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 *  copies of the Software, and to permit persons to whom the Software is
 *  furnished to do so, subject to the following conditions:
 *
 *  The above copyright notice and this permission notice shall be included in
 *  all copies or substantial portions of the Software.
 *
 *  THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 *  IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 *  FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 *  AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 *  LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 *  OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 *  THE SOFTWARE.
 */

package com.elemental.validator;

import java.util.regex.Pattern;

/**
 * The type Regex matcher.
 */
public class RegexMatcher {

  /**
   * Validate string against a regex.
   *
   * @param dataStr the data str
   * @param regex   the regex
   * @return the boolean
   */
  public boolean validate(String dataStr, String regex) {
    if (regex == null || regex.equals("")) {
      throw new IllegalArgumentException("regex field cannot is be null or empty!");
    } else {
      Pattern p = Pattern.compile(regex);
      return validate(dataStr, p);
    }
  }


  /**
   * Find in string against a regex.
   *
   * @param dataStr the data str
   * @param regex   the regex
   * @return the boolean
   */
  public boolean find(String dataStr, String regex) {
    if (regex == null || regex.equals("")) {
      throw new IllegalArgumentException("regex field cannot is be null or empty!");
    } else {
      Pattern p = Pattern.compile(regex);
      return find(dataStr, p);
    }
  }

  /**
   * Validate string against a pattern.
   *
   * @param dataStr the data str
   * @param pattern the pattern
   * @return the boolean
   */
  public boolean validate(String dataStr, Pattern pattern) {
    return !(dataStr == null || dataStr.equals("")) && pattern.matcher(dataStr).matches();
  }

  /**
   * Find in string against a pattern.
   *
   * @param dataStr the data str
   * @param pattern the pattern
   * @return the boolean
   */
  public boolean find(String dataStr, Pattern pattern) {
    return !(dataStr == null || dataStr.equals("")) && pattern.matcher(dataStr).find();
  }
}
