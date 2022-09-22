package co.mall.prj.common;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Command {
	//HashMap의 value = command
	String exec(HttpServletRequest request, HttpServletResponse response);
}
