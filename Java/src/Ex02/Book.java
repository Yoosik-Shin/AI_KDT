package Ex02;

public class Book {

	int isbn;
	String title;
	String writer;
	String content;
	int price;
	
	
	public Book() {
		super();
	}
	

	public Book(int isbn, int price) {
		super();
		this.isbn = isbn;
		this.price = price;
	}
	
	
	public Book(String title, String writer, String content) {
		super();
		this.title = title;
		this.writer = writer;
		this.content = content;
	}


	public Book(int isbn, String title, String writer, String content, int price) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.content = content;
		this.price = price;
	}


	public int getIsbn() {
		return isbn;
	}


	public void setIsbn(int isbn) {
		this.isbn = isbn;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getWriter() {
		return writer;
	}


	public void setWriter(String writer) {
		this.writer = writer;
	}


	public String getContent() {
		return content;
	}


	public void setContent(String content) {
		this.content = content;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	@Override
	public String toString() {
		return " " + isbn + "\s|" + title + "| " + writer + "\s|\s" + content + "\t|\s" + price;
	}

	
	
	
}
