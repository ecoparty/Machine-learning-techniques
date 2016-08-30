import java.io.*;
import java.lang.Math;


import java.util.*;
public class abc
{
 public static void main(String[] args)throws IOException
 {
 try
  {
  int x1=0,x2=0,y1=0,y2=0;
  int i=0,n=100;
  int [] points=new int[100];
  
  for(i=0;i<100;i++)
  {
   points[i]=i;
  }
  
  int d=0;
  x1=12;
  x2=32;
  y1=62;
  y2=86;
  vector g=new vector();
 
  d=g.KM(points,x1,x2,y1,y2,100);
  
  double m1=0,m2=0,c1=0,c2=0,cx=0,cy=0;
  m1=(double)((g.y2-g.y1)/(g.x2-g.x1));
  m2=(double)(1/m1);
  m2=-m2;
  cx=(g.x1+g.x2)/2;
  cy=(g.y1+g.y2)/2;
  c2=cy-(m2*cx);
  System.out.println("The equation of the line is"+"Y="+m2+"X"+"+"+c2);
  }
  catch (ArrayIndexOutOfBoundsException e) {
         System.out.println
         ("Error�. Array is out of Bounds"+e);
      }
      catch (ArithmeticException e) {
         System.out.println 
         ("Can't be divided by Zero"+e);
      }
 }
 }
 class vector
 {
 int x1,x2,y1,y2,n;
 int totgroup1x=0,totgroup1y=0,totgroup2x=0,totgroup2y=0;
  int avggroup1x=0,avggroup1y=0,avggroup2x=0,avggroup2y=0;
  int[] d1;
  int[] d2; 
  int d=0;
  int k,l;
 public int KM(int[] x,int x1,int x2,int y1,int y2,int n)
  {
  int i=0;
  k=1;
  l=1;
  d1=new int[n];
  d2=new int[n];
  int[] group1x=new int[n];
  int[] group1y=new int[n];
  int[] group2x=new int[n];
  int[] group2y=new int[n];
  
  
  int[] y=new int[n];
  
  
  for(i=0;i<n;i++)
  {
   y[i]=n-x[i];
  }
   
   
  for(i=0;i<n;i++)
  {
   d1[i]=Math.abs(x1-x[i])+Math.abs(y1-y[i]);//euclidean distance calculation from point 1
   d2[i]=Math.abs(x2-x[i])+Math.abs(y2-y[i]);//euclidean distance calculation from point 2
  }
  
  for(i=0;i<n;i++)//separating the coordinates into group1 and group2
  {
   if(d1[i]>d2[i])
   {
    group2x[k]=x[i];
    group2y[k]=x[i];
    k++; 
   }
   else if(d1[i]<d2[i])
   {
    group1x[l]=x[i];
    group1y[l]=y[i];
    l++;
   }
  }
  for(i=0;i<l;i++)
  {
   totgroup1x=totgroup1x+group1x[i];
   totgroup1y=totgroup1y+group1y[i];
  } 
  for(i=0;i<k;i++)
  {
   totgroup2x=totgroup2x+group2x[i];
   totgroup2y=totgroup2y+group2y[i];
  } 
  avggroup1x=totgroup1x/l;
  avggroup1x=totgroup1y/l;
  avggroup2x=totgroup2x/k;
  avggroup2y=totgroup2y/k;
  
  if(avggroup1x!=x1||avggroup1y!=y1||avggroup2x!=x2||avggroup2y!=y2)
  {
   d=KM(x,avggroup1x,avggroup2x,avggroup1y,avggroup2y,n);
  }
  else
  {
   x1=avggroup1x;
   x2=avggroup2x;
   y1=avggroup1y;
   y2=avggroup2y;
   return 1;
  } 
  return 0;
  
  }  
 
}

