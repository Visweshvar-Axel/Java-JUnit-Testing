package com.in28minutes.business;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockStubTest {

	@Test
	public void usingAStub() {
		TodoService mockTodoService = mock(TodoService.class);
		List<String> todo = Arrays.asList("Learn Spring MVC", "Learn Spring","Learn to Dance");
		when(mockTodoService.retrieveTodos("Dummy")).thenReturn(todo);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(mockTodoService);
		List<String> todos = todoBusinessImpl.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
}