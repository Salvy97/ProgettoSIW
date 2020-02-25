package persistence.dao;

import java.util.List;
import model.Notifica;

public interface NotificaDAO 
{
	public void save(Notifica notifica);
	public void delete(Notifica notifica);
	public List<Notifica> findNotificheByUsername(String username);
}