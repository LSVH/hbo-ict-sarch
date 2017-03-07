/**
 * @project Game31
 * @author LSVH, Luuk Sebastiaan Van Houdt
 * @link http://lsvh.org
 * @created 11:01
 */

package assignments.w2c2;

import java.io.*; // PrintWriter
import java.util.*; // Vector, Iterator
import java.lang.*; // String, Stringbuffer
import java.sql.*; // Connection, Date, PreparedStatement

public class Order {

    private Vector lineItemList;

    public Order(Vector lis) {
        lineItemList = lis;
    }

    public boolean equals(Object aThat) {
        if ( this == aThat ) return true;
        if ( !(aThat instanceof Order) ) return false;
        Order that = (Order)aThat;
        return this.lineItemList.equals(that.lineItemList);
    }

    // writes this order object to the specified print writer
    public void writeOrder(Order order, PrintWriter pw) {
        // get a vector of line items
        private Vector lineItems = lineItemList.getLineItems();

        // ------------------------------------------------------
        // calculate total
        // ------------------------------------------------------
        // create an iterator for the vector
        int total = swagTotal(lineItems);
        Iterator iter;
        LineItem item;
        // ------------------------------------------------------
        // END calculate total
        // ------------------------------------------------------

        // ------------------------------------------------------
        // write order
        // ------------------------------------------------------
        // create an iterator for the vector
        iter = lineItems.iterator();
        while (iter.hasNext()) {
            item = (LineItem)iter.next();

            // calculate total for line item
            int unitPrice = item.getUnitPrice();
            int qty = item.getQuantity();
            int productID = item.getProductID();
            int imageID = item.getImageId();
            int lineItemtotal = unitPrice * qty;

            pw.println("Begin Line Item");
            pw.println("Product = " + productID);
            pw.println("Image = " + imageID);
            pw.println("Quantity = " + qty);
            pw.println("Total = " + lineItemtotal);
            pw.println("End Line Item");
        }
        pw.println("Order total = " + total);
    }

    private int swagTotal(Vector lineItems) {
        private Iterator iter = lineItems.iterator();
        private LineItem item;
        // set total to zero
        int total = 0;
        while (iter.hasNext()) {
            item = (LineItem)iter.next();

            // calculate total for line item
            int unitPrice = item.getUnitPrice();
            int qty = item.getQuantity();
            int lineItemtotal = unitPrice * qty;

            total += lineItemtotal;
        }
        return total;
    }

    public int getTotal() {
        // get a vector of line items
        private Vector lineItems = lineItemList;
        // create an iterator for the vector
        private Iterator iter = lineItems.iterator();
        private LineItem item;
        // set total to zero
        int total = 0;
        while (iter.hasNext()) {
            item = (LineItem)iterator.next();

            // calculate total for line item
            int unitPrice = item.getUnitPrice();
            int qty = item.getQuantity();
            int lineItemtotal = unitPrice * qty;

            total += lineItemtotal;
        }
        return total;
    }

    /** This method saves the order to the database */
    public void saveOrder() throws SQLException {
        //create connection
        Connection conn = null;

        java.sql.Date date = new java.sql.Date((new java.util.Date()).getTime());
        PreparedStatement orderStatement = null;
        PreparedStatement getStatement = null;
        String sql = null;
        sql = new StringBuffer().append("INSERT INTO T_ORDER " )
                .append("(AUTHORIZATION_CODE, " )
                .append("SHIPMETHOD_ID, USER_ID, ADDRESS_ID) " )
                .append("VALUES ( ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)" ).toString();
        conn = setConnection();
        orderStatement = conn.prepareStatement(sql);
        //set all parameters
        //...
        //execute statement
        orderStatement.executeUpdate();
    }
}