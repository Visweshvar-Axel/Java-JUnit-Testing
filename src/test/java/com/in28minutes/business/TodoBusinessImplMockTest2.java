package com.in28minutes.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.stub;

import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.stub.TodoServiceStub;

public class TodoBusinessImplMockTest2 {
//	What is mocking?
//			mocking is creating objects that simulate the behavior of real objects.
//			Unlike stubs, mocks can be dynamically created from code
//			- at runtime.
//			Mocks offer more functionality than stubbing.
//			You can verify method calls and a lot of other things.
	@Test
	public void usingAStub() {
		TodoService mockTodoService = mock(TodoService.class);
		stub(mockTodoService.retrieveTodos("parameter")).return("values");
//		TodoService mockTodoService = new TodoServiceStub();
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
}