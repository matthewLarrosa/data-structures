package com.company;

public class Main {

    public void radixSort(int[] arr, int num){

        int maxNum = arr[0];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] % 2 != 0){
                System.out.println("*** Abort *** the input has at least one key with odd digits  ");
                break;
            }
            if(maxNum < arr[i]) {
                maxNum = arr[i];
            }
        }

        int arrLength = arr.length;

        for(int j = 1; maxNum > j; j *= 10){
            countingSort(arr, j, arrLength);
        }

    }

    public void countingSort(int[] arr, int digit, int length){
        int[] arrTemp = new int[length];

        for(int i = 0; i < arr.length; i++){
            if(arr[i] / digit % 10 == digit){

            }
        }



    }

    public static void main(String[] args) {

    }
}
