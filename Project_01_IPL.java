import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class CSVReader {

    public static void main(String[] args) {
        CSVReader obj = new CSVReader();

        String csvFile = "/home/rocky/Android/matches.csv";
        String line = "";
        String cvsSplitBy = ",";
        int count = 0;
        int season[] = new int[637];
        String winner[] = new String[637];
        int year_Count = 0;

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {

            while ((line = br.readLine()) != null) {

                // use comma as separator
                String[] data = line.split(cvsSplitBy);
                count++;
                if (count > 1) {
                    season[count - 2] = Integer.parseInt(data[1]);
                    winner[count - 2] = data[10];
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        int year[]=season.clone();
        String win[]=winner.clone();

        //1. Function Call
        obj.year_Count_Of_Matches(year, season.length); //Function Call to Count the matches done in each years//

        //2. Function Call
        obj.matches_Won_Count_Yearly(year,win,year.length-1);//Function call to count Won Team in yearly level//

        //3. Function Call

    }

    void year_Count_Of_Matches(int season[], int n) {
        //-------------------------------------------------------------------//
        //Code for Number of matches played per year of all the years in IPL-//
        //-------------------------------------------------------------------//
        System.out.println("Number of matches played per year of all the years in IPL");
        int j = 0;
        int year_Count = 0;
        Arrays.sort(season);
        for (int i = 1; i < n; i = j) {
            for (j = i; j < n; j++) {
                if (season[i] != season[j]) {
                    break;
                }
                year_Count++;
            }
            System.out.println(season[i] + " total matches = " + year_Count);
            year_Count = 0;
        }
    }

    void matches_Won_Count_Yearly(int year[],String winner[],int n)
    {
        //-----------------------------------------------------------------//
        //Code for Number of Matches won of all teams Yearly---------------//
        //-----------------------------------------------------------------//
        String mergeString[]=new String[n];
        int temp,j;
        String strTemp;

        //Merging integer data with string
        for(int i=0;i<n;i++)
        {
            mergeString[i]=year[i]+" "+winner[i];
        }

        //Sort mergeString in ascending order
        for (int i = 0; i < n; i++) {
            for (j = 1; j < (n - i); j++) {
                if (mergeString[j - 1].compareTo( mergeString[j] ) > 0) {
                    strTemp = mergeString[j - 1];
                    mergeString[j - 1] = mergeString[j];
                    mergeString[j] = strTemp;
                }

            }
        }

        //Count the number of winner yearly
        int win_Count=0;
        for(int i=0;i<n;i=j)
        {
            win_Count=0;
            for(j=i;j<n;j++)
            {
                if (mergeString[i].compareTo(mergeString[j]) != 0) {
                    break;
                }
                win_Count++;

            }
            System.out.println("In "+mergeString[i]+" won "+win_Count+" times");
        }

    }
    

}