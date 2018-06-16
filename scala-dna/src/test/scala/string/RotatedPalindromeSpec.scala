package string

import org.scalatest.FunSpec

class RotatedPalindromeSpec extends FunSpec {

  describe("Rotated palindrome") {
    it("should fail on a non-palindrome") {
      assert(!RotatedPalindrome.isRotated("bat"))
    }
    it("should discover a rotated palindrome") {
      assert(RotatedPalindrome.isRotated("abcdedcba"))
    }
  }

}
