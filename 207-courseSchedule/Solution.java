import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {

    Map<Integer, Set<Integer>> courseMap = new HashMap<>();
    Map<Integer, Boolean> memo = new HashMap<>();

    private boolean dfs(Set<Integer> courses, int prereq) {
        if(memo.containsKey(prereq)) return memo.get(prereq);
        Set<Integer> prereqs = courseMap.get(prereq);

        if (prereqs.isEmpty())
            return true;
        if (courses.contains(prereq))
            return false;

        courses.add(prereq);

        for (int pq : prereqs) {

            boolean res = dfs(new HashSet<Integer>(courses), pq);
            memo.put(pq, res);

            if (!res)
                return res;

        }

        return true;

    }

    public boolean canFinish(int numCourses, int[][] prerequisites) {

        for (int i = 0; i < numCourses; i++) {
            courseMap.put(i, new HashSet<>());
        }

        for (int[] prereq : prerequisites) {
            courseMap.get(prereq[0]).add(prereq[1]);
        }


        for (int course : courseMap.keySet()) {
            Set<Integer> prereqs = courseMap.get(course);

            for (int prereq : prereqs) {

                Set<Integer> coursesSoFar = new HashSet<>() {
                    {
                        add(course);
                    }
                };

                boolean res = dfs(coursesSoFar, prereq);
                if (!res)
                    return res;

            }

        }

        return true;

    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        boolean ans = sol.canFinish(7, new int[][] {
                new int[] { 1, 0 },
                new int[] { 0, 3 },
                new int[] { 0, 2 },
                new int[] { 3, 2 },
                new int[] { 2, 5 },
                new int[] { 4, 5 },
                new int[] { 5, 6 },
                new int[] { 2, 4 }
        });

        System.out.println(ans);
    }

}