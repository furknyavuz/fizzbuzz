package com.furknyavuz.fizzbuzz.controller;

import static com.furknyavuz.fizzbuzz.controller.GameController.BUZZ_STRING;
import static com.furknyavuz.fizzbuzz.controller.GameController.FIZZ_STRING;
import static org.junit.Assert.assertEquals;

import com.furknyavuz.fizzbuzz.model.ResultModel;
import org.junit.Test;

public class GameControllerTests
{

	@Test
	public void testNullParam ()
	{
		GameController gameController = new GameController();

		ResultModel resultModel = gameController.gameSubmit(null);

		assertEquals("At least one number needed!", resultModel.getErrorMessage());
	}

	@Test
	public void testEmptyParam ()
	{
		String inputItem = "";

		GameController gameController = new GameController();

		ResultModel resultModel = gameController.gameSubmit(inputItem);

		assertEquals("At least one number needed!", resultModel.getErrorMessage());
	}

	@Test
	public void testIllegalParam ()
	{
		String inputItem = "illegal 1 2 3 4";

		GameController gameController = new GameController();

		ResultModel resultModel = gameController.gameSubmit(inputItem);

		assertEquals("All items in the input should be number!", resultModel.getErrorMessage());
	}

	@Test
	public void testFizz ()
	{
		String inputItem = "3 -3 6";

		GameController gameController = new GameController();

		ResultModel resultModel = gameController.gameSubmit(inputItem);

		assertEquals(3, resultModel.getResultItems().size());
		assertEquals(FIZZ_STRING, resultModel.getResultItems().get(0));
		assertEquals(FIZZ_STRING, resultModel.getResultItems().get(1));
		assertEquals(FIZZ_STRING, resultModel.getResultItems().get(2));
	}

	@Test
	public void testBuzz ()
	{
		String inputItem = "5 -5 10";

		GameController gameController = new GameController();

		ResultModel resultModel = gameController.gameSubmit(inputItem);

		assertEquals(3, resultModel.getResultItems().size());
		assertEquals(BUZZ_STRING, resultModel.getResultItems().get(0));
		assertEquals(BUZZ_STRING, resultModel.getResultItems().get(1));
		assertEquals(BUZZ_STRING, resultModel.getResultItems().get(2));
	}

	@Test
	public void testFizzBuzz ()
	{
		String inputItem = "15 -15 30";

		GameController gameController = new GameController();

		ResultModel resultModel = gameController.gameSubmit(inputItem);

		assertEquals(3, resultModel.getResultItems().size());
		assertEquals(FIZZ_STRING + " " + BUZZ_STRING, resultModel.getResultItems().get(0));
		assertEquals(FIZZ_STRING + " " + BUZZ_STRING, resultModel.getResultItems().get(1));
		assertEquals(FIZZ_STRING + " " + BUZZ_STRING, resultModel.getResultItems().get(2));
	}

	@Test
	public void testNonFizzOrBuzz ()
	{
		String inputItem = "1 2 4";

		GameController gameController = new GameController();

		ResultModel resultModel = gameController.gameSubmit(inputItem);

		assertEquals(3, resultModel.getResultItems().size());
		assertEquals("1", resultModel.getResultItems().get(0));
		assertEquals("2", resultModel.getResultItems().get(1));
		assertEquals("4", resultModel.getResultItems().get(2));
	}
}
