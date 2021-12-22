package com.example.demo.crawling.dto.response;

import java.io.Serializable;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.example.demo.crawling.dto.CrawlingResponse;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PrintResponse implements Serializable, CrawlingResponse {

	private static final long serialVersionUID = 1L;

	@ApiModelProperty(notes = "몫", required = true)
	private String quotient;

	@ApiModelProperty(notes = "나머지", required = true)
	private String remainder;

	@Override
	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE)
        	.toString();
    }

}
