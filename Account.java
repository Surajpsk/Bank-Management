package Projects;

public class Account {
    private int accNumber;
    private double accBalance;
    private String accName;
    
    public Account()
    {
        
    }

    public Account(String accName , int accNumber , double accBalance)
    {
      setAccountName(accName);
      setAccountNumber(accNumber);
      setAccountBalance(accBalance);
    }
    
    public String getAccountName()
    {
        return accName;
    } 
    
    public int getAccountNumber()
    {
        return accNumber;
    }

    public double getAccouuntBalance()
    {
        return accBalance;
    }

    public boolean setAccountName(String accName)
    { 
        if(isValidAccName(accName))
            {
                this.accName=accName;
                return true;
            }
        else
            return false;    
    }
    
    public boolean setAccountNumber(int accNumber)
    {
        if(isValidAccNumber(accNumber))
       { 
           this.accNumber=accNumber;
           return true;
       }
       else
           return  false;
    }

    public boolean setAccountBalance(double accBalance)
    {
        if(isValidAccBalance(accBalance))
          {
             this.accBalance=accBalance;
             return true;
          }
          else
             return false;

    }

    public boolean isValidAccName(String acName) {
        if (acName.length() > 4)
        {
            for (int i = 0; i < acName.length(); i++)
            {
                char c = acName.charAt(i);
                if (!((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z') || (c == '-') || (c == '\'') || (c == ' '))) {
                    return false;
                }

            }
            return true;
        }
        else
            return false;
    }

    public  boolean  isValidAccNumber(int acNumber)
    {
        if(acNumber >=1000 && acNumber <= 999999999)
            return true;
        else
            return false;
    }

    public boolean isValidAccBalance(double accBalance)
    {
        double precision = accBalance * 100 - (int) (accBalance * 100);
        if( precision == 0.00 || precision == 0.01 || precision == 0.99)
            return true;
        else
            return false ;
    }


     public boolean equals(Account obj1 , Account obj2)
     {
        if((obj1.accName.equals(obj2.accName))&&(obj1.accNumber==obj2.accNumber)&&(obj1.accBalance==obj2.accBalance))
          {
            return true;
          }
         
          return false;

     }
    
   @ Override
    public String toString()
    {
        return ("Account Name :"+ accName +"\nAccount Number :"+accNumber+"\nAccount Balance :"+accBalance);
    }
}


