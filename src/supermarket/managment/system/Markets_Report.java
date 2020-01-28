/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package supermarket.managment.system;

/**
 *
 * @author Ahmed
 */
public class Markets_Report {
    private String Date1;
    private String Report;
    

    public Markets_Report(String Date1, String Report) {
        this.Date1 = Date1;
        this.Report = Report;
    }

    /**
     *
     * @param Date1
     * @param offer
     */
   
  

   
  

    public String getDate1() {
        return Date1;
    }

    public void setDate1(String Date1) {
        this.Date1 = Date1;
    }

    public String getReport() {
        return Report;
    }

    public void setReport(String Report) {
        this.Report = Report;
    }
    
    
    
}
