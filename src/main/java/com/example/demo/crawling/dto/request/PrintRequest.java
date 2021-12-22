package com.example.demo.crawling.dto.request;

import java.io.Serializable;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.hibernate.validator.constraints.URL;

import com.example.demo.crawling.dto.CrawlingRequest;
import com.example.demo.global.code.CrawlingType;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class PrintRequest implements Serializable, CrawlingRequest {
	
	private static final long serialVersionUID = 1L;

	@URL
	@NotNull
	@ApiModelProperty(notes = "URL", required = true, example = "http://www.wemakeprice.com")
	private String url;

	@NotNull
	@ApiModelProperty(notes = "Type", required = true, example = "HTML_IGNORE")
	private CrawlingType type;
	
	@Min(0)
	@Max(999999999)
	@ApiModelProperty(notes = "출력 단위 묶음", required = true, example = "100")
	private long bundle;
    
	@Override
	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE)
        	.toString();
    }
	
}
