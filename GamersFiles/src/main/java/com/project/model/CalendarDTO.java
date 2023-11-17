package com.project.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@AllArgsConstructor
@NoArgsConstructor
@Getter
@ToString
public class CalendarDTO {
	private int a_num;
	private int g_num;
	@NonNull private String c_start;
	@NonNull private String c_end;
	@NonNull private String c_content;
	private String a_date;
}
