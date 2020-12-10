package mysql.database.com.register;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class RegisterController {

	@Autowired
	RegisterService registerServiceObject = new RegisterService();
	
	
	@RequestMapping(method = RequestMethod.GET,value = "/authentication/register")
	public List<RegisterModel> get_allRegistrationPage() {
		return registerServiceObject.show_allRegisteration();
	}
	
	@RequestMapping(method = RequestMethod.GET,value = "/authentication/register/{id}")
	public Optional<RegisterModel> get_oneRegistrationPage(@PathVariable String id) {
		return registerServiceObject.show_oneRegisteration(id);
	}
	
	
	@RequestMapping(method = RequestMethod.POST,value = "/authentication/register")
	public void postRegistrationPage(@RequestBody RegisterModel obj) {
		registerServiceObject.newRegisteration(obj);
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/authentication/register/{id}")
	public void putRegistrationPage(@RequestBody RegisterModel obj,@PathVariable String id) {
		registerServiceObject.updateRegisteration(obj,id);
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/authentication/register/{id}")
	public void deleteRegistrationPage(@PathVariable String id) {
		registerServiceObject.deleteRegisteration(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/authentication/qrCodeGenerator")
	public void qrCodeGenerator(@RequestBody RegisterModel obj) {
//		registerServiceObject.qrCodeGenerator(obj);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/authentication/smallqrcodetext")
	public void smallqrcodetext() {
		registerServiceObject.smallqrcodetext();
	}
}
