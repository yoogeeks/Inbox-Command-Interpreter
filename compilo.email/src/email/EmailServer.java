package email;

import java.util.ArrayList;

public class EmailServer {
	public static ArrayList<String> blocked = new ArrayList<String>();
	public static ArrayList<String> inbox = new ArrayList<String>();
	public static ArrayList<String> outbox = new ArrayList<String>();
	public static ArrayList<String> spam = new ArrayList<String>();
	public Boolean filterIncoming(String sender){
		for(String bEmail : blocked){
			if (bEmail.equals(sender)){
				System.out.println("Email added to spam");
				spam.add(sender);
				return false;
			}
			
		}
		return true;
	}
	public Boolean filterOutgoing(String reciever){
		for(String bEmail : blocked){
			if (bEmail.equals(reciever)){
				System.out.println("Email may sent to spam");
				spam.add(reciever);
				return false;
			}			
		}
		return true;
	}
	public void addToBlockedkList(String emailToBlock){
		blocked.add(emailToBlock);
	}
	public void removeFromBlockedkList(String emailToUnblock){
		blocked.remove(emailToUnblock);
	}
	public void send(String email){
		if (filterOutgoing(email)){
			System.out.println("Email sent!");
			outbox.add(email);
		}
		
	}
	public void recieve(String email){
		if (filterIncoming(email)){
			System.out.println("New email recieved!");
			inbox.add(email);
		}
	}
	public void showInbox(){
		System.out.println("Inbox (" + inbox.size() + ")");
		for (String email: inbox){
			System.out.println(email);
		}
	}
}
