from math import gcd
class Solution:
    def countTriples(self, N: int) -> int:
        count = 0
        m = 2
        while m * m + 1 <= N:          # since n_ >= 1
            n_ = 1
            while n_ < m:
                c0 = m*m + n_*n_
                if c0 > N:
                    break
                if gcd(m, n_) == 1 and (m - n_) % 2 == 1:
                    count += N // c0   # all valid k for this primitive triple
                n_ += 1
            m += 1
        return count * 2