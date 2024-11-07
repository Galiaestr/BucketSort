import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BucketSort {
    public static void bucketSort(int[] array, int bucketSize) {
        int maxVal = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > maxVal) {
                maxVal = array[i];
            }
        }

        // Crea los buckets
        List<List<Integer>> buckets = new ArrayList<>();
        for (int i = 0; i <= maxVal / bucketSize; i++) {
            buckets.add(new ArrayList<>());
        }

        // Distribuir los elementos en los buckets
        for (int i = 0; i < array.length; i++) {
            int bucketIndex = array[i] / bucketSize;
            buckets.get(bucketIndex).add(array[i]);
        }

        // Ordenar cada bucket 
        for (List<Integer> bucket : buckets) {
           
            bucket.sort(null);
        }

        // Combinar los buckets en el array original
        int index = 0;
        for (List<Integer> bucket : buckets) {
            for (int value : bucket) {
                array[index++] = value;
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Ingrese el tamaño del array: ");
        int n = scanner.nextInt();

        int[] array = new int[n];
        System.out.println("Ingrese los elementos del array:");
        for (int i = 0; i < n; i++) {
            array[i] = scanner.nextInt();
        }

        System.out.print("Ingrese el tamaño del bucket: ");
        int bucketSize = scanner.nextInt();

        bucketSort(array, bucketSize);

        System.out.println("Array ordenado:");
        for (int i = 0; i < n; i++) {
            System.out.print(array[i] + " ");
        }
    }
}