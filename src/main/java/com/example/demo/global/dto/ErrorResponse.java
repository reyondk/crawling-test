package com.example.demo.global.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.validation.BindingResult;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.example.demo.global.code.ErrorCode;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class ErrorResponse implements ApiResponse {

	@ApiModelProperty(notes = "HTTP 상태코드")
	private int status;

	@ApiModelProperty(notes = "오류코드")
	private String code;

	@ApiModelProperty(notes = "오류메세지")
	private String message;

	@ApiModelProperty(notes = "필드에러")
	private List<FieldError> errors;

	public ErrorResponse(ErrorCode code) {
		this.status = code.getStatus();
		this.code = code.getCode();
		this.message = code.getMessage();
		this.errors = new ArrayList<>();
	}

	public ErrorResponse(ErrorCode code, BindingResult bindingResult) {
		this.status = code.getStatus();
		this.code = code.getCode();
		this.message = code.getMessage();
		this.errors = FieldError.newFieldErrors(bindingResult);
	}

	public ErrorResponse(ErrorCode code, MethodArgumentTypeMismatchException e) {
		String value = e.getValue() == null ? "" : e.getValue().toString();
		this.status = code.getStatus();
		this.code = code.getCode();
		this.message = code.getMessage();
		this.errors = FieldError.newFieldErrors(e.getName(), value, e.getErrorCode());
	}

	public ErrorResponse(ErrorCode code, ConstraintViolationException e) {
		this.status = code.getStatus();
		this.code = code.getCode();
		this.message = code.getMessage();
		this.errors = FieldError.newFieldErrors(e);
	}
	
	@Getter
	@AllArgsConstructor
	public static class FieldError {
		
		@ApiModelProperty(notes = "필드명")
		private String field;

		@ApiModelProperty(notes = "값")
		private String value;

		@ApiModelProperty(notes = "사유")
		private String reason;
		
		public static List<FieldError> newFieldErrors(String field, String value, String reason) {
			List<FieldError> fieldErrors = new ArrayList<>();
			fieldErrors.add(new FieldError(field, value, reason));
			return fieldErrors;
		}
		
		public static List<FieldError> newFieldErrors(ConstraintViolationException e) {
			List<FieldError> fieldErrors = e.getConstraintViolations()
				.stream()
				.map(i -> new FieldError(
					i.getPropertyPath() == null ? "" : i.getPropertyPath().toString(),
					String.valueOf(i.getInvalidValue()),
					i.getMessage()))
				.collect(Collectors.toList());
			return fieldErrors;
		}

		private static List<FieldError> newFieldErrors(BindingResult bindingResult) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors()
				.stream()
				.map(i -> new FieldError(
					i.getField(),
					i.getRejectedValue() == null ? "" : i.getRejectedValue().toString(),
					i.getDefaultMessage()))
				.collect(Collectors.toList());
			return fieldErrors;
		}
		
		@Override
		public String toString() {
	        return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE)
	        	.toString();
	    }
	}

	@Override
	public String toString() {
        return new ReflectionToStringBuilder(this, ToStringStyle.JSON_STYLE)
        	.toString();
    }

}
