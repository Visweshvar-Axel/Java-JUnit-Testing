package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;

import com.in28minutes.data.api.TodoService;

public class TodoBusinessImplMockitoTest {

	@Test
	public void usingMockito() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
	
	@Test
	public void usingMockito_UsingBDD() {
		TodoService todoService = mock(TodoService.class);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		//given
		given(todoService.retrieveTodos("Ranga")).willReturn(allTodos);

		//when
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");

		//then
		assertThat(todos.size(), is(2));
	}

	@Test
	public void letsTestDeleteNow() {
		//given
		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("viswa")).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		//when
		todoBusinessImpl.deleteTodoNotRelatedToSpring("viswa");
		//verify
		verify(todoService).deleteTodo("Learn to Dance");

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring MVC");
//		then(todoService).should().deleteTodo("Learn Spring MVC");//BDD syntax

		verify(todoService, Mockito.never()).deleteTodo("Learn Spring");
//		then(todoService).should(never()).deleteTodo("Learn Spring");
		
		verify(todoService, Mockito.times(1)).deleteTodo("Learn to Dance");
//		then(todoService).should(never()).deleteTodo("Learn to Dance");

		// atLeastOnce, atLeast

	}
	@Test
	public void letsTestDeleteNow_usingBDD_CatptureArgument() {
		
		//Declare Argument captor
		ArgumentCaptor<String> strArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//define Argument captor on specific call
		//capture the argument
		
		//given
		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("viswa")).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		//when
		todoBusinessImpl.deleteTodoNotRelatedToSpring("viswa");
		//verify
		then(todoService).should().deleteTodo(strArgumentCaptor.capture());
		assertThat(strArgumentCaptor.getValue(), is("Learn to Dance"));

	}
	@Test
	public void letsTestDeleteNow_usingBDD_CatptureArgument_multipleTimes() {
		
		//Declare Argument captor
		ArgumentCaptor<String> strArgumentCaptor = ArgumentCaptor.forClass(String.class);
		
		//define Argument captor on specific call
		//capture the argument
		
		//given
		TodoService todoService = mock(TodoService.class);

		List<String> allTodos = Arrays.asList("Learn MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("viswa")).thenReturn(allTodos);

		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		//when
		todoBusinessImpl.deleteTodoNotRelatedToSpring("viswa");
		//verify
		then(todoService).should(times(2)).deleteTodo(strArgumentCaptor.capture());
		assertThat(strArgumentCaptor.getAllValues().size(), is(2));

	}
}