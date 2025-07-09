package javaPrograms;


public class InvoiceItem_Demo {
	
	private String invoiceId;
    private String invoiceDesc;
    private int invoiceQty;
    private double invoiceItemPrice;
    
    
    public InvoiceItem_Demo(String invId, String invDesc, int invqty, double invPrice) {
        this.invoiceId = invId;
        this.invoiceDesc = invDesc;
        this.invoiceQty = invqty;
        this.invoiceItemPrice = invPrice;
    }
    
	public String getInvoiceId() {
		return invoiceId;
	}

	public void setInvoiceId(String invoiceId) {
		this.invoiceId = invoiceId;
	}

	public String getInvoiceDesc() {
		return invoiceDesc;
	}

	public void setInvoiceDesc(String invoiceDesc) {
		this.invoiceDesc = invoiceDesc;
	}

	public int getInvoiceQty() {
		return invoiceQty;
	}

	public void setInvoiceQty(int invoiceQty) {
		this.invoiceQty = invoiceQty;
	}

	public double getInvoiceItemPrice() {
		return invoiceItemPrice;
	}

	public void setInvoiceItemPrice(double invoiceItemPrice) {
		this.invoiceItemPrice = invoiceItemPrice;
	}


    public void invoiceTotalAmount() {
        if (invoiceQty == 1) {
            System.out.println("Total Price is : ₹" + invoiceItemPrice);
        } else if (invoiceQty > 1) {
            double billAmount = invoiceQty * invoiceItemPrice;
            System.out.println("Total Price is : ₹" + billAmount);
        } else {
            System.out.println("Enter valid invoice quantity.");
        }
    }

    public static void main(String[] args) {
        InvoiceItem_Demo item = new InvoiceItem_Demo("Inv012", "Lenova Laptop", 25, 150000.00);
        item.invoiceTotalAmount();
    }
}
