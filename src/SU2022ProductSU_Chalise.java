//File SU2022ProductSU_Chalise.java

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;


public class SU2022ProductSU_Chalise {
	 
	   private int[] arrayUnit;
	   private float[] arrayPrice; 
	 
	   public SU2022ProductSU_Chalise() {
		  
		   arrayUnit =new int [3];
		   arrayPrice =new float [3];
	   }
	   public SU2022ProductSU_Chalise(int[] u, float[] p)
		{
		arrayUnit =u;
		arrayPrice =p;
		}
	   public void setArrayUnit(int[] u)
		{
			arrayUnit =u;
		}
	   public void setArrayPrice(float[] p)
		{
			arrayPrice =p;
		}
	   public int[] getArrayUnit()
		{
			return arrayUnit;
		}
	   public float[] getArrayPrice()
		{
			return arrayPrice;
		}
	   public String getCurrentDate()
	   {  
	       DateFormat formatter = new SimpleDateFormat("MM/dd/yyyy"); 
	       Date date = new Date();  
	       return formatter.format(date);   
	   }
	  

	   //to get the total amount
	   public void getTotal() {
		   float smallSale;
		   float mediumSale;
		   float largeSale;
		   float tax;
		   float subTotal;
		   float total;
		   
		   smallSale = arrayUnit[0]*arrayPrice[0];
		   mediumSale = arrayUnit[1]*arrayPrice[1];
		   largeSale = arrayUnit[2]*arrayPrice[2];
		   subTotal = smallSale+mediumSale+largeSale;
		   tax = subTotal/100 * 8.25f;
		   total = subTotal+tax;
		   System.out.println("Your total will be: "+total);
		   
		  
		   
	   }
	   // to print the receipt!!
	   public String  getReceipt(float amount, int transactionNum) {
		   float smallSale;
		   float mediumSale;
		   float largeSale;
		   float tax;
		   float subTotal;
		   float total;
		   float change;
		   smallSale = arrayUnit[0]*arrayPrice[0];
		   mediumSale = arrayUnit[1]*arrayPrice[1];
		   largeSale = arrayUnit[2]*arrayPrice[2];
		   subTotal = smallSale+mediumSale+largeSale;
		   tax = subTotal/100 * 8.25f;
		   total = subTotal+tax;
		   change = amount-total;
		   return "\nFile: SU2022SaleProductSu_Application_Chalise.java\n" +
		   "SU2022 Sale Product SU Receipt – Chalise\n"+
	       "Day:"+getCurrentDate() +" - "+ "Transaction #: "+String.format("%04d", transactionNum)+"\n"+
	       "-------------------------------------------\n" + 
	       "Small  "+"("+arrayPrice[0]+")\t    "+arrayUnit[0]+"\t\t"+String.format("%.2f",smallSale)+"\n"+
	       "Medium "+"("+arrayPrice[1]+")\t    "+arrayUnit[1]+"\t\t"+String.format("%.2f",mediumSale)+"\n"+
	       "Large  "+"("+arrayPrice[2]+")\t    "+arrayUnit[2]+"\t\t"+String.format("%.2f",largeSale)+"\n"+
	       "-------------------------------------------\n" +
	       
	       String.format("%-15s%24.2f\n", "Subtotal: ", subTotal)+
	       String.format("%-15s%24.2f\n", "Tax: ",tax )+
	       String.format("%-15s%24.2f\n", "Total: ", total)+
	       String.format("%-15s%24.2f\n", "Money Paid: ", amount)+
	       String.format("%-15s%24.2f\n", "Change: ", change);
	       }
	   
	   // To write the data inFile.
	   public void toFile(int transactionNum) throws IOException {
		   FileWriter sale = new FileWriter("daySale_06012022.txt",true);
		   
		   sale.append(String.format("%04d",transactionNum));
		   sale.append(" "+arrayUnit[0]+" "+arrayUnit[1]+" "+arrayUnit[2]+"\n");
		   sale.close();
		   
	   }
	   public String printReport(String finalDate) {
		   float smallSale;
		   float mediumSale;
		   float largeSale;
		   float tax;
		   float subTotal;
		   float total;
		  
		   smallSale = arrayUnit[0]*arrayPrice[0];
		   mediumSale = arrayUnit[1]*arrayPrice[1];
		   largeSale = arrayUnit[2]*arrayPrice[2];
		   subTotal = smallSale+mediumSale+largeSale;
		   tax = subTotal/100 * 8.25f;
		   total = subTotal+tax;
		   return "File: SU2022SaleProductSu_Application_Chalise.java\n" +
		   "SU2022 Sale Product SU Report – Chalise\n"+
	       "Day Report                  :"+finalDate+"\n"+
	       "-------------------------------------------\n" + 
	       "Small  "+"("+arrayPrice[0]+")\t    "+arrayUnit[0]+"\t\t"+String.format("%.2f",smallSale)+"\n"+
	       "Medium "+"("+arrayPrice[1]+")\t    "+arrayUnit[1]+"\t\t"+String.format("%.2f",mediumSale)+"\n"+
	       "Large  "+"("+arrayPrice[2]+")\t    "+arrayUnit[2]+"\t\t"+String.format("%.2f",largeSale)+"\n"+
	       "-------------------------------------------\n" +
	       
	       String.format("%-15s%24.2f\n", "Subtotal: ", subTotal)+
	       String.format("%-15s%24.2f\n", "Tax: ",tax )+
	       String.format("%-15s%24.2f\n", "Total: ", total);
		   
	   }
	   public String compareReport(int[] arrayTotalUnits1,int[] arrayTotalUnits2,float[] arrayPrice,String finalDate1,String finalDate2) {
		   float smallSale1;
		   float mediumSale1;
		   float largeSale1;
		   float tax1;
		   float subTotal1;
		   float total1;
		   
		   smallSale1 = arrayTotalUnits1[0]*arrayPrice[0];
		   mediumSale1 = arrayTotalUnits1[1]*arrayPrice[1];
		   largeSale1 = arrayTotalUnits1[2]*arrayPrice[2];
		   subTotal1 = smallSale1+mediumSale1+largeSale1;
		   tax1 = subTotal1/100 * 8.25f;
		   total1 = subTotal1+tax1;
		   
		   
		   float smallSale2;
		   float mediumSale2;
		   float largeSale2;
		   float tax2;
		   float subTotal2;
		   float total2;
		   float smallPercent;
		   float mediumPercent;
		   float largePercent;
		   
		   smallSale2 = arrayTotalUnits2[0]*arrayPrice[0];
		   mediumSale2 = arrayTotalUnits2[1]*arrayPrice[1];
		   largeSale2 = arrayTotalUnits2[2]*arrayPrice[2];
		   subTotal2 = smallSale2+mediumSale2+largeSale2;
		   tax2 = subTotal2/100 * 8.25f;
		   total2 = subTotal2+tax2;
		   
		   int smallCupDiff =Math.abs(arrayTotalUnits1[0]-arrayTotalUnits2[0]);
		   int mediumCupDiff =Math.abs(arrayTotalUnits1[1]-arrayTotalUnits2[1]);
		   int largeCupDiff =Math.abs(arrayTotalUnits1[2]-arrayTotalUnits2[2]);
		   if (smallSale1<smallSale2) {
			   smallPercent =(float) 100*smallCupDiff/arrayTotalUnits1[0];
		   }
		   else {
			   smallPercent = (float)100*smallCupDiff/arrayTotalUnits2[0];
		   }
		   if (mediumSale1<mediumSale2) {
			   mediumPercent = (float) 100*mediumCupDiff/arrayTotalUnits1[1];
		   }
		   else {
			   mediumPercent = (float)100*mediumCupDiff/arrayTotalUnits2[1];
		   }
		   if (largeSale1<largeSale2) {
			   largePercent = (float)100*largeCupDiff/arrayTotalUnits1[2];
		   }
		   else {
			   largePercent = (float)100*largeCupDiff/arrayTotalUnits2[2];
		   }
		   
		   return 
				   "\nFile: SU2022SaleProductSu_Application_Chalise.java\n" +
		   "SALE PRODUCT SU COMPARE DAYS REPORT – SAMIP CHALISE\n"+
	       "COMPARE DAYS:      :"+finalDate1+" and "+finalDate2+"\n"+
	       "--------------------------------------------------------------------------------------------\n" + 
	       "\t\t  SALE IN "+finalDate1+"\t"+"      SALE IN "+finalDate2+"   DIFFERENCE  "+"  PERCENTAGE"+"\n"+
	       "Small  "+"("+arrayPrice[0]+")\t  "+arrayTotalUnits1[0]+"\t     "+String.format("%.2f",smallSale1)+"\t      "+arrayTotalUnits2[0]+"\t "+String.format("%.2f",smallSale2)+"\t   "+smallCupDiff+"\t     "+String.format("%.2f", smallPercent)+"%"+"\n"+
	       "Medium "+"("+arrayPrice[1]+")\t  "+arrayTotalUnits1[1]+"\t     "+String.format("%.2f",mediumSale1)+"\t      "+arrayTotalUnits2[1]+"\t "+String.format("%.2f",mediumSale2)+"\t   "+mediumCupDiff+"\t     "+String.format("%.2f", mediumPercent)+"%"+"\n"+
	       "Large  "+"("+arrayPrice[2]+")\t  "+arrayTotalUnits1[2]+"\t     "+String.format("%.2f",largeSale1)+"\t      "+arrayTotalUnits2[2]+"\t "+String.format("%.2f",largeSale2)+"\t    "+largeCupDiff+"\t      "+String.format("%.2f", largePercent)+"%"+"\n"+
	       "--------------------------------------------------------------------------------------------\n" +
	       
	       String.format("%-15s%21.2f", "Subtotal: ", subTotal1)+"\t\t\t"+String.format("%.2f",subTotal2)+"\n"+
	       String.format("%-15s%21.2f", "Tax: ",tax1 )+"\t\t\t "+String.format("%.2f",tax2)+"\n"+
	       String.format("%-15s%21.2f", "Total: ", total1)+"\t\t\t"+String.format("%.2f",total2)+"\n";
		   
	   }
	   
	   
}
