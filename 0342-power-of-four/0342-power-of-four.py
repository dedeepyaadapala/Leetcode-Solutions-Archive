class Solution(object):
    def isPowerOfFour(self, n):
        """
        :type n: int
        :rtype: bool
        """
        for i in range(16):
            if n == pow(4,i):
                return True
            else:
                if n > pow(4,i) and n < pow(4,i+1):
                    return False