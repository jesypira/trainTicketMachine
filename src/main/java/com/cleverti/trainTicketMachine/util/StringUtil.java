package com.cleverti.trainTicketMachine.util;

import org.springframework.stereotype.Component;

@Component
public class StringUtil {

    public static char[] formatToCharArray(String string){
        return string.toUpperCase().toCharArray();
    }

    /**
     * Boyer Moore Algorithm for Pattern Searching
     * @param stationSearched
     * @param stationName
     * @return
     */
    public static int compare(char[] stationSearched, char[] stationName){
            int stationSearchedSize = stationSearched.length;
            int stationNameSize = stationName.length;

            int i = 0, j;

            while ((i + stationSearchedSize) <= stationNameSize) {
                j = stationSearchedSize - 1;
                while (stationName[i + j] == stationSearched[j]) {
                    j--;
                    if (j < 0){
                        return i;
                    }
                }
                i++;
            }
            return -1;
    }
 }
