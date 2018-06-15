package string

import org.scalatest.FunSpec

class PalindromeSpec extends FunSpec {

  describe("Palindrome checker") {
    it("should return true for a proper palindrome") {
      assert(Palindrome.isPalindrome("bob"))
      assert(Palindrome.isPalindrome("boob"))
      assert(Palindrome.isPalindrome("evacanistabbatsinacave"))
    }
    it("should return false for a non-palindrome") {
      assert(!Palindrome.isPalindrome("import"))
    }
  }

}
