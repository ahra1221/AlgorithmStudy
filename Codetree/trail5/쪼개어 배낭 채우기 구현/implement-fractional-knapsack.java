import java.util.*;

public class Main {

    static class Jewel {
        int weight;
        int value;
        double ratio;

        Jewel(int weight, int value, double ratio) {
            this.weight = weight;
            this.value = value;
            this.ratio = ratio;
        }
    }

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int N = sc.nextInt();
        int M  = sc.nextInt();
        Jewel[] jewel = new Jewel[N];

        for(int i=0;i<N;i++) {
           int w = sc.nextInt();
           int v = sc.nextInt();
           jewel[i] = new Jewel(w, v, (double)v / w);
        }

        Arrays.sort(jewel, (a, b) -> Double.compare(b.ratio, a.ratio));

        int bag = 0;
        int idx = 0;
        double value = 0.0;
        while(bag < M && idx < N) {
            int left = M - bag;
            if(jewel[idx].weight <= left) {
                bag += jewel[idx].weight;
                value += jewel[idx].value;
                idx++;
            } else {
                value += jewel[idx].ratio * left;
                break;
            }
        }
        System.out.printf("%.3f", value);
    }
}