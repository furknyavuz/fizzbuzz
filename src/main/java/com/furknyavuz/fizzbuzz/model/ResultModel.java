package com.furknyavuz.fizzbuzz.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

/**
 * Created by Furkan Yavuz on 18.10.2018.
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultModel
{
	private List<String> resultItems;

	private String errorMessage;

	public ResultModel (String errorMessage)
	{
		this.errorMessage = errorMessage;
	}

	public ResultModel (List<String> resultItems)
	{
		this.resultItems = resultItems;
	}
}
