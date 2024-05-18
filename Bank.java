package Projects;

import java.util.ArrayList;

public class Bank  extends Account
{

    private String bankName ;
    private  ArrayList <Account>accounts;

    public Bank()
    {

    }

    public Bank(String bankName )
    {
       if(setBankName(bankName))
       {
        this.accounts =new ArrayList<>();
       }
       else
       {
        System.out.println("INVALID BANK NAME ");
         System.exit(0);
       }
    }
    
    public String getBankName()
    {
        return bankName;
    }

    public boolean setBankName(String bankName)
    {
        if(isValidBankName(bankName))
        {
            this.bankName=bankName;
            return true;
        }
         
        return false;
    }

    public Account getAccountByNumber(int accNumber)
    {
        for(int i=0;i<accounts.size();i++)
        {
            Account acc = accounts.get(i);
            if(acc.getAccountNumber()==accNumber)
            {
                return acc;
            }
        }
        
        return new Account();
    }

    public boolean addAccount(Account acc)
    {  
        for(int i=0;i<accounts.size();i++)
        {
            Account acc1 = accounts.get(i);
            if(acc1.getAccountNumber()==acc.getAccountNumber())
            {
                return false;
            }

        }
        accounts.add(acc);
        return true;
      
    } 

    public Account viewAccount(int accNumber)
    { 
      return getAccountByNumber(accNumber);
    }
     
    public boolean modifyAccount(int accNumber, String newName ,double newBalance)
    {
        Account acc =getAccountByNumber(accNumber);
        if(acc.getAccountName()==null&&acc.getAccountNumber()==0)
        {
            System.out.println("ACCOUNT NOT FOUND ");
            return false;
        }
        else
        {
         return (acc.setAccountName(newName)&&acc.setAccountBalance(newBalance));
        }
    }

    public boolean deleteAccountByNum(int accNumber)
    {
        for(int i=0;i<accounts.size();i++)
        {
            Account acc = accounts.get(i);
            if(acc.getAccountNumber()==accNumber)
            {
               accounts.remove(i);
                return true;
            }
            
        }

        return false;
    }


    public  boolean isValidBankName(String bankName) {
        if (bankName.length() > 7)
        {
            for (int i = 0; i < bankName.length(); i++)
            {
                char c = bankName.charAt(i);
                if (!((c >= 'a'&&c <= 'z')||(c >= 'A' && c <= 'Z')||(c == '-')||(c == '\'')||(c==' ')||(c=='&')))
                {
                    return false;
                }

            }
            return true;
        }
        else
            return false;

    }
   
  
}
