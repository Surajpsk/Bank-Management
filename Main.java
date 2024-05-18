package Projects;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        
        Scanner sc =new Scanner(System.in);
        int accNumber;
        String accName,bankName;
        double accBalance;
         
        System.out.print("Enter Bank Name :");
        bankName=sc.nextLine();
         Bank bank =new Bank(bankName);
        while(true)
        {
            System.out.println("\n===== Menu =====");
            System.out.println("1. Add Account");
            System.out.println("2. View Account");
            System.out.println("3. Modify Account");
            System.out.println("4. Delete Account");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");

            System.out.print("Enter Choice : ");
            int choice=sc.nextInt();
        
            switch (choice) {
                case 1:
                         System.out.print("Enter Account Name :");
                           sc.nextLine();
                 if(bank.isValidAccName(accName=sc.nextLine()))
                    {
                         System.out.print("Enter Account Number :");
                     if(bank.isValidAccNumber(accNumber=sc.nextInt()))
                     { 
                            System.out.print("Enter Account Balance :");
                        if(bank.isValidAccBalance(accBalance =sc.nextDouble()))
                        {
                      
                         Account acc =new Account(accName, accNumber, accBalance) ;
                          if(bank.addAccount(acc))
                          {
                            System.out.println("ACCOUNT ADDED SUCCESSFULLY "); 
                          }
                          else
                          {
                            System.out.println("ACCOUNT ALREADY EXIST "); 
                          }
                        }
                        else
                        {
                            System.out.println("INVALID ACCOUNT BALANCE ");
                        }
                     }
                    else
                     {
                        System.out.println("INVALID ACCOUNT NUMBER");
                     }  
                  }
                  else
                  {
                        System.out.println("INVALID ACCOUNT NAME ");
                  }
                 break;
                case 2:
                      System.out.print("Enter Account Number to view Account ");
                      if(bank.isValidAccNumber(accNumber=sc.nextInt()))
                         {
                            Account acc =bank.viewAccount(accNumber);
                            if(acc.getAccountName()==null&&acc.getAccountNumber()==0)
                            {
                              System.out.println("ACCOUNT NOT FOUND");
                            }
                            else
                            System.out.println( acc.toString());
                         }
                      else
                         {
                            System.out.println("INVALID ACCOUNT NUMBER");
                         }   
                    break;
                case 3:  
                         System.out.print("Enter Account Number to Modify :");
                        if(bank.isValidAccNumber(accNumber=sc.nextInt()))
                        {   
                          System.out.print("Enter New Account Name :");
                          sc.nextLine();    
                         if(bank.isValidAccName(accName=sc.nextLine()))
                          {  
                            System.out.print("Enter New Account Balance :");
                             if (bank.isValidAccBalance(accBalance=sc.nextDouble()))
                               {
                                    if(bank.modifyAccount(accNumber,accName , accBalance))
                                    {
                                      System.out.println("ACCOUNT MODIFIED SUCCESSFULLY");
                                    }
                                    else
                                    {
                                       System.out.println("FAILED TO MODIFY ACCOUNT");
                                    }
                               }
                              else
                            {
                              System.out.println("INVALID ACCOUNT BALANCE ");

                            }
                          }
                          else
                          {
                                 System.out.println("INVALID ACCOUNT NAME ");
                          }
                        }
                        else
                        {
                          System.out.println("INVALID ACCOUNT NUMBER");
                        }
                        break ;
                case 4:
                    System.out.print("Enter Account Number to Delete Account :");
                     if(bank.isValidAccNumber(accNumber=sc.nextInt()))
                     {
                          if(bank.deleteAccountByNum(accNumber))
                          {
                            System.out.println("ACCOUNT DELETED SUCCESSFULLY");
                          }
                          else
                          {
                            System.out.println(" ACCOUNT NOT FOUND");
                          }
                     }
                     else
                     {
                       System.out.println("INVALID ACCOUNT NUMBER ");
                     }
                     break;
                case 5:
                     System.exit(0);    
                     break;         
                default:
                    System.out.println("WRONG CHOICE");
                    break;
            }
        }
    }
    

}