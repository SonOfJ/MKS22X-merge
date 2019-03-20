public class Merge {
  public static void mergesort(int[] data) {
    int[] opti = new int[data.length]; //Trying to do the optimization right off the bat.
    for (int i = 0; i < opti.length; i = i + 1) {
      opti[i] = data[i]; //Add the elements.
    }
    mergesortH(data, 0, data.length - 1, opti);
  }
  private static void insertionSort(int[] data, int lo, int hi) {
    if (data.length != 0) {
      for(int i = lo; i < hi; i = i + 1) { //The first element is already sorted
        int value = data[i];
        int index = i; //Allows for the manipulation of the index without affecting i
        while (index != 0 && data[index - 1] > value) { //index cannot be zero and the current element is smaller
          data[index] = data[index - 1]; //Shifting
          index = index - 1; //Continue the loop towards the left
        }
        data[index] = value; //Place the element at i at the location of the index
      }
    }
  }
  private static void mergesortH(int[] data, int lo, int hi, int[] opti) {
    if (hi - lo < 50) {
      insertionSort(data, lo, hi);
      return;
    }
    int middle = (hi - lo) / 2 + lo; //Index for the middle of the range.
    mergesortH(opti, lo, middle, data); //Create the tree first.
    mergesortH(opti, middle + 1, hi, data);
    int lt = lo; //Start of first half.
    int lt2 = middle + 1; //Start of second half.
    int i = lo; //Index for the original array.
    while (lt <= middle && lt2 <= hi) { //Everything still within bounds, add the smaller value first.
      if (opti[lt] < opti[lt2]) { //If the value on the left side is smaller.
        data[i] = opti[lt]; //Add it to the original array.
        lt = lt + 1; //Only the left side moves forward.
      } else { //If the value on the right side is smaller.
        data[i] = opti[lt2]; //Add it to the original array.
        lt2 = lt2 + 1; //Only the right side moves forward.
      }
      i = i + 1; //Index of the original array moves forward regardless of which element was added.
    }
    while (lt <= middle) { //Still stuff left on the left side?
      data[i] = opti[lt];
      lt = lt + 1;
      i = i + 1;
    }
    while (lt2 <= hi) { //Still stuff left on the right side?
      data[i] = opti[lt2];
      lt2 = lt2 + 1;
      i = i + 1;
    }
  }
}
