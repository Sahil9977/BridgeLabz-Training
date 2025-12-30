// Q5_CircularTour.java
// Circular Tour Problem using Queue
package Collection;

public class CircularTour {
    static class PetrolPump {
        int petrol, distance;
        PetrolPump(int p, int d) { petrol = p; distance = d; }
    }

    public static int circularTour(PetrolPump[] pumps) {
        int n = pumps.length;
        int start = 0, end = 1;
        int curr_petrol = pumps[start].petrol - pumps[start].distance;
        while (start != end || curr_petrol < 0) {
            while (curr_petrol < 0 && start != end) {
                curr_petrol -= pumps[start].petrol - pumps[start].distance;
                start = (start + 1) % n;
                if (start == 0) return -1;
            }
            curr_petrol += pumps[end].petrol - pumps[end].distance;
            end = (end + 1) % n;
        }
        return start;
    }

    public static void main(String[] args) {
        PetrolPump[] pumps = {
            new PetrolPump(4, 6),
            new PetrolPump(6, 5),
            new PetrolPump(7, 3),
            new PetrolPump(4, 5)
        };
        int start = circularTour(pumps);
        System.out.println(start); // Output: 1
    }
}
