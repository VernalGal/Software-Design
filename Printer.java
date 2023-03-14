package edu.cuny.csi.csc330.lab4;
import java.util.Date;
import edu.cuny.csi.csc330.util.Randomizer;

public class Printer 
{
	protected static final int MIN_SPEED = 0;
	protected static final int MAX_SPEED = 40;
	protected static final int DEFAULT_SPEED = 20;
	protected static final int MIN_PRINTING_AMOUNT = 0;
	protected static final int MAX_PRINTING_AMOUNT = 300;
	protected static final int MIN_PRINTER_CAPACITY = 0;
	protected static final int MAX_PRINTER_CAPACITY = 600;
	protected static final int MIN_INK = 0;
	protected static final int MAX_INK = 60;
	
	
	private int select_printing_limit;
	private int select_printing_speed;
	private int paper_amount;
	private int num_inkcolor;
	private int printer_capacity; 
	private String[] select_inkcolor = new String[] {"Color", "Black & White"};
	private String paper_layout_style;
	private boolean staple_1;
	private boolean power_state;
	private String serial_number;
	private Date first_time_on;
	private Date last_time_on;
	private boolean staple;
	
	
	private void init() 
	{
		Integer range_nums = Randomizer.generateInt(00000000, 99999999);
		this.serial_number = new Date().getTime() + ":" + range_nums.toString();	
	}
	
	
	private void on()
	{
		Date current = new Date();
		if(first_time_on == null)
		{
			staple_1 = false;
			select_printing_limit = MIN_PRINTING_AMOUNT;
			select_printing_speed = DEFAULT_SPEED;
			first_time_on = current;
			num_inkcolor = MIN_INK;
			paper_layout_style = "Portrait";
			paper_amount = 0;
		}
		
		power_state = true;
		last_time_on = current;
		
	}
	
	
	public void off()
	{
		power_state = false;
	}
	
	public boolean staple()
	{
		return staple();
	}
	
	public Date catchfirst_time_on()
	{
		return first_time_on;
	}
	
	public String getPaperLayoutFrom() 
	{
        return paper_layout_style;
	}
	
	public int getInkColorNum() 
	{
        return num_inkcolor;
	}
	
	public void setstaple(boolean staple) 
	{
        this.staple_1 = staple;
        if (staple==true)
        	paper_layout_style = "Landscape";
        else
        	paper_layout_style = "Portrait";   
	}
	
	public boolean changedstaple() 
	{
        staple = !staple;
        if (staple==true)
        	paper_layout_style = "Landscape";
        else
        	paper_layout_style = "Portrait";   
        return staple;
	}
	
	
	public void setPaperLayoutFrom(String paperLayoutFrom) 
	{
        this.paper_layout_style = paperLayoutFrom;
	}
	
	
	
	public int getAmountofPaper() 
	{
        return paper_amount;
	}
	
	public String getChosenInkColor() 
	{
        return select_inkcolor[num_inkcolor];
	}
	
	public void setSelectedPrintSpeed(int select_printing_speed) 
	{
        this.select_printing_speed = select_printing_speed;
	}
 
	public void setNumInkColor(int inkColorNum) 
	{
        this.num_inkcolor = inkColorNum;
	}
	
	
	public int changedInkColorNum() 
	{
        return num_inkcolor = Randomizer.generateInt(MIN_INK, MAX_INK);
	}
	
	
	public int AddingPaperToPrinter()
	{
        if(paper_amount==0)
        	paper_amount = Randomizer.generateInt(MIN_PRINTER_CAPACITY, printer_capacity);
        return paper_amount;
	}
 

	public void setAmountofPaper(int containedPaperAmount ) 
	{
        this.paper_amount  = containedPaperAmount;
	}
  
	public int getPrinterSpeed() 
	{
        return select_printing_speed;
	}
 
	public int getLimitofPrinting() 
	{
        return select_printing_limit;
	}
	
	public void decreasePrintSpeed(int Speed) 
	{
        if((select_printing_speed-Speed)>=MIN_SPEED)
        {
             this.select_printing_speed -= Speed;
        }
        else
             System.err.println("It over the minimun printing speed.\n");
	}
 
	public void increasePrintSpeed(int Speed) 
  	{
	  	if(select_printing_speed<(MAX_PRINTING_AMOUNT-Speed))
        {
             this.select_printing_speed += Speed;
        }
        else
             System.err.println("It over the maximun printing speed.\n");
  	}
  
	
	public void setSelectedPrintingLimit(int selectedPrintingLimit) 
	{
        this.select_printing_limit = selectedPrintingLimit;
	}
  
	public void lowerLimitOnPrinting(int page) 
	{
        if (select_printing_limit > 10 && select_printing_limit > page)
        {
             this.select_printing_limit -= page;
        }
        else {
             System.err.println("It over the minimun printing limit.\n");
        }
	}
  
	
	public void higherLimitOnPrinting(int page) 
	{
        if((select_printing_limit + page)< MAX_PRINTING_AMOUNT)
        {
             this.select_printing_limit += page;
        }
        else
        {
             System.err.println("It over the maximun printing limit.\n");
        }
	}
 @Override
  
 	public String toString() 
 	{
	 return "Printer Instance: " + "[SerialNumber = " + serial_number + ", Printer Capacity = "+printer_capacity
             + ", powerState = " + power_state +",\n staple = "+ staple_1
             + ", paperLayoutForm = "+ paper_layout_style + ", selectedInkColor = "+ select_inkcolor [num_inkcolor]
             +", inkColor = " + num_inkcolor + ",\n containedPaperAmount = " + paper_amount
             +  ", selectedPrintSpeed = " + select_printing_speed + ", selectedPrintingLimit = "+ select_printing_limit
             + "\n firstTimeOn = " + first_time_on + ", lastTimeOn = " + last_time_on + "]\n";
 	}
  
 	
 	public static void main(String[] args) 
 	{
     
        Printer printer = new Printer();
        System.out.println("New Instance\n" + printer + "\n");
     
        printer.on();
        System.out.println("Turned On\n" + printer + "\n");
       
        //printer.decreasePrintSpeed(5);
        System.out.println("Changed the Station\n" + printer + "\n");
     
        //printer.changedstaple();
        System.out.println("Changed to Landscape\n" + printer + "\n");
       
        //printer.changedInkColorNum();
        System.out.println("Changed the ink color\n" + printer + "\n");

        //printer.addPaperToPrinter();
        System.out.println("Added paper \n" + printer + "\n");

        //printer.increasePrintingLimit(10);
        System.out.println("Changed the  printing limit \n" + printer + "\n");
       
        printer.off();
        System.out.println("Turned Off\n" + printer + "\n");
 	}
}
	
	
	
	
	
	
	
	
	
	
	
	
	

