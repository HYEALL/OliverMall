package service;

import dto.UsersDTO;

public interface Join {
	public String join(UsersDTO dto);
	public String cancel(UsersDTO dto);
}
