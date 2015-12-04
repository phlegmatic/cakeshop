package src.com.vkkm.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*Test class to try out stuff*/
public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		/*StringBuffer s=new StringBuffer("C:$Users$devsan$workspace$.metadata$.plugins$org.eclipse.wst.server.core$tmp2$wtpwebapps$CakeShopPortal$images");
		//I want C:\Users\devsan\workspace\CakeShopPortal\WebContent\images
		System.out.println(s.indexOf("."));
		System.out.println(s.indexOf("webapps"));
		//System.out.println(s.substring(26,88));
		//System.out.println(s.substring(s.indexOf("."), s.indexOf("webapps")));
		//System.out.println(s.replace(s.substring(s.indexOf(".")-1, s.indexOf("webapps")+7),""));
		System.out.println(s.replace(s.indexOf("."), s.indexOf("webapps")+8,""));
		System.out.println(s.replace(s.indexOf("$images"),s.indexOf("$images")+8, "$WebContent$images"));*/

		List<String> str = new ArrayList<String>();

		str.add("4");
		str.add("6");
		str.add("8");



		str.add("1");
		str.add("2");
		str.add("3");

		Map<String, List <String>> productMap = new HashMap<String, List<String>>();

		productMap.put("pastry",str );
		//productMap.put("cake",str2 );


		for (String a: productMap.keySet()){
			System.out.print(a);
			for(String val:str){
				System.out.println(val);//System.out.println(productMap.get(a).get(index));
			}
		}



	}

}
