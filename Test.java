[-2, 1, 0, 3, 5, -1, 6]
 -2  -1 -1,2, 5, -1, 5
-2
-1
[-2,1,0]
[1,0,3]

public int findMinimum(int[] array) {
    int min = array[0];
    int[] helper = new int[array.length];
    helper[0] = array[0];
    for (int i = 1; i < helper.length; i++) {
        if (helper[i - 1] < 0) {
            helper[i] = helper[i - 1] + array[i];
        } else {
            helper[i] = array[i];
        }
        min = Math.min(min, helper[i]);
    }
    return min;
}

public int findMinimum2(int[] array) throws Exception {
    if (array == null || array.length == 0) {
        throw new Exception(System.out.println("Invalid input."));
    }
    int min = array[0];
    int prevMin = array[0];
    for (int i = 1; i < array.length; i++) {
        if (prevMin < 0) {
            prevMin = pervMin + array[i];
        } else {
            prevMin = array[i];
        }
        min = Math.min(min, prevMin);
    }
    return min;
}
[-2, 1, 0, 3, 5, -1, 6]

min: -2
prevMin:5
