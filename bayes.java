import java.io.*;
class bayes
    {
    public static void main(String args[])throws IOException
        {
         int i,j,len;
         double pos=0.6,neg=0.4;
         char ch;
         String s="",w="";  
         String[] str=new String[5];
         String[] word=new String[11];
         double [] prob_pos={0.0,0.0833,0.0833,0.0833,0.2083,0.125,0.125,0.0833,0.125,0.0417,0.0417};
         double []prob_neg={0.0,0.125,0.125,0.125,0.125,0.125,0.125,0.0625,0.0625,0.0625,0.0625};   
         BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
         //System.out.println("Enter the string lists:");
         str[0]="I loved the movie.";
         str[1]="I hated the movie.";
         str[2]="a great movie.good movie.";
         str[3]="poor acting.";
         str[4]="great acting.a good movie.";
         //System.out.println("The string lists:");
          /*for(i=0;i<5;i++)
        {
          System.out.println(str[i]);  
            }*/
          word[0]=null;
          word[1]="I";
          word[2]="loved";
          word[3]="the";
          word[4]="movie";
          word[5]="hated";
          word[6]="a";
          word[7]="great";
          word[8]="poor";
          word[9]="acting";
          word[10]="good";
         // System.out.println("The words lists:");   
          /*for(i=0;i<10;i++)
        {
          System.out.println(word[i]);  
            }*/
          System.out.println("Enter the review:");
          s=br.readLine();
          System.out.println("The review:"+s);
          len=s.length();           
          //Calculating positive outcomes
          for(i=0;i<len;i++)
           {
             ch=s.charAt(i);
                        
             
             if(ch==' ' || ch=='.' || ch==',' || ch==';')
                {
                    for(j=1;j<=10;j++)
                  {
                        if((w.compareTo(word[j]))==0)
                     {
                       pos=pos*prob_pos[j];
                               System.out.println(pos);                         
                        }
                    }
                 w="";          
                }
            else
              w+=ch;
            }
               //Calculating negative outcomes
            w="";
        for(i=0;i<len;i++)
           {
             ch=s.charAt(i);
                 
                
             if(ch==' ' || ch=='.' || ch==',' || ch==';' )
              {
                    for(j=1;j<=10;j++)
                  {
                        if((w.compareTo(word[j]))==0)
                     {
                       neg=neg*prob_neg[j];
                       System.out.println(neg);                                 
                        }
                    }
                 w="";          
                }
                else
                w+=ch;
            }
           System.out.println("The +ve and -ve values:"+pos+"and"+neg);
          //if(pos>neg)
            //System.out.println("The review is +ve.");
              //else
            //System.out.println("The review is -ve.");                     
        }
     } 
