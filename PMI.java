import java.io.*;
class PMI
    {
      void main()throws IOException
        {
           String word1="",word2="";
           int c1=0,c2=0,c3=0,i,j;
           double c4,c5,c6,c7,result,pmi,n=33719.0;
           System.out.print("Enter the two words:\n");
           BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
           System.out.print("Enter the 1st word:\n");
           word1=br.readLine();
           System.out.print("Enter the 2nd word:\n");
           word2=br.readLine();
           try
                {
                   FileInputStream fin=new FileInputStream("movie.txt");
                   char ch;String w="";
                   i=fin.read();
                   while((char)i!='#')
                      {
                         ch=(char)i;
                         if(ch!=' ' && ch!='.' && ch!=',' && ch!='\r' && ch!='\n' && ch!='"' && ch!=';' && ch!=':' && ch!='(' && ch!=')')
                            {
                             w+=ch;   
                              }
                          else
                            {
                              if(word1.compareTo(w)==0)
                                {
                                  c1++;  
                                  }
                                 w=""; 
                               }
                           i=fin.read();    
                        }
                    fin.close();    
                }catch(Exception e){System.out.println(e);};
            try
                {
                   FileInputStream fin=new FileInputStream("movie.txt");
                   char ch;String w="";
                   i=fin.read();
                   while((char)i!='#')
                      {
                         ch=(char)i;
                         if(ch!=' ' && ch!='.' && ch!=',' && ch!='\r' && ch!='\n' && ch!='"' && ch!=';' && ch!=':' && ch!='(' && ch!=')')
                            {
                             w+=ch;   
                              }
                          else
                            {
                              if(word2.compareTo(w)==0)
                                {
                                  c2++;  
                                  }
                                 w=""; 
                               }
                           i=fin.read();    
                        }
                   fin.close();     
                }catch(Exception e){System.out.println(e);};
                 try
                {
                   FileInputStream fin=new FileInputStream("movie.txt");
                   char ch;String w1="",w2="";
                   i=fin.read();
                   while((char)i!='#')
                      {
                         ch=(char)i;
                         if(ch!=' ' && ch!='.' && ch!=',' && ch!='\r' && ch!='\n' && ch!='"' && ch!=';' && ch!=':' && ch!='(' && ch!=')')
                            {
                             w1+=ch;   
                              }
                          else
                            {
                              if(word1.compareTo(w1)==0)
                                {
                                    j=fin.read();
                                    do
                                    {
                                    ch=(char)j;
                                    if(ch!=' ' && ch!='.' && ch!=',')
                                        {
                                          w2+=ch;  
                                        }
                                       j=fin.read(); 
                                    }while((char)j!=' ' && (char)j!=',' && (char)j!='.');
                                    if(word2.compareTo(w2)==0)
                                                {
                                                    c3++;
                                                }
                                                w2="";
                                  }
                               w1="";   
                               }
                           i=fin.read();    
                        } 
                  fin.close();      
                }catch(Exception e){System.out.println(e);};
                //System.out.println(c1);
                //System.out.println(c2);
                //System.out.println(c3);
                c4=(double)(c1/n);
                c5=(double)(c2/n);
                c6=(double)(c4*c5);
                c7=(double)(c3/n);
                result=(double)(c7/c6);
                pmi=Math.log(result);
                System.out.println("The resultant pmi="+pmi);
         }
    }