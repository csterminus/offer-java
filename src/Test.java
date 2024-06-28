import java.util.*;

/**
 * @author chengshi
 * @date 2024/6/22 13:40
 */
public class Test {
    public static void main(String[] args) {
        Test test = new Test();
        test.solution();
    }

//    public void sulotion() {
//        Scanner scanner = new Scanner(System.in);
//        String sou = scanner.nextLine();
//        int n = Integer.parseInt(sou);
//        int max = Integer.MAX_VALUE;
//        List<Integer> res = new ArrayList<>();
//        for (int m = 1; m * (m + 1) / 2 <= n; m++) {
//            List<Integer> list = new ArrayList<>();
//            double a = (double) n / m - (double) (m - 1) / 2;
//            if (a == (int) a && a > 0) {
//                int temp = (int) a;
//                for (int i = 0; i < m; i++) {
//                    list.add(temp + i);
//                }
//                if (list.size() < max && list.size() > 1) {
//                    res = new ArrayList<>(list);
//                    max = list.size();
//                }
//            }
//        }
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(n);
//        if (res.size() > 0) {
//            stringBuilder.append("=");
//            for (Integer count : res) {
//                stringBuilder.append(count).append("+");
//            }
//            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
//        }
//        System.out.println(stringBuilder.toString());
//
//    }

    public void solution2() {
        Scanner in = new Scanner(System.in);
        String s1 = in.nextLine();
        String s2 = in.nextLine();
        List<String> list1 = Arrays.asList(s1.split(" "));
        List<String> list2 = Arrays.asList(s2.split(" "));
        int m = Integer.parseInt(list1.get(0));
        int n = Integer.parseInt(list1.get(1));
        int[][] nums = new int[m][n];
        int temp = (list1.size() - 2) / 2;
        int count1 = 0;
        int sum1 = 0;
        int[] count = new int[temp];
        int[] sum = new int[temp];
        for (int i = 2; i < list1.size(); i++) {
            if (i % 2 == 0) {
                count[count1++] = Integer.parseInt(list1.get(i));
            } else {
                sum[sum1++] = Integer.parseInt(list1.get(i));
            }
        }
        int xx = Integer.parseInt(list2.get(0));
        int yy = Integer.parseInt(list2.get(1));
        int sum2 = xx * n + yy;
        int sum3 = 0;
        int sum4 = 0;
        for (int i = 0; i < temp; i++) {
            sum3 = sum4;
            sum4 = sum4 + sum[i];
            if (sum2 >= sum3 && sum2 < sum4) {
                System.out.println(count[i]);
                break;
            }

        }

    }

    public void solution() {
        Scanner in = new Scanner(System.in);
        String s1 = in.next();
        List<String> list1 = Arrays.asList(s1.split(" "));
        String str = list1.get(0);
        int length = Integer.valueOf(list1.get(1));
        int m = str.length();
        if (m == 0 || length == 0) {
            System.out.println(0);
        }
        Set<Character> characteCount = new HashSet<>();
        for (int i = 0; i < m; i++) {
            characteCount.add(str.charAt(i));
        }
        int result = 1;
        int len = characteCount.size();
        for (int i = 0; i < length; i++) {
            result = result * len;
            len--;
        }
        System.out.println(result);
    }
}