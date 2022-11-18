package com.company;

import java.util.Arrays;

class Main {

    /***************************************************************************
      Purpose/Description: Problem 1 Radix Sort
      Author's Panther ID: 6293021
      Certification: Matthew Larrosa
        I hereby certify that this work is my own and none of it is the work of
        any other person.
     ***************************************************************************/

    boolean oddArray = false;

    // Function to get the largest element from an array
    public int maxNumber(int array[], int arrLength) {

        // Assigns the first index of array to max
        int max = array[0];

        // Iterates through the array, check if current index is greater than max. If so, assign current index to max
        for (int i = 1; i < arrLength; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    public void countingSort(int arr[], int digit, int length) {

        int maxNum = arr[0];
        int[] arrTest = new int[length + 1];

        // Checks if maxNum is less than arr if so assigns a new max number
        for (int i = 1; i < length; i++) {
            if (maxNum < arr[i])
                maxNum = arr[i];
        }

        int[] arrCnt = new int[maxNum + 1];

        // Fills the counting array with zeros up to the max element
        for (int i = 0; i < maxNum; ++i){ // <--- *Important* Increments before
            arrCnt[i] = 0;
        }

        // Increment the index of the current digit
        for (int i = 0; i < length; i++) {
            arrCnt[(arr[i] / digit) % 10]++;
        }

        // Adds all the indexes of digits 0-9 in the counting array
        for (int i = 1; i < 10; i++){
            arrCnt[i] += arrCnt[i - 1];
        }

        // Reverse iterates through the array assign element to the test array
        for (int i = length - 1; i >= 0; i--) {
            arrTest[arrCnt[(arr[i] / digit) % 10] - 1] = arr[i];

            // Decrements the index in the counting array that correlates to the current digit in the index of arr
            arrCnt[(arr[i] / digit) % 10]--;
        }

        // Assigns the manipulated elements in the test array to the main array
        for (int i = 0; i < length; i++){
            arr[i] = arrTest[i];
        }
    }

    public void radixSort(int array[]) {

        // Assigns the length of the array to int arrLength
        int arrLength = array.length;

        // Calls maxNumber method to get the largest number in the array
        int maxNum = maxNumber(array, arrLength);

        boolean foundOdd = false;

        for(int i = 0; i < arrLength; i++){
            if(array[i] % 2 != 0) {
                foundOdd = true;
                this.oddArray = true;
            }
        }

        if(foundOdd == true){
            System.out.println("*** Abort *** the input has at least one key with odd digits");
        }
        else{
            // Iterates through each element, calling counting sort in relation to the current digit
            for (int digit = 1; maxNum / digit > 0; digit *= 10) {
                countingSort(array, digit, arrLength);
            }
        }
    }

    public static void main(String args[]) {

        int[] testArray = {88, 12, 248, 2, 16, 8, 924};
        // Prints array before radix sort
        System.out.println("Before: " + Arrays.toString(testArray));

        Main obj = new Main();
        obj.radixSort(testArray);

        // Prints array after radix sort
        if(obj.oddArray == false){
            System.out.println("After: " + Arrays.toString(testArray));
        }

        //**********************************************************

        System.out.println(" ");
        System.out.println("Second Test, checks for Odds");
        System.out.println(" ");

        int[] testOddArray = {88, 12, 248, 1, 16, 8, 924};

        System.out.println("Before: " + Arrays.toString(testOddArray));

        obj.radixSort(testOddArray);

        if(obj.oddArray == false){
            System.out.println("After: " + Arrays.toString(testOddArray));
        }

    }
}