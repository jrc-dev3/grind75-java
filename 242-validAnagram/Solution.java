import java.util.HashMap;

class Solution {
  public boolean isAnagram(String s, String t) {

    HashMap<String, Integer> smp = new HashMap<String, Integer>();
    for (String c : s.split("")) {
      if (!smp.containsKey(c)) {
        smp.put(c, 0);
      }

      smp.put(c, smp.get(c) + 1);
    }

    HashMap<String, Integer> tmp = new HashMap<String, Integer>();
    for (String c : t.split("")) {
      if (!tmp.containsKey(c)) {
        tmp.put(c, 0);
      }

      tmp.put(c, tmp.get(c) + 1);
    }

    if (smp.size() != tmp.size())
      return false;

    for (String mpkey : smp.keySet()) {
      if (!tmp.containsKey(mpkey))
        return false;
      if (!smp.get(mpkey).equals(tmp.get(mpkey)))
        return false;
    }

    return true;

  }

  public static void main(String[] args) {

    Solution sol = new Solution();
    boolean ans = sol.isAnagram("rat", "cat");
    System.out.println(ans);
  }
}
