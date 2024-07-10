package com.in28minutes.business;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;
import org.mockito.runners.MockitoJUnitRunner;

import com.in28minutes.data.api.TodoService;

//@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {
	
	@Rule
	public MockitoRule mockitoRule = MockitoJUnit.rule();
	
	@Mock
	TodoService todoService;
	
	@InjectMocks
	TodoBusinessImpl todoBusinessImpl;
	
	@Captor
	ArgumentCaptor<String> strArgumentCaptor;
	
	@Test
	public void usingMockito() {
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
	
	@Test
	public void usingMockito_UsingBDD() {
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
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("viswa")).thenReturn(allTodos);

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
		//define Argument captor on specific call
		//capture the argument
		
		//given

		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("viswa")).thenReturn(allTodos);

		//when
		todoBusinessImpl.deleteTodoNotRelatedToSpring("viswa");
		//verify
		then(todoService).should().deleteTodo(strArgumentCaptor.capture());
		assertThat(strArgumentCaptor.getValue(), is("Learn to Dance"));

	}
	@Test
	public void letsTestDeleteNow_usingBDD_CatptureArgument_multipleTimes() {
		
		//Declare Argument captor		
		//define Argument captor on specific call
		//capture the argument
		
		//given

		List<String> allTodos = Arrays.asList("Learn MVC",
				"Learn Spring", "Learn to Dance");

		when(todoService.retrieveTodos("viswa")).thenReturn(allTodos);

		//when
		todoBusinessImpl.deleteTodoNotRelatedToSpring("viswa");
		//verify
		then(todoService).should(times(2)).deleteTodo(strArgumentCaptor.capture());
		assertThat(strArgumentCaptor.getAllValues().size(), is(2));

	}
}