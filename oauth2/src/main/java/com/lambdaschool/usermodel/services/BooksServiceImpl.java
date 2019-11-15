package com.lambdaschool.usermodel.services;

import com.lambdaschool.usermodel.exceptions.ResourceNotFoundException;
import com.lambdaschool.usermodel.logging.Loggable;
import com.lambdaschool.usermodel.models.Authors;
import com.lambdaschool.usermodel.models.Books;
import com.lambdaschool.usermodel.repository.AuthorsRepo;
import com.lambdaschool.usermodel.repository.BooksRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;


@Loggable
@Service(value = "booksService")
public class BooksServiceImpl implements BooksService {

    @Autowired
    BooksRespository bookRepository;
    @Autowired
    AuthorsRepo authorsRepo;

    /*@Autowired
    WroteRepo wroteRepo;*/

    @Autowired
    AuthorsService authorService;

    @Override
    public List<Books> findAll() {
        List<Books> list = new ArrayList<>();
        bookRepository.findAll()
                .iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Books update(Books books, long id) {
        Books currentBook = bookRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (books.getTitle() != null)
        {
            currentBook.setTitle(books.getTitle());
        }

        if (books.getISBN() != null)
        {
            currentBook.setISBN(books.getISBN());
        }

        if (books.getCopy() != 0)
        {
            currentBook.setCopy(books.getCopy());
        }


        return bookRepository.save(currentBook);
    }
    @Transactional
    @Override
    public Authors save(long bookid, long authorid) {

        if(bookRepository.findById(bookid).isEmpty()){
            throw new ResourceNotFoundException("not found/Book ID:" + bookid);
        }
        if(authorsRepo.findById(authorid).isEmpty()){
            throw new ResourceNotFoundException("not found/Author ID:" + authorid );
        }

        Authors author = authorsRepo.findById(authorid).get();
        Books book = bookRepository.findById(bookid).get();

        author.addAuthorBooks(book);

       // Wrote newBookAuthor = new Wrote(author,book);

        return authorsRepo.save(author);
    }
    @Override
    public void delete(long id) {
        if (bookRepository.findById(id).isPresent())
        {
            bookRepository.deleteById(id);
        }
        else
        {
            throw new ResourceNotFoundException("not found/ID: " + id );
        }
    }


   /* @Override
    public Book update(Long id, String bookTitle, String copyright, String ISBN) {
        return null;
    }*/
}

