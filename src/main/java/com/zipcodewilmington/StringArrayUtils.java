package com.zipcodewilmington;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by leon on 1/29/18.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length -1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length -2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        for (String doesContain:array) { // created new string called doesContain to look through the already declared array
            if (doesContain.equals(value)) { // if the array contains 'value'
                return true;
            }
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
//       String[] revStr= new String[array.length];   // created a new string that will look through the length of the already declared array
//        int j=0;    // new values will be stored in here
//        for (int i= array.length-1; i >=0 ; i--){ // for loop to reverse the value of the given array
//            revStr[j]=array[i]; // setting the values = to the new int and storing them in the created array
//            j++; // increment for the new array
//        }
//        return revStr; // returning new array of reversed values
        Collections.reverse(Arrays.asList(array));
        return array;
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        String [] copyArray = Arrays.copyOf(array,array.length);
        Collections.reverse (Arrays.asList(copyArray));
        return Arrays.equals(array,copyArray);
        // created a new string array and used a method Arrays.copyof to create a copy of the same array with the same elements and length as the original
        //used the collections.reverse method to reverse the array and Arrays.aslist converts the method to a list
        // Arrays.equals method compares the 2 string arrays and of they are equal it returns a string

    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        boolean [] alphabet= new boolean [26]; // created a new boolean to keep track of all the letters the alphabet

        for (String str : array) { // new string to iterate through all the strings in the array
            for (char letter : str.toCharArray()){ // new character letter loops through each letter/character in the array
                letter= Character.toLowerCase(letter); // if the character is a letter it will change it to lower case

                if (Character.isLetter(letter)){  //checks if the character is a letter and if it is its marked as used in the array
                    alphabet[letter - 'a']=true; // returning true
                }
            }
        }
        for (boolean used : alphabet ){ // new boolean to check is all the letters have been used in the boolean alphabet
            if (!used){ // if it's not used its told to return false
                return false;
            }
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0; // iny to count the number of occurrences

        for (String used :array){ //new string loops through every input into the array
            if (used.equals(value)){ // if the value currently is equal to the value given
                count++; // add to the count
            }
        }
        return count;
    }

    /**

     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
       int count = 0; //
       for (String str : array){ // new string to look through the array
           if (!str.equals(valueToRemove)){ // if the value found by the new string is equal to the value to be removed
               count++; // add to the count
           }
       }
       String [] answer =new String[count]; //created a new array with the same length as the count

        int newStr =0;
        for ( String str : array){
            if (!str.equals(valueToRemove)){
                answer [newStr++]= str; // copies the values from the array given without the value to remove
            }
        }
        return answer;
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        if (array == null || array.length==0){
            return new String[0];
            //checks whether the inout array is empty or null
            // and if it is it retruns and empty array
        }
        ArrayList<String> result = new ArrayList<String>();
        // empty array will hold the the not copied elements in a array list
        result.add(array[0]);
        // first element in input array is added to the array list using .add method

        for (int i=1;i< array.length;i++){ // iterates through loop starting at second element
                                            // and compares each element to the previous one
            if (!array[i].equals(array[i-1])){ // if current element is not equal to the previous one
                result.add(array[i]);// its added to the result array list using the .add method
            }
        }
        return result.toArray(new String[result.size()]); // .to Array method converts the results to an array list and return the results
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        if (array == null || array.length == 0) {
            //checks whether the inout array is empty or null
            // and if it is it retruns and empty array
            return new String[0];
        }

        ArrayList<String> result = new ArrayList<String>();
        StringBuilder sb = new StringBuilder();
        sb.append(array[0]);
        // empty array will hold the the not copied elements in a array list
        // // first element in input array is added to the array list and string builder  using .add method

        for (int i = 1; i < array.length; i++) { //for loop tp to see if current element= previous element
            if (array[i].equals(array[i-1])) {
                sb.append(array[i]);// appended to the string builder
            } else {
                result.add(sb.toString());// if different string builder is added to the result and a new sb is
                                            // initialized with current element
                sb = new StringBuilder();
                sb.append(array[i]);
            }
        }

        result.add(sb.toString()); // sb added to array list

        return result.toArray(new String[result.size()]); // converted to array and returned
    }


}



