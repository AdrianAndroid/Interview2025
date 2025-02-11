package LeetCode.贪心算法;

import java.util.Arrays;

public class 分发饼干 {

    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;
        int i = 0, j = 0;

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                contentChildren++;
                i++;
            }
            j++;
        }

        return contentChildren;
    }

}
