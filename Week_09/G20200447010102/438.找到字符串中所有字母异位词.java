/*
 * @lc app=leetcode.cn id=438 lang=java
 *
 * [438] 找到字符串中所有字母异位词
 */

// @lc code=start
class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] freq = new int[256];
        for (int i = 0; i < p.length(); i++) freq[p.charAt(i)]++;

        List<Integer> ret = new ArrayList<>();
        int diff = p.length();
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (freq[s.charAt(i)]-- > 0) diff--;
            while (diff == 0) {
                if (i - j + 1 == p.length()) { // Here is the key!
                    ret.add(j);
                }
                if (++freq[s.charAt(j++)] > 0) diff++;
            }
        }
        return ret;
    }
}
// @lc code=end

