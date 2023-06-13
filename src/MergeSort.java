public class MergeSort {
    int number = 8;
    int[] sorted = new int[8];

    void mergeSort(int a[], int m, int middle, int n) {
        int i = m;
        int j = middle + 1;
        int k = m;
        // 작은 순서대로 배열에 삽입
        while (i <= middle && j <= n) {
            if (a[i] <= a[j]) {
                sorted[k] = a[i];
            } else {
                sorted[k] = a[j];
            }
            k++;
        }

        // 남은 데이터도 삽입
        if (i > middle) {
            for (int t = j; t <= n; t++) {
                sorted[k] = a[t];
                k++;
            }
        } else {
            for (int t = i; t <= middle; t++) {
                sorted[k] = a[t];
                k++;
            }
        }

        // 정렬된 배열을 삽입
        for (int t = m; t <= n; t++) {
            a[t] = sorted[t];
        }
    }

    void mergeSort(int a[], int m, int n) {
        // 크기가 1보다 큰 경우
        if (m < n) {
            int middle = (m + n) / 2;
            mergeSort(a, m, middle);
            mergeSort(a, middle + 1, n);
            mergeSort(a, m, middle, n);
        }
    }
}
