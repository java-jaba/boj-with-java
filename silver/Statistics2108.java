import java.util.*;
// 2108. 통계학
public class Statistics2108 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr);
        // 3. 중앙값
        int mid = arr[n/2];
        // 4. 범위
        int max = arr[n-1];
        int range = max - arr[0];

        // 1. 산술평균
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }
        double avg = sum / (double)n;

        // 2. 최빈값
        int frq = 0;
        TreeMap<Integer, Integer> map = new TreeMap<>();

        for (int i = 0; i < n; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int tmp = Integer.MIN_VALUE;
        for (int i : map.keySet()) {
            if (tmp < map.get(i)) {
                tmp = map.get(i);
            }
        }

        ArrayList<Integer> list = new ArrayList<>();
        for (int i : map.keySet()) {
            if (map.get(i) == tmp) {
                list.add(i);
            }
        }

        Collections.sort(list);
        
        // 출력
        System.out.printf(String.valueOf(Math.round(avg)));
        System.out.println();
        System.out.println(mid);
        System.out.println(list.size() == 1 ? list.get(0) : list.get(1));
        System.out.println(range);

    }
}
