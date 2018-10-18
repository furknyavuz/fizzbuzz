package com.furknyavuz.fizzbuzz.controller;

import com.furknyavuz.fizzbuzz.model.ResultModel;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Furkan Yavuz on 18.10.2018.
 */
@RestController
public class GameController
{
	private static final int FIZZ = 3;

	private static final int BUZZ = 5;

	public static final String FIZZ_STRING = "Fizz";

	public static final String BUZZ_STRING = "Buzz";

	@GetMapping ( "/submit" )
	public ResultModel gameSubmit (@RequestParam ( name = "input" ) String inputItem)
	{
		// ResultModel can contain error message or result items list
		ResultModel resultModel;

		try
		{
			// Pre validation
			if (StringUtils.isEmpty(inputItem))
			{
				throw new IllegalArgumentException();
			}

			// Split string input into list
			List<String> splitInputs = new ArrayList<>();
			Collections.addAll(splitInputs, inputItem.split("\\s+"));

			List<String> resultItems = new ArrayList<>();

			for (String item : splitInputs)
			{
				String result = fizzbuzzCheck(item);
				resultItems.add(result);
			}

			resultModel = new ResultModel(resultItems);
		}
		catch (NumberFormatException ex)
		{
			resultModel = new ResultModel("All items in the input should be number!");
		}
		catch (IllegalArgumentException ex)
		{
			resultModel = new ResultModel("At least one number needed!");
		}

		return resultModel;
	}

	private String fizzbuzzCheck (String item)
	{
		// Agorithm: % of the number should be 0 in order to change result into fizz, buzz or fizz buzz

		int number = Integer.parseInt(item);

		String result;

		if (number % (FIZZ * BUZZ) == 0)
		{
			result = FIZZ_STRING + " " + BUZZ_STRING;
		}
		else if (number % FIZZ == 0)
		{
			result = FIZZ_STRING;
		}
		else if (number % BUZZ == 0)
		{
			result = BUZZ_STRING;
		}
		else
		{
			result = String.valueOf(number);
		}
		return result;
	}
}
