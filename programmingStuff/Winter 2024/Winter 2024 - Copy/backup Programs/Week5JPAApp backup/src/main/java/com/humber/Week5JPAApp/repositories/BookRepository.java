package com.humber.Week5JPAApp.repositories;

import com.humber.Week5JPAApp.models.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {

}
/*public class BookRepository {
    @Autowired
    JdbcTemplate template;
    //save book to database
    public int save(Book book){
        String sql="INSERT INTO book (name,category,price) VALUES(?,?,?)";
        return template.update(sql,book.getName(),book.getCategory(),book.getPrice());
    }
    //retrieve all books from database
    public List<Book> findAll(){
        String sql="SELECT * FROM book";

        RowMapper<Book> mapper= new RowMapper<Book>() {
            @Override
            public Book mapRow(ResultSet rs, int rowNum) throws SQLException {
                Book myBook=new Book();
                myBook.setId(rs.getInt(1));
                myBook.setName(rs.getString(2));
                myBook.setCategory(rs.getString(3));
                myBook.setPrice(rs.getDouble(4));
                return myBook;
            }
        };
        List<Book>books=template.query(sql,mapper);
        return books;
    }

}
*/