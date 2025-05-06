class Solution:
    def canPlaceFlowers(self, flowerbed: List[int], n: int) -> bool:
        count = 0
        for i in range(len(flowerbed)):
            if i == len(flowerbed) - 1 and flowerbed[i - 1] == 0 and flowerbed[i] == 0:
                flowerbed[i] = 1
                count += 1
            elif i == 0 and flowerbed[0] == 0 and flowerbed[i+1] == 0:
                flowerbed[0] = 1
                count += 1 
            else:
                if flowerbed[i] == 0 and flowerbed[i-1] != 1 and flowerbed[i+1] != 1:
                    flowerbed[i] = 1
                    count += 1
        if count >= n: return True
        return False