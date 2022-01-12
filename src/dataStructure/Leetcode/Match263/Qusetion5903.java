package dataStructure.Leetcode.Match263;

public class Qusetion5903 {
	long[] balance;
	int n;
	public Qusetion5903(long[] balance) {
		this.balance=balance;
		n=balance.length;
    }
    
    public boolean transfer(int account1, int account2, long money) {
    	if(account1>n || account2>n) return false;
    	if(balance[account1-1]<money) return false;
    	
    	balance[account1-1]-=money;
    	balance[account2-1]+=money;
    	return true;
    }
    
    public boolean deposit(int account, long money) {
    	if(account>n) return false;
    	balance[account-1]+=money;
    	return true;
    }
    
    public boolean withdraw(int account, long money) {
    	if(account>n) return false;
    	if(balance[account-1]<money) return false;
    	
    	balance[account-1]-=money;
    	return true;
    }
}
