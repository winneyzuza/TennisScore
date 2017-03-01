
package com.tennis.tennisapp;


import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import javax.swing.JOptionPane;
import org.json.simple.JSONObject;

/**
 *
 * @author Thammarat P. 02 March 2017
 */
public class Tennis {
    
    public static String removeDuplicates(String input){
        String result = "";
        for (int i = 0; i < input.length(); i++) {
            if(!result.contains(String.valueOf(input.charAt(i)))) {
                result += String.valueOf(input.charAt(i));
            }
        }
        return result;
    }


    public static void main(String[] args) {
        JOptionPane.showMessageDialog(null, "WelCome Tennis Club by Thammarat P.");
        String fileName = JOptionPane.showInputDialog("Where are your tennis scoring location, such as  D:\\tennis.txt");
        
        String FILENAME = fileName;
        
        try (BufferedReader br = new BufferedReader(new FileReader(FILENAME))) {
               
            JSONObject scoreRule = new JSONObject();
            
            scoreRule.put(1,"15");
            scoreRule.put(2,"30");
            scoreRule.put(3,"40");
            scoreRule.put(4,"WIN");
           
            
                String sScoreLine;
                
                List<ScoreData> list = new ArrayList<ScoreData>();
                
                while ((sScoreLine = br.readLine()) != null) {
                    int i = 0; 
                    ScoreData s = new ScoreData();
                    s.setGame(sScoreLine.split(":")[0]);
                    s.setScore(sScoreLine.split(":")[1].replaceAll(" ", ""));
                    list.add(i, s);
                       
                    i++;
                }
                Collections.sort(list, ScoreData.ScoreNoComparator);
                int countA = 0;
                int countB = 0;
                
                
                //String SecondStr = String.valueOf(removeDuplicates(list.get(1).getScore()).charAt(1));
                
                System.out.println("- - - - - - - - - - -");
                for(ScoreData sd:list) {
                    String firstStr = removeDuplicates(String.valueOf(sd.getScore().charAt(0)));
                    System.out.println(sd.getGame());
                    System.out.println("- - - - - - - - - - -");
                    
                    for(int i = 0 ; i < sd.getScore().length(); i++){
                       
                        String str = String.valueOf(sd.getScore().charAt(i)) ;
                        if(countB >= 3 && countA >= 3){ // Duce
                        
                            if(Math.abs(countA - countB)<1)
                                System.out.println("DUCE");

                          
                            if(str.equals(firstStr)){
                                countA++;
                                System.out.println(str + ": " +  "ADV");
                            }else{
                                countB++;
                                System.out.println(str + ": " +  "ADV");
                            }
                                
                            if(Math.abs(countA - countB)==2)
                                System.out.println(str + ": " +  "WIN");
                        }else{
                            if(str.equals(firstStr)){
                                countA++;
                                System.out.println(str + ": " +  scoreRule.get(countA).toString());
                                
                            }else{
                                countB++;
                                System.out.println(str + ": " +  scoreRule.get(countB).toString());
                            }
                        }
                    }
                    countA = 0;
                    countB = 0;
                    System.out.println("- - - - - - - - - - -");
                }
        } catch (Exception e) {
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "Opp ! Something went wrong try again");
                return;
        }
    }
}
