package Cucumber_Resources;

import java.util.ArrayList;
import java.util.List;

import Pojo_Classes.Add_Place_Pojo;
import Pojo_Classes.Location1;

public class Test_Data {

	public Add_Place_Pojo getMeTestDataPayload(String name,String address,String language) {
		 Add_Place_Pojo ap = new Add_Place_Pojo();
		 ap.setAccuracy(50);
		 ap.setName(name);
		 ap.setPhone_number("(+91) 983 893 3937");
		 ap.setAddress(address);
		 ap.setWebsite("http://google.com");
		 ap.setLanguage(language);
		 List<String> StringList = new ArrayList<>();
		 StringList.add("shoe park");
        StringList.add("shop");
        ap.setTypes(StringList);
        Location1 l = new Location1();
        l.setLat(-38.383494);
        l.setLng(33.427362);
        ap.setLocation(l);
        return ap;
	}
	public String deletePayload(String place_id) {
       return "{\r\n"
       		+ "    \"place_id\":\""+place_id+"\"\r\n"
       		+ "}";
	}
}
