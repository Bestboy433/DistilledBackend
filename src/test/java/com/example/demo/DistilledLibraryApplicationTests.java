package com.example.demo;

import com.example.demo.library.Author;
import com.example.demo.library.AuthorRepository;
import com.example.demo.library.Book;
import com.example.demo.library.BookRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;



@SpringBootTest
@AutoConfigureMockMvc
class DistilledLibraryApplicationTests {

	@Autowired
	private MockMvc mvc;

	//Need to test features:
	//1. Add Book
	private BookRepository book;
	private AuthorRepository author;
	Author a1 = new Author("Arthur");
	Book t1 = new Book(2637L,"Father Christmas", List.of(a1));
	@Test
	public Boolean tryAddBook() throws Exception {
		int before = book.findAll().size();
		this.mvc.perform(post("api/v1/library/addBook",t1));
		int after = book.findAll().size();
		if(before == after + 1) return true;
		else return false;

	}

	//2. Add Authors
	Author a2 = new Author("Michael");

	@Test
	public Boolean tryAddAuthor() throws Exception {
		int before = author.findAll().size();
		this.mvc.perform(post("api/v1/library/addAuthor",a2));
		int after = author.findAll().size();
		if(before == after + 1) return true;
		else return false;

	}

	//3. Update Book Status
	@Test
	public Boolean tryUpdateBook() throws Exception {
		this.mvc.perform(post("api/v1/library/addBook",t1));
		this.mvc.perform(put("api/v1/library/updateStatus",t1));
		if(book.findBookByIsbn(t1.getIsbn()).get(0).getStatus().matches("Borrowed")) return true;
		else return false;
	}
	//4. Search Books in all 3 ways

	//First by ISBN
	@Test
	public void trySearchIsbn() throws Exception {
		this.mvc.perform(post("api/v1/library/addBook",t1));
		this.mvc.perform(get("api/v1/library/book/isbn="+t1.getIsbn())).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(t1.getTitle())));
	}
	//Second by Title
	@Test
	public void trySearchTitle() throws Exception {
		this.mvc.perform(post("api/v1/library/addBook",t1));
		this.mvc.perform(get("api/v1/library/book/title="+t1.getTitle())).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(t1.getTitle())));
	}
	//Third by Author
	@Test
	public void trySearchAuthor() throws Exception {
		this.mvc.perform(post("api/v1/library/addBook",t1));
		this.mvc.perform(get("api/v1/library/book/author="+t1.getAuthors().get(0).getName())).andDo(print()).andExpect(status().isOk()).andExpect(content().string(containsString(t1.getTitle())));
	}

	//5. Register a borrow of a book
	@Test
	void contextLoads() {
	}


}
