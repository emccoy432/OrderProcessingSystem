/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package order.processing.system;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gilberto
 */
public class OrderProcessingSystem {

    /**
     * @param args the command line arguments
     */
  
    public static void  main(String[] args)  {
        // TODO code application logic here
     InteractionCntl ILCntl = new InteractionCntl(); 
  
      //Comment this line in to get our interface. 
      //  ILCntl.welcomeProtocol();
        
       //I used CustomerListCntl and then InteractionCntl as a bucket for the ILC this way both customers can access the same list
      Thread Thread1 = new CustomerListCntl(ILCntl.getILC());
      Thread Thread2 = new CustomerListCntl(ILCntl.getILC());
     
      
        Thread1.start();
       
        try {
            Thread1.join(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(OrderProcessingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
         Thread2.start();
       Thread.yield();
      
      /*Old INCORRECT THREADING, I'm keeping it around in case it becomes useful.  
       ILCntl.getILC().initInvList();
       ILCntl.getILC().displayInvList();
       
       Thread Thread1 = new Customer(ILCntl.getILC());
       Thread Thread2 = new Customer(ILCntl.getILC());
     
       
        System.out.println("The Order Processing System Presents...");
        System.out.println("****************************************");
        System.out.println("*********THREAD***HANDLING**************");
        System.out.println("****************************************");
        
        
       Thread1.start();
        try {
            Thread1.join(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(OrderProcessingSystem.class.getName()).log(Level.SEVERE, null, ex);
        }
       Thread2.start();
       Thread.yield();
       
    */
       
       }
    
    
}
