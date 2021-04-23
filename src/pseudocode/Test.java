package pseudocode;

public class Test {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String [] recepients =new String[]{"c0785472@mylambton.ca"};
		String [] bccRecepients =new String[]{"c0785472@mylambton.ca"};
		String subject ="Check from CCBT";
		String message ="this is a test mail";
		
		new SendEmail().sendMail(recepients, bccRecepients, subject, message);
		
//		String s =  "form-data; name=file; filename=Java.pdf";
//		String[] s2 = s.split("filename=");
//		
////		System.out.println(s2);
//		System.out.println(s2[1]);
//		for (String i:s2) {
//			System.out.println(i);
//		}
	}

}
