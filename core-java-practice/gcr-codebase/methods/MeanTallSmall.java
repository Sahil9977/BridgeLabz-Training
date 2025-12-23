package methods;

public class MeanTallSmall {

	public static int sum(int[] heights) {
        int total = 0;
        for (int height : heights) total += height;
        return total;
    }

    public static int findMin(int[] heights) {
        int min = heights[0];
        for (int height : heights) if (height < min) min = height;
        return min;
    }

    public static int findMax(int[] heights) {
        int max = heights[0];
        for (int height : heights) if (height > max) max = height;
        return max;
    }

    public static double findMean(int[] heights) {
        return (double) sum(heights) / heights.length;
    }

    public static void main(String[] args) {
        int[] heights = new int[11];
        for (int i = 0; i < heights.length; i++) {
            heights[i] = 150 + (int)(Math.random() * 101);
        }


        System.out.println("\nMean Height: " + findMean(heights));
        System.out.println("Shortest Height: " + findMin(heights));
        System.out.println("Tallest Height: " + findMax(heights));
    }


}


