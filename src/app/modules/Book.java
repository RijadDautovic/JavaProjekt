/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.modules;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Rijad
 */
@Entity
@Table(name = "book")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Book.findAll", query = "SELECT b FROM Book b")
    , @NamedQuery(name = "Book.findById", query = "SELECT b FROM Book b WHERE b.id = :id")
    , @NamedQuery(name = "Book.findByBookName", query = "SELECT b FROM Book b WHERE b.bookName = :bookName")
    , @NamedQuery(name = "Book.findByBookAuthor", query = "SELECT b FROM Book b WHERE b.bookAuthor = :bookAuthor")
    , @NamedQuery(name = "Book.findByBookPublisher", query = "SELECT b FROM Book b WHERE b.bookPublisher = :bookPublisher")
    , @NamedQuery(name = "Book.findByBookPdflink", query = "SELECT b FROM Book b WHERE b.bookPdflink = :bookPdflink")
    , @NamedQuery(name = "Book.findByPublisherID", query = "SELECT b FROM Book b WHERE b.publisherID = :publisherID")})
public class Book implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @Column(name = "book_Name")
    private String bookName;
    @Basic(optional = false)
    @Column(name = "book_Author")
    private String bookAuthor;
    @Basic(optional = false)
    @Column(name = "book_Publisher")
    private String bookPublisher;
    @Basic(optional = false)
    @Column(name = "book_pdflink")
    private String bookPdflink;
    @Basic(optional = false)
    @Column(name = "publisherID")
    private int publisherID;
    @JoinColumn(name = "userID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private User userID;

    public Book() {
    }

    public Book(Integer id) {
        this.id = id;
    }

    public Book(Integer id, String bookName, String bookAuthor, String bookPublisher, String bookPdflink, int publisherID) {
        this.id = id;
        this.bookName = bookName;
        this.bookAuthor = bookAuthor;
        this.bookPublisher = bookPublisher;
        this.bookPdflink = bookPdflink;
        this.publisherID = publisherID;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        this.bookName = bookName;
    }

    public String getBookAuthor() {
        return bookAuthor;
    }

    public void setBookAuthor(String bookAuthor) {
        this.bookAuthor = bookAuthor;
    }

    public String getBookPublisher() {
        return bookPublisher;
    }

    public void setBookPublisher(String bookPublisher) {
        this.bookPublisher = bookPublisher;
    }

    public String getBookPdflink() {
        return bookPdflink;
    }

    public void setBookPdflink(String bookPdflink) {
        this.bookPdflink = bookPdflink;
    }

    public int getPublisherID() {
        return publisherID;
    }

    public void setPublisherID(int publisherID) {
        this.publisherID = publisherID;
    }

    public User getUserID() {
        return userID;
    }

    public void setUserID(User userID) {
        this.userID = userID;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Book)) {
            return false;
        }
        Book other = (Book) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "app.modules.Book[ id=" + id + " ]";
    }
    
}
