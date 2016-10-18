import com.apress.isf.java.service.Login

/**
 * @author Felipe Gutierrez
 *
 */
class GroovyLoginService implements Login {

	String username
	String password
	
	boolean isAuthorized(String email, String pass) {
		if(username==email && password==pass)
			return true
		return false
	}

}
