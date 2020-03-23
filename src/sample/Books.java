package sample;

public class Books {
    int BookId;
    String Bookname;
    String Genre;
    int price;
    Books(int BookId,String Bookname,String Genre,int price){
        this.BookId=BookId;
        this.Bookname=Bookname;
        this.Genre=Genre;
        this.price=price;
    }
    //Getter methods;
    public int getBookId(){
        return BookId;
    }
    public String getBookname(){
        return Bookname;
    }
    public String getGenre(){
        return Genre;
    }
    public int getPrice(){
        return price;
    }

    public void setBookId(int bookId) {
        BookId = bookId;
    }

    public void setBookname(String bookname) {
        Bookname = bookname;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

}
