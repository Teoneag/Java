import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Main {
    private static List<Integer> successor(List<Integer> list) {
        List<Integer> res = new ArrayList<>(list.size());
        int carry = 1;

        for (Integer integer : list) {
            int cur = integer + carry;
            if (cur == 3) {
                res.add(0); // carry remains 1
            } else {
                res.add(cur);
                carry = 0; // carry is resolved, stop further implements
            }
        }

        return res;
    }

    private static boolean leq(List<Integer> a, List<Integer> b) {
        // the lists can have trailing 0s, so we can't just compare sizes

        int n = Math.min(a.size(), b.size()); // if they are different sizes, take the smaller one
        for (int i = n - 1; i >= 0; i--) {
            if (!Objects.equals(a.get(i), b.get(i))) { // null safe equals
                return a.get(i) < b.get(i);
            }
        }

        return true; // they are equal, so a <= b
    }

    private static List<Integer> tritwise_min(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>(a.size());
        int n = Math.min(a.size(), b.size()); // if they are different sizes, take the smaller one

        for (int i = 0; i < n; i++) res.add(Math.min(a.get(i), b.get(i)));

        // although there can be remaining elements in a or b,
        // min(x, 0) is always 0, and trailing 0s can be ignored
        return res;
    }

    private static List<Integer> f(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>(a);
        List<Integer> succ = successor(a);

        while (leq(succ, b)) {
            res = tritwise_min(res, succ);
            succ = successor(succ);
        }

        return res;
    }

    // considering always a <= b
    private static List<Integer> f_eff(List<Integer> a, List<Integer> b) {
        List<Integer> res = new ArrayList<>(a.size());

        int lastSmallerIndex = -1; // the last index where a is smaller than b
        int n = Math.min(a.size(), b.size());
        for (int i = 0; i < n; i++) {
            if (a.get(i) < b.get(i)) lastSmallerIndex = i;
        }

        // up to the last index before the last smaller index, fill with 0s
        // (as when counting, all digits will overflow, and the min will be 0)
        for (int i = 0; i < lastSmallerIndex; i++) res.add(0);

        // if a and b are equal, lastSmallerIndex will be -1, and in that case we just want to copy b
        if (lastSmallerIndex != -1) res.add(a.get(lastSmallerIndex));

        for (int i = lastSmallerIndex + 1; i < b.size(); i++) res.add(b.get(i));

        return res;
    }

    // 2,0,1; 0,1,1; 1,1,1

    public static void main(String[] args) {
//        System.out.println(successor(List.of(2, 0, 1))); // [0, 1, 1]
//        System.out.println(successor(List.of(2, 1, 0))); // [0, 2, 0]

//        System.out.println(leq(List.of(2, 0, 1), List.of(0, 1, 1))); // true
//        System.out.println(leq(List.of(2, 0, 1, 0), List.of(2, 0, 1)));
//        System.out.println(leq(List.of(0, 1, 1), List.of(2, 0, 1)));

//        System.out.println(tritwise_min(List.of(1, 0, 2), List.of(1, 1, 1)));
//        System.out.println(tritwise_min(List.of(2, 1), List.of(0, 2, 1)));

//        System.out.println(f(List.of(2, 0, 1), List.of(1, 1, 1)));
        System.out.println(f_eff(List.of(2, 0, 1), List.of(1, 1, 1))); // [0, 0, 1]
        System.out.println(f_eff(List.of(0, 1, 2), List.of(0, 1, 2))); // [0, 1, 2]
        System.out.println(f_eff(List.of(0, 0, 0), List.of(1))); // [0]
        System.out.println(f_eff(List.of(1, 0, 0), List.of(1))); // [1]
        System.out.println(f_eff(List.of(1, 1, 0), List.of(0, 0, 1))); // [0, 0, 0]

    }
}