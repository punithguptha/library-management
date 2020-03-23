package sample;

import java.time.LocalDate;
import java.util.Date;

public class IssueBooks {
    int userid,bookid,issueid,period,fine;
    LocalDate issuedate,returndate;
    IssueBooks(int issueid,int userid,int bookid,LocalDate issuedate,int period,LocalDate returndate,int fine){
        this.issueid=issueid;
        this.userid=userid;
        this.bookid=bookid;
        this.period=period;
        this.fine=fine;
        this.issuedate=issuedate;
        this.returndate=returndate;
    }

    public int getBookid() {
        return bookid;
    }

    public int getFine() {
        return fine;
    }

    public int getIssueid() {
        return issueid;
    }

    public int getPeriod() {
        return period;
    }

    public int getUserid() {
        return userid;
    }

    public LocalDate getIssuedate() {
        return issuedate;
    }

    public LocalDate getReturndate() {
        return returndate;
    }

    public void setBookid(int bookid) {
        this.bookid = bookid;
    }

    public void setFine(int fine) {
        this.fine = fine;
    }

    public void setIssuedate(LocalDate issuedate) {
        this.issuedate = issuedate;
    }

    public void setIssueid(int issueid) {
        this.issueid = issueid;
    }

    public void setPeriod(int period) {
        this.period = period;
    }

    public void setReturndate(LocalDate returndate) {
        this.returndate = returndate;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

}
