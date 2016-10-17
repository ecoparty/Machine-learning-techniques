import java.io.*;
class project {
public static void main(String [] args)throws IOException
    {
       int avgpos=0,avgneg=0,countpos=0,countneg=0,sumpos=0,sumneg=0;
       int i,j;
       int []p=new int[100];
       int score=0;
       String str="",w="";int l=0,x=0;char ch;
       String [] array=new String[] {"a", "about", "above", "above", "across", "after", "afterwards", "again", "against", "all", "almost",     "alone", "along", "already", "also","although","always","am","among", "amongst", "amoungst", "amount",  "an", "and", "another", "any","anyhow","anyone","anything","anyway", "anywhere", "are", "around", "as",  "at", "back","be","became", "because","become","becomes", "becoming", "been", "before", "beforehand", "behind", "being", "below", "beside", "besides", "between", "beyond", "bill", "both", "bottom","but", "by", "call", "can", "cannot", "cant", "co", "con", "could", "couldnt", "cry", "de", "describe", "detail", "do", "done", "down", "due", "during", "each", "eg", "eight", "either", "eleven","else", "elsewhere", "empty", "enough", "etc", "even", "ever", "every", "everyone", "everything", "everywhere", "except", "few", "fifteen", "fify", "fill", "find", "fire", "first", "five", "for", "former", "formerly", "forty", "found", "four", "from", "front", "full", "further", "get", "give", "go", "had", "has", "hasnt", "have", "he", "hence", "her", "here", "hereafter", "hereby", "herein", "hereupon", "hers", "herself", "him", "himself", "his", "how", "however", "hundred", "ie", "if", "in", "inc", "indeed", "interest", "into", "is", "it", "its", "itself", "keep", "last", "latter", "latterly", "least", "less", "ltd", "made", "many", "may", "me", "meanwhile", "might", "mill", "mine", "more", "moreover", "most", "mostly", "move", "much", "must", "my", "myself", "name", "namely", "neither", "never", "nevertheless", "next", "nine", "no", "nobody", "none", "noone", "nor", "not", "nothing", "now", "nowhere", "of", "off", "often", "on", "once", "one", "only", "onto", "or", "other", "others", "otherwise", "our", "ours", "ourselves", "out", "over", "own","part", "per", "perhaps", "please", "put", "rather", "re", "same", "see", "seem", "seemed", "seeming", "seems", "serious", "several", "she", "should", "show", "side", "since", "sincere", "six", "sixty", "so", "some", "somehow", "someone", "something", "sometime", "sometimes", "somewhere", "still", "such", "system", "take", "ten", "than", "that", "the", "their", "them", "themselves", "then", "thence", "there", "thereafter", "thereby", "therefore", "therein", "thereupon", "these", "they", "thickv", "thin", "third", "this", "those", "though", "three", "through", "throughout", "thru", "thus", "to", "together", "too", "top", "toward", "towards", "twelve", "twenty", "two", "un", "under", "until", "up", "upon", "us", "very", "via", "was", "we", "well", "were", "what", "whatever", "when", "whence", "whenever", "where", "whereafter", "whereas", "whereby", "wherein", "whereupon", "wherever", "whether", "which", "while", "whither", "who", "whoever", "whole", "whom", "whose", "why", "will", "with", "within", "without", "would", "yet", "you", "your", "yours", "yourself", "yourselves", "the"};
       BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
       System.out.println("Enter the review:");
       str=br.readLine();
       System.out.println("The review is:"+str);
       //System.out.println("The list of stopwords:");
       /*for(i=0;i<array.length;i++
        {
          System.out.println(array[i]);
         }*/
	  for(String stopWord : array){
                str = str.replaceAll(" "+ stopWord + " ", " ");
             }
          System.out.println("The final review without stopwords:"+str);
	  for (i = 0; i < str.length(); i++) 
            {	
	        ch=str.charAt(i);  	
                if (ch==' ' || ch=='.' || ch==',' || ch==';' || ch==':') 
                {
                    l++;
                } 
            }
	  System.out.println(l+1);
	  String [] words=new String[l+1];int [] freq=new int[l+1];
	  for(i=0;i<(l+1);i++)
		words[i]="";
	  for(i=0;i<(l+1);i++)
		freq[i]=0;
	  for(i=0;i<str.length();i++)
		{
		  ch=str.charAt(i);
		  if(ch!=' ' && ch!='.' && ch!=',' && ch!=';' && ch!=':')
		     {   
			words[x]+=ch;
				}
	                else
				{
				  x++;
					}
			}
	 //for(i=0;i<(x);i++)
	  //System.out.println(words[i]);	
	 for(i=0;i<(x);i++)
		{
		  //System.out.println(words[i]);
		  w=words[i];
		  for(j=0;j<(x);j++)
			  {
			    if(words[j]==w)
				freq[i]++;
				}   
			}
	 for(i=0;i<(x);i++)
		{
		  System.out.println("Frequency of "+words[i]+" is "+freq[i]);
			}
	for(int k=0;k<(x);k++)
	{
		try{  
        FileInputStream fin=new FileInputStream("positive.txt");  
        i=fin.read();
	w="";  
        while((char)i!='.'){
         if((char)i!=' ' && (char)i!=',')
	    {
	      w+=(char)i;		
		}
	else if((char)i==' ')
	     {
	       if(w.compareTo(words[k])==0)
			{
                          
			  i=fin.read();
			  p[k]=i;
			  score=score+i;
                          countpos++;
			  sumpos=sumpos+i;
			  System.out.print(w+" "+(char)i);
		          System.out.println();	
			}
                           	
                        
			
		else
		   {
		     i=fin.read();
		     if((char)i=='1')
			{
			  i=fin.read();
				}	
			}		
		}
         else
	    w="";
         i=fin.read();			  
        // System.out.print((char)i);  
        }  
        fin.close();  
      }catch(Exception e){System.out.println(e);}
       try{  
        FileInputStream fout=new FileInputStream("neg.txt");  
        i=fout.read();
	w="";  
        while((char)i!='.'){
         if((char)i!=' ' && (char)i!=',')
	    {
	      w+=(char)i;		
		}
	else if((char)i==' ')
	     {
	       if(w.compareTo(words[k])==0)
			{
                                  countneg++;
				  i=fout.read();
				  p[k]=i;
				  score=score+i;
                                  sumneg=sumneg+i;				
				  System.out.print(w+" "+(char)i);
				  System.out.println();	
			}
		else
		   {
		     i=fout.read();
		     if((char)i=='1')
			{
			  i=fout.read();
				}	
			}		
		}
         else
	    w="";
         i=fout.read();			  
        // System.out.print((char)i);  
        }  
        fout.close();  
      }catch(Exception e){System.out.println(e);}		 
     }	 			   
   double g=0;
   g=(Math.log(p[0])/Math.log(score));
   System.out.println(g);
   
  System.out.println(score);
}
}
