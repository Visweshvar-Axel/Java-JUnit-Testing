package business;

import static org.junit.Assert.assertEquals;

import java.util.List;

import api.TodoService;
import org.junit.Test;
import stub.TodoServiceStub;


public class TodoBusinessImplStubTest {

	@Test
	public void usingAStub() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
	@Test
	public void usingAStub_dummy() {
		TodoService todoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Dummy");
		assertEquals("Learn Spring MVC , Learn Spring", todos.get(0)+" , "+todos.get(1));
	}
}