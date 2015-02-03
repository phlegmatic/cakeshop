package src.com.vkkm.controller;

public class test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		StringBuffer s=new StringBuffer("C:$Users$devsan$workspace$.metadata$.plugins$org.eclipse.wst.server.core$tmp2$wtpwebapps$CakeShopPortal$images");
		//I want C:\Users\devsan\workspace\CakeShopPortal\WebContent\images
		System.out.println(s.indexOf("."));
		System.out.println(s.indexOf("webapps"));
		//System.out.println(s.substring(26,88));
		//System.out.println(s.substring(s.indexOf("."), s.indexOf("webapps")));
		//System.out.println(s.replace(s.substring(s.indexOf(".")-1, s.indexOf("webapps")+7),""));
		System.out.println(s.replace(s.indexOf("."), s.indexOf("webapps")+8,""));
		System.out.println(s.replace(s.indexOf("$images"),s.indexOf("$images")+8, "$WebContent$images"));
		
	}

}
