# AI-generated study solution; review before use.
class Solution:
    def addDigits(self, num: int) -> int:
        """
        Compute the repeated sum of digits until a single digit remains.
        This is the digital root of the number.
        """
        if num == 0:
            return 0
        # Digital root formula: 1 + (num - 1) % 9
        return 1 + (num - 1) % 9
