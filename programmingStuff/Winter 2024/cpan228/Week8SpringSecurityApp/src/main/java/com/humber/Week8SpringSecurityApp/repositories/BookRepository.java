package com.humber.Week8SpringSecurityApp.repositories;

import com.humber.Week8SpringSecurityApp.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    //public List<Book> findByCategoryAndPrice(String category, Double price);

    @Query(value = "select * from Book where lower(category)=lower(?1) and price=?2",nativeQuery = true)
    public List<Book> findByCategoryAndPrice(String category, Double price);
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