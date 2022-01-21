package br.com.lovebook.report;

public class GlobalReport {
	
	private Integer stockBook;
	private Integer readerQuantity;
	
	public GlobalReport(Integer stockBook, Integer readerQuantity) {
		this.stockBook = stockBook;
		this.readerQuantity = readerQuantity;
	}
	
	public Integer getStockBook() {
		return stockBook;
	}
	public void setStockBook(Integer stockBook) {
		this.stockBook = stockBook;
	}
	public Integer getReaderQuantity() {
		return readerQuantity;
	}
	public void setReaderQuantity(Integer readerQuantity) {
		this.readerQuantity = readerQuantity;
	}
}
